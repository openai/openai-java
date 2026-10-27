package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.core.http.ResponseConnection
import com.openai.core.http.ResponseWebSocketOptions
import com.openai.core.http.WebSocketOptions
import com.openai.core.jsonMapper
import com.openai.helpers.LiveSidebandConnection
import com.openai.helpers.RealtimeConnection
import com.openai.helpers.RealtimeWebSocketOptions
import com.openai.models.beta.responses.BetaResponsesClientEvent
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(30)
class WebSocketParityTest {
    private val mapper = jsonMapper()

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

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            webSocket.close(code, reason)
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            closed.countDown()
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            closed.countDown()
        }
    }

    @Test
    fun connectionQueryReplacesInheritedBaseUrlValues() {
        for (mode in listOf("realtime", "responses")) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val client =
                        ClientOptions.builder()
                            .httpClient(http)
                            .apiKey("synthetic")
                            .baseUrl(
                                server
                                    .url("/v1/?tenant=base&model=base-model&keep=a%2Bb")
                                    .toString()
                            )
                            .putQueryParam("tenant", "client")
                            .build()
                    val connection =
                        if (mode == "realtime") {
                            RealtimeConnection.connect(
                                client,
                                RealtimeWebSocketOptions.builder()
                                    .model("connection-model")
                                    .putQueryParam("tenant", "connection")
                                    .build(),
                            )
                        } else {
                            ResponseConnection.connect(
                                client,
                                ResponseWebSocketOptions.builder()
                                    .putQueryParam("tenant", "connection")
                                    .build(),
                            )
                        }
                    connection.use {
                        val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                        val url = request.requestUrl!!
                        assertThat(url.encodedPath).isEqualTo("/v1/$mode")
                        assertThat(url.queryParameterValues("tenant")).containsExactly("connection")
                        assertThat(url.queryParameterValues("model"))
                            .containsExactly(
                                if (mode == "realtime") "connection-model" else "base-model"
                            )
                        assertThat(url.queryParameterValues("keep")).containsExactly("a+b")
                    }
                    assertThat(peer.closed.await(5, TimeUnit.SECONDS)).isTrue()
                }
            }
        }
    }

    @Test
    fun betaConnectionsUseBetaTypesInBothModes() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                val client =
                    OpenAIOkHttpClient.builder()
                        .apiKey("synthetic-default")
                        .baseUrl(server.url("/v1/").toString())
                        .build()
                try {
                    val options =
                        WebSocketOptions.builder()
                            .putHeader("Authorization", "Bearer synthetic-override")
                            .putQueryParam("test", "beta")
                            .build()
                    val connection =
                        if (async)
                            client
                                .async()
                                .beta()
                                .responses()
                                .connectWebSocket(options)
                                .get(5, TimeUnit.SECONDS)
                        else client.beta().responses().connectWebSocket(options)
                    connection.use {
                        val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                        assertThat(request.path).isEqualTo("/v1/responses?test=beta")
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer synthetic-override")
                        val command =
                            """{"type":"response.inject","response_id":"resp_beta","input":[]}"""
                        it.send(mapper.readValue(command, BetaResponsesClientEvent::class.java))
                        assertThat(mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS)))
                            .isEqualTo(mapper.readTree(command))
                        val wire = peer.socket.get(5, TimeUnit.SECONDS)
                        wire.send(
                            """{"type":"response.inject.created","response_id":"resp_beta","sequence_number":7,"stream_id":"stream_beta"}"""
                        )
                        val event =
                            (if (async) it.receiveAsync().get(5, TimeUnit.SECONDS)
                                else it.receive())
                                .asResponseInjectCreated()
                        assertThat(event.responseId()).isEqualTo("resp_beta")
                        assertThat(event.streamId()).contains("stream_beta")
                        assertThat(event.sequenceNumber()).isEqualTo(7L)
                        wire.send(
                            """{"type":"response.completed","sequence_number":8,"response":{"id":"resp_beta","status":"completed"}}"""
                        )
                        assertThat(it.receive().asResponseCompleted().response().id())
                            .isEqualTo("resp_beta")
                        wire.send("""{"type":"future.beta.event","marker":42}""")
                        assertThat(it.receive()._json()).isPresent()
                    }
                    assertThat(peer.closed.await(5, TimeUnit.SECONDS)).isTrue()
                } finally {
                    client.close()
                }
            }
        }
    }

    @Test
    fun sidebandKeepsItsExistingServerEventTypes() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val options =
                        ClientOptions.builder()
                            .httpClient(http)
                            .apiKey("synthetic")
                            .baseUrl(server.url("/v1/").toString())
                            .build()
                    val connection =
                        if (async)
                            LiveSidebandConnection.connectAsync(options, "live_test")
                                .get(5, TimeUnit.SECONDS)
                        else LiveSidebandConnection.connect(options, "live_test")
                    connection.use {
                        val frames =
                            listOf(
                                """{"type":"session.input_audio.append","audio":"AAE="}""",
                                """{"type":"transport.dtmf.received","event_id":"r1","event":"5"}""",
                                """{"type":"transport.dtmf.send","event_id":"s1","event":"#","client_event_id":"command1"}""",
                                """{"type":"transport.ringing","event_id":"r2","session_id":"live_test"}""",
                                """{"type":"transport.answered","event_id":"a1","session_id":"live_test"}""",
                                """{"type":"transport.failed","event_id":"f1","session_id":"live_test","error":{"type":"call_error","code":"provider_invite_failed","message":"synthetic failure","param":null}}""",
                                // Null is outside the server schema; retain the existing lenient
                                // decode behavior.
                                """{"type":"transport.dtmf.send","event_id":"s2","event":"#","client_event_id":null}""",
                                """{"type":"transport.dtmf.send","event_id":"s3","event":"#"}""",
                                """{"type":"session.output_audio.delta","delta":"AAE=","start_ms":10,"end_ms":20}""",
                                """{"type":"future.transport.event","marker":42}""",
                            )
                        frames.forEach { peer.socket.get(5, TimeUnit.SECONDS).send(it) }
                        val events =
                            frames.map {
                                if (async) connection.receiveAsync().get(5, TimeUnit.SECONDS)
                                else connection.receive()
                            }
                        assertThat(events[0].asSessionInputAudioAppend().audio()).isEqualTo("AAE=")
                        assertThat(events[1].asTransportDtmfReceived().event()).isEqualTo("5")
                        assertThat(events[2].asTransportDtmfSend().clientEventId())
                            .contains("command1")
                        assertThat(events[3].asTransportRinging().sessionId())
                            .isEqualTo("live_test")
                        assertThat(events[4].asTransportAnswered().sessionId())
                            .isEqualTo("live_test")
                        assertThat(events[5].asTransportFailed().error().message())
                            .isEqualTo("synthetic failure")
                        assertThat(events[6].asTransportDtmfSend().clientEventId()).isEmpty()
                        assertThat(events[7].asTransportDtmfSend().clientEventId()).isEmpty()
                        assertThat(events[8].asSessionOutputAudioDelta().delta()).isEqualTo("AAE=")
                        assertThat(events[8].asSessionOutputAudioDelta().startMs()).contains(10L)
                        assertThat(events[8].asSessionOutputAudioDelta().endMs()).contains(20L)
                        assertThat(events[9]._json()).isPresent()
                        assertThat(peer.messages).isEmpty()
                    }
                    assertThat(peer.closed.await(5, TimeUnit.SECONDS)).isTrue()
                }
            }
        }
    }
}
