// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import com.openai.core.DefaultSleeper
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.core.checkRequired
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import java.io.IOException
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
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

            val backoffDuration = getRetryBackoffDuration(retries, response)
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
        val result = CompletableFuture<HttpResponse>()
        val currentResponseFuture = AtomicReference<CompletableFuture<HttpResponse>?>(null)
        val currentSleepFuture = AtomicReference<CompletableFuture<Void>?>(null)

        fun <T> trackFuture(
            futureReference: AtomicReference<CompletableFuture<T>?>,
            future: CompletableFuture<T>,
        ) {
            futureReference.set(future)
            if (result.isCancelled) {
                futureReference.getAndSet(null)?.cancel(false)
            }
        }

        fun completeResult(response: HttpResponse?, throwable: Throwable?) {
            if (throwable == null) {
                val completedResponse = checkNotNull(response)
                if (!result.complete(completedResponse)) {
                    completedResponse.close()
                }
            } else {
                result.completeExceptionally(throwable)
            }
        }

        fun executeWithRetries(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ) {
            if (result.isDone) {
                return
            }

            val requestWithRetryCount =
                if (shouldSendRetryCount) setRetryCountHeader(request, retries) else request

            val responseFuture = httpClient.executeAsync(requestWithRetryCount, requestOptions)
            trackFuture(currentResponseFuture, responseFuture)
            if (!isRetryable(requestWithRetryCount)) {
                responseFuture.whenComplete nonRetryableResponse@{ response, throwable ->
                    currentResponseFuture.compareAndSet(responseFuture, null)

                    if (result.isDone) {
                        response?.close()
                        return@nonRetryableResponse
                    }

                    completeResult(response, throwable)
                }
                return
            }

            responseFuture.whenComplete responseHandler@{ response, throwable ->
                currentResponseFuture.compareAndSet(responseFuture, null)

                if (result.isDone) {
                    response?.close()
                    return@responseHandler
                }

                if (response != null) {
                    if (++retries > maxRetries || !shouldRetry(response)) {
                        completeResult(response, null)
                        return@responseHandler
                    }
                } else {
                    val actualThrowable = checkNotNull(throwable)
                    if (++retries > maxRetries || !shouldRetry(actualThrowable)) {
                        completeResult(null, actualThrowable)
                        return@responseHandler
                    }
                }

                val backoffDuration = getRetryBackoffDuration(retries, response)
                // All responses must be closed, so close the failed one before retrying.
                response?.close()

                if (result.isDone) {
                    return@responseHandler
                }

                val sleepFuture = sleeper.sleepAsync(backoffDuration)
                trackFuture(currentSleepFuture, sleepFuture)
                sleepFuture.whenComplete sleepHandler@{ _, sleepThrowable ->
                    currentSleepFuture.compareAndSet(sleepFuture, null)

                    if (result.isDone) {
                        return@sleepHandler
                    }

                    if (sleepThrowable != null) {
                        result.completeExceptionally(sleepThrowable)
                        return@sleepHandler
                    }

                    executeWithRetries(requestWithRetryCount, requestOptions)
                }
            }
        }

        result.whenComplete { _, _ ->
            if (result.isCancelled) {
                currentResponseFuture.getAndSet(null)?.cancel(false)
                currentSleepFuture.getAndSet(null)?.cancel(false)
            }
        }

        executeWithRetries(modifiedRequest, requestOptions)
        return result
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

    private fun shouldRetry(throwable: Throwable): Boolean =
        // Only retry known retryable exceptions, other exceptions are not intended to be retried.
        throwable is IOException ||
            throwable is OpenAIIoException ||
            throwable is OpenAIRetryableException

    private fun getRetryBackoffDuration(retries: Int, response: HttpResponse?): Duration {
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
                                ChronoUnit.NANOS.between(
                                    OffsetDateTime.now(clock),
                                    OffsetDateTime.parse(
                                        retryAfter,
                                        DateTimeFormatter.RFC_1123_DATE_TIME,
                                    ),
                                )
                            } catch (e: DateTimeParseException) {
                                null
                            }
                    }
            }
            ?.let { retryAfterNanos ->
                // If the API asks us to wait a certain amount of time, do what it says.
                return Duration.ofNanos(retryAfterNanos.toLong())
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
