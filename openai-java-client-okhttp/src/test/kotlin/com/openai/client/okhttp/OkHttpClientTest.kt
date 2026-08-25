package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
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
    fun completeOrCloseResponse_whenCancellationWins_closesTheDroppedResponse() {
        val future = CompletableFuture<HttpResponse>()
        val response = TrackingHttpResponse()
        assertThat(future.cancel(true)).isTrue()

        completeOrCloseResponse(future, response)

        assertThat(future.isCancelled).isTrue()
        assertThat(response.closed).isTrue()
    }

    @Test
    fun completeOrCloseResponse_whenCompletionWins_transfersResponseOwnership() {
        val future = CompletableFuture<HttpResponse>()
        val response = TrackingHttpResponse()

        completeOrCloseResponse(future, response)

        assertThat(future.get()).isSameAs(response)
        assertThat(response.closed).isFalse()
    }

    @Test
    fun close_cancelsSyncAndAsyncResponseBodyReadsAfterHeaders() {
        listOf(false, true).forEach { async ->
            val server = MockWebServer()
            val client = OkHttpClient.builder().build()
            val executor = Executors.newCachedThreadPool()
            try {
                server.start()
                server.enqueue(
                    MockResponse()
                        .setBody("partial")
                        .setHeader("Content-Length", 100)
                        .setSocketPolicy(SocketPolicy.KEEP_OPEN)
                )
                val request =
                    HttpRequest.builder()
                        .method(HttpMethod.GET)
                        .baseUrl(server.url("/").toString())
                        .build()
                val response =
                    if (async) client.executeAsync(request).get(5, TimeUnit.SECONDS)
                    else
                        executor
                            .submit<HttpResponse> { client.execute(request) }
                            .get(5, TimeUnit.SECONDS)
                val readStarted = CountDownLatch(1)
                val readFuture =
                    executor.submit<Int> {
                        readStarted.countDown()
                        response.body().readBytes().size
                    }
                assertThat(readStarted.await(5, TimeUnit.SECONDS)).isTrue()

                client.close()

                try {
                    readFuture.get(5, TimeUnit.SECONDS)
                } catch (_: ExecutionException) {}
                assertThat(readFuture.isDone).isTrue()
                response.close()
            } finally {
                client.close()
                executor.shutdownNow()
                server.close()
            }
        }
    }
}

private class TrackingHttpResponse : HttpResponse {
    var closed = false
        private set

    override fun statusCode(): Int = 200

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): ByteArrayInputStream = ByteArrayInputStream(byteArrayOf())

    override fun close() {
        closed = true
    }
}
