package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncResponseConnection
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesClientEvent
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(30)
class ResponsesWebSocketLifecycleTest {
    private fun command(): ResponsesClientEvent =
        jsonMapper()
            .readValue(
                """{"type":"response.create","model":"gpt-4o-mini","input":"hello"}""",
                ResponsesClientEvent::class.java,
            )

    @Test
    fun `close and reconnect allow transport callbacks to finish`() {
        val reader = Executors.newSingleThreadExecutor()
        try {
            for (reconnect in listOf(false, true)) {
                val callbackFailure = AtomicReference<Throwable>()
                val transport =
                    CallbackTransport(
                        onClose = { listener ->
                            try {
                                reader.submit { listener.onClosed(1000) }.get(5, TimeUnit.SECONDS)
                            } catch (error: Exception) {
                                callbackFailure.set(error)
                                throw error
                            }
                        }
                    )
                connection(transport).use { connection ->
                    if (reconnect) connection.reconnect().get(5, TimeUnit.SECONDS)
                    else connection.close()
                    assertThat(callbackFailure.get()).isNull()
                }
                assertThat(callbackFailure.get()).isNull()
            }
        } finally {
            reader.shutdownNow()
            assertThat(reader.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
        }
    }

    @Test
    fun `send allows concurrent transport delivery`() {
        val reader = Executors.newSingleThreadExecutor()
        try {
            val transport =
                CallbackTransport(
                    onSend = { listener ->
                        reader
                            .submit {
                                listener.onMessage(
                                    """{"type":"response.future","marker":"delivered"}"""
                                )
                            }
                            .get(5, TimeUnit.SECONDS)
                    }
                )
            connection(transport).use { connection ->
                val received = connection.receive()
                connection.send(command())
                assertThat(
                        jsonMapper()
                            .valueToTree<com.fasterxml.jackson.databind.JsonNode>(
                                received.get(5, TimeUnit.SECONDS)
                            )
                            .path("marker")
                            .asText()
                    )
                    .isEqualTo("delivered")
            }
        } finally {
            reader.shutdownNow()
            assertThat(reader.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
        }
    }

    @Test
    fun `canceling a superseded reconnect does not close the replacement`() {
        val callbacks = java.util.concurrent.LinkedBlockingQueue<Runnable>()
        val sends = java.util.concurrent.atomic.AtomicInteger()
        val transport = CallbackTransport(onSend = { sends.incrementAndGet() })
        val options =
            ClientOptions.builder()
                .apiKey("fake-key")
                .httpClient(transport)
                .streamHandlerExecutor { callbacks.add(it) }
                .build()
        fun finish(future: CompletableFuture<*>) {
            while (!future.isDone) {
                val callback = callbacks.poll(5, TimeUnit.SECONDS)
                check(callback != null) { "Expected an asynchronous completion" }
                callback.run()
            }
            future.get(5, TimeUnit.SECONDS)
        }
        val opening = AsyncResponseConnection.connect(options)
        finish(opening)
        opening.get().use { connection ->
            val first = connection.reconnect()
            val replacement = connection.reconnect()
            assertThat(first.cancel(false)).isTrue()
            finish(replacement)
            connection.send(command())
            assertThat(sends.get()).isEqualTo(1)
        }
    }

    @Test
    fun `canceling a reconnect permits a later explicit retry`() {
        val callbacks = java.util.concurrent.LinkedBlockingQueue<Runnable>()
        val sends = java.util.concurrent.atomic.AtomicInteger()
        val transport = CallbackTransport(onSend = { sends.incrementAndGet() })
        val options =
            ClientOptions.builder()
                .apiKey("fake-key")
                .httpClient(transport)
                .streamHandlerExecutor { callbacks.add(it) }
                .build()
        fun finish(future: CompletableFuture<*>) {
            while (!future.isDone) {
                val callback = callbacks.poll(5, TimeUnit.SECONDS)
                check(callback != null) { "Expected an asynchronous completion" }
                callback.run()
            }
            future.get(5, TimeUnit.SECONDS)
        }
        val opening = AsyncResponseConnection.connect(options)
        finish(opening)
        opening.get().use { connection ->
            val canceled = connection.reconnect()
            assertThat(canceled.cancel(false)).isTrue()
            finish(connection.reconnect())
            connection.send(command())
            assertThat(sends.get()).isEqualTo(1)
        }
    }

    @Test
    fun `close can interrupt a transport send`() {
        val entered = CountDownLatch(1)
        val released = CountDownLatch(1)
        val writer = Executors.newSingleThreadExecutor()
        try {
            val transport =
                CallbackTransport(
                    onSend = {
                        entered.countDown()
                        check(released.await(5, TimeUnit.SECONDS))
                    },
                    onClose = { released.countDown() },
                )
            connection(transport).use { connection ->
                val sent = writer.submit { connection.send(command()) }
                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                connection.close()
                sent.get(5, TimeUnit.SECONDS)
            }
        } finally {
            released.countDown()
            writer.shutdownNow()
            assertThat(writer.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
        }
    }

    @Test
    fun `interrupted final response releases its next receive after a claimed nonterminal event`() =
        interruptFinalResponse(queued = false)

    @Test
    fun `interrupted final response leaves queued events for the next receive`() =
        interruptFinalResponse(queued = true)

    @Test
    fun `interrupted final response preserves its claimed terminal event`() =
        interruptFinalResponse(queued = true, terminal = true)

    @Test
    fun `interrupted final response cancels before any event is claimed`() =
        interruptFinalResponse(queued = false, claimed = false)

    private fun interruptFinalResponse(
        queued: Boolean,
        terminal: Boolean = false,
        claimed: Boolean = true,
    ) {
        for (lane in listOf(false, true)) {
            val callbacks = java.util.concurrent.LinkedBlockingQueue<Runnable>()
            val sent = java.util.concurrent.atomic.AtomicInteger()
            val transport =
                CallbackTransport(
                    onSend = { listener ->
                        val sequence = sent.incrementAndGet()
                        listener.onMessage(
                            if (terminal && sequence == 1)
                                """{"type":"response.completed","sequence_number":1,"stream_id":"lane","response":{"id":"resp_claimed","created_at":0,"object":"response","model":"gpt-4o-mini","output":[],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"completed"}}"""
                            else
                                """{"type":"response.future","stream_id":"lane","sequence_number":$sequence}"""
                        )
                    }
                )
            val options =
                ClientOptions.builder()
                    .apiKey("fake-key")
                    .httpClient(transport)
                    .streamHandlerExecutor { callbacks.add(it) }
                    .build()
            val opening =
                CompletableFuture.supplyAsync {
                    com.openai.core.http.ResponseConnection.connect(options)
                }
            callbacks.poll(5, TimeUnit.SECONDS)!!.run()
            opening.get(5, TimeUnit.SECONDS).use { connection ->
                val stream = if (lane) connection.lane("lane") else null
                val received = CompletableFuture<Any>()
                val interruptPreserved = java.util.concurrent.atomic.AtomicBoolean()
                val reader =
                    Thread {
                            try {
                                val response =
                                    if (stream == null) connection.finalResponse()
                                    else stream.finalResponse()
                                interruptPreserved.set(Thread.currentThread().isInterrupted)
                                received.complete(response)
                            } catch (error: Throwable) {
                                interruptPreserved.set(Thread.currentThread().isInterrupted)
                                received.complete(error)
                            }
                        }
                        .apply { isDaemon = true }
                reader.start()
                try {
                    val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                    while (reader.state != Thread.State.WAITING && System.nanoTime() < deadline) {
                        Thread.sleep(1)
                    }
                    assertThat(reader.state).isEqualTo(Thread.State.WAITING)
                    val delivery =
                        if (claimed) {
                            connection.send(command())
                            callbacks.poll(5, TimeUnit.SECONDS)!!
                        } else null
                    if (queued) connection.send(command())
                    reader.interrupt()
                    if (delivery != null) {
                        val interruptDeadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                        while (
                            (reader.isInterrupted ||
                                reader.state !in
                                    listOf(Thread.State.WAITING, Thread.State.TIMED_WAITING)) &&
                                System.nanoTime() < interruptDeadline
                        ) {
                            Thread.sleep(1)
                        }
                        assertThat(reader.isInterrupted).isFalse()
                        assertThat(reader.state)
                            .isIn(Thread.State.WAITING, Thread.State.TIMED_WAITING)
                        delivery.run()
                        callbacks.poll(5, TimeUnit.SECONDS)!!.run()
                    }
                    val result = received.get(5, TimeUnit.SECONDS)
                    if (terminal) {
                        assertThat((result as com.openai.models.responses.Response).id())
                            .isEqualTo("resp_claimed")
                    } else {
                        assertThat(result)
                            .isInstanceOf(com.openai.errors.OpenAIIoException::class.java)
                        assertThat((result as Throwable).cause)
                            .isInstanceOf(InterruptedException::class.java)
                    }
                    reader.join(5000)
                    assertThat(reader.isAlive).isFalse()
                    assertThat(interruptPreserved).isTrue()
                    // The helper must leave the next event available, even if it was already
                    // queued.
                    if (!queued) connection.send(command())
                    val next = if (stream == null) connection.receive() else stream.receive()
                    assertThat(
                            jsonMapper()
                                .valueToTree<com.fasterxml.jackson.databind.JsonNode>(next)
                                .path("sequence_number")
                                .asInt()
                        )
                        .isEqualTo(if (claimed) 2 else 1)
                } finally {
                    connection.close()
                    reader.interrupt()
                    while (callbacks.isNotEmpty()) callbacks.poll()?.run()
                    reader.join(5000)
                }
            }
        }
    }

    @Test
    fun `queue byte accounting preserves replacement of unpaired UTF16 surrogates`() {
        for (payload in listOf("\uD800", "\uDC00", "\uD800a", "\uD800\uD800\uDC00")) {
            val text = """{"type":"response.future_event","payload":"$payload"}"""
            val size = text.toByteArray(Charsets.UTF_8).size.toLong()
            for (limit in listOf(size, size - 1)) {
                val transport = CallbackTransport(onSend = { it.onMessage(text) })
                AsyncResponseConnection.connect(
                        ClientOptions.builder().apiKey("fake-key").httpClient(transport).build(),
                        com.openai.core.http.ResponseWebSocketOptions.builder()
                            .maxQueuedBytes(limit)
                            .build(),
                    )
                    .get(5, TimeUnit.SECONDS)
                    .use { connection ->
                        val pending = connection.receive()
                        connection.send(command())
                        if (limit == size) {
                            assertThat(
                                    jsonMapper()
                                        .valueToTree<com.fasterxml.jackson.databind.JsonNode>(
                                            pending.get(5, TimeUnit.SECONDS)
                                        )
                                        .path("payload")
                                        .asText()
                                )
                                .isEqualTo(payload)
                        } else {
                            org.assertj.core.api.Assertions.assertThatThrownBy {
                                    pending.get(5, TimeUnit.SECONDS)
                                }
                                .hasRootCauseMessage("WebSocket event buffer is full")
                        }
                    }
            }
        }
    }

    @Test
    fun `explicit close rejects new lane registrations`() {
        connection(CallbackTransport()).use { connection ->
            connection.lane("existing").use { connection.reconnect().get(5, TimeUnit.SECONDS) }
            connection.close()
            org.assertj.core.api.Assertions.assertThatThrownBy { connection.lane("new-lane") }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessage("WebSocket is closed")
        }
    }

    @Test
    fun `delayed open completion reports peer failure or owner close`() {
        for (termination in listOf("peer failure", "transport close", "owner close")) {
            val callbacks = java.util.concurrent.LinkedBlockingQueue<Runnable>()
            lateinit var peerListener: WebSocketClient.Listener
            val transport =
                object : HttpClient, WebSocketClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse = throw AssertionError("Unexpected HTTP request")

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> =
                        throw AssertionError("Unexpected HTTP request")

                    override fun connectWebSocket(
                        request: HttpRequest,
                        options: RequestOptions,
                        maxMessageBytes: Int,
                        listener: WebSocketClient.Listener,
                    ): CompletableFuture<WebSocketClient.Connection> {
                        peerListener = listener
                        return CompletableFuture.completedFuture(
                            object : WebSocketClient.Connection {
                                override fun send(text: String) {}

                                override fun close() {}
                            }
                        )
                    }

                    override fun close() {}
                }
            val options =
                ClientOptions.builder()
                    .apiKey("fake-key")
                    .httpClient(transport)
                    .streamHandlerExecutor { callbacks.add(it) }
                    .build()
            val client = com.openai.client.OpenAIClientAsyncImpl(options)
            try {
                val opening = client.responses().connect()
                val completion = callbacks.poll(5, TimeUnit.SECONDS)
                check(completion != null) { "Expected the pending open completion" }
                assertThat(opening.isDone).isFalse()
                when (termination) {
                    "owner close" -> client.close()
                    "transport close" -> peerListener.onClosed(1000)
                    else ->
                        peerListener.onFailure(java.io.IOException("peer failed before completion"))
                }
                completion.run()
                val error =
                    org.assertj.core.api.Assertions.assertThatThrownBy {
                        opening.get(5, TimeUnit.SECONDS)
                    }
                if (termination == "owner close") {
                    error
                        .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                        .hasMessage("Client is closed")
                    // The owner state is sufficient even before the transport notifies its
                    // listener.
                    peerListener.onClosed(1000)
                } else {
                    error
                        .hasCauseInstanceOf(java.io.IOException::class.java)
                        .hasRootCauseMessage(
                            if (termination == "transport close") "WebSocket closed (code 1000)"
                            else "peer failed before completion"
                        )
                }
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `client close completes openings waiting for workload authentication`() {
        for (stallSubject in listOf(true, false)) {
            val subject = CompletableFuture<String>()
            if (!stallSubject) subject.complete("fake-subject")
            val exchange = CompletableFuture<HttpResponse>()
            val exchangeStarted = CountDownLatch(1)
            val dials = java.util.concurrent.atomic.AtomicInteger()
            val transport =
                object : HttpClient, WebSocketClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse = throw AssertionError("Unexpected blocking request")

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> {
                        exchangeStarted.countDown()
                        return exchange
                    }

                    override fun connectWebSocket(
                        request: HttpRequest,
                        options: RequestOptions,
                        maxMessageBytes: Int,
                        listener: WebSocketClient.Listener,
                    ): CompletableFuture<WebSocketClient.Connection> {
                        dials.incrementAndGet()
                        return CompletableFuture.completedFuture(
                            object : WebSocketClient.Connection {
                                override fun send(text: String) {}

                                override fun close() {}
                            }
                        )
                    }

                    override fun close() {}
                }
            val provider =
                object : com.openai.auth.SubjectTokenProvider {
                    override fun tokenType() = com.openai.auth.SubjectTokenType.JWT

                    override fun getToken(
                        httpClient: HttpClient,
                        jsonMapper: com.fasterxml.jackson.databind.json.JsonMapper,
                    ): String = throw AssertionError("Unexpected blocking authentication")

                    override fun getTokenAsync(
                        httpClient: HttpClient,
                        jsonMapper: com.fasterxml.jackson.databind.json.JsonMapper,
                    ) = subject
                }
            val options =
                ClientOptions.builder()
                    .httpClient(transport)
                    .workloadIdentity(
                        com.openai.auth.WorkloadIdentity.builder()
                            .identityProviderId("fake-provider")
                            .serviceAccountId("fake-account")
                            .provider(provider)
                            .build()
                    )
                    .build()
            val client = com.openai.client.OpenAIClientAsyncImpl(options)
            try {
                val opening = client.responses().connect()
                if (!stallSubject) assertThat(exchangeStarted.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(opening.isDone).isFalse()
                client.close()
                org.assertj.core.api.Assertions.assertThatThrownBy {
                        opening.get(5, TimeUnit.SECONDS)
                    }
                    .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                // Late authentication completion must not open a socket after owner shutdown.
                subject.complete("fake-subject")
                exchange.complete(
                    object : HttpResponse {
                        override fun statusCode() = 200

                        override fun headers() = com.openai.core.http.Headers.builder().build()

                        override fun body() =
                            """{"access_token":"fake-access","expires_in":3600,"token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token"}"""
                                .byteInputStream()

                        override fun close() {}
                    }
                )
                assertThat(dials.get()).isZero()
                org.assertj.core.api.Assertions.assertThatThrownBy {
                        client.responses().connect().get(5, TimeUnit.SECONDS)
                    }
                    .hasRootCauseMessage("Client is closed")
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `legacy Azure routing fails before authentication or transport`() {
        for (mode in
            listOf(
                com.openai.azure.AzureUrlPathMode.LEGACY,
                com.openai.azure.AzureUrlPathMode.AUTO,
            )) {
            val authentications = java.util.concurrent.atomic.AtomicInteger()
            val openings = java.util.concurrent.atomic.AtomicInteger()
            val transport = CallbackTransport(onConnect = { openings.incrementAndGet() })
            val options =
                ClientOptions.builder()
                    .baseUrl("https://example.openai.azure.com")
                    .azureUrlPathMode(mode)
                    .credential(
                        com.openai.credential.BearerTokenCredential.create(
                            java.util.function.Supplier {
                                authentications.incrementAndGet()
                                "fake-token"
                            }
                        )
                    )
                    .httpClient(transport)
                    .build()
            val client = com.openai.client.OpenAIClientAsyncImpl(options)
            try {
                org.assertj.core.api.Assertions.assertThatThrownBy {
                        client.responses().connect().get(5, TimeUnit.SECONDS)
                    }
                    .hasCauseInstanceOf(UnsupportedOperationException::class.java)
                    .hasRootCauseMessage(
                        "Responses WebSocket connections do not support legacy Azure routing; use unified Azure routing"
                    )
                assertThat(authentications.get()).isZero()
                assertThat(openings.get()).isZero()
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `unified Azure routing preserves the prepared upgrade URL`() {
        for (mode in
            listOf(
                com.openai.azure.AzureUrlPathMode.UNIFIED,
                com.openai.azure.AzureUrlPathMode.AUTO,
            )) {
            val observed = AtomicReference<HttpRequest>()
            val transport = CallbackTransport(onConnect = { observed.set(it) })
            val options =
                ClientOptions.builder()
                    .baseUrl("https://example.openai.azure.com/openai/v1")
                    .azureUrlPathMode(mode)
                    .apiKey("fake-key")
                    .httpClient(transport)
                    .build()
            val client = com.openai.client.OpenAIClientAsyncImpl(options)
            try {
                client
                    .responses()
                    .connect(
                        com.openai.core.http.ResponseWebSocketOptions.builder()
                            .putQueryParam("test", "value")
                            .build()
                    )
                    .get(5, TimeUnit.SECONDS)
                    .use {
                        assertThat(observed.get().method)
                            .isEqualTo(com.openai.core.http.HttpMethod.GET)
                        assertThat(observed.get().url())
                            .isEqualTo(
                                "https://example.openai.azure.com/openai/v1/responses?test=value"
                            )
                    }
            } finally {
                client.close()
            }
        }
    }

    private fun connection(transport: CallbackTransport): AsyncResponseConnection =
        AsyncResponseConnection.connect(
                ClientOptions.builder().apiKey("fake-key").httpClient(transport).build()
            )
            .get(5, TimeUnit.SECONDS)

    private class CallbackTransport(
        private val onSend: (WebSocketClient.Listener) -> Unit = {},
        private val onClose: (WebSocketClient.Listener) -> Unit = {},
        private val onConnect: (HttpRequest) -> Unit = {},
    ) : HttpClient, WebSocketClient {
        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            onConnect(request)
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) = onSend(listener)

                    override fun close() = onClose(listener)
                }
            )
        }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            throw AssertionError("Unexpected HTTP request")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = throw AssertionError("Unexpected HTTP request")

        override fun close() {}
    }
}
