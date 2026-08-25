package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.RetryingHttpClient
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509AttemptAuthenticatorTest {
    @Test
    fun oneCancelledWaiterDoesNotCancelSharedExchange() {
        val exchange = CancellationFuture<X509AccessToken>()
        val authenticator = x509AttemptAuthenticatorForTest { exchange }
        val cancelled = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        val surviving = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        cancelled.cancel(true)
        exchange.complete(X509AccessToken("survivingtoken", Duration.ofMinutes(1)))

        assertThat(exchange.isCancelled).isFalse()
        assertThat(authorization(surviving.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer survivingtoken")
        authenticator.close()
    }

    @Test
    fun lastCancelledWaiterCancelsExchangeAndCannotInstallLateToken() {
        val first = CancellationFuture<X509AccessToken>()
        val second = CancellationFuture<X509AccessToken>()
        val exchanges = ArrayDeque(listOf(first, second))
        val authenticator = x509AttemptAuthenticatorForTest { exchanges.removeFirst() }
        val cancelled = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        cancelled.cancel(true)

        assertThat(first.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(first.complete(X509AccessToken("latetoken", Duration.ofMinutes(1)))).isFalse()
        val replacement = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        second.complete(X509AccessToken("replacementtoken", Duration.ofMinutes(1)))
        assertThat(authorization(replacement.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer replacementtoken")
        authenticator.close()
    }

    @Test
    fun timingOutOneWaiterLeavesTheSharedExchangeForOtherWaiters() {
        val exchange = CancellationFuture<X509AccessToken>()
        val authenticator = x509AttemptAuthenticatorForTest { exchange }
        val surviving = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        val timedOut = authenticator.authenticateAsync(request(), Duration.ofMillis(20))

        assertThatThrownBy { timedOut.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("deadline")
        assertThat(exchange.isCancelled).isFalse()
        exchange.complete(X509AccessToken("survivingtoken", Duration.ofMinutes(1)))
        assertThat(authorization(surviving.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer survivingtoken")
        authenticator.close()
    }

    @Test
    fun interruptingSyncWaiterCancelsItsLastExchange() {
        val exchange = CancellationFuture<X509AccessToken>()
        val started = CountDownLatch(1)
        val authenticator = x509AttemptAuthenticatorForTest {
            started.countDown()
            exchange
        }
        val executor = Executors.newSingleThreadExecutor()
        val waiter = executor.submit { authenticator.authenticate(request(), null) }

        try {
            assertThat(started.await(5, TimeUnit.SECONDS)).isTrue()
            waiter.cancel(true)
            assertThat(exchange.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
        } finally {
            authenticator.close()
            executor.shutdownNow()
        }
    }

    @Test
    fun failedRefreshCannotRestoreConcurrentlyRejectedFallback() {
        val now = AtomicLong()
        val initial = CompletableFuture<X509AccessToken>()
        val refresh = CompletableFuture<X509AccessToken>()
        val replacement = CompletableFuture<X509AccessToken>()
        val exchanges = ArrayDeque(listOf(initial, refresh, replacement))
        val authenticator =
            x509AttemptAuthenticatorForTest(nanoTime = now::get) { exchanges.removeFirst() }
        val installed = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        initial.complete(X509AccessToken("fallbacktoken", Duration.ofMillis(500)))
        val rejected = installed.get(5, TimeUnit.SECONDS)
        now.set(Duration.ofMillis(425).toNanos())

        val refreshing = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        rejected.onUnauthorized()
        refresh.completeExceptionally(OpenAIRetryableException("refresh failed"))

        assertThatThrownBy { refreshing.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("refresh failed")
        val afterRejection = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        replacement.complete(X509AccessToken("replacementtoken", Duration.ofMinutes(1)))
        assertThat(authorization(afterRejection.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer replacementtoken")
        authenticator.close()
    }

    @Test
    fun refreshFailureCooldownCannotServeFallbackPastExpiry() {
        val now = AtomicLong()
        val initial = CompletableFuture<X509AccessToken>()
        val refresh = CompletableFuture<X509AccessToken>()
        val replacement = CompletableFuture<X509AccessToken>()
        val exchanges = ArrayDeque(listOf(initial, refresh, replacement))
        val authenticator =
            x509AttemptAuthenticatorForTest(nanoTime = now::get) { exchanges.removeFirst() }
        val installed = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        initial.complete(X509AccessToken("fallbacktoken", Duration.ofMillis(500)))
        installed.get(5, TimeUnit.SECONDS)
        now.set(Duration.ofMillis(425).toNanos())

        val fallback = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        refresh.completeExceptionally(OpenAIRetryableException("refresh failed"))
        assertThat(authorization(fallback.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer fallbacktoken")
        now.set(Duration.ofMillis(501).toNanos())

        val afterExpiry = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        assertThat(afterExpiry.isDone).isFalse()
        replacement.complete(X509AccessToken("replacementtoken", Duration.ofMinutes(1)))
        assertThat(authorization(afterExpiry.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer replacementtoken")
        authenticator.close()
    }

    @Test
    fun delayedExchangeCannotExtendTokenLifetime() {
        val now = AtomicLong()
        val exchange = CompletableFuture<X509AccessToken>()
        val authenticator = x509AttemptAuthenticatorForTest(nanoTime = now::get) { exchange }
        val authentication = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        now.set(Duration.ofSeconds(2).toNanos())
        exchange.complete(X509AccessToken("expiredtoken", Duration.ofSeconds(1)))

        assertThatThrownBy { authentication.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("expired during exchange")
        authenticator.close()
    }

    @Test
    fun exchangeCannotPublishTokenAfterCloseStarts() {
        val exchange = CompletableFuture<X509AccessToken>()
        lateinit var authenticator: com.openai.core.http.HttpRequestAttemptAuthenticator
        authenticator =
            x509AttemptAuthenticatorForTest(beforeTokenPublication = { authenticator.close() }) {
                exchange
            }
        val authentication = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        exchange.complete(X509AccessToken("latetoken", Duration.ofMinutes(1)))

        assertThatThrownBy { authentication.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("HTTP client is closed")
    }

    @Test
    fun closeBeforeTimeoutSchedulingDoesNotExposeSchedulerRejection() {
        val exchange = CancellationFuture<X509AccessToken>()
        lateinit var authenticator: com.openai.core.http.HttpRequestAttemptAuthenticator
        authenticator =
            x509AttemptAuthenticatorForTest(
                beforeWaiterTimeoutSchedule = { authenticator.close() }
            ) {
                exchange
            }

        val authentication = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        assertThatThrownBy { authentication.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("HTTP client is closed")
        assertThat(exchange.isCancelled).isTrue()
    }

    @Test
    fun cachedTokenRemainsFreshAcrossNanoTimeRollover() {
        val now = AtomicLong(Long.MAX_VALUE - 100)
        var exchanges = 0
        val authenticator =
            x509AttemptAuthenticatorForTest(nanoTime = now::get) {
                exchanges++
                CompletableFuture.completedFuture(
                    X509AccessToken("rollovertoken", Duration.ofNanos(500))
                )
            }

        assertThat(
                authorization(
                    authenticator
                        .authenticateAsync(request(), Duration.ofSeconds(5))
                        .get(5, TimeUnit.SECONDS)
                )
            )
            .isEqualTo("Bearer rollovertoken")
        now.addAndGet(200)
        assertThat(
                authorization(
                    authenticator
                        .authenticateAsync(request(), Duration.ofSeconds(5))
                        .get(5, TimeUnit.SECONDS)
                )
            )
            .isEqualTo("Bearer rollovertoken")
        assertThat(exchanges).isEqualTo(1)
        authenticator.close()
    }

    @Test
    fun refreshFailureCooldownAndExpiryRemainOrderedAcrossNanoTimeRollover() {
        val now = AtomicLong(Long.MAX_VALUE - 100)
        val refresh = CompletableFuture<X509AccessToken>()
        val replacement = CompletableFuture<X509AccessToken>()
        val exchanges =
            ArrayDeque(
                listOf(
                    CompletableFuture.completedFuture(
                        X509AccessToken("fallbacktoken", Duration.ofNanos(500))
                    ),
                    refresh,
                    replacement,
                )
            )
        val authenticator =
            x509AttemptAuthenticatorForTest(nanoTime = now::get) { exchanges.removeFirst() }
        authenticator.authenticateAsync(request(), Duration.ofSeconds(5)).get(5, TimeUnit.SECONDS)
        now.addAndGet(425)

        val fallback = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        refresh.completeExceptionally(OpenAIRetryableException("refresh failed"))
        assertThat(authorization(fallback.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer fallbacktoken")
        now.addAndGet(50)
        assertThat(
                authorization(
                    authenticator
                        .authenticateAsync(request(), Duration.ofSeconds(5))
                        .get(5, TimeUnit.SECONDS)
                )
            )
            .isEqualTo("Bearer fallbacktoken")
        now.addAndGet(26)

        val afterExpiry = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        assertThat(afterExpiry.isDone).isFalse()
        replacement.complete(X509AccessToken("replacementtoken", Duration.ofMinutes(1)))
        assertThat(authorization(afterExpiry.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer replacementtoken")
        authenticator.close()
    }

    @Test
    fun rejectedCompletedGenerationIsNotReusedByImmediateReplay() {
        listOf(false, true).forEach { async ->
            val firstExchange = CompletableFuture<X509AccessToken>()
            val firstExchangeStarted = CountDownLatch(1)
            val replacementExchangeStarted = CountDownLatch(1)
            val publishedBeforeClear = CountDownLatch(1)
            val allowRefreshClear = CountDownLatch(1)
            val exchangeCalls = AtomicInteger()
            val publicationCalls = AtomicInteger()
            val authenticator =
                x509AttemptAuthenticatorForTest(
                    beforeRefreshCleared = {
                        if (publicationCalls.incrementAndGet() == 1) {
                            publishedBeforeClear.countDown()
                            allowRefreshClear.await(5, TimeUnit.SECONDS)
                        }
                    }
                ) {
                    if (exchangeCalls.getAndIncrement() == 0) {
                        firstExchangeStarted.countDown()
                        firstExchange
                    } else {
                        replacementExchangeStarted.countDown()
                        CompletableFuture.completedFuture(
                            X509AccessToken("replacementtoken", Duration.ofMinutes(1))
                        )
                    }
                }
            val transport = ImmediateUnauthorizedThenSuccessClient()
            val client =
                RetryingHttpClient.builder()
                    .httpClient(transport)
                    .attemptAuthenticator(authenticator)
                    .maxRetries(0)
                    .build()
            val executor = Executors.newSingleThreadExecutor()
            val completionExecutor = Executors.newSingleThreadExecutor()

            try {
                val result =
                    if (async) {
                        client.executeAsync(request())
                    } else {
                        CompletableFuture.supplyAsync({ client.execute(request()) }, executor)
                    }
                assertThat(firstExchangeStarted.await(5, TimeUnit.SECONDS)).isTrue()
                val completion =
                    completionExecutor.submit {
                        firstExchange.complete(
                            X509AccessToken("rejectedtoken", Duration.ofMinutes(1))
                        )
                    }
                assertThat(publishedBeforeClear.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(replacementExchangeStarted.await(5, TimeUnit.SECONDS)).isTrue()
                allowRefreshClear.countDown()
                completion.get(5, TimeUnit.SECONDS)
                val response = result.get(5, TimeUnit.SECONDS)
                response.close()

                assertThat(transport.authorization)
                    .containsExactly("Bearer rejectedtoken", "Bearer replacementtoken")
            } finally {
                allowRefreshClear.countDown()
                client.close()
                executor.shutdownNow()
                completionExecutor.shutdownNow()
            }
        }
    }

    @Test
    fun completedWaitersAreRemovedFromSchedulerQueue() {
        val exchange = CompletableFuture<X509AccessToken>()
        lateinit var scheduler: ScheduledThreadPoolExecutor
        val authenticator =
            x509AttemptAuthenticatorForTest(schedulerObserver = { scheduler = it }) { exchange }
        val waiters =
            List(100) { authenticator.authenticateAsync(request(), Duration.ofMinutes(10)) }

        exchange.complete(X509AccessToken("sharedtoken", Duration.ofMinutes(1)))
        waiters.forEach { it.get(5, TimeUnit.SECONDS) }

        assertThat(scheduler.removeOnCancelPolicy).isTrue()
        assertThat(scheduler.queue).isEmpty()
        authenticator.close()
    }

    private fun request(): HttpRequest =
        HttpRequest.builder().method(HttpMethod.GET).baseUrl(X509_API_BASE_URL).build()

    private fun authorization(authenticated: com.openai.core.http.AuthenticatedHttpRequest) =
        authenticated.request().headers.values("Authorization").single()

    private class CancellationFuture<T> : CompletableFuture<T>() {
        val cancelled = CountDownLatch(1)

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean =
            super.cancel(mayInterruptIfRunning).also { if (it) cancelled.countDown() }
    }

    private class ImmediateUnauthorizedThenSuccessClient : HttpClient {
        val authorization = mutableListOf<String>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            next(request)

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(next(request))

        private fun next(request: HttpRequest): HttpResponse {
            authorization += request.headers.values("Authorization").single()
            val status = if (authorization.size == 1) 401 else 200
            return object : HttpResponse {
                override fun statusCode(): Int = status

                override fun headers(): Headers = Headers.builder().build()

                override fun body() = ByteArrayInputStream(ByteArray(0))

                override fun close() {}
            }
        }

        override fun close() {}
    }
}
