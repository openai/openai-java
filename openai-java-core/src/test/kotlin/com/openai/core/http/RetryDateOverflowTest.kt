package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import java.io.InputStream
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RetryDateOverflowTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun extremeDatesFallBackAndCloseResponse(async: Boolean) {
        for (year in listOf(1, 9999)) {
            var closed = false
            var attempts = 0
            val durations = mutableListOf<Duration>()
            val response =
                object : HttpResponse {
                    override fun statusCode() = 429

                    override fun headers() =
                        Headers.builder()
                            .put(
                                "Retry-After",
                                OffsetDateTime.of(year, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
                                    .format(DateTimeFormatter.RFC_1123_DATE_TIME),
                            )
                            .build()

                    override fun body(): InputStream = "".byteInputStream()

                    override fun close() {
                        closed = true
                    }
                }
            val transport =
                object : HttpClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse {
                        attempts++
                        return response
                    }

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ) = CompletableFuture.completedFuture(execute(request, requestOptions))

                    override fun close() {}
                }
            val sleeper =
                object : Sleeper {
                    override fun sleep(duration: Duration) {
                        assertThat(closed).isTrue()
                        durations.add(duration)
                    }

                    override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
                        sleep(duration)
                        return CompletableFuture.completedFuture(null)
                    }

                    override fun close() {}
                }
            val client =
                RetryingHttpClient.builder()
                    .httpClient(transport)
                    .sleeper(sleeper)
                    .clock(Clock.fixed(Instant.parse("2026-01-01T00:00:00Z"), ZoneOffset.UTC))
                    .maxRetries(1)
                    .build()
            val request =
                HttpRequest.builder().baseUrl("https://example.test").method(HttpMethod.GET).build()
            (if (async) client.executeAsync(request, RequestOptions.none()).join()
                else client.execute(request, RequestOptions.none()))
                .close()
            assertThat(attempts).isEqualTo(2)
            assertThat(durations).hasSize(1)
            assertThat(durations.single()).isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
        }
    }
}
