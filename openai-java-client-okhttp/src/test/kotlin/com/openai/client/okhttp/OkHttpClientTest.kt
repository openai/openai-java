package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import okhttp3.Interceptor
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
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
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
    fun execute_runsConfiguredApplicationInterceptor() {
        stubFor(get(urlPathEqualTo("/something")).willReturn(ok()))
        val client =
            OkHttpClient.builder()
                .addInterceptor(
                    Interceptor { chain ->
                        chain.proceed(
                            chain
                                .request()
                                .newBuilder()
                                .header("X-Test-Interceptor", "applied")
                                .build()
                        )
                    }
                )
                .build()

        client
            .execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build()
            )
            .use { assertThat(it.statusCode()).isEqualTo(200) }

        verify(
            1,
            getRequestedFor(urlPathEqualTo("/something"))
                .withHeader("X-Test-Interceptor", equalTo("applied")),
        )
        client.close()
    }
}
