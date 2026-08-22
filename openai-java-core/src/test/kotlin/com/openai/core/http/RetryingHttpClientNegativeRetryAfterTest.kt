package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RetryingHttpClientNegativeRetryAfterTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun negativeRetryAfterSecondsRetriesImmediately(async: Boolean) {
        val sleeper = RecordingSleeper()
        val client = retryingClient("Retry-After", "-1", Clock.systemUTC(), sleeper)

        val response = client.execute(request(), async)

        assertThat(response.statusCode()).isEqualTo(200)
        assertThat(sleeper.durations).containsExactly(Duration.ZERO)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun negativeRetryAfterMillisecondsRetriesImmediately(async: Boolean) {
        val sleeper = RecordingSleeper()
        val client = retryingClient("Retry-After-Ms", "-1", Clock.systemUTC(), sleeper)

        val response = client.execute(request(), async)

        assertThat(response.statusCode()).isEqualTo(200)
        assertThat(sleeper.durations).containsExactly(Duration.ZERO)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun pastRetryAfterDateRetriesImmediately(async: Boolean) {
        val sleeper = RecordingSleeper()
        val clock = Clock.fixed(Instant.parse("2015-10-21T07:28:05Z"), ZoneOffset.UTC)
        val client =
            retryingClient(
                "Retry-After",
                "Wed, 21 Oct 2015 07:28:00 GMT",
                clock,
                sleeper,
            )

        val response = client.execute(request(), async)

        assertThat(response.statusCode()).isEqualTo(200)
        assertThat(sleeper.durations).containsExactly(Duration.ZERO)
    }

    private fun retryingClient(
        headerName: String,
        headerValue: String,
        clock: Clock,
        sleeper: RecordingSleeper,
    ): HttpClient {
        var calls = 0
        val underlying =
            object : HttpClient {
                private fun nextResponse(): HttpResponse {
                    calls++
                    return if (calls == 1) {
                        TestResponse(
                            503,
                            Headers.builder().put(headerName, headerValue).build(),
                        )
                    } else {
                        TestResponse(200, Headers.builder().build())
                    }
                }

                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = nextResponse()

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(nextResponse())

                override fun close() {}
            }

        return RetryingHttpClient.builder()
            .httpClient(underlying)
            .sleeper(sleeper)
            .clock(clock)
            .maxRetries(1)
            .build()
    }

    private fun request(): HttpRequest =
        HttpRequest.builder().method(HttpMethod.POST).baseUrl("https://example.test").build()

    private fun HttpClient.execute(request: HttpRequest, async: Boolean): HttpResponse =
        if (async) executeAsync(request).join() else execute(request)

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

    private class TestResponse(
        private val statusCode: Int,
        private val headers: Headers,
    ) : HttpResponse {
        override fun statusCode(): Int = statusCode

        override fun headers(): Headers = headers

        override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

        override fun close() {}
    }
}
