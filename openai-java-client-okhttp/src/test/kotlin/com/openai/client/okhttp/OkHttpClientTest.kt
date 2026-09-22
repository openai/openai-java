package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.RetryingHttpClient
import com.openai.core.http.multipartFormData
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIIoException
import com.openai.models.images.ImageEditParams
import java.io.FilterInputStream
import java.io.IOException
import java.io.OutputStream
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.Call
import okhttp3.EventListener
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import okio.Buffer
import okio.BufferedSource
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
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

    @TestFactory
    fun syncBodyCloseFailurePreservesOperationAndReleasesResponse() =
        listOf(false, true).map { transportFails ->
            dynamicTest("transportFails=$transportFails") {
                val transportFailure = IOException("test transport failure")
                val closeFailure = IllegalStateException("test body close failure")
                val responseBody = TrackingResponseBody()
                var closeCalls = 0
                val body =
                    object : HttpRequestBody {
                        override fun writeTo(outputStream: OutputStream) {}

                        override fun contentType() = "application/octet-stream"

                        override fun contentLength() = 0L

                        override fun repeatable() = false

                        override fun close() {
                            closeCalls++
                            throw closeFailure
                        }
                    }
                val interceptor = Interceptor { chain ->
                    if (transportFails) throw transportFailure
                    Response.Builder()
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .message("OK")
                        .body(responseBody)
                        .build()
                }
                OkHttpClient(okhttp3.OkHttpClient.Builder().addInterceptor(interceptor).build())
                    .use { client ->
                        val failure = catchThrowable {
                            client.execute(
                                HttpRequest.builder()
                                    .method(HttpMethod.POST)
                                    .baseUrl("https://example.test")
                                    .body(body)
                                    .build()
                            )
                        }
                        if (transportFails) {
                            assertThat(failure).isInstanceOf(OpenAIIoException::class.java)
                            assertThat(failure.cause).isSameAs(transportFailure)
                            assertThat(failure.suppressed).containsExactly(closeFailure)
                        } else {
                            assertThat(failure).isSameAs(closeFailure)
                            assertThat(responseBody.closed.count).isZero()
                        }
                        assertThat(closeCalls).isEqualTo(1)
                    }
            }
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
    fun cancellingMultipartUploadAbortsCallWaitingForResponse() {
        val callFailed = CountDownLatch(1)
        val closes = AtomicInteger()
        val stream =
            object : FilterInputStream(byteArrayOf(1, 2, 3).inputStream()) {
                override fun close() {
                    closes.incrementAndGet()
                    super.close()
                }
            }
        val listener =
            object : EventListener() {
                override fun callFailed(call: Call, ioe: IOException) {
                    callFailed.countDown()
                }
            }
        MockWebServer().use { server ->
            server.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE))
            server.start()
            val transport =
                OkHttpClient(
                    okhttp3.OkHttpClient.Builder()
                        .eventListener(listener)
                        .callTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build()
                )
            RetryingHttpClient.builder().httpClient(transport).maxRetries(0).build().use { client ->
                val params = ImageEditParams.builder().prompt("test").image(stream).build()
                val request =
                    HttpRequest.builder()
                        .method(HttpMethod.POST)
                        .baseUrl(server.url("/").toString())
                        .body(multipartFormData(jsonMapper(), params._body()))
                        .build()
                val result = client.executeAsync(request)
                try {
                    assertThat(server.takeRequest(5, TimeUnit.SECONDS)).isNotNull()
                    val call = transport.okHttpClient.dispatcher.runningCalls().single()
                    assertThat(result.isDone).isFalse()

                    assertThat(result.cancel(true)).isTrue()

                    assertThat(call.isCanceled()).isTrue()
                    assertThat(callFailed.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(closes.get()).isEqualTo(1)
                } finally {
                    transport.okHttpClient.dispatcher.cancelAll()
                }
            }
        }
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
