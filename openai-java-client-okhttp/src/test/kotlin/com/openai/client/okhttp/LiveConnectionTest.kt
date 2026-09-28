package com.openai.client.okhttp

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.jsonMapper
import com.openai.helpers.LiveConnection
import com.openai.helpers.LiveWebSocketOptions
import com.openai.models.live.ClientEvent
import com.openai.models.live.SessionCloseEvent
import com.openai.models.live.SessionConfig
import com.openai.models.live.SessionStartEvent
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.assertThrows

@Timeout(25)
class LiveConnectionTest {
    private val mapper = jsonMapper()

    private fun start() =
        ClientEvent.ofSessionStart(
            SessionStartEvent.builder()
                .session(SessionConfig.builder().model("live-test").build())
                .eventId("start-1")
                .build()
        )

    private fun finish() = ClientEvent.ofSessionClose(SessionCloseEvent.builder().build())

    private class Peer : WebSocketListener() {
        val socket = CompletableFuture<WebSocket>()
        val messages = LinkedBlockingQueue<String>()
        val closed = CountDownLatch(1)

        override fun onOpen(webSocket: WebSocket, response: Response) {
            socket.complete(webSocket)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            messages.add(text)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            closed.countDown()
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            closed.countDown()
        }
    }

    private fun options(server: MockWebServer, http: HttpClient) =
        ClientOptions.builder()
            .httpClient(http)
            .apiKey("fake-live-key")
            .baseUrl(server.url("/proxy/v1?inherited=one%2Ftwo&x=a%2Bb").toString())
            .build()

    @Test
    fun primaryStartIsCallerDrivenThenUsageAndErrorsDrainOnSameReader() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val perSession =
                        LiveWebSocketOptions.builder()
                            .putHeader("X-Live-Request", "one")
                            .putQueryParam("graceful_close", "true")
                            .build()
                    val live =
                        if (async)
                            LiveConnection.connectAsync(options(server, http), perSession)
                                .get(8, TimeUnit.SECONDS)
                        else LiveConnection.connect(options(server, http), perSession)
                    live.use { conn ->
                        val request = server.takeRequest(8, TimeUnit.SECONDS)!!
                        assertThat(request.requestUrl!!.encodedPath)
                            .isEqualTo("/proxy/v1/live/sessions")
                        assertThat(request.requestUrl!!.queryParameter("inherited"))
                            .isEqualTo("one/two")
                        assertThat(request.requestUrl!!.queryParameter("x")).isEqualTo("a+b")
                        assertThat(request.requestUrl!!.queryParameter("graceful_close"))
                            .isEqualTo("true")
                        assertThat(request.requestUrl!!.queryParameter("model")).isNull()
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer fake-live-key")
                        assertThat(request.getHeader("X-Live-Request")).isEqualTo("one")
                        assertThat(peer.messages.poll(200, TimeUnit.MILLISECONDS)).isNull()

                        conn.send(start())
                        val sent = mapper.readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                        assertThat(sent.path("type").asText()).isEqualTo("session.start")
                        assertThat(sent.at("/session/model").asText()).isEqualTo("live-test")
                        val socket = peer.socket.get(8, TimeUnit.SECONDS)
                        socket.send(
                            """{"type":"session.started","event_id":"ready","session":{"id":"test-session"}}"""
                        )
                        val ready =
                            if (async) conn.receiveAsync().get(8, TimeUnit.SECONDS)
                            else conn.receive()
                        assertThat(ready.isSessionStarted()).isTrue()
                        assertThat(ready.asSessionStarted().eventId()).isEqualTo("ready")
                        conn.send(finish())
                        assertThat(
                                mapper
                                    .readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                                    .path("type")
                                    .asText()
                            )
                            .isEqualTo("session.close")
                        socket.send(
                            """{"type":"error","event_id":"failure","error":{"code":"session_storage_failed","message":"fixture"}}"""
                        )
                        socket.send(
                            """{"type":"session.output_transcript.delta","event_id":"last-text","delta":"final words","turn_id":"turn-1"}"""
                        )
                        socket.send(
                            """{"type":"session.closed","event_id":"closed","session":{"id":"test-session"},"reason":"client_request"}"""
                        )
                        val error = conn.receiveAsync().get(8, TimeUnit.SECONDS)
                        assertThat(error.isErrorEvent()).isTrue()
                        assertThat(mapper.valueToTree<JsonNode>(error).at("/error/code").asText())
                            .isEqualTo("session_storage_failed")
                        assertThat(conn.receive().isSessionOutputTranscriptDelta()).isTrue()
                        assertThat(conn.receive().isSessionClosed()).isTrue()
                    }
                    assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun closeWithoutFinishDoesNotInventSessionCloseOrAcknowledgeReadiness() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveConnection.connect(options(server, http)).use {}
                assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThat(peer.messages).isEmpty()
            }
        }
    }

    @Test
    fun timeoutAndCancellationReleaseOnlyUnclaimedReadForNextEvent() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveConnection.connect(options(server, http)).use { live ->
                    val first = live.receiveAsync()
                    assertThatThrownBy { first.get(100, TimeUnit.MILLISECONDS) }
                        .isInstanceOf(TimeoutException::class.java)
                    assertThatThrownBy { live.receiveAsync() }
                        .hasMessageContaining("already pending")
                    assertThat(first.cancel(false)).isTrue()
                    val next = live.receiveAsync()
                    peer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send(
                            """{"type":"session.started","event_id":"after-cancel","session":{}}"""
                        )
                    assertThat(next.get(8, TimeUnit.SECONDS).asSessionStarted().eventId())
                        .isEqualTo("after-cancel")
                }
            }
        }
    }

    @Test
    fun closeReleasesPendingReadAndSharedClientIsStillUsable() {
        MockWebServer().use { server ->
            val first = Peer()
            val second = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(first))
            server.enqueue(MockResponse().withWebSocketUpgrade(second))
            OkHttpClient.builder().build().use { http ->
                val configuration = options(server, http)
                val live = LiveConnection.connect(configuration)
                val read = live.receiveAsync()
                live.close()
                assertThatThrownBy { read.get(8, TimeUnit.SECONDS) }
                    .hasMessageContaining("Live connection closed")
                LiveConnection.connect(configuration).use {
                    it.send(start())
                    assertThat(
                            mapper
                                .readTree(second.messages.poll(8, TimeUnit.SECONDS))
                                .path("event_id")
                                .asText()
                        )
                        .isEqualTo("start-1")
                }
                assertThat(first.messages).isEmpty()
            }
        }
    }

    @Test
    fun largeUnknownForwardEventAndFinalEventFollowedByEofAreRetained() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveConnection.connect(options(server, http)).use { live ->
                    val payload = "x".repeat(12 * 1024 * 1024)
                    val socket = peer.socket.get(8, TimeUnit.SECONDS)
                    assertThat(socket.send("""{"type":"live.future","data":"$payload"}""")).isTrue()
                    val unknown = live.receive()
                    assertThat(unknown._json()).isPresent()
                    assertThat(mapper.valueToTree<JsonNode>(unknown).get("data").textValue())
                        .isEqualTo(payload)
                    socket.send("""{"type":"session.closed","event_id":"terminal","session":{}}""")
                    socket.close(1000, "done")
                    assertThat(live.receive().asSessionClosed().eventId()).isEqualTo("terminal")
                    assertThatThrownBy { live.receive() }.hasMessageContaining("WebSocket")
                }
            }
        }
    }

    @Test
    fun explicitQueueBoundsKeepAcceptedEventsBeforeFailure() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val limited = LiveWebSocketOptions.builder().maxQueuedEvents(1).build()
                LiveConnection.connect(options(server, http), limited).use { live ->
                    val socket = peer.socket.get(8, TimeUnit.SECONDS)
                    socket.send("""{"type":"live.future","sequence":1}""")
                    socket.send("""{"type":"live.future","sequence":2}""")
                    assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                    assertThat(mapper.valueToTree<JsonNode>(live.receive()).get("sequence").asInt())
                        .isEqualTo(1)
                    assertThatThrownBy { live.receive() }.hasMessageContaining("WebSocket")
                }
            }
        }
    }

    @Test
    fun callbackBlockingOnReceiveDoesNotStarveNativeTransportReader() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(
                MockResponse()
                    .setHeadersDelay(100, TimeUnit.MILLISECONDS)
                    .withWebSocketUpgrade(peer)
            )
            OkHttpClient.builder().build().use { http ->
                val direct =
                    options(server, http).toBuilder().streamHandlerExecutor { it.run() }.build()
                val result =
                    LiveConnection.connectAsync(direct).thenApply { live ->
                        live.use { it.receive() }
                    }
                peer.socket
                    .get(8, TimeUnit.SECONDS)
                    .send("""{"type":"live.ready","value":"synthetic"}""")
                assertThat(result.get(8, TimeUnit.SECONDS)._json()).isPresent()
            }
        }
    }

    @Test
    fun singleThreadCallbackCanMakeNextBlockingReceive() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val single = Executors.newSingleThreadExecutor()
                try {
                    val client =
                        options(server, http).toBuilder().streamHandlerExecutor(single).build()
                    LiveConnection.connect(client).use { live ->
                        val inCallback = CountDownLatch(1)
                        val second =
                            live.receiveAsync().thenApply {
                                inCallback.countDown()
                                live.receive()
                            }
                        val socket = peer.socket.get(8, TimeUnit.SECONDS)
                        socket.send("""{"type":"live.first"}""")
                        assertThat(inCallback.await(5, TimeUnit.SECONDS)).isTrue()
                        socket.send(
                            """{"type":"session.started","event_id":"second","session":{}}"""
                        )
                        assertThat(second.get(3, TimeUnit.SECONDS).asSessionStarted().eventId())
                            .isEqualTo("second")
                    }
                } finally {
                    single.shutdownNow()
                }
            }
        }
    }

    @Test
    fun failureCleanupNeverJoinsItsOwnReaderAndSettlesPendingReceive() {
        for (malformed in listOf(true, false)) {
            val http = FakeTransport()
            val readerExited = CountDownLatch(1)
            val enteredClose = CountDownLatch(1)
            http.onClose = {
                enteredClose.countDown()
                check(readerExited.await(3, TimeUnit.SECONDS)) { "closed on transport reader" }
            }
            val client = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
            LiveConnection.connect(client).use { live ->
                val pending = live.receiveAsync()
                val reader = Thread {
                    try {
                        if (malformed) http.listener!!.onMessage("""{"type":5}""")
                        else http.listener!!.onFailure(IOException("transport ended"))
                    } finally {
                        readerExited.countDown()
                    }
                }
                reader.start()
                assertThat(enteredClose.await(4, TimeUnit.SECONDS)).isTrue()
                val error = assertThrows<ExecutionException> { pending.get(4, TimeUnit.SECONDS) }
                assertThat(error.cause!!.suppressed).isEmpty()
                assertThat(error.cause!!.message)
                    .contains(if (malformed) "Invalid Live event" else "transport ended")
                assertThat(readerExited.await(4, TimeUnit.SECONDS)).isTrue()
                reader.join()
            }
        }
    }

    @Test
    fun retiredHandshakeWithThrowingTransportCloseStillCompletesTheOpening() {
        FakeTransport().use { http ->
            val original = IOException("failed before open acknowledgement")
            val closing = AssertionError("close failed")
            http.closeFailure = closing
            http.onOpen = { it.onFailure(original) }
            val client = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
            assertThatThrownBy { LiveConnection.connectAsync(client).get(3, TimeUnit.SECONDS) }
                .hasCause(original)
            assertThat(original.suppressed).containsExactly(closing)
        }
    }

    @Test
    fun malformedEventIsTerminalButJsonValidationCanRemainForwardCompatible() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http).toBuilder().responseValidation(true).build()
                LiveConnection.connect(
                        configuration,
                        LiveWebSocketOptions.defaults(),
                        RequestOptions.builder().responseValidation(false).build(),
                    )
                    .use { live ->
                        val socket = peer.socket.get(8, TimeUnit.SECONDS)
                        socket.send("""{"type":"live.future","data":{"nested":true}}""")
                        assertThat(live.receive()._json()).isPresent()
                        socket.send("""{"type":5}""")
                        assertThatThrownBy { live.receive() }
                            .hasMessageContaining("Invalid Live event")
                        assertThatThrownBy { live.send(start()) }
                            .hasMessageContaining("not connected")
                    }
            }
        }
    }

    private class FakeTransport : HttpClient, WebSocketClient {
        val opens = LinkedBlockingQueue<HttpRequest>()
        val writes = LinkedBlockingQueue<String>()
        var sendFailure: Throwable? = null
        var closeFailure: Throwable? = null
        var onClose: (() -> Unit)? = null
        var onOpen: ((WebSocketClient.Listener) -> Unit)? = null
        var listener: WebSocketClient.Listener? = null
        var closed = false

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            throw AssertionError("WebSocket request made as HTTP")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = throw AssertionError("WebSocket request made as HTTP")

        override fun close() {}

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            opens.add(request)
            this.listener = listener
            onOpen?.invoke(listener)
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {
                        writes.add(text)
                        sendFailure?.let { throw it }
                    }

                    override fun close() {
                        closed = true
                        onClose?.invoke()
                        closeFailure?.let { throw it }
                    }
                }
            )
        }
    }

    @Test
    fun customTransportAndAuthenticatorCanUseCanonicalUrlWithInheritedQuery() {
        FakeTransport().use { http ->
            val client =
                ClientOptions.builder()
                    .httpClient(http)
                    .apiKey("fake-key")
                    .baseUrl("https://api.openai.com/proxy/v1?seen=a%2Fb&phrase=plus%2Bspace+here")
                    .build()
            val options =
                LiveWebSocketOptions.builder().putQueryParam("graceful_close", "true").build()
            LiveConnection.connect(client, options).use {
                val sent = http.opens.poll(8, TimeUnit.SECONDS)
                assertThat(sent.url())
                    .isEqualTo(
                        "https://api.openai.com/proxy/v1/live/sessions?seen=a%2Fb&phrase=plus%2Bspace+here&graceful_close=true"
                    )
                assertThat(sent.headers.values("Authorization")).containsExactly("Bearer fake-key")
            }
        }
    }

    @Test
    fun unknownAttemptedWritePoisonsIncludingErrorsAndCleanupNeverStrandsReader() {
        for (failure in listOf(IOException("failed"), AssertionError("failed"))) {
            FakeTransport().use { http ->
                val client = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
                LiveConnection.connect(client).use { live ->
                    val read = live.receiveAsync()
                    http.sendFailure = failure
                    http.closeFailure = AssertionError("close failed")
                    assertThatThrownBy { live.send(start()) }.isSameAs(failure)
                    assertThatThrownBy { read.get(8, TimeUnit.SECONDS) }.hasCause(failure)
                    assertThat(failure.suppressed).containsExactly(http.closeFailure)
                    assertThat(http.closed).isTrue()
                    assertThatThrownBy { live.send(start()) }.hasMessageContaining("not connected")
                    assertThat(http.writes).hasSize(1)
                }
            }
        }
    }

    @Test
    fun provenUnattemptedWriteLeavesLiveUsableWithoutSilentReplay() {
        FakeTransport().use { http ->
            val client = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
            LiveConnection.connect(client).use { live ->
                http.sendFailure = WebSocketWriteNotAttempted.Busy("synthetic busy")
                assertThatThrownBy { live.send(start()) }.hasMessage("synthetic busy")
                http.sendFailure = null
                live.send(finish())
                assertThat(http.writes).hasSize(2)
                assertThat(mapper.readTree(http.writes.poll()).path("type").asText())
                    .isEqualTo("session.start")
                assertThat(mapper.readTree(http.writes.poll()).path("type").asText())
                    .isEqualTo("session.close")
            }
        }
    }
}
