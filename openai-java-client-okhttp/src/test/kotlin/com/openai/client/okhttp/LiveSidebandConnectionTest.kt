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
import com.openai.helpers.LiveSidebandConnection
import com.openai.helpers.LiveWebSocketOptions
import com.openai.models.live.InputAudioMuteEvent
import com.openai.models.live.InputAudioUnmuteEvent
import com.openai.models.live.SessionCloseEvent
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

@Timeout(30)
class LiveSidebandConnectionTest {
    private val mapper = jsonMapper()

    private class Peer(private val earlyReplay: Boolean = false) : WebSocketListener() {
        val socket = CompletableFuture<WebSocket>()
        val messages = LinkedBlockingQueue<String>()
        val closed = CountDownLatch(1)

        override fun onOpen(webSocket: WebSocket, response: Response) {
            if (earlyReplay) {
                webSocket.send(
                    """{"type":"session.instructions.appended","event_id":"replayed","instructions":"fixture"}"""
                )
                webSocket.send(
                    """{"type":"session.input_audio.append","event_id":"reflected","audio":"AQID","timestamp":7}"""
                )
            }
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
            .apiKey("fake-owner-key")
            .putHeader("OpenAI-Project", "fake-project")
            .baseUrl(server.url("/proxy/v1?inherited=one%2Ftwo&x=a%2Bb").toString())
            .build()

    @Test
    fun replayAndReflectedAudioArriveWithoutAnyFreshStartedEventOrStartupCommand() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer(earlyReplay = true)
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val headers =
                        LiveWebSocketOptions.builder()
                            .putHeader("Authorization", "Bearer fake-bound-observer")
                            .putQueryParam("graceful_close", "true")
                            .build()
                    val id = "signaling id+alias/with?data"
                    val observer =
                        if (async)
                            LiveSidebandConnection.connectAsync(options(server, http), id, headers)
                                .get(8, TimeUnit.SECONDS)
                        else LiveSidebandConnection.connect(options(server, http), id, headers)
                    observer.use { sideband ->
                        val request = server.takeRequest(8, TimeUnit.SECONDS)!!
                        assertThat(request.method).isEqualTo("GET")
                        assertThat(request.requestUrl!!.pathSegments)
                            .containsExactly("proxy", "v1", "live", "sessions", id, "attach")
                        assertThat(request.requestUrl!!.queryParameter("inherited"))
                            .isEqualTo("one/two")
                        assertThat(request.requestUrl!!.queryParameter("graceful_close"))
                            .isEqualTo("true")
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer fake-bound-observer")
                        assertThat(request.getHeader("OpenAI-Project")).isEqualTo("fake-project")
                        assertThat(peer.messages.poll(100, TimeUnit.MILLISECONDS)).isNull()
                        val replay = sideband.receiveAsync().get(8, TimeUnit.SECONDS)
                        assertThat(replay.isSessionInstructionsAppended()).isTrue()
                        assertThat(mapper.valueToTree<JsonNode>(replay).path("event_id").asText())
                            .isEqualTo("replayed")
                        val reflection = sideband.receive()
                        assertThat(reflection.isSessionInputAudioAppend()).isTrue()
                        assertThat(mapper.valueToTree<JsonNode>(reflection).path("audio").asText())
                            .isEqualTo("AQID")
                        peer.socket
                            .get(8, TimeUnit.SECONDS)
                            .send("""{"type":"transport.ringing","event_id":"live-signal"}""")
                        assertThat(sideband.receive().isTransportRinging()).isTrue()
                    }
                    assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun observerWaitsForDataNotStartedAndRejectsStartupOverridesBeforeAnyWrite() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveSidebandConnection.connect(options(server, http), "signaling").use { sideband ->
                    val read = sideband.receiveAsync()
                    assertThatThrownBy { read.get(100, TimeUnit.MILLISECONDS) }
                        .isInstanceOf(TimeoutException::class.java)
                    for (unsupported in
                        listOf(
                            "session.start",
                            "session.reconnect",
                            "session.input_audio.append",
                        )) {
                        val misleading =
                            SessionCloseEvent.builder().type(JsonValue.from(unsupported)).build()
                        assertThatThrownBy { sideband.send(misleading) }
                            .isInstanceOf(IllegalArgumentException::class.java)
                            .hasMessage(
                                "Live sideband cannot start, reconnect or append primary audio"
                            )
                    }
                    assertThat(peer.messages.poll(100, TimeUnit.MILLISECONDS)).isNull()
                    sideband.send(InputAudioMuteEvent.builder().build())
                    assertThat(
                            mapper
                                .readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.input_audio.mute")
                    peer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":"session.input_audio.muted","event_id":"muted"}""")
                    assertThat(read.get(8, TimeUnit.SECONDS).isSessionInputAudioMuted()).isTrue()
                    sideband.send(InputAudioUnmuteEvent.builder().build())
                    assertThat(
                            mapper
                                .readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.input_audio.unmute")
                    peer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":"session.input_audio.unmuted","event_id":"unmuted"}""")
                    assertThat(sideband.receive().isSessionInputAudioUnmuted()).isTrue()
                }
            }
        }
    }

    @Test
    fun explicitSessionCloseDrainsErrorsAndFutureEventsWhileObserverCloseOnlyDetaches() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveSidebandConnection.connect(options(server, http), "signaling").use { sideband ->
                    sideband.send(SessionCloseEvent.builder().build())
                    assertThat(
                            mapper
                                .readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                                .path("type")
                                .asText()
                        )
                        .isEqualTo("session.close")
                    val payload = "x".repeat(12 * 1024 * 1024)
                    val socket = peer.socket.get(8, TimeUnit.SECONDS)
                    socket.send(
                        """{"type":"error","event_id":"failed-storage","error":{"code":"session_storage_failed","message":"fixture"}}"""
                    )
                    socket.send("""{"type":"session.future","data":"$payload"}""")
                    socket.send(
                        """{"type":"session.closed","event_id":"closed","session":{},"reason":"client_request"}"""
                    )
                    val error = sideband.receive()
                    assertThat(mapper.valueToTree<JsonNode>(error).at("/error/code").asText())
                        .isEqualTo("session_storage_failed")
                    val unknown = sideband.receive()
                    assertThat(unknown._json()).isPresent()
                    assertThat(mapper.valueToTree<JsonNode>(unknown).path("data").asText())
                        .isEqualTo(payload)
                    assertThat(sideband.receiveAsync().get(8, TimeUnit.SECONDS).isSessionClosed())
                        .isTrue()
                }
                assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThat(peer.messages).isEmpty()
            }
        }
    }

    @Test
    fun deniedBearerAndInvalidIdCannotAttachAndSharedClientSurvivesCancellation() {
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse().setResponseCode(403).setBody("fixture authorization refusal")
            )
            val peer = Peer()
            val nextPeer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            server.enqueue(MockResponse().withWebSocketUpgrade(nextPeer))
            OkHttpClient.builder().build().use { http ->
                val client = options(server, http)
                for (id in listOf("", ".", "..")) {
                    assertThatThrownBy { LiveSidebandConnection.connect(client, id) }
                        .hasMessageNotContaining("fake-owner-key")
                }
                assertThat(server.requestCount).isZero()
                assertThatThrownBy { LiveSidebandConnection.connect(client, "session-other-key") }
                    .hasMessageNotContaining("fake-owner-key")
                val refused = server.takeRequest(8, TimeUnit.SECONDS)!!
                assertThat(refused.getHeader("Authorization")).isEqualTo("Bearer fake-owner-key")
                assertThat(refused.getHeader("OpenAI-Project")).isEqualTo("fake-project")
                val selected =
                    LiveWebSocketOptions.builder()
                        .putHeader("Authorization", "Bearer fake-bound-observer")
                        .build()
                LiveSidebandConnection.connectAsync(client, "signaling", selected)
                    .get(8, TimeUnit.SECONDS)
                    .use { sideband ->
                        assertThat(
                                server.takeRequest(8, TimeUnit.SECONDS)!!.getHeader("Authorization")
                            )
                            .isEqualTo("Bearer fake-bound-observer")
                        val canceled = sideband.receiveAsync()
                        assertThat(canceled.cancel(false)).isTrue()
                        val next = sideband.receiveAsync()
                        peer.socket
                            .get(8, TimeUnit.SECONDS)
                            .send("""{"type":"session.updated","event_id":"next","session":{}}""")
                        assertThat(next.get(8, TimeUnit.SECONDS).asSessionUpdated().eventId())
                            .isEqualTo("next")
                    }
                LiveSidebandConnection.connect(client, "signaling", selected).use {}
                assertThat(peer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThat(nextPeer.closed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThat(peer.messages).isEmpty()
                assertThat(nextPeer.messages).isEmpty()
            }
        }
    }

    @Test
    fun asyncObserverCallbackCanWaitForReplayedEventsOnSingleThreadExecutor() {
        val executor = Executors.newSingleThreadExecutor()
        try {
            MockWebServer().use { server ->
                val peer = Peer(earlyReplay = true)
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val client =
                        options(server, http).toBuilder().streamHandlerExecutor(executor).build()
                    val result =
                        LiveSidebandConnection.connectAsync(client, "signaling").thenApply {
                            sideband ->
                            sideband.use {
                                val first = it.receive()
                                val second = it.receive()
                                first.isSessionInstructionsAppended() &&
                                    second.isSessionInputAudioAppend()
                            }
                        }
                    assertThat(result.get(8, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                }
            }
        } finally {
            executor.shutdownNow()
        }
    }

    private class Transport : HttpClient, WebSocketClient {
        val requests = LinkedBlockingQueue<HttpRequest>()
        val attempted = LinkedBlockingQueue<String>()
        val closed = CountDownLatch(1)
        var writeFailure: Throwable? = null

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("Unexpected HTTP")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("Unexpected HTTP")

        override fun close() {}

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            requests.add(request)
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {
                        val failure = writeFailure
                        if (failure is WebSocketWriteNotAttempted) throw failure
                        attempted.add(text)
                        if (failure != null) throw failure
                    }

                    override fun close() {
                        closed.countDown()
                    }
                }
            )
        }
    }

    @Test
    fun selectedObserverCredentialsAndSpaceOrPlusIdReachCustomTransportWithoutUnknownWriteReplay() {
        for (id in listOf("signaling id", "signaling+id")) {
            Transport().use { http ->
                val client =
                    ClientOptions.builder()
                        .httpClient(http)
                        .apiKey("fake-key")
                        .baseUrl("https://api.openai.com/proxy/v1?inherited=a%2Bb")
                        .build()
                val selected =
                    LiveWebSocketOptions.builder()
                        .putHeader("Authorization", "Bearer fake-observer")
                        .build()
                LiveSidebandConnection.connect(client, id, selected).use { sideband ->
                    val sent = http.requests.poll(8, TimeUnit.SECONDS)
                    assertThat(URI(sent.url()).path).isEqualTo("/proxy/v1/live/sessions/$id/attach")
                    assertThat(sent.headers.values("Authorization"))
                        .containsExactly("Bearer fake-observer")
                    assertThat(sent.queryParams.values("inherited")).containsExactly("a+b")
                    http.writeFailure = WebSocketWriteNotAttempted.Busy("synthetic busy")
                    assertThatThrownBy { sideband.send(InputAudioMuteEvent.builder().build()) }
                        .hasMessage("synthetic busy")
                    assertThat(http.attempted).isEmpty()
                    val read = sideband.receiveAsync()
                    val failure = IOException("uncertain write")
                    http.writeFailure = failure
                    assertThatThrownBy { sideband.send(InputAudioMuteEvent.builder().build()) }
                        .isSameAs(failure)
                    assertThatThrownBy { read.get(8, TimeUnit.SECONDS) }.hasCause(failure)
                    assertThat(http.closed.await(8, TimeUnit.SECONDS)).isTrue()
                    assertThatThrownBy { sideband.send(InputAudioUnmuteEvent.builder().build()) }
                        .hasMessageContaining("not connected")
                    assertThat(http.attempted).hasSize(1)
                }
            }
        }
    }
}
