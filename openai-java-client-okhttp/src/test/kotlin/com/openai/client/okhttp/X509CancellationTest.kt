package com.openai.client.okhttp

import com.openai.client.OpenAIClientAsyncImpl
import com.openai.core.ClientOptions
import com.openai.core.Sleeper
import com.openai.core.http.HttpClient
import com.openai.errors.OpenAIIoException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.IOException
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import okhttp3.Call
import okhttp3.EventListener
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import okio.Source
import okio.Timeout
import okio.buffer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class X509CancellationTest {
    @Test
    fun cancellingPublicRequestCancelsDispatchedCallAndClosesLateResponse() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val call = AtomicReference<Call>()
        val cancelled = CountDownLatch(1)
        val body =
            object : ResponseBody() {
                private val source = Buffer()

                override fun contentType() = null

                override fun contentLength() = 0L

                override fun source() = source

                override fun close() {
                    super.close()
                    closed.countDown()
                }
            }
        val client =
            client(
                Interceptor { chain ->
                    call.set(chain.call())
                    entered.countDown()
                    check(release.await(5, TimeUnit.SECONDS))
                    response(chain, body)
                },
                listener =
                    object : EventListener() {
                        override fun canceled(call: Call) {
                            cancelled.countDown()
                        }
                    },
            )
        try {
            val future = client.models().retrieve("test-model")
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(future.cancel(true)).isTrue()
            assertThat(cancelled.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(call.get().isCanceled()).isTrue()
            release.countDown()
            assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(future.isCancelled).isTrue()
        } finally {
            release.countDown()
            client.close()
        }
    }

    @Test
    fun cancellationDuringCallCreationCancelsTheCallWhenEnrolled() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val cancelled = CountDownLatch(1)
        val client =
            client(
                Interceptor { response(it, "".toResponseBody(JSON)) },
                listener =
                    object : EventListener() {
                        override fun callStart(call: Call) {
                            entered.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                        }

                        override fun canceled(call: Call) {
                            cancelled.countDown()
                        }
                    },
            )
        try {
            val future = client.models().retrieve("test-model")
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(future.cancel(true)).isTrue()
            release.countDown()
            assertThat(cancelled.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(future.isCancelled).isTrue()
        } finally {
            release.countDown()
            client.close()
        }
    }

    @Test
    fun cancellingAuthWaiterPreservesSharedExchangeAndDoesNotDispatchItsApiRequest() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val exchanges = AtomicInteger()
        val requests = AtomicInteger()
        val client =
            client(
                Interceptor { chain ->
                    requests.incrementAndGet()
                    response(
                        chain,
                        """{"id":"test-model","object":"model","created":0,"owned_by":"test"}"""
                            .toResponseBody(JSON),
                    )
                },
                Interceptor { chain ->
                    exchanges.incrementAndGet()
                    entered.countDown()
                    check(release.await(5, TimeUnit.SECONDS))
                    response(chain, TOKEN.toResponseBody(JSON))
                },
            )
        try {
            val cancelled = client.models().retrieve("cancelled-model")
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            val remaining = client.models().retrieve("test-model")
            assertThat(cancelled.cancel(true)).isTrue()
            release.countDown()
            assertThat(remaining.get(5, TimeUnit.SECONDS).id()).isEqualTo("test-model")
            assertThat(cancelled.isCancelled).isTrue()
            assertThat(exchanges.get()).isEqualTo(1)
            assertThat(requests.get()).isEqualTo(1)
        } finally {
            release.countDown()
            client.close()
        }
    }

    @TestFactory
    fun issuerErrorBodyIoRetainsServerMinimum() =
        listOf(false, true).flatMap { async ->
            listOf(
                    listOf("Retry-After" to "90") to Duration.ofSeconds(90),
                    listOf("Retry-After-Ms" to "90000") to Duration.ofSeconds(90),
                    listOf("Retry-After" to "90.0000000001") to Duration.ofNanos(90_000_000_001),
                    listOf("Retry-After-Ms" to "90000.0001", "Retry-After" to "1") to
                        Duration.ofNanos(90_000_000_100),
                    listOf("Retry-After" to "Thu, 01 Jan 2026 00:01:30 GMT") to
                        Duration.ofSeconds(90),
                    listOf("Retry-After" to "+9e1") to Duration.ofSeconds(90),
                    listOf("Retry-After-Ms" to "9e4") to Duration.ofSeconds(90),
                    listOf("Retry-After" to "0".repeat(80) + "90") to Duration.ofSeconds(90),
                    listOf("Retry-After" to "1e999999999999") to null,
                    listOf("Retry-After-Ms" to "1e999999999999", "Retry-After" to "1") to null,
                    listOf("Retry-After" to "9".repeat(80)) to null,
                    listOf("Retry-After-Ms" to "9".repeat(80)) to null,
                    listOf("Retry-After" to "999999999999999999999999") to null,
                    listOf("Retry-After-Ms" to "999999999999999999999999") to null,
                    listOf("Retry-After-Ms" to "9223372036854.775807") to
                        Duration.ofNanos(Long.MAX_VALUE),
                    listOf("Retry-After-Ms" to "9223372036854.775808") to null,
                    listOf("Retry-After" to "1e-999999999999") to Duration.ofNanos(1),
                    listOf("Retry-After" to "0e999999999999") to Duration.ZERO,
                    listOf(
                        "Retry-After-Ms" to "fake-private-retry-value",
                        "Retry-After-Ms" to "1",
                        "Retry-After" to "90",
                    ) to Duration.ofSeconds(90),
                )
                .mapIndexed { index, (headers, minimum) ->
                    dynamicTest("async=$async case=$index") {
                        verifyIssuerErrorBodyIo(async, headers, minimum)
                    }
                }
        }

    private fun verifyIssuerErrorBodyIo(
        async: Boolean,
        headers: List<Pair<String, String>>,
        minimum: Duration?,
    ) {
        val cause = IOException("synthetic issuer body disconnect")
        val exchanges = AtomicInteger()
        val apiRequests = AtomicInteger()
        val closes = AtomicInteger()
        val delays = mutableListOf<Duration>()
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) {
                    delays.add(duration)
                }

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
                    sleep(duration)
                    return CompletableFuture.completedFuture(null)
                }

                override fun close() = Unit
            }
        val client =
            client(
                Interceptor { chain ->
                    apiRequests.incrementAndGet()
                    response(chain, "".toResponseBody(JSON))
                },
                Interceptor { chain ->
                    exchanges.incrementAndGet()
                    val body =
                        object : ResponseBody() {
                            private val source =
                                object : Source {
                                        override fun read(sink: Buffer, byteCount: Long): Long =
                                            throw cause

                                        override fun timeout() = Timeout.NONE

                                        override fun close() {
                                            closes.incrementAndGet()
                                        }
                                    }
                                    .buffer()

                            override fun contentType() = JSON

                            override fun contentLength() = -1L

                            override fun source() = source
                        }
                    response(chain, body)
                        .newBuilder()
                        .code(503)
                        .apply { headers.forEach { (name, value) -> addHeader(name, value) } }
                        .header("Authorization", "fake-private-issuer-authorization")
                        .header("X-Request-Id", "fake-private-issuer-request-id")
                        .build()
                },
                options = {
                    it.maxRetries(1)
                        .sleeper(sleeper)
                        .clock(Clock.fixed(Instant.parse("2026-01-01T00:00:00Z"), ZoneOffset.UTC))
                },
            )
        try {
            val failure =
                try {
                    if (async) client.models().retrieve("test-model").get(5, TimeUnit.SECONDS)
                    else client.sync().models().retrieve("test-model")
                    error("Expected issuer body failure")
                } catch (failure: ExecutionException) {
                    failure.cause!!
                } catch (failure: OpenAIIoException) {
                    failure
                }
            assertThat(failure)
                .isInstanceOf(OpenAIIoException::class.java)
                .hasMessage("Failed to read X.509 token exchange response")
            assertThat(failure.cause).isSameAs(cause)
            val context = failure.suppressed.single() as UnexpectedStatusCodeException
            assertThat(context.headers().toString())
                .doesNotContain(
                    "fake-private-issuer-authorization",
                    "fake-private-issuer-request-id",
                    "fake-private-retry-value",
                )
            assertThat(failure.stackTraceToString())
                .doesNotContain(
                    "fake-private-issuer-authorization",
                    "fake-private-issuer-request-id",
                )
            assertThat(apiRequests.get()).isZero()
            if (minimum == null) {
                assertThat(delays).isEmpty()
                assertThat(exchanges.get()).isEqualTo(1)
            } else {
                assertThat(delays).containsExactly(minimum)
                assertThat(exchanges.get()).isEqualTo(2)
            }
            assertThat(closes.get()).isEqualTo(exchanges.get())
        } finally {
            client.close()
        }
    }

    private fun client(
        api: Interceptor,
        auth: Interceptor = Interceptor { response(it, TOKEN.toResponseBody(JSON)) },
        listener: EventListener = EventListener.NONE,
        options: (ClientOptions.Builder) -> Unit = {},
    ): OpenAIClientAsyncImpl {
        val apiClient =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder().addInterceptor(api).eventListener(listener).build()
            )
        val authClient = OkHttpClient(okhttp3.OkHttpClient.Builder().addInterceptor(auth).build())
        val authenticator =
            X509WorkloadIdentityAuthenticator(
                X509TokenExchange("idp_test", "svc_test", authClient),
                authClient,
                Duration.ZERO,
            )
        // Exercise the private production adapter without expanding its visibility for tests.
        val adapter =
            Class.forName("com.openai.client.okhttp.X509RefreshingHttpClient")
                .getDeclaredConstructor(
                    OkHttpClient::class.java,
                    X509WorkloadIdentityAuthenticator::class.java,
                )
                .apply { isAccessible = true }
                .newInstance(apiClient, authenticator) as HttpClient
        return OpenAIClientAsyncImpl(
            ClientOptions.builder()
                .baseUrl("https://mtls.api.openai.com/v1")
                .httpClient(adapter)
                .httpRequestAuthenticator(authenticator)
                .maxRetries(0)
                .apply(options)
                .build()
        )
    }

    private fun response(chain: Interceptor.Chain, body: ResponseBody): Response =
        Response.Builder()
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .code(200)
            .message("OK")
            .header("Content-Type", "application/json")
            .body(body)
            .build()

    private companion object {
        val JSON = "application/json".toMediaType()
        const val TOKEN =
            """{"access_token":"fake-x509-token","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":3600}"""
    }
}
