package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIIoException
import java.io.ByteArrayInputStream
import java.io.OutputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
    fun execute_afterClientClose_closesRequestBodyOnce() {
        val closeFailure = IllegalStateException("request body close failed")
        val body = CountingRequestBody(closeFailure)
        httpClient.close()

        val failure = runCatching { httpClient.execute(request(body)) }.exceptionOrNull()

        assertThat(failure)
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("HTTP client is closed")
        assertThat(failure!!.suppressed).containsExactly(closeFailure)
        assertThat(body.closes).isEqualTo(1)
    }

    @Test
    fun executeAsync_afterClientClose_closesRequestBodyOnce() {
        val body = CountingRequestBody()
        httpClient.close()

        assertThatThrownBy { httpClient.executeAsync(request(body)) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("HTTP client is closed")
        assertThat(body.closes).isEqualTo(1)
    }

    @Test
    fun execute_transportFailureSuppressesRequestBodyCloseFailure() {
        val server = MockWebServer()
        val closeFailure = IllegalStateException("request body close failed")
        val body = CountingRequestBody(closeFailure)
        try {
            server.start()
            server.enqueue(MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AT_START))

            val failure =
                runCatching { httpClient.execute(request(body, server.url("/").toString())) }
                    .exceptionOrNull()

            assertThat(failure).isInstanceOf(OpenAIIoException::class.java)
            assertThat(failure!!.suppressed).containsExactly(closeFailure)
            assertThat(body.closes).isEqualTo(1)
        } finally {
            server.close()
        }
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

    private fun request(body: HttpRequestBody, requestBaseUrl: String = baseUrl): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(requestBaseUrl)
            .addPathSegment("something")
            .body(body)
            .build()
}

private class CountingRequestBody(private val closeFailure: Throwable? = null) : HttpRequestBody {
    var closes = 0

    override fun writeTo(outputStream: OutputStream) {}

    override fun contentType(): String? = null

    override fun contentLength(): Long = 0

    override fun repeatable(): Boolean = true

    override fun close() {
        closes++
        closeFailure?.let { throw it }
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
