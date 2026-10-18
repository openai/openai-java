package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIIoException
import com.openai.helpers.RealtimeConnection
import com.openai.helpers.RealtimeWebSocketOptions
import com.openai.models.realtime.InputAudioBufferAppendEvent
import com.openai.models.realtime.InputAudioBufferClearEvent
import com.openai.models.realtime.RealtimeClientEvent
import java.io.IOException
import java.net.ProtocolException
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.ByteString.Companion.encodeUtf8
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
    fun failureBeforeSendRejectionRecovers() = failureDuringWrite(flush = false, rejected = true)

    @Test
    fun failureBeforeFlushRejectionRecovers() = failureDuringWrite(flush = true, rejected = true)

    @Test
    fun failureBeforeAcceptedSendRemainsTerminal() =
        failureDuringWrite(flush = false, rejected = false)

    @Test
    fun rejectedFlushInRecoveryCallbackKeepsTheRetry() =
        failureDuringWrite(flush = true, rejected = true, fromCallback = true)

    private enum class CallbackFailure {
        FLUSH_ENTRY,
        CAPACITY_WAIT,
        APPLICATION,
    }

    @Test
    fun staleCallbackFlushEntryPreservesRecovery() = staleCallback(CallbackFailure.FLUSH_ENTRY)

    @Test
    fun staleCallbackCapacityWaitPreservesRecovery() = staleCallback(CallbackFailure.CAPACITY_WAIT)

    @Test
    fun staleCallbackApplicationFailureRemainsTerminal() =
        staleCallback(CallbackFailure.APPLICATION)

    private fun staleCallback(mode: CallbackFailure) {
        val secondOpening = CompletableFuture<Unit>()
        val thirdOpening = CompletableFuture<Unit>()
        val opened = LinkedBlockingQueue<WebSocketClient.Listener>()
        val sent = LinkedBlockingQueue<String>()
        val callbackFinished = CountDownLatch(1)
        val recovered = CompletableFuture<RealtimeConnection>()
        val attempts = java.util.concurrent.atomic.AtomicInteger()
        val callbacks = java.util.concurrent.atomic.AtomicInteger()
        val applicationError = IllegalStateException("application callback failed")
        OkHttpClient.builder().build().use { http ->
            val transport =
                object : HttpClient by http, WebSocketClient {
                    override fun connectWebSocket(
                        request: HttpRequest,
                        options: RequestOptions,
                        maxMessageBytes: Int,
                        listener: WebSocketClient.Listener,
                    ): CompletableFuture<WebSocketClient.Connection> {
                        val attempt = attempts.incrementAndGet()
                        opened.add(listener)
                        val active =
                            object : WebSocketClient.WritableConnection {
                                override fun awaitWritable(timeout: Duration) {
                                    if (attempt == 2 && mode == CallbackFailure.CAPACITY_WAIT) {
                                        listener.onFailure(IOException("replacement failed"))
                                        throw java.util.concurrent.TimeoutException("capacity wait")
                                    }
                                }

                                override fun send(text: String) {
                                    sent.add(text)
                                }

                                override fun close() {}
                            }
                        return when (attempt) {
                            2 -> secondOpening.thenApply { active }
                            3 -> thirdOpening.thenApply { active }
                            else -> CompletableFuture.completedFuture(active)
                        }
                    }
                }
            val configuration =
                ClientOptions.builder()
                    .httpClient(transport)
                    .apiKey("fake-key")
                    .timeout(com.openai.core.Timeout.builder().write(Duration.ofSeconds(1)).build())
                    .build()
            val settings =
                RealtimeWebSocketOptions.builder()
                    .reconnect(true)
                    .reconnectDelayMillis(1)
                    .maxPendingBytes(1024)
                    .onReconnected {
                        if (callbacks.incrementAndGet() == 1) {
                            try {
                                val listener = opened.poll(5, TimeUnit.SECONDS)!!
                                if (mode != CallbackFailure.CAPACITY_WAIT)
                                    listener.onFailure(IOException("replacement failed"))
                                if (mode == CallbackFailure.APPLICATION) throw applicationError
                                it.flushPending()
                            } finally {
                                callbackFinished.countDown()
                            }
                        } else recovered.complete(it)
                    }
                    .build()
            RealtimeConnection.connect(configuration, settings).use { connection ->
                val waiting = connection.receiveAsync()
                opened.poll(5, TimeUnit.SECONDS)!!.onFailure(IOException("initial disconnect"))
                connection.send(command())
                secondOpening.complete(Unit)
                assertThat(callbackFinished.await(5, TimeUnit.SECONDS)).isTrue()
                thirdOpening.complete(Unit)
                if (mode == CallbackFailure.APPLICATION) {
                    assertThatThrownBy { waiting.get(5, TimeUnit.SECONDS) }
                        .hasCause(applicationError)
                    assertThat(sent).isEmpty()
                } else {
                    assertThat(recovered.get(5, TimeUnit.SECONDS)).isSameAs(connection)
                    assertThat(sent).isEmpty()
                    connection.flushPending()
                    assertThat(sent).hasSize(1)
                    opened
                        .poll(5, TimeUnit.SECONDS)!!
                        .onMessage(
                            """{"type":"input_audio_buffer.cleared","event_id":"restored"}"""
                        )
                    assertThat(
                            waiting.get(5, TimeUnit.SECONDS).asInputAudioBufferCleared().eventId()
                        )
                        .isEqualTo("restored")
                }
            }
        }
    }

    @Test
    fun callbackWriteRejectionWithoutAnotherRecoveryIsTerminal() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            server.enqueue(MockResponse().withWebSocketUpgrade(Listener()))
            val rejection = WebSocketWriteNotAttempted.Busy("application busy")
            OkHttpClient.builder().build().use { http ->
                val settings =
                    RealtimeWebSocketOptions.builder()
                        .reconnect(true)
                        .reconnectDelayMillis(1)
                        .onReconnected { throw rejection }
                        .build()
                RealtimeConnection.connect(options(server, http), settings).use { connection ->
                    val waiting = connection.receiveAsync()
                    peer.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                    assertThatThrownBy { waiting.get(5, TimeUnit.SECONDS) }.hasCause(rejection)
                }
            }
        }
    }

    private fun failureDuringWrite(
        flush: Boolean,
        rejected: Boolean,
        fromCallback: Boolean = false,
    ) {
        val opening = CompletableFuture<Unit>()
        val opened = LinkedBlockingQueue<WebSocketClient.Listener>()
        val recovered = LinkedBlockingQueue<RealtimeConnection>()
        val sent = LinkedBlockingQueue<String>()
        val rejection = WebSocketWriteNotAttempted.Closed("closed before enqueue")
        val attempts = java.util.concurrent.atomic.AtomicInteger()
        OkHttpClient.builder().build().use { http ->
            val transport =
                object : HttpClient by http, WebSocketClient {
                    override fun connectWebSocket(
                        request: HttpRequest,
                        options: RequestOptions,
                        maxMessageBytes: Int,
                        listener: WebSocketClient.Listener,
                    ): CompletableFuture<WebSocketClient.Connection> {
                        val attempt = attempts.incrementAndGet()
                        opened.add(listener)
                        val connection =
                            object : WebSocketClient.Connection {
                                override fun send(text: String) {
                                    if (attempt == if (flush) 2 else 1) {
                                        listener.onFailure(IOException("peer reset"))
                                        if (rejected) throw rejection
                                    }
                                    sent.add(text)
                                }

                                override fun close() {}
                            }
                        if (flush && attempt == 2) return opening.thenApply { connection }
                        return CompletableFuture.completedFuture(connection)
                    }
                }
            val configuration =
                ClientOptions.builder().httpClient(transport).apiKey("fake-key").build()
            val settings =
                RealtimeWebSocketOptions.builder()
                    .reconnect(true)
                    .reconnectDelayMillis(1)
                    .maxPendingBytes(1024)
                    .onReconnected {
                        if (fromCallback && attempts.get() == 2) it.flushPending()
                        else recovered.add(it)
                    }
                    .build()
            RealtimeConnection.connect(configuration, settings).use { connection ->
                val first = opened.poll(5, TimeUnit.SECONDS)!!
                val waiting = connection.receiveAsync()
                if (flush) {
                    first.onFailure(IOException("initial disconnect"))
                    assertThat(opened.poll(5, TimeUnit.SECONDS)).isNotNull()
                    connection.send(command())
                    opening.complete(Unit)
                    if (!fromCallback)
                        assertThat(recovered.poll(5, TimeUnit.SECONDS)).isSameAs(connection)
                }
                if (!rejected) {
                    connection.send(command())
                    assertThatThrownBy { waiting.get(5, TimeUnit.SECONDS) }
                        .hasRootCauseMessage("peer reset")
                    assertThat(attempts.get()).isEqualTo(1)
                    assertThat(sent).hasSize(1)
                    return
                }
                if (!fromCallback)
                    assertThatThrownBy {
                            if (flush) connection.flushPending() else connection.send(command())
                        }
                        .isSameAs(rejection)
                assertThat(recovered.poll(5, TimeUnit.SECONDS)).isSameAs(connection)
                assertThat(sent).isEmpty()
                if (flush) connection.flushPending() else connection.send(command())
                assertThat(sent).hasSize(1)
                opened
                    .poll(5, TimeUnit.SECONDS)!!
                    .onMessage("""{"type":"input_audio_buffer.cleared","event_id":"recovered"}""")
                assertThat(waiting.get(5, TimeUnit.SECONDS).asInputAudioBufferCleared().eventId())
                    .isEqualTo("recovered")
            }
        }
    }

    @Test
    fun localProtocolFailuresDoNotReconnect() {
        for (binary in listOf(false, true)) {
            MockWebServer().use { server ->
                val peer = Listener()
                server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                server.enqueue(MockResponse().setResponseCode(403))
                OkHttpClient.builder().build().use { http ->
                    val settings =
                        RealtimeWebSocketOptions.builder()
                            .reconnect(true)
                            .reconnectDelayMillis(1)
                            .maxMessageBytes(64)
                            .build()
                    RealtimeConnection.connect(options(server, http), settings).use { connection ->
                        val waiting = connection.receiveAsync()
                        val socket = peer.socket.get(5, TimeUnit.SECONDS)
                        if (binary) socket.send("binary".encodeUtf8())
                        else socket.send("x".repeat(65))
                        assertThatThrownBy { waiting.get(5, TimeUnit.SECONDS) }
                            .hasRootCauseInstanceOf(ProtocolException::class.java)
                            .hasRootCauseMessage(
                                if (binary) "Unexpected binary WebSocket message"
                                else "WebSocket message exceeds maxMessageBytes"
                            )
                        assertThat(server.requestCount).isEqualTo(1)
                    }
                }
            }
        }
    }

    @Test
    fun disabledExtensionsOnReplacementDoNotReconnectAgain() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            server.enqueue(
                MockResponse()
                    .withWebSocketUpgrade(Listener())
                    .setHeader("Sec-WebSocket-Extensions", "permessage-deflate")
            )
            server.enqueue(MockResponse().setResponseCode(403))
            OkHttpClient.builder().build().use { http ->
                val settings =
                    RealtimeWebSocketOptions.builder()
                        .reconnect(true)
                        .reconnectDelayMillis(1)
                        .build()
                RealtimeConnection.connect(options(server, http), settings).use { connection ->
                    val waiting = connection.receiveAsync()
                    peer.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                    assertThatThrownBy { waiting.get(5, TimeUnit.SECONDS) }
                        .hasRootCauseInstanceOf(ProtocolException::class.java)
                        .hasRootCauseMessage("WebSocket extensions are disabled")
                    assertThat(server.requestCount).isEqualTo(2)
                }
            }
        }
    }

    @Test
    fun failureDuringOpeningCompletesThePublicFuture() {
        val opening = CompletableFuture<WebSocketClient.Connection>()
        val listening = CompletableFuture<WebSocketClient.Listener>()
        OkHttpClient.builder().build().use { http ->
            val transport =
                object : HttpClient by http, WebSocketClient {
                    override fun connectWebSocket(
                        request: HttpRequest,
                        options: RequestOptions,
                        maxMessageBytes: Int,
                        listener: WebSocketClient.Listener,
                    ): CompletableFuture<WebSocketClient.Connection> {
                        listening.complete(listener)
                        return opening
                    }
                }
            val configuration =
                ClientOptions.builder().httpClient(transport).apiKey("fake-key").build()
            val connection = RealtimeConnection.connectAsync(configuration)
            listening.get(5, TimeUnit.SECONDS).onMessage("[]")
            assertThatThrownBy { connection.get(5, TimeUnit.SECONDS) }
                .hasRootCauseMessage("Invalid Realtime event")
        }
    }

    @Test
    fun serializationStartedDuringRecoveryStillWaitsForExplicitFlush() =
        serializationWaitsForExplicitFlush(startDuringRecovery = true)

    @Test
    fun serializationStartedBeforeRecoveryStillWaitsForExplicitFlush() =
        serializationWaitsForExplicitFlush(startDuringRecovery = false)

    private fun serializationWaitsForExplicitFlush(startDuringRecovery: Boolean) {
        MockWebServer().use { server ->
            val first = Listener()
            val second = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(first))
            server.enqueue(MockResponse().withWebSocketUpgrade(second))
            val opening = CountDownLatch(1)
            val allowOpen = CountDownLatch(1)
            val encoding = CountDownLatch(1)
            val allowEncode = CountDownLatch(1)
            val recovered = CompletableFuture<RealtimeConnection>()
            val calls = java.util.concurrent.atomic.AtomicInteger()
            val customMapper =
                jsonMapper()
                    .rebuild()
                    .addModule(
                        com.fasterxml.jackson.databind.module
                            .SimpleModule()
                            .addSerializer(
                                String::class.java,
                                object : com.fasterxml.jackson.databind.JsonSerializer<String>() {
                                    override fun serialize(
                                        value: String,
                                        generator: com.fasterxml.jackson.core.JsonGenerator,
                                        provider: com.fasterxml.jackson.databind.SerializerProvider,
                                    ) {
                                        if (value == "pending-audio") {
                                            encoding.countDown()
                                            check(allowEncode.await(5, TimeUnit.SECONDS))
                                        }
                                        generator.writeString(value)
                                    }
                                },
                            )
                    )
                    .build()
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http)
                        .toBuilder()
                        .jsonMapper(customMapper)
                        .credential(
                            com.openai.credential.BearerTokenCredential.create {
                                if (calls.incrementAndGet() == 2) {
                                    opening.countDown()
                                    check(allowOpen.await(5, TimeUnit.SECONDS))
                                }
                                "fake-recovery"
                            }
                        )
                        .build()
                val settings =
                    RealtimeWebSocketOptions.builder()
                        .reconnect(true)
                        .reconnectDelayMillis(1)
                        .maxPendingBytes(1024)
                        .onReconnected { recovered.complete(it) }
                        .build()
                RealtimeConnection.connect(configuration, settings).use { connection ->
                    val original = first.socket.get(5, TimeUnit.SECONDS)
                    if (startDuringRecovery) {
                        original.close(1012, "restart")
                        assertThat(opening.await(5, TimeUnit.SECONDS)).isTrue()
                    }
                    val sent =
                        CompletableFuture.runAsync {
                            connection.send(
                                RealtimeClientEvent.ofInputAudioBufferAppend(
                                    InputAudioBufferAppendEvent.builder()
                                        .audio("pending-audio")
                                        .build()
                                )
                            )
                        }
                    try {
                        assertThat(encoding.await(5, TimeUnit.SECONDS)).isTrue()
                        if (!startDuringRecovery) {
                            original.close(1012, "restart")
                            assertThat(opening.await(5, TimeUnit.SECONDS)).isTrue()
                        }
                        allowOpen.countDown()
                        recovered.get(5, TimeUnit.SECONDS)
                        allowEncode.countDown()
                        sent.get(5, TimeUnit.SECONDS)
                        assertThat(second.messages).isEmpty()
                        connection.flushPending()
                        assertThat(second.messages.poll(5, TimeUnit.SECONDS))
                            .contains("pending-audio")
                    } finally {
                        allowOpen.countDown()
                        allowEncode.countDown()
                    }
                }
            }
        }
    }

    @Test
    fun recoveryRejectsInheritedSessionSelectorsBeforeOpening() {
        MockWebServer().use { server ->
            OkHttpClient.builder().build().use { http ->
                for (query in
                    listOf("call_id=existing", "intent=transcription", "%63all_id=existing")) {
                    val configuration =
                        options(server, http)
                            .toBuilder()
                            .baseUrl(server.url("/v1?$query").toString())
                            .build()
                    assertThatThrownBy {
                            RealtimeConnection.connect(
                                configuration,
                                RealtimeWebSocketOptions.builder().reconnect(true).build(),
                            )
                        }
                        .hasMessageContaining("requires a model session")
                }
                assertThat(server.requestCount).isZero()
            }
        }
    }

    @Test
    fun blockingRecoveryCallbackDoesNotBlockLaterRecovery() {
        val executor = Executors.newSingleThreadExecutor()
        try {
            MockWebServer().use { server ->
                val first = Listener()
                val second = Listener()
                val third = Listener()
                server.enqueue(MockResponse().withWebSocketUpgrade(first))
                server.enqueue(MockResponse().withWebSocketUpgrade(second))
                server.enqueue(MockResponse().withWebSocketUpgrade(third))
                val callbackStarted = CountDownLatch(1)
                val received = CompletableFuture<String>()
                OkHttpClient.builder().build().use { http ->
                    val settings =
                        RealtimeWebSocketOptions.builder()
                            .reconnect(true)
                            .reconnectDelayMillis(1)
                            .onReconnected {
                                if (!received.isDone) {
                                    callbackStarted.countDown()
                                    received.complete(
                                        it.receive().asInputAudioBufferCleared().eventId()
                                    )
                                }
                            }
                            .build()
                    val configuration =
                        options(server, http).toBuilder().streamHandlerExecutor(executor).build()
                    RealtimeConnection.connect(configuration, settings).use {
                        first.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                        assertThat(callbackStarted.await(5, TimeUnit.SECONDS)).isTrue()
                        second.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                        third.socket
                            .get(5, TimeUnit.SECONDS)
                            .send("""{"type":"input_audio_buffer.cleared","event_id":"restored"}""")
                        assertThat(received.get(5, TimeUnit.SECONDS)).isEqualTo("restored")
                    }
                }
            }
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun automaticRecoveryRefreshesCredentialsAndOnlyFlushesWhenAsked() {
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                val first = Listener()
                val second = Listener()
                server.enqueue(MockResponse().withWebSocketUpgrade(first))
                server.enqueue(MockResponse().withWebSocketUpgrade(second))
                val refreshing = CountDownLatch(1)
                val allowRefresh = CountDownLatch(1)
                val calls = java.util.concurrent.atomic.AtomicInteger()
                val recovered = CompletableFuture<RealtimeConnection>()
                val writeTimeout = Duration.ofSeconds(3)
                val observedTimeouts = mutableListOf<Duration>()
                OkHttpClient.builder().build().use { http ->
                    val observedHttp =
                        object : HttpClient by http, WebSocketClient {
                            override fun connectWebSocket(
                                request: HttpRequest,
                                options: RequestOptions,
                                maxMessageBytes: Int,
                                listener: WebSocketClient.Listener,
                            ): CompletableFuture<WebSocketClient.Connection> =
                                http
                                    .connectWebSocket(request, options, maxMessageBytes, listener)
                                    .thenApply { active ->
                                        val writable = active as WebSocketClient.WritableConnection
                                        object : WebSocketClient.WritableConnection by writable {
                                            override fun awaitWritable(timeout: Duration) {
                                                observedTimeouts.add(timeout)
                                                writable.awaitWritable(timeout)
                                            }
                                        }
                                    }
                        }
                    val configuration =
                        options(server, observedHttp)
                            .toBuilder()
                            .timeout(com.openai.core.Timeout.builder().write(writeTimeout).build())
                            .credential(
                                com.openai.credential.BearerTokenCredential.create {
                                    val attempt = calls.incrementAndGet()
                                    if (attempt == 2) {
                                        refreshing.countDown()
                                        check(allowRefresh.await(5, TimeUnit.SECONDS))
                                    }
                                    "fake-recovery-$attempt"
                                }
                            )
                            .build()
                    val settings =
                        RealtimeWebSocketOptions.builder()
                            .reconnect(true)
                            .maxReconnectAttempts(1)
                            .reconnectDelayMillis(1)
                            .maxPendingBytes(100)
                            .onReconnected { recovered.complete(it) }
                            .build()
                    val requestOptions =
                        RequestOptions.builder()
                            .timeout(
                                com.openai.core.Timeout.builder()
                                    .connect(Duration.ofSeconds(2))
                                    .build()
                            )
                            .build()
                    val connection =
                        if (async)
                            RealtimeConnection.connectAsync(configuration, settings, requestOptions)
                                .get(5, TimeUnit.SECONDS)
                        else RealtimeConnection.connect(configuration, settings, requestOptions)
                    connection.use {
                        it.send(command())
                        assertThat(first.messages.poll(5, TimeUnit.SECONDS))
                            .contains("input_audio_buffer.clear")
                        val nextEvent = it.receiveAsync()
                        first.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                        assertThat(refreshing.await(5, TimeUnit.SECONDS)).isTrue()
                        it.send(command())
                        it.send(
                            RealtimeClientEvent.ofInputAudioBufferClear(
                                InputAudioBufferClearEvent.builder().eventId("second").build()
                            )
                        )
                        allowRefresh.countDown()
                        assertThat(recovered.get(5, TimeUnit.SECONDS)).isSameAs(it)
                        assertThat(second.messages).isEmpty()
                        it.flushPending()
                        assertThat(observedTimeouts).containsExactly(writeTimeout, writeTimeout)
                        assertThat(second.messages.poll(5, TimeUnit.SECONDS))
                            .contains("input_audio_buffer.clear")
                        assertThat(second.messages.poll(5, TimeUnit.SECONDS)).contains("second")
                        assertThat(it.takePending()).isEmpty()
                        second.socket
                            .get(5, TimeUnit.SECONDS)
                            .send("""{"type":"input_audio_buffer.cleared","event_id":"fresh"}""")
                        assertThat(
                                nextEvent
                                    .get(5, TimeUnit.SECONDS)
                                    .asInputAudioBufferCleared()
                                    .eventId()
                            )
                            .isEqualTo("fresh")
                        val exhausted = it.receiveAsync()
                        second.socket.get().close(1012, "again")
                        assertThatThrownBy { exhausted.get(5, TimeUnit.SECONDS) }
                            .hasRootCauseMessage("GA Realtime WebSocket closed (code 1012)")
                    }
                    assertThat(calls.get()).isEqualTo(2)
                    assertThat(server.takeRequest(5, TimeUnit.SECONDS)!!.getHeader("Authorization"))
                        .isEqualTo("Bearer fake-recovery-1")
                    assertThat(server.takeRequest(5, TimeUnit.SECONDS)!!.getHeader("Authorization"))
                        .isEqualTo("Bearer fake-recovery-2")
                    assertThat(server.requestCount).isEqualTo(2)
                }
            }
        }
    }

    @Test
    fun recoveryCanBeCanceledWhileRefreshingAndDoesNotAdmitUnboundedPendingWork() {
        MockWebServer().use { server ->
            val first = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(first))
            val refreshing = CountDownLatch(1)
            val allowRefresh = CountDownLatch(1)
            val calls = java.util.concurrent.atomic.AtomicInteger()
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http)
                        .toBuilder()
                        .credential(
                            com.openai.credential.BearerTokenCredential.create {
                                if (calls.incrementAndGet() > 1) {
                                    refreshing.countDown()
                                    check(allowRefresh.await(5, TimeUnit.SECONDS))
                                }
                                "fake-recovery"
                            }
                        )
                        .build()
                val settings =
                    RealtimeWebSocketOptions.builder()
                        .reconnect(true)
                        .reconnectDelayMillis(1)
                        .build()
                RealtimeConnection.connect(configuration, settings).use { connection ->
                    val nextEvent = connection.receiveAsync()
                    first.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                    assertThat(refreshing.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThatThrownBy { connection.send(command()) }
                        .hasMessageContaining("queue is full")
                    connection.close()
                    allowRefresh.countDown()
                    assertThatThrownBy { nextEvent.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                    assertThat(connection.takePending()).isEmpty()
                    assertThat(server.requestCount).isEqualTo(1)
                }
            }
        }
    }

    @Test
    fun closingOwnerDuringBackoffSettlesTheLogicalConnection() {
        val openedListener = CompletableFuture<WebSocketClient.Listener>()
        val opens = java.util.concurrent.atomic.AtomicInteger()
        val retired = java.util.concurrent.atomic.AtomicInteger()
        OkHttpClient.builder().build().use { http ->
            val transport =
                object : HttpClient by http, WebSocketClient {
                    override fun connectWebSocket(
                        request: HttpRequest,
                        options: RequestOptions,
                        maxMessageBytes: Int,
                        listener: WebSocketClient.Listener,
                    ): CompletableFuture<WebSocketClient.Connection> {
                        opens.incrementAndGet()
                        openedListener.complete(listener)
                        return CompletableFuture.completedFuture(
                            object : WebSocketClient.Connection {
                                override fun send(text: String) = error("no command expected")

                                override fun close() {
                                    retired.incrementAndGet()
                                }
                            }
                        )
                    }
                }
            val configuration =
                ClientOptions.builder().httpClient(transport).apiKey("fake-key").build()
            val settings =
                RealtimeWebSocketOptions.builder()
                    .reconnect(true)
                    .reconnectDelayMillis(8000)
                    .build()
            RealtimeConnection.connect(configuration, settings).use { connection ->
                val pending = connection.receiveAsync()
                openedListener
                    .get(5, TimeUnit.SECONDS)
                    .onFailure(IOException("temporary disconnect"))
                assertThat(retired.get()).isEqualTo(1)
                configuration.close()
                assertThatThrownBy { pending.get(2, TimeUnit.SECONDS) }
                    .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                    .hasMessage("Client is closed")
                assertThatThrownBy {
                        RealtimeConnection.connectAsync(configuration, settings)
                            .get(2, TimeUnit.SECONDS)
                    }
                    .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                    .hasMessage("Client is closed")
                assertThat(opens.get()).isEqualTo(1)
            }
        }
    }

    @Test
    fun wrappedCredentialTransportIoRetries() =
        credentialRefreshFailure(
            CompletionException(
                OpenAIIoException("token exchange failed", IOException("transient read"))
            ),
            retryable = true,
        )

    @Test
    fun credentialRefreshExclusionsRemainTerminal() {
        for (error in
            listOf(
                OpenAIIoException(
                    "token exchange failed",
                    javax.net.ssl.SSLException("TLS failure"),
                ),
                OpenAIIoException("token exchange failed", ProtocolException("protocol failure")),
                OpenAIIoException(
                    "token exchange failed",
                    java.util.concurrent.CancellationException("credential canceled"),
                ),
                IllegalStateException("application failure", IOException("nested I/O")),
            )) credentialRefreshFailure(error, retryable = false)
    }

    private fun credentialRefreshFailure(error: RuntimeException, retryable: Boolean) {
        MockWebServer().use { server ->
            val first = Listener()
            val second = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(first))
            server.enqueue(MockResponse().withWebSocketUpgrade(second))
            val calls = java.util.concurrent.atomic.AtomicInteger()
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    options(server, http)
                        .toBuilder()
                        .credential(
                            com.openai.credential.BearerTokenCredential.create {
                                val call = calls.incrementAndGet()
                                if (call == 2) throw error
                                "fake-recovery-$call"
                            }
                        )
                        .build()
                val settings =
                    RealtimeWebSocketOptions.builder()
                        .reconnect(true)
                        .reconnectDelayMillis(1)
                        .build()
                RealtimeConnection.connect(configuration, settings).use { connection ->
                    val pending = connection.receiveAsync()
                    first.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                    if (retryable) {
                        second.socket
                            .get(5, TimeUnit.SECONDS)
                            .send(
                                """{"type":"input_audio_buffer.cleared","event_id":"refreshed"}"""
                            )
                        assertThat(
                                pending
                                    .get(5, TimeUnit.SECONDS)
                                    .asInputAudioBufferCleared()
                                    .eventId()
                            )
                            .isEqualTo("refreshed")
                        assertThat(
                                server.takeRequest(5, TimeUnit.SECONDS)!!.getHeader("Authorization")
                            )
                            .isEqualTo("Bearer fake-recovery-1")
                        assertThat(
                                server.takeRequest(5, TimeUnit.SECONDS)!!.getHeader("Authorization")
                            )
                            .isEqualTo("Bearer fake-recovery-3")
                    } else {
                        assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                            .hasRootCauseMessage(error.cause!!.message)
                    }
                    assertThat(calls.get()).isEqualTo(if (retryable) 3 else 2)
                    assertThat(server.requestCount).isEqualTo(if (retryable) 2 else 1)
                }
            }
        }
    }

    @Test
    fun recoveryDoesNotRetryAuthenticationRejection() {
        MockWebServer().use { server ->
            val first = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(first))
            server.enqueue(MockResponse().setResponseCode(401))
            OkHttpClient.builder().build().use { http ->
                RealtimeConnection.connect(
                        options(server, http),
                        RealtimeWebSocketOptions.builder()
                            .reconnect(true)
                            .reconnectDelayMillis(1)
                            .build(),
                    )
                    .use { connection ->
                        val pending = connection.receiveAsync()
                        first.socket.get(5, TimeUnit.SECONDS).close(1012, "restart")
                        assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                            .hasRootCauseMessage("WebSocket handshake failed (HTTP 401)")
                        assertThat(server.requestCount).isEqualTo(2)
                    }
            }
        }
    }

    @Test
    fun blockingContinuationAfterHandshakeDoesNotBlockIncomingFrames() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(
                MockResponse()
                    .setHeadersDelay(300, TimeUnit.MILLISECONDS)
                    .withWebSocketUpgrade(peer)
            )
            OkHttpClient.builder().build().use { http ->
                val configuration =
                    ClientOptions.builder()
                        .httpClient(http)
                        .apiKey("fake-realtime-key")
                        .baseUrl(server.url("/v1").toString())
                        .streamHandlerExecutor { it.run() }
                        .build()
                try {
                    val event =
                        RealtimeConnection.connectAsync(configuration).thenApply { connection ->
                            connection.use { it.receive() }
                        }
                    assertThat(
                            peer.socket
                                .get(8, TimeUnit.SECONDS)
                                .send("""{"type":"future.ready","note":"hello"}""")
                        )
                        .isTrue()
                    assertThat(event.get(8, TimeUnit.SECONDS)._json()).isPresent()
                } finally {
                    configuration.close()
                }
            }
        }
    }

    @Test
    fun blockingReadInSingleThreadAsyncCallbackReceivesFramesAndPeerFailures() {
        for (peerCloses in listOf(false, true)) {
            MockWebServer().use { server ->
                val executor = Executors.newSingleThreadExecutor()
                try {
                    val peer = Listener()
                    server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                    OkHttpClient.builder().build().use { http ->
                        val configuration =
                            options(server, http)
                                .toBuilder()
                                .streamHandlerExecutor(executor)
                                .build()
                        RealtimeConnection.connect(configuration).use { connection ->
                            val reading = CountDownLatch(1)
                            val next =
                                connection.receiveAsync().thenApply {
                                    assertThat(it._json()).isPresent()
                                    reading.countDown()
                                    connection.receive()
                                }
                            val socket = peer.socket.get(5, TimeUnit.SECONDS)
                            socket.send("""{"type":"future.first","data":"ready"}""")
                            assertThat(reading.await(5, TimeUnit.SECONDS)).isTrue()
                            if (peerCloses) {
                                socket.close(1000, "complete")
                                assertThatThrownBy { next.get(5, TimeUnit.SECONDS) }
                                    .hasRootCauseMessage("GA Realtime WebSocket closed (code 1000)")
                            } else {
                                socket.send(
                                    """{"type":"input_audio_buffer.cleared","event_id":"second"}"""
                                )
                                assertThat(
                                        next
                                            .get(5, TimeUnit.SECONDS)
                                            .asInputAudioBufferCleared()
                                            .eventId()
                                    )
                                    .isEqualTo("second")
                            }
                        }
                    }
                } finally {
                    executor.shutdownNow().forEach { it.run() }
                    executor.awaitTermination(5, TimeUnit.SECONDS)
                }
            }
        }
    }

    @Test
    fun blockingReconnectInSingleThreadCallbackCreatesOneFreshSocketAndDoesNotReplay() {
        MockWebServer().use { server ->
            val executor = Executors.newSingleThreadExecutor()
            try {
                val initial = Listener()
                val fresh = Listener()
                server.enqueue(MockResponse().withWebSocketUpgrade(initial))
                server.enqueue(MockResponse().withWebSocketUpgrade(fresh))
                OkHttpClient.builder().build().use { http ->
                    val configuration =
                        options(server, http).toBuilder().streamHandlerExecutor(executor).build()
                    RealtimeConnection.connect(configuration).use { connection ->
                        connection.send(command())
                        assertThat(
                                mapper
                                    .readTree(initial.messages.poll(5, TimeUnit.SECONDS))
                                    .path("type")
                                    .asText()
                            )
                            .isEqualTo("input_audio_buffer.clear")
                        val recovered =
                            connection.receiveAsync().thenApply {
                                assertThat(it.asInputAudioBufferCleared().eventId())
                                    .isEqualTo("first")
                                connection.reconnect().use { next ->
                                    assertThat(fresh.messages).isEmpty()
                                    next.send(command())
                                    mapper
                                        .readTree(fresh.messages.poll(5, TimeUnit.SECONDS))
                                        .path("type")
                                        .asText()
                                }
                            }
                        initial.socket
                            .get(5, TimeUnit.SECONDS)
                            .send("""{"type":"input_audio_buffer.cleared","event_id":"first"}""")
                        assertThat(recovered.get(5, TimeUnit.SECONDS))
                            .isEqualTo("input_audio_buffer.clear")
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
    fun closingSharedClientWhileHandshakeCompletionIsQueuedRejectsTheConnection() {
        MockWebServer().use { server ->
            val peer = Listener()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                val completions = LinkedBlockingQueue<Runnable>()
                val configuration =
                    ClientOptions.builder()
                        .httpClient(http)
                        .apiKey("fake-realtime-key")
                        .baseUrl(server.url("/v1").toString())
                        .streamHandlerExecutor { completions.add(it) }
                        .build()
                try {
                    val opening = RealtimeConnection.connectAsync(configuration)
                    peer.socket.get(8, TimeUnit.SECONDS)
                    val complete = completions.poll(8, TimeUnit.SECONDS)
                    assertThat(complete).isNotNull()
                    configuration.close()
                    complete!!.run()
                    assertThat(opening).isCompletedExceptionally()
                    assertThat(peer.terminated.await(8, TimeUnit.SECONDS)).isTrue()
                } finally {
                    configuration.close()
                }
            }
        }
    }

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
        for (original in
            listOf(java.io.IOException("uncertain write"), AssertionError("uncertain write"))) {
            checkUncertainWrite(original)
        }
    }

    @Test
    fun failedOpeningCompletesWithTheOriginalErrorWhenSocketCleanupThrows() {
        val original = java.io.IOException("failed while opening")
        val closing = AssertionError("synthetic close failed")
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
                    listener.onFailure(original)
                    return CompletableFuture.completedFuture(
                        object : WebSocketClient.Connection {
                            override fun send(text: String) = error("a failed socket cannot send")

                            override fun close() {
                                closes++
                                throw closing
                            }
                        }
                    )
                }
            }
        val configuration = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
        val opening = RealtimeConnection.connectAsync(configuration)
        assertThatThrownBy { opening.get(5, TimeUnit.SECONDS) }.hasCause(original)
        assertThat(original.suppressed).containsExactly(closing)
        assertThat(closes).isEqualTo(1)
        assertThat(httpClosed).isFalse()
    }

    private fun checkUncertainWrite(original: Throwable) {
        var opened = 0
        var writes = 0
        var closes = 0
        var httpClosed = false
        val closing = AssertionError("synthetic close failed")
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
                                if (opened == 1) throw original
                            }

                            override fun close() {
                                closes++
                                if (opened == 1) throw closing
                            }
                        }
                    )
                }
            }
        val configuration = ClientOptions.builder().httpClient(http).apiKey("fake-key").build()
        RealtimeConnection.connect(configuration).use { old ->
            val pending = old.receiveAsync()
            assertThatThrownBy { old.send(command()) }.isSameAs(original)
            assertThatThrownBy { pending.get(8, TimeUnit.SECONDS) }
                .hasRootCauseMessage("uncertain write")
            assertThat(original.suppressed).containsExactly(closing)
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
