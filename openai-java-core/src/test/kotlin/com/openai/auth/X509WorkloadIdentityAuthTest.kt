package com.openai.auth

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.BadRequestException
import com.openai.errors.InternalServerException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference
import java.util.function.LongSupplier
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class X509WorkloadIdentityAuthTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun exchangeUsesExactEndpointAndStructurallyOmitsSubjectToken(async: Boolean) {
        val capturedRequest = AtomicReference<HttpRequest>()
        val httpClient = synchronousHttpClient { request ->
            capturedRequest.set(request)
            tokenResponse("access-token", expiresIn = 3600)
        }
        val auth = x509Auth(httpClient)

        val token = if (async) auth.getTokenAsync().get(5, TimeUnit.SECONDS) else auth.getToken()
        assertThat(token).isEqualTo("access-token")

        val request = capturedRequest.get()
        val body = requestJson(request)
        assertThat(request.method).isEqualTo(HttpMethod.POST)
        assertThat(request.url()).isEqualTo("https://mtls.auth.openai.com/oauth/token")
        assertThat(request.followRedirects).isFalse()
        assertThat(request.body?.contentType()).isEqualTo("application/json")
        assertThat(body.get("grant_type").asText())
            .isEqualTo("urn:ietf:params:oauth:grant-type:token-exchange")
        assertThat(body.get("subject_token_type").asText())
            .isEqualTo("urn:openai:params:oauth:token-type:x509")
        assertThat(body.get("identity_provider_id").asText()).isEqualTo("idp_test")
        assertThat(body.get("service_account_id").asText()).isEqualTo("svc_acct_test")
        assertThat(body.has("subject_token")).isFalse()
        assertThat(body.has("client_id")).isFalse()
    }

    @Test
    fun exchangeIsLazy() {
        val calls = AtomicInteger()
        val auth =
            x509Auth(
                synchronousHttpClient {
                    calls.incrementAndGet()
                    tokenResponse("access-token", expiresIn = 3600)
                }
            )

        assertThat(calls).hasValue(0)
        assertThat(auth.getToken()).isEqualTo("access-token")
        assertThat(calls).hasValue(1)
    }

    @Test
    fun refreshBufferIsClampedToHalfOfShortTokenLifetimeUsingMonotonicTime() {
        val nowNanos = AtomicLong()
        val calls = AtomicInteger()
        val responses =
            ConcurrentLinkedQueue(
                listOf(
                    tokenResponse("first-token", expiresIn = 10),
                    tokenResponse("second-token", expiresIn = 10),
                )
            )
        val auth =
            x509Auth(
                httpClient =
                    synchronousHttpClient {
                        calls.incrementAndGet()
                        responses.remove()
                    },
                refreshBuffer = Duration.ofMinutes(20),
                nanoTime = LongSupplier(nowNanos::get),
            )

        assertThat(auth.getToken()).isEqualTo("first-token")
        nowNanos.set(Duration.ofSeconds(4).toNanos())
        assertThat(auth.getToken()).isEqualTo("first-token")
        assertThat(calls).hasValue(1)

        nowNanos.set(Duration.ofSeconds(5).toNanos())
        assertThat(auth.getToken()).isEqualTo("second-token")
        assertThat(calls).hasValue(2)
    }

    @Test
    fun concurrentColdSynchronousCallersShareOneExchange() {
        val exchangeStarted = CountDownLatch(1)
        val releaseExchange = CountDownLatch(1)
        val calls = AtomicInteger()
        val auth =
            x509Auth(
                synchronousHttpClient {
                    calls.incrementAndGet()
                    exchangeStarted.countDown()
                    check(releaseExchange.await(5, TimeUnit.SECONDS))
                    tokenResponse("shared-token", expiresIn = 3600)
                }
            )
        val executor = Executors.newFixedThreadPool(20)

        try {
            val results = (1..100).map { executor.submit<String> { auth.getToken() } }
            assertThat(exchangeStarted.await(5, TimeUnit.SECONDS)).isTrue()
            releaseExchange.countDown()

            assertThat(results.map { it.get(5, TimeUnit.SECONDS) }).containsOnly("shared-token")
            assertThat(calls).hasValue(1)
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun cancelingAsyncWaiterDoesNotCancelOrPoisonSharedRefresh() {
        val exchange = CompletableFuture<HttpResponse>()
        val calls = AtomicInteger()
        val httpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("unexpected synchronous call")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    calls.incrementAndGet()
                    return exchange
                }

                override fun close() {}
            }
        val auth = x509Auth(httpClient)

        val canceledWaiter = auth.getTokenAsync()
        val successfulWaiter = auth.getTokenAsync()
        assertThat(canceledWaiter.cancel(true)).isTrue()
        assertThat(exchange.isCancelled).isFalse()

        exchange.complete(tokenResponse("shared-token", expiresIn = 3600))

        assertThat(successfulWaiter.get(5, TimeUnit.SECONDS)).isEqualTo("shared-token")
        assertThat(calls).hasValue(1)
        assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("shared-token")
    }

    @Test
    fun synchronousAndAsynchronousColdCallersShareOneExchange() {
        val exchangeStarted = CountDownLatch(1)
        val releaseExchange = CountDownLatch(1)
        val calls = AtomicInteger()
        val auth =
            x509Auth(
                synchronousHttpClient {
                    calls.incrementAndGet()
                    exchangeStarted.countDown()
                    check(releaseExchange.await(5, TimeUnit.SECONDS))
                    tokenResponse("shared-token", expiresIn = 3600)
                }
            )
        val executor = Executors.newSingleThreadExecutor()

        try {
            val synchronous = executor.submit<String> { auth.getToken() }
            assertThat(exchangeStarted.await(5, TimeUnit.SECONDS)).isTrue()
            val asynchronous = auth.getTokenAsync()
            releaseExchange.countDown()

            assertThat(synchronous.get(5, TimeUnit.SECONDS)).isEqualTo("shared-token")
            assertThat(asynchronous.get(5, TimeUnit.SECONDS)).isEqualTo("shared-token")
            assertThat(calls).hasValue(1)
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun asyncProactiveRefreshReturnsUsableCachedTokenUntilRefreshCompletes() {
        val nowNanos = AtomicLong()
        val refresh = CompletableFuture<HttpResponse>()
        val calls = AtomicInteger()
        val httpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    calls.incrementAndGet()
                    return tokenResponse("first-token", expiresIn = 10)
                }

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    calls.incrementAndGet()
                    return refresh
                }

                override fun close() {}
            }
        val auth = x509Auth(httpClient, nanoTime = LongSupplier(nowNanos::get))
        assertThat(auth.getToken()).isEqualTo("first-token")

        nowNanos.set(Duration.ofSeconds(5).toNanos())
        assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("first-token")
        assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("first-token")
        assertThat(calls).hasValue(2)

        refresh.complete(tokenResponse("refreshed-token", expiresIn = 10))

        assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("refreshed-token")
        assertThat(calls).hasValue(2)
    }

    @Test
    fun staleTokenLeaseDoesNotInvalidateSameValuedRefreshedToken() {
        val refreshExchange = CompletableFuture<HttpResponse>()
        val calls = AtomicInteger()
        val httpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    calls.incrementAndGet()
                    return tokenResponse("old-token", expiresIn = 3600)
                }

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    calls.incrementAndGet()
                    return refreshExchange
                }

                override fun close() {}
            }
        val auth = x509Auth(httpClient)
        val oldToken = auth.getTokenLease()
        assertThat(oldToken.value).isEqualTo("old-token")

        auth.invalidateToken(oldToken)
        val firstWaiter = auth.getTokenAsync()
        refreshExchange.complete(tokenResponse("old-token", expiresIn = 3600))
        assertThat(firstWaiter.get(5, TimeUnit.SECONDS)).isEqualTo("old-token")

        auth.invalidateToken(oldToken)
        val secondWaiter = auth.getTokenAsync()
        assertThat(secondWaiter.get(5, TimeUnit.SECONDS)).isEqualTo("old-token")
        assertThat(calls).hasValue(2)
    }

    @Test
    fun invalidatedTokenDoesNotWaitForAnEarlierProactiveRefreshBackoff() {
        val nowNanos = AtomicLong()
        val asynchronousExchanges = AtomicInteger()
        val blockedBackoff = CompletableFuture<Void>()
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) {}

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                    blockedBackoff

                override fun close() {}
            }
        val httpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = tokenResponse("rejected-token", expiresIn = 10)

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> =
                    CompletableFuture.completedFuture(
                        if (asynchronousExchanges.getAndIncrement() == 0) {
                            response(
                                statusCode = 429,
                                body = "{}",
                                headers = Headers.builder().put("Retry-After", "60").build(),
                            )
                        } else {
                            tokenResponse("replacement-token", expiresIn = 10)
                        }
                    )

                override fun close() {}
            }
        val auth = x509Auth(httpClient, sleeper = sleeper, nanoTime = LongSupplier(nowNanos::get))
        val rejectedToken = auth.getTokenLease()
        nowNanos.set(Duration.ofSeconds(5).toNanos())

        assertThat(auth.getTokenAsync().get()).isEqualTo("rejected-token")
        assertThat(asynchronousExchanges).hasValue(1)
        nowNanos.set(Duration.ofSeconds(10).toNanos())
        val displacedWaiter = auth.getTokenAsync()
        assertThat(displacedWaiter).isNotCompleted
        auth.invalidateToken(rejectedToken)

        val recoveredToken = auth.getTokenAsync()

        assertThat(recoveredToken).isCompletedWithValue("replacement-token")
        assertThat(displacedWaiter).isCompletedWithValue("replacement-token")
        assertThat(asynchronousExchanges).hasValue(2)
        assertThat(blockedBackoff).isNotCompleted
    }

    @Test
    fun invalidatedTokenDoesNotWaitForASynchronousProactiveRefreshBackoff() {
        val nowNanos = AtomicLong()
        val synchronousExchanges = AtomicInteger()
        val asynchronousExchanges = AtomicInteger()
        val backoffStarted = CountDownLatch(1)
        val releaseBackoff = CountDownLatch(1)
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) {
                    backoffStarted.countDown()
                    check(releaseBackoff.await(5, TimeUnit.SECONDS))
                }

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                    CompletableFuture.completedFuture(null)

                override fun close() {}
            }
        val httpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse =
                    when (synchronousExchanges.getAndIncrement()) {
                        0 -> tokenResponse("rejected-token", expiresIn = 10)
                        1 ->
                            response(
                                statusCode = 429,
                                body = "{}",
                                headers = Headers.builder().put("Retry-After", "60").build(),
                            )
                        else -> tokenResponse("superseded-token", expiresIn = 10)
                    }

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    asynchronousExchanges.incrementAndGet()
                    return CompletableFuture.completedFuture(
                        tokenResponse("replacement-token", expiresIn = 10)
                    )
                }

                override fun close() {}
            }
        val auth = x509Auth(httpClient, sleeper = sleeper, nanoTime = LongSupplier(nowNanos::get))
        val rejectedToken = auth.getTokenLease()
        val executor = Executors.newSingleThreadExecutor()

        try {
            nowNanos.set(Duration.ofSeconds(5).toNanos())
            val synchronousRefresh = executor.submit<String> { auth.getToken() }
            assertThat(backoffStarted.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(auth.getTokenLeaseAsync()).isCompletedWithValue(rejectedToken)

            auth.invalidateToken(rejectedToken)

            assertThat(auth.getTokenAsync()).isCompletedWithValue("replacement-token")
            assertThat(asynchronousExchanges).hasValue(1)
            assertThat(releaseBackoff.count).isEqualTo(1)

            releaseBackoff.countDown()
            assertThat(synchronousRefresh.get(5, TimeUnit.SECONDS)).isEqualTo("replacement-token")
            assertThat(auth.getToken()).isEqualTo("replacement-token")
        } finally {
            releaseBackoff.countDown()
            executor.shutdownNow()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun displacedRefreshCannotCompleteWaitersBeforeReplacement(failedRefresh: Boolean) {
        val nowNanos = AtomicLong()
        val asynchronousExchanges = AtomicInteger()
        val displacedExchange = CompletableFuture<HttpResponse>()
        val replacementExchange = CompletableFuture<HttpResponse>()
        val httpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = tokenResponse("rejected-token", expiresIn = 10)

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> =
                    if (asynchronousExchanges.getAndIncrement() == 0) displacedExchange
                    else replacementExchange

                override fun close() {}
            }
        val auth = x509Auth(httpClient, nanoTime = LongSupplier(nowNanos::get))
        val rejectedToken = auth.getTokenLease()
        nowNanos.set(Duration.ofSeconds(5).toNanos())
        assertThat(auth.getTokenAsync()).isCompletedWithValue("rejected-token")

        nowNanos.set(Duration.ofSeconds(10).toNanos())
        val displacedWaiter = auth.getTokenAsync()
        auth.invalidateToken(rejectedToken)
        val replacementWaiter = auth.getTokenAsync()

        if (failedRefresh) {
            displacedExchange.completeExceptionally(IllegalStateException("superseded failure"))
        } else {
            displacedExchange.complete(tokenResponse("superseded-token", expiresIn = 10))
        }

        assertThat(displacedWaiter).isNotCompleted
        assertThat(replacementWaiter).isNotCompleted

        replacementExchange.complete(tokenResponse("replacement-token", expiresIn = 10))

        assertThat(displacedWaiter).isCompletedWithValue("replacement-token")
        assertThat(replacementWaiter).isCompletedWithValue("replacement-token")
        assertThat(auth.getToken()).isEqualTo("replacement-token")
        assertThat(asynchronousExchanges).hasValue(2)
    }

    @Test
    fun tokenLeaseDebugRepresentationDoesNotExposeBearerToken() {
        val auth =
            x509Auth(
                synchronousHttpClient { tokenResponse("sensitive-bearer-token", expiresIn = 3600) }
            )

        assertThat(auth.getTokenLease().toString()).doesNotContain("sensitive-bearer-token")
    }

    @Test
    fun transientExchangeRetryIsBoundedAndHonorsRetryAfter() {
        val calls = AtomicInteger()
        val sleeper = RecordingSleeper()
        val httpClient = synchronousHttpClient {
            if (calls.getAndIncrement() == 0) {
                response(
                    statusCode = 429,
                    body = "{}",
                    headers = Headers.builder().put("Retry-After", "1.5").build(),
                )
            } else {
                tokenResponse("access-token", expiresIn = 3600)
            }
        }
        val auth = x509Auth(httpClient, sleeper = sleeper, maxRetries = 1)

        assertThat(auth.getToken()).isEqualTo("access-token")
        assertThat(calls).hasValue(2)
        assertThat(sleeper.durations).containsExactly(Duration.ofMillis(1500))
    }

    @ParameterizedTest
    @CsvSource(
        value =
            [
                "false|Infinity",
                "true|Infinity",
                "false|1e30",
                "true|1e30",
                "false|999999999999",
                "true|999999999999",
                "false|-1",
                "true|-1",
                "false|NaN",
                "true|NaN",
                "false|Fri, 31 Dec 9999 23:59:59 GMT",
                "true|Fri, 31 Dec 9999 23:59:59 GMT",
                "false|Mon, 01 Jan 0001 00:00:00 GMT",
                "true|Mon, 01 Jan 0001 00:00:00 GMT",
            ],
        delimiter = '|',
    )
    fun transientExchangeRejectsUnboundedOrInvalidRetryAfter(async: Boolean, retryAfter: String) {
        val calls = AtomicInteger()
        val sleeper = RecordingSleeper()
        val auth =
            x509Auth(
                httpClient =
                    synchronousHttpClient {
                        if (calls.getAndIncrement() == 0) {
                            response(
                                statusCode = 429,
                                body = "{}",
                                headers = Headers.builder().put("Retry-After", retryAfter).build(),
                            )
                        } else {
                            tokenResponse("access-token", expiresIn = 3600)
                        }
                    },
                sleeper = sleeper,
                maxRetries = 1,
            )

        val token = if (async) auth.getTokenAsync().get() else auth.getToken()

        assertThat(token).isEqualTo("access-token")
        assertThat(calls).hasValue(2)
        assertThat(sleeper.durations).hasSize(1)
        assertThat(sleeper.durations.single())
            .isPositive()
            .isLessThanOrEqualTo(Duration.ofSeconds(60))
    }

    @Test
    fun transientExchangeRetriesDoNotExceedConfiguredBound() {
        val calls = AtomicInteger()
        val sleeper = RecordingSleeper()
        val auth =
            x509Auth(
                httpClient =
                    synchronousHttpClient {
                        calls.incrementAndGet()
                        response(500, "{}")
                    },
                sleeper = sleeper,
                maxRetries = 2,
            )

        assertThatThrownBy { auth.getToken() }.isInstanceOf(InternalServerException::class.java)
        assertThat(calls).hasValue(3)
        assertThat(sleeper.durations).hasSize(2)
    }

    @Test
    fun oauthClientErrorIsNotRetriedAndDoesNotExposeDescription() {
        val calls = AtomicInteger()
        val auth =
            x509Auth(
                synchronousHttpClient {
                    calls.incrementAndGet()
                    response(
                        400,
                        """{"error":"invalid_grant","error_description":"sensitive mapping detail"}""",
                    )
                },
                maxRetries = 2,
            )

        val thrown = assertThrows<BadRequestException> { auth.getToken() }

        assertThat(calls).hasValue(1)
        assertThat(thrown.code()).contains("invalid_grant")
        assertThat(thrown.message).doesNotContain("sensitive mapping detail")
    }

    @ParameterizedTest
    @CsvSource("false,200", "true,200", "false,400", "true,400")
    fun oversizedOauthResponseStopsReadingAtBound(async: Boolean, statusCode: Int) {
        val oversizedField = "a".repeat(1_048_577)
        val body =
            if (statusCode == 200) {
                """{"access_token":"$oversizedField","expires_in":3600}"""
            } else {
                """{"error":"invalid_grant","error_description":"$oversizedField"}"""
            }
        val bytesRead = AtomicInteger()
        val source = ByteArrayInputStream(body.toByteArray())
        val stream =
            object : InputStream() {
                override fun read(): Int =
                    source.read().also { value -> if (value != -1) bytesRead.incrementAndGet() }

                override fun read(buffer: ByteArray, offset: Int, length: Int): Int =
                    source.read(buffer, offset, length).also { count ->
                        if (count > 0) bytesRead.addAndGet(count)
                    }
            }
        val response =
            object : HttpResponse {
                override fun statusCode() = statusCode

                override fun headers() = Headers.builder().build()

                override fun body() = stream

                override fun close() {}
            }
        val auth = x509Auth(synchronousHttpClient { response })

        val error =
            assertThrows<Throwable> { if (async) auth.getTokenAsync().join() else auth.getToken() }
        val cause = if (async) checkNotNull(error.cause) else error
        if (statusCode == 200) {
            assertThat(cause).isInstanceOf(OpenAIInvalidDataException::class.java)
        } else {
            assertThat(cause).isInstanceOf(BadRequestException::class.java)
        }
        assertThat(bytesRead.get()).isLessThanOrEqualTo(1_048_577)
    }

    @Test
    fun redirectResponseIsRejectedWithoutRetry() {
        val calls = AtomicInteger()
        val auth =
            x509Auth(
                synchronousHttpClient {
                    calls.incrementAndGet()
                    response(
                        302,
                        "redirect",
                        Headers.builder().put("Location", "https://example.com/").build(),
                    )
                }
            )

        assertThatThrownBy { auth.getToken() }
            .isInstanceOf(UnexpectedStatusCodeException::class.java)
        assertThat(calls).hasValue(1)
    }

    @Test
    fun x509ExchangeRequiresPositiveExpiresIn() {
        val missing = x509Auth(synchronousHttpClient { tokenResponse("token", expiresIn = null) })
        val zero = x509Auth(synchronousHttpClient { tokenResponse("token", expiresIn = 0) })
        val negative = x509Auth(synchronousHttpClient { tokenResponse("token", expiresIn = -1) })
        val nonNumeric =
            x509Auth(
                synchronousHttpClient {
                    response(
                        200,
                        """{"access_token":"token","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","token_type":"Bearer","expires_in":"3600"}""",
                    )
                }
            )

        assertThatThrownBy { missing.getToken() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("X.509 token exchange response missing 'expires_in' field")
        assertThatThrownBy { zero.getToken() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("Token exchange returned invalid expires_in value: 0")
        assertThatThrownBy { negative.getToken() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("Token exchange returned invalid expires_in value: -1")
        assertThatThrownBy { nonNumeric.getToken() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("Token exchange returned a non-integer expires_in value")
    }

    @Test
    fun invalidSuccessResponseDoesNotExposeBodyOrTokenMaterial() {
        val auth =
            x509Auth(
                synchronousHttpClient {
                    response(200, """{"access_token":"","expires_in":3600,"debug":"secret-body"}""")
                }
            )

        assertThatThrownBy { auth.getToken() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("Token exchange response missing 'access_token' field")
            .hasMessageNotContaining("secret-body")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "\"Basic\"", "\"MAC\"", "\"DPoP\"", "null", "5", "true"])
    fun x509RejectsNonBearerTokenTypes(tokenType: String) {
        listOf(false, true).forEach { async ->
            val tokenTypeField = if (tokenType.isEmpty()) "" else ",\"token_type\":$tokenType"
            val auth =
                x509Auth(
                    synchronousHttpClient {
                        response(
                            200,
                            """{"access_token":"safe-token"$tokenTypeField,"expires_in":3600}""",
                        )
                    }
                )

            val failure =
                assertThrows<Throwable> {
                    if (async) auth.getTokenAsync().join() else auth.getToken()
                }
            val cause = if (async) checkNotNull(failure.cause) else failure
            assertThat(cause)
                .isInstanceOf(OpenAIInvalidDataException::class.java)
                .hasMessage("X.509 token exchange returned a non-Bearer token type")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["Bearer", "bearer", "BEARER"])
    fun x509AcceptsBearerTokenTypeCaseInsensitively(tokenType: String) {
        listOf(false, true).forEach { async ->
            val auth =
                x509Auth(
                    synchronousHttpClient {
                        response(
                            200,
                            """{"access_token":"safe-token","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","token_type":"$tokenType","expires_in":3600}""",
                        )
                    }
                )

            val token = if (async) auth.getTokenAsync().join() else auth.getToken()

            assertThat(token).isEqualTo("safe-token")
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "",
                "null",
                "\"refresh_token\"",
                "\"urn:ietf:params:oauth:token-type:refresh_token\"",
                "5",
                "true",
            ]
    )
    fun x509RejectsMissingOrUnsupportedIssuedTokenTypes(issuedTokenType: String) {
        listOf(false, true).forEach { async ->
            val issuedTokenTypeField =
                if (issuedTokenType.isEmpty()) "" else ",\"issued_token_type\":$issuedTokenType"
            val auth =
                x509Auth(
                    synchronousHttpClient {
                        response(
                            200,
                            """{"access_token":"safe-token"$issuedTokenTypeField,"token_type":"Bearer","expires_in":3600}""",
                        )
                    }
                )

            val failure =
                assertThrows<Throwable> {
                    if (async) auth.getTokenAsync().join() else auth.getToken()
                }
            val cause = if (async) checkNotNull(failure.cause) else failure
            assertThat(cause)
                .isInstanceOf(OpenAIInvalidDataException::class.java)
                .hasMessage("Token exchange returned an unsupported issued_token_type")
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "token\r\ninjected",
                "token\ninjected",
                "token\u0000injected",
                "token\tinjected",
                "token value",
                "tökén",
                "token=value",
            ]
    )
    fun x509RejectsUnsafeBearerTokenCharacters(accessToken: String) {
        listOf(false, true).forEach { async ->
            val encodedToken = JsonMapper().writeValueAsString(accessToken)
            val auth =
                x509Auth(
                    synchronousHttpClient {
                        response(200, """{"access_token":$encodedToken,"expires_in":3600}""")
                    }
                )

            val failure =
                assertThrows<Throwable> {
                    if (async) auth.getTokenAsync().join() else auth.getToken()
                }
            val cause = if (async) checkNotNull(failure.cause) else failure
            assertThat(cause)
                .isInstanceOf(OpenAIInvalidDataException::class.java)
                .hasMessage("X.509 token exchange returned an invalid access token")
        }
    }

    private fun x509Auth(
        httpClient: HttpClient,
        refreshBuffer: Duration = Duration.ofMinutes(20),
        sleeper: Sleeper = RecordingSleeper(),
        maxRetries: Int = 2,
        nanoTime: LongSupplier = LongSupplier { System.nanoTime() },
    ): WorkloadIdentityAuth =
        WorkloadIdentityAuth(
            config =
                WorkloadIdentity.x509Builder()
                    .identityProviderId("idp_test")
                    .serviceAccountId("svc_acct_test")
                    .refreshBuffer(refreshBuffer)
                    .build(),
            httpClient = httpClient,
            jsonMapper = JsonMapper(),
            sleeper = sleeper,
            maxRetries = maxRetries,
            nanoTime = nanoTime,
        )

    private fun synchronousHttpClient(execute: (HttpRequest) -> HttpResponse): HttpClient =
        object : HttpClient {
            override fun execute(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): HttpResponse = execute(request)

            override fun executeAsync(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): CompletableFuture<HttpResponse> =
                try {
                    CompletableFuture.completedFuture(execute(request))
                } catch (error: Throwable) {
                    CompletableFuture<HttpResponse>().also { it.completeExceptionally(error) }
                }

            override fun close() {}
        }

    private fun tokenResponse(accessToken: String, expiresIn: Int?): HttpResponse {
        val expiresInJson = expiresIn?.let { ",\"expires_in\":$it" } ?: ""
        return response(
            200,
            """{"access_token":"$accessToken","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","token_type":"Bearer"$expiresInJson}""",
        )
    }

    private fun response(
        statusCode: Int,
        body: String,
        headers: Headers = Headers.builder().build(),
    ): HttpResponse =
        object : HttpResponse {
            override fun statusCode(): Int = statusCode

            override fun headers(): Headers = headers

            override fun body(): InputStream = ByteArrayInputStream(body.toByteArray())

            override fun close() {}
        }

    private fun requestJson(request: HttpRequest): JsonNode {
        val output = ByteArrayOutputStream()
        checkNotNull(request.body).writeTo(output)
        return JsonMapper().readTree(output.toByteArray())
    }

    private class RecordingSleeper : Sleeper {
        val durations = mutableListOf<Duration>()

        override fun sleep(duration: Duration) {
            durations.add(duration)
        }

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
            durations.add(duration)
            return CompletableFuture.completedFuture(null)
        }

        override fun close() {}
    }
}
