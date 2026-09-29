package com.openai.client.okhttp

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.azure.AzureUrlPathMode
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.helpers.TranslationConnection
import com.openai.helpers.TranslationWebSocketOptions
import com.openai.models.realtime.RealtimeTranslationClientEvent
import com.openai.models.realtime.RealtimeTranslationInputAudioBufferAppendEvent
import com.openai.models.realtime.RealtimeTranslationServerEvent
import com.openai.models.realtime.RealtimeTranslationSessionClosedEvent
import java.io.IOException
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(25)
class TranslationConnectionTest {
    private val mapper = jsonMapper()
    private val deadline = Duration.ofSeconds(5)
    private val appended = "session.input_audio_buffer.append"
    private val close = "session.close"

    private fun audio(value: String = "AAAA") =
        RealtimeTranslationClientEvent.ofSessionInputAudioBufferAppend(
            RealtimeTranslationInputAudioBufferAppendEvent.builder().audio(value).build()
        )

    private fun options(server: MockWebServer, http: HttpClient) =
        ClientOptions.builder()
            .httpClient(http)
            .apiKey("fake-translation-key")
            .baseUrl(server.url("/v1?inherited=1").toString())
            .build()

    private inner class Peer(private val whenClosing: (WebSocket) -> Unit = {}) :
        WebSocketListener() {
        val socket = CompletableFuture<WebSocket>()
        val messages = LinkedBlockingQueue<JsonNode>()
        val terminated = CountDownLatch(1)

        override fun onOpen(webSocket: WebSocket, response: Response) {
            socket.complete(webSocket)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            val json = mapper.readTree(text)
            messages.add(json)
            if (json.path("type").asText() == close) whenClosing(webSocket)
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            webSocket.close(code, reason)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            terminated.countDown()
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            terminated.countDown()
        }

        fun next(): JsonNode = checkNotNull(messages.poll(7, TimeUnit.SECONDS))
    }

    private fun finalEvents(socket: WebSocket) {
        socket.send(
            """{"type":"session.output_transcript.delta","event_id":"t","delta":"Hola","elapsed_ms":200}"""
        )
        socket.send(
            """{"type":"session.output_audio.delta","event_id":"a","delta":"AQID","sample_rate":24000}"""
        )
        socket.send("""{"type":"session.closed","event_id":"done"}""")
    }

    @Test
    fun preparedRouteAndBothReceiveStylesKeepErrorAndFutureTypesObservable() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val settings =
                        TranslationWebSocketOptions.builder()
                            .model("translation-test")
                            .putHeader("X-Test", "one")
                            .putQueryParam("another", "2")
                            .build()
                    val connection =
                        if (async)
                            TranslationConnection.connectAsync(options(server, http), settings)
                                .get(7, TimeUnit.SECONDS)
                        else TranslationConnection.connect(options(server, http), settings)
                    connection.use {
                        val request = checkNotNull(server.takeRequest(7, TimeUnit.SECONDS))
                        assertThat(request.requestUrl!!.encodedPath)
                            .isEqualTo("/v1/realtime/translations")
                        assertThat(request.requestUrl!!.queryParameter("model"))
                            .isEqualTo("translation-test")
                        assertThat(request.requestUrl!!.queryParameter("inherited")).isEqualTo("1")
                        assertThat(request.requestUrl!!.queryParameter("another")).isEqualTo("2")
                        assertThat(request.requestUrl!!.queryParameter("intent")).isNull()
                        assertThat(request.getHeader("OpenAI-Beta")).isNull()
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer fake-translation-key")
                        assertThat(request.getHeader("X-Test")).isEqualTo("one")
                        it.send(audio())
                        val append = peer.next()
                        assertThat(append.path("type").asText()).isEqualTo(appended)
                        assertThat(append.path("audio").asText()).isEqualTo("AAAA")
                        val socket = peer.socket.get(7, TimeUnit.SECONDS)
                        socket.send(
                            """{"type":"error","event_id":"e","error":{"type":"invalid_request_error","code":"synthetic","message":"test"}}"""
                        )
                        val error =
                            if (async) it.receiveAsync().get(7, TimeUnit.SECONDS) else it.receive()
                        assertThat(error.asError().error().message()).isEqualTo("test")
                        socket.send("""{"type":"translation.future","raw":{"more":[1,2,3]}}""")
                        val future =
                            if (async) it.receiveAsync().get(7, TimeUnit.SECONDS) else it.receive()
                        assertThat(future._json()).isPresent
                        assertThat(mapper.valueToTree<JsonNode>(future).at("/raw/more/2").asInt())
                            .isEqualTo(3)
                        it.send(audio("AQID"))
                        assertThat(peer.next().path("audio").asText()).isEqualTo("AQID")
                    }
                }
            }
        }
    }

    @Test
    fun finishWithoutAnActiveReaderPreservesFinalTranscriptAudioAndValidatedClosed() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                TranslationConnection.connect(options(server, http)).use { connection ->
                    connection.send(audio())
                    assertThat(peer.next().path("type").asText()).isEqualTo(appended)
                    val finish = connection.finishAsync(deadline)
                    assertThat(connection.finishAsync(deadline)).isSameAs(finish)
                    assertThat(finish.get(7, TimeUnit.SECONDS).eventId()).isEqualTo("done")
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    val text = connection.receive().asSessionOutputTranscriptDelta()
                    assertThat(text.delta()).isEqualTo("Hola")
                    assertThat(text.elapsedMs()).hasValue(200L)
                    val audio =
                        connection
                            .receiveAsync()
                            .get(7, TimeUnit.SECONDS)
                            .asSessionOutputAudioDelta()
                    assertThat(audio.delta()).isEqualTo("AQID")
                    assertThat(audio.sampleRate()).hasValue(24000L)
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("done")
                    assertThatThrownBy { connection.receive() }.hasMessageContaining("failed")
                    assertThatThrownBy { connection.send(audio()) }
                        .isInstanceOf(IllegalStateException::class.java)
                    assertThat(peer.terminated.await(7, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun directExecutorCallbackCanFinishWithOneReaderAndRetainsLaterEvents() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(
                MockResponse()
                    .setHeadersDelay(180, TimeUnit.MILLISECONDS)
                    .withWebSocketUpgrade(peer)
            )
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http).toBuilder().streamHandlerExecutor { it.run() }.build()
                val received =
                    TranslationConnection.connectAsync(configuration).thenApply { connection ->
                        connection.use {
                            it.send(audio())
                            assertThat(it.finish(deadline).eventId()).isEqualTo("done")
                            listOf(
                                it.receive().asSessionOutputTranscriptDelta().delta(),
                                it.receive().asSessionOutputAudioDelta().delta(),
                                it.receive().asSessionClosed().eventId(),
                            )
                        }
                    }
                assertThat(received.get(7, TimeUnit.SECONDS))
                    .containsExactly("Hola", "AQID", "done")
                assertThat(peer.next().path("type").asText()).isEqualTo(appended)
                assertThat(peer.next().path("type").asText()).isEqualTo(close)
            }
        }
    }

    @Test
    fun canceledReceiveAndSingleReaderWorkWhileFinishDoesNotStealEitherEvent() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                TranslationConnection.connect(options(server, http)).use { connection ->
                    val canceled = connection.receiveAsync()
                    assertThatThrownBy { connection.receiveAsync() }
                        .hasMessageContaining("already pending")
                    assertThat(canceled.cancel(false)).isTrue()
                    val waiting = connection.receiveAsync()
                    val ending = connection.finishAsync(deadline)
                    assertThat(
                            waiting
                                .get(7, TimeUnit.SECONDS)
                                .asSessionOutputTranscriptDelta()
                                .delta()
                        )
                        .isEqualTo("Hola")
                    assertThat(ending.get(7, TimeUnit.SECONDS).eventId()).isEqualTo("done")
                    assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                        .isEqualTo("AQID")
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("done")
                }
            }
        }
    }

    @Test
    fun intentAndAzureAreRejectedBeforeOpeningOrSendingCredentials() {
        MockWebServer().use { server ->
            OkHttpClient.builder().build().use { http ->
                val inheritedIntent =
                    options(server, http)
                        .toBuilder()
                        .baseUrl(server.url("/v1?intent=translation").toString())
                        .build()
                assertThatThrownBy { TranslationConnection.connect(inheritedIntent) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("intent")
                val explicit =
                    TranslationWebSocketOptions.builder()
                        .putQueryParam("intent", "transcription")
                        .build()
                assertThatThrownBy {
                        TranslationConnection.connect(options(server, http), explicit)
                    }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("intent")
                for (pathMode in listOf(AzureUrlPathMode.LEGACY, AzureUrlPathMode.UNIFIED)) {
                    val azure = options(server, http).toBuilder().azureUrlPathMode(pathMode).build()
                    assertThatThrownBy { TranslationConnection.connect(azure) }
                        .isInstanceOf(IllegalArgumentException::class.java)
                        .hasMessageContaining("Azure")
                }
                assertThat(server.requestCount).isZero()
            }
        }
    }

    @Test
    fun unknownAndErrorCannotSatisfyFinishBeforeNormalTransportClose() {
        MockWebServer().use { server ->
            val peer = Peer { socket ->
                socket.send(
                    """{"type":"error","event_id":"e","error":{"type":"server_error","message":"not done"}}"""
                )
                socket.send("""{"type":"future.session.closed","event_id":"nope"}""")
                socket.close(1000, "synthetic eof")
            }
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                TranslationConnection.connect(options(server, http)).use { connection ->
                    val finish = connection.finishAsync(deadline)
                    assertThatThrownBy { finish.get(7, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCauseInstanceOf(IOException::class.java)
                    assertThat(connection.receive().isError()).isTrue()
                    assertThat(connection.receive()._json()).isPresent
                    assertThatThrownBy { connection.receive() }.hasMessageContaining("failed")
                    assertThat(server.requestCount).isEqualTo(1)
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun malformedEnvelopeAndInvalidTerminalNeverBecomeSuccessfulDrainEvenLenient() {
        for (frame in
            listOf(
                """{"type":"session.closed"}""",
                """{"type":"session.closed","event_id":33}""",
                """{"type":"session.closed","event_id":"x"} {}""",
                """{"type":false,"event_id":"x"}""",
            )) {
            MockWebServer().use { server ->
                val peer = Peer { it.send(frame) }
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    TranslationConnection.connect(options(server, http)).use { connection ->
                        assertThatThrownBy {
                                connection.finishAsync(deadline).get(7, TimeUnit.SECONDS)
                            }
                            .isInstanceOf(ExecutionException::class.java)
                        assertThatThrownBy { connection.receive() }
                            .isInstanceOf(RuntimeException::class.java)
                        assertThat(peer.next().path("type").asText()).isEqualTo(close)
                        assertThat(server.requestCount).isEqualTo(1)
                    }
                }
            }
        }
    }

    @Test
    fun overflowBeforeTerminalFailsDrainButPreviouslyAdmittedDataCanStillBeRead() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val limited = TranslationWebSocketOptions.builder().maxQueuedEvents(1).build()
                TranslationConnection.connect(options(server, http), limited).use { connection ->
                    assertThatThrownBy { connection.finishAsync(deadline).get(7, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCauseInstanceOf(IOException::class.java)
                    assertThat(connection.receive().asSessionOutputTranscriptDelta().delta())
                        .isEqualTo("Hola")
                    assertThatThrownBy { connection.receive() }.hasMessageContaining("failed")
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun finishTimeoutAndCancellationBothReleaseOnlyTheirSocketWithoutReplay() {
        for (cancel in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Peer { it.send("""{"type":"future.keepalive"}""") }
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    TranslationConnection.connect(options(server, http)).use { connection ->
                        val end =
                            connection.finishAsync(if (cancel) deadline else Duration.ofSeconds(2))
                        assertThat(peer.next().path("type").asText()).isEqualTo(close)
                        assertThat(connection.receive()._json()).isPresent
                        if (cancel) {
                            assertThat(end.cancel(false)).isTrue()
                            assertThatThrownBy { connection.receive() }
                                .hasMessageContaining("closed")
                        } else {
                            assertThatThrownBy { end.get(7, TimeUnit.SECONDS) }
                                .isInstanceOf(ExecutionException::class.java)
                                .hasCauseInstanceOf(TimeoutException::class.java)
                            assertThatThrownBy { connection.receive() }
                                .hasMessageContaining("failed")
                        }
                        assertThat(peer.terminated.await(7, TimeUnit.SECONDS)).isTrue()
                        assertThat(peer.messages).isEmpty()
                        assertThat(server.requestCount).isEqualTo(1)
                    }
                }
            }
        }
    }

    private fun wrapping(
        delegate: OkHttpClient,
        write: (WebSocketClient.Connection, String) -> Unit,
    ): HttpClient =
        object : HttpClient by delegate, WebSocketClient {
            override fun connectWebSocket(
                request: HttpRequest,
                requestOptions: RequestOptions,
                maxMessageBytes: Int,
                listener: WebSocketClient.Listener,
            ): CompletableFuture<WebSocketClient.Connection> =
                delegate
                    .connectWebSocket(request, requestOptions, maxMessageBytes, listener)
                    .thenApply { connection ->
                        object : WebSocketClient.Connection by connection {
                            override fun send(text: String) = write(connection, text)
                        }
                    }
        }

    @Test
    fun nativeCapacityObservationPreservesPendingReadAndDoesNotSend() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val settings = TranslationWebSocketOptions.builder().sendTimeout(deadline).build()
                TranslationConnection.connect(options(server, http), settings).use { connection ->
                    val reading = connection.receiveAsync()
                    connection.awaitWritable(deadline)
                    assertThat(peer.messages).isEmpty()
                    peer.socket
                        .get(5, TimeUnit.SECONDS)
                        .send(
                            """{"type":"session.output_transcript.delta","event_id":"t","delta":"Hola","elapsed_ms":200}"""
                        )
                    assertThat(
                            reading
                                .get(5, TimeUnit.SECONDS)
                                .asSessionOutputTranscriptDelta()
                                .delta()
                        )
                        .isEqualTo("Hola")
                    connection.send(audio())
                    connection.awaitWritable(deadline)
                    assertThat(peer.next().path("type").asText()).isEqualTo(appended)
                    assertThat(connection.finish(deadline).eventId()).isEqualTo("done")
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun timedSendsReleaseAdmissionBeforeReturningIncludingRecoverableMessageRejections() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val settings =
                    TranslationWebSocketOptions.builder()
                        .maxMessageBytes(256)
                        .sendTimeout(deadline)
                        .build()
                TranslationConnection.connect(options(server, http), settings).use { connection ->
                    repeat(40) {
                        assertThatThrownBy { connection.send(audio("A".repeat(512))) }
                            .isInstanceOf(IllegalArgumentException::class.java)
                        connection.send(audio("AQID"))
                        connection.send(audio("AAAB"))
                        assertThat(peer.next().path("audio").asText()).isEqualTo("AQID")
                        assertThat(peer.next().path("audio").asText()).isEqualTo("AAAB")
                    }
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun legacyTransportKeepsDefaultImmediateBusyAndExplicitWaitReportsUnsupported() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val attempts = AtomicInteger()
                val client =
                    wrapping(http) { native, text ->
                        if (attempts.getAndIncrement() == 0)
                            throw WebSocketWriteNotAttempted.Busy("synthetic admission failure")
                        native.send(text)
                    }
                val settings =
                    TranslationWebSocketOptions.builder()
                        .sendTimeout(deadline)
                        .sendTimeout(null)
                        .build()
                TranslationConnection.connect(options(server, client), settings).use { connection ->
                    assertThatThrownBy { connection.awaitWritable(deadline) }
                        .isInstanceOf(UnsupportedOperationException::class.java)
                    assertThatThrownBy { connection.send(audio()) }
                        .isInstanceOf(WebSocketWriteNotAttempted.Busy::class.java)
                    assertThat(peer.messages).isEmpty()
                    connection.send(audio("AQID"))
                    assertThat(peer.next().path("audio").asText()).isEqualTo("AQID")
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun timedLegacySendCanWaitThroughOnlyTypedBusyAndFinishCannotOvertakeIt() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val admitted = CountDownLatch(1)
                val release = CountDownLatch(1)
                val client =
                    wrapping(http) { native, text ->
                        if (
                            mapper.readTree(text).path("type").asText() == appended &&
                                release.count > 0
                        ) {
                            admitted.countDown()
                            throw WebSocketWriteNotAttempted.Busy("synthetic transport admission")
                        }
                        native.send(text)
                    }
                val settings = TranslationWebSocketOptions.builder().sendTimeout(deadline).build()
                TranslationConnection.connect(options(server, client), settings).use { connection ->
                    try {
                        val reading = connection.receiveAsync()
                        val input = CompletableFuture.runAsync { connection.send(audio()) }
                        assertThat(admitted.await(5, TimeUnit.SECONDS)).isTrue()
                        val end = connection.finishAsync(deadline)
                        assertThat(peer.messages).isEmpty()
                        release.countDown()
                        input.get(5, TimeUnit.SECONDS)
                        assertThat(end.get(5, TimeUnit.SECONDS).eventId()).isEqualTo("done")
                        assertThat(peer.next().path("type").asText()).isEqualTo(appended)
                        assertThat(peer.next().path("type").asText()).isEqualTo(close)
                        assertThat(
                                reading
                                    .get(5, TimeUnit.SECONDS)
                                    .asSessionOutputTranscriptDelta()
                                    .delta()
                            )
                            .isEqualTo("Hola")
                        assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                            .isEqualTo("AQID")
                        assertThat(connection.receive().asSessionClosed().eventId())
                            .isEqualTo("done")
                        assertThat(peer.messages).isEmpty()
                    } finally {
                        release.countDown()
                    }
                }
            }
        }
    }

    @Test
    fun timedCustomSendCanBlockWithoutPreventingTimeoutOrClosingSharedClient() {
        MockWebServer().use { server ->
            val peer = Peer()
            val neighbor = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            server.enqueue(MockResponse().withWebSocketUpgrade(neighbor))
            OkHttpClient.builder().build().use { http ->
                val entered = CountDownLatch(1)
                val release = CountDownLatch(1)
                val client =
                    wrapping(http) { native, text ->
                        entered.countDown()
                        check(release.await(7, TimeUnit.SECONDS))
                        native.send(text)
                    }
                val settings =
                    TranslationWebSocketOptions.builder()
                        .sendTimeout(Duration.ofMillis(250))
                        .build()
                TranslationConnection.connect(options(server, client), settings).use { connection ->
                    TranslationConnection.connect(options(server, http)).use { unaffected ->
                        try {
                            val reading = connection.receiveAsync()
                            val input = CompletableFuture.runAsync { connection.send(audio()) }
                            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                            assertThatThrownBy { input.get(3, TimeUnit.SECONDS) }
                                .hasRootCauseInstanceOf(TimeoutException::class.java)
                            assertThatThrownBy { reading.get(3, TimeUnit.SECONDS) }
                                .hasCauseInstanceOf(TimeoutException::class.java)
                            assertThat(peer.terminated.await(3, TimeUnit.SECONDS)).isTrue()
                            assertThat(peer.messages).isEmpty()
                            unaffected.send(audio("AQID"))
                            assertThat(neighbor.next().path("audio").asText()).isEqualTo("AQID")
                            release.countDown()
                            assertThatThrownBy { connection.send(audio()) }
                                .hasMessageContaining("not connected")
                        } finally {
                            release.countDown()
                        }
                    }
                }
            }
        }
    }

    @Test
    fun timeoutDuringCustomReadinessPreventsAnyLateSendAfterUnblocking() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val entered = CountDownLatch(1)
                val release = CountDownLatch(1)
                val finished = CountDownLatch(1)
                val writes = AtomicInteger()
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http
                                .connectWebSocket(
                                    request,
                                    requestOptions,
                                    maxMessageBytes,
                                    listener,
                                )
                                .thenApply { native ->
                                    object : WebSocketClient.WritableConnection {
                                        override fun awaitWritable(timeout: Duration) {
                                            entered.countDown()
                                            try {
                                                check(release.await(15, TimeUnit.SECONDS))
                                            } finally {
                                                finished.countDown()
                                            }
                                        }

                                        override fun send(text: String) {
                                            writes.incrementAndGet()
                                            native.send(text)
                                        }

                                        override fun close() = native.close()
                                    }
                                }
                    }
                val settings = TranslationWebSocketOptions.builder().sendTimeout(deadline).build()
                TranslationConnection.connect(options(server, client), settings).use { connection ->
                    try {
                        val input = CompletableFuture.runAsync { connection.send(audio()) }
                        assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                        assertThatThrownBy { input.get(10, TimeUnit.SECONDS) }
                            .hasRootCauseInstanceOf(TimeoutException::class.java)
                        assertThat(peer.terminated.await(3, TimeUnit.SECONDS)).isTrue()
                        release.countDown()
                        assertThat(finished.await(3, TimeUnit.SECONDS)).isTrue()
                        assertThat(writes.get()).isZero()
                        assertThat(peer.messages).isEmpty()
                    } finally {
                        release.countDown()
                    }
                }
            }
        }
    }

    @Test
    fun possiblyAttemptedTimedWriteNeverRetriesOrReusesConnection() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    wrapping(http) { native, text ->
                        native.send(text)
                        throw IOException("synthetic error after write")
                    }
                val settings = TranslationWebSocketOptions.builder().sendTimeout(deadline).build()
                TranslationConnection.connect(options(server, client), settings).use { connection ->
                    assertThatThrownBy { connection.send(audio()) }
                        .hasRootCauseMessage("synthetic error after write")
                    assertThatThrownBy { connection.send(audio("AQID")) }
                        .hasMessageContaining("not connected")
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages.size).isLessThanOrEqualTo(1)
                }
            }
        }
    }

    @Test
    fun finishFollowsAnAdmittedInFlightAppendAndOnlyRetriesTypedPrewriteBusy() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val admitted = CountDownLatch(1)
                val release = CountDownLatch(1)
                val remainingBusy = AtomicInteger(2)
                val client =
                    wrapping(http) { socket, text ->
                        when (mapper.readTree(text).path("type").asText()) {
                            appended -> {
                                admitted.countDown()
                                check(release.await(7, TimeUnit.SECONDS))
                                socket.send(text)
                            }
                            close -> {
                                if (remainingBusy.getAndDecrement() > 0)
                                    throw WebSocketWriteNotAttempted.Busy(
                                        "synthetic transport admission"
                                    )
                                socket.send(text)
                            }
                            else -> socket.send(text)
                        }
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    try {
                        val input = CompletableFuture.runAsync { connection.send(audio()) }
                        assertThat(admitted.await(7, TimeUnit.SECONDS)).isTrue()
                        val end = connection.finishAsync(deadline)
                        assertThatThrownBy { connection.send(audio("AQID")) }
                            .hasMessageContaining("finishing")
                        assertThat(peer.messages).isEmpty()
                        release.countDown()
                        input.get(7, TimeUnit.SECONDS)
                        assertThat(end.get(7, TimeUnit.SECONDS).eventId()).isEqualTo("done")
                        assertThat(peer.next().path("type").asText()).isEqualTo(appended)
                        assertThat(peer.next().path("type").asText()).isEqualTo(close)
                        assertThat(peer.messages).isEmpty()
                        assertThat(connection.receive().asSessionOutputTranscriptDelta().delta())
                            .isEqualTo("Hola")
                        assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                            .isEqualTo("AQID")
                        assertThat(connection.receive().asSessionClosed().eventId())
                            .isEqualTo("done")
                    } finally {
                        release.countDown()
                    }
                }
            }
        }
    }

    @Test
    fun genericIllegalStateAfterActuallyWritingCloseCannotTriggerReplayOrSuccess() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    wrapping(http) { socket, text ->
                        socket.send(text)
                        if (mapper.readTree(text).path("type").asText() == close) {
                            check(peer.next().path("type").asText() == close)
                            throw IllegalStateException("uncertain after native write")
                        }
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    assertThatThrownBy { connection.finishAsync(deadline).get(7, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCauseInstanceOf(IllegalStateException::class.java)
                    assertThatThrownBy { connection.receive() }.hasMessageContaining("uncertain")
                    assertThat(peer.terminated.await(7, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun invalidFrameReleasesCustomTransportWhoseCloseJoinsItsReader() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val readerReturned = CountDownLatch(1)
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http
                                .connectWebSocket(
                                    request,
                                    options,
                                    maxMessageBytes,
                                    object : WebSocketClient.Listener by listener {
                                        override fun onMessage(text: String) {
                                            try {
                                                listener.onMessage(text)
                                            } finally {
                                                readerReturned.countDown()
                                            }
                                        }
                                    },
                                )
                                .thenApply { socket ->
                                    object : WebSocketClient.Connection by socket {
                                        override fun close() {
                                            check(readerReturned.await(2, TimeUnit.SECONDS)) {
                                                "Cannot release transport until its reader returns"
                                            }
                                            socket.close()
                                        }
                                    }
                                }
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    val event = connection.receiveAsync()
                    peer.socket.get(7, TimeUnit.SECONDS).send("""{"type":false}""")
                    assertThatThrownBy { event.get(7, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .cause()
                        .isInstanceOf(IllegalArgumentException::class.java)
                        .hasMessage("Invalid Translation event")
                        .hasNoSuppressedExceptions()
                    assertThat(peer.terminated.await(7, TimeUnit.SECONDS)).isTrue()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun parallelFinishesAllowAllHealthySessionsToDrainBeforeTheirDeadlines() {
        MockWebServer().use { server ->
            val received = CountDownLatch(4)
            val peers = (1..4).map { Peer { received.countDown() } }
            peers.forEach { server.enqueue(MockResponse().withWebSocketUpgrade(it)) }
            OkHttpClient.builder().build().use { http ->
                val connections = peers.map { TranslationConnection.connect(options(server, http)) }
                try {
                    val finishes = connections.map { it.finishAsync(Duration.ofSeconds(9)) }
                    assertThat(received.await(5, TimeUnit.SECONDS)).isTrue()
                    peers.forEach { finalEvents(it.socket.get(7, TimeUnit.SECONDS)) }
                    for (i in peers.indices) {
                        assertThat(finishes[i].get(7, TimeUnit.SECONDS).eventId()).isEqualTo("done")
                        assertThat(peers[i].next().path("type").asText()).isEqualTo(close)
                        assertThat(
                                connections[i].receive().asSessionOutputTranscriptDelta().delta()
                            )
                            .isEqualTo("Hola")
                        assertThat(connections[i].receive().asSessionOutputAudioDelta().delta())
                            .isEqualTo("AQID")
                        assertThat(connections[i].receive().asSessionClosed().eventId())
                            .isEqualTo("done")
                        assertThat(peers[i].messages).isEmpty()
                    }
                } finally {
                    connections.forEach { it.close() }
                }
            }
        }
    }

    @Test
    fun transportThrowableReachesTheFinishFutureAndPendingReadWithoutReplay() {
        MockWebServer().use { server ->
            val peer = Peer { it.send("""{"type":"synthetic.transport_failure"}""") }
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val problem = AssertionError("reported from Translation transport")
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http.connectWebSocket(
                                request,
                                options,
                                maxMessageBytes,
                                object : WebSocketClient.Listener by listener {
                                    override fun onMessage(text: String) =
                                        listener.onFailure(problem)
                                },
                            )
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    val event = connection.receiveAsync()
                    val end = connection.finishAsync(Duration.ofSeconds(2))
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    assertThatThrownBy { end.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCause(problem)
                    assertThatThrownBy { event.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCause(problem)
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun perConnectionModelReplacesInheritedAndEncodedBaseUrlModels() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http)
                        .toBuilder()
                        .baseUrl(server.url("/v1?model=old&%6Dodel=other&keep=a%2Fb").toString())
                        .putQueryParam("model", "inherited")
                        .build()
                val settings = TranslationWebSocketOptions.builder().model("chosen").build()
                TranslationConnection.connect(configuration, settings).use {
                    val request = checkNotNull(server.takeRequest(7, TimeUnit.SECONDS))
                    assertThat(request.requestUrl!!.encodedPath)
                        .isEqualTo("/v1/realtime/translations")
                    assertThat(request.requestUrl!!.queryParameterValues("model"))
                        .containsExactly("chosen")
                    assertThat(request.requestUrl!!.queryParameter("keep")).isEqualTo("a/b")
                    it.send(audio())
                    assertThat(peer.next().path("type").asText()).isEqualTo(appended)
                }
            }
        }
    }

    @Test
    fun earlyFailedUpgradeReleasesSocketWithoutBlockingTheConnectCompletionThread() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val completionReturned = CountDownLatch(1)
                val problem = IOException("synthetic early listener failure")
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> {
                            val active =
                                http
                                    .connectWebSocket(request, options, maxMessageBytes, listener)
                                    .get(7, TimeUnit.SECONDS)
                            listener.onFailure(problem)
                            return CompletableFuture.completedFuture(
                                object : WebSocketClient.Connection by active {
                                    override fun close() {
                                        check(completionReturned.await(2, TimeUnit.SECONDS)) {
                                            "Cannot join connect completion from its own thread"
                                        }
                                        active.close()
                                    }
                                }
                            )
                        }
                    }
                val opening = TranslationConnection.connectAsync(options(server, client))
                completionReturned.countDown()
                assertThatThrownBy { opening.get(5, TimeUnit.SECONDS) }
                    .isInstanceOf(ExecutionException::class.java)
                    .hasCause(problem)
                assertThat(problem).hasNoSuppressedExceptions()
                assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(server.requestCount).isEqualTo(1)
            }
        }
    }

    @Test
    fun listenerFailureWhileUpgradeIsPendingRetainsTheCauseAndCancelsOnlyThatSocket() {
        MockWebServer().use { server ->
            val failing = Peer()
            val other = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(failing))
            server.enqueue(MockResponse().withWebSocketUpgrade(other))
            OkHttpClient.builder().build().use { http ->
                val error = IOException("synthetic upgrade listener failure")
                val listenerReady = CompletableFuture<WebSocketClient.Listener>()
                val native = CompletableFuture<WebSocketClient.Connection>()
                val pending = CompletableFuture<WebSocketClient.Connection>()
                pending.whenComplete { _, _ ->
                    if (pending.isCancelled) native.thenAccept { it.close() }
                }
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> {
                            listenerReady.complete(listener)
                            http
                                .connectWebSocket(request, options, maxMessageBytes, listener)
                                .thenAccept { native.complete(it) }
                            return pending
                        }
                    }
                val opening = TranslationConnection.connectAsync(options(server, client))
                native.get(5, TimeUnit.SECONDS)
                TranslationConnection.connect(options(server, http)).use { unaffected ->
                    listenerReady.get(5, TimeUnit.SECONDS).onFailure(error)
                    assertThatThrownBy { opening.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCause(error)
                    assertThat(failing.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(pending.isCancelled).isTrue()
                    assertThat(failing.messages).isEmpty()
                    unaffected.send(audio("AQ=="))
                    assertThat(other.next().path("audio").asText()).isEqualTo("AQ==")
                }
                assertThat(other.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(server.requestCount).isEqualTo(2)
            }
        }
    }

    @Test
    fun attemptedSendThrowableLeavesTheSocketUnusableAndCannotReplayAudio() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val problem = AssertionError("synthetic error after actual audio send")
                val attempts = AtomicInteger()
                val client =
                    wrapping(http) { socket, text ->
                        socket.send(text)
                        if (attempts.getAndIncrement() == 0) {
                            check(peer.next().path("audio").asText() == "AAAA")
                            throw problem
                        }
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    assertThatThrownBy { connection.send(audio()) }.isSameAs(problem)
                    assertThatThrownBy { connection.send(audio("AQID")) }
                        .isInstanceOf(IllegalStateException::class.java)
                    assertThatThrownBy { connection.finishAsync(deadline).get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCause(problem)
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun failedReadCanReleaseBlockingCleanupAndRetainsLaterSuppressedThrowable() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val closing = AssertionError("synthetic native close failure")
                val observedError = CountDownLatch(1)
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http
                                .connectWebSocket(request, options, maxMessageBytes, listener)
                                .thenApply { native ->
                                    object : WebSocketClient.Connection by native {
                                        override fun close() {
                                            try {
                                                check(observedError.await(9, TimeUnit.SECONDS)) {
                                                    "Application cannot tear down before its read fails"
                                                }
                                            } finally {
                                                native.close()
                                            }
                                            throw closing
                                        }
                                    }
                                }
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    val read = connection.receiveAsync()
                    peer.socket.get(5, TimeUnit.SECONDS).send("""{"type":42}""")
                    val original =
                        try {
                            val readError = catchThrowable { read.get(3, TimeUnit.SECONDS) }
                            assertThat(readError).isInstanceOf(ExecutionException::class.java)
                            checkNotNull(readError.cause).also {
                                assertThat(it)
                                    .isInstanceOf(IllegalArgumentException::class.java)
                                    .hasMessage("Invalid Translation event")
                            }
                        } finally {
                            observedError.countDown()
                        }
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    // Cleanup can only finish after delivery; preserve its eventual error on the
                    // same exception, without making read delivery depend on application teardown.
                    val until = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                    while (original.suppressed.isEmpty() && System.nanoTime() < until) Thread.sleep(
                        10
                    )
                    assertThat(original).hasSuppressedException(closing)
                }
            }
        }
    }

    @Test
    fun finishDoesNotWriteCloseIfSerializationConsumedItsDeadline() {
        MockWebServer().use { server ->
            val closeReceived = CountDownLatch(1)
            val peer = Peer { closeReceived.countDown() }
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    wrapping(http) { native, text ->
                        native.send(text)
                        check(closeReceived.await(5, TimeUnit.SECONDS))
                    }
                val prepared =
                    options(server, client)
                        .toBuilder()
                        .jsonMapper(
                            object : JsonMapper(mapper) {
                                override fun writeValueAsString(value: Any): String {
                                    if (
                                        value is RealtimeTranslationClientEvent &&
                                            value.isSessionClose()
                                    )
                                        Thread.sleep(300)
                                    return super.writeValueAsString(value)
                                }
                            }
                        )
                        .build()
                TranslationConnection.connect(prepared).use { connection ->
                    val end = connection.finishAsync(Duration.ofMillis(150))
                    assertThatThrownBy { end.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCauseInstanceOf(TimeoutException::class.java)
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun customTransportCanUsePublicRequestUrlWithInheritedQueriesAndModelOverride() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http.connectWebSocket(
                                request
                                    .toBuilder()
                                    .baseUrl(request.url())
                                    .pathSegments(emptyList())
                                    .queryParams(emptyMap())
                                    .build(),
                                options,
                                maxMessageBytes,
                                listener,
                            )
                    }
                val configuration =
                    options(server, client)
                        .toBuilder()
                        .baseUrl(
                            server
                                .url("/v1?tenant=a%2Fb&%6Dodel=old&tag=%E2%9C%93&tag=x+y")
                                .toString()
                        )
                        .build()
                TranslationConnection.connect(
                        configuration,
                        TranslationWebSocketOptions.builder().model("chosen").build(),
                    )
                    .use { connection ->
                        val request = checkNotNull(server.takeRequest(5, TimeUnit.SECONDS))
                        assertThat(request.requestUrl!!.encodedPath)
                            .isEqualTo("/v1/realtime/translations")
                        assertThat(request.requestUrl!!.queryParameterValues("model"))
                            .containsExactly("chosen")
                        assertThat(request.requestUrl!!.queryParameter("tenant")).isEqualTo("a/b")
                        assertThat(request.requestUrl!!.queryParameterValues("tag"))
                            .containsExactly("✓", "x y")
                        assertThat(request.getHeader("Authorization"))
                            .isEqualTo("Bearer fake-translation-key")
                        connection.send(audio())
                        assertThat(peer.next().path("audio").asText()).isEqualTo("AAAA")
                    }
            }
        }
    }

    @Test
    fun terminalCleanupThrowableIsReturnedWithoutReplacingItByTimeout() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val closing = AssertionError("synthetic terminal transport cleanup failure")
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http
                                .connectWebSocket(request, options, maxMessageBytes, listener)
                                .thenApply { native ->
                                    object : WebSocketClient.Connection by native {
                                        override fun close() {
                                            native.close()
                                            throw closing
                                        }
                                    }
                                }
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    assertThatThrownBy { connection.finishAsync(deadline).get(7, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCause(closing)
                    assertThat(connection.receive().asSessionOutputTranscriptDelta().delta())
                        .isEqualTo("Hola")
                    assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                        .isEqualTo("AQID")
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("done")
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                }
            }
        }
    }

    @Test
    fun terminalCannotSucceedWhenAdmittedSendReturnsAfterDeadline() {
        MockWebServer().use { server ->
            val peer = Peer(::finalEvents)
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    wrapping(http) { native, text ->
                        native.send(text)
                        check(peer.terminated.await(5, TimeUnit.SECONDS))
                        Thread.sleep(1200)
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    assertThatThrownBy {
                            connection.finishAsync(Duration.ofSeconds(1)).get(5, TimeUnit.SECONDS)
                        }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCauseInstanceOf(TimeoutException::class.java)
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    assertThat(peer.messages).isEmpty()
                    assertThat(connection.receive().asSessionOutputTranscriptDelta().delta())
                        .isEqualTo("Hola")
                    assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                        .isEqualTo("AQID")
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("done")
                }
            }
        }
    }

    @Test
    fun singleThreadAsyncCallbackCanReceiveBlockingWithoutLosingNextWireEvent() {
        MockWebServer().use { server ->
            val executor = Executors.newSingleThreadExecutor()
            try {
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val configuration =
                        options(server, http).toBuilder().streamHandlerExecutor(executor).build()
                    TranslationConnection.connect(configuration).use { connection ->
                        val received =
                            connection.receiveAsync().thenApply {
                                connection.send(audio())
                                listOf(
                                    it.asSessionOutputTranscriptDelta().delta(),
                                    connection.receive().asSessionOutputAudioDelta().delta(),
                                )
                            }
                        val socket = peer.socket.get(5, TimeUnit.SECONDS)
                        socket.send(
                            """{"type":"session.output_transcript.delta","event_id":"text","delta":"Hola"}"""
                        )
                        assertThat(peer.next().path("audio").asText()).isEqualTo("AAAA")
                        // Arrive after the callback has begun waiting for the next network frame.
                        Thread.sleep(100)
                        socket.send(
                            """{"type":"session.output_audio.delta","event_id":"audio","delta":"AQID"}"""
                        )
                        assertThat(received.get(5, TimeUnit.SECONDS))
                            .containsExactly("Hola", "AQID")
                        assertThat(peer.messages).isEmpty()
                        assertThat(server.requestCount).isEqualTo(1)
                    }
                }
            } finally {
                // A failing implementation can leave the claimed read's completion queued.
                // Release it during test cleanup, retaining the original observable failure.
                executor.shutdownNow().forEach { it.run() }
                executor.awaitTermination(5, TimeUnit.SECONDS)
            }
        }
    }

    @Test
    fun finishTimeoutClosesBlockedSerializationAndBlockedAdmissionWithoutReplay() {
        for (serialize in listOf(true, false)) {
            MockWebServer().use { server ->
                val peer = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val began = CountDownLatch(1)
                    val closed = CountDownLatch(1)
                    val client =
                        object : HttpClient by http, WebSocketClient {
                            override fun connectWebSocket(
                                request: HttpRequest,
                                options: RequestOptions,
                                maxMessageBytes: Int,
                                listener: WebSocketClient.Listener,
                            ): CompletableFuture<WebSocketClient.Connection> =
                                http
                                    .connectWebSocket(request, options, maxMessageBytes, listener)
                                    .thenApply { native ->
                                        object : WebSocketClient.Connection by native {
                                            override fun send(text: String) {
                                                if (!serialize) {
                                                    began.countDown()
                                                    check(closed.await(9, TimeUnit.SECONDS))
                                                }
                                                native.send(text)
                                            }

                                            override fun close() {
                                                native.close()
                                                closed.countDown()
                                            }
                                        }
                                    }
                        }
                    val configuration =
                        options(server, client)
                            .toBuilder()
                            .jsonMapper(
                                object : JsonMapper(mapper) {
                                    override fun writeValueAsString(value: Any): String {
                                        if (
                                            serialize &&
                                                value is RealtimeTranslationClientEvent &&
                                                value.isSessionClose()
                                        ) {
                                            began.countDown()
                                            check(closed.await(9, TimeUnit.SECONDS))
                                        }
                                        return super.writeValueAsString(value)
                                    }
                                }
                            )
                            .build()
                    TranslationConnection.connect(configuration).use { connection ->
                        val finish = connection.finishAsync(Duration.ofSeconds(1))
                        assertThat(began.await(3, TimeUnit.SECONDS)).isTrue()
                        assertThatThrownBy { finish.get(4, TimeUnit.SECONDS) }
                            .isInstanceOf(ExecutionException::class.java)
                            .hasCauseInstanceOf(TimeoutException::class.java)
                        assertThat(closed.await(3, TimeUnit.SECONDS)).isTrue()
                        assertThat(peer.terminated.await(3, TimeUnit.SECONDS)).isTrue()
                        assertThat(peer.messages).isEmpty()
                        assertThat(server.requestCount).isEqualTo(1)
                    }
                }
            }
        }
    }

    @JsonDeserialize(using = BrokenTranslationDeserializer::class)
    private interface BrokenTranslationMixin

    private class BrokenTranslationDeserializer :
        JsonDeserializer<RealtimeTranslationServerEvent>() {
        override fun deserialize(
            parser: JsonParser,
            context: DeserializationContext,
        ): RealtimeTranslationServerEvent {
            throw AssertionError("synthetic Translation deserializer error")
        }
    }

    @Test
    fun deserializerErrorCompletesReadEvenIfTransportContainsListenerThrowables() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http.connectWebSocket(
                                request,
                                options,
                                maxMessageBytes,
                                object : WebSocketClient.Listener by listener {
                                    override fun onMessage(text: String) {
                                        // Transports may contain listener failures to protect their
                                        // reader.
                                        try {
                                            listener.onMessage(text)
                                        } catch (_: Throwable) {}
                                    }
                                },
                            )
                    }
                val customMapper = mapper.copy()
                customMapper.addMixIn(
                    RealtimeTranslationServerEvent::class.java,
                    BrokenTranslationMixin::class.java,
                )
                val configuration =
                    options(server, client).toBuilder().jsonMapper(customMapper).build()
                TranslationConnection.connect(configuration).use { connection ->
                    val read = connection.receiveAsync()
                    peer.socket
                        .get(5, TimeUnit.SECONDS)
                        .send(
                            """{"type":"session.output_transcript.delta","event_id":"text","delta":"Hola"}"""
                        )
                    assertThatThrownBy { read.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(ExecutionException::class.java)
                        .hasCauseInstanceOf(AssertionError::class.java)
                        .cause()
                        .hasMessage("synthetic Translation deserializer error")
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun blockingReconnectFromSingleThreadAsyncCallbackCreatesOneFreshSocket() {
        MockWebServer().use { server ->
            val executor = Executors.newSingleThreadExecutor()
            try {
                val initial = Peer()
                val fresh = Peer()
                server.enqueue(MockResponse().withWebSocketUpgrade(initial))
                server.enqueue(MockResponse().withWebSocketUpgrade(fresh))
                OkHttpClient.builder().build().use { http ->
                    val configuration =
                        options(server, http).toBuilder().streamHandlerExecutor(executor).build()
                    TranslationConnection.connect(configuration).use { connection ->
                        connection.send(audio())
                        assertThat(initial.next().path("audio").asText()).isEqualTo("AAAA")
                        val recovered =
                            connection.receiveAsync().thenApply {
                                assertThat(it.asSessionOutputTranscriptDelta().delta())
                                    .isEqualTo("Hola")
                                connection.reconnect().use { next ->
                                    assertThat(fresh.messages).isEmpty()
                                    next.send(audio("AQID"))
                                    fresh.next().path("audio").asText()
                                }
                            }
                        initial.socket
                            .get(5, TimeUnit.SECONDS)
                            .send(
                                """{"type":"session.output_transcript.delta","event_id":"text","delta":"Hola"}"""
                            )
                        assertThat(recovered.get(5, TimeUnit.SECONDS)).isEqualTo("AQID")
                        assertThat(initial.terminated.await(3, TimeUnit.SECONDS)).isTrue()
                        assertThat(fresh.terminated.await(3, TimeUnit.SECONDS)).isTrue()
                        assertThat(server.requestCount).isEqualTo(2)
                    }
                }
            } finally {
                executor.shutdownNow().forEach { it.run() }
                executor.awaitTermination(5, TimeUnit.SECONDS)
            }
        }
    }

    @Test
    fun admittedTerminalWinsWhenItsCleanupClosesTransportBeforeFinishWrite() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val client =
                    wrapping(http) { native, text ->
                        // The peer ends the session after finish selected this active socket.
                        finalEvents(peer.socket.get(5, TimeUnit.SECONDS))
                        check(peer.terminated.await(5, TimeUnit.SECONDS))
                        native.send(text)
                    }
                TranslationConnection.connect(options(server, client)).use { connection ->
                    assertThat(connection.finishAsync(deadline).get(7, TimeUnit.SECONDS).eventId())
                        .isEqualTo("done")
                    assertThat(connection.receive().asSessionOutputTranscriptDelta().delta())
                        .isEqualTo("Hola")
                    assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                        .isEqualTo("AQID")
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("done")
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun terminalAlreadyReceivedAndReleasedNeedsNoCloseSerialization() {
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http)
                        .toBuilder()
                        .jsonMapper(
                            object : JsonMapper(mapper) {
                                override fun writeValueAsString(value: Any): String {
                                    if (
                                        value is RealtimeTranslationClientEvent &&
                                            value.isSessionClose()
                                    )
                                        throw AssertionError(
                                            "close serializer must not run after peer ended"
                                        )
                                    return super.writeValueAsString(value)
                                }
                            }
                        )
                        .build()
                TranslationConnection.connect(configuration).use { connection ->
                    connection.send(audio("AA=="))
                    assertThat(peer.next().path("audio").asText()).isEqualTo("AA==")
                    finalEvents(peer.socket.get(5, TimeUnit.SECONDS))
                    assertThat(connection.receive().asSessionOutputTranscriptDelta().delta())
                        .isEqualTo("Hola")
                    assertThat(connection.receive().asSessionOutputAudioDelta().delta())
                        .isEqualTo("AQID")
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("done")
                    assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(connection.finishAsync(deadline).get(7, TimeUnit.SECONDS).eventId())
                        .isEqualTo("done")
                    assertThat(peer.messages).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @JsonDeserialize(using = TerminalTranslationDeserializer::class)
    private interface TerminalTranslationMixin

    private class TerminalTranslationDeserializer :
        JsonDeserializer<RealtimeTranslationServerEvent>() {
        override fun deserialize(
            parser: JsonParser,
            context: DeserializationContext,
        ): RealtimeTranslationServerEvent {
            parser.skipChildren()
            return RealtimeTranslationServerEvent.ofSessionClosed(
                RealtimeTranslationSessionClosedEvent.builder().eventId("mapped").build()
            )
        }
    }

    @Test
    fun customReaderCannotMakeErrorOrFutureWireTypeSatisfyFinish() {
        for (wireType in listOf("error", "future.session.closed")) {
            MockWebServer().use { server ->
                val peer = Peer { socket ->
                    socket.send("""{"type":"$wireType","event_id":"e"}""")
                    socket.close(1000, "EOF without wire terminal")
                }
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val customMapper = mapper.copy()
                    customMapper.addMixIn(
                        RealtimeTranslationServerEvent::class.java,
                        TerminalTranslationMixin::class.java,
                    )
                    val configuration =
                        options(server, http).toBuilder().jsonMapper(customMapper).build()
                    TranslationConnection.connect(configuration).use { connection ->
                        assertThatThrownBy {
                                connection.finishAsync(deadline).get(7, TimeUnit.SECONDS)
                            }
                            .isInstanceOf(ExecutionException::class.java)
                            .hasCauseInstanceOf(IOException::class.java)
                        // Expose what the configured reader returned without making it the
                        // transport's successful terminal unless that type was actually on wire.
                        assertThat(connection.receive().asSessionClosed().eventId())
                            .isEqualTo("mapped")
                        assertThat(peer.next().path("type").asText()).isEqualTo(close)
                        assertThat(peer.messages).isEmpty()
                        assertThat(server.requestCount).isEqualTo(1)
                    }
                }
            }
        }
    }

    @Test
    fun customReaderCannotSupplyRequiredTerminalDataMissingOnTheWire() {
        for (raw in
            listOf(
                """{"type":"session.closed"}""",
                """{"type":"session.closed","event_id":42}""",
            )) {
            MockWebServer().use { server ->
                val peer = Peer { socket -> socket.send(raw) }
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                OkHttpClient.builder().build().use { http ->
                    val customMapper = mapper.copy()
                    customMapper.addMixIn(
                        RealtimeTranslationServerEvent::class.java,
                        TerminalTranslationMixin::class.java,
                    )
                    val configuration =
                        options(server, http).toBuilder().jsonMapper(customMapper).build()
                    TranslationConnection.connect(configuration).use { connection ->
                        assertThatThrownBy {
                                connection.finishAsync(deadline).get(7, TimeUnit.SECONDS)
                            }
                            .isInstanceOf(ExecutionException::class.java)
                            .hasCauseInstanceOf(OpenAIInvalidDataException::class.java)
                        assertThat(peer.next().path("type").asText()).isEqualTo(close)
                        assertThat(peer.terminated.await(5, TimeUnit.SECONDS)).isTrue()
                        assertThat(peer.messages).isEmpty()
                    }
                }
            }
        }
        // For an actually valid terminal, the configured public mapping is still retained.
        MockWebServer().use { server ->
            val peer = Peer { socket ->
                socket.send("""{"type":"session.closed","event_id":"on-wire"}""")
            }
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val customMapper = mapper.copy()
                customMapper.addMixIn(
                    RealtimeTranslationServerEvent::class.java,
                    TerminalTranslationMixin::class.java,
                )
                val configuration =
                    options(server, http).toBuilder().jsonMapper(customMapper).build()
                TranslationConnection.connect(configuration).use { connection ->
                    assertThat(connection.finishAsync(deadline).get(7, TimeUnit.SECONDS).eventId())
                        .isEqualTo("mapped")
                    assertThat(connection.receive().asSessionClosed().eventId()).isEqualTo("mapped")
                    assertThat(peer.next().path("type").asText()).isEqualTo(close)
                    assertThat(peer.messages).isEmpty()
                }
            }
        }
    }

    @Test
    fun blockedCleanupsOfOtherSocketsDoNotHoldAnIndependentFinishDeadline() {
        MockWebServer().use { server ->
            val blocked = listOf(Peer(), Peer())
            val independent = Peer()
            for (peer in blocked + independent) server.enqueue(
                MockResponse().withWebSocketUpgrade(peer)
            )
            val entered = CountDownLatch(blocked.size)
            val release = CountDownLatch(1)
            OkHttpClient.builder().build().use { http ->
                val client =
                    object : HttpClient by http, WebSocketClient {
                        override fun connectWebSocket(
                            request: HttpRequest,
                            options: RequestOptions,
                            maxMessageBytes: Int,
                            listener: WebSocketClient.Listener,
                        ): CompletableFuture<WebSocketClient.Connection> =
                            http
                                .connectWebSocket(request, options, maxMessageBytes, listener)
                                .thenApply { native ->
                                    object : WebSocketClient.Connection by native {
                                        override fun close() {
                                            entered.countDown()
                                            try {
                                                check(release.await(12, TimeUnit.SECONDS))
                                            } finally {
                                                native.close()
                                            }
                                        }
                                    }
                                }
                    }
                TranslationConnection.connect(options(server, client)).use { first ->
                    TranslationConnection.connect(options(server, client)).use { second ->
                        TranslationConnection.connect(options(server, http)).use { target ->
                            try {
                                first.send(audio("AA=="))
                                second.send(audio("AQ=="))
                                assertThat(blocked[0].next().path("audio").asText())
                                    .isEqualTo("AA==")
                                assertThat(blocked[1].next().path("audio").asText())
                                    .isEqualTo("AQ==")
                                for (peer in blocked) peer.socket
                                    .get(5, TimeUnit.SECONDS)
                                    .send("""{"type":"session.closed","event_id":"blocked"}""")
                                check(entered.await(5, TimeUnit.SECONDS))
                                assertThatThrownBy {
                                        target
                                            .finishAsync(Duration.ofMillis(300))
                                            .get(3, TimeUnit.SECONDS)
                                    }
                                    .isInstanceOf(ExecutionException::class.java)
                                    .hasCauseInstanceOf(TimeoutException::class.java)
                                assertThat(independent.terminated.await(5, TimeUnit.SECONDS))
                                    .isTrue()
                            } finally {
                                release.countDown()
                            }
                        }
                    }
                }
                for (peer in blocked) assertThat(peer.terminated.await(5, TimeUnit.SECONDS))
                    .isTrue()
            }
        }
    }

    @Test
    fun reconnectIsCallerOwnedAndDoesNotResendCommandsOrTouchOtherSession() {
        MockWebServer().use { server ->
            val first = Peer()
            val other = Peer()
            val fresh = Peer(::finalEvents)
            for (peer in listOf(first, other, fresh)) server.enqueue(
                MockResponse().withWebSocketUpgrade(peer)
            )
            OkHttpClient.builder().build().use { http ->
                val configuration = options(server, http)
                TranslationConnection.connect(configuration).use { original ->
                    TranslationConnection.connect(configuration).use { independent ->
                        original.send(audio("AA=="))
                        assertThat(first.next().path("audio").asText()).isEqualTo("AA==")
                        original.reconnect().use { reconnected ->
                            assertThat(first.terminated.await(7, TimeUnit.SECONDS)).isTrue()
                            assertThat(fresh.messages).isEmpty()
                            independent.send(audio("AQ=="))
                            assertThat(other.next().path("audio").asText()).isEqualTo("AQ==")
                            assertThat(reconnected.finish(deadline).eventId()).isEqualTo("done")
                            assertThat(fresh.next().path("type").asText()).isEqualTo(close)
                            assertThat(fresh.messages).isEmpty()
                            assertThat(other.messages).isEmpty()
                            assertThat(server.requestCount).isEqualTo(3)
                        }
                    }
                }
            }
        }
    }
}
