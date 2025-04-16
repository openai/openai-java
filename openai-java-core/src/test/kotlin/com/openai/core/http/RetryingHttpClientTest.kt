package com.openai.core.http

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.openai.client.okhttp.OkHttpClient
import com.openai.core.RequestOptions
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class RetryingHttpClientTest {

    private var openResponseCount = 0
    private lateinit var httpClient: HttpClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        val okHttpClient = OkHttpClient.builder().baseUrl(wmRuntimeInfo.httpBaseUrl).build()
        httpClient =
            object : HttpClient {

                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = trackClose(okHttpClient.execute(request, requestOptions))

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> =
                    okHttpClient.executeAsync(request, requestOptions).thenApply { trackClose(it) }

                override fun close() = okHttpClient.close()

                private fun trackClose(response: HttpResponse): HttpResponse {
                    openResponseCount++
                    return object : HttpResponse {

                        private var isClosed = false

                        override fun statusCode(): Int = response.statusCode()

                        override fun headers(): Headers = response.headers()

                        override fun body(): InputStream = response.body()

                        override fun close() {
                            response.close()
                            if (isClosed) {
                                return
                            }
                            openResponseCount--
                            isClosed = true
                        }
                    }
                }
            }
        resetAllScenarios()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
        val retryingClient = retryingHttpClientBuilder().build()

        val response =
            retryingClient.execute(
                HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(1, postRequestedFor(urlPathEqualTo("/something")))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withIdempotencyHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .withHeader("X-Some-Header", matching("stainless-java-retry-.+"))
                .willReturn(ok())
        )
        val retryingClient =
            retryingHttpClientBuilder().maxRetries(2).idempotencyHeader("X-Some-Header").build()

        val response =
            retryingClient.execute(
                HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(1, postRequestedFor(urlPathEqualTo("/something")))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryAfterHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                // First we fail with a retry after header given as a date
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    serviceUnavailable().withHeader("Retry-After", "Wed, 21 Oct 2015 07:28:00 GMT")
                )
                .willSetStateTo("RETRY_AFTER_DATE")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                // Then we fail with a retry after header given as a delay
                .inScenario("foo")
                .whenScenarioStateIs("RETRY_AFTER_DATE")
                .willReturn(serviceUnavailable().withHeader("Retry-After", "1.234"))
                .willSetStateTo("RETRY_AFTER_DELAY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                // Then we return a success
                .inScenario("foo")
                .whenScenarioStateIs("RETRY_AFTER_DELAY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val retryingClient = retryingHttpClientBuilder().maxRetries(2).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("0")),
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("1")),
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("2")),
        )
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withOverwrittenRetryCountHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo") // first we fail with a retry after header given as a date
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    serviceUnavailable().withHeader("Retry-After", "Wed, 21 Oct 2015 07:28:00 GMT")
                )
                .willSetStateTo("RETRY_AFTER_DATE")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo") // then we return a success
                .whenScenarioStateIs("RETRY_AFTER_DATE")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val retryingClient = retryingHttpClientBuilder().maxRetries(2).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegment("something")
                    .putHeader("x-stainless-retry-count", "42")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            2,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("42")),
        )
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryAfterMsHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable().withHeader("Retry-After-Ms", "10"))
                .willSetStateTo("RETRY_AFTER_DELAY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo") // then we return a success
                .whenScenarioStateIs("RETRY_AFTER_DELAY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val retryingClient = retryingHttpClientBuilder().maxRetries(1).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(2, postRequestedFor(urlPathEqualTo("/something")))
        assertNoResponseLeaks()
    }

    private fun retryingHttpClientBuilder() =
        RetryingHttpClient.builder()
            .httpClient(httpClient)
            // Use a no-op `Sleeper` to make the test fast.
            .sleeper(
                object : RetryingHttpClient.Sleeper {

                    override fun sleep(duration: Duration) {}

                    override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                        CompletableFuture.completedFuture(null)
                }
            )

    private fun HttpClient.execute(request: HttpRequest, async: Boolean): HttpResponse =
        if (async) executeAsync(request).get() else execute(request)

    // When retrying, all failed responses should be closed. Only the final returned response should
    // be open.
    private fun assertNoResponseLeaks() = assertThat(openResponseCount).isEqualTo(1)
}
