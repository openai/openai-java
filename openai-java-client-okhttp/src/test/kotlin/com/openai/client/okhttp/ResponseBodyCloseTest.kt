package com.openai.client.okhttp

import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.ProxyAuthenticator
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.ProxySelector
import java.util.Optional
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import javax.net.SocketFactory
import okhttp3.Address
import okhttp3.Authenticator
import okhttp3.Call
import okhttp3.ConnectionSpec
import okhttp3.Dns
import okhttp3.EventListener
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Route
import okio.Buffer
import okio.BufferedSource
import okio.Source
import okio.Timeout
import okio.buffer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class ResponseBodyCloseTest {
    @TestFactory
    fun closeCancelsItsReadBeforeWaitingAndClosesBodyOnlyAfterReadUnwinds() =
        listOf(false, true).flatMap { async ->
            listOf(false, true).map { closeStream ->
                dynamicTest("async=$async closeStream=$closeStream") {
                    val entered = CountDownLatch(1)
                    val cancelled = CountDownLatch(1)
                    val release = CountDownLatch(1)
                    val closes = AtomicInteger()
                    val cancellationCount = AtomicInteger()
                    val readerError = AtomicReference<Throwable>()
                    val closerError = AtomicReference<Throwable>()
                    val body =
                        object : ResponseBody() {
                            private val buffered =
                                object : Source {
                                        override fun read(sink: Buffer, byteCount: Long): Long {
                                            entered.countDown()
                                            check(release.await(5, TimeUnit.SECONDS))
                                            throw IOException("cancelled fixture read")
                                        }

                                        override fun timeout() = Timeout.NONE

                                        override fun close() {
                                            closes.incrementAndGet()
                                        }
                                    }
                                    .buffer()

                            override fun contentType(): MediaType? = null

                            override fun contentLength() = -1L

                            override fun source(): BufferedSource = buffered
                        }
                    client(
                            body,
                            object : EventListener() {
                                override fun canceled(call: Call) {
                                    cancellationCount.incrementAndGet()
                                    cancelled.countDown()
                                }
                            },
                        )
                        .use { client ->
                            val response =
                                if (async) client.executeAsync(request()).get(5, TimeUnit.SECONDS)
                                else client.execute(request())
                            val input = response.body()
                            val reader = Thread {
                                try {
                                    input.read()
                                } catch (e: Throwable) {
                                    readerError.set(e)
                                }
                            }
                            val closer = Thread {
                                try {
                                    if (closeStream) input.close() else response.close()
                                } catch (e: Throwable) {
                                    closerError.set(e)
                                }
                            }
                            try {
                                reader.start()
                                assertTrue(entered.await(5, TimeUnit.SECONDS))
                                closer.start()
                                assertTrue(
                                    cancelled.await(5, TimeUnit.SECONDS),
                                    "cancel must precede waiting for read",
                                )
                                val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                                while (
                                    closer.state != Thread.State.BLOCKED &&
                                        closer.isAlive &&
                                        System.nanoTime() < deadline
                                ) Thread.yield()
                                assertEquals(Thread.State.BLOCKED, closer.state)
                                assertEquals(
                                    0,
                                    closes.get(),
                                    "body must stay open until the held read unwinds",
                                )
                            } finally {
                                release.countDown()
                                reader.join(5000)
                                closer.join(5000)
                                response.close()
                            }
                            assertFalse(reader.isAlive)
                            assertFalse(closer.isAlive)
                            assertInstanceOf(IOException::class.java, readerError.get())
                            assertNull(closerError.get())
                            assertEquals(1, closes.get())
                            assertThrows(IOException::class.java) { input.read() }
                            client.execute(request()).use { reused ->
                                assertEquals(
                                    "reused",
                                    reused.body().readBytes().toString(Charsets.UTF_8),
                                )
                            }
                            assertEquals(1, cancellationCount.get())
                        }
                }
            }
        }

    @Test
    fun normalEofAndRepeatedCloseDoNotCancelCallOrCloseSharedClient() {
        val cancellations = AtomicInteger()
        val closes = AtomicInteger()
        val native =
            okhttp3.OkHttpClient.Builder()
                .eventListener(
                    object : EventListener() {
                        override fun canceled(call: Call) {
                            cancellations.incrementAndGet()
                        }
                    }
                )
                .addInterceptor { chain ->
                    response(
                        chain.request(),
                        object : ResponseBody() {
                            val buffered = Buffer().writeUtf8("abc")

                            override fun contentType(): MediaType? = null

                            override fun contentLength() = 3L

                            override fun source(): BufferedSource = buffered

                            override fun close() {
                                closes.incrementAndGet()
                                super.close()
                            }
                        },
                    )
                }
                .build()
        OkHttpClient(native).use { client ->
            repeat(2) {
                val response = client.execute(request())
                assertEquals("abc", response.body().readBytes().toString(Charsets.UTF_8))
                response.body().close()
                response.close()
            }
            assertEquals(0, cancellations.get())
            assertEquals(2, closes.get())
            assertFalse(native.dispatcher.executorService.isShutdown)
        }
    }

    private fun request() =
        HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://example.test").build()

    private fun client(body: ResponseBody, listener: EventListener): OkHttpClient {
        val requests = AtomicInteger()
        return OkHttpClient(
            okhttp3.OkHttpClient.Builder()
                .eventListener(listener)
                .addInterceptor { chain ->
                    response(
                        chain.request(),
                        if (requests.getAndIncrement() == 0) body else "reused".toResponseBody(),
                    )
                }
                .build()
        )
    }

    @Test
    fun proxyAuthenticatorCanInspectHeadersWithoutAResponseBody() {
        val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 8080))
        val request = Request.Builder().url("http://example.test/resource").build()
        val route =
            Route(
                Address(
                    request.url.host,
                    request.url.port,
                    Dns.SYSTEM,
                    SocketFactory.getDefault(),
                    null,
                    null,
                    null,
                    Authenticator.NONE,
                    proxy,
                    listOf(Protocol.HTTP_1_1),
                    listOf(ConnectionSpec.CLEARTEXT),
                    ProxySelector.getDefault(),
                ),
                proxy,
                InetSocketAddress("127.0.0.1", 8080),
            )
        val challenge =
            Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(407)
                .message("Proxy Authentication Required")
                .header("Proxy-Authenticate", "Basic realm=fixture")
                .build()
        val calls = AtomicInteger()
        OkHttpClient.builder()
            .proxyAuthenticator(
                ProxyAuthenticator { _, _, response ->
                    assertEquals(407, response.statusCode())
                    assertEquals(
                        listOf("Basic realm=fixture"),
                        response.headers().values("Proxy-Authenticate"),
                    )
                    calls.incrementAndGet()
                    Optional.empty()
                }
            )
            .build()
            .use { client ->
                assertNull(client.okHttpClient.proxyAuthenticator.authenticate(route, challenge))
            }
        assertEquals(1, calls.get())
    }

    private fun response(request: okhttp3.Request, body: ResponseBody) =
        Response.Builder()
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .code(200)
            .message("OK")
            .body(body)
            .build()
}
