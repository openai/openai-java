package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.ByteArrayInputStream
import java.io.OutputStream
import java.time.Clock
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AttemptAuthenticatingRetryingHttpClientTest {
    @Test
    fun replaysOneUnauthorizedResponseEvenWhenTransientRetriesAreDisabled() {
        val transport = ScriptedClient(response(401), response(200))
        val authenticator = CachingAuthenticator()
        val client = client(transport, authenticator, maxRetries = 0)

        client.execute(request()).use { assertThat(it.statusCode()).isEqualTo(200) }

        assertThat(authenticator.exchanges).isEqualTo(2)
        assertThat(authenticator.invalidations).isEqualTo(1)
        assertThat(transport.authorization).containsExactly("Bearer token-1", "Bearer token-2")
        assertThat(transport.retryCounts).containsExactly("0", "0")
    }

    @Test
    fun transientFailuresAndUnauthorizedReplayShareOneRetryLifecycle() {
        val transport =
            ScriptedClient(
                response(500),
                response(401),
                response(500),
                response(500),
                response(200),
            )
        val authenticator = CachingAuthenticator()
        val client = client(transport, authenticator, maxRetries = 2)

        client.executeAsync(request()).get(5, TimeUnit.SECONDS).use {
            assertThat(it.statusCode()).isEqualTo(500)
        }

        assertThat(transport.calls).isEqualTo(4)
        assertThat(authenticator.exchanges).isEqualTo(2)
        assertThat(authenticator.invalidations).isEqualTo(1)
        assertThat(transport.retryCounts).containsExactly("0", "1", "1", "2")
    }

    @Test
    fun exchangeFailureConsumesTheSameRetryBudgetAsApiFailure() {
        val transport = ScriptedClient(response(500), response(200))
        val authenticator = CachingAuthenticator(OpenAIRetryableException("exchange failed"))
        val client = client(transport, authenticator, maxRetries = 1)

        client.execute(request()).use { assertThat(it.statusCode()).isEqualTo(500) }

        assertThat(authenticator.attempts).isEqualTo(2)
        assertThat(transport.calls).isEqualTo(1)
        assertThat(transport.retryCounts).containsExactly("1")
    }

    @Test
    fun nonRepeatableRequestInvalidatesButDoesNotReplay() {
        val transport = ScriptedClient(response(401), response(200))
        val authenticator = CachingAuthenticator()
        val client = client(transport, authenticator, maxRetries = 2)

        client.execute(request(repeatable = false)).use {
            assertThat(it.statusCode()).isEqualTo(401)
        }

        assertThat(transport.calls).isEqualTo(1)
        assertThat(authenticator.invalidations).isEqualTo(1)
    }

    @Test
    fun nonRepeatableRequestCanRetryExchangeBeforeItsOnlyApiDispatch() {
        listOf(false, true).forEach { async ->
            val transport = ScriptedClient(response(200))
            val authenticator = CachingAuthenticator(OpenAIRetryableException("exchange failed"))
            val client = client(transport, authenticator, maxRetries = 1)

            if (async) client.executeAsync(request(repeatable = false)).get().close()
            else client.execute(request(repeatable = false)).close()

            assertThat(authenticator.attempts).isEqualTo(2)
            assertThat(transport.calls).isEqualTo(1)
            assertThat(transport.retryCounts).containsExactly("1")
        }
    }

    @Test
    fun requestThatBecomesNonRepeatableStopsUnauthorizedReplay() {
        listOf(false, true).forEach { async ->
            var repeatabilityChecks = 0
            val statefulRequest =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl("https://mtls.api.openai.com/v1")
                    .body(
                        object : HttpRequestBody {
                            override fun writeTo(outputStream: OutputStream) {}

                            override fun contentLength(): Long = 0

                            override fun contentType(): String? = null

                            override fun repeatable(): Boolean = ++repeatabilityChecks == 1

                            override fun close() {}
                        }
                    )
                    .build()
            val transport = ScriptedClient(response(401), response(401), response(200))
            val authenticator = CachingAuthenticator()
            val client = client(transport, authenticator, maxRetries = 2)

            if (async) {
                client.executeAsync(statefulRequest).get().use {
                    assertThat(it.statusCode()).isEqualTo(401)
                }
            } else {
                client.execute(statefulRequest).use { assertThat(it.statusCode()).isEqualTo(401) }
            }

            assertThat(transport.calls).isEqualTo(2)
            assertThat(repeatabilityChecks).isEqualTo(2)
            assertThat(authenticator.invalidations).isEqualTo(2)
        }
    }

    @Test
    fun authenticatorReplacementWithNonRepeatableBodyStopsUnauthorizedReplay() {
        listOf(false, true).forEach { async ->
            val transport = ScriptedClient(response(401), response(200))
            var invalidations = 0
            val authenticator =
                object : HttpRequestAttemptAuthenticator {
                    fun authenticated(request: HttpRequest): AuthenticatedHttpRequest {
                        val wireRequest =
                            request
                                .toBuilder()
                                .body(
                                    object : HttpRequestBody {
                                        override fun writeTo(outputStream: OutputStream) {}

                                        override fun contentLength(): Long = 0

                                        override fun contentType(): String? = null

                                        override fun repeatable(): Boolean = false

                                        override fun close() {}
                                    }
                                )
                                .build()
                        return AuthenticatedHttpRequest.create(wireRequest) { invalidations++ }
                    }

                    override fun authenticate(
                        request: HttpRequest,
                        timeout: Duration?,
                    ): AuthenticatedHttpRequest = authenticated(request)

                    override fun authenticateAsync(
                        request: HttpRequest,
                        timeout: Duration?,
                    ): CompletableFuture<AuthenticatedHttpRequest> =
                        CompletableFuture.completedFuture(authenticated(request))
                }
            val client = client(transport, authenticator, maxRetries = 2)

            val response =
                if (async) client.executeAsync(request()).get(5, TimeUnit.SECONDS)
                else client.execute(request())
            response.use { assertThat(it.statusCode()).isEqualTo(401) }

            assertThat(transport.calls).isEqualTo(1)
            assertThat(invalidations).isEqualTo(1)
        }
    }

    @Test
    fun ordinaryRetriesPreservePerAttemptRequestTimeout() {
        val timeout = Duration.ofMillis(123)
        listOf(false, true).forEach { async ->
            val transport = ScriptedClient(response(500), response(200))
            val client =
                RetryingHttpClient.builder()
                    .httpClient(transport)
                    .maxRetries(1)
                    .sleeper(ImmediateSleeper)
                    .build()
            val options = RequestOptions.builder().timeout(timeout).build()

            if (async) client.executeAsync(request(), options).get().close()
            else client.execute(request(), options).close()

            assertThat(transport.timeouts).containsExactly(timeout, timeout)
        }
    }

    @Test
    fun ordinaryTransportKeepsLegacyExceptionClassification() {
        listOf(false, true).forEach { async ->
            val failure = statusFailure(503, "X-Should-Retry" to "true")
            var calls = 0
            val transport =
                object : HttpClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse {
                        calls++
                        throw failure
                    }

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> {
                        calls++
                        return CompletableFuture<HttpResponse>().also {
                            it.completeExceptionally(failure)
                        }
                    }

                    override fun close() {}
                }
            val client =
                RetryingHttpClient.builder()
                    .httpClient(transport)
                    .maxRetries(2)
                    .sleeper(ImmediateSleeper)
                    .build()

            if (async) {
                assertThatThrownBy { client.executeAsync(request()).get() }.hasCause(failure)
            } else {
                assertThatThrownBy { client.execute(request()) }.isSameAs(failure)
            }
            assertThat(calls).isEqualTo(1)
        }
    }

    @Test
    fun ordinaryAsyncTransportSynchronousFailureStillEscapes() {
        val failure = OpenAIRetryableException("synchronous failure")
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = throw failure

                override fun close() {}
            }
        val ordinary =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .maxRetries(2)
                .sleeper(ImmediateSleeper)
                .build()

        assertThatThrownBy { ordinary.executeAsync(request()) }.isSameAs(failure)
    }

    @Test
    fun ordinaryAsyncRetryFactoryFailureCompletesTheReturnedFuture() {
        val failure = OpenAIRetryableException("second synchronous failure")
        var calls = 0
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    if (calls++ == 0) return CompletableFuture.completedFuture(response(500))
                    throw failure
                }

                override fun close() {}
            }
        val ordinary =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .maxRetries(2)
                .sleeper(ImmediateSleeper)
                .build()

        assertThatThrownBy { ordinary.executeAsync(request()).get(5, TimeUnit.SECONDS) }
            .hasCause(failure)
        assertThat(calls).isEqualTo(2)
    }

    @Test
    fun ordinaryAsyncSleeperFailureKeepsLegacyRelayExceptionShape() {
        val failure = OpenAIIoException("sleep failed")
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) = error("sync path not expected")

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                    CompletableFuture<Void>().also { it.completeExceptionally(failure) }

                override fun close() {}
            }
        val ordinary =
            RetryingHttpClient.builder()
                .httpClient(ScriptedClient(response(500)))
                .maxRetries(1)
                .sleeper(sleeper)
                .build()

        val observedCompletion = AtomicReference<Throwable>()
        val result =
            ordinary.executeAsync(
                request(),
                RequestOptions.builder().timeout(Duration.ofSeconds(5)).build(),
            )
        result.whenComplete { _, error -> observedCompletion.set(error) }
        val thrown =
            try {
                result.get(5, TimeUnit.SECONDS)
                error("expected retry sleep to fail")
            } catch (error: ExecutionException) {
                error
            }

        assertThat(observedCompletion.get()).isInstanceOf(CompletionException::class.java)
        assertThat(observedCompletion.get().cause).isSameAs(failure)
        assertThat(thrown.cause).isSameAs(failure)
    }

    @Test
    fun ordinaryAsyncSynchronousSleeperFailureKeepsLegacyRelayExceptionShape() {
        val failure = OpenAIIoException("sleep factory failed")
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) = error("sync path not expected")

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> = throw failure

                override fun close() {}
            }
        val ordinary =
            RetryingHttpClient.builder()
                .httpClient(ScriptedClient(response(500)))
                .maxRetries(1)
                .sleeper(sleeper)
                .build()
        val observedCompletion = AtomicReference<Throwable>()
        val result =
            ordinary.executeAsync(
                request(),
                RequestOptions.builder().timeout(Duration.ofSeconds(5)).build(),
            )
        result.whenComplete { _, error -> observedCompletion.set(error) }

        val thrown =
            try {
                result.get(5, TimeUnit.SECONDS)
                error("expected retry sleep to fail")
            } catch (error: ExecutionException) {
                error
            }

        assertThat(observedCompletion.get()).isInstanceOf(CompletionException::class.java)
        assertThat(observedCompletion.get().cause).isSameAs(failure)
        assertThat(thrown.cause).isSameAs(failure)
    }

    @Test
    fun cancellingOrdinaryAsyncResultKeepsLegacyDetachedRetryLifecycle() {
        val first = CompletableFuture<HttpResponse>()
        val secondDispatched = CountDownLatch(1)
        val calls = AtomicInteger()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> =
                    if (calls.incrementAndGet() == 1) first
                    else {
                        secondDispatched.countDown()
                        CompletableFuture.completedFuture(response(200))
                    }

                override fun close() {}
            }
        val ordinary =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .maxRetries(1)
                .sleeper(ImmediateSleeper)
                .build()
        val result = ordinary.executeAsync(request())

        assertThat(result.cancel(true)).isTrue()
        assertThat(first.isCancelled).isFalse()
        first.complete(response(500))

        assertThat(secondDispatched.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(calls.get()).isEqualTo(2)
        assertThat(result.isCancelled).isTrue()
        assertThat(first.isCancelled).isFalse()
    }

    @Test
    fun asyncResponseInspectionFailureCompletesTheReturnedFutureAndClosesTheResponse() {
        val failure = IllegalStateException("cannot inspect status")
        var closes = 0
        val brokenResponse =
            object : HttpResponse {
                override fun statusCode(): Int = throw failure

                override fun headers(): Headers = Headers.builder().build()

                override fun body() = ByteArrayInputStream(ByteArray(0))

                override fun close() {
                    closes++
                }
            }
        val client = client(ScriptedClient(brokenResponse), CachingAuthenticator(), maxRetries = 1)

        assertThatThrownBy { client.executeAsync(request()).get(5, TimeUnit.SECONDS) }
            .hasCause(failure)
        assertThat(closes).isEqualTo(1)
    }

    @Test
    fun syncResponseInspectionFailureClosesTheResponse() {
        val failure = IllegalStateException("cannot inspect status")
        var closes = 0
        val brokenResponse =
            object : HttpResponse {
                override fun statusCode(): Int = throw failure

                override fun headers(): Headers = Headers.builder().build()

                override fun body() = ByteArrayInputStream(ByteArray(0))

                override fun close() {
                    closes++
                }
            }
        val client = client(ScriptedClient(brokenResponse), CachingAuthenticator(), maxRetries = 1)

        assertThatThrownBy { client.execute(request()) }.isSameAs(failure)
        assertThat(closes).isEqualTo(1)
    }

    @Test
    fun closePreservesLegacyOrderAndRepeatabilityAfterFailure() {
        val failure = OpenAIIoException("first close failed")
        var transportCloses = 0
        var sleeperCloses = 0
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = error("not expected")

                override fun close() {
                    if (transportCloses++ == 0) throw failure
                }
            }
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) = error("not expected")

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                    error("not expected")

                override fun close() {
                    sleeperCloses++
                }
            }
        val client = RetryingHttpClient.builder().httpClient(transport).sleeper(sleeper).build()

        assertThatThrownBy { client.close() }.isSameAs(failure)
        assertThat(transportCloses).isEqualTo(1)
        assertThat(sleeperCloses).isZero()

        client.close()
        client.close()

        assertThat(transportCloses).isEqualTo(3)
        assertThat(sleeperCloses).isEqualTo(2)
    }

    @Test
    fun authenticatedCloseAttemptsEveryOwnedComponentAfterFailure() {
        val failure = OpenAIIoException("authenticator close failed")
        var authenticatorCloses = 0
        var transportCloses = 0
        var sleeperCloses = 0
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}

                override fun close() {
                    authenticatorCloses++
                    throw failure
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = error("not expected")

                override fun close() {
                    transportCloses++
                    throw failure
                }
            }
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) = error("not expected")

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                    error("not expected")

                override fun close() {
                    sleeperCloses++
                }
            }
        val client =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .attemptAuthenticator(authenticator)
                .sleeper(sleeper)
                .build()

        assertThatThrownBy { client.close() }.isSameAs(failure)
        assertThat(authenticatorCloses).isEqualTo(1)
        assertThat(transportCloses).isEqualTo(1)
        assertThat(sleeperCloses).isEqualTo(1)
        assertThat(failure.suppressed).isEmpty()
    }

    @Test
    fun finiteDeadlineWorksWhenMonotonicClockIsNegative() {
        val times = ArrayDeque(listOf(-100L, -90L))
        val transport = ScriptedClient(response(200))
        val authenticator = CachingAuthenticator()
        val client =
            RetryingHttpClientOrchestrator(
                httpClient = transport,
                sleeper = ImmediateSleeper,
                clock = Clock.systemUTC(),
                maxRetries = 0,
                idempotencyHeader = null,
                attemptAuthenticator = authenticator,
                nanoTime = { times.removeFirst() },
            )
        val options = RequestOptions.builder().timeout(Duration.ofNanos(10)).build()

        assertThatThrownBy { client.execute(request(), options) }
            .isInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("deadline")
        assertThat(authenticator.attempts).isZero()
        assertThat(transport.calls).isZero()
    }

    @Test
    fun negativeOverflowingDeadlineExpiresBeforeAuthentication() {
        val transport = ScriptedClient(response(200))
        val authenticator = CachingAuthenticator()
        val client = client(transport, authenticator, maxRetries = 0)
        val options = RequestOptions.builder().timeout(Duration.ofSeconds(Long.MIN_VALUE)).build()

        assertThatThrownBy { client.execute(request(), options) }
            .isInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("deadline")
        assertThat(authenticator.attempts).isZero()
        assertThat(transport.calls).isZero()
    }

    @Test
    fun ordinaryResponseInspectionKeepsLegacyBoundaryOrderAndRetryCount() {
        listOf(false, true).forEach { async ->
            val events = mutableListOf<String>()
            val failure = OpenAIIoException("headers unavailable")
            var calls = 0
            val first =
                object : HttpResponse {
                    override fun statusCode(): Int {
                        events += "status-1"
                        return 500
                    }

                    override fun headers(): Headers {
                        events += "headers-1"
                        throw failure
                    }

                    override fun body() = ByteArrayInputStream(ByteArray(0))

                    override fun close() {}
                }
            val second =
                object : HttpResponse {
                    override fun statusCode(): Int {
                        events += "status-2"
                        return 200
                    }

                    override fun headers(): Headers {
                        events += "headers-2"
                        return Headers.builder().build()
                    }

                    override fun body() = ByteArrayInputStream(ByteArray(0))

                    override fun close() {}
                }
            val responses = ArrayDeque(listOf(first, second))
            val retryCounts = mutableListOf<String?>()
            val transport =
                object : HttpClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse {
                        events += "transport-${++calls}"
                        retryCounts +=
                            request.headers.values("X-Stainless-Retry-Count").singleOrNull()
                        return responses.removeFirst()
                    }

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> =
                        CompletableFuture.completedFuture(execute(request, requestOptions))

                    override fun close() {}
                }
            val client =
                RetryingHttpClient.builder()
                    .httpClient(transport)
                    .maxRetries(2)
                    .sleeper(ImmediateSleeper)
                    .build()

            if (async) {
                assertThatThrownBy { client.executeAsync(request()).get(5, TimeUnit.SECONDS) }
                    .hasCause(failure)
                assertThat(events).containsExactly("transport-1", "headers-1")
                assertThat(retryCounts).containsExactly("0")
            } else {
                client.execute(request()).close()
                assertThat(events).containsExactly("transport-1", "headers-1", "transport-2")
                assertThat(retryCounts).containsExactly("0", "2")
            }
        }
    }

    @Test
    fun ordinaryRepeatabilityKeepsLegacyPerAttemptOrdering() {
        listOf(false, true).forEach { async ->
            val events = mutableListOf<String>()
            var repeatabilityChecks = 0
            val statefulRequest =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl("https://api.openai.com/v1")
                    .body(
                        object : HttpRequestBody {
                            override fun writeTo(outputStream: OutputStream) {}

                            override fun contentLength(): Long = 0

                            override fun contentType(): String? = null

                            override fun repeatable(): Boolean {
                                events += "repeatable-${++repeatabilityChecks}"
                                return repeatabilityChecks == 1
                            }

                            override fun close() {}
                        }
                    )
                    .build()
            var calls = 0
            fun retryableResponse(attempt: Int): HttpResponse =
                object : HttpResponse {
                    override fun statusCode(): Int {
                        events += "status-$attempt"
                        return 500
                    }

                    override fun headers(): Headers {
                        events += "headers-$attempt"
                        return Headers.builder().build()
                    }

                    override fun body() = ByteArrayInputStream(ByteArray(0))

                    override fun close() {}
                }
            val transport =
                object : HttpClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse {
                        events += "transport-${++calls}"
                        return retryableResponse(calls)
                    }

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> =
                        CompletableFuture.completedFuture(execute(request, requestOptions))

                    override fun close() {}
                }
            val client =
                RetryingHttpClient.builder()
                    .httpClient(transport)
                    .maxRetries(2)
                    .sleeper(ImmediateSleeper)
                    .build()

            if (async) client.executeAsync(statefulRequest).get().close()
            else client.execute(statefulRequest).close()

            val expected =
                if (async)
                    listOf(
                        "transport-1",
                        "repeatable-1",
                        "headers-1",
                        "status-1",
                        "headers-1",
                        "transport-2",
                        "repeatable-2",
                    )
                else
                    listOf(
                        "repeatable-1",
                        "transport-1",
                        "headers-1",
                        "status-1",
                        "headers-1",
                        "repeatable-2",
                        "transport-2",
                    )
            assertThat(events).containsExactlyElementsOf(expected)
            assertThat(calls).isEqualTo(2)
        }
    }

    @Test
    fun retryAfterCannotExtendTheRequestDeadline() {
        val transport = ScriptedClient(response(503, "Retry-After-Ms" to "1000"))
        val authenticator = CachingAuthenticator()
        val client = client(transport, authenticator, maxRetries = 2)
        val options = RequestOptions.builder().timeout(Duration.ofMillis(100)).build()

        assertThatThrownBy { client.execute(request(), options) }
            .isInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("deadline")
        assertThat(transport.calls).isEqualTo(1)
    }

    @Test
    fun cancellingAsyncRequestCancelsItsActiveAuthenticationWaiter() {
        val waiter = CompletableFuture<AuthenticatedHttpRequest>()
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = error("sync path not expected")

                override fun authenticateAsync(
                    request: HttpRequest,
                    timeout: Duration?,
                ): CompletableFuture<AuthenticatedHttpRequest> = waiter
            }
        val client = client(ScriptedClient(response(200)), authenticator, maxRetries = 2)

        val result = client.executeAsync(request())
        result.cancel(true)

        assertThat(waiter.isCancelled).isTrue()
    }

    @Test
    fun authenticationTimeIsDeductedBeforeSyncAndAsyncApiDispatch() {
        val transport = ScriptedClient(response(200), response(200))
        val authenticator = SlowAuthenticator(Duration.ofMillis(60))
        val client = client(transport, authenticator, maxRetries = 0)
        val options = RequestOptions.builder().timeout(Duration.ofMillis(300)).build()

        client.execute(request(), options).close()
        client.executeAsync(request(), options).get(5, TimeUnit.SECONDS).close()

        assertThat(transport.timeouts).allSatisfy {
            assertThat(it).isLessThan(Duration.ofMillis(270))
        }
    }

    @Test
    fun exhaustedDeadlineDoesNotBecomeAnUnlimitedApiCall() {
        val transport = ScriptedClient(response(200), response(200))
        val authenticator = SlowAuthenticator(Duration.ofMillis(50))
        val client = client(transport, authenticator, maxRetries = 0)
        val options = RequestOptions.builder().timeout(Duration.ofMillis(10)).build()

        assertThatThrownBy { client.execute(request(), options) }
            .isInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("deadline")
        assertThatThrownBy { client.executeAsync(request(), options).get(5, TimeUnit.SECONDS) }
            .hasCauseInstanceOf(OpenAIIoException::class.java)
        assertThat(transport.calls).isZero()
    }

    @Test
    fun issuerRetryOverridesAndRetryAfterApplyToExchangeFailures() {
        val retryAfter = RecordingSleeper()
        val retrying =
            RetryingHttpClient.builder()
                .httpClient(ScriptedClient(response(200)))
                .attemptAuthenticator(
                    CachingAuthenticator(
                        statusFailure(400, "X-Should-Retry" to "true", "Retry-After-Ms" to "17")
                    )
                )
                .maxRetries(1)
                .sleeper(retryAfter)
                .build()

        retrying.execute(request()).close()

        assertThat(retryAfter.delays).containsExactly(Duration.ofMillis(17))

        val doNotRetry = CachingAuthenticator(statusFailure(503, "X-Should-Retry" to "false"))
        val rejecting = client(ScriptedClient(response(200)), doNotRetry, maxRetries = 1)
        assertThatThrownBy { rejecting.execute(request()) }
            .isInstanceOf(UnexpectedStatusCodeException::class.java)
        assertThat(doNotRetry.attempts).isEqualTo(1)
    }

    @Test
    fun synchronousAsyncStageFailuresCompleteThroughTheRetryStateMachine() {
        var authenticationAttempts = 0
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}

                override fun authenticateAsync(
                    request: HttpRequest,
                    timeout: Duration?,
                ): CompletableFuture<AuthenticatedHttpRequest> {
                    if (authenticationAttempts++ == 0) {
                        throw OpenAIRetryableException("synchronous authentication failure")
                    }
                    return CompletableFuture.completedFuture(
                        AuthenticatedHttpRequest.create(request) {}
                    )
                }
            }
        val transport =
            object : HttpClient {
                var attempts = 0

                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    if (attempts++ == 0) {
                        throw OpenAIRetryableException("synchronous transport failure")
                    }
                    return CompletableFuture.completedFuture(response(200))
                }

                override fun close() {}
            }
        val client = client(transport, authenticator, maxRetries = 2)

        client.executeAsync(request()).get(5, TimeUnit.SECONDS).close()

        assertThat(authenticationAttempts).isEqualTo(3)
        assertThat(transport.attempts).isEqualTo(2)
    }
}
