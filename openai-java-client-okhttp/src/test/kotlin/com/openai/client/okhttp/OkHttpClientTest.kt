package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.ClientOptions
import com.openai.core.LogLevel
import com.openai.core.RequestOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.LoggingHttpClient
import com.openai.core.http.RequestObserver
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream
import java.util.concurrent.CopyOnWriteArrayList
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
    fun loggedUrl_matchesSentUrl() {
        assertLoggedUrlMatchesSentUrl(async = false)
    }

    @Test
    @ResourceLock("stderr")
    fun loggedUrlAsync_matchesSentUrl() {
        assertLoggedUrlMatchesSentUrl(async = true)
    }

    private fun assertLoggedUrlMatchesSentUrl(async: Boolean) {
        stubFor(get(anyUrl()).willReturn(ok()))
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("$baseUrl/v1/?existing=base%20value")
                .addPathSegment("user name+%/?#雪~@")
                .putQueryParams("filter", listOf("a+b c/%?#雪", "second value"))
                .build()
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
        assertThat(output.toString("UTF-8")).contains("--> GET $sentUrl\n")
        assertThat(sentUrl)
            .isEqualTo(
                "$baseUrl/v1/user%20name+%25%2F%3F%23%E9%9B%AA~@" +
                    "?existing=base%20value" +
                    "&filter=a%2Bb%20c%2F%25%3F%23%E9%9B%AA&filter=second%20value"
            )
    }

    @Test
    @ResourceLock("stderr")
    fun observedRequest_logsBeforeWritingBody() {
        stubFor(post(anyUrl()).willReturn(ok()))
        val output = ByteArrayOutputStream()
        val originalErr = System.err
        val loggingClient =
            LoggingHttpClient.builder().httpClient(httpClient).level(LogLevel.DEBUG).build()
        try {
            System.setErr(PrintStream(output, true, "UTF-8"))
            listOf(false, true).forEach { async ->
                output.reset()
                val events = CopyOnWriteArrayList<String>()
                val expectedUrl = "$baseUrl/body%20$async"
                val body =
                    object : HttpRequestBody {
                        override fun writeTo(outputStream: OutputStream) {
                            assertThat(events).containsExactly("observed")
                            assertThat(output.toString("UTF-8"))
                                .contains("--> POST $expectedUrl (unknown-length body)\n")
                                .contains("x-test-header: example\n")
                            events.add("body")
                            outputStream.write("example body".toByteArray(Charsets.UTF_8))
                        }

                        override fun contentType(): String = "text/plain"

                        override fun contentLength(): Long = -1

                        override fun repeatable(): Boolean = false

                        override fun close() {}
                    }
                val request =
                    HttpRequest.builder()
                        .method(HttpMethod.POST)
                        .baseUrl(baseUrl)
                        .addPathSegment("body $async")
                        .putHeader("x-test-header", "example")
                        .body(body)
                        .build()
                val observer = RequestObserver { method, url ->
                    assertThat(method).isEqualTo(HttpMethod.POST)
                    assertThat(url).isEqualTo(expectedUrl)
                    events.add("observed")
                }

                val response =
                    if (async)
                        loggingClient
                            .executeAsync(request, RequestOptions.none(), observer)
                            .get(5, TimeUnit.SECONDS)
                    else loggingClient.execute(request, RequestOptions.none(), observer)
                response.use { assertThat(it.statusCode()).isEqualTo(200) }

                assertThat(events).containsExactly("observed", "body")
                assertThat(output.toString("UTF-8"))
                    .contains("example body\n--> END POST (12-byte body)")
            }
        } finally {
            System.setErr(originalErr)
            loggingClient.close()
        }
    }

    @Test
    fun executeAsync_keepsObserversScopedToEachRequest() {
        stubFor(get(anyUrl()).willReturn(ok().withFixedDelay(100)))
        val firstUrls = CopyOnWriteArrayList<String?>()
        val secondUrls = CopyOnWriteArrayList<String?>()
        val firstRequest =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(baseUrl)
                .addPathSegment("first request")
                .build()
        val secondRequest = firstRequest.toBuilder().pathSegments(listOf("second+request")).build()

        val firstResponse =
            httpClient.executeAsync(
                firstRequest,
                RequestOptions.none(),
                RequestObserver { _, url -> firstUrls.add(url) },
            )
        val secondResponse =
            httpClient.executeAsync(
                secondRequest,
                RequestOptions.none(),
                RequestObserver { _, url -> secondUrls.add(url) },
            )

        firstResponse.get(5, TimeUnit.SECONDS).use { assertThat(it.statusCode()).isEqualTo(200) }
        secondResponse.get(5, TimeUnit.SECONDS).use { assertThat(it.statusCode()).isEqualTo(200) }
        assertThat(firstUrls).containsExactly("$baseUrl/first%20request")
        assertThat(secondUrls).containsExactly("$baseUrl/second+request")
    }

    @Test
    fun observerFailure_doesNotPreventDispatchOrBodyCleanup() {
        stubFor(post(anyUrl()).willReturn(ok()))
        listOf(false, true).forEach { async ->
            val bodyClosed = CountDownLatch(1)
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("observer failure")
                    .body(
                        object : HttpRequestBody {
                            override fun writeTo(outputStream: OutputStream) {
                                outputStream.write("example body".toByteArray(Charsets.UTF_8))
                            }

                            override fun contentType(): String = "text/plain"

                            override fun contentLength(): Long = 12

                            override fun repeatable(): Boolean = false

                            override fun close() {
                                bodyClosed.countDown()
                            }
                        }
                    )
                    .build()
            val observer = RequestObserver { _, _ ->
                throw IllegalStateException("observer failed")
            }

            val response =
                if (async)
                    httpClient
                        .executeAsync(request, RequestOptions.none(), observer)
                        .get(5, TimeUnit.SECONDS)
                else httpClient.execute(request, RequestOptions.none(), observer)
            response.use { assertThat(it.statusCode()).isEqualTo(200) }
            assertThat(bodyClosed.await(5, TimeUnit.SECONDS)).isTrue()
        }

        verify(
            2,
            postRequestedFor(urlEqualTo("/observer%20failure"))
                .withRequestBody(equalTo("example body")),
        )
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
