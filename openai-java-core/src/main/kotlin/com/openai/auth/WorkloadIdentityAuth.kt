package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.CancellableFuture
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
import java.time.Clock
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
    private var refreshInFlight: TokenRefresh? = null
    private var synchronousRefresh: SynchronousRefresh? = null

    private class SynchronousRefresh {
        var complete = false
        var failure: Throwable? = null
    }

    private sealed interface TokenRefreshResult {
        data class Success(val token: String) : TokenRefreshResult

        data class Failure(val error: Throwable) : TokenRefreshResult
    }

    private class TokenRefresh(
        val background: Boolean,
        var waiters: Int = 0,
        val retryGeneration: WorkloadIdentityRetryGeneration,
    ) {
        val future = CompletableFuture<TokenRefreshResult>()
        var operation: CompletableFuture<String>? = null
    }

    private sealed interface TokenAction {
        data class ReturnCached(val token: String) : TokenAction

        data class WaitForMinimum(val barrier: WorkloadIdentityRetryScope.Barrier) : TokenAction

        data class BackgroundRefresh(val refresh: TokenRefresh, val token: String) : TokenAction

        data class ForegroundRefresh(val refresh: TokenRefresh) : TokenAction

        data class WaitForRefresh(val refresh: TokenRefresh) : TokenAction
    }

    private fun unwrapCompletionException(error: Throwable?): Throwable? =
        when (error) {
            is CompletionException -> error.cause ?: error
            is ExecutionException -> error.cause ?: error
            else -> error
        }

    fun getToken(): String {
        val refresh =
            lock.withLock {
                val token = unexpiredCachedTokenUnsafe()
                if (token != null && !isExpiringSoonUnsafe()) {
                    return token
                }

                synchronousRefresh?.let { inFlight ->
                    while (!inFlight.complete) {
                        condition.await()
                    }
                    // Preserve cached-token fallback, but share a failed generation when no
                    // usable bearer remains instead of starting another issuer exchange.
                    return unexpiredCachedTokenUnsafe()
                        ?: throw (inFlight.failure
                            ?: IllegalStateException("Token is unusable after refresh completed"))
                }

                SynchronousRefresh().also { synchronousRefresh = it }
            }

        try {
            performRefresh()
            lock.withLock {
                return unexpiredCachedTokenUnsafe()
                    ?: throw IllegalStateException("Token is unusable after refresh completed")
            }
        } catch (error: Throwable) {
            lock.withLock { refresh.failure = error }
            throw error
        } finally {
            lock.withLock {
                refresh.complete = true
                synchronousRefresh = null
                condition.signalAll()
            }
        }
    }

    fun getTokenAsync(): CompletableFuture<String> = getTokenAsync(null)

    fun getTokenAsync(scope: WorkloadIdentityRetryScope?): CompletableFuture<String> {
        val action =
            lock.withLock {
                val token = unexpiredCachedTokenUnsafe()
                if (token != null) {
                    refreshInFlight?.let { scope?.observe(it.retryGeneration) }
                    if (
                        isExpiringSoonUnsafe() &&
                            refreshInFlight == null &&
                            scope?.barrier() == null
                    ) {
                        val refresh =
                            TokenRefresh(
                                background = true,
                                retryGeneration =
                                    WorkloadIdentityRetryGeneration(
                                        scope?.clock ?: Clock.systemUTC()
                                    ),
                            )
                        scope?.observe(refresh.retryGeneration)
                        refreshInFlight = refresh
                        TokenAction.BackgroundRefresh(refresh, token)
                    } else {
                        TokenAction.ReturnCached(token)
                    }
                } else if (refreshInFlight != null) {
                    TokenAction.WaitForRefresh(
                        refreshInFlight!!.also {
                            it.waiters++
                            scope?.observe(it.retryGeneration)
                        }
                    )
                } else {
                    val barrier = scope?.barrier()
                    if (barrier != null) return@withLock TokenAction.WaitForMinimum(barrier)
                    scope?.clear()
                    val refresh =
                        TokenRefresh(
                            background = false,
                            waiters = 1,
                            retryGeneration =
                                WorkloadIdentityRetryGeneration(scope?.clock ?: Clock.systemUTC()),
                        )
                    scope?.observe(refresh.retryGeneration)
                    refreshInFlight = refresh
                    TokenAction.ForegroundRefresh(refresh)
                }
            }

        return when (action) {
            is TokenAction.ReturnCached -> CompletableFuture.completedFuture(action.token)
            is TokenAction.WaitForMinimum -> {
                val delay = action.barrier.delay
                if (delay == null) {
                    CompletableFuture<String>().apply {
                        completeExceptionally(action.barrier.error)
                    }
                } else {
                    CancellableFuture.wrap(checkNotNull(scope).sleeper.sleepAsync(delay))
                        .thenCompose { _: Void? ->
                            lock.withLock { scope.clear() }
                            getTokenAsync(scope)
                        }
                }
            }
            is TokenAction.BackgroundRefresh -> {
                performRefreshAndComplete(action.refresh)
                CompletableFuture.completedFuture(action.token)
            }
            is TokenAction.WaitForRefresh -> refreshWaiter(action.refresh)
            is TokenAction.ForegroundRefresh -> {
                val waiter = refreshWaiter(action.refresh)
                performRefreshAndComplete(action.refresh)
                waiter
            }
        }
    }

    private fun refreshWaiter(refresh: TokenRefresh): CompletableFuture<String> {
        val waiter = CompletableFuture<String>()
        waiter.whenComplete { _, _ ->
            val cancelOperation =
                lock.withLock {
                    refresh.waiters--
                    if (waiter.isCancelled && refresh.waiters == 0 && !refresh.background) {
                        if (refreshInFlight === refresh) refreshInFlight = null
                        refresh.operation
                    } else null
                }
            cancelOperation?.cancel(true)
        }
        refresh.future.whenComplete { result, error ->
            when {
                error != null -> waiter.completeExceptionally(error)
                result is TokenRefreshResult.Success -> waiter.complete(result.token)
                result is TokenRefreshResult.Failure -> waiter.completeExceptionally(result.error)
            }
        }
        return waiter
    }

    private fun performRefreshAndComplete(refresh: TokenRefresh) {
        val operation =
            try {
                refreshTokenAsync()
            } catch (error: Throwable) {
                finishRefresh(refresh, null, error)
                return
            }
        val cancelOperation =
            lock.withLock {
                refresh.operation = operation
                refresh.waiters == 0 && !refresh.background
            }
        operation.whenComplete { token, error ->
            finishRefresh(refresh, token, unwrapCompletionException(error))
        }
        if (cancelOperation) operation.cancel(true)
    }

    private fun finishRefresh(refresh: TokenRefresh, token: String?, error: Throwable?) {
        lock.withLock {
            error?.let { refresh.retryGeneration.failed(it) }
            if (refreshInFlight === refresh) refreshInFlight = null
        }
        refresh.future.complete(
            when {
                error != null -> TokenRefreshResult.Failure(error)
                token != null -> TokenRefreshResult.Success(token)
                else -> error("finishRefresh requires either a token or an error")
            }
        )
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
        return CancellableFuture.wrap(config.provider.getTokenAsync(httpClient, jsonMapper))
            .thenCompose { subjectToken ->
                val request = buildTokenExchangeRequest(subjectToken)
                CancellableFuture.wrap(httpClient.executeAsync(request)).thenApply { response ->
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
