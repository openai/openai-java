package com.openai.core.http

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIServiceException
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RetryAfterConformanceTest {
    private class RecordingSleeper : Sleeper {
        val waits = mutableListOf<Duration>()
        val entered = CountDownLatch(1)
        var pending: CompletableFuture<Void>? = null
        var beforeReturn: CountDownLatch? = null

        override fun sleep(duration: Duration) {
            waits.add(duration)
        }

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
            waits.add(duration)
            entered.countDown()
            check(beforeReturn?.await(5, TimeUnit.SECONDS) != false)
            return pending ?: CompletableFuture.completedFuture(null)
        }

        override fun close() {}
    }

    private class Transport(
        private val status: Int,
        private val header: String,
        private val value: String,
    ) : HttpClient {
        val calls = AtomicInteger()
        val second = CountDownLatch(1)

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            if (calls.incrementAndGet() == 2) second.countDown()
            val code = if (status == 429) "slow_down" else "server_is_overloaded"
            val type = if (status == 429) "rate_limit_error" else "service_unavailable_error"
            return object : HttpResponse {
                override fun statusCode() = status

                override fun headers() =
                    Headers.builder()
                        .put(header, value)
                        .put("x-request-id", "synthetic-retry")
                        .put("content-type", "application/json")
                        .build()

                override fun body(): InputStream =
                    """{"error":{"type":"$type","code":"$code","message":"Synthetic retry response","param":null}}"""
                        .byteInputStream()

                override fun close() {}
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }

    private fun client(transport: HttpClient, sleeper: RecordingSleeper) =
        OpenAIClientImpl(
            ClientOptions.builder()
                .apiKey("synthetic")
                .baseUrl("https://example.invalid")
                .httpClient(transport)
                .sleeper(sleeper)
                .maxRetries(1)
                .build()
        )

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun preservesMinimumAndOriginalError(async: Boolean) {
        for (status in listOf(429, 503)) {
            for ((header, value, duration) in
                listOf(
                    Triple("Retry-After", "90", Duration.ofSeconds(90)),
                    Triple("Retry-After-Ms", "90000", Duration.ofSeconds(90)),
                    Triple("Retry-After", "0.0000000001", Duration.ofNanos(1)),
                )) {
                val transport = Transport(status, header, value)
                val sleeper = RecordingSleeper()
                client(transport, sleeper).let { sdk ->
                    val error =
                        try {
                            if (async) sdk.async().models().retrieve("test").join()
                            else sdk.models().retrieve("test")
                            error("Expected an API error")
                        } catch (error: java.util.concurrent.CompletionException) {
                            error.cause as OpenAIServiceException
                        } catch (error: OpenAIServiceException) {
                            error
                        }
                    assertThat(error.statusCode()).isEqualTo(status)
                    assertThat(error.headers().values("x-request-id"))
                        .containsExactly("synthetic-retry")
                    assertThat(error.code())
                        .contains(if (status == 429) "slow_down" else "server_is_overloaded")
                    assertThat(sleeper.waits).containsExactly(duration)
                    assertThat(transport.calls.get()).isEqualTo(2)
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cancellingPublicFutureStopsPendingRetry(duringHandoff: Boolean) {
        val transport = Transport(503, "Retry-After", "90")
        val sleeper =
            RecordingSleeper().apply {
                pending = CompletableFuture()
                if (duringHandoff) beforeReturn = CountDownLatch(1)
            }
        val stopped = CountDownLatch(1)
        sleeper.pending!!.whenComplete { _, _ -> stopped.countDown() }
        client(transport, sleeper).let { sdk ->
            val result = sdk.async().models().retrieve("test")
            assertThat(sleeper.entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            sleeper.beforeReturn?.countDown()
            assertThat(stopped.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(sleeper.pending!!.isCancelled).isTrue()
            sleeper.pending!!.complete(null)
            assertThat(transport.second.await(100, TimeUnit.MILLISECONDS)).isFalse()
            assertThat(transport.calls.get()).isEqualTo(1)
        }
    }

    @Test
    fun cancellingPublicFutureCancelsInFlightTransport() {
        val dispatched = CountDownLatch(1)
        val pending = CompletableFuture<HttpResponse>()
        val stopped = CountDownLatch(1)
        pending.whenComplete { _, _ -> stopped.countDown() }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous call")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    dispatched.countDown()
                    return pending
                }

                override fun close() {}
            }
        val sdk = client(transport, RecordingSleeper())
        try {
            val result = sdk.async().models().retrieve("test")
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(stopped.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(pending.isCancelled).isTrue()
        } finally {
            sdk.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun unrepresentableDelaysReturnOriginalErrorWithoutRetry(async: Boolean) {
        for (header in listOf("Retry-After", "Retry-After-Ms")) {
            for (value in listOf("1e999", "1e2147483648", "999999999999999999999999")) {
                val transport = Transport(429, header, value)
                val sleeper = RecordingSleeper()
                client(transport, sleeper).let { sdk ->
                    val error =
                        try {
                            if (async) sdk.async().models().retrieve("test").join()
                            else sdk.models().retrieve("test")
                            error("Expected an API error")
                        } catch (error: java.util.concurrent.CompletionException) {
                            error.cause as OpenAIServiceException
                        } catch (error: OpenAIServiceException) {
                            error
                        }
                    assertThat(error.statusCode()).isEqualTo(429)
                    assertThat(error.headers().values(header)).containsExactly(value)
                    assertThat(transport.calls.get()).isEqualTo(1)
                    assertThat(sleeper.waits).isEmpty()
                }
            }
        }
    }
}
