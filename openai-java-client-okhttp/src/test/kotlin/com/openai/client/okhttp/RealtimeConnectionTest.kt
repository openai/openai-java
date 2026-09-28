package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.core.jsonMapper
import com.openai.helpers.RealtimeConnection
import com.openai.helpers.RealtimeWebSocketOptions
import com.openai.models.realtime.InputAudioBufferAppendEvent
import com.openai.models.realtime.InputAudioBufferClearEvent
import com.openai.models.realtime.RealtimeClientEvent
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
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(25)
class RealtimeConnectionTest {
    private val mapper = jsonMapper()

    private fun command() =
        RealtimeClientEvent.ofInputAudioBufferClear(InputAudioBufferClearEvent.builder().build())

    private class Listener : WebSocketListener() {
        val socket = CompletableFuture<WebSocket>()
        val messages = LinkedBlockingQueue<String>()
        val terminated = CountDownLatch(1)

        override fun onOpen(webSocket: WebSocket, response: Response) {
            socket.complete(webSocket)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            messages.add(text)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            terminated.countDown()
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            terminated.countDown()
        }
    }

    private fun options(server: MockWebServer, client: HttpClient) =
        ClientOptions.builder()
            .httpClient(client)
            .apiKey("fake-realtime-key")
            .baseUrl(server.url("/v1?inherited=1").toString())
            .build()

    @Test
    fun typedSessionsAllowBlockingAndAsyncReceivesAndKeepErrorsNonterminal() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Listener()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val configuration = options(server, http)
                    val perSession =
                        RealtimeWebSocketOptions.builder()
                            .model("realtime-test")
                            .putHeader("X-Test", "one")
                            .putQueryParam("another", "2")
                            .build()
                    val connection =
                        if (async)
                            RealtimeConnection.connectAsync(configuration, perSession)
                                .get(8, TimeUnit.SECONDS)
                        else RealtimeConnection.connect(configuration, perSession)
                    connection.use {
                        val request = server.takeRequest(8, TimeUnit.SECONDS)!!
                        assertThat(request.path)
                            .contains(
                                "/v1/realtime?",
                                "inherited=1",
                                "model=realtime-test",
                                "another=2",
                            )
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer fake-realtime-key")
                        assertThat(request.getHeader("X-Test")).isEqualTo("one")
                        val socket = peer.socket.get(8, TimeUnit.SECONDS)
                        repeat(2) { round ->
                            it.send(command())
                            assertThat(
                                    mapper
                                        .readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                                        .path("type")
                                        .asText()
                                )
                                .isEqualTo("input_audio_buffer.clear")
                            socket.send(
                                """{"type":"error","event_id":"error$round","error":{"type":"invalid_request_error","code":"synthetic","message":"test"}}"""
                            )
                            val error =
                                if (async) it.receiveAsync().get(8, TimeUnit.SECONDS)
                                else it.receive()
                            assertThat(error.isError()).isTrue()
                            assertThat(error.asError().error().message()).isEqualTo("test")
                            socket.send(
                                """{"type":"input_audio_buffer.cleared","event_id":"clear$round"}"""
                            )
                            val cleared =
                                if (async) it.receiveAsync().get(8, TimeUnit.SECONDS)
                                else it.receive()
                            assertThat(cleared.asInputAudioBufferCleared().eventId())
                                .isEqualTo("clear$round")
                        }
                        socket.send("""{"type":"realtime.future","raw":{"more":[1,2,3]}}""")
                        val unknown = it.receive()
                        assertThat(unknown._json()).isPresent
                        assertThat(
                                mapper
                                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(unknown)
                                    .at("/raw/more/2")
                                    .asInt()
                            )
                            .isEqualTo(3)
                    }
                }
            }
        }
    }

    @Test
    fun canceledReceiveLeavesNextEventAvailableAndConcurrentReceivesReject() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                RealtimeConnection.connect(options(server, http)).use { connection ->
                    val pending = connection.receiveAsync()
                    assertThatThrownBy { connection.receiveAsync() }
                        .hasMessageContaining("already pending")
                    assertThat(pending.cancel(false)).isTrue()
                    val next = connection.receiveAsync()
                    peer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":"input_audio_buffer.cleared","event_id":"after-cancel"}""")
                    assertThat(next.get(8, TimeUnit.SECONDS).asInputAudioBufferCleared().eventId())
                        .isEqualTo("after-cancel")
                }
            }
        }
    }

    @Test
    fun transcriptModeAndCallOptionsDoNotRedirectToResponsesAndNoReplayOnReconnect() {
        MockWebServer().use { server ->
            val first = Listener()
            val next = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(first))
            server.enqueue(MockResponse().withWebSocketUpgrade(next))
            OkHttpClient.builder().build().use { http ->
                val configuration = options(server, http)
                val connection =
                    RealtimeConnection.connect(
                        configuration,
                        RealtimeWebSocketOptions.builder()
                            .transcription()
                            .putHeader("X-Test", "session")
                            .build(),
                    )
                connection.use {
                    val request = server.takeRequest(8, TimeUnit.SECONDS)!!
                    assertThat(request.path).contains("/v1/realtime?", "intent=transcription")
                    it.send(
                        RealtimeClientEvent.ofInputAudioBufferAppend(
                            InputAudioBufferAppendEvent.builder().audio("ZmFrZQ==").build()
                        )
                    )
                    assertThat(
                            mapper
                                .readTree(first.messages.poll(8, TimeUnit.SECONDS))
                                .path("audio")
                                .asText()
                        )
                        .isEqualTo("ZmFrZQ==")
                    it.reconnectAsync(
                            RealtimeWebSocketOptions.builder().callId("fake-call").build()
                        )
                        .get(8, TimeUnit.SECONDS)
                        .use { replacement ->
                            val later = server.takeRequest(8, TimeUnit.SECONDS)!!
                            assertThat(later.path).contains("call_id=fake-call", "/v1/realtime?")
                            assertThat(later.path).doesNotContain("intent=transcription")
                            assertThat(later.getHeader("X-Test")).isNull()
                            replacement.send(command())
                            val received = mapper.readTree(next.messages.poll(8, TimeUnit.SECONDS))
                            assertThat(received.path("type").asText())
                                .isEqualTo("input_audio_buffer.clear")
                            assertThat(next.messages).isEmpty()
                            assertThatThrownBy { it.send(command()) }
                                .hasMessageContaining("not connected")
                        }
                }
            }
        }
    }

    @Test
    fun closeAndInvalidEnvelopeDoNotCloseSharedHttpClient() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            server.enqueue(MockResponse().setResponseCode(200).setBody("still-open"))
            OkHttpClient.builder().build().use { http ->
                RealtimeConnection.connect(options(server, http)).use { connection ->
                    val pending = connection.receiveAsync()
                    peer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":123,"details":"invalid"}""")
                    assertThatThrownBy { pending.get(8, TimeUnit.SECONDS) }
                        .hasRootCauseMessage("Invalid Realtime event")
                    assertThatThrownBy { connection.send(command()) }
                        .hasMessageContaining("not connected")
                }
                http
                    .execute(
                        HttpRequest.builder()
                            .baseUrl(server.url("/").toString())
                            .method(com.openai.core.http.HttpMethod.GET)
                            .build(),
                        RequestOptions.none(),
                    )
                    .use { response -> assertThat(response.statusCode()).isEqualTo(200) }
            }
        }
    }

    @Test
    fun optionalSlowConsumerLimitFailsAndDrainsAlreadyAcceptedEvents() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                RealtimeConnection.connect(
                        options(server, http),
                        RealtimeWebSocketOptions.builder().maxQueuedEvents(1).build(),
                    )
                    .use { connection ->
                        val socket = peer.socket.get(8, TimeUnit.SECONDS)
                        // Synchronize on the server seeing the transport close on overflow.
                        socket.send("""{"type":"input_audio_buffer.cleared","event_id":"one"}""")
                        socket.send("""{"type":"input_audio_buffer.cleared","event_id":"two"}""")
                        assertThat(peer.terminated.await(8, TimeUnit.SECONDS)).isTrue()
                        assertThat(connection.receive().asInputAudioBufferCleared().eventId())
                            .isEqualTo("one")
                        assertThatThrownBy { connection.receive() }
                            .hasRootCauseMessage("Realtime event buffer is full")
                    }
            }
        }
    }

    @Test
    fun queueBytesLimitDoesNotRejectAMessageAlreadyClaimedByAWaitingReader() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                RealtimeConnection.connect(
                        options(server, http),
                        RealtimeWebSocketOptions.builder().maxQueuedBytes(128).build(),
                    )
                    .use { connection ->
                        val next = connection.receiveAsync()
                        val payload = "transcript".repeat(1000)
                        peer.socket
                            .get(8, TimeUnit.SECONDS)
                            .send("""{"type":"realtime.future","text":"$payload"}""")
                        val actual = next.get(8, TimeUnit.SECONDS)
                        assertThat(
                                mapper
                                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(actual)
                                    .path("text")
                                    .asText()
                            )
                            .isEqualTo(payload)
                    }
            }
        }
    }

    @Test
    fun honorsStrictClientValidationAndPerConnectionOverride() {
        MockWebServer().use { server ->
            val strictPeer = Listener()
            val relaxedPeer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(strictPeer))
            server.enqueue(MockResponse().withWebSocketUpgrade(relaxedPeer))
            OkHttpClient.builder().build().use { http ->
                val strict = options(server, http).toBuilder().responseValidation(true).build()
                RealtimeConnection.connect(strict).use { connection ->
                    val read = connection.receiveAsync()
                    // Missing the required event_id must not silently bypass strict validation.
                    strictPeer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":"input_audio_buffer.cleared"}""")
                    assertThatThrownBy { read.get(8, TimeUnit.SECONDS) }
                        .hasRootCauseInstanceOf(
                            com.openai.errors.OpenAIInvalidDataException::class.java
                        )
                }
                RealtimeConnection.connect(
                        strict,
                        RealtimeWebSocketOptions.defaults(),
                        RequestOptions.builder().responseValidation(false).build(),
                    )
                    .use { connection ->
                        relaxedPeer.socket
                            .get(8, TimeUnit.SECONDS)
                            .send(
                                """{"type":"new.realtime.event","future":{"value":"preserved"}}"""
                            )
                        val event = connection.receive()
                        assertThat(
                                mapper
                                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(event)
                                    .at("/future/value")
                                    .asText()
                            )
                            .isEqualTo("preserved")
                        connection.send(command())
                        assertThat(
                                mapper
                                    .readTree(relaxedPeer.messages.poll(8, TimeUnit.SECONDS))
                                    .path("type")
                                    .asText()
                            )
                            .isEqualTo("input_audio_buffer.clear")
                    }
            }
        }
    }

    @Test
    fun nativeOversizedUnsentAudioAllowsTheNextCommandOnTheSameConnection() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                RealtimeConnection.connect(options(server, http)).use { connection ->
                    val oversized =
                        RealtimeClientEvent.ofInputAudioBufferAppend(
                            InputAudioBufferAppendEvent.builder()
                                .audio("A".repeat(16 * 1024 * 1024))
                                .build()
                        )
                    assertThatThrownBy { connection.send(oversized) }
                        .isInstanceOf(IllegalArgumentException::class.java)
                        .hasMessageContaining("16 MiB")
                    connection.send(command())
                    val only = mapper.readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                    assertThat(only.path("type").asText()).isEqualTo("input_audio_buffer.clear")
                    assertThat(peer.messages).isEmpty()
                    peer.socket
                        .get(8, TimeUnit.SECONDS)
                        .send("""{"type":"input_audio_buffer.cleared","event_id":"not-poisoned"}""")
                    assertThat(connection.receive().asInputAudioBufferCleared().eventId())
                        .isEqualTo("not-poisoned")
                }
            }
        }
    }

    @Test
    fun uncertainFailedWriteClosesAndNeverResendsToTheReplacement() {
        var opened = 0
        var writes = 0
        var closes = 0
        var httpClosed = false
        val http =
            object : HttpClient, WebSocketClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = throw UnsupportedOperationException()

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = throw UnsupportedOperationException()

                override fun close() {
                    httpClosed = true
                }

                override fun connectWebSocket(
                    request: HttpRequest,
                    options: RequestOptions,
                    maxMessageBytes: Int,
                    listener: WebSocketClient.Listener,
                ): CompletableFuture<WebSocketClient.Connection> {
                    opened++
                    return CompletableFuture.completedFuture(
                        object : WebSocketClient.Connection {
                            override fun send(text: String) {
                                writes++
                                if (opened == 1) throw java.io.IOException("uncertain write")
                            }

                            override fun close() {
                                closes++
                            }
                        }
                    )
                }
            }
        val configuration = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
        RealtimeConnection.connect(configuration).use { old ->
            val pending = old.receiveAsync()
            assertThatThrownBy { old.send(command()) }.hasMessage("uncertain write")
            assertThatThrownBy { pending.get(8, TimeUnit.SECONDS) }
                .hasRootCauseMessage("uncertain write")
            assertThatThrownBy { old.send(command()) }.hasMessageContaining("not connected")
            old.reconnect().use { fresh ->
                assertThat(writes).isEqualTo(1)
                fresh.send(command())
                assertThat(writes).isEqualTo(2)
            }
        }
        assertThat(opened).isEqualTo(2)
        assertThat(closes).isEqualTo(2)
        assertThat(httpClosed).isFalse()
    }

    @Test
    fun httpOnlyUnsupportedBeforeSendingAnyRequest() {
        val http =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("REST must not be called")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = error("REST must not be called")

                override fun close() {}
            }
        val configuration = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
        assertThatThrownBy { RealtimeConnection.connect(configuration) }
            .hasMessageContaining("does not support WebSockets")
    }

    @Test
    fun closeReleasesAnUnassignedReadWithoutCallbacksUnderLock() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val connection = RealtimeConnection.connect(options(server, http))
                val pending = connection.receiveAsync()
                val completed = CountDownLatch(1)
                pending.whenComplete { _, _ ->
                    connection.close()
                    completed.countDown()
                }
                connection.close()
                assertThat(completed.await(8, TimeUnit.SECONDS)).isTrue()
                assertThat(pending).isCompletedExceptionally()
            }
        }
    }
}
