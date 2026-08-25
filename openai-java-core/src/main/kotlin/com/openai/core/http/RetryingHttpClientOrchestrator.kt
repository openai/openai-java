package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.core.Timeout
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.IOException
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutionException
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import java.util.function.Function
import kotlin.math.min
import kotlin.math.pow

internal class RetryingHttpClientOrchestrator(
    private val httpClient: HttpClient,
    private val sleeper: Sleeper,
    private val clock: Clock,
    private val maxRetries: Int,
    private val idempotencyHeader: String?,
    private val attemptAuthenticator: HttpRequestAttemptAuthenticator?,
    private val nanoTime: () -> Long = System::nanoTime,
    private val beforeAsyncApiDispatch: () -> Unit = {},
) : HttpClient {
    private val closed = AtomicBoolean()
    private val activeAuthenticatedRequests = ConcurrentHashMap.newKeySet<CompletableFuture<*>>()
    private var authenticatorClosed = attemptAuthenticator == null
    private var httpClientClosed = false
    private var sleeperClosed = false

    private fun trackAuthenticatedRequest(future: CompletableFuture<*>): Boolean {
        if (closed.get()) return false
        activeAuthenticatedRequests.add(future)
        future.whenComplete { _, _ -> activeAuthenticatedRequests.remove(future) }
        if (closed.get() && activeAuthenticatedRequests.remove(future)) {
            future.completeExceptionally(OpenAIIoException("HTTP client is closed"))
            return false
        }
        return true
    }

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        executeWithRetries(request, requestOptions)

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = executeWithRetriesAsync(request, requestOptions)

    @Synchronized
    override fun close() {
        closed.set(true)
        activeAuthenticatedRequests.forEach { future ->
            future.completeExceptionally(OpenAIIoException("HTTP client is closed"))
        }
        if (attemptAuthenticator == null) {
            httpClient.close()
            sleeper.close()
            return
        }
        var failure: Throwable? = null
        fun closeComponent(isClosed: Boolean, close: () -> Unit): Boolean {
            if (isClosed) return true
            try {
                close()
                return true
            } catch (error: Throwable) {
                if (failure == null) failure = error
                else if (error !== failure) failure?.addSuppressed(error)
                return false
            }
        }
        authenticatorClosed = closeComponent(authenticatorClosed, attemptAuthenticator::close)
        httpClientClosed = closeComponent(httpClientClosed, httpClient::close)
        sleeperClosed = closeComponent(sleeperClosed, sleeper::close)
        failure?.let { throw it }
    }

    private fun executeWithRetries(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): HttpResponse {
        val authenticator = attemptAuthenticator
        val pipelineRequest =
            if (authenticator != null) request.withPipelineOwnedBody() else request
        var requestFailure: Throwable? = null
        try {
            if (authenticator != null && closed.get()) {
                throw OpenAIIoException("HTTP client is closed")
            }
            val deadline = authenticator?.let { deadline(requestOptions) }
            val modified = maybeAddIdempotencyHeader(pipelineRequest)
            val sendRetryCount = !modified.headers.names().contains("X-Stainless-Retry-Count")
            var retries = 0
            var replayed = false
            while (true) {
                val current =
                    if (sendRetryCount) setRetryCountHeader(modified, retries) else modified
                if (authenticator == null) {
                    if (!isRetryable(current)) return httpClient.execute(current, requestOptions)
                    val response =
                        try {
                            val value = httpClient.execute(current, requestOptions)
                            if (++retries > maxRetries || !shouldRetry(value)) return value
                            value
                        } catch (error: Throwable) {
                            if (++retries > maxRetries || !shouldRetry(error)) throw error
                            null
                        }
                    val delay = getRetryBackoffDuration(retries, response)
                    response?.close()
                    sleeper.sleep(delay)
                    continue
                }
                val authenticated =
                    try {
                        val authenticationOptions =
                            deadline?.let { remainingOptions(requestOptions, it) } ?: requestOptions
                        authenticator.authenticate(current, attemptTimeouts(authenticationOptions))
                    } catch (error: Throwable) {
                        if (retries >= maxRetries || !shouldRetryAttempt(error)) {
                            throw error
                        }
                        retries++
                        sleepAuthenticated(
                            getRetryBackoffDuration(retries, error = error),
                            deadline,
                        )
                        continue
                    }
                val options =
                    deadline?.let { remainingOptions(requestOptions, it) } ?: requestOptions
                val authenticatedRequest = authenticated.request()
                val response =
                    try {
                        httpClient.execute(authenticatedRequest, options)
                    } catch (error: Throwable) {
                        if (
                            !isRetryable(authenticatedRequest) ||
                                retries >= maxRetries ||
                                !shouldRetryAttempt(error)
                        ) {
                            throw error
                        }
                        retries++
                        sleepAuthenticated(getRetryBackoffDuration(retries), deadline)
                        continue
                    }
                var ownedResponse: HttpResponse? = response
                try {
                    if (response.statusCode() == 401) {
                        authenticated.onUnauthorized()
                        // Authentication replay is the separate `replayUsed` bit in RequestScope.
                        // It
                        // shares the deadline and retry-count continuity, but does not consume or
                        // reset
                        // the transient maxRetries budget.
                        if (isRetryable(authenticatedRequest) && !replayed) {
                            replayed = true
                            ownedResponse = null
                            response.close()
                            continue
                        }
                        ownedResponse = null
                        return response.asPipelineOwned()
                    }
                    if (
                        !isRetryable(authenticatedRequest) ||
                            retries >= maxRetries ||
                            !shouldRetry(response)
                    ) {
                        ownedResponse = null
                        return response.asPipelineOwned()
                    }
                    retries++
                    val delay = getRetryBackoffDuration(retries, response)
                    ownedResponse = null
                    response.close()
                    sleepAuthenticated(delay, deadline)
                } catch (failure: Throwable) {
                    ownedResponse?.let {
                        try {
                            it.close()
                        } catch (closeFailure: Throwable) {
                            if (closeFailure !== failure) failure.addSuppressed(closeFailure)
                        }
                    }
                    throw failure
                }
            }
        } catch (failure: Throwable) {
            requestFailure = failure
            throw failure
        } finally {
            if (authenticator != null) pipelineRequest.closePipelineBody(requestFailure)
        }
    }

    private fun executeWithRetriesAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        attemptAuthenticator?.let {
            executeAuthenticatedWithRetriesAsync(request, requestOptions, it)
        } ?: executeOrdinaryWithRetriesAsync(request, requestOptions)

    private fun executeAuthenticatedWithRetriesAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        authenticator: HttpRequestAttemptAuthenticator,
    ): CompletableFuture<HttpResponse> {
        val pipelineRequest = request.withPipelineOwnedBody()
        val stageLock = Any()
        var terminalReserved = false
        val result =
            object : CompletableFuture<HttpResponse>() {
                private fun reserveTerminal(): Boolean =
                    synchronized(stageLock) {
                        if (terminalReserved || isDone) false
                        else {
                            terminalReserved = true
                            true
                        }
                    }

                override fun cancel(mayInterruptIfRunning: Boolean): Boolean =
                    reserveTerminal() && super.cancel(mayInterruptIfRunning)

                override fun complete(value: HttpResponse): Boolean =
                    reserveTerminal() && super.complete(value)

                override fun completeExceptionally(error: Throwable): Boolean =
                    reserveTerminal() && super.completeExceptionally(error)
            }
        val active = AtomicReference<CompletableFuture<*>?>()
        result.whenComplete { _, _ ->
            if (result.isCancelled || closed.get()) active.getAndSet(null)?.cancel(true)
            pipelineRequest.discardPipelineBody()
        }
        if (closed.get()) {
            result.completeExceptionally(OpenAIIoException("HTTP client is closed"))
            return result
        }
        if (!trackAuthenticatedRequest(result)) {
            result.completeExceptionally(OpenAIIoException("HTTP client is closed"))
            return result
        }
        val deadline = deadline(requestOptions)
        val modified = maybeAddIdempotencyHeader(pipelineRequest)
        val sendRetryCount = !modified.headers.names().contains("X-Stainless-Retry-Count")
        var retries = 0
        var replayed = false

        fun <T> startStage(start: () -> CompletableFuture<T>): CompletableFuture<T>? =
            synchronized(stageLock) {
                if (terminalReserved || result.isDone) null else start().also { active.set(it) }
            }

        fun closeDiscarded(response: HttpResponse?) {
            try {
                response?.close()
            } catch (_: Throwable) {}
        }

        fun fail(error: Throwable, response: HttpResponse? = null) {
            var failure = error
            if (response != null) {
                try {
                    response.close()
                } catch (closeError: Throwable) {
                    if (closeError !== failure) failure.addSuppressed(closeError)
                }
            }
            result.completeExceptionally(failure)
        }

        fun completeResponse(response: HttpResponse) {
            val delivered = response.asPipelineOwned()
            if (!result.complete(delivered)) delivered.close()
        }

        lateinit var run: () -> Unit
        fun retry(
            response: HttpResponse? = null,
            error: Throwable? = null,
            authenticationFailure: Boolean = false,
            requestRetryable: Boolean = true,
        ) {
            var ownedResponse = response
            try {
                if (result.isDone) {
                    ownedResponse = null
                    closeDiscarded(response)
                    return
                }
                if (!requestRetryable && !authenticationFailure) {
                    if (response != null) {
                        ownedResponse = null
                        completeResponse(response)
                    } else {
                        result.completeExceptionally(
                            error ?: IllegalStateException("Missing failure")
                        )
                    }
                    return
                }
                val cause = error?.let(::unwrap)
                val retryError = cause?.let(::shouldRetryAttempt)
                if (retries >= maxRetries || (response?.let(::shouldRetry) ?: retryError != true)) {
                    if (response != null) {
                        ownedResponse = null
                        completeResponse(response)
                    } else {
                        result.completeExceptionally(
                            cause ?: IllegalStateException("Missing failure")
                        )
                    }
                    return
                }
                retries++
                val delay = getRetryBackoffDuration(retries, response, cause)
                if (response != null) {
                    ownedResponse = null
                    response.close()
                }
                val remaining = deadline?.let(::remaining)
                if (remaining != null && delay >= remaining) {
                    result.completeExceptionally(timedOut())
                    return
                }
                val sleep =
                    try {
                        startStage { sleeper.sleepAsync(delay) } ?: return
                    } catch (sleepError: Throwable) {
                        result.completeExceptionally(sleepError)
                        return
                    }
                sleep.whenComplete { _, sleepError ->
                    try {
                        if (sleepError == null) run()
                        else {
                            result.completeExceptionally(unwrap(sleepError))
                        }
                    } catch (sleepFailure: Throwable) {
                        fail(sleepFailure)
                    }
                }
            } catch (retryFailure: Throwable) {
                fail(retryFailure, ownedResponse)
            }
        }

        fun dispatch(authenticated: AuthenticatedHttpRequest, options: RequestOptions) {
            val authenticatedRequest = authenticated.request()
            beforeAsyncApiDispatch()
            val call =
                try {
                    startStage { httpClient.executeAsync(authenticatedRequest, options) } ?: return
                } catch (error: Throwable) {
                    retry(error = error, requestRetryable = isRetryable(authenticatedRequest))
                    return
                }
            call.whenComplete callComplete@{ response, callError ->
                var ownedResponse = response
                try {
                    if (result.isDone) {
                        ownedResponse = null
                        closeDiscarded(response)
                        return@callComplete
                    }
                    val requestRetryable = isRetryable(authenticatedRequest)
                    if (callError != null) {
                        ownedResponse = null
                        closeDiscarded(response)
                        retry(error = callError, requestRetryable = requestRetryable)
                    } else if (response.statusCode() == 401) {
                        authenticated.onUnauthorized()
                        // See the synchronous path: replayUsed is distinct from maxRetries.
                        if (requestRetryable && !replayed) {
                            replayed = true
                            ownedResponse = null
                            response.close()
                            run()
                        } else {
                            ownedResponse = null
                            completeResponse(response)
                        }
                    } else {
                        ownedResponse = null
                        retry(response = response, requestRetryable = requestRetryable)
                    }
                } catch (callbackFailure: Throwable) {
                    fail(callbackFailure, ownedResponse)
                }
            }
        }

        run = run@{
            if (result.isDone) return@run
            val authenticationOptions =
                try {
                    deadline?.let { remainingOptions(requestOptions, it) } ?: requestOptions
                } catch (error: Throwable) {
                    result.completeExceptionally(error)
                    return@run
                }
            val current = if (sendRetryCount) setRetryCountHeader(modified, retries) else modified
            val authentication =
                try {
                    startStage {
                        authenticator.authenticateAsync(
                            current,
                            attemptTimeouts(authenticationOptions),
                        )
                    } ?: return@run
                } catch (error: Throwable) {
                    retry(error = error, authenticationFailure = true)
                    return@run
                }
            authentication.whenComplete authenticationComplete@{ authenticated, authError ->
                try {
                    if (result.isDone) return@authenticationComplete
                    if (authError != null) {
                        retry(error = authError, authenticationFailure = true)
                        return@authenticationComplete
                    }
                    val options =
                        try {
                            deadline?.let { remainingOptions(requestOptions, it) } ?: requestOptions
                        } catch (error: Throwable) {
                            result.completeExceptionally(error)
                            return@authenticationComplete
                        }
                    dispatch(authenticated, options)
                } catch (error: Throwable) {
                    fail(error)
                }
            }
        }
        run()
        return result
    }

    /**
     * The pre-X.509 pipeline is kept intact so ordinary-client completion semantics do not move.
     */
    private fun executeOrdinaryWithRetriesAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val modifiedRequest = maybeAddIdempotencyHeader(request)
        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")
        var retries = 0

        fun executeWithRetries(current: HttpRequest): CompletableFuture<HttpResponse> {
            val requestWithRetryCount =
                if (shouldSendRetryCount) setRetryCountHeader(current, retries) else current
            val responseFuture = httpClient.executeAsync(requestWithRetryCount, requestOptions)
            if (!isRetryable(requestWithRetryCount)) return responseFuture

            return responseFuture
                .handleAsync(
                    fun(
                        response: HttpResponse?,
                        error: Throwable?,
                    ): CompletableFuture<HttpResponse> {
                        if (response != null) {
                            if (++retries > maxRetries || !shouldRetry(response)) {
                                return CompletableFuture.completedFuture(response)
                            }
                        } else if (++retries > maxRetries || !shouldRetry(error!!)) {
                            return CompletableFuture<HttpResponse>().also {
                                it.completeExceptionally(error)
                            }
                        }

                        val backoffDuration = getRetryBackoffDuration(retries, response)
                        response?.close()
                        return sleeper.sleepAsync(backoffDuration).thenCompose {
                            executeWithRetries(requestWithRetryCount)
                        }
                    }
                ) {
                    it.run()
                }
                .thenCompose(Function.identity())
        }

        return executeWithRetries(modifiedRequest)
    }

    private fun deadline(options: RequestOptions): Deadline? {
        val duration = (options.timeout ?: Timeout.default()).request()
        if (duration.isZero) return null
        val nanos =
            try {
                duration.toNanos()
            } catch (_: ArithmeticException) {
                if (duration.isNegative) 0 else Long.MAX_VALUE
            }
        return Deadline(nanoTime(), nanos)
    }

    private fun remaining(deadline: Deadline): Duration {
        val elapsed = nanoTime() - deadline.startedAt
        val nanos =
            if (elapsed < 0 || elapsed >= deadline.timeoutNanos) 0
            else deadline.timeoutNanos - elapsed
        return Duration.ofNanos(nanos)
    }

    private fun remainingOptions(options: RequestOptions, deadline: Deadline): RequestOptions {
        val remaining = remaining(deadline)
        if (remaining.isZero) throw timedOut()
        return options.withTimeout(
            (options.timeout ?: Timeout.default()).toBuilder().request(remaining).build()
        )
    }

    private fun attemptTimeouts(options: RequestOptions): HttpRequestAttemptTimeouts {
        val timeout = options.timeout
        return HttpRequestAttemptTimeouts.create(
            timeout?.connect(),
            timeout?.read(),
            timeout?.write(),
            timeout?.request(),
        )
    }

    private fun sleepAuthenticated(delay: Duration, deadline: Deadline?) {
        val remaining = deadline?.let(::remaining)
        if (remaining != null && delay >= remaining) throw timedOut()
        val closeWaiter = CompletableFuture<Void>()
        if (!trackAuthenticatedRequest(closeWaiter)) {
            throw OpenAIIoException("HTTP client is closed")
        }
        if (closeWaiter.isDone) {
            throw OpenAIIoException("HTTP client is closed")
        }
        if (closed.get()) {
            closeWaiter.cancel(false)
            throw OpenAIIoException("HTTP client is closed")
        }
        val sleep =
            try {
                sleeper.sleepAsync(delay)
            } catch (error: Throwable) {
                closeWaiter.cancel(false)
                throw error
            }
        if (sleep.isDone && !sleep.isCompletedExceptionally) {
            closeWaiter.cancel(false)
            sleep.get()
            return
        }
        try {
            CompletableFuture.anyOf(sleep, closeWaiter).get()
            if (closeWaiter.isDone) throw OpenAIIoException("HTTP client is closed")
        } catch (error: InterruptedException) {
            Thread.currentThread().interrupt()
            throw OpenAIIoException("Interrupted during retry backoff", error)
        } catch (error: ExecutionException) {
            val cause = unwrap(error)
            if (cause is OpenAIIoException && cause.message == "HTTP client is closed") {
                throw cause
            }
            throw OpenAIIoException("Retry backoff failed", cause)
        } finally {
            closeWaiter.cancel(false)
            sleep.cancel(true)
        }
    }

    private fun timedOut() = OpenAIIoException("X.509 request deadline exceeded")

    private data class Deadline(val startedAt: Long, val timeoutNanos: Long)

    private fun shouldRetryAttempt(error: Throwable): Boolean {
        val cause = unwrap(error)
        return if (cause is UnexpectedStatusCodeException) {
            shouldRetry(cause.statusCode(), cause.headers())
        } else shouldRetry(cause)
    }

    private fun unwrap(error: Throwable): Throwable =
        if (error is CompletionException || error is ExecutionException) error.cause ?: error
        else error

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
        val headers = response.headers()
        return shouldRetry(response.statusCode(), headers)
    }

    private fun shouldRetry(statusCode: Int, headers: Headers): Boolean {
        // Note: this is not a standard header
        val shouldRetryHeader = headers.values("X-Should-Retry").getOrNull(0)

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

    private fun getRetryBackoffDuration(
        retries: Int,
        response: HttpResponse? = null,
        error: Throwable? = null,
    ): Duration {
        // About the Retry-After header:
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After
        (response?.headers() ?: (error?.let(::unwrap) as? UnexpectedStatusCodeException)?.headers())
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
}
