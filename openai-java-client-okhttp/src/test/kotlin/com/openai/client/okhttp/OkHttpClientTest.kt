package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.ClientOptions
import com.openai.core.LogLevel
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import okhttp3.Call
import okhttp3.EventListener
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
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
    @ResourceLock("stderr")
    fun requestUrlAndLoggedUrl_matchSentUrl() = assertUrlMatchesSentUrl(async = false)

    @Test
    @ResourceLock("stderr")
    fun requestUrlAndLoggedUrlAsync_matchSentUrl() = assertUrlMatchesSentUrl(async = true)

    private fun assertUrlMatchesSentUrl(async: Boolean) {
        stubFor(get(anyUrl()).willReturn(ok()))
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("$baseUrl/v1/?existing=base%20value")
                .addPathSegment("user name+%/?#雪~@")
                .putQueryParams("filter", listOf("a+b c/%?#雪", "second value"))
                .build()
        val expectedUrl =
            "$baseUrl/v1/user%20name+%25%2F%3F%23%E9%9B%AA~@" +
                "?existing=base%20value" +
                "&filter=a%2Bb%20c%2F%25%3F%23%E9%9B%AA&filter=second%20value"
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("fake-api-key")
                .logLevel(LogLevel.INFO)
                .build()
        val output = ByteArrayOutputStream()
        val originalErr = System.err
        try {
            System.setErr(PrintStream(output, true, "UTF-8"))
            val response =
                if (async) clientOptions.httpClient.executeAsync(request).get(5, TimeUnit.SECONDS)
                else clientOptions.httpClient.execute(request)
            response.use { assertThat(it.statusCode()).isEqualTo(200) }
        } finally {
            System.setErr(originalErr)
            clientOptions.close()
        }

        val sentUrl = baseUrl + findAll(getRequestedFor(anyUrl())).single().url
        assertThat(request.url()).isEqualTo(expectedUrl)
        assertThat(sentUrl).isEqualTo(expectedUrl)
        assertThat(output.toString("UTF-8")).contains("--> GET $expectedUrl\n")
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
    fun executeAsync_whenResponseLosesCancellationRace_closesDroppedResponse() {
        val handoffStarted = CountDownLatch(1)
        val releaseHandoff = CountDownLatch(1)
        val responseBody = TrackingResponseBody()
        val interceptor = Interceptor { chain ->
            Response.Builder()
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .message("OK")
                .body(responseBody)
                .build()
        }
        val handoffListener =
            object : EventListener() {
                override fun callEnd(call: Call) {
                    handoffStarted.countDown()
                    check(releaseHandoff.await(5, TimeUnit.SECONDS))
                }
            }
        val client =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .eventListener(handoffListener)
                    .build()
            )

        client.use {
            val responseFuture =
                client.executeAsync(
                    HttpRequest.builder()
                        .method(HttpMethod.POST)
                        .baseUrl("https://example.test")
                        .build()
                )
            assertThat(handoffStarted.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(responseFuture.cancel(true)).isTrue()

            releaseHandoff.countDown()

            assertThat(responseBody.closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(responseFuture.isCancelled).isTrue()
        }
    }
}

private class TrackingResponseBody : ResponseBody() {
    val closed = CountDownLatch(1)
    private val source = Buffer()

    override fun contentType(): MediaType? = null

    override fun contentLength(): Long = 0

    override fun source(): BufferedSource = source

    override fun close() {
        super.close()
        closed.countDown()
    }
}
