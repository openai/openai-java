package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class OkHttpClientTest {

    private lateinit var baseUrl: String
    private lateinit var httpClient: OkHttpClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        httpClient = OkHttpClient.builder().build()
    }

    @Test
    fun executeAsync_whenFutureCancelled_cancelsUnderlyingCall() {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok().withFixedDelay(1_000)))
        val responseFuture =
            httpClient.executeAsync(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build()
            )
        val call = httpClient.okHttpClient.dispatcher.runningCalls().single()

        responseFuture.cancel(false)

        // Should have cancelled the underlying call
        assertThat(call.isCanceled()).isTrue()
    }

    @Test
    fun execute_whenRequestRefusesRedirect_doesNotFollowTransportRedirect() {
        stubFor(get(urlPathEqualTo("/redirect")).willReturn(temporaryRedirect("/target")))
        stubFor(get(urlPathEqualTo("/target")).willReturn(ok()))

        val response =
            httpClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(baseUrl)
                    .addPathSegment("redirect")
                    .followRedirects(false)
                    .build()
            )

        response.use { assertThat(it.statusCode()).isBetween(300, 399) }
        verify(0, getRequestedFor(urlPathEqualTo("/target")))
    }
}
