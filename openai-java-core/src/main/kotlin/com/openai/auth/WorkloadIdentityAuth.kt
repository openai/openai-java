package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.DefaultSleeper
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.Sleeper
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.core.http.RetryingHttpClient
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ErrorObject
import java.io.FilterInputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.time.Clock
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import java.util.function.LongSupplier
import kotlin.concurrent.withLock
import kotlin.math.max
import kotlin.math.min

private const val TOKEN_EXCHANGE_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange"
private const val JWT_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:jwt"
private const val ID_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:id_token"
private const val X509_TOKEN_TYPE = "urn:openai:params:oauth:token-type:x509"
private const val DEFAULT_TOKEN_EXPIRY_SECONDS = 3600
private const val SUBJECT_TOKEN_EXCHANGE_URL = "https://auth.openai.com/oauth/token"
private const val X509_TOKEN_EXCHANGE_URL = "https://mtls.auth.openai.com/oauth/token"
private const val MAX_X509_TOKEN_RESPONSE_BYTES = 1_048_576
private val X509_BEARER_TOKEN_PATTERN = Regex("[A-Za-z0-9._~+/-]+=*")

internal class WorkloadIdentityAuth(
    internal val config: WorkloadIdentity,
    private val httpClient: HttpClient,
    private val jsonMapper: JsonMapper,
    sleeper: Sleeper? = null,
    private val clock: Clock = Clock.systemUTC(),
    private val maxRetries: Int = 2,
    private val nanoTime: LongSupplier = LongSupplier { System.nanoTime() },
) : AutoCloseable {

    constructor(
        config: WorkloadIdentity,
        httpClient: HttpClient,
        jsonMapper: JsonMapper,
    ) : this(
        config,
        httpClient,
        jsonMapper,
        null,
        Clock.systemUTC(),
        2,
        LongSupplier { System.nanoTime() },
    )

    internal val isX509 = config.isX509()
    private val ownsSleeper = isX509 && sleeper == null
    private val sleeper = sleeper ?: if (isX509) DefaultSleeper() else null
    private val tokenExchangeHttpClient =
        if (isX509) {
            RetryingHttpClient.builder()
                .httpClient(httpClient)
                .sleeper(checkNotNull(this.sleeper))
                .clock(clock)
                .maxRetries(maxRetries)
                .maxRetryAfter(Duration.ofSeconds(60))
                .build()
        } else {
            httpClient
        }
    private val errorHandler =
        errorHandler(
            object : HttpResponse.Handler<JsonField<ErrorObject>> {
                override fun handle(response: HttpResponse): JsonField<ErrorObject> {
                    val node =
                        try {
                            jsonMapper.readTree(tokenExchangeResponseBody(response))
                        } catch (e: Exception) {
                            return JsonMissing.of()
                        }

                    return try {
                        val errorCode =
                            node.get("error")?.asText()?.takeIf { it.isNotBlank() }
                                ?: return JsonMissing.of()
                        val errorMessage =
                            if (isX509) errorCode
                            else node.get("error_description")?.asText() ?: errorCode
                        JsonField.of(
                            jsonMapper.treeToValue(
                                jsonMapper.createObjectNode().apply {
                                    put("code", errorCode)
                                    put("message", errorMessage)
                                },
                                ErrorObject::class.java,
                            )
                        )
                    } catch (e: Exception) {
                        JsonMissing.of()
                    }
                }
            }
        )
    private val lock = ReentrantLock()
    private var cachedToken: CachedToken? = null
    private var refreshInFlight: CompletableFuture<CachedToken>? = null
    private var refreshSourceLease: TokenLease? = null

    private class CachedToken(
        val lease: TokenLease,
        val issuedAtNanos: Long,
        val expiresAfterNanos: Long,
        val refreshAfterNanos: Long,
    )

    private class BoundedTokenResponseBody(stream: InputStream) : FilterInputStream(stream) {

        private var remaining = MAX_X509_TOKEN_RESPONSE_BYTES

        override fun read(): Int {
            val value = super.read()
            if (value != -1 && remaining-- == 0) {
                throw IOException("Token exchange response exceeds the maximum allowed size")
            }
            return value
        }

        override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
            if (length == 0) {
                return 0
            }
            if (remaining == 0) {
                return read()
            }

            val count = super.read(buffer, offset, min(length, remaining))
            if (count > 0) {
                remaining -= count
            }
            return count
        }
    }

    internal class TokenLease internal constructor(val value: String)

    private sealed interface AsyncTokenAction {
        class ReturnCached(val token: CachedToken) : AsyncTokenAction

        class StartBackground(val refresh: CompletableFuture<CachedToken>, val token: CachedToken) :
            AsyncTokenAction

        class AwaitRefresh(val refresh: CompletableFuture<CachedToken>, val shouldStart: Boolean) :
            AsyncTokenAction
    }

    fun getToken(): String = getTokenLease().value

    internal fun getTokenLease(): TokenLease {
        var shouldRefresh = false
        val refresh =
            lock.withLock {
                val token = unexpiredCachedTokenUnsafe()
                if (token != null && !isExpiringSoonUnsafe(token)) {
                    return token.lease
                }
                if (token != null && refreshInFlight != null) {
                    return token.lease
                }

                refreshInFlight
                    ?: CompletableFuture<CachedToken>().also {
                        refreshInFlight = it
                        shouldRefresh = true
                    }
            }

        if (shouldRefresh) {
            try {
                finishRefresh(refresh, performRefresh())
            } catch (error: Throwable) {
                finishRefresh(refresh, error)
            }
        }

        return awaitRefresh(refresh).lease
    }

    fun getTokenAsync(): CompletableFuture<String> = getTokenLeaseAsync().thenApply { it.value }

    internal fun getTokenLeaseAsync(): CompletableFuture<TokenLease> {
        val action =
            lock.withLock {
                val token = unexpiredCachedTokenUnsafe()
                if (token != null) {
                    if (isExpiringSoonUnsafe(token) && refreshInFlight == null) {
                        val refresh = CompletableFuture<CachedToken>()
                        refreshInFlight = refresh
                        refreshSourceLease = token.lease
                        AsyncTokenAction.StartBackground(refresh, token)
                    } else {
                        AsyncTokenAction.ReturnCached(token)
                    }
                } else {
                    val existing = refreshInFlight
                    if (existing != null) {
                        AsyncTokenAction.AwaitRefresh(existing, false)
                    } else {
                        val refresh = CompletableFuture<CachedToken>()
                        refreshInFlight = refresh
                        AsyncTokenAction.AwaitRefresh(refresh, true)
                    }
                }
            }

        return when (action) {
            is AsyncTokenAction.ReturnCached ->
                CompletableFuture.completedFuture(action.token.lease)
            is AsyncTokenAction.StartBackground -> {
                startRefreshAsync(action.refresh)
                CompletableFuture.completedFuture(action.token.lease)
            }
            is AsyncTokenAction.AwaitRefresh -> {
                if (action.shouldStart) {
                    startRefreshAsync(action.refresh)
                }
                // Return a dependent future so canceling a waiter never cancels the shared refresh.
                action.refresh.thenApply { it.lease }
            }
        }
    }

    fun invalidateToken() = lock.withLock { cachedToken = null }

    internal fun invalidateToken(rejectedToken: TokenLease) {
        var displacedRefresh: CompletableFuture<CachedToken>? = null
        var replacementRefresh: CompletableFuture<CachedToken>? = null
        lock.withLock {
            if (cachedToken?.lease === rejectedToken) {
                cachedToken = null
                if (refreshSourceLease === rejectedToken) {
                    displacedRefresh = refreshInFlight
                    replacementRefresh = CompletableFuture()
                    refreshInFlight = replacementRefresh
                    refreshSourceLease = null
                }
            }
        }
        val replacement = replacementRefresh ?: return
        val displaced = checkNotNull(displacedRefresh)
        replacement.whenComplete { token, error ->
            if (error != null) displaced.completeExceptionally(error) else displaced.complete(token)
        }
        startRefreshAsync(replacement)
    }

    private fun unexpiredCachedTokenUnsafe(): CachedToken? {
        val token = cachedToken ?: return null
        return if (elapsedNanos(token) >= token.expiresAfterNanos) null else token
    }

    private fun isExpiringSoonUnsafe(token: CachedToken): Boolean =
        elapsedNanos(token) >= token.refreshAfterNanos

    private fun elapsedNanos(token: CachedToken): Long = nanoTime.asLong - token.issuedAtNanos

    private fun performRefresh(): CachedToken {
        val request =
            if (isX509) {
                buildX509TokenExchangeRequest()
            } else {
                val provider = checkNotNull(config.subjectTokenProvider())
                buildSubjectTokenExchangeRequest(
                    provider.getToken(httpClient, jsonMapper),
                    provider.tokenType(),
                )
            }

        return tokenExchangeHttpClient.execute(request).use { response ->
            processTokenExchangeResponse(response)
        }
    }

    private fun startRefreshAsync(refresh: CompletableFuture<CachedToken>) {
        val request =
            try {
                if (isX509) {
                    CompletableFuture.completedFuture(buildX509TokenExchangeRequest())
                } else {
                    val provider = checkNotNull(config.subjectTokenProvider())
                    provider.getTokenAsync(httpClient, jsonMapper).thenApply { subjectToken ->
                        buildSubjectTokenExchangeRequest(subjectToken, provider.tokenType())
                    }
                }
            } catch (error: Throwable) {
                finishRefresh(refresh, error)
                return
            }

        request
            .thenCompose { tokenRequest -> tokenExchangeHttpClient.executeAsync(tokenRequest) }
            .thenApply { response -> response.use { processTokenExchangeResponse(it) } }
            .whenComplete { token, error ->
                val cause = unwrapCompletionException(error)
                when {
                    cause != null -> finishRefresh(refresh, cause)
                    token != null -> finishRefresh(refresh, token)
                    else ->
                        finishRefresh(
                            refresh,
                            IllegalStateException("Token refresh completed without a result"),
                        )
                }
            }
    }

    private fun finishRefresh(refresh: CompletableFuture<CachedToken>, token: CachedToken) {
        lock.withLock {
            if (refreshInFlight === refresh) {
                cachedToken = token
                refreshInFlight = null
                refreshSourceLease = null
            }
        }
        refresh.complete(token)
    }

    private fun finishRefresh(refresh: CompletableFuture<CachedToken>, error: Throwable) {
        lock.withLock {
            if (refreshInFlight === refresh) {
                refreshInFlight = null
                refreshSourceLease = null
            }
        }
        refresh.completeExceptionally(error)
    }

    private fun awaitRefresh(refresh: CompletableFuture<CachedToken>): CachedToken =
        try {
            refresh.get()
        } catch (error: ExecutionException) {
            throw error.cause ?: error
        }

    private fun unwrapCompletionException(error: Throwable?): Throwable? =
        when (error) {
            is CompletionException -> error.cause ?: error
            is ExecutionException -> error.cause ?: error
            else -> error
        }

    private fun buildX509TokenExchangeRequest(): HttpRequest =
        buildTokenExchangeRequest(
            url = X509_TOKEN_EXCHANGE_URL,
            followRedirects = false,
            requestBody =
                linkedMapOf(
                    "grant_type" to TOKEN_EXCHANGE_GRANT_TYPE,
                    "subject_token_type" to X509_TOKEN_TYPE,
                    "identity_provider_id" to config.identityProviderId,
                    "service_account_id" to config.serviceAccountId,
                ),
        )

    private fun buildSubjectTokenExchangeRequest(
        subjectToken: String,
        subjectTokenType: SubjectTokenType,
    ): HttpRequest {
        val requestBody = linkedMapOf("grant_type" to TOKEN_EXCHANGE_GRANT_TYPE)
        config.clientId?.let { requestBody["client_id"] = it }
        requestBody["subject_token"] = subjectToken
        requestBody["subject_token_type"] =
            when (subjectTokenType) {
                SubjectTokenType.JWT -> JWT_TOKEN_TYPE
                SubjectTokenType.ID -> ID_TOKEN_TYPE
            }
        requestBody["identity_provider_id"] = config.identityProviderId
        requestBody["service_account_id"] = config.serviceAccountId
        return buildTokenExchangeRequest(
            url = SUBJECT_TOKEN_EXCHANGE_URL,
            followRedirects = true,
            requestBody = requestBody,
        )
    }

    private fun buildTokenExchangeRequest(
        url: String,
        followRedirects: Boolean,
        requestBody: Map<String, String>,
    ): HttpRequest {
        val jsonBody = jsonMapper.writeValueAsBytes(requestBody)
        val body =
            object : HttpRequestBody {
                override fun writeTo(outputStream: OutputStream) = outputStream.write(jsonBody)

                override fun contentType(): String = "application/json"

                override fun contentLength(): Long = jsonBody.size.toLong()

                override fun repeatable(): Boolean = true

                override fun close() {}
            }

        return HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(url)
            .body(body)
            .followRedirects(followRedirects)
            .build()
    }

    private fun processTokenExchangeResponse(response: HttpResponse): CachedToken {
        errorHandler.handle(response)

        val tokenResponse =
            try {
                jsonMapper.readTree(tokenExchangeResponseBody(response))
                    ?: throw OpenAIInvalidDataException("Invalid token exchange response")
            } catch (error: Exception) {
                throw OpenAIInvalidDataException("Invalid token exchange response")
            }

        val accessToken =
            tokenResponse
                .get("access_token")
                ?.takeIf { it.isTextual }
                ?.asText()
                ?.takeIf { it.isNotBlank() }
        if (accessToken == null) {
            throw OpenAIInvalidDataException("Token exchange response missing 'access_token' field")
        }
        if (isX509 && !X509_BEARER_TOKEN_PATTERN.matches(accessToken)) {
            throw OpenAIInvalidDataException(
                "X.509 token exchange returned an invalid access token"
            )
        }

        val tokenType = tokenResponse.get("token_type")
        if (
            isX509 &&
                tokenType != null &&
                (!tokenType.isTextual || !tokenType.asText().equals("Bearer", ignoreCase = true))
        ) {
            throw OpenAIInvalidDataException(
                "X.509 token exchange returned a non-Bearer token type"
            )
        }

        val expiresInNode = tokenResponse.get("expires_in")
        val expiresIn =
            if (expiresInNode == null || expiresInNode.isNull) {
                if (isX509) {
                    throw OpenAIInvalidDataException(
                        "X.509 token exchange response missing 'expires_in' field"
                    )
                } else {
                    DEFAULT_TOKEN_EXPIRY_SECONDS
                }
            } else {
                if (!expiresInNode.isIntegralNumber || !expiresInNode.canConvertToInt()) {
                    throw OpenAIInvalidDataException(
                        "Token exchange returned a non-integer expires_in value"
                    )
                }
                expiresInNode.intValue()
            }
        if (expiresIn <= 0) {
            throw OpenAIInvalidDataException(
                "Token exchange returned invalid expires_in value: $expiresIn"
            )
        }

        val expiresAfterNanos = TimeUnit.SECONDS.toNanos(expiresIn.toLong())
        val configuredBufferNanos = max(0L, config.refreshBuffer.toNanos())
        val effectiveBufferNanos =
            if (isX509) min(configuredBufferNanos, expiresAfterNanos / 2) else configuredBufferNanos
        return CachedToken(
            lease = TokenLease(accessToken),
            issuedAtNanos = nanoTime.asLong,
            expiresAfterNanos = expiresAfterNanos,
            refreshAfterNanos = expiresAfterNanos - effectiveBufferNanos,
        )
    }

    private fun tokenExchangeResponseBody(response: HttpResponse): InputStream =
        if (isX509) BoundedTokenResponseBody(response.body()) else response.body()

    internal fun uses(
        httpClient: HttpClient,
        jsonMapper: JsonMapper,
        sleeper: Sleeper,
        clock: Clock,
        maxRetries: Int,
    ): Boolean =
        this.httpClient === httpClient &&
            this.jsonMapper === jsonMapper &&
            this.sleeper === sleeper &&
            this.clock === clock &&
            this.maxRetries == maxRetries

    override fun close() {
        var failure: Throwable? = null
        try {
            (config.subjectTokenProvider() as? AutoCloseable)?.close()
        } catch (error: Throwable) {
            failure = error
        }

        if (ownsSleeper) {
            try {
                checkNotNull(sleeper).close()
            } catch (error: Throwable) {
                val providerFailure = failure
                if (providerFailure == null) failure = error
                else providerFailure.addSuppressed(error)
            }
        }

        failure?.let { throw it }
    }
}
