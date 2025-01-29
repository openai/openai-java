package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.errors.OpenAIIoException
import java.io.IOException
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.util.Timer
import java.util.TimerTask
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.function.Function
import kotlin.math.min
import kotlin.math.pow

class RetryingHttpClient
private constructor(
    private val httpClient: HttpClient,
    private val clock: Clock,
    private val maxRetries: Int,
    private val idempotencyHeader: String?,
) : HttpClient {

    override fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): HttpResponse {
        if (!isRetryable(request) || maxRetries <= 0) {
            return httpClient.execute(request, requestOptions)
        }

        var modifiedRequest = maybeAddIdempotencyHeader(request)

        // Don't send the current retry count in the headers if the caller set their own value.
        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        while (true) {
            if (shouldSendRetryCount) {
                modifiedRequest = setRetryCountHeader(modifiedRequest, retries)
            }

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

                    null
                }

            val backoffMillis = getRetryBackoffMillis(retries, response)
            // All responses must be closed, so close the failed one before retrying.
            response?.close()
            Thread.sleep(backoffMillis.toMillis())
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        if (!isRetryable(request) || maxRetries <= 0) {
            return httpClient.executeAsync(request, requestOptions)
        }

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

            return httpClient
                .executeAsync(requestWithRetryCount, requestOptions)
                .handleAsync(
                    fun(
                        response: HttpResponse?,
                        throwable: Throwable?
                    ): CompletableFuture<HttpResponse> {
                        if (response != null) {
                            if (++retries > maxRetries || !shouldRetry(response)) {
                                return CompletableFuture.completedFuture(response)
                            }
                        } else {
                            if (++retries > maxRetries || !shouldRetry(throwable!!)) {
                                val failedFuture = CompletableFuture<HttpResponse>()
                                failedFuture.completeExceptionally(throwable)
                                return failedFuture
                            }
                        }

                        val backoffMillis = getRetryBackoffMillis(retries, response)
                        // All responses must be closed, so close the failed one before retrying.
                        response?.close()
                        return sleepAsync(backoffMillis.toMillis()).thenCompose {
                            executeWithRetries(requestWithRetryCount, requestOptions)
                        }
                    },
                ) {
                    // Run in the same thread.
                    it.run()
                }
                .thenCompose(Function.identity())
        }

        return executeWithRetries(modifiedRequest, requestOptions)
    }

    override fun close() = httpClient.close()

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

    private fun shouldRetry(throwable: Throwable): Boolean =
        // Only retry IOException and OpenAIIoException, other exceptions are not intended to be
        // retried.
        throwable is IOException || throwable is OpenAIIoException

    private fun getRetryBackoffMillis(retries: Int, response: HttpResponse?): Duration {
        // About the Retry-After header:
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After
        response
            ?.headers()
            ?.let { headers ->
                headers
                    .values("Retry-After-Ms")
                    .getOrNull(0)
                    ?.toFloatOrNull()
                    ?.times(TimeUnit.MILLISECONDS.toNanos(1))
                    ?: headers.values("Retry-After").getOrNull(0)?.let { retryAfter ->
                        retryAfter.toFloatOrNull()?.times(TimeUnit.SECONDS.toNanos(1))
                            ?: try {
                                ChronoUnit.MILLIS.between(
                                    OffsetDateTime.now(clock),
                                    OffsetDateTime.parse(
                                        retryAfter,
                                        DateTimeFormatter.RFC_1123_DATE_TIME
                                    )
                                )
                            } catch (e: DateTimeParseException) {
                                null
                            }
                    }
            }
            ?.let { retryAfterNanos ->
                // If the API asks us to wait a certain amount of time (and it's a reasonable
                // amount), just
                // do what it says.
                val retryAfter = Duration.ofNanos(retryAfterNanos.toLong())
                if (retryAfter in Duration.ofNanos(0)..Duration.ofMinutes(1)) {
                    return retryAfter
                }
            }

        // Apply exponential backoff, but not more than the max.
        val backoffSeconds = min(0.5 * 2.0.pow(retries - 1), 8.0)

        // Apply some jitter
        val jitter = 1.0 - 0.25 * ThreadLocalRandom.current().nextDouble()

        return Duration.ofNanos((TimeUnit.SECONDS.toNanos(1) * backoffSeconds * jitter).toLong())
    }

    companion object {

        private val TIMER = Timer("RetryingHttpClient", true)

        private fun sleepAsync(millis: Long): CompletableFuture<Void> {
            val future = CompletableFuture<Void>()
            TIMER.schedule(
                object : TimerTask() {
                    override fun run() {
                        future.complete(null)
                    }
                },
                millis
            )
            return future
        }

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var clock: Clock = Clock.systemUTC()
        private var maxRetries: Int = 2
        private var idempotencyHeader: String? = null

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun idempotencyHeader(header: String) = apply { this.idempotencyHeader = header }

        fun build(): HttpClient =
            RetryingHttpClient(
                checkRequired("httpClient", httpClient),
                clock,
                maxRetries,
                idempotencyHeader,
            )
    }
}
