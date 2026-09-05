package com.openai.core.http

import com.openai.auth.WorkloadIdentityRetryScope
import com.openai.core.CancellableFuture
import com.openai.core.DefaultSleeper
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.core.checkRequired
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import java.io.IOException
import java.time.Clock
import java.time.Duration
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import kotlin.math.min
import kotlin.math.pow

class RetryingHttpClient
private constructor(
    private val httpClient: HttpClient,
    private val sleeper: Sleeper,
    private val clock: Clock,
    private val maxRetries: Int,
    private val idempotencyHeader: String?,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        var modifiedRequest = maybeAddIdempotencyHeader(request)

        // Don't send the current retry count in the headers if the caller set their own value.
        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        while (true) {
            if (shouldSendRetryCount) {
                modifiedRequest = setRetryCountHeader(modifiedRequest, retries)
            }

            if (!isRetryable(modifiedRequest)) {
                return httpClient.execute(modifiedRequest, requestOptions)
            }

            var failure: Throwable? = null
            val response =
                try {
                    val response = httpClient.execute(modifiedRequest, requestOptions)
                    if (++retries > maxRetries || !shouldRetry(response)) {
                        return response
                    }

                    response
                } catch (throwable: Throwable) {
                    if (++retries > maxRetries || !shouldRetry(throwable)) {
                        throw throwable
                    }

                    failure = throwable
                    null
                }

            val backoffDuration =
                getRetryBackoffDuration(retries, response?.headers() ?: retryHeaders(failure))
                    ?: if (response != null) return response else throw checkNotNull(failure)
            // All responses must be closed, so close the failed one before retrying.
            response?.close()
            sleeper.sleep(backoffDuration)
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val modifiedRequest = maybeAddIdempotencyHeader(request)

        // Don't send the current retry count in the headers if the caller set their own value.
        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        fun executeWithRetries(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val requestWithRetryCount =
                if (shouldSendRetryCount) setRetryCountHeader(request, retries) else request

            val responseFuture =
                CancellableFuture.wrap(
                    httpClient.executeAsync(requestWithRetryCount, requestOptions)
                )
            if (!isRetryable(requestWithRetryCount)) {
                return responseFuture
            }

            val responseClosed = AtomicBoolean()
            val inspectedResponse = AtomicReference<HttpResponse?>()
            fun closeResponse(response: HttpResponse?) {
                if (response != null && responseClosed.compareAndSet(false, true)) response.close()
            }

            return responseFuture
                .handleAsync(
                    { response, throwable -> Pair(response, throwable) },
                    onDiscard = { (response, _) -> response?.close() },
                )
                .thenCompose(
                    { (response, throwable) ->
                        inspectedResponse.set(response)
                        if (response != null) {
                            if (++retries > maxRetries || !shouldRetry(response)) {
                                return@thenCompose CompletableFuture.completedFuture(response)
                            }
                        } else {
                            if (++retries > maxRetries || !shouldRetry(throwable!!)) {
                                val failedFuture = CompletableFuture<HttpResponse>()
                                failedFuture.completeExceptionally(throwable)
                                return@thenCompose failedFuture
                            }
                        }

                        val backoffDuration =
                            getRetryBackoffDuration(
                                retries,
                                response?.headers() ?: retryHeaders(throwable),
                            )
                                ?: return@thenCompose if (response != null) {
                                    CompletableFuture.completedFuture(response)
                                } else {
                                    CompletableFuture<HttpResponse>().apply {
                                        completeExceptionally(checkNotNull(throwable))
                                    }
                                }
                        // All responses must be closed, so close the failed one before retrying.
                        closeResponse(response)
                        CancellableFuture.wrap(sleeper.sleepAsync(backoffDuration)).thenCompose {
                            _: Void? ->
                            executeWithRetries(requestWithRetryCount, requestOptions)
                        }
                    },
                    { (response, _) -> closeResponse(response) },
                    { response ->
                        if (response === inspectedResponse.get()) closeResponse(response)
                        else response.close()
                    },
                )
        }

        return executeWithRetries(
            modifiedRequest,
            requestOptions.withWorkloadIdentityRetryScope(
                WorkloadIdentityRetryScope(clock, sleeper)
            ),
        )
    }

    override fun close() {
        httpClient.close()
        sleeper.close()
    }

    private fun isRetryable(request: HttpRequest): Boolean =
        // Some requests, such as when a request body is being streamed, cannot be retried because
        // the body data aren't available on subsequent attempts.
        request.body?.repeatable() ?: true

    private fun setRetryCountHeader(request: HttpRequest, retries: Int): HttpRequest =
        request.toBuilder().replaceHeaders("X-Stainless-Retry-Count", retries.toString()).build()

    private fun idempotencyKey(): String = "stainless-java-retry-${UUID.randomUUID()}"

    private fun maybeAddIdempotencyHeader(request: HttpRequest): HttpRequest {
        if (idempotencyHeader == null || request.headers.names().contains(idempotencyHeader)) {
            return request
        }

        return request
            .toBuilder()
            // Set a header to uniquely identify the request when retried.
            .putHeader(idempotencyHeader, idempotencyKey())
            .build()
    }

    private fun shouldRetry(response: HttpResponse): Boolean {
        // Note: this is not a standard header
        val shouldRetryHeader = response.headers().values("X-Should-Retry").getOrNull(0)
        val statusCode = response.statusCode()

        return when {
            // If the server explicitly says whether to retry, obey
            shouldRetryHeader == "true" -> true
            shouldRetryHeader == "false" -> false

            // Retry on request timeouts
            statusCode == 408 -> true
            // Retry on lock timeouts
            statusCode == 409 -> true
            // Retry on rate limits
            statusCode == 429 -> true
            // Retry internal errors
            statusCode >= 500 -> true
            else -> false
        }
    }

    private fun unwrap(throwable: Throwable): Throwable {
        var current = throwable
        while (
            (current is CompletionException || current is ExecutionException) &&
                current.cause != null
        ) {
            current = checkNotNull(current.cause)
        }
        return current
    }

    private fun retryHeaders(throwable: Throwable?): Headers? {
        val failure = throwable?.let(::unwrap) ?: return null
        return retryAfterHeaders(failure)
    }

    private fun shouldRetry(throwable: Throwable): Boolean {
        val cause = unwrap(throwable)
        // Only retry known retryable exceptions, other exceptions are not intended to be retried.
        return cause is IOException ||
            cause is OpenAIIoException ||
            cause is OpenAIRetryableException
    }

    private fun getRetryBackoffDuration(retries: Int, headers: Headers?): Duration? {
        retryAfterDelay(headers, clock)?.let { delay ->
            // Return the original response if the duration cannot be represented safely.
            return delay.takeIf { it <= Duration.ofNanos(Long.MAX_VALUE) }
        }

        // Apply exponential backoff, but not more than the max.
        val backoffSeconds = min(0.5 * 2.0.pow(retries - 1), 8.0)

        // Apply some jitter
        val jitter = 1.0 - 0.25 * ThreadLocalRandom.current().nextDouble()

        return Duration.ofNanos((TimeUnit.SECONDS.toNanos(1) * backoffSeconds * jitter).toLong())
    }

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var sleeper: Sleeper? = null
        private var clock: Clock = Clock.systemUTC()
        private var maxRetries: Int = 2
        private var idempotencyHeader: String? = null

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun sleeper(sleeper: Sleeper) = apply { this.sleeper = sleeper }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun idempotencyHeader(header: String) = apply { this.idempotencyHeader = header }

        fun build(): HttpClient =
            RetryingHttpClient(
                checkRequired("httpClient", httpClient),
                sleeper ?: DefaultSleeper(),
                clock,
                maxRetries,
                idempotencyHeader,
            )
    }
}
