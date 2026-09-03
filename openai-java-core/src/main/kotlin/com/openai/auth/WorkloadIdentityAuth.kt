package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ErrorObject
import java.io.OutputStream
import java.time.Instant
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

private const val TOKEN_EXCHANGE_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange"
private const val JWT_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:jwt"
private const val ID_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:id_token"
private const val DEFAULT_TOKEN_EXPIRY_SECONDS = 3600
private const val TOKEN_EXCHANGE_URL = "https://auth.openai.com/oauth/token"

internal class WorkloadIdentityAuth(
    private val config: WorkloadIdentity,
    private val httpClient: HttpClient,
    private val jsonMapper: JsonMapper,
) : AutoCloseable {
    private val errorHandler =
        errorHandler(
            object : HttpResponse.Handler<JsonField<ErrorObject>> {
                override fun handle(response: HttpResponse): JsonField<ErrorObject> {
                    val node =
                        try {
                            jsonMapper.readTree(response.body())
                        } catch (e: Exception) {
                            return JsonMissing.of()
                        }

                    return try {
                        val errorCode = node.get("error")?.asText()
                        val errorMessage = node.get("error_description")?.asText() ?: errorCode
                        JsonField.of(
                            jsonMapper.treeToValue(
                                jsonMapper.createObjectNode().apply {
                                    errorCode?.let { put("code", it) }
                                    errorMessage?.let { put("message", it) }
                                },
                                ErrorObject::class.java,
                            )
                        )
                    } catch (e: Exception) {
                        JsonValue.fromJsonNode(node)
                    }
                }
            }
        )
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private var cachedToken: String? = null
    private var tokenExpiry: Instant? = null
    private var refreshInFlight: CompletableFuture<TokenRefreshResult>? = null
    private var refreshing: Boolean = false

    private sealed interface TokenRefreshResult {
        data class Success(val token: String) : TokenRefreshResult

        data class Failure(val error: Throwable) : TokenRefreshResult
    }

    private sealed interface TokenAction {
        data class ReturnCached(val token: String) : TokenAction

        data class BackgroundRefresh(
            val future: CompletableFuture<TokenRefreshResult>,
            val token: String,
        ) : TokenAction

        data class ForegroundRefresh(val future: CompletableFuture<TokenRefreshResult>) :
            TokenAction

        data class WaitForRefresh(val future: CompletableFuture<TokenRefreshResult>) : TokenAction
    }

    private fun unwrapCompletionException(error: Throwable?): Throwable? =
        when (error) {
            is CompletionException -> error.cause ?: error
            is ExecutionException -> error.cause ?: error
            else -> error
        }

    fun getToken(): String {
        lock.withLock {
            while (refreshing && unexpiredCachedTokenUnsafe() == null) {
                condition.await()
            }

            val token = unexpiredCachedTokenUnsafe()
            if (token != null && !isExpiringSoonUnsafe()) {
                return token
            }

            if (refreshing) {
                while (refreshing) {
                    condition.await()
                }
                return unexpiredCachedTokenUnsafe()
                    ?: throw IllegalStateException("Token is unusable after refresh completed")
            }

            refreshing = true
        }

        try {
            performRefresh()
            lock.withLock {
                return unexpiredCachedTokenUnsafe()
                    ?: throw IllegalStateException("Token is unusable after refresh completed")
            }
        } finally {
            lock.withLock {
                refreshing = false
                condition.signalAll()
            }
        }
    }

    fun getTokenAsync(): CompletableFuture<String> {
        val action =
            lock.withLock {
                val token = unexpiredCachedTokenUnsafe()
                if (token != null) {
                    if (isExpiringSoonUnsafe() && refreshInFlight == null) {
                        val future = CompletableFuture<TokenRefreshResult>()
                        refreshInFlight = future
                        TokenAction.BackgroundRefresh(future, token)
                    } else {
                        TokenAction.ReturnCached(token)
                    }
                } else if (refreshInFlight != null) {
                    TokenAction.WaitForRefresh(refreshInFlight!!)
                } else {
                    val future = CompletableFuture<TokenRefreshResult>()
                    refreshInFlight = future
                    TokenAction.ForegroundRefresh(future)
                }
            }

        return when (action) {
            is TokenAction.ReturnCached -> CompletableFuture.completedFuture(action.token)
            is TokenAction.BackgroundRefresh -> {
                performRefreshAndComplete(action.future)
                CompletableFuture.completedFuture(action.token)
            }
            is TokenAction.WaitForRefresh ->
                action.future.thenApply { result ->
                    when (result) {
                        is TokenRefreshResult.Success -> result.token
                        is TokenRefreshResult.Failure -> throw result.error
                    }
                }
            is TokenAction.ForegroundRefresh -> {
                val refresh = refreshTokenAsync()
                refresh.whenComplete { token, error ->
                    finishRefresh(action.future, token, unwrapCompletionException(error))
                }
                refresh
            }
        }
    }

    private fun performRefreshAndComplete(future: CompletableFuture<TokenRefreshResult>) {
        refreshTokenAsync().whenComplete { token, error ->
            finishRefresh(future, token, unwrapCompletionException(error))
        }
    }

    private fun finishRefresh(
        future: CompletableFuture<TokenRefreshResult>,
        token: String?,
        error: Throwable?,
    ) {
        val shouldComplete =
            lock.withLock {
                if (refreshInFlight != future) {
                    false
                } else {
                    refreshInFlight = null
                    true
                }
            }

        if (shouldComplete) {
            future.complete(
                when {
                    error != null -> TokenRefreshResult.Failure(error)
                    token != null -> TokenRefreshResult.Success(token)
                    else -> error("finishRefresh requires either a token or an error")
                }
            )
        }
    }

    fun invalidateToken() {
        lock.withLock {
            cachedToken = null
            tokenExpiry = null
        }
    }

    private fun unexpiredCachedTokenUnsafe(): String? {
        val token = cachedToken
        val expiry = tokenExpiry
        if (token == null || expiry == null) return null
        return if (Instant.now().isAfter(expiry)) null else token
    }

    private fun isExpiringSoonUnsafe(): Boolean {
        val expiry = tokenExpiry ?: return true
        val refreshBuffer = config.refreshBufferSeconds
        val refreshTime = expiry.minusSeconds(refreshBuffer.toLong())
        return Instant.now().isAfter(refreshTime)
    }

    private fun performRefresh() {
        val subjectToken = config.provider.getToken(httpClient, jsonMapper)
        val request = buildTokenExchangeRequest(subjectToken)
        val response = httpClient.execute(request)
        response.use { processTokenExchangeResponse(it) }
    }

    private fun refreshTokenAsync(): CompletableFuture<String> {
        return config.provider.getTokenAsync(httpClient, jsonMapper).thenCompose { subjectToken ->
            val request = buildTokenExchangeRequest(subjectToken)
            httpClient.executeAsync(request).thenApply { response ->
                response.use { processTokenExchangeResponse(it) }
            }
        }
    }

    private fun buildTokenExchangeRequest(subjectToken: String): HttpRequest {
        val subjectTokenTypeURN =
            when (config.provider.tokenType()) {
                SubjectTokenType.JWT -> JWT_TOKEN_TYPE
                SubjectTokenType.ID -> ID_TOKEN_TYPE
            }

        val requestBody = mutableMapOf("grant_type" to TOKEN_EXCHANGE_GRANT_TYPE)
        config.clientId?.let { requestBody["client_id"] = it }
        requestBody["subject_token"] = subjectToken
        requestBody["subject_token_type"] = subjectTokenTypeURN
        requestBody["identity_provider_id"] = config.identityProviderId
        requestBody["service_account_id"] = config.serviceAccountId

        val jsonBody = jsonMapper.writeValueAsBytes(requestBody)

        val body =
            object : HttpRequestBody {
                override fun writeTo(outputStream: OutputStream) {
                    outputStream.write(jsonBody)
                }

                override fun contentType(): String = "application/json"

                override fun contentLength(): Long = jsonBody.size.toLong()

                override fun repeatable(): Boolean = true

                override fun close() {}
            }

        return HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(TOKEN_EXCHANGE_URL)
            .body(body)
            .build()
    }

    private fun processTokenExchangeResponse(response: HttpResponse): String {
        errorHandler.handle(response)

        val bodyString = response.body().bufferedReader().readText()
        val tokenResponse =
            jsonMapper.readValue(bodyString, jacksonTypeRef<TokenExchangeResponse>())

        if (tokenResponse.accessToken.isBlank()) {
            throw OpenAIInvalidDataException(
                "Token exchange response missing 'access_token' field. Response: $bodyString"
            )
        }

        val expiresIn = tokenResponse.expiresIn ?: DEFAULT_TOKEN_EXPIRY_SECONDS

        if (expiresIn <= 0) {
            throw OpenAIInvalidDataException(
                "Token exchange returned invalid expires_in value: $expiresIn"
            )
        }

        val newExpiry = Instant.now().plusSeconds(expiresIn.toLong())

        lock.withLock {
            cachedToken = tokenResponse.accessToken
            tokenExpiry = newExpiry
        }

        return tokenResponse.accessToken
    }

    override fun close() {
        (config.provider as? AutoCloseable)?.close()
    }
}
