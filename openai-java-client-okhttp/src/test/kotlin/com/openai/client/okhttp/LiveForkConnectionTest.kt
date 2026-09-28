package com.openai.client.okhttp

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.jsonMapper
import com.openai.helpers.LiveForkConnection
import com.openai.helpers.LiveWebSocketOptions
import com.openai.models.live.ForkSessionConfig
import com.openai.models.live.ForkSessionStartEvent
import com.openai.models.live.SessionCloseEvent
import com.openai.models.live.forks.ForkClientEvent
import java.io.IOException
import java.net.URI
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
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

@Timeout(28)
class LiveForkConnectionTest {
    private val mapper = jsonMapper()

    private fun start() =
        ForkClientEvent.ofSessionStart(
            ForkSessionStartEvent.builder().session(ForkSessionConfig.builder().build()).build()
        )

    private fun finish() = ForkClientEvent.ofSessionClose(SessionCloseEvent.builder().build())

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
            .apiKey("fake-fork-key")
            .baseUrl(server.url("/proxy/v1?inherited=one%2Ftwo&x=a%2Bb").toString())
            .build()

    @Test
    fun storedSessionIdIsOnePathSegmentAndOnlyCallerSendsForkStart() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val perSession =
                        LiveWebSocketOptions.builder()
                            .putHeader("X-Fork-Request", "fixture")
                            .putQueryParam("graceful_close", "true")
                            .build()
                    val id = "live-stored/a?x=2#done"
                    val fork =
                        if (async)
                            LiveForkConnection.connectAsync(options(server, http), id, perSession)
                                .get(8, TimeUnit.SECONDS)
                        else LiveForkConnection.connect(options(server, http), id, perSession)
                    fork.use { conn ->
                        val request = server.takeRequest(8, TimeUnit.SECONDS)!!
                        assertThat(request.method).isEqualTo("GET")
                        assertThat(request.requestUrl!!.pathSegments)
                            .containsExactly("proxy", "v1", "live", "sessions", id, "fork")
                        assertThat(request.requestUrl!!.queryParameter("inherited"))
                            .isEqualTo("one/two")
                        assertThat(request.requestUrl!!.queryParameter("x")).isEqualTo("a+b")
                        assertThat(request.requestUrl!!.queryParameter("graceful_close"))
                            .isEqualTo("true")
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer fake-fork-key")
                        assertThat(request.getHeader("X-Fork-Request")).isEqualTo("fixture")
                        assertThat(peer.messages.poll(180, TimeUnit.MILLISECONDS)).isNull()
                        val read = conn.receiveAsync()
                        assertThatThrownBy { read.get(100, TimeUnit.MILLISECONDS) }
                            .isInstanceOf(TimeoutException::class.java)
                        conn.send(start())
                        assertThat(mapper.readTree(peer.messages.poll(8, TimeUnit.SECONDS)))
                            .isEqualTo(mapper.readTree("""{"type":"session.start","session":{}}"""))
                        val socket = peer.socket.get(8, TimeUnit.SECONDS)
                        socket.send(
                            """{"type":"session.started","event_id":"fork-ready","session":{"id":"new-fork"}}"""
                        )
                        assertThat(read.get(8, TimeUnit.SECONDS).asSessionStarted().eventId())
                            .isEqualTo("fork-ready")
                        // This is a fork event type: do not coerce via the primary union.
                        socket.send(
                            """{"type":"session.input_audio.append","event_id":"reflected","audio":"AQID","timestamp":3}"""
                        )
                        val reflection =
                            if (async) conn.receiveAsync().get(8, TimeUnit.SECONDS)
                            else conn.receive()
                        assertThat(reflection.isSessionInputAudioAppend()).isTrue()
                        assertThat(mapper.valueToTree<JsonNode>(reflection).path("audio").asText())
                            .isEqualTo("AQID")
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
                            """{"type":"session.closed","event_id":"closed","session":{"id":"new-fork"},"reason":"client_request"}"""
                        )
                        val error = conn.receive()
                        assertThat(error.isErrorEvent()).isTrue()
                        assertThat(mapper.valueToTree<JsonNode>(error).at("/error/code").asText())
                            .isEqualTo("session_storage_failed")
                        assertThat(conn.receiveAsync().get(8, TimeUnit.SECONDS).isSessionClosed())
                            .isTrue()
                    }
                    assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun authorizationFailureAndUnstablePathNeverStartSessionOrConsumeSharedClient() {
        MockWebServer().use { server ->
            server.enqueue(MockResponse().setResponseCode(403).setBody("fixture"))
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client = options(server, http)
                for (id in listOf("", ".", "..")) {
                    assertThatThrownBy { LiveForkConnection.connect(client, id) }
                        .isInstanceOf(IllegalArgumentException::class.java)
                }
                assertThat(server.requestCount).isZero()
                assertThatThrownBy { LiveForkConnection.connect(client, "unavailable-stored-id") }
                    .hasMessageNotContaining("fake-fork-key")
                val refused = server.takeRequest(8, TimeUnit.SECONDS)!!
                assertThat(refused.requestUrl!!.encodedPath)
                    .isEqualTo("/proxy/v1/live/sessions/unavailable-stored-id/fork")
                LiveForkConnection.connectAsync(client, "eligible-stored-id")
                    .get(8, TimeUnit.SECONDS)
                    .use {}
                assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThat(peer.messages).isEmpty()
            }
        }
    }

    @Test
    fun customAndOkHttpForksAddressTheSameStoredIdWithSpaces() {
        verifyForkRouteAcrossTransports("stored id")
    }

    @Test
    fun customAndOkHttpForksAddressTheSameStoredIdWithLiteralPlus() {
        verifyForkRouteAcrossTransports("stored+id")
    }

    private fun verifyForkRouteAcrossTransports(id: String) {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { sdkHttp ->
                WriteTransport().use { otherHttp ->
                    val perSession =
                        LiveWebSocketOptions.builder()
                            .putHeader("X-Fork-Request", "fixture")
                            .putQueryParam("graceful_close", "true")
                            .build()
                    LiveForkConnection.connect(options(server, sdkHttp), id, perSession).use { fork
                        ->
                        LiveForkConnection.connectAsync(options(server, otherHttp), id, perSession)
                            .get(8, TimeUnit.SECONDS)
                            .use { other ->
                                val wire = server.takeRequest(8, TimeUnit.SECONDS)!!
                                val custom = otherHttp.opens.poll(8, TimeUnit.SECONDS)!!
                                val customUrl = URI(custom.url())
                                val sdkUrl = wire.requestUrl!!.toUri()
                                assertThat(customUrl.path)
                                    .isEqualTo("/proxy/v1/live/sessions/$id/fork")
                                assertThat(sdkUrl.path)
                                    .isEqualTo("/proxy/v1/live/sessions/$id/fork")
                                // Authenticators consuming HttpRequest.url() must see the same
                                // escaped resource path that either physical transport sends.
                                assertThat(customUrl.rawPath).isEqualTo(sdkUrl.rawPath)
                                assertThat(custom.queryParams.values("inherited"))
                                    .containsExactly("one/two")
                                assertThat(wire.requestUrl!!.queryParameter("inherited"))
                                    .isEqualTo("one/two")
                                assertThat(custom.headers.values("Authorization"))
                                    .containsExactly("Bearer fake-fork-key")
                                assertThat(wire.getHeader("Authorization"))
                                    .isEqualTo("Bearer fake-fork-key")
                                fork.send(start())
                                other.send(start())
                                assertThat(mapper.readTree(peer.messages.poll(8, TimeUnit.SECONDS)))
                                    .isEqualTo(
                                        mapper.readTree(
                                            otherHttp.attempted.poll(8, TimeUnit.SECONDS)
                                        )
                                    )
                            }
                    }
                }
            }
        }
    }

    @Test
    fun reconnectNeverReachesForkWireIncludingMisdeclaredKnownAndUnknownEvents() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveForkConnection.connect(options(server, http), "stored").use { fork ->
                    val raw =
                        mapper.readValue(
                            """{"type":"session.reconnect"}""",
                            ForkClientEvent::class.java,
                        )
                    val known =
                        ForkClientEvent.ofSessionStart(
                            ForkSessionStartEvent.builder()
                                .session(ForkSessionConfig.builder().build())
                                .type(JsonValue.from("session.reconnect"))
                                .build()
                        )
                    for (event in listOf(raw, known)) {
                        assertThatThrownBy { fork.send(event) }
                            .isInstanceOf(IllegalArgumentException::class.java)
                            .hasMessage("Live forks do not support session.reconnect")
                    }
                    // Unknown future types, and nested strings resembling commands, stay supported.
                    val bytes = "x".repeat(12 * 1024 * 1024)
                    fork.send(
                        mapper.convertValue(
                            mapOf(
                                "type" to "live.future",
                                "metadata" to mapOf("type" to "session.reconnect"),
                                "data" to bytes,
                            ),
                            ForkClientEvent::class.java,
                        )
                    )
                    val sent = mapper.readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                    assertThat(sent.path("type").asText()).isEqualTo("live.future")
                    assertThat(sent.at("/metadata/type").asText()).isEqualTo("session.reconnect")
                    assertThat(sent.path("data").asText()).isEqualTo(bytes)
                    fork.send(start())
                    assertThat(
                            mapper
                                .readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.start")
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun cancellationAndClosePreserveForkEventsAndClientOwnership() {
        MockWebServer().use { server ->
            val peer = Peer()
            val nextPeer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            server.enqueue(MockResponse().withWebSocketUpgrade(nextPeer))
            OkHttpClient.builder().build().use { http ->
                val client = options(server, http)
                LiveForkConnection.connectAsync(client, "source").get(8, TimeUnit.SECONDS).use {
                    fork ->
                    val canceled = fork.receiveAsync()
                    assertThat(canceled.cancel(false)).isTrue()
                    val read = fork.receiveAsync()
                    val raw = """{"type":"fork.future","future_data":{"sequence":17}}"""
                    peer.socket.get(8, TimeUnit.SECONDS).send(raw)
                    val unknown = read.get(8, TimeUnit.SECONDS)
                    assertThat(unknown._json()).isPresent()
                    assertThat(mapper.valueToTree<JsonNode>(unknown))
                        .isEqualTo(mapper.readTree(raw))
                    val unfinished = fork.receiveAsync()
                    fork.close()
                    assertThatThrownBy { unfinished.get(8, TimeUnit.SECONDS) }
                        .hasMessageContaining("Live connection closed")
                }
                LiveForkConnection.connect(client, "source").use { fork ->
                    fork.send(start())
                    assertThat(
                            mapper
                                .readTree(nextPeer.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.start")
                }
                assertThat(peer.messages).isEmpty()
                assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
            }
        }
    }

    @Test
    fun asyncForkCallbackCanBlockOnReadAndAnotherForkWithSingleThreadExecutor() {
        val executor = Executors.newSingleThreadExecutor()
        try {
            MockWebServer().use { server ->
                val first = Peer()
                val second = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(first))
                server.enqueue(MockResponse().withWebSocketUpgrade(second))
                OkHttpClient.builder().build().use { http ->
                    val client =
                        options(server, http).toBuilder().streamHandlerExecutor(executor).build()
                    val result =
                        LiveForkConnection.connectAsync(client, "first").thenApply { fork ->
                            fork.use {
                                it.send(start())
                                val event = it.receive()
                                LiveForkConnection.connect(client, "second").use { other ->
                                    other.send(finish())
                                    assertThat(other.receive().isSessionClosed()).isTrue()
                                }
                                event
                            }
                        }
                    assertThat(
                            mapper
                                .readTree(first.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.start")
                    first.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":"session.started","event_id":"ready","session":{}}""")
                    assertThat(
                            mapper
                                .readTree(second.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.close")
                    second.socket
                        .get(8, TimeUnit.SECONDS)
                        .send(
                            """{"type":"session.closed","event_id":"closed","session":{},"reason":"client_request"}"""
                        )
                    assertThat(result.get(8, TimeUnit.SECONDS).asSessionStarted().eventId())
                        .isEqualTo("ready")
                }
            }
        } finally {
            executor.shutdownNow()
        }
    }

    private class WriteTransport : HttpClient, WebSocketClient {
        val attempted = LinkedBlockingQueue<String>()
        val opens = LinkedBlockingQueue<HttpRequest>()
        val closed = CountDownLatch(1)
        var writeFailure: Throwable? = null

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("Unexpected HTTP request")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("Unexpected HTTP request")

        override fun close() {}

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            opens.add(request)
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {
                        val problem = writeFailure
                        if (problem is WebSocketWriteNotAttempted) throw problem
                        attempted.add(text)
                        if (problem != null) throw problem
                    }

                    override fun close() {
                        closed.countDown()
                    }
                }
            )
        }
    }

    @Test
    fun forkNeverReplaysAndOnlyActualUncertainWriteEndsConnection() {
        WriteTransport().use { http ->
            val client = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
            LiveForkConnection.connect(client, "stored").use { fork ->
                http.writeFailure = WebSocketWriteNotAttempted.Busy("synthetic busy")
                assertThatThrownBy { fork.send(start()) }.hasMessage("synthetic busy")
                assertThat(http.attempted).isEmpty()
                val read = fork.receiveAsync()
                val failure = IOException("write failed")
                http.writeFailure = failure
                assertThatThrownBy { fork.send(start()) }.isSameAs(failure)
                assertThatThrownBy { read.get(8, TimeUnit.SECONDS) }.hasCause(failure)
                assertThat(http.closed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThatThrownBy { fork.send(finish()) }.hasMessageContaining("not connected")
                assertThat(http.attempted).hasSize(1)
                assertThat(mapper.readTree(http.attempted.poll()).path("type").asText())
                    .isEqualTo("session.start")
            }
        }
    }
}
