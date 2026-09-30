package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import java.time.Duration
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class RetryDelayBoundaryTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun serverDelaysAreCappedWithoutChangingShortDelays(async: Boolean) {
        for ((headerName, value, expected) in
            listOf(
                Triple("Retry-After", "120", Duration.ofSeconds(8)),
                Triple("Retry-After-Ms", "120000", Duration.ofSeconds(8)),
                Triple("Retry-After", "1e100", Duration.ofSeconds(8)),
                Triple("Retry-After-Ms", "1e100", Duration.ofSeconds(8)),
                Triple("Retry-After", "Infinity", Duration.ofSeconds(8)),
                Triple("Retry-After", "NaN", Duration.ZERO),
                Triple("Retry-After", "-1", Duration.ZERO),
                Triple("Retry-After", "0", Duration.ZERO),
                Triple("Retry-After", "1.25", Duration.ofMillis(1250)),
                Triple("Retry-After-Ms", "1.25", Duration.ofNanos(1_250_000)),
                Triple("Retry-After", "8", Duration.ofSeconds(8)),
                Triple("Retry-After-Ms", "8000", Duration.ofSeconds(8)),
            )) {
            assertThat(retryDelay(headerName, value, async))
                .describedAs("%s: %s (async=%s)", headerName, value, async)
                .isEqualTo(expected)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun malformedHeadersStillUseExponentialBackoff(async: Boolean) {
        for (headerName in listOf("Retry-After", "Retry-After-Ms")) {
            assertThat(retryDelay(headerName, "not-a-delay", async))
                .isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
        }
    }

    private fun retryDelay(headerName: String, value: String, async: Boolean): Duration {
        val retryResponse = mock<HttpResponse>()
        whenever(retryResponse.statusCode()).thenReturn(429)
        whenever(retryResponse.headers())
            .thenReturn(Headers.builder().put(headerName, value).build())
        val successResponse = mock<HttpResponse>()
        whenever(successResponse.statusCode()).thenReturn(200)
        val transport = mock<HttpClient>()
        whenever(transport.execute(any(), any())).thenReturn(retryResponse, successResponse)
        whenever(transport.executeAsync(any(), any()))
            .thenReturn(
                CompletableFuture.completedFuture(retryResponse),
                CompletableFuture.completedFuture(successResponse),
            )
        val delays = mutableListOf<Duration>()
        val sleeper =
            object : Sleeper {
                override fun sleep(duration: Duration) {
                    verify(retryResponse).close()
                    delays.add(duration)
                }

                override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
                    sleep(duration)
                    return CompletableFuture.completedFuture(null)
                }

                override fun close() {}
            }
        RetryingHttpClient.builder()
            .httpClient(transport)
            .sleeper(sleeper)
            .maxRetries(1)
            .build()
            .use { client ->
                val request =
                    HttpRequest.builder()
                        .baseUrl("https://example.test")
                        .method(HttpMethod.GET)
                        .build()
                val response =
                    if (async) client.executeAsync(request, RequestOptions.none()).join()
                    else client.execute(request, RequestOptions.none())
                assertThat(response).isSameAs(successResponse)
                response.close()
            }
        return delays.single()
    }
}
