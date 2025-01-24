package com.openai.core.http

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.openai.client.okhttp.OkHttpClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
internal class RetryingHttpClientTest {

    private lateinit var httpClient: HttpClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        httpClient = OkHttpClient.builder().baseUrl(wmRuntimeInfo.httpBaseUrl).build()
        resetAllScenarios()
    }

    @Test
    fun byDefaultShouldNotAddIdempotencyHeaderToRequest() {
        val request =
            HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build()
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
        val retryingClient = RetryingHttpClient.builder().httpClient(httpClient).build()
        val response = retryingClient.execute(request)
        assertThat(response.statusCode()).isEqualTo(200)
        verify(1, postRequestedFor(urlPathEqualTo("/something")))
    }

    @Test
    fun whenProvidedShouldAddIdempotencyHeaderToRequest() {
        val request =
            HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build()
        stubFor(
            post(urlPathEqualTo("/something"))
                .withHeader("X-Some-Header", matching("stainless-java-retry-.+"))
                .willReturn(ok())
        )
        val retryingClient =
            RetryingHttpClient.builder()
                .httpClient(httpClient)
                .maxRetries(2)
                .idempotencyHeader("X-Some-Header")
                .build()
        val response = retryingClient.execute(request)
        assertThat(response.statusCode()).isEqualTo(200)
        verify(1, postRequestedFor(urlPathEqualTo("/something")))
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun retryAfterHeader(async: Boolean) {
        val request =
            HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build()
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
                .inScenario("foo") // then we fail with a retry after header given as a delay
                .whenScenarioStateIs("RETRY_AFTER_DATE")
                .willReturn(serviceUnavailable().withHeader("Retry-After", "1.234"))
                .willSetStateTo("RETRY_AFTER_DELAY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo") // then we return a success
                .whenScenarioStateIs("RETRY_AFTER_DELAY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val retryingClient =
            RetryingHttpClient.builder().httpClient(httpClient).maxRetries(2).build()

        val response =
            if (async) retryingClient.executeAsync(request).get()
            else retryingClient.execute(request)

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("0"))
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("1"))
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("2"))
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun overwriteRetryCountHeader(async: Boolean) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegment("something")
                .putHeader("x-stainless-retry-count", "42")
                .build()
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
        val retryingClient =
            RetryingHttpClient.builder().httpClient(httpClient).maxRetries(2).build()

        val response =
            if (async) retryingClient.executeAsync(request).get()
            else retryingClient.execute(request)

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            2,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("42"))
        )
    }

    @Test
    fun retryAfterMsHeader() {
        val request =
            HttpRequest.builder().method(HttpMethod.POST).addPathSegment("something").build()
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
        val retryingClient =
            RetryingHttpClient.builder().httpClient(httpClient).maxRetries(1).build()
        val response = retryingClient.execute(request)
        assertThat(response.statusCode()).isEqualTo(200)
        verify(2, postRequestedFor(urlPathEqualTo("/something")))
    }
}
