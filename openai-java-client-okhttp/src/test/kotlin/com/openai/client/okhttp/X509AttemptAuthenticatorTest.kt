package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.Timeout
import com.openai.core.http.AuthenticatedHttpRequest
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAttemptTimeouts
import com.openai.core.http.HttpResponse
import com.openai.core.http.RetryingHttpClient
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.io.IOException
import java.security.cert.CertPathBuilderException
import java.security.cert.CertificateException
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLPeerUnverifiedException
import javax.net.ssl.SSLProtocolException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509AttemptAuthenticatorTest {
    @Test
    fun forwardsEffectiveRequestOptionsToIssuerExchange() {
        val observed = CompletableFuture<RequestOptions>()
        val authenticator =
            x509AttemptAuthenticatorForTest(exchangeOptionsObserver = { observed.complete(it) }) {
                CompletableFuture.completedFuture(
                    X509AccessToken("optionstoken", Duration.ofMinutes(1))
                )
            }
        val timeout =
            Timeout.builder()
                .connect(Duration.ofMillis(11))
                .read(Duration.ofMillis(22))
                .write(Duration.ofMillis(33))
                .request(Duration.ofMillis(250))
                .build()
        val timeouts =
            HttpRequestAttemptTimeouts.create(
                timeout.connect(),
                timeout.read(),
                timeout.write(),
                timeout.request(),
            )

        val authenticated = authenticator.authenticateAsync(request(), timeouts)

        assertThat(authorization(authenticated.get(5, TimeUnit.SECONDS)))
            .isEqualTo("Bearer optionstoken")
        val issuerOptions = observed.get(5, TimeUnit.SECONDS)
        assertThat(issuerOptions.timeout).isEqualTo(timeout)
        authenticator.close()
    }

    @Test
    fun oneCancelledWaiterDoesNotCancelSharedExchange() {
        val exchange = CancellationFuture<X509AccessToken>()
        val authenticator = x509AttemptAuthenticatorForTest { exchange }
        val cancelled = authenticator.authenticateAsync(request(), null)
        val surviving = authenticator.authenticateAsync(request(), null)

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
    fun shortFirstAsyncWaiterCannotTruncateLongerRefreshGeneration() {
        val shortExchange = CancellationFuture<X509AccessToken>()
        val longExchange = CancellationFuture<X509AccessToken>()
        val exchanges = ArrayDeque(listOf(shortExchange, longExchange))
        val authenticator = x509AttemptAuthenticatorForTest { exchanges.removeFirst() }

        val short = authenticator.authenticateAsync(request(), Duration.ofMillis(200))
        val long = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        assertThatThrownBy { short.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("deadline")
        assertThat(shortExchange.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
        longExchange.complete(X509AccessToken("longtoken", Duration.ofMinutes(1)))
        assertThat(authorization(long.get(5, TimeUnit.SECONDS))).isEqualTo("Bearer longtoken")
        authenticator.close()
    }

    @Test
    fun delayedAsyncWaiterUsesActiveRefreshRemainingBudget() {
        val now = AtomicLong()
        val firstExchange = CompletableFuture<X509AccessToken>()
        val secondExchange = CompletableFuture<X509AccessToken>()
        val exchanges = ArrayDeque(listOf(firstExchange, secondExchange))
        val exchangeOptions = mutableListOf<RequestOptions>()
        val authenticator =
            x509AttemptAuthenticatorForTest(
                nanoTime = now::get,
                exchangeOptionsObserver = exchangeOptions::add,
            ) {
                exchanges.removeFirst()
            }
        val first = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        now.set(Duration.ofSeconds(3).toNanos())
        val delayed = authenticator.authenticateAsync(request(), Duration.ofSeconds(4))

        now.set(Duration.ofSeconds(4).toNanos())
        firstExchange.completeExceptionally(OpenAIIoException("first exchange timed out"))
        assertThatThrownBy { first.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasCauseInstanceOf(OpenAIIoException::class.java)
        secondExchange.complete(X509AccessToken("delayedtoken", Duration.ofMinutes(1)))

        assertThat(authorization(delayed.get(5, TimeUnit.SECONDS))).isEqualTo("Bearer delayedtoken")
        assertThat(exchangeOptions.map { it.timeout?.request() })
            .containsExactly(Duration.ofSeconds(5), Duration.ofSeconds(3))
        assertThat(exchanges).isEmpty()
        authenticator.close()
    }

    @Test
    fun exhaustedDelayedAsyncWaiterDoesNotStartAnotherRefresh() {
        val now = AtomicLong()
        val firstExchange = CompletableFuture<X509AccessToken>()
        val exchangeCalls = AtomicInteger()
        val authenticator =
            x509AttemptAuthenticatorForTest(
                nanoTime = now::get,
                exchangeOptionsObserver = { exchangeCalls.incrementAndGet() },
            ) {
                firstExchange
            }
        val first = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))
        now.set(Duration.ofSeconds(3).toNanos())
        val exhausted = authenticator.authenticateAsync(request(), Duration.ofSeconds(4))

        now.set(Duration.ofSeconds(7).toNanos())
        firstExchange.completeExceptionally(OpenAIIoException("first exchange timed out"))

        assertThatThrownBy { first.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasCauseInstanceOf(OpenAIIoException::class.java)
        assertThatThrownBy { exhausted.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasCauseInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("deadline")
        assertThat(exchangeCalls).hasValue(1)
        authenticator.close()
    }

    @Test
    fun shortFirstSyncWaiterCannotTruncateLongerRefreshGeneration() {
        val shortExchange = CancellationFuture<X509AccessToken>()
        val longExchange = CancellationFuture<X509AccessToken>()
        val firstStarted = CountDownLatch(1)
        val secondStarted = CountDownLatch(1)
        val exchanges = ArrayDeque(listOf(shortExchange, longExchange))
        val exchangeCount = AtomicInteger()
        val authenticator = x509AttemptAuthenticatorForTest {
            if (exchangeCount.getAndIncrement() == 0) firstStarted.countDown()
            else secondStarted.countDown()
            exchanges.removeFirst()
        }
        val executor = Executors.newFixedThreadPool(2)

        try {
            val short =
                executor.submit { authenticator.authenticate(request(), Duration.ofMillis(200)) }
            assertThat(firstStarted.await(5, TimeUnit.SECONDS)).isTrue()
            val long: java.util.concurrent.Future<AuthenticatedHttpRequest> =
                executor.submit(
                    java.util.concurrent.Callable {
                        authenticator.authenticate(request(), Duration.ofSeconds(5))
                    }
                )
            assertThat(secondStarted.await(5, TimeUnit.SECONDS)).isTrue()

            assertThatThrownBy { short.get(5, TimeUnit.SECONDS) }
                .isInstanceOf(ExecutionException::class.java)
                .hasCauseInstanceOf(OpenAIIoException::class.java)
                .hasMessageContaining("deadline")
            assertThat(shortExchange.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
            longExchange.complete(X509AccessToken("longtoken", Duration.ofMinutes(1)))
            assertThat(authorization(long.get(5, TimeUnit.SECONDS))).isEqualTo("Bearer longtoken")
        } finally {
            authenticator.close()
            executor.shutdownNow()
        }
    }

    @Test
    fun delayedSyncWaiterUsesActiveRefreshRemainingBudget() {
        val now = AtomicLong()
        val firstExchange = CompletableFuture<X509AccessToken>()
        val secondExchange = CompletableFuture<X509AccessToken>()
        val exchanges = ArrayDeque(listOf(firstExchange, secondExchange))
        val exchangeOptions = mutableListOf<RequestOptions>()
        val firstStarted = CountDownLatch(1)
        val incompatibleRefreshInspected = CountDownLatch(1)
        val delayedThread = AtomicReference<Thread?>()
        val delayedClockReads = AtomicInteger()
        val authenticator =
            x509AttemptAuthenticatorForTest(
                nanoTime = {
                    if (
                        Thread.currentThread() === delayedThread.get() &&
                            delayedClockReads.incrementAndGet() == 2
                    ) {
                        incompatibleRefreshInspected.countDown()
                    }
                    now.get()
                },
                exchangeOptionsObserver = exchangeOptions::add,
            ) {
                firstStarted.countDown()
                exchanges.removeFirst()
            }
        val executor = Executors.newFixedThreadPool(2)

        try {
            val first =
                executor.submit(
                    java.util.concurrent.Callable {
                        authenticator.authenticate(request(), Duration.ofSeconds(5))
                    }
                )
            assertThat(firstStarted.await(5, TimeUnit.SECONDS)).isTrue()
            now.set(Duration.ofSeconds(3).toNanos())
            val delayed =
                executor.submit(
                    java.util.concurrent.Callable {
                        delayedThread.set(Thread.currentThread())
                        authenticator.authenticate(request(), Duration.ofSeconds(4))
                    }
                )
            assertThat(incompatibleRefreshInspected.await(5, TimeUnit.SECONDS)).isTrue()

            now.set(Duration.ofSeconds(4).toNanos())
            firstExchange.completeExceptionally(OpenAIIoException("first exchange timed out"))
            assertThatThrownBy { first.get(5, TimeUnit.SECONDS) }
                .isInstanceOf(ExecutionException::class.java)
                .hasCauseInstanceOf(OpenAIIoException::class.java)
            secondExchange.complete(X509AccessToken("delayedtoken", Duration.ofMinutes(1)))

            assertThat(authorization(delayed.get(5, TimeUnit.SECONDS)))
                .isEqualTo("Bearer delayedtoken")
            assertThat(exchangeOptions.map { it.timeout?.request() })
                .containsExactly(Duration.ofSeconds(5), Duration.ofSeconds(3))
            assertThat(exchanges).isEmpty()
        } finally {
            authenticator.close()
            executor.shutdownNow()
        }
    }

    @Test
    fun closeFailsAttachedAndIncompatibleAsyncWaitersAsIo() {
        val exchange = CancellationFuture<X509AccessToken>()
        val exchanges = AtomicInteger()
        val authenticator = x509AttemptAuthenticatorForTest {
            exchanges.incrementAndGet()
            exchange
        }
        val attached = authenticator.authenticateAsync(request(), Duration.ofSeconds(1))
        val awaiting = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        authenticator.close()

        listOf(attached, awaiting).forEach { waiter ->
            assertThatThrownBy { waiter.get(5, TimeUnit.SECONDS) }
                .isInstanceOf(ExecutionException::class.java)
                .hasCauseInstanceOf(OpenAIIoException::class.java)
                .hasMessageContaining("closed")
        }
        assertThat(exchanges).hasValue(1)
    }

    @Test
    fun closeFailsAttachedAndIncompatibleSyncWaitersAsIo() {
        val exchange = CancellationFuture<X509AccessToken>()
        val scheduled = CountDownLatch(2)
        val exchangeStarted = CountDownLatch(1)
        val exchanges = AtomicInteger()
        val authenticator =
            x509AttemptAuthenticatorForTest(
                beforeWaiterTimeoutSchedule = { scheduled.countDown() }
            ) {
                exchanges.incrementAndGet()
                exchangeStarted.countDown()
                exchange
            }
        val executor = Executors.newFixedThreadPool(2)

        try {
            val attached =
                executor.submit(
                    java.util.concurrent.Callable {
                        authenticator.authenticate(request(), Duration.ofSeconds(1))
                    }
                )
            assertThat(exchangeStarted.await(5, TimeUnit.SECONDS)).isTrue()
            val awaiting =
                executor.submit(
                    java.util.concurrent.Callable {
                        authenticator.authenticate(request(), Duration.ofSeconds(5))
                    }
                )
            assertThat(scheduled.await(5, TimeUnit.SECONDS)).isTrue()

            authenticator.close()

            listOf(attached, awaiting).forEach { waiter ->
                assertThatThrownBy { waiter.get(5, TimeUnit.SECONDS) }
                    .isInstanceOf(ExecutionException::class.java)
                    .hasCauseInstanceOf(OpenAIIoException::class.java)
                    .hasMessageContaining("closed")
            }
            assertThat(exchanges).hasValue(1)
        } finally {
            authenticator.close()
            executor.shutdownNow()
        }
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
    fun syncAndAsyncPermanentTlsRefreshFailureCannotFallbackToCachedBearer() {
        val tlsFailures =
            listOf<() -> Throwable>(
                {
                    SSLHandshakeException("untrusted issuer certificate").apply {
                        initCause(CertificateException("certificate path rejected"))
                    }
                },
                { CertPathBuilderException("issuer certificate path could not be built") },
                { SSLPeerUnverifiedException("issuer hostname mismatch") },
                { SSLProtocolException("issuer TLS protocol failure") },
                { SSLException("issuer TLS failure") },
            )

        tlsFailures.forEach { tlsFailure ->
            listOf(false, true).forEach { async ->
                val now = AtomicLong()
                val permanentFailure =
                    OpenAIIoException(
                        "issuer exchange failed",
                        IOException("transport wrapper", tlsFailure()),
                    )
                val exchanges =
                    ArrayDeque(
                        listOf(
                            CompletableFuture.completedFuture(
                                X509AccessToken("cachedtoken", Duration.ofMillis(500))
                            ),
                            CompletableFuture<X509AccessToken>().apply {
                                completeExceptionally(permanentFailure)
                            },
                        )
                    )
                val authenticator =
                    x509AttemptAuthenticatorForTest(nanoTime = now::get) { exchanges.removeFirst() }

                try {
                    if (async) {
                        authenticator
                            .authenticateAsync(request(), Duration.ofSeconds(5))
                            .get(5, TimeUnit.SECONDS)
                    } else {
                        authenticator.authenticate(request(), Duration.ofSeconds(5))
                    }
                    now.set(Duration.ofMillis(425).toNanos())

                    if (async) {
                        assertThatThrownBy {
                                authenticator
                                    .authenticateAsync(request(), Duration.ofSeconds(5))
                                    .get(5, TimeUnit.SECONDS)
                            }
                            .isInstanceOf(ExecutionException::class.java)
                            .hasCause(permanentFailure)
                    } else {
                        assertThatThrownBy {
                                authenticator.authenticate(request(), Duration.ofSeconds(5))
                            }
                            .isSameAs(permanentFailure)
                    }
                    assertThat(exchanges).isEmpty()
                } finally {
                    authenticator.close()
                }
            }
        }
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
        val exchangeStarts = AtomicInteger()
        lateinit var authenticator: com.openai.core.http.HttpRequestAttemptAuthenticator
        authenticator =
            x509AttemptAuthenticatorForTest(
                beforeWaiterTimeoutSchedule = { authenticator.close() }
            ) {
                exchangeStarts.incrementAndGet()
                exchange
            }

        val authentication = authenticator.authenticateAsync(request(), Duration.ofSeconds(5))

        assertThatThrownBy { authentication.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasMessageContaining("HTTP client is closed")
        assertThat(exchangeStarts).hasValue(0)
        assertThat(exchange.isCancelled).isFalse()
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
