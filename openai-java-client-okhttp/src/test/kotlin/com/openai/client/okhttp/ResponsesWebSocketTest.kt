package com.openai.client.okhttp

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.http.ResponseWebSocketOptions
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesClientEvent
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.Base64
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(30)
@org.junit.jupiter.api.parallel.Execution(org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD)
class ResponsesWebSocketTest {
    private val mapper = jsonMapper()

    private fun command(id: String? = null): ResponsesClientEvent =
        mapper.readValue(
            """{"type":"response.create","model":"gpt-4o-mini","input":"hello"${id?.let { ",\"stream_id\":\"$it\"" } ?: ""}}""",
            ResponsesClientEvent::class.java,
        )

    private fun event(type: String, id: String? = null): String =
        """{"type":"$type","sequence_number":1,"response":{"id":"resp_123","created_at":0,"object":"response","model":"gpt-4o-mini","output":[],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"${type.substringAfterLast('.')}"}${id?.let { ",\"stream_id\":\"$it\"" } ?: ""}}"""

    @Test
    fun `shared contract scenarios through blocking and async entrypoints`() {
        val scenarios =
            mapper
                .readTree(javaClass.getResourceAsStream("/responses-websocket/scenarios.json"))[
                    "scenarios"]
        for (async in listOf(false, true)) for (scenario in scenarios) {
            Peer { socket, _ ->
                    for (turn in scenario["turns"]) {
                        assertThat(mapper.readTree(readMessage(socket))).isEqualTo(turn["request"])
                        for (frame in turn["frames"]) send(
                            socket,
                            if (frame.isTextual) frame.asText() else frame.toString(),
                        )
                    }
                    if (scenario.has("close_code")) {
                        val code = scenario["close_code"].asInt()
                        val out = DataOutputStream(socket.getOutputStream())
                        out.writeByte(0x88)
                        out.writeByte(2)
                        out.writeShort(code)
                        out.flush()
                    }
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                    val asyncClient =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        val blocking = if (async) null else client.responses().connect()
                        val asynchronous =
                            if (async) asyncClient.responses().connect().get(5, TimeUnit.SECONDS)
                            else null
                        try {
                            for (turn in scenario["turns"]) {
                                val accumulator = com.openai.helpers.ResponseAccumulator.create()
                                val typed =
                                    mapper.treeToValue(
                                        turn["request"],
                                        ResponsesClientEvent::class.java,
                                    )
                                if (async) asynchronous!!.send(typed) else blocking!!.send(typed)
                                for (frame in turn["frames"]) {
                                    if (frame.isTextual) {
                                        assertThatThrownBy {
                                                if (async)
                                                    asynchronous!!
                                                        .receive()
                                                        .get(5, TimeUnit.SECONDS)
                                                else blocking!!.receive()
                                            }
                                            .isInstanceOf(Exception::class.java)
                                    } else {
                                        val received =
                                            if (async)
                                                asynchronous!!.receive().get(5, TimeUnit.SECONDS)
                                            else blocking!!.receive()
                                        assertThat(
                                                mapper
                                                    .readTree(mapper.writeValueAsString(received))
                                                    .equals(
                                                        Comparator<JsonNode> { left, right ->
                                                            if (left.isNumber && right.isNumber)
                                                                left
                                                                    .decimalValue()
                                                                    .compareTo(right.decimalValue())
                                                            else if (left == right) 0 else 1
                                                        },
                                                        frame,
                                                    )
                                            )
                                            .`as`("${scenario["id"]} async=$async")
                                            .isTrue()
                                        assertThat(accumulator.accumulate(received))
                                            .isSameAs(received)
                                        if (
                                            frame.path("type").asText() in
                                                listOf(
                                                    "response.completed",
                                                    "response.failed",
                                                    "response.incomplete",
                                                )
                                        ) {
                                            assertThat(accumulator.response().id())
                                                .isEqualTo(
                                                    frame.path("response").path("id").asText()
                                                )
                                        }
                                    }
                                }
                            }
                            if (scenario.has("close_code")) {
                                assertThatThrownBy {
                                        if (async) asynchronous!!.receive().get(5, TimeUnit.SECONDS)
                                        else blocking!!.receive()
                                    }
                                    .isInstanceOf(Exception::class.java)
                            }
                        } finally {
                            blocking?.close()
                            asynchronous?.close()
                        }
                        peer.await()
                    } finally {
                        client.close()
                        asyncClient.close()
                    }
                }
        }
    }

    @Test
    fun `typed warmup leaves the connection usable for a subsequent response`() {
        for (async in listOf(false, true)) {
            Peer { socket, _ ->
                    val warmup = mapper.readTree(readMessage(socket))
                    assertThat(warmup.path("type").asText()).isEqualTo("response.create")
                    assertThat(warmup.path("generate").isBoolean).isTrue()
                    assertThat(warmup.path("generate").booleanValue()).isFalse()
                    assertThat(warmup.has("generate")).isTrue()
                    send(socket, event("response.completed"))
                    val next = mapper.readTree(readMessage(socket))
                    assertThat(next.has("generate")).isFalse()
                    assertThat(next.path("previous_response_id").asText()).isEqualTo("resp_123")
                    send(socket, event("response.completed").replace("resp_123", "resp_followup"))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                    val asyncClient =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    val warmup =
                        ResponsesClientEvent.ofResponseCreate(
                            ResponsesClientEvent.ResponseCreate.builder()
                                .model("gpt-4o-mini")
                                .input("Seed the next request")
                                .putAdditionalProperty(
                                    "generate",
                                    com.openai.core.JsonValue.from(false),
                                )
                                .build()
                        )
                    try {
                        val blocking = if (async) null else client.responses().connect()
                        val asynchronous =
                            if (async) asyncClient.responses().connect().get(5, TimeUnit.SECONDS)
                            else null
                        try {
                            if (async) asynchronous!!.send(warmup) else blocking!!.send(warmup)
                            val first =
                                if (async) asynchronous!!.finalResponse().get(5, TimeUnit.SECONDS)
                                else blocking!!.finalResponse()
                            assertThat(first.output()).isEmpty()
                            val next =
                                ResponsesClientEvent.ofResponseCreate(
                                    ResponsesClientEvent.ResponseCreate.builder()
                                        .model("gpt-4o-mini")
                                        .input("Continue")
                                        .previousResponseId(first.id())
                                        .build()
                                )
                            if (async) asynchronous!!.send(next) else blocking!!.send(next)
                            val second =
                                if (async) asynchronous!!.finalResponse().get(5, TimeUnit.SECONDS)
                                else blocking!!.finalResponse()
                            assertThat(second.id()).isEqualTo("resp_followup")
                        } finally {
                            blocking?.close()
                            asynchronous?.close()
                        }
                        peer.await()
                    } finally {
                        client.close()
                        asyncClient.close()
                    }
                }
        }
    }

    @Test
    fun `blocking reuses socket after every terminal and protocol error`() {
        Peer { socket, headers ->
                assertThat(headers["authorization"]).isEqualTo("Bearer fake-key")
                assertThat(headers["x-test"]).isEqualTo("custom")
                assertThat(headers["cookie"]).isEqualTo("session=synthetic-session")
                assertThat(headers["request"])
                    .isEqualTo("GET /v1/responses?existing=1&test=2 HTTP/1.1")
                for (type in
                    listOf("response.completed", "response.failed", "response.incomplete")) {
                    assertThat(mapper.readTree(readMessage(socket)).path("type").asText())
                        .isEqualTo("response.create")
                    send(socket, event(type))
                }
                readMessage(socket)
                send(
                    socket,
                    """{"type":"error","error":{"type":"invalid_request_error","code":"bad_input","message":"synthetic"},"stream_id":"lane-unknown"}""",
                )
                readMessage(socket)
                send(
                    socket,
                    """{"type":"response.future_event","stream_id":"lane-unknown","future":{"enabled":true}}""",
                )
                send(socket, event("response.completed"))
                assertThat(socket.getInputStream().read()).isEqualTo(-1)
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url + "?existing=1")
                        .build()
                try {
                    client
                        .responses()
                        .connect(
                            ResponseWebSocketOptions.builder()
                                .putHeader("X-Test", "custom")
                                .putHeader("Cookie", "session=synthetic-session")
                                .putQueryParam("test", "2")
                                .build()
                        )
                        .use { connection ->
                            for (type in
                                listOf(
                                    "response.completed",
                                    "response.failed",
                                    "response.incomplete",
                                )) {
                                connection.send(command())
                                assertThat(
                                        mapper
                                            .valueToTree<JsonNode>(connection.receive())
                                            .path("type")
                                            .asText()
                                    )
                                    .isEqualTo(type)
                            }
                            connection.send(command())
                            val error = mapper.valueToTree<JsonNode>(connection.receive())
                            assertThat(error.path("error").path("code").asText())
                                .isEqualTo("bad_input")
                            assertThat(error.path("stream_id").asText()).isEqualTo("lane-unknown")
                            connection.send(command())
                            val unknown = mapper.valueToTree<JsonNode>(connection.receive())
                            assertThat(unknown.path("future").path("enabled").asBoolean()).isTrue()
                            assertThat(
                                    mapper
                                        .valueToTree<JsonNode>(connection.receive())
                                        .path("type")
                                        .asText()
                                )
                                .isEqualTo("response.completed")
                        }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `async lanes and canceled waiters share one reader`() {
        val emit = CountDownLatch(1)
        Peer { socket, _ ->
                emit.await(5, TimeUnit.SECONDS)
                send(socket, event("response.created", "a"))
                send(socket, event("response.created", "b"))
                send(socket, event("response.completed", "b"))
                send(socket, event("response.completed", "a"))
                assertThat(socket.getInputStream().read()).isEqualTo(-1)
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        connection.lane("a").use { a ->
                            connection.lane("b").use { b ->
                                val canceled = a.receive()
                                assertThat(canceled.cancel(false)).isTrue()
                                val canceledHelper = a.finalResponse()
                                assertThat(canceledHelper.cancel(false)).isTrue()
                                val resultA = a.finalResponse()
                                val resultB = b.finalResponse()
                                emit.countDown()
                                assertThat(resultA.get(5, TimeUnit.SECONDS).id())
                                    .isEqualTo("resp_123")
                                assertThat(resultB.get(5, TimeUnit.SECONDS).id())
                                    .isEqualTo("resp_123")
                            }
                        }
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `closed lane IDs stay reserved before and after terminal events`() {
        for (terminal in
            listOf(null, "response.completed", "response.failed", "response.incomplete")) {
            val firstCommandReceived = CountDownLatch(1)
            Peer { socket, _ ->
                    assertThat(mapper.readTree(readMessage(socket)).path("stream_id").asText())
                        .isEqualTo("retired")
                    firstCommandReceived.countDown()
                    if (terminal != null) send(socket, event(terminal, "retired"))
                    // A parent command synchronizes emission after the local lane was closed.
                    readMessage(socket)
                    send(socket, event("response.created", "retired"))
                    send(
                        socket,
                        event("response.completed", "retired").replace("resp_123", "resp_late"),
                    )
                    send(socket, event("response.completed", "unregistered"))
                    send(socket, event("response.completed"))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                            val lane = connection.lane("retired")
                            lane.send(command())
                            if (terminal != null) lane.finalResponse().get(5, TimeUnit.SECONDS)
                            val pending = lane.receive()
                            lane.close()
                            assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                                .isInstanceOf(
                                    java.util.concurrent.CancellationException::class.java
                                )
                            assertThatThrownBy { connection.lane("retired") }
                                .isInstanceOf(IllegalStateException::class.java)
                            assertThat(firstCommandReceived.await(5, TimeUnit.SECONDS)).isTrue()
                            connection.send(command())
                            assertThat(
                                    mapper
                                        .valueToTree<JsonNode>(
                                            connection.receive().get(5, TimeUnit.SECONDS)
                                        )
                                        .path("stream_id")
                                        .asText()
                                )
                                .isEqualTo("retired")
                            assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_late")
                            assertThat(
                                    mapper
                                        .valueToTree<JsonNode>(
                                            connection.receive().get(5, TimeUnit.SECONDS)
                                        )
                                        .path("stream_id")
                                        .asText()
                                )
                                .isEqualTo("unregistered")
                            assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_123")
                        }
                        peer.await()
                    } finally {
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `closed lane reservations count toward maxLanes`() {
        Peer { socket, _ ->
                assertThat(mapper.readTree(readMessage(socket)).path("stream_id").asText())
                    .isEqualTo("b")
                send(socket, event("response.completed", "b"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client
                        .responses()
                        .connect(ResponseWebSocketOptions.builder().maxLanes(2).build())
                        .use { connection ->
                            connection.lane("a").close()
                            connection.lane("b").use { lane ->
                                assertThatThrownBy { connection.lane("c") }
                                    .isInstanceOf(IllegalStateException::class.java)
                                assertThatThrownBy { connection.lane("a") }
                                    .isInstanceOf(IllegalStateException::class.java)
                                lane.send(command())
                                assertThat(lane.finalResponse().id()).isEqualTo("resp_123")
                            }
                        }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `named lane IDs require bounded ASCII before reserving capacity`() {
        val longestId = "Az09_.-" + "x".repeat(249)
        Peer { socket, _ ->
                for (id in listOf(longestId, "a")) {
                    assertThat(mapper.readTree(readMessage(socket)).path("stream_id").asText())
                        .isEqualTo(id)
                    send(socket, event("response.completed", id))
                }
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client
                        .responses()
                        .connect(ResponseWebSocketOptions.builder().maxLanes(2).build())
                        .use { connection ->
                            for (id in
                                listOf(
                                    "",
                                    "a b",
                                    "a/b",
                                    "a\n",
                                    "é",
                                    "猫",
                                    "🙂",
                                    "a\u0000",
                                    "x".repeat(257),
                                )) {
                                assertThatThrownBy { connection.lane(id) }
                                    .isInstanceOf(IllegalArgumentException::class.java)
                            }
                            for (id in listOf(longestId, "a")) {
                                connection.lane(id).use { lane ->
                                    lane.send(command())
                                    assertThat(lane.finalResponse().id()).isEqualTo("resp_123")
                                }
                            }
                        }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `reconnect releases closed IDs and preserves open handles without replay`() {
        val attempts = java.util.concurrent.atomic.AtomicInteger()
        val uncertainReceived = CountDownLatch(1)
        val checked = CountDownLatch(1)
        Peer(2) { socket, _ ->
                val attempt = attempts.incrementAndGet()
                if (attempt == 2) {
                    socket.soTimeout = 150
                    assertThatThrownBy { socket.getInputStream().read() }
                        .isInstanceOf(java.net.SocketTimeoutException::class.java)
                    socket.soTimeout = 10000
                    checked.countDown()
                }
                assertThat(mapper.readTree(readMessage(socket)).path("stream_id").asText())
                    .isEqualTo("open")
                send(socket, event("response.completed", "open"))
                assertThat(mapper.readTree(readMessage(socket)).path("stream_id").asText())
                    .isEqualTo("retired")
                if (attempt == 1) uncertainReceived.countDown()
                else
                    send(
                        socket,
                        event("response.completed", "retired").replace("resp_123", "resp_new"),
                    )
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client
                        .responses()
                        .connect(ResponseWebSocketOptions.builder().maxLanes(3).build())
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            connection.lane("unused").close()
                            val open = connection.lane("open")
                            val retired = connection.lane("retired")
                            open.send(command())
                            open.finalResponse().get(5, TimeUnit.SECONDS)
                            val pending = open.receive()
                            retired.send(command())
                            assertThat(uncertainReceived.await(5, TimeUnit.SECONDS)).isTrue()
                            retired.close()
                            assertThatThrownBy { connection.lane("another") }
                                .isInstanceOf(IllegalStateException::class.java)
                            connection
                                .reconnect(ResponseWebSocketOptions.builder().maxLanes(2).build())
                                .get(5, TimeUnit.SECONDS)
                            assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                                .isInstanceOf(
                                    java.util.concurrent.CancellationException::class.java
                                )
                            assertThat(checked.await(5, TimeUnit.SECONDS)).isTrue()
                            val replacement = connection.lane("retired")
                            assertThatThrownBy { connection.lane("open") }
                                .isInstanceOf(IllegalStateException::class.java)
                            assertThatThrownBy { connection.lane("another") }
                                .isInstanceOf(IllegalStateException::class.java)
                            retired.close()
                            assertThatThrownBy { retired.send(command()) }
                                .isInstanceOf(IllegalStateException::class.java)
                            assertThatThrownBy { retired.receive().get(5, TimeUnit.SECONDS) }
                                .hasCauseInstanceOf(IllegalStateException::class.java)
                            open.send(command())
                            assertThat(open.finalResponse().get(5, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_123")
                            replacement.send(command())
                            assertThat(replacement.finalResponse().get(5, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_new")
                        }
                    peer.await()
                    assertThat(attempts.get()).isEqualTo(2)
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `oversized complete messages are rejected before event delivery`() {
        rejectedFrame("WebSocket message exceeds maxMessageBytes") { socket ->
            send(socket, "x".repeat(4096))
        }
    }

    @Test
    fun `fragmented message aggregate is bounded before event delivery`() {
        rejectedFrame("WebSocket message exceeds maxMessageBytes") { socket ->
            send(socket, "x".repeat(800), 1)
            send(socket, "x".repeat(800), 0x80)
        }
    }

    @Test
    fun `fragmented messages tolerate empty continuations and interleaved control frames`() {
        val terminal = event("response.completed")
        Peer { socket, _ ->
                send(socket, terminal.substring(0, 20), 0x01)
                repeat(100) { send(socket, "", 0x00) }
                send(socket, "ping", 0x89)
                send(socket, terminal.substring(20), 0x80)
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `native pongs queue individually while an application write is blocked`() {
        for (pingCount in listOf(1, 3)) {
            val drain = CountDownLatch(1)
            val pings = (0 until pingCount).map { "ping-$it" }
            Peer { socket, _ ->
                    // Wait for the native writer to start the application frame, without
                    // draining its payload. Enqueueing alone does not establish frame order.
                    val firstByte = DataInputStream(socket.getInputStream()).readUnsignedByte()
                    assertThat(firstByte).isEqualTo(0x81)
                    pings.forEach { send(socket, it, 0x89) }
                    send(socket, """{"type":"response.pings_processed"}""")
                    assertThat(drain.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(
                            mapper
                                .readTree(readMessage(socket, firstByte = firstByte))["input"]
                                .asText()
                                .length
                        )
                        .isEqualTo(8 * 1024 * 1024)
                    pings.forEach { assertThat(readMessage(socket, 0x8a)).isEqualTo(it) }
                    send(socket, event("response.completed"))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                            connection.send(
                                ResponsesClientEvent.ofResponseCreate(
                                    ResponsesClientEvent.ResponseCreate.builder()
                                        .model("gpt-4o-mini")
                                        .input("x".repeat(8 * 1024 * 1024))
                                        .build()
                                )
                            )
                            // This event follows every ping on the same reader, before the peer
                            // drains the blocked write and its separately queued pong frames.
                            connection.receive().get(5, TimeUnit.SECONDS)
                            assertThatThrownBy { connection.send(command()) }
                                .isInstanceOf(IllegalStateException::class.java)
                                .hasMessageContaining("send buffer is full")
                            drain.countDown()
                            assertThat(connection.finalResponse().get(10, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_123")
                        }
                        peer.await()
                    } finally {
                        drain.countDown()
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `per connection write timeout terminates a stalled native writer`() {
        val release = CountDownLatch(1)
        Peer { socket, _ ->
                // Complete the upgrade but do not consume any application bytes until failure.
                assertThat(release.await(10, TimeUnit.SECONDS)).isTrue()
                val bytes = ByteArray(8192)
                while (socket.getInputStream().read(bytes) != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url)
                        .timeout(
                            com.openai.core.Timeout.builder().write(java.time.Duration.ZERO).build()
                        )
                        .build()
                try {
                    client
                        .responses()
                        .connect(
                            ResponseWebSocketOptions.defaults(),
                            com.openai.core.RequestOptions.builder()
                                .timeout(
                                    com.openai.core.Timeout.builder()
                                        .write(java.time.Duration.ofMillis(250))
                                        .build()
                                )
                                .build(),
                        )
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            val pending = connection.receive()
                            connection.send(
                                ResponsesClientEvent.ofResponseCreate(
                                    ResponsesClientEvent.ResponseCreate.builder()
                                        .model("gpt-4o-mini")
                                        .input("x".repeat(8 * 1024 * 1024))
                                        .build()
                                )
                            )
                            assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                                .hasCauseInstanceOf(java.io.IOException::class.java)
                                .hasMessageContaining("WebSocket transport failed")
                            assertThatThrownBy { connection.send(command()) }
                                .isInstanceOf(IllegalStateException::class.java)
                            release.countDown()
                            peer.await()
                        }
                } finally {
                    release.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `peer close terminates a blocked writer without a write timeout`() {
        val sent = CountDownLatch(1)
        val closePeer = CountDownLatch(1)
        val drain = CountDownLatch(1)
        val reader = java.util.concurrent.atomic.AtomicReference<Thread>()
        Peer { socket, _ ->
                assertThat(sent.await(5, TimeUnit.SECONDS)).isTrue()
                send(socket, """{"type":"response.writer_blocked"}""")
                assertThat(closePeer.await(5, TimeUnit.SECONDS)).isTrue()
                DataOutputStream(socket.getOutputStream()).apply {
                    writeByte(0x88)
                    writeByte(2)
                    writeShort(1000)
                    flush()
                }
                // Do not unblock the writer until the SDK has reported the peer close.
                assertThat(drain.await(5, TimeUnit.SECONDS)).isTrue()
                val bytes = ByteArray(8192)
                while (socket.getInputStream().read(bytes) != -1) {}
            }
            .use { peer ->
                val native =
                    okhttp3.OkHttpClient.Builder()
                        .writeTimeout(0, TimeUnit.MILLISECONDS)
                        .addInterceptor { chain ->
                            reader.set(Thread.currentThread())
                            chain.proceed(chain.request())
                        }
                        .build()
                val client =
                    com.openai.client.OpenAIClientAsyncImpl(
                        com.openai.core.ClientOptions.builder()
                            .httpClient(OkHttpClient(native))
                            .baseUrl(peer.url)
                            .apiKey("fake-key")
                            .build()
                    )
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        connection.send(
                            ResponsesClientEvent.ofResponseCreate(
                                ResponsesClientEvent.ResponseCreate.builder()
                                    .model("gpt-4o-mini")
                                    .input("x".repeat(8 * 1024 * 1024))
                                    .build()
                            )
                        )
                        sent.countDown()
                        connection.receive().get(5, TimeUnit.SECONDS)
                        assertThatThrownBy { connection.send(command()) }
                            .hasMessageContaining("send buffer is full")
                        val pending = connection.receive()
                        closePeer.countDown()
                        assertThatThrownBy { pending.get(3, TimeUnit.SECONDS) }
                            .hasRootCauseMessage("WebSocket closed (code 1000)")
                        reader.get().join(3000)
                        assertThat(reader.get().isAlive).isFalse()
                        drain.countDown()
                        peer.await()
                    }
                } finally {
                    closePeer.countDown()
                    drain.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `normal peer close releases the socket before a blocking terminal listener`() {
        val start = CountDownLatch(1)
        val release = CountDownLatch(1)
        val eof = CountDownLatch(1)
        val code = CompletableFuture<Int>()
        val finished = CompletableFuture<Void>()
        val notifications = java.util.concurrent.atomic.AtomicInteger()
        Peer { socket, _ ->
                check(start.await(5, TimeUnit.SECONDS))
                DataOutputStream(socket.getOutputStream()).apply {
                    writeByte(0x88)
                    writeByte(2)
                    writeShort(1001)
                    flush()
                }
                val input = DataInputStream(socket.getInputStream())
                assertThat(input.readUnsignedByte()).isEqualTo(0x88)
                assertThat(input.readUnsignedByte()).isEqualTo(0x82)
                val mask = ByteArray(4).also(input::readFully)
                val reply =
                    ((input.readUnsignedByte() xor (mask[0].toInt() and 0xff)) shl 8) or
                        (input.readUnsignedByte() xor (mask[1].toInt() and 0xff))
                assertThat(reply).isEqualTo(1001)
                assertThat(input.read()).isEqualTo(-1)
                eof.countDown()
            }
            .use { peer ->
                OkHttpClient.builder().build().use { client ->
                    client
                        .connectWebSocket(
                            com.openai.core.http.HttpRequest.builder()
                                .method(com.openai.core.http.HttpMethod.GET)
                                .baseUrl(peer.url)
                                .addPathSegment("responses")
                                .build(),
                            com.openai.core.RequestOptions.none(),
                            Int.MAX_VALUE,
                            object : com.openai.core.http.WebSocketClient.Listener {
                                override fun onMessage(text: String) {}

                                override fun onClosed(value: Int) {
                                    notifications.incrementAndGet()
                                    code.complete(value)
                                    try {
                                        check(release.await(5, TimeUnit.SECONDS))
                                    } finally {
                                        finished.complete(null)
                                    }
                                }

                                override fun onFailure(error: Throwable) {
                                    code.completeExceptionally(error)
                                    finished.completeExceptionally(error)
                                }
                            },
                        )
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            try {
                                start.countDown()
                                assertThat(code.get(5, TimeUnit.SECONDS)).isEqualTo(1001)
                                connection.close()
                                connection.close()
                                assertThat(eof.await(1500, TimeUnit.MILLISECONDS)).isTrue()
                                assertThat(notifications.get()).isEqualTo(1)
                            } finally {
                                release.countDown()
                            }
                            finished.get(5, TimeUnit.SECONDS)
                        }
                    peer.await()
                    assertThat(notifications.get()).isEqualTo(1)
                }
            }
    }

    @Test
    fun `blocked opening timeout continuation does not delay another peer close`() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val closePeer = CountDownLatch(1)
        val peerCode = CompletableFuture<Int>()
        Peer(upgrade = { false }) { socket, _ -> while (socket.getInputStream().read() != -1) {} }
            .use { openingPeer ->
                Peer { socket, _ ->
                        socket.receiveBufferSize = 1024
                        check(closePeer.await(5, TimeUnit.SECONDS))
                        DataOutputStream(socket.getOutputStream()).apply {
                            writeByte(0x88)
                            writeByte(2)
                            writeShort(1001)
                            flush()
                        }
                        // Keep the application write blocked until its local close deadline fires.
                        peerCode.get(5, TimeUnit.SECONDS)
                    }
                    .use { peer ->
                        OkHttpClient(
                                okhttp3.OkHttpClient.Builder()
                                    .readTimeout(0, TimeUnit.MILLISECONDS)
                                    .writeTimeout(0, TimeUnit.MILLISECONDS)
                                    .build()
                            )
                            .use { client ->
                                val request =
                                    com.openai.core.http.HttpRequest.builder()
                                        .method(com.openai.core.http.HttpMethod.GET)
                                        .baseUrl(peer.url)
                                        .addPathSegment("responses")
                                        .build()
                                client
                                    .connectWebSocket(
                                        request,
                                        com.openai.core.RequestOptions.none(),
                                        Int.MAX_VALUE,
                                        object : com.openai.core.http.WebSocketClient.Listener {
                                            override fun onMessage(text: String) {}

                                            override fun onClosed(code: Int) {
                                                peerCode.complete(code)
                                            }

                                            override fun onFailure(error: Throwable) {
                                                peerCode.completeExceptionally(error)
                                            }
                                        },
                                    )
                                    .get(5, TimeUnit.SECONDS)
                                    .use { connection ->
                                        val opening =
                                            client.connectWebSocket(
                                                request
                                                    .toBuilder()
                                                    .baseUrl(openingPeer.url)
                                                    .build(),
                                                com.openai.core.RequestOptions.builder()
                                                    .timeout(
                                                        com.openai.core.Timeout.builder()
                                                            .connect(
                                                                java.time.Duration.ofMillis(250)
                                                            )
                                                            .request(java.time.Duration.ZERO)
                                                            .build()
                                                    )
                                                    .build(),
                                                Int.MAX_VALUE,
                                                object :
                                                    com.openai.core.http.WebSocketClient.Listener {
                                                    override fun onMessage(text: String) {}

                                                    override fun onClosed(code: Int) {}

                                                    override fun onFailure(error: Throwable) {}
                                                },
                                            )
                                        val continuation =
                                            opening.whenComplete { _, _ ->
                                                entered.countDown()
                                                check(release.await(10, TimeUnit.SECONDS))
                                            }
                                        try {
                                            assertThat(entered.await(3, TimeUnit.SECONDS)).isTrue()
                                            assertThatThrownBy { opening.get(1, TimeUnit.SECONDS) }
                                                .hasRootCauseMessage(
                                                    "WebSocket handshake timed out"
                                                )
                                            connection.send(
                                                """{"type":"response.create","input":"${"x".repeat(8 * 1024 * 1024)}"}"""
                                            )
                                            closePeer.countDown()
                                            assertThat(peerCode.get(2500, TimeUnit.MILLISECONDS))
                                                .isEqualTo(1001)
                                        } finally {
                                            release.countDown()
                                            closePeer.countDown()
                                        }
                                        assertThatThrownBy { continuation.get(3, TimeUnit.SECONDS) }
                                            .hasRootCauseMessage("WebSocket handshake timed out")
                                    }
                                openingPeer.await()
                                peer.await()
                            }
                    }
            }
    }

    @Test
    fun `blocked peer close listener does not delay another handshake deadline`() {
        val sent = CountDownLatch(1)
        val release = CountDownLatch(1)
        val peerCode = CompletableFuture<Int>()
        val secondAccepted = CountDownLatch(1)
        val secondClosed = CountDownLatch(1)
        Peer { socket, _ ->
                socket.receiveBufferSize = 1024
                check(sent.await(5, TimeUnit.SECONDS))
                DataOutputStream(socket.getOutputStream()).apply {
                    writeByte(0x88)
                    writeByte(2)
                    writeShort(1001)
                    flush()
                }
                // The application write cannot drain while its close listener runs.
                check(release.await(10, TimeUnit.SECONDS))
            }
            .use { first ->
                Peer(upgrade = { false }) { socket, _ ->
                        secondAccepted.countDown()
                        while (socket.getInputStream().read() != -1) {}
                        secondClosed.countDown()
                    }
                    .use { second ->
                        OkHttpClient(
                                okhttp3.OkHttpClient.Builder()
                                    .readTimeout(0, TimeUnit.MILLISECONDS)
                                    .writeTimeout(0, TimeUnit.MILLISECONDS)
                                    .build()
                            )
                            .use { client ->
                                val firstRequest =
                                    com.openai.core.http.HttpRequest.builder()
                                        .method(com.openai.core.http.HttpMethod.GET)
                                        .baseUrl(first.url)
                                        .addPathSegment("responses")
                                        .build()
                                val connection =
                                    client
                                        .connectWebSocket(
                                            firstRequest,
                                            com.openai.core.RequestOptions.none(),
                                            Int.MAX_VALUE,
                                            object : com.openai.core.http.WebSocketClient.Listener {
                                                override fun onMessage(text: String) {}

                                                override fun onClosed(code: Int) {
                                                    peerCode.complete(code)
                                                    check(release.await(10, TimeUnit.SECONDS))
                                                }

                                                override fun onFailure(error: Throwable) {
                                                    peerCode.completeExceptionally(error)
                                                }
                                            },
                                        )
                                        .get(5, TimeUnit.SECONDS)
                                try {
                                    connection.send(
                                        """{"type":"response.create","input":"${"x".repeat(8 * 1024 * 1024)}"}"""
                                    )
                                    sent.countDown()
                                    assertThat(peerCode.get(5, TimeUnit.SECONDS)).isEqualTo(1001)
                                    val opening =
                                        client.connectWebSocket(
                                            firstRequest.toBuilder().baseUrl(second.url).build(),
                                            com.openai.core.RequestOptions.builder()
                                                .timeout(
                                                    com.openai.core.Timeout.builder()
                                                        .connect(java.time.Duration.ofMillis(250))
                                                        .request(java.time.Duration.ZERO)
                                                        .build()
                                                )
                                                .build(),
                                            Int.MAX_VALUE,
                                            object : com.openai.core.http.WebSocketClient.Listener {
                                                override fun onMessage(text: String) {}

                                                override fun onClosed(code: Int) {}

                                                override fun onFailure(error: Throwable) {}
                                            },
                                        )
                                    assertThat(secondAccepted.await(2, TimeUnit.SECONDS)).isTrue()
                                    assertThatThrownBy { opening.get(2, TimeUnit.SECONDS) }
                                        .hasRootCauseMessage("WebSocket handshake timed out")
                                    assertThat(secondClosed.await(2, TimeUnit.SECONDS)).isTrue()
                                } finally {
                                    release.countDown()
                                    connection.close()
                                }
                                first.await()
                                second.await()
                            }
                    }
            }
    }

    @Test
    fun `public transport close aborts before a blocked callback returns`() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val eof = CountDownLatch(1)
        val active = java.util.concurrent.atomic.AtomicBoolean()
        val terminal = CompletableFuture<Int>()
        Peer { socket, _ ->
                send(socket, """{"type":"response.future"}""")
                while (socket.getInputStream().read() != -1) {}
                eof.countDown()
            }
            .use { peer ->
                OkHttpClient.builder().build().use { client ->
                    client
                        .connectWebSocket(
                            com.openai.core.http.HttpRequest.builder()
                                .method(com.openai.core.http.HttpMethod.GET)
                                .baseUrl(peer.url)
                                .addPathSegment("responses")
                                .build(),
                            com.openai.core.RequestOptions.none(),
                            Int.MAX_VALUE,
                            object : com.openai.core.http.WebSocketClient.Listener {
                                override fun onMessage(text: String) {
                                    active.set(true)
                                    entered.countDown()
                                    try {
                                        check(release.await(5, TimeUnit.SECONDS))
                                    } finally {
                                        active.set(false)
                                    }
                                }

                                override fun onClosed(code: Int) {
                                    if (active.get())
                                        terminal.completeExceptionally(
                                            AssertionError("Concurrent callbacks")
                                        )
                                    else terminal.complete(code)
                                }

                                override fun onFailure(error: Throwable) {
                                    terminal.completeExceptionally(error)
                                }
                            },
                        )
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            try {
                                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                                CompletableFuture.runAsync { connection.close() }
                                    .get(1, TimeUnit.SECONDS)
                                assertThat(eof.await(1, TimeUnit.SECONDS)).isTrue()
                                assertThat(terminal.isDone).isFalse()
                            } finally {
                                release.countDown()
                            }
                            assertThat(terminal.get(5, TimeUnit.SECONDS)).isEqualTo(1000)
                        }
                    peer.await()
                }
            }
    }

    @Test
    fun `public transport rejects empty commands without sending a frame`() {
        val received = CompletableFuture<String>()
        val command = mapper.writeValueAsString(command())
        Peer { socket, _ ->
                assertThat(readMessage(socket)).isEqualTo(command)
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                OkHttpClient.builder().build().use { client ->
                    client
                        .connectWebSocket(
                            com.openai.core.http.HttpRequest.builder()
                                .method(com.openai.core.http.HttpMethod.GET)
                                .baseUrl(peer.url)
                                .addPathSegment("responses")
                                .build(),
                            com.openai.core.RequestOptions.none(),
                            Int.MAX_VALUE,
                            object : com.openai.core.http.WebSocketClient.Listener {
                                override fun onMessage(text: String) {
                                    received.complete(text)
                                }

                                override fun onClosed(code: Int) {}

                                override fun onFailure(error: Throwable) {
                                    received.completeExceptionally(error)
                                }
                            },
                        )
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            assertThatThrownBy { connection.send("") }
                                .isInstanceOf(IllegalArgumentException::class.java)
                                .hasMessageContaining("empty")
                            connection.send(command)
                            assertThat(
                                    mapper
                                        .readTree(received.get(5, TimeUnit.SECONDS))["type"]
                                        .asText()
                                )
                                .isEqualTo("response.completed")
                        }
                    peer.await()
                }
            }
    }

    @Test
    fun `default connection retains more than 1024 queued events`() {
        val emitted = CountDownLatch(1)
        Peer { socket, _ ->
                repeat(2048) { index ->
                    send(socket, """{"type":"response.future","index":$index}""")
                }
                send(socket, event("response.completed"))
                // A pong proves the single reader queued every preceding event before draining.
                send(socket, "q", 0x89)
                val input = DataInputStream(socket.getInputStream())
                assertThat(input.readUnsignedByte()).isEqualTo(0x8a)
                assertThat(input.readUnsignedByte()).isEqualTo(0x81)
                val mask = ByteArray(4).also(input::readFully)
                assertThat(input.readUnsignedByte() xor (mask[0].toInt() and 0xff))
                    .isEqualTo('q'.code)
                emitted.countDown()
                assertThat(mapper.readTree(readMessage(socket)).path("type").asText())
                    .isEqualTo("response.create")
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        assertThat(emitted.await(5, TimeUnit.SECONDS)).isTrue()
                        repeat(2048) { index ->
                            val received = connection.receive().get(5, TimeUnit.SECONDS)
                            assertThat(mapper.valueToTree<JsonNode>(received).path("index").asInt())
                                .isEqualTo(index)
                        }
                        assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_123")
                        connection.send(command())
                        assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `queued pong does not consume the application write budget`() {
        val secondSent = CountDownLatch(1)
        Peer { socket, _ ->
                // Establish frame order before queuing a pong behind the blocked write.
                val firstByte = DataInputStream(socket.getInputStream()).readUnsignedByte()
                assertThat(firstByte).isEqualTo(0x81)
                send(socket, "p", 0x89)
                send(socket, """{"type":"response.ping_processed"}""")
                assertThat(secondSent.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(
                        mapper
                            .readTree(readMessage(socket, firstByte = firstByte))
                            .path("input")
                            .asText()
                            .length
                    )
                    .isEqualTo(8 * 1024 * 1024)
                val input = DataInputStream(socket.getInputStream())
                assertThat(input.readUnsignedByte()).isEqualTo(0x8a)
                assertThat(input.readUnsignedByte()).isEqualTo(0x81)
                val mask = ByteArray(4).also(input::readFully)
                assertThat(input.readUnsignedByte() xor (mask[0].toInt() and 0xff))
                    .isEqualTo('p'.code)
                send(socket, """{"type":"response.write_drained"}""")
                assertThat(mapper.readTree(readMessage(socket)).path("input").asText())
                    .isEqualTo("hello")
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        connection.send(
                            ResponsesClientEvent.ofResponseCreate(
                                ResponsesClientEvent.ResponseCreate.builder()
                                    .model("gpt-4o-mini")
                                    .input("x".repeat(8 * 1024 * 1024))
                                    .build()
                            )
                        )
                        connection.receive().get(5, TimeUnit.SECONDS)
                        assertThatThrownBy { connection.send(command()) }
                            .isInstanceOf(IllegalStateException::class.java)
                            .hasMessageContaining("send buffer is full")
                        secondSent.countDown()
                        connection.receive().get(5, TimeUnit.SECONDS)
                        connection.send(command())
                        assertThat(connection.finalResponse().get(10, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    secondSent.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `explicit close prevents later reconnects`() {
        val tokens = java.util.concurrent.atomic.AtomicInteger()
        Peer { socket, _ -> while (socket.getInputStream().read() != -1) {} }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .credential(
                            com.openai.credential.BearerTokenCredential.create {
                                "fake-${tokens.incrementAndGet()}"
                            }
                        )
                        .baseUrl(peer.url)
                        .build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        connection.close()
                        assertThatThrownBy { connection.reconnect() }
                            .isInstanceOf(IllegalStateException::class.java)
                        assertThatThrownBy {
                                connection.reconnect(ResponseWebSocketOptions.defaults())
                            }
                            .isInstanceOf(IllegalStateException::class.java)
                        assertThat(tokens.get()).isEqualTo(1)
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `peer failure still permits explicit reconnect`() {
        val attempts = java.util.concurrent.atomic.AtomicInteger()
        Peer(2) { socket, _ ->
                assertThat(mapper.readTree(readMessage(socket)).path("type").asText())
                    .isEqualTo("response.create")
                if (attempts.incrementAndGet() == 1) {
                    val output = DataOutputStream(socket.getOutputStream())
                    output.writeByte(0x88)
                    output.writeByte(2)
                    output.writeShort(1011)
                    output.flush()
                } else send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        connection.send(command())
                        assertThatThrownBy { connection.receive().get(5, TimeUnit.SECONDS) }
                            .hasCauseInstanceOf(java.io.IOException::class.java)
                        connection.reconnect().get(5, TimeUnit.SECONDS)
                        connection.send(command())
                        assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_123")
                    }
                    peer.await()
                    assertThat(attempts.get()).isEqualTo(2)
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `default connection accepts events larger than 64 MiB`() {
        Peer { socket, _ ->
                val chunk = ByteArray(1024 * 1024) { 'x'.code.toByte() }
                val prefix = "{\"type\":\"response.future_event\",\"chunks\":["
                val payloadBytes = prefix.length + 65L * (chunk.size + 3) + 1
                val out = DataOutputStream(socket.getOutputStream())
                out.writeByte(0x81)
                out.writeByte(127)
                out.writeLong(payloadBytes)
                out.writeBytes(prefix)
                repeat(65) { i ->
                    if (i > 0) out.writeByte(','.code)
                    out.writeByte('"'.code)
                    out.write(chunk)
                    out.writeByte('"'.code)
                }
                out.writeBytes("]}")
                out.flush()
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        val raw =
                            connection.receive()._json().orElseThrow {
                                AssertionError("Unknown event missing")
                            }
                        assertThat(raw.asObject().get().getValue("chunks").asArray().get())
                            .hasSize(65)
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `unterminated upgrade headers are rejected before a large body can accumulate`() {
        Peer(upgrade = { false }) { socket, _ ->
                val output = socket.getOutputStream()
                output.write("HTTP/1.1 101 Switching Protocols\r\nX-Long: ".toByteArray())
                output.write(ByteArray(256 * 1024) { 'x'.code.toByte() })
                output.flush()
                assertThat(socket.getInputStream().read()).isEqualTo(-1)
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    assertThatThrownBy { client.responses().connect().get(5, TimeUnit.SECONDS) }
                        .hasCauseInstanceOf(java.io.IOException::class.java)
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `401 upgrade invalidates the cached workload token for the next connection`() {
        rejectedWorkloadToken(refreshBefore401 = false)
    }

    @Test
    fun `late 401 upgrade preserves a refreshed workload token`() {
        rejectedWorkloadToken(refreshBefore401 = true)
    }

    private fun rejectedWorkloadToken(refreshBefore401: Boolean) {
        val exchanges = java.util.concurrent.atomic.AtomicInteger()
        val upgrades = java.util.concurrent.atomic.AtomicInteger()
        val rejectedUpgrade = if (refreshBefore401) 1 else 0
        Peer(connectionCount = rejectedUpgrade + 2, upgrade = { it != rejectedUpgrade }) {
                socket,
                headers ->
                val upgrade = upgrades.getAndIncrement()
                if (upgrade == rejectedUpgrade) {
                    assertThat(headers["authorization"]).isEqualTo("Bearer fake-access-1")
                    // The synchronous background exchange has already cached the replacement.
                    if (refreshBefore401) assertThat(exchanges.get()).isEqualTo(2)
                    socket
                        .getOutputStream()
                        .write(
                            "HTTP/1.1 401 Unauthorized\r\nConnection: close\r\nContent-Length: 0\r\n\r\n"
                                .toByteArray()
                        )
                    socket.getOutputStream().flush()
                } else {
                    assertThat(headers["authorization"])
                        .isEqualTo("Bearer fake-access-${if (upgrade == 0) 1 else 2}")
                    send(socket, event("response.completed"))
                }
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val actual = OkHttpClient.builder().build()
                val transport =
                    object : com.openai.core.http.HttpClient, com.openai.core.http.WebSocketClient {
                        override fun execute(
                            request: com.openai.core.http.HttpRequest,
                            requestOptions: com.openai.core.RequestOptions,
                        ): com.openai.core.http.HttpResponse {
                            val number = exchanges.incrementAndGet()
                            val expiry = if (refreshBefore401 && number == 1) 60 else 3600
                            return object : com.openai.core.http.HttpResponse {
                                override fun statusCode() = 200

                                override fun headers() =
                                    com.openai.core.http.Headers.builder().build()

                                override fun body() =
                                    "{\"access_token\":\"fake-access-$number\",\"expires_in\":$expiry,\"token_type\":\"Bearer\",\"issued_token_type\":\"urn:ietf:params:oauth:token-type:access_token\"}"
                                        .byteInputStream()

                                override fun close() {}
                            }
                        }

                        override fun executeAsync(
                            request: com.openai.core.http.HttpRequest,
                            requestOptions: com.openai.core.RequestOptions,
                        ) = CompletableFuture.completedFuture(execute(request, requestOptions))

                        override fun connectWebSocket(
                            request: com.openai.core.http.HttpRequest,
                            options: com.openai.core.RequestOptions,
                            maxMessageBytes: Int,
                            listener: com.openai.core.http.WebSocketClient.Listener,
                        ) = actual.connectWebSocket(request, options, maxMessageBytes, listener)

                        override fun close() = actual.close()
                    }
                val provider =
                    object : com.openai.auth.SubjectTokenProvider {
                        override fun tokenType() = com.openai.auth.SubjectTokenType.JWT

                        override fun getToken(
                            httpClient: com.openai.core.http.HttpClient,
                            jsonMapper: com.fasterxml.jackson.databind.json.JsonMapper,
                        ) = "fake-subject"

                        override fun getTokenAsync(
                            httpClient: com.openai.core.http.HttpClient,
                            jsonMapper: com.fasterxml.jackson.databind.json.JsonMapper,
                        ) = CompletableFuture.completedFuture("fake-subject")
                    }
                val options =
                    com.openai.core.ClientOptions.builder()
                        .httpClient(transport)
                        .baseUrl(peer.url)
                        .workloadIdentity(
                            com.openai.auth.WorkloadIdentity.builder()
                                .identityProviderId("fake-provider")
                                .serviceAccountId("fake-account")
                                .provider(provider)
                                .build()
                        )
                        .build()
                val client = com.openai.client.OpenAIClientImpl(options)
                try {
                    if (refreshBefore401) {
                        client.responses().connect().use {
                            assertThat(it.finalResponse().id()).isEqualTo("resp_123")
                        }
                    }
                    assertThatThrownBy { client.responses().connect() }
                        .isInstanceOf(com.openai.core.http.WebSocketHandshakeException::class.java)
                        .isInstanceOf(com.openai.errors.OpenAIException::class.java)
                        .hasMessage("WebSocket handshake failed (HTTP 401)")
                    client.responses().connect().use {
                        assertThat(it.finalResponse().id()).isEqualTo("resp_123")
                    }
                    assertThat(exchanges.get()).isEqualTo(2)
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `compressed frames are rejected when the server did not negotiate compression`() {
        rejectedFrame("Unexpected rsv1 flag") { socket -> send(socket, "compressed", 0xc1) }
    }

    private fun rejectedFrame(expectedMessage: String, write: (Socket) -> Unit) {
        val emit = CountDownLatch(1)
        Peer { socket, headers ->
                assertThat(headers["sec-websocket-extensions"]).isNull()
                assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                // Rejection can close the connection before the peer finishes sending.
                try {
                    write(socket)
                    while (socket.getInputStream().read() != -1) {}
                } catch (_: java.net.SocketException) {
                    // The receive assertion below independently verifies protocol rejection.
                }
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    val connection =
                        client
                            .responses()
                            .connect(
                                ResponseWebSocketOptions.builder().maxMessageBytes(1024).build()
                            )
                            .get(5, TimeUnit.SECONDS)
                    connection.use {
                        emit.countDown()
                        assertThatThrownBy { it.receive().get(5, TimeUnit.SECONDS) }
                            .hasCauseInstanceOf(java.io.IOException::class.java)
                            .hasRootCauseMessage(expectedMessage)
                    }
                    peer.await()
                } finally {
                    emit.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `final response rejects missing and null terminal responses while socket stays open`() {
        for (async in listOf(false, true)) {
            for (type in listOf("response.completed", "response.failed", "response.incomplete")) {
                for (includeNull in listOf(true, false)) {
                    Peer { socket, _ ->
                            readMessage(socket)
                            val terminal =
                                mapper
                                    .createObjectNode()
                                    .put("type", type)
                                    .put("sequence_number", 1)
                            if (includeNull) terminal.putNull("response")
                            send(socket, terminal.toString())
                            while (socket.getInputStream().read() != -1) {}
                        }
                        .use { peer ->
                            val client =
                                OpenAIOkHttpClient.builder()
                                    .apiKey("fake-key")
                                    .baseUrl(peer.url)
                                    .build()
                            val asyncClient =
                                OpenAIOkHttpClientAsync.builder()
                                    .apiKey("fake-key")
                                    .baseUrl(peer.url)
                                    .build()
                            try {
                                if (async) {
                                    asyncClient
                                        .responses()
                                        .connect()
                                        .get(5, TimeUnit.SECONDS)
                                        .use { connection ->
                                            connection.send(command())
                                            assertThatThrownBy {
                                                    connection
                                                        .finalResponse()
                                                        .get(5, TimeUnit.SECONDS)
                                                }
                                                .hasCauseInstanceOf(
                                                    com.openai.errors
                                                            .OpenAIInvalidDataException::class
                                                        .java
                                                )
                                        }
                                } else {
                                    client.responses().connect().use { connection ->
                                        connection.send(command())
                                        assertThatThrownBy { connection.finalResponse() }
                                            .isInstanceOf(
                                                com.openai.errors.OpenAIInvalidDataException::class
                                                    .java
                                            )
                                    }
                                }
                                peer.await()
                            } finally {
                                client.close()
                                asyncClient.close()
                            }
                        }
                }
            }
        }
    }

    @Test
    fun `malformed events and early close are observable`() {
        for (message in
            listOf(
                "not-json",
                "null",
                "[]",
                "{}",
                "{\"type\":7}",
                "",
                """{"type":"response.future_event"}garbage""",
                """{"type":"response.future_event"}{"type":"response.future_event"}""",
                event("response.completed") + "garbage",
            )) {
            val emit = CountDownLatch(1)
            Peer { socket, _ ->
                    assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                    if (message.isNotEmpty()) {
                        send(socket, message)
                        while (socket.getInputStream().read() != -1) {}
                    }
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        val connection = client.responses().connect().get(5, TimeUnit.SECONDS)
                        connection.use {
                            emit.countDown()
                            assertThatThrownBy { it.receive().get(5, TimeUnit.SECONDS) }
                                .isInstanceOf(java.util.concurrent.ExecutionException::class.java)
                        }
                        peer.await()
                    } finally {
                        emit.countDown()
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `malformed stream IDs fail pending lanes without misrouting the event`() {
        val invalidIds =
            listOf("42", "true", "[]", "{}") +
                listOf("", " ", "\t", "é", "a/b", "a".repeat(257)).map {
                    mapper.writeValueAsString(it)
                }
        for (id in invalidIds) {
            val emit = CountDownLatch(1)
            Peer { socket, _ ->
                    assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                    send(socket, event("response.completed").dropLast(1) + ""","stream_id":$id}""")
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                            val parent = connection.finalResponse()
                            val lane = connection.lane("a").receive()
                            val neighbor = connection.lane("b").receive()
                            emit.countDown()
                            for (pending in listOf(parent, lane, neighbor)) {
                                assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                                    .hasRootCauseMessage("Invalid WebSocket stream_id")
                            }
                        }
                        peer.await()
                    } finally {
                        emit.countDown()
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `valid absent and null stream IDs retain independent lane routing`() {
        val unknownId = "A0_." + "x".repeat(251) + "-"
        val emit = CountDownLatch(1)
        Peer { socket, _ ->
                assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                send(socket, event("response.completed", "b").replace("resp_123", "resp_b"))
                send(socket, event("response.completed").replace("resp_123", "resp_absent"))
                send(socket, event("response.completed", "a").replace("resp_123", "resp_a"))
                send(
                    socket,
                    event("response.completed", "null")
                        .replace("\"null\"", "null")
                        .replace("resp_123", "resp_null"),
                )
                send(
                    socket,
                    event("response.completed", unknownId).replace("resp_123", "resp_unknown"),
                )
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        val a = connection.lane("a").finalResponse()
                        val b = connection.lane("b").finalResponse()
                        emit.countDown()
                        assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_absent")
                        assertThat(a.get(5, TimeUnit.SECONDS).id()).isEqualTo("resp_a")
                        assertThat(b.get(5, TimeUnit.SECONDS).id()).isEqualTo("resp_b")
                        assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_null")
                        assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_unknown")
                    }
                    peer.await()
                } finally {
                    emit.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `slow consumer overflow fails instead of dropping events`() {
        val emit = CountDownLatch(1)
        val sent = CountDownLatch(1)
        Peer { socket, _ ->
                assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                send(socket, event("response.created"))
                send(socket, event("response.completed"))
                sent.countDown()
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    val connection =
                        client
                            .responses()
                            .connect(ResponseWebSocketOptions.builder().maxQueuedEvents(1).build())
                            .get(5, TimeUnit.SECONDS)
                    connection.use {
                        emit.countDown()
                        sent.await(5, TimeUnit.SECONDS)
                        peer.await()
                        assertThat(
                                mapper
                                    .valueToTree<JsonNode>(it.receive().get())
                                    .path("type")
                                    .asText()
                            )
                            .isEqualTo("response.created")
                        assertThatThrownBy { it.receive().get() }
                            .hasRootCauseMessage("WebSocket event buffer is full")
                    }
                } finally {
                    emit.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `Unicode message and queue byte limits retain exact UTF8 boundaries`() {
        for (payload in listOf("ascii", "é", "€", "😀", "aé€😀")) {
            val text = """{"type":"response.future_event","payload":"$payload"}"""
            val size = text.toByteArray(Charsets.UTF_8).size
            for (limit in listOf("exact", "message", "queue")) {
                val emit = CountDownLatch(1)
                Peer { socket, _ ->
                        assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                        send(socket, text)
                        while (socket.getInputStream().read() != -1) {}
                    }
                    .use { peer ->
                        val client =
                            OpenAIOkHttpClientAsync.builder()
                                .apiKey("fake-key")
                                .baseUrl(peer.url)
                                .build()
                        try {
                            val options =
                                ResponseWebSocketOptions.builder()
                                    .maxMessageBytes(if (limit == "message") size - 1 else size)
                                    .maxQueuedBytes(
                                        (if (limit == "queue") size - 1 else size).toLong()
                                    )
                                    .build()
                            client.responses().connect(options).get(5, TimeUnit.SECONDS).use {
                                connection ->
                                val pending = connection.receive()
                                emit.countDown()
                                if (limit == "exact") {
                                    assertThat(
                                            mapper
                                                .valueToTree<JsonNode>(
                                                    pending.get(5, TimeUnit.SECONDS)
                                                )
                                                .path("payload")
                                                .asText()
                                        )
                                        .isEqualTo(payload)
                                } else {
                                    assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                                        .hasRootCauseMessage(
                                            if (limit == "message")
                                                "WebSocket message exceeds maxMessageBytes"
                                            else "WebSocket event buffer is full"
                                        )
                                }
                            }
                            peer.await()
                        } finally {
                            emit.countDown()
                            client.close()
                        }
                    }
            }
        }
    }

    @Test
    fun `large supported messages remain available`() {
        val payload = List(20) { "x".repeat(1024 * 1024) }
        val frame =
            mapper.writeValueAsString(
                mapOf("type" to "response.future_event", "payload" to payload)
            )
        Peer { socket, _ ->
                send(socket, frame)
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use {
                        assertThat(mapper.valueToTree<JsonNode>(it.receive()).path("payload"))
                            .isEqualTo(mapper.valueToTree<JsonNode>(payload))
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `wire routing and validation are preserved with a custom event deserializer`() {
        val replacement =
            com.openai.models.responses.ResponsesServerEvent.ofResponseCompleted(
                mapper
                    .readValue(
                        event("response.completed"),
                        com.openai.models.responses.ResponsesServerEvent::class.java,
                    )
                    .asResponseCompleted()
            )
        val customMapper =
            mapper.copy().apply {
                addMixIn(
                    com.openai.models.responses.ResponsesServerEvent::class.java,
                    CustomEventDeserializer::class.java,
                )
                registerModule(
                    com.fasterxml.jackson.databind.module
                        .SimpleModule()
                        .addDeserializer(
                            com.openai.models.responses.ResponsesServerEvent::class.java,
                            object :
                                com.fasterxml.jackson.databind.JsonDeserializer<
                                    com.openai.models.responses.ResponsesServerEvent
                                >() {
                                override fun deserialize(
                                    parser: com.fasterxml.jackson.core.JsonParser,
                                    context: com.fasterxml.jackson.databind.DeserializationContext,
                                ): com.openai.models.responses.ResponsesServerEvent {
                                    parser.skipChildren()
                                    return replacement
                                }
                            },
                        )
                )
            }
        for (invalid in listOf(false, true)) {
            val emit = CountDownLatch(1)
            Peer { socket, _ ->
                    assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                    send(
                        socket,
                        if (invalid) """{"type":"response.future_event","stream_id":42}"""
                        else """{"type":"response.future_event","stream_id":"mapped"}""",
                    )
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClient.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .jsonMapper(customMapper)
                            .build()
                    try {
                        client.responses().connect().use { connection ->
                            connection.lane("mapped").use { lane ->
                                emit.countDown()
                                if (invalid)
                                    assertThatThrownBy { lane.receive() }
                                        .isInstanceOf(IllegalArgumentException::class.java)
                                        .hasMessage("Invalid WebSocket stream_id")
                                else
                                    assertThat(lane.receive().asResponseCompleted().response().id())
                                        .isEqualTo("resp_123")
                            }
                        }
                        peer.await()
                    } finally {
                        emit.countDown()
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `nested large events retain payload and root lane routing`() {
        val payload =
            List(20_000) {
                mapOf(
                    "type" to 42,
                    "stream_id" to "not routing metadata",
                    "nested" to listOf("a", "b", "c", "d", "e", "f", "g", "h"),
                )
            }
        val frame =
            mapper.writeValueAsString(
                mapOf(
                    "type" to "response.future_event",
                    "stream_id" to "nested",
                    "payload" to payload,
                )
            )
        val emit = CountDownLatch(1)
        Peer { socket, _ ->
                assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                send(socket, frame)
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        connection.lane("nested").use { lane ->
                            emit.countDown()
                            val received = mapper.valueToTree<JsonNode>(lane.receive())
                            assertThat(received.path("stream_id").asText()).isEqualTo("nested")
                            assertThat(received.path("payload"))
                                .isEqualTo(mapper.valueToTree<JsonNode>(payload))
                            assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                        }
                    }
                    peer.await()
                } finally {
                    emit.countDown()
                    client.close()
                }
            }
    }

    @Test
    fun `configured DNS rejection is preserved before an HTTP upgrade`() {
        okhttp3.mockwebserver.MockWebServer().use { server ->
            val transport =
                okhttp3.OkHttpClient.Builder()
                    .dns(
                        object : okhttp3.Dns {
                            override fun lookup(hostname: String): List<java.net.InetAddress> =
                                throw java.net.UnknownHostException(
                                    "Synthetic DNS policy rejects this host"
                                )
                        }
                    )
                    .build()
            val client =
                com.openai.client.OpenAIClientAsyncImpl(
                    com.openai.core.ClientOptions.builder()
                        .httpClient(OkHttpClient(transport))
                        .baseUrl(server.url("/v1").toString())
                        .apiKey("fake-key")
                        .build()
                )
            try {
                assertThatThrownBy { client.responses().connect().get(5, TimeUnit.SECONDS) }
                    .hasRootCauseMessage("Synthetic DNS policy rejects this host")
                assertThat(server.requestCount).isZero()
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `caller network interceptors are rejected before an HTTP upgrade`() {
        for (includeSdkGuard in listOf(false, true)) {
            okhttp3.mockwebserver.MockWebServer().use { server ->
                server.enqueue(okhttp3.mockwebserver.MockResponse().setResponseCode(400))
                val builder =
                    if (includeSdkGuard) OkHttpClient.builder().build().okHttpClient.newBuilder()
                    else okhttp3.OkHttpClient.Builder()
                val transport =
                    builder
                        .addNetworkInterceptor {
                            throw java.io.IOException(
                                "Synthetic network policy rejects this request"
                            )
                        }
                        .build()
                val client =
                    com.openai.client.OpenAIClientAsyncImpl(
                        com.openai.core.ClientOptions.builder()
                            .httpClient(OkHttpClient(transport))
                            .baseUrl(server.url("/v1").toString())
                            .apiKey("fake-key")
                            .build()
                    )
                try {
                    assertThatThrownBy { client.responses().connect().get(5, TimeUnit.SECONDS) }
                        .hasCauseInstanceOf(IllegalArgumentException::class.java)
                        .hasMessageContaining(
                            "WebSockets do not support OkHttp network interceptors"
                        )
                    assertThat(server.requestCount).isZero()
                } finally {
                    client.close()
                }
            }
        }
    }

    @Test
    fun `reserved extension headers fail before opening without masking the error`() {
        okhttp3.mockwebserver.MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-key")
                    .baseUrl(server.url("/v1").toString())
                    .build()
            try {
                for (name in listOf("Sec-WebSocket-Extensions", "sec-websocket-extensions")) {
                    assertThatThrownBy {
                            client
                                .responses()
                                .connect(
                                    ResponseWebSocketOptions.builder()
                                        .putHeader(name, "permessage-deflate")
                                        .build()
                                )
                                .get(5, TimeUnit.SECONDS)
                        }
                        .hasRootCauseInstanceOf(IllegalArgumentException::class.java)
                        .hasMessageContaining("Sec-WebSocket-Extensions")
                }
                assertThat(server.requestCount).isZero()
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `configured cookies and interceptors reach the upgrade`() {
        Peer { socket, headers ->
                assertThat(headers["cookie"]).isEqualTo("session=synthetic-session")
                assertThat(headers["x-intercepted"]).isEqualTo("synthetic-header")
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val transport =
                    okhttp3.OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            chain.proceed(
                                chain
                                    .request()
                                    .newBuilder()
                                    .header("X-Intercepted", "synthetic-header")
                                    .build()
                            )
                        }
                        .cookieJar(
                            object : okhttp3.CookieJar {
                                override fun loadForRequest(url: okhttp3.HttpUrl) =
                                    listOf(
                                        okhttp3.Cookie.Builder()
                                            .name("session")
                                            .value("synthetic-session")
                                            .hostOnlyDomain(url.host)
                                            .build()
                                    )

                                override fun saveFromResponse(
                                    url: okhttp3.HttpUrl,
                                    cookies: List<okhttp3.Cookie>,
                                ) {}
                            }
                        )
                        .build()
                val client =
                    com.openai.client.OpenAIClientImpl(
                        com.openai.core.ClientOptions.builder()
                            .httpClient(OkHttpClient(transport))
                            .baseUrl(peer.url)
                            .apiKey("fake-key")
                            .build()
                    )
                try {
                    client.responses().connect().use {
                        assertThat(it.finalResponse().id()).isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `custom TLS trust and connection specifications are preserved`() {
        val certificate =
            okhttp3.tls.HeldCertificate.Builder().addSubjectAlternativeName("localhost").build()
        val serverTls =
            okhttp3.tls.HandshakeCertificates.Builder().heldCertificate(certificate).build()
        val clientTls =
            okhttp3.tls.HandshakeCertificates.Builder()
                .addTrustedCertificate(certificate.certificate)
                .build()
        okhttp3.mockwebserver.MockWebServer().use { server ->
            server.useHttps(serverTls.sslSocketFactory(), false)
            server.enqueue(
                okhttp3.mockwebserver
                    .MockResponse()
                    .withWebSocketUpgrade(
                        object : okhttp3.WebSocketListener() {
                            override fun onOpen(
                                socket: okhttp3.WebSocket,
                                response: okhttp3.Response,
                            ) {
                                socket.send(event("response.completed"))
                            }
                        }
                    )
            )
            server.start()
            val spec =
                okhttp3.ConnectionSpec.Builder(okhttp3.ConnectionSpec.MODERN_TLS)
                    .tlsVersions(okhttp3.TlsVersion.TLS_1_2)
                    .cipherSuites(okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256)
                    .build()
            val native =
                okhttp3.OkHttpClient.Builder()
                    .sslSocketFactory(clientTls.sslSocketFactory(), clientTls.trustManager)
                    .connectionSpecs(listOf(spec))
                    .build()
            val client =
                com.openai.client.OpenAIClientImpl(
                    com.openai.core.ClientOptions.builder()
                        .apiKey("fake-key")
                        .putHeader("X-TLS-Test", "custom")
                        .baseUrl(server.url("/v1").toString())
                        .httpClient(OkHttpClient(native))
                        .build()
                )
            try {
                client.responses().connect().use {
                    assertThat(it.finalResponse().id()).isEqualTo("resp_123")
                }
                val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                assertThat(request.getHeader("Authorization")).isEqualTo("Bearer fake-key")
                assertThat(request.getHeader("X-TLS-Test")).isEqualTo("custom")
                assertThat(request.handshake!!.tlsVersion).isEqualTo(okhttp3.TlsVersion.TLS_1_2)
                assertThat(request.handshake!!.cipherSuite)
                    .isEqualTo(okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `TLS policy is enforced with optional TLS extensions`() {
        val certificate =
            okhttp3.tls.HeldCertificate.Builder().addSubjectAlternativeName("localhost").build()
        val serverTls =
            okhttp3.tls.HandshakeCertificates.Builder().heldCertificate(certificate).build()
        val clientTls =
            okhttp3.tls.HandshakeCertificates.Builder()
                .addTrustedCertificate(certificate.certificate)
                .build()
        val policies =
            listOf(
                okhttp3.ConnectionSpec.Builder(okhttp3.ConnectionSpec.MODERN_TLS)
                    .cipherSuites("TLS_SYNTHETIC_UNSUPPORTED_CIPHER")
                    .build(),
                okhttp3.ConnectionSpec.Builder(okhttp3.ConnectionSpec.MODERN_TLS)
                    .supportsTlsExtensions(false)
                    .build(),
            )
        for (policy in policies) {
            okhttp3.mockwebserver.MockWebServer().use { server ->
                server.useHttps(serverTls.sslSocketFactory(), false)
                server.enqueue(
                    okhttp3.mockwebserver
                        .MockResponse()
                        .withWebSocketUpgrade(
                            object : okhttp3.WebSocketListener() {
                                override fun onOpen(
                                    socket: okhttp3.WebSocket,
                                    response: okhttp3.Response,
                                ) {
                                    socket.send(event("response.completed"))
                                }
                            }
                        )
                )
                server.start()
                val native =
                    okhttp3.OkHttpClient.Builder()
                        .sslSocketFactory(clientTls.sslSocketFactory(), clientTls.trustManager)
                        .connectionSpecs(listOf(policy))
                        .build()
                val client =
                    com.openai.client.OpenAIClientImpl(
                        com.openai.core.ClientOptions.builder()
                            .apiKey("fake-key")
                            .baseUrl(server.url("/v1").toString())
                            .httpClient(OkHttpClient(native))
                            .build()
                    )
                try {
                    if (policy.supportsTlsExtensions) {
                        assertThatThrownBy { client.responses().connect() }
                            .hasRootCauseInstanceOf(java.net.UnknownServiceException::class.java)
                        assertThat(server.takeRequest(200, TimeUnit.MILLISECONDS)).isNull()
                    } else {
                        client.responses().connect().use {
                            assertThat(it.finalResponse().id()).isEqualTo("resp_123")
                        }
                        assertThat(server.takeRequest(5, TimeUnit.SECONDS)).isNotNull()
                    }
                } finally {
                    client.close()
                }
            }
        }
    }

    @Test
    fun `configured SOCKS proxy transports the handshake and commands`() {
        Peer { socket, headers ->
                assertThat(headers["authorization"]).isEqualTo("Bearer fake-key")
                assertThat(headers["x-test"]).isEqualTo("through-proxy")
                readMessage(socket)
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                ServerSocket(0).use { proxy ->
                    proxy.soTimeout = 5000
                    val tunnel =
                        CompletableFuture.runAsync {
                            proxy.accept().use { incoming ->
                                incoming.soTimeout = 5000
                                val input = DataInputStream(incoming.getInputStream())
                                val output = DataOutputStream(incoming.getOutputStream())
                                assertThat(input.readUnsignedByte()).isEqualTo(5)
                                val methods = ByteArray(input.readUnsignedByte())
                                input.readFully(methods)
                                assertThat(methods).contains(0.toByte())
                                output.write(byteArrayOf(5, 0))
                                output.flush()
                                assertThat(input.readUnsignedByte()).isEqualTo(5)
                                assertThat(input.readUnsignedByte()).isEqualTo(1)
                                assertThat(input.readUnsignedByte()).isEqualTo(0)
                                val addressType = input.readUnsignedByte()
                                assertThat(addressType).isIn(1, 3)
                                val address =
                                    ByteArray(if (addressType == 1) 4 else input.readUnsignedByte())
                                input.readFully(address)
                                val host =
                                    if (addressType == 1)
                                        java.net.InetAddress.getByAddress(address).hostAddress
                                    else String(address, Charsets.UTF_8)
                                assertThat(host).isEqualTo("127.0.0.1")
                                val port = input.readUnsignedShort()
                                assertThat(port).isEqualTo(java.net.URI(peer.url).port)
                                Socket(host, port).use { upstream ->
                                    upstream.soTimeout = 5000
                                    output.write(byteArrayOf(5, 0, 0, 1, 127, 0, 0, 1, 0, 0))
                                    output.flush()
                                    val upload =
                                        CompletableFuture.runAsync {
                                            input.copyTo(upstream.getOutputStream())
                                            upstream.shutdownOutput()
                                        }
                                    upstream.getInputStream().copyTo(output)
                                    upload.get(5, TimeUnit.SECONDS)
                                }
                            }
                        }
                    val client =
                        OpenAIOkHttpClient.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .proxy(
                                java.net.Proxy(
                                    java.net.Proxy.Type.SOCKS,
                                    java.net.InetSocketAddress("127.0.0.1", proxy.localPort),
                                )
                            )
                            .build()
                    try {
                        client
                            .responses()
                            .connect(
                                ResponseWebSocketOptions.builder()
                                    .putHeader("X-Test", "through-proxy")
                                    .build()
                            )
                            .use { connection ->
                                connection.send(command())
                                assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                            }
                        peer.await()
                        tunnel.get(5, TimeUnit.SECONDS)
                    } finally {
                        client.close()
                    }
                }
            }
    }

    @Test
    fun `TLS SOCKS proxy resolves endpoint hostnames remotely`() = socksProxyReachesEndpoint(true)

    @Test
    fun `plain SOCKS proxy resolves endpoint hostnames remotely`() =
        socksProxyReachesEndpoint(false)

    @Test
    fun `TLS SOCKS proxy preserves IPv6 literal addresses`() =
        socksProxyReachesEndpoint(true, "::1")

    @Test
    fun `plain SOCKS proxy preserves IPv6 literal addresses`() =
        socksProxyReachesEndpoint(false, "::1")

    @Test
    fun `TLS SOCKS4 fallback fails without a direct connection`() =
        socksProxyReachesEndpoint(true, "127.0.0.1", socks4 = true)

    @Test
    fun `plain SOCKS4 fallback fails without a direct connection`() =
        socksProxyReachesEndpoint(false, "127.0.0.1", socks4 = true)

    private fun socksProxyReachesEndpoint(
        secure: Boolean,
        host: String = "localhost",
        socks4: Boolean = false,
    ) {
        val ipv6 = ':' in host
        val serverAddress = java.net.InetAddress.getByName(if (ipv6) host else "127.0.0.1")
        val certificate =
            okhttp3.tls.HeldCertificate.Builder().addSubjectAlternativeName(host).build()
        val serverTls =
            okhttp3.tls.HandshakeCertificates.Builder().heldCertificate(certificate).build()
        val clientTls =
            okhttp3.tls.HandshakeCertificates.Builder()
                .addTrustedCertificate(certificate.certificate)
                .build()
        okhttp3.mockwebserver.MockWebServer().use { server ->
            if (secure) server.useHttps(serverTls.sslSocketFactory(), false)
            server.enqueue(
                okhttp3.mockwebserver
                    .MockResponse()
                    .withWebSocketUpgrade(
                        object : okhttp3.WebSocketListener() {
                            override fun onMessage(socket: okhttp3.WebSocket, text: String) {
                                assertThat(mapper.readTree(text).path("type").asText())
                                    .isEqualTo("response.create")
                                socket.send(event("response.completed"))
                            }
                        }
                    )
            )
            server.start(serverAddress, 0)
            ServerSocket(0).use { proxy ->
                proxy.soTimeout = 5000
                val tunnel =
                    CompletableFuture.runAsync {
                        proxy.accept().use { incoming ->
                            incoming.soTimeout = 5000
                            val input = DataInputStream(incoming.getInputStream())
                            val output = DataOutputStream(incoming.getOutputStream())
                            assertThat(input.readUnsignedByte()).isEqualTo(5)
                            val methods = ByteArray(input.readUnsignedByte())
                            input.readFully(methods)
                            // An older proxy's non-v5 greeting invokes the JDK's SOCKS4 fallback.
                            output.write(if (socks4) byteArrayOf(0, 0) else byteArrayOf(5, 0))
                            output.flush()
                            if (socks4) {
                                // Native OkHttp/JDK SOCKS4 fallback cannot route unresolved
                                // destinations. It must fail here without contacting the origin.
                                assertThat(input.read()).isEqualTo(-1)
                                return@runAsync
                            }
                            assertThat(input.readUnsignedByte()).isEqualTo(5)
                            assertThat(input.readUnsignedByte()).isEqualTo(1)
                            assertThat(input.readUnsignedByte()).isEqualTo(0)
                            val addressType = input.readUnsignedByte()
                            if (addressType == 4) {
                                assertThat(ipv6).isTrue()
                                val address = ByteArray(16)
                                input.readFully(address)
                                assertThat(address).isEqualTo(serverAddress.address)
                            } else {
                                assertThat(addressType).isEqualTo(3)
                                val hostname = ByteArray(input.readUnsignedByte())
                                input.readFully(hostname)
                                assertThat(String(hostname, Charsets.UTF_8)).isEqualTo(host)
                            }
                            val port = input.readUnsignedShort()
                            assertThat(port).isEqualTo(server.port)
                            Socket(serverAddress, port).use { upstream ->
                                upstream.soTimeout = 5000
                                output.write(byteArrayOf(5, 0, 0, 1, 127, 0, 0, 1, 0, 0))
                                output.flush()
                                val upload =
                                    CompletableFuture.runAsync {
                                        input.copyTo(upstream.getOutputStream())
                                        upstream.shutdownOutput()
                                    }
                                upstream.getInputStream().copyTo(output)
                                upload.get(5, TimeUnit.SECONDS)
                            }
                        }
                    }
                val native =
                    okhttp3.OkHttpClient.Builder()
                        .sslSocketFactory(clientTls.sslSocketFactory(), clientTls.trustManager)
                        .proxy(
                            java.net.Proxy(
                                java.net.Proxy.Type.SOCKS,
                                java.net.InetSocketAddress("127.0.0.1", proxy.localPort),
                            )
                        )
                        .build()
                val client =
                    com.openai.client.OpenAIClientImpl(
                        com.openai.core.ClientOptions.builder()
                            .apiKey("fake-key")
                            .baseUrl(server.url("/v1").newBuilder().host(host).build().toString())
                            .httpClient(OkHttpClient(native))
                            .build()
                    )
                try {
                    if (socks4) {
                        assertThatThrownBy { client.responses().connect() }
                            .hasRootCauseInstanceOf(java.net.UnknownHostException::class.java)
                        assertThat(server.requestCount).isZero()
                    } else {
                        client.responses().connect().use { connection ->
                            connection.send(command())
                            assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                        }
                        assertThat(
                                server.takeRequest(5, TimeUnit.SECONDS)!!.getHeader("Authorization")
                            )
                            .isEqualTo("Bearer fake-key")
                    }
                    tunnel.get(5, TimeUnit.SECONDS)
                } finally {
                    client.close()
                }
            }
        }
    }

    @Test
    fun `control frames retain their protocol limit with a small message limit`() {
        for (closeCode in listOf(1000, null)) {
            val payload = "x".repeat(125)
            Peer { socket, _ ->
                    val output = DataOutputStream(socket.getOutputStream())
                    // A legal maximum-size ping must receive its matching pong.
                    output.writeByte(0x89)
                    output.writeByte(125)
                    output.write(payload.toByteArray(Charsets.UTF_8))
                    output.flush()
                    assertThat(readMessage(socket, 0x8a)).isEqualTo(payload)
                    output.writeByte(0x8a)
                    output.writeByte(125)
                    output.write(payload.toByteArray(Charsets.UTF_8))
                    send(socket, """{"type":"future"}""")
                    output.writeByte(0x88)
                    output.writeByte(if (closeCode == null) 0 else 125)
                    if (closeCode != null) {
                        output.writeShort(closeCode)
                        output.write("x".repeat(123).toByteArray(Charsets.UTF_8))
                    }
                    output.flush()
                    // The client must finish the closing handshake before closing TCP.
                    val input = DataInputStream(socket.getInputStream())
                    assertThat(input.read()).isEqualTo(0x88)
                    assertThat(input.readUnsignedByte()).isEqualTo(0x80 or 2)
                    val mask = ByteArray(4).also(input::readFully)
                    val status =
                        ((input.readUnsignedByte() xor (mask[0].toInt() and 0xff)) shl 8) or
                            (input.readUnsignedByte() xor (mask[1].toInt() and 0xff))
                    assertThat(status).isEqualTo(1000)
                    assertThat(input.read()).isEqualTo(-1)
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        client
                            .responses()
                            .connect(ResponseWebSocketOptions.builder().maxMessageBytes(32).build())
                            .get(5, TimeUnit.SECONDS)
                            .use { connection ->
                                assertThat(connection.receive().get(5, TimeUnit.SECONDS)._json())
                                    .isPresent()
                                assertThatThrownBy { connection.receive().get(5, TimeUnit.SECONDS) }
                                    .hasRootCauseMessage(
                                        "WebSocket closed (code ${closeCode ?: 1005})"
                                    )
                            }
                        peer.await()
                    } finally {
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `final response inspects terminal variants without serializing events`() {
        finalResponseWithoutSerialization(rejectTerminal = false)
    }

    @Test
    fun `final response rejects unparsed terminal variants without serializing events`() {
        finalResponseWithoutSerialization(rejectTerminal = true)
    }

    private fun finalResponseWithoutSerialization(rejectTerminal: Boolean) {
        val terminalTypes = listOf("response.completed", "response.failed", "response.incomplete")
        val payload = "x".repeat(1024 * 1024)
        val rejectingMapper =
            jsonMapper().copy().apply {
                addMixIn(
                    com.openai.models.responses.ResponsesServerEvent::class.java,
                    UnserializableServerEvent::class.java,
                )
                if (rejectTerminal) {
                    for (type in
                        listOf(
                            com.openai.models.responses.ResponseCompletedEvent::class.java,
                            com.openai.models.responses.ResponseFailedEvent::class.java,
                            com.openai.models.responses.ResponseIncompleteEvent::class.java,
                            com.openai.models.responses.ResponsesServerEvent.ResponseWsError::class
                                .java,
                        )) addMixIn(type, UndeserializableTerminalEvent::class.java)
                }
            }
        Peer { socket, _ ->
                for (type in terminalTypes) {
                    readMessage(socket)
                    send(socket, """{"type":"response.future_event"}""")
                    send(
                        socket,
                        event(type)
                            .replace(
                                "\"output\":[]",
                                "\"output\":[],\"synthetic_payload\":\"$payload\"",
                            ),
                    )
                }
                readMessage(socket)
                send(socket, """{"type":"error","error":{"message":"synthetic"}}""")
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url)
                        .jsonMapper(rejectingMapper)
                        .build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        for (type in terminalTypes) {
                            connection.send(command())
                            val response = connection.finalResponse()
                            if (rejectTerminal) {
                                assertThatThrownBy { response.get(5, TimeUnit.SECONDS) }
                                    .hasCauseInstanceOf(
                                        com.openai.errors.OpenAIInvalidDataException::class.java
                                    )
                            } else {
                                assertThat(
                                        response
                                            .get(5, TimeUnit.SECONDS)
                                            ._additionalProperties()["synthetic_payload"]
                                            ?.asString()
                                            ?.orElse(null)
                                    )
                                    .isEqualTo(payload)
                            }
                        }
                        connection.send(command())
                        assertThatThrownBy { connection.finalResponse().get(5, TimeUnit.SECONDS) }
                            .hasCauseInstanceOf(
                                com.openai.core.http.ResponseWebSocketException::class.java
                            )
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(
        using = com.fasterxml.jackson.databind.JsonDeserializer.None::class
    )
    private abstract class CustomEventDeserializer

    @com.fasterxml.jackson.databind.annotation.JsonSerialize(
        using = RejectingEventSerializer::class
    )
    private abstract class UnserializableServerEvent

    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(
        using = RejectingTerminalDeserializer::class
    )
    private abstract class UndeserializableTerminalEvent

    class RejectingTerminalDeserializer : com.fasterxml.jackson.databind.JsonDeserializer<Any>() {
        override fun deserialize(
            parser: com.fasterxml.jackson.core.JsonParser,
            context: com.fasterxml.jackson.databind.DeserializationContext,
        ): Any = throw IllegalArgumentException("Synthetic terminal deserialization failure")
    }

    class RejectingEventSerializer :
        com.fasterxml.jackson.databind.JsonSerializer<
            com.openai.models.responses.ResponsesServerEvent
        >() {
        override fun serialize(
            value: com.openai.models.responses.ResponsesServerEvent,
            generator: com.fasterxml.jackson.core.JsonGenerator,
            provider: com.fasterxml.jackson.databind.SerializerProvider,
        ) {
            throw IllegalArgumentException("Synthetic server event serialization failure")
        }
    }

    @Test
    fun `named lane preserves reference routed steering command`() {
        val json =
            """{"type":"response.steer","previous_response_id":"resp_parent","input":"Change course"}"""
        val command = mapper.readValue(json, ResponsesClientEvent::class.java)
        Peer { socket, _ ->
                assertThat(mapper.readTree(readMessage(socket))).isEqualTo(mapper.readTree(json))
                send(socket, event("response.completed", "steering"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        connection.lane("steering").use { lane ->
                            lane.send(command)
                            assertThat(lane.finalResponse().get(5, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_123")
                            assertThat(
                                    mapper.valueToTree<com.fasterxml.jackson.databind.JsonNode>(
                                        command
                                    )
                                )
                                .isEqualTo(mapper.readTree(json))
                        }
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `reconnect refreshes credentials and never replays a command`() {
        val count = java.util.concurrent.atomic.AtomicInteger()
        val checked = CountDownLatch(1)
        Peer(2) { socket, headers ->
                val attempt = count.incrementAndGet()
                assertThat(headers["authorization"]).isEqualTo("Bearer fake-$attempt")
                assertThat(headers["x-routing-context"]).isEqualTo("attempt-$attempt")
                assertThat(headers["x-base-header"]).isEqualTo("base")
                if (attempt == 2) {
                    socket.soTimeout = 150
                    assertThatThrownBy { socket.getInputStream().read() }
                        .isInstanceOf(java.net.SocketTimeoutException::class.java)
                    socket.soTimeout = 10000
                    checked.countDown()
                }
                assertThat(mapper.readTree(readMessage(socket)).path("stream_id").asText())
                    .isEqualTo("lane")
                send(socket, event("response.completed", "lane"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val token = java.util.concurrent.atomic.AtomicInteger()
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .credential(
                            com.openai.credential.BearerTokenCredential.create {
                                "fake-${token.incrementAndGet()}"
                            }
                        )
                        .baseUrl(peer.url)
                        .putHeader("X-Routing-Context", "base-value")
                        .putHeader("X-Base-Header", "base")
                        .build()
                try {
                    client
                        .responses()
                        .connect(
                            ResponseWebSocketOptions.builder()
                                .putHeader("x-routing-context", "attempt-1")
                                .build()
                        )
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            connection.lane("lane").use { lane ->
                                lane.send(command())
                                assertThat(lane.finalResponse().get(5, TimeUnit.SECONDS).id())
                                    .isEqualTo("resp_123")
                                connection
                                    .reconnect(
                                        ResponseWebSocketOptions.builder()
                                            .putHeader("X-Routing-Context", "attempt-2")
                                            .build()
                                    )
                                    .get(5, TimeUnit.SECONDS)
                                assertThat(checked.await(5, TimeUnit.SECONDS)).isTrue()
                                lane.send(command())
                                assertThat(lane.finalResponse().get(5, TimeUnit.SECONDS).id())
                                    .isEqualTo("resp_123")
                            }
                        }
                    peer.await()
                    assertThat(count.get()).isEqualTo(2)
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `open websocket does not occupy the HTTP dispatcher or its bounded executor`() {
        val httpExecutor = java.util.concurrent.Executors.newSingleThreadExecutor()
        val dispatcher = okhttp3.Dispatcher(httpExecutor).apply { maxRequests = 1 }
        val reader = java.util.concurrent.atomic.AtomicReference<Thread>()
        okhttp3.mockwebserver.MockWebServer().use { server ->
            server.enqueue(
                okhttp3.mockwebserver
                    .MockResponse()
                    .withWebSocketUpgrade(
                        object : okhttp3.WebSocketListener() {
                            override fun onMessage(socket: okhttp3.WebSocket, text: String) {
                                socket.send(event("response.completed"))
                            }
                        }
                    )
            )
            server.enqueue(
                okhttp3.mockwebserver
                    .MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody("""{"object":"list","data":[]}""")
            )
            val native =
                okhttp3.OkHttpClient.Builder()
                    .dispatcher(dispatcher)
                    .addInterceptor { chain ->
                        if (chain.request().header("Upgrade") == "websocket")
                            reader.set(Thread.currentThread())
                        chain.proceed(chain.request())
                    }
                    .build()
            val client =
                com.openai.client.OpenAIClientAsyncImpl(
                    com.openai.core.ClientOptions.builder()
                        .httpClient(OkHttpClient(native))
                        .baseUrl(server.url("/v1").toString())
                        .apiKey("fake-key")
                        .build()
                )
            try {
                client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                    assertThat(client.models().list().get(5, TimeUnit.SECONDS).data()).isEmpty()
                    connection.send(command())
                    assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                        .isEqualTo("resp_123")
                }
                reader.get().join(5000)
                assertThat(reader.get().isAlive).isFalse()
                assertThat(httpExecutor.submit<String> { "still running" }.get(5, TimeUnit.SECONDS))
                    .isEqualTo("still running")
            } finally {
                client.close()
                httpExecutor.shutdownNow()
            }
        }
    }

    @Test
    fun `failed canceled and timed out openings release their reader executor`() {
        for (mode in listOf("failure", "cancel", "timeout")) {
            val reader = java.util.concurrent.atomic.AtomicReference<Thread>()
            okhttp3.mockwebserver.MockWebServer().use { server ->
                server.enqueue(
                    if (mode == "failure") okhttp3.mockwebserver.MockResponse().setResponseCode(400)
                    else
                        okhttp3.mockwebserver
                            .MockResponse()
                            .setSocketPolicy(okhttp3.mockwebserver.SocketPolicy.NO_RESPONSE)
                )
                val native =
                    okhttp3.OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            reader.set(Thread.currentThread())
                            chain.proceed(chain.request())
                        }
                        .build()
                val client =
                    com.openai.client.OpenAIClientAsyncImpl(
                        com.openai.core.ClientOptions.builder()
                            .httpClient(OkHttpClient(native))
                            .baseUrl(server.url("/v1").toString())
                            .apiKey("fake-key")
                            .build()
                    )
                try {
                    val requestOptions =
                        com.openai.core.RequestOptions.builder()
                            .timeout(
                                com.openai.core.Timeout.builder()
                                    .connect(
                                        java.time.Duration.ofMillis(
                                            if (mode == "timeout") 1000 else 0
                                        )
                                    )
                                    .request(java.time.Duration.ZERO)
                                    .build()
                            )
                            .build()
                    val pending =
                        client
                            .responses()
                            .connect(ResponseWebSocketOptions.defaults(), requestOptions)
                    assertThat(server.takeRequest(5, TimeUnit.SECONDS)).isNotNull()
                    if (mode == "cancel") assertThat(pending.cancel(false)).isTrue()
                    else
                        assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                            .hasCauseInstanceOf(
                                if (mode == "failure")
                                    com.openai.core.http.WebSocketHandshakeException::class.java
                                else java.io.IOException::class.java
                            )
                    reader.get().join(5000)
                    assertThat(reader.get().isAlive).describedAs("reader for %s", mode).isFalse()
                } finally {
                    client.close()
                }
            }
        }
    }

    @Test
    fun `closing the client closes active sockets without shutting another client`() {
        Peer { socket, _ -> while (socket.getInputStream().read() != -1) {} }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                val connection = client.responses().connect().get(5, TimeUnit.SECONDS)
                val pending = connection.receive()
                client.close()
                assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                    .isInstanceOf(java.util.concurrent.ExecutionException::class.java)
                peer.await()
                connection.close()
            }
    }

    @Test
    fun `HTTP only clients fail explicitly without fallback transport`() {
        val calls = java.util.concurrent.atomic.AtomicInteger()
        val subjects = java.util.concurrent.atomic.AtomicInteger()
        val tokens = java.util.concurrent.atomic.AtomicInteger()
        val transport =
            object : com.openai.core.http.HttpClient {
                override fun execute(
                    request: com.openai.core.http.HttpRequest,
                    options: com.openai.core.RequestOptions,
                ): com.openai.core.http.HttpResponse {
                    calls.incrementAndGet()
                    throw UnsupportedOperationException()
                }

                override fun executeAsync(
                    request: com.openai.core.http.HttpRequest,
                    options: com.openai.core.RequestOptions,
                ): CompletableFuture<com.openai.core.http.HttpResponse> {
                    calls.incrementAndGet()
                    throw UnsupportedOperationException()
                }

                override fun close() {}
            }
        val provider =
            object : com.openai.auth.SubjectTokenProvider {
                override fun tokenType() = com.openai.auth.SubjectTokenType.JWT

                override fun getToken(
                    httpClient: com.openai.core.http.HttpClient,
                    jsonMapper: com.fasterxml.jackson.databind.json.JsonMapper,
                ): String {
                    subjects.incrementAndGet()
                    return "fake-subject"
                }

                override fun getTokenAsync(
                    httpClient: com.openai.core.http.HttpClient,
                    jsonMapper: com.fasterxml.jackson.databind.json.JsonMapper,
                ) = CompletableFuture.completedFuture(getToken(httpClient, jsonMapper))
            }
        for (authentication in listOf("api-key", "workload-identity", "token-supplier")) {
            val options = com.openai.core.ClientOptions.builder().httpClient(transport)
            when (authentication) {
                "api-key" -> options.apiKey("fake-key")
                "workload-identity" ->
                    options.workloadIdentity(
                        com.openai.auth.WorkloadIdentity.builder()
                            .identityProviderId("fake-provider")
                            .serviceAccountId("fake-account")
                            .provider(provider)
                            .build()
                    )
                "token-supplier" ->
                    options.credential(
                        com.openai.credential.BearerTokenCredential.create {
                            tokens.incrementAndGet()
                            throw AssertionError("HTTP-only clients must not request a token")
                        }
                    )
            }
            val client = com.openai.client.OpenAIClientImpl(options.build())
            try {
                assertThatThrownBy { client.responses().connect() }
                    .isInstanceOf(UnsupportedOperationException::class.java)
                    .hasMessage("The configured HTTP client does not support WebSockets")
                assertThatThrownBy { client.async().responses().connect().get(5, TimeUnit.SECONDS) }
                    .hasCauseInstanceOf(UnsupportedOperationException::class.java)
                    .hasRootCauseMessage("The configured HTTP client does not support WebSockets")
                assertThat(subjects.get()).isZero()
                assertThat(tokens.get()).isZero()
                assertThat(calls.get()).isZero()
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `blocking readers expose transport failures as unchecked SDK errors`() {
        Peer { socket, _ ->
                readMessage(socket)
                socket.close()
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        connection.send(command())
                        val failure =
                            org.assertj.core.api.Assertions.catchThrowable { connection.receive() }
                        assertThat(failure)
                            .isInstanceOf(com.openai.errors.OpenAIIoException::class.java)
                            .hasCauseInstanceOf(java.io.IOException::class.java)
                        assertThatThrownBy { connection.finalResponse() }
                            .isInstanceOf(com.openai.errors.OpenAIIoException::class.java)
                            .cause()
                            .isSameAs(failure.cause)
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `connection close preserves the shared callback executor`() {
        val executor = java.util.concurrent.Executors.newSingleThreadExecutor()
        Peer { socket, _ -> while (socket.getInputStream().read() != -1) {} }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url)
                        .streamHandlerExecutor(executor)
                        .build()
                try {
                    client.responses().connect().close()
                    assertThat(executor.submit<String> { "still running" }.get(5, TimeUnit.SECONDS))
                        .isEqualTo("still running")
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `native 503 retry repeats only the opening handshake`() {
        val commands = java.util.concurrent.atomic.AtomicInteger()
        okhttp3.mockwebserver.MockWebServer().use { server ->
            server.enqueue(
                okhttp3.mockwebserver
                    .MockResponse()
                    .setResponseCode(503)
                    .setHeader("Retry-After", "0")
                    .setBody("")
            )
            server.enqueue(
                okhttp3.mockwebserver
                    .MockResponse()
                    .withWebSocketUpgrade(
                        object : okhttp3.WebSocketListener() {
                            override fun onMessage(socket: okhttp3.WebSocket, text: String) {
                                assertThat(mapper.readTree(text)["type"].asText())
                                    .isEqualTo("response.create")
                                commands.incrementAndGet()
                                socket.send(event("response.completed"))
                            }
                        }
                    )
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("fake-key")
                    .baseUrl(server.url("/v1").toString())
                    .build()
            try {
                client
                    .responses()
                    .connect(
                        ResponseWebSocketOptions.builder()
                            .putHeader("X-Test", "synthetic-handshake-header")
                            .build()
                    )
                    .use { connection ->
                        connection.send(command())
                        assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                    }
                assertThat(server.requestCount).isEqualTo(2)
                repeat(2) {
                    val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                    assertThat(request.method).isEqualTo("GET")
                    assertThat(request.path).isEqualTo("/v1/responses")
                    assertThat(request.getHeader("Authorization")).isEqualTo("Bearer fake-key")
                    assertThat(request.getHeader("X-Test")).isEqualTo("synthetic-handshake-header")
                }
                assertThat(commands.get()).isEqualTo(1)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `redirects never forward credentials to a second origin`() {
        ServerSocket(0).use { origin ->
            ServerSocket(0).use { destination ->
                destination.soTimeout = 300
                val served =
                    CompletableFuture.runAsync {
                        origin.accept().use { socket ->
                            val input = socket.getInputStream()
                            val headers = StringBuilder()
                            while (!headers.endsWith("\r\n\r\n")) headers.append(
                                input.read().toChar()
                            )
                            socket
                                .getOutputStream()
                                .write(
                                    ("HTTP/1.1 307 Temporary Redirect\r\nLocation: http://127.0.0.1:${destination.localPort}/responses\r\nContent-Length: 0\r\n\r\n")
                                        .toByteArray()
                                )
                        }
                    }
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .apiKey("fake-key")
                        .baseUrl("http://127.0.0.1:${origin.localPort}/v1")
                        .build()
                try {
                    assertThatThrownBy { client.responses().connect().get(3, TimeUnit.SECONDS) }
                        .isInstanceOf(java.util.concurrent.ExecutionException::class.java)
                    served.get(3, TimeUnit.SECONDS)
                    assertThatThrownBy { destination.accept() }
                        .isInstanceOf(java.net.SocketTimeoutException::class.java)
                } finally {
                    client.close()
                }
            }
        }
    }

    @Test
    fun `handshake timeout and cancellation release the socket`() {
        for (mode in listOf("connect", "read", "cancel")) ServerSocket(0).use { origin ->
            val accepted = CountDownLatch(1)
            val served =
                CompletableFuture.runAsync {
                    origin.accept().use { socket ->
                        socket.soTimeout = 3000
                        accepted.countDown()
                        while (socket.getInputStream().read() != -1) {}
                    }
                }
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-key")
                    .baseUrl("http://127.0.0.1:${origin.localPort}/v1")
                    .build()
            try {
                val timeout =
                    com.openai.core.Timeout.builder()
                        .connect(java.time.Duration.ofMillis(if (mode == "connect") 250 else 0))
                        .read(java.time.Duration.ofMillis(if (mode == "read") 250 else 0))
                        .request(java.time.Duration.ZERO)
                        .build()
                val future =
                    client
                        .responses()
                        .connect(
                            ResponseWebSocketOptions.defaults(),
                            com.openai.core.RequestOptions.builder().timeout(timeout).build(),
                        )
                assertThat(accepted.await(2, TimeUnit.SECONDS)).isTrue()
                if (mode == "cancel") assertThat(future.cancel(false)).isTrue()
                else if (mode == "connect")
                    assertThatThrownBy { future.get(3, TimeUnit.SECONDS) }
                        .hasRootCauseMessage("WebSocket handshake timed out")
                else
                    assertThatThrownBy { future.get(3, TimeUnit.SECONDS) }
                        .cause()
                        .hasCauseInstanceOf(java.net.SocketTimeoutException::class.java)
                served.get(3, TimeUnit.SECONDS)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `upgrade timeout headers use effective per connection options`() {
        for (mode in listOf("inherited", "overridden", "unlimited", "explicit")) {
            val observed = CompletableFuture<Map<String, String>>()
            Peer { socket, headers ->
                    observed.complete(headers)
                    send(socket, event("response.completed"))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .timeout(
                                com.openai.core.Timeout.builder()
                                    .read(java.time.Duration.ofSeconds(17))
                                    .request(java.time.Duration.ofSeconds(23))
                                    .build()
                            )
                            .build()
                    try {
                        val options =
                            if (mode == "inherited") com.openai.core.RequestOptions.none()
                            else
                                com.openai.core.RequestOptions.builder()
                                    .timeout(
                                        com.openai.core.Timeout.builder()
                                            .read(
                                                java.time.Duration.ofSeconds(
                                                    if (mode == "unlimited") 0 else 5
                                                )
                                            )
                                            .request(
                                                java.time.Duration.ofSeconds(
                                                    if (mode == "unlimited") 0 else 7
                                                )
                                            )
                                            .build()
                                    )
                                    .build()
                        val parameters =
                            ResponseWebSocketOptions.builder()
                                .apply {
                                    if (mode == "explicit") {
                                        putHeader("X-Stainless-Read-Timeout", "91")
                                        putHeader("X-Stainless-Timeout", "92")
                                    }
                                }
                                .build()
                        client
                            .responses()
                            .connect(parameters, options)
                            .get(5, TimeUnit.SECONDS)
                            .use { connection ->
                                val headers = observed.get(5, TimeUnit.SECONDS)
                                val expected =
                                    when (mode) {
                                        "inherited" -> "17" to "23"
                                        "overridden" -> "5" to "7"
                                        "explicit" -> "91" to "92"
                                        else -> null to null
                                    }
                                assertThat(headers["x-stainless-read-timeout"])
                                    .isEqualTo(expected.first)
                                assertThat(headers["x-stainless-timeout"])
                                    .isEqualTo(expected.second)
                                assertThat(connection.finalResponse().get(5, TimeUnit.SECONDS).id())
                                    .isEqualTo("resp_123")
                            }
                        peer.await()
                    } finally {
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `read timeout can be disabled for upgrade and is cleared after upgrade`() {
        for (unlimited in listOf(false, true)) {
            val emit = CountDownLatch(1)
            Peer(
                    upgrade = {
                        // An explicit zero must outlive the shorter base read timeout.
                        if (unlimited) Thread.sleep(750)
                        true
                    }
                ) { socket, _ ->
                    assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                    send(socket, event("response.completed"))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .timeout(
                                com.openai.core.Timeout.builder()
                                    .connect(java.time.Duration.ZERO)
                                    .read(java.time.Duration.ofMillis(if (unlimited) 250 else 0))
                                    .request(java.time.Duration.ZERO)
                                    .build()
                            )
                            .build()
                    try {
                        client
                            .responses()
                            .connect(
                                ResponseWebSocketOptions.defaults(),
                                com.openai.core.RequestOptions.builder()
                                    .timeout(
                                        com.openai.core.Timeout.builder()
                                            .read(
                                                java.time.Duration.ofMillis(
                                                    if (unlimited) 0 else 250
                                                )
                                            )
                                            .build()
                                    )
                                    .build(),
                            )
                            .get(5, TimeUnit.SECONDS)
                            .use { connection ->
                                val response = connection.finalResponse()
                                // A successful upgrade removes the HTTP socket read timeout.
                                assertThatThrownBy { response.get(750, TimeUnit.MILLISECONDS) }
                                    .isInstanceOf(java.util.concurrent.TimeoutException::class.java)
                                emit.countDown()
                                assertThat(response.get(5, TimeUnit.SECONDS).id())
                                    .isEqualTo("resp_123")
                            }
                        peer.await()
                    } finally {
                        emit.countDown()
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `close cancels a pending reconnect handshake`() {
        val accepted = CountDownLatch(1)
        val attempt = java.util.concurrent.atomic.AtomicInteger()
        Peer(connectionCount = 2, upgrade = { it == 0 }) { socket, _ ->
                if (attempt.incrementAndGet() == 2) accepted.countDown()
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    val timeout =
                        com.openai.core.Timeout.builder()
                            .connect(java.time.Duration.ZERO)
                            .request(java.time.Duration.ZERO)
                            .build()
                    val connection =
                        client
                            .responses()
                            .connect(
                                ResponseWebSocketOptions.defaults(),
                                com.openai.core.RequestOptions.builder().timeout(timeout).build(),
                            )
                            .get(5, TimeUnit.SECONDS)
                    val reconnect = connection.reconnect()
                    assertThat(accepted.await(5, TimeUnit.SECONDS)).isTrue()
                    connection.close()
                    assertThatThrownBy { reconnect.get(5, TimeUnit.SECONDS) }
                        .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `an assigned event survives cancellation and peer close while callbacks are delayed`() {
        for (helper in listOf(false, true)) {
            val callbacks = java.util.concurrent.LinkedBlockingDeque<Runnable>()
            val emit = CountDownLatch(1)
            Peer { socket, _ ->
                    assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                    send(socket, event("response.completed"))
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .streamHandlerExecutor(
                                java.util.concurrent.Executor { callbacks.add(it) }
                            )
                            .build()
                    try {
                        val opening = client.responses().connect()
                        callbacks.poll(5, TimeUnit.SECONDS)!!.run()
                        opening.get(5, TimeUnit.SECONDS).use { connection ->
                            val received =
                                if (helper) connection.finalResponse() else connection.receive()
                            emit.countDown()
                            peer.await()
                            val deliver = callbacks.poll(5, TimeUnit.SECONDS)!!
                            assertThat(received.cancel(false)).isFalse()
                            deliver.run()
                            if (helper) {
                                callbacks.poll(5, TimeUnit.SECONDS)!!.run()
                                assertThat(
                                        (received.get(5, TimeUnit.SECONDS)
                                                as com.openai.models.responses.Response)
                                            .id()
                                    )
                                    .isEqualTo("resp_123")
                            } else {
                                assertThat(
                                        mapper
                                            .valueToTree<JsonNode>(
                                                received.get(5, TimeUnit.SECONDS)
                                            )
                                            .path("type")
                                            .asText()
                                    )
                                    .isEqualTo("response.completed")
                            }
                        }
                    } finally {
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `cancellation callbacks can wait for another thread using the connection`() {
        for (helper in listOf(false, true)) {
            Peer { socket, _ ->
                    readMessage(socket)
                    send(socket, event("response.completed"))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                            val pending =
                                if (helper) connection.finalResponse() else connection.receive()
                            val callback =
                                pending.handle { _, _ ->
                                    CompletableFuture.runAsync {
                                            connection.lane("callback").close()
                                        }
                                        .get(2, TimeUnit.SECONDS)
                                }
                            assertThat(pending.cancel(false)).isTrue()
                            callback.get(5, TimeUnit.SECONDS)
                            val next = connection.finalResponse()
                            connection.send(command())
                            assertThat(next.get(5, TimeUnit.SECONDS).id()).isEqualTo("resp_123")
                        }
                        peer.await()
                    } finally {
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `concurrent send admission rejects before serialization and releases capacity`() {
        val entered = CountDownLatch(2)
        val releases = listOf(CountDownLatch(1), CountDownLatch(1))
        val serializations = java.util.concurrent.atomic.AtomicInteger()
        val boundedMapper =
            object : com.fasterxml.jackson.databind.json.JsonMapper(mapper) {
                override fun <T : JsonNode?> valueToTree(value: Any?): T {
                    if (value is ResponsesClientEvent) {
                        val index = serializations.getAndIncrement()
                        if (index < 2) {
                            entered.countDown()
                            check(releases[index].await(5, TimeUnit.SECONDS))
                        }
                    }
                    return super.valueToTree(value)
                }
            }
        Peer { socket, _ ->
                repeat(3) {
                    assertThat(mapper.readTree(readMessage(socket)).path("input").asText())
                        .isEqualTo("hello")
                    send(socket, event("response.completed"))
                }
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url)
                        .jsonMapper(boundedMapper)
                        .build()
                try {
                    client
                        .responses()
                        .connect(ResponseWebSocketOptions.builder().maxPendingSends(2).build())
                        .get(5, TimeUnit.SECONDS)
                        .use { connection ->
                            val first = CompletableFuture.runAsync { connection.send(command()) }
                            val second = CompletableFuture.runAsync { connection.send(command()) }
                            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                            assertThatThrownBy { connection.send(command()) }
                                .isInstanceOf(IllegalStateException::class.java)
                                .hasMessageContaining("command was not sent")
                            assertThat(serializations.get()).isEqualTo(2)
                            releases[0].countDown()
                            connection.finalResponse().get(5, TimeUnit.SECONDS)
                            releases[1].countDown()
                            connection.finalResponse().get(5, TimeUnit.SECONDS)
                            first.get(5, TimeUnit.SECONDS)
                            second.get(5, TimeUnit.SECONDS)
                            connection.send(command())
                            connection.finalResponse().get(5, TimeUnit.SECONDS)
                            assertThat(serializations.get()).isEqualTo(3)
                        }
                    peer.await()
                } finally {
                    releases.forEach { it.countDown() }
                    client.close()
                }
            }
    }

    @Test
    fun `a response helper cannot continue consuming after socket replacement`() {
        val callbacks = java.util.concurrent.LinkedBlockingDeque<Runnable>()
        fun finish(future: CompletableFuture<*>) {
            val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
            while (!future.isDone && System.nanoTime() < deadline) {
                callbacks.poll(1, TimeUnit.SECONDS)?.run()
            }
            assertThat(future.isDone).isTrue()
        }
        val emit = CountDownLatch(1)
        val attempt = java.util.concurrent.atomic.AtomicInteger()
        Peer(2) { socket, _ ->
                if (attempt.incrementAndGet() == 1) {
                    assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                    send(socket, event("response.created"))
                } else {
                    readMessage(socket)
                    send(socket, event("response.completed").replace("resp_123", "resp_new"))
                }
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url)
                        .streamHandlerExecutor(java.util.concurrent.Executor { callbacks.add(it) })
                        .build()
                try {
                    val opening = client.responses().connect()
                    finish(opening)
                    opening.get(5, TimeUnit.SECONDS).use { connection ->
                        val previous = connection.finalResponse()
                        emit.countDown()
                        val assigned = callbacks.poll(5, TimeUnit.SECONDS)!!
                        val replacement = connection.reconnect()
                        assigned.run()
                        finish(previous)
                        assertThatThrownBy { previous.get(5, TimeUnit.SECONDS) }
                            .isInstanceOf(java.util.concurrent.CancellationException::class.java)
                        finish(replacement)
                        replacement.get(5, TimeUnit.SECONDS)
                        val next = connection.finalResponse()
                        connection.send(command())
                        finish(next)
                        assertThat(next.get(5, TimeUnit.SECONDS).id()).isEqualTo("resp_new")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `interruption cannot discard an event assigned to a blocking reader`() {
        val callbacks = java.util.concurrent.LinkedBlockingDeque<Runnable>()
        val emit = CountDownLatch(1)
        Peer { socket, _ ->
                assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder()
                        .apiKey("fake-key")
                        .baseUrl(peer.url)
                        .streamHandlerExecutor(java.util.concurrent.Executor { callbacks.add(it) })
                        .build()
                try {
                    val opening = CompletableFuture.supplyAsync { client.responses().connect() }
                    callbacks.poll(5, TimeUnit.SECONDS)!!.run()
                    opening.get(5, TimeUnit.SECONDS).use { connection ->
                        val received =
                            CompletableFuture<com.openai.models.responses.ResponsesServerEvent>()
                        val interruptPreserved = java.util.concurrent.atomic.AtomicBoolean()
                        val reader = Thread {
                            try {
                                val value = connection.receive()
                                interruptPreserved.set(Thread.currentThread().isInterrupted)
                                received.complete(value)
                            } catch (error: Throwable) {
                                received.completeExceptionally(error)
                            }
                        }
                        reader.isDaemon = true
                        reader.start()
                        val waitingDeadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                        while (
                            reader.state != Thread.State.WAITING &&
                                System.nanoTime() < waitingDeadline
                        ) Thread.sleep(1)
                        assertThat(reader.state).isEqualTo(Thread.State.WAITING)
                        emit.countDown()
                        val delivery = callbacks.poll(5, TimeUnit.SECONDS)!!
                        reader.interrupt()
                        val interruptDeadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                        while (
                            reader.isAlive &&
                                reader.isInterrupted &&
                                System.nanoTime() < interruptDeadline
                        ) Thread.sleep(1)
                        delivery.run()
                        assertThat(received.get(5, TimeUnit.SECONDS).responseCompleted())
                            .isPresent()
                        reader.join(5000)
                        assertThat(reader.isAlive).isFalse()
                        assertThat(interruptPreserved).isTrue()
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `cancellation during TLS socket creation cannot leave a later connection open`() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val delegate = javax.net.ssl.SSLSocketFactory.getDefault() as javax.net.ssl.SSLSocketFactory
        val factory =
            object : javax.net.ssl.SSLSocketFactory() {
                private fun awaitRelease() {
                    entered.countDown()
                    check(release.await(5, TimeUnit.SECONDS))
                }

                override fun getDefaultCipherSuites() = delegate.defaultCipherSuites

                override fun getSupportedCipherSuites() = delegate.supportedCipherSuites

                override fun createSocket(): Socket {
                    awaitRelease()
                    return delegate.createSocket()
                }

                override fun createSocket(
                    socket: Socket,
                    host: String,
                    port: Int,
                    autoClose: Boolean,
                ): Socket {
                    awaitRelease()
                    return delegate.createSocket(socket, host, port, autoClose)
                }

                override fun createSocket(host: String, port: Int) =
                    delegate.createSocket(host, port)

                override fun createSocket(
                    host: String,
                    port: Int,
                    local: java.net.InetAddress,
                    localPort: Int,
                ) = delegate.createSocket(host, port, local, localPort)

                override fun createSocket(host: java.net.InetAddress, port: Int) =
                    delegate.createSocket(host, port)

                override fun createSocket(
                    host: java.net.InetAddress,
                    port: Int,
                    local: java.net.InetAddress,
                    localPort: Int,
                ) = delegate.createSocket(host, port, local, localPort)
            }
        val trustFactory =
            javax.net.ssl.TrustManagerFactory.getInstance(
                javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()
            )
        trustFactory.init(null as java.security.KeyStore?)
        val trust =
            trustFactory.trustManagers.filterIsInstance<javax.net.ssl.X509TrustManager>().single()
        ServerSocket(0).use { origin ->
            origin.soTimeout = 5000
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-key")
                    .baseUrl("https://localhost:${origin.localPort}/v1")
                    .sslSocketFactory(factory)
                    .trustManager(trust)
                    .build()
            try {
                val future = client.responses().connect()
                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(future.cancel(false)).isTrue()
                release.countDown()
                origin.accept().use { socket ->
                    socket.soTimeout = 5000
                    assertThat(socket.getInputStream().read()).isEqualTo(-1)
                }
            } finally {
                release.countDown()
                client.close()
            }
        }
    }

    @Test
    fun `TLS hostname mismatch sends no authorization handshake`() {
        val certificate =
            okhttp3.tls.HeldCertificate.Builder().addSubjectAlternativeName("localhost").build()
        val serverTls =
            okhttp3.tls.HandshakeCertificates.Builder().heldCertificate(certificate).build()
        val clientTls =
            okhttp3.tls.HandshakeCertificates.Builder()
                .addTrustedCertificate(certificate.certificate)
                .build()
        okhttp3.mockwebserver.MockWebServer().use { server ->
            server.useHttps(serverTls.sslSocketFactory(), false)
            server.start()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-key")
                    .baseUrl(server.url("/v1").newBuilder().host("127.0.0.1").build().toString())
                    .sslSocketFactory(clientTls.sslSocketFactory())
                    .trustManager(clientTls.trustManager)
                    .build()
            try {
                assertThatThrownBy { client.responses().connect().get(3, TimeUnit.SECONDS) }
                    .isInstanceOf(java.util.concurrent.ExecutionException::class.java)
                assertThat(server.takeRequest(200, TimeUnit.MILLISECONDS)).isNull()
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun `a lane protocol error does not stop another lane or a later response`() {
        val emit = CountDownLatch(1)
        Peer { socket, _ ->
                assertThat(emit.await(5, TimeUnit.SECONDS)).isTrue()
                send(
                    socket,
                    """{"type":"error","stream_id":"a","error":{"type":"invalid_request_error","code":"bad_input","message":"synthetic"}}""",
                )
                send(socket, event("response.completed", "b"))
                readMessage(socket)
                send(socket, event("response.completed", "a"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClientAsync.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                        val a = connection.lane("a")
                        val b = connection.lane("b")
                        val failed = a.finalResponse()
                        val succeeded = b.finalResponse()
                        emit.countDown()
                        assertThatThrownBy { failed.get(5, TimeUnit.SECONDS) }
                            .hasCauseInstanceOf(
                                com.openai.core.http.ResponseWebSocketException::class.java
                            )
                            .hasCauseInstanceOf(com.openai.errors.OpenAIException::class.java)
                        assertThat(succeeded.get(5, TimeUnit.SECONDS).id()).isEqualTo("resp_123")
                        a.send(command())
                        assertThat(a.finalResponse().get(5, TimeUnit.SECONDS).id())
                            .isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `provider authenticator sees and signs the complete handshake request`() {
        Peer { socket, headers ->
                assertThat(headers["authorization"]).isEqualTo("signed-fake")
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val options =
                    com.openai.core.ClientOptions.builder()
                        .httpClient(OkHttpClient.builder().build())
                        .baseUrl(peer.url)
                        .httpRequestAuthenticator(
                            object : com.openai.core.http.HttpRequestAuthenticator {
                                override fun authenticate(
                                    request: com.openai.core.http.HttpRequest
                                ): com.openai.core.http.HttpRequest {
                                    assertThat(request.method)
                                        .isEqualTo(com.openai.core.http.HttpMethod.GET)
                                    assertThat(request.pathSegments).containsExactly("responses")
                                    return request
                                        .toBuilder()
                                        .replaceHeaders("Authorization", "signed-fake")
                                        .build()
                                }
                            }
                        )
                        .build()
                val client = com.openai.client.OpenAIClientImpl(options)
                try {
                    client.responses().connect().use {
                        assertThat(it.finalResponse().id()).isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `workflow recipes preserve tool lineage fork readiness and compacted input`() {
        val window =
            """[{"type":"message","role":"user","content":[{"type":"input_text","text":"Keep this context"}]},{"type":"compaction","id":"cmp_item","encrypted_content":"opaque","future_field":"retain"}]"""
        val expected =
            listOf(
                """{"type":"response.create","model":"gpt-4o-mini","input":"hello"}""",
                """{"type":"response.create","model":"gpt-4o-mini","previous_response_id":"resp_123","input":[{"type":"function_call_output","call_id":"call_1","output":"42"}],"context_management":[{"type":"compaction","compact_threshold":20000}]}""",
                """{"type":"response.create","model":"gpt-4o-mini","previous_response_id":"resp_parent","input":"Explore another approach.","store":false,"stream_id":"fork"}""",
                """{"type":"response.create","model":"gpt-4o-mini","previous_response_id":"resp_parent","input":"Advance source"}""",
                """{"type":"response.create","model":"gpt-4o-mini","input":$window}""",
            )
        val replies =
            listOf(
                listOf(
                    event("response.completed")
                        .replace(
                            "\"output\":[]",
                            """"output":[{"type":"function_call","id":"fc_1","call_id":"call_1","name":"lookup","arguments":"{}","status":"completed"}]""",
                        )
                ),
                listOf(event("response.completed").replace("resp_123", "resp_parent")),
                listOf(event("response.created", "fork"), event("response.in_progress", "fork")),
                listOf(event("response.completed"), event("response.completed", "fork")),
                listOf(event("response.completed").replace("resp_123", "resp_fresh")),
            )
        Peer { socket, _ ->
                expected.indices.forEach { step ->
                    assertThat(mapper.readTree(readMessage(socket)))
                        .describedAs("workflow request %s", step)
                        .isEqualTo(mapper.readTree(expected[step]))
                    replies[step].forEach { send(socket, it) }
                }
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        connection.send(command())
                        val previous = connection.finalResponse()
                        val output =
                            com.openai.models.responses.ResponseInputItem.ofFunctionCallOutput(
                                com.openai.models.responses.ResponseInputItem.FunctionCallOutput
                                    .builder()
                                    .callId(previous.output()[0].asFunctionCall().callId())
                                    .output("42")
                                    .build()
                            )
                        connection.send(
                            ResponsesClientEvent.ofResponseCreate(
                                ResponsesClientEvent.ResponseCreate.builder()
                                    .model("gpt-4o-mini")
                                    .previousResponseId(previous.id())
                                    .inputOfResponse(listOf(output))
                                    .addContextManagement(
                                        ResponsesClientEvent.ResponseCreate.ContextManagement
                                            .builder()
                                            .type("compaction")
                                            .compactThreshold(20000L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        val parent = connection.finalResponse()
                        connection.lane("fork").use { fork ->
                            fork.send(
                                ResponsesClientEvent.ofResponseCreate(
                                    ResponsesClientEvent.ResponseCreate.builder()
                                        .model("gpt-4o-mini")
                                        .store(false)
                                        .previousResponseId(parent.id())
                                        .input("Explore another approach.")
                                        .build()
                                )
                            )
                            while (true) {
                                val ready = fork.receive()
                                if (ready.isError())
                                    throw com.openai.core.http.ResponseWebSocketException(ready)
                                if (ready.isResponseInProgress()) break
                                check(
                                    !ready.isResponseCompleted() &&
                                        !ready.isResponseFailed() &&
                                        !ready.isResponseIncomplete()
                                )
                            }
                            connection.send(
                                ResponsesClientEvent.ofResponseCreate(
                                    ResponsesClientEvent.ResponseCreate.builder()
                                        .model("gpt-4o-mini")
                                        .previousResponseId(parent.id())
                                        .input("Advance source")
                                        .build()
                                )
                            )
                            connection.finalResponse()
                            fork.finalResponse()
                        }
                        // The compaction resource ID is deliberately different from a response ID.
                        val compacted =
                            mapper.readValue(
                                """{"id":"cmp_resource","object":"response.compaction","output":$window}""",
                                com.openai.models.responses.CompactedResponse::class.java,
                            )
                        connection.send(
                            ResponsesClientEvent.ofResponseCreate(
                                ResponsesClientEvent.ResponseCreate.builder()
                                    .model("gpt-4o-mini")
                                    .input(com.openai.core.JsonValue.from(compacted.output()))
                                    .build()
                            )
                        )
                        assertThat(connection.finalResponse().id()).isEqualTo("resp_fresh")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `header only large frames do not allocate their declared payload`() {
        runProcessProbe("header-only", 20)
    }

    @Test
    fun `open transport does not prevent JVM shutdown`() {
        runProcessProbe("daemon-reader", 10)
    }

    private fun runProcessProbe(mode: String, timeoutSeconds: Long) {
        val loaderClasspath =
            generateSequence(javaClass.classLoader) { it.parent }
                .filterIsInstance<java.net.URLClassLoader>()
                .flatMap { it.urLs.asSequence() }
                .map { java.nio.file.Paths.get(it.toURI()).toString() }
                .joinToString(java.io.File.pathSeparator)
        val classpath =
            System.getProperty("java.class.path") + java.io.File.pathSeparator + loaderClasspath
        check(classpath.isNotEmpty())
        val output = java.nio.file.Files.createTempFile("responses-$mode-probe", ".log")
        try {
            val process =
                ProcessBuilder(
                        java.nio.file.Paths.get(System.getProperty("java.home"), "bin", "java")
                            .toString(),
                        "-Xmx64m",
                        "-XX:-HeapDumpOnOutOfMemoryError",
                        "-cp",
                        classpath,
                        javaClass.name,
                        mode,
                    )
                    .redirectErrorStream(true)
                    .redirectOutput(output.toFile())
                    .start()
            try {
                assertThat(process.waitFor(timeoutSeconds, TimeUnit.SECONDS)).isTrue()
                assertThat(process.exitValue())
                    .withFailMessage(
                        String(java.nio.file.Files.readAllBytes(output), Charsets.UTF_8)
                    )
                    .isZero()
            } finally {
                if (process.isAlive) process.destroyForcibly()
            }
        } finally {
            java.nio.file.Files.deleteIfExists(output)
        }
    }

    @Test
    fun `frame buffering handles split length headers and trailing partial frames`() {
        val messages =
            listOf(0, 126, 65536).map { size ->
                mapper.writeValueAsString(
                    mapOf("type" to "response.future", "payload" to "x".repeat(size))
                )
            }
        Peer { socket, _ ->
                val out = DataOutputStream(socket.getOutputStream())
                for (message in messages) {
                    val bytes = message.toByteArray(Charsets.UTF_8)
                    val header = java.io.ByteArrayOutputStream()
                    DataOutputStream(header).apply {
                        writeByte(0x81)
                        if (bytes.size < 126) writeByte(bytes.size)
                        else if (bytes.size <= 65535) {
                            writeByte(126)
                            writeShort(bytes.size)
                        } else {
                            writeByte(127)
                            writeLong(bytes.size.toLong())
                        }
                    }
                    for (byte in header.toByteArray()) {
                        out.writeByte(byte.toInt())
                        out.flush()
                    }
                    var offset = 0
                    while (offset < bytes.size) {
                        val count = minOf(997, bytes.size - offset)
                        out.write(bytes, offset, count)
                        out.flush()
                        offset += count
                    }
                }
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        messages.forEach { expected ->
                            assertThat(mapper.valueToTree<JsonNode>(connection.receive()))
                                .isEqualTo(mapper.readTree(expected))
                        }
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `explicit message limits disable compression before the native reader`() {
        for (mode in
            listOf(
                "bounded-compressed",
                "bounded-plain",
                "default-compressed",
                "bounded-unknown",
            )) {
            val bounded = mode != "default-compressed"
            val compressed = mode != "bounded-plain"
            val rejected = bounded && compressed
            val extension =
                when (mode) {
                    "bounded-plain" -> null
                    "bounded-unknown" -> "unsupported-test-extension"
                    else -> "permessage-deflate"
                }
            val text =
                mapper.writeValueAsString(
                    mapOf(
                        "type" to "response.future",
                        "payload" to "x".repeat(if (compressed) 16384 else 16),
                    )
                )
            val bytes = text.toByteArray(Charsets.UTF_8)
            val payload =
                if (compressed) {
                    val deflater = java.util.zip.Deflater(6, true)
                    try {
                        deflater.setInput(bytes)
                        val output = ByteArray(bytes.size + 64)
                        val count =
                            deflater.deflate(
                                output,
                                0,
                                output.size,
                                java.util.zip.Deflater.SYNC_FLUSH,
                            )
                        check(count >= 4)
                        output.copyOf(count - 4)
                    } finally {
                        deflater.end()
                    }
                } else bytes
            val offered = java.util.concurrent.atomic.AtomicReference<String>()
            val delivered = java.util.concurrent.atomic.AtomicInteger()
            val message = CompletableFuture<String>()
            Peer(extensions = extension) { socket, headers ->
                    offered.set(headers["sec-websocket-extensions"])
                    try {
                        send(socket, payload, if (compressed) 0xc1 else 0x81)
                        while (socket.getInputStream().read() != -1) {}
                    } catch (error: java.net.SocketException) {
                        if (!rejected) throw error
                    }
                }
                .use { peer ->
                    val client = OkHttpClient.builder().build()
                    try {
                        val opening =
                            client.connectWebSocket(
                                com.openai.core.http.HttpRequest.builder()
                                    .method(com.openai.core.http.HttpMethod.GET)
                                    .baseUrl(peer.url)
                                    .addPathSegment("responses")
                                    .build(),
                                com.openai.core.RequestOptions.none(),
                                if (bounded) 1024 else Int.MAX_VALUE,
                                object : com.openai.core.http.WebSocketClient.Listener {
                                    override fun onMessage(text: String) {
                                        delivered.incrementAndGet()
                                        message.complete(text)
                                    }

                                    override fun onClosed(code: Int) {}

                                    override fun onFailure(error: Throwable) {
                                        message.completeExceptionally(error)
                                    }
                                },
                            )
                        if (rejected) {
                            assertThatThrownBy { opening.get(5, TimeUnit.SECONDS) }
                                .hasRootCauseMessage(
                                    "WebSocket extensions are disabled when maxMessageBytes is configured"
                                )
                            assertThat(delivered.get()).isZero()
                        } else {
                            opening.get(5, TimeUnit.SECONDS).use {
                                assertThat(message.get(5, TimeUnit.SECONDS)).isEqualTo(text)
                                assertThat(delivered.get()).isEqualTo(1)
                            }
                        }
                        peer.await()
                        if (bounded) assertThat(offered.get()).isNull()
                        else assertThat(offered.get()).contains("permessage-deflate")
                    } finally {
                        client.close()
                    }
                }
        }
    }

    @Test
    fun `configured outgoing UTF-8 limit permits the exact multibyte boundary`() {
        fun create(input: String) =
            ResponsesClientEvent.ofResponseCreate(
                ResponsesClientEvent.ResponseCreate.builder()
                    .model("gpt-4o-mini")
                    .input(input)
                    .build()
            )
        val input = "é€😀".repeat(128)
        val atLimit = create(input)
        val limit = mapper.writeValueAsString(atLimit).toByteArray(Charsets.UTF_8).size
        Peer { socket, _ ->
                assertThat(mapper.readTree(readMessage(socket)).path("input").asText())
                    .isEqualTo(input)
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client
                        .responses()
                        .connect(ResponseWebSocketOptions.builder().maxMessageBytes(limit).build())
                        .use { connection ->
                            assertThatThrownBy { connection.send(create(input + "x")) }
                                .isInstanceOf(IllegalArgumentException::class.java)
                                .hasMessage("WebSocket command exceeds maxMessageBytes")
                            connection.send(atLimit)
                            assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                        }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `outgoing UTF-8 limit rejects before enqueue and permits the exact boundary`() {
        val limit = 16 * 1024 * 1024
        fun create(input: String) =
            ResponsesClientEvent.ofResponseCreate(
                ResponsesClientEvent.ResponseCreate.builder()
                    .model("gpt-4o-mini")
                    .input(input)
                    .build()
            )
        val overhead = mapper.writeValueAsBytes(create("")).size
        val input =
            "é".repeat((limit - overhead) / 2) + if ((limit - overhead) % 2 == 0) "" else "x"
        val atLimit = create(input)
        val overLimit = create(input + "x")
        assertThat(mapper.writeValueAsBytes(atLimit).size).isEqualTo(limit)
        assertThat(mapper.writeValueAsBytes(overLimit).size).isEqualTo(limit + 1)
        Peer { socket, _ ->
                assertThat(readMessage(socket).toByteArray(Charsets.UTF_8).size).isEqualTo(limit)
                send(socket, event("response.completed"))
                assertThat(mapper.readTree(readMessage(socket)).path("input").asText())
                    .isEqualTo("hello")
                send(socket, event("response.completed"))
                while (socket.getInputStream().read() != -1) {}
            }
            .use { peer ->
                val client =
                    OpenAIOkHttpClient.builder().apiKey("fake-key").baseUrl(peer.url).build()
                try {
                    client.responses().connect().use { connection ->
                        assertThatThrownBy { connection.send(overLimit) }
                            .isInstanceOf(IllegalArgumentException::class.java)
                            .hasMessageContaining("16 MiB send limit")
                        connection.send(atLimit)
                        assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                        connection.send(command())
                        assertThat(connection.finalResponse().id()).isEqualTo("resp_123")
                    }
                    peer.await()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `verbose transport logging does not include credentials or application payloads`() {
        val markers =
            listOf(
                "synthetic-bearer-marker",
                "synthetic-header-marker",
                "synthetic-request-marker",
                "synthetic-response-marker",
            )
        val captured = java.util.Collections.synchronizedList(mutableListOf<String>())
        val logger = java.util.logging.Logger.getLogger("okhttp3")
        val taskLogger =
            java.util.logging.Logger.getLogger("okhttp3.internal.concurrent.TaskRunner")
        val previousLevel = logger.level
        val previousTaskLevel = taskLogger.level
        val handler =
            object : java.util.logging.Handler() {
                    override fun publish(record: java.util.logging.LogRecord) {
                        captured.add(record.message)
                    }

                    override fun flush() {}

                    override fun close() {}
                }
                .apply { level = java.util.logging.Level.ALL }
        logger.level = java.util.logging.Level.ALL
        taskLogger.level = java.util.logging.Level.ALL
        logger.addHandler(handler)
        try {
            Peer { socket, headers ->
                    assertThat(headers["authorization"]).isEqualTo("Bearer " + markers[0])
                    assertThat(headers["x-test"]).isEqualTo(markers[1])
                    assertThat(readMessage(socket)).contains(markers[2])
                    send(socket, event("response.completed").replace("resp_123", markers[3]))
                    while (socket.getInputStream().read() != -1) {}
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClient.builder().apiKey(markers[0]).baseUrl(peer.url).build()
                    try {
                        client
                            .responses()
                            .connect(
                                ResponseWebSocketOptions.builder()
                                    .putHeader("X-Test", markers[1])
                                    .build()
                            )
                            .use { connection ->
                                connection.send(
                                    ResponsesClientEvent.ofResponseCreate(
                                        ResponsesClientEvent.ResponseCreate.builder()
                                            .model("gpt-4o-mini")
                                            .input(markers[2])
                                            .build()
                                    )
                                )
                                assertThat(connection.finalResponse().id()).isEqualTo(markers[3])
                            }
                        peer.await()
                    } finally {
                        client.close()
                    }
                }
            assertThat(captured).isNotEmpty()
            val log = synchronized(captured) { captured.joinToString("\n") }
            markers.forEach { assertThat(log).doesNotContain(it) }
        } finally {
            logger.removeHandler(handler)
            logger.level = previousLevel
            taskLogger.level = previousTaskLevel
        }
    }

    private class Peer(
        connectionCount: Int = 1,
        upgrade: (Int) -> Boolean = { true },
        extensions: String? = null,
        handler: (Socket, Map<String, String>) -> Unit,
    ) : AutoCloseable {
        private val server = ServerSocket(0, 1, java.net.InetAddress.getLoopbackAddress())
        private var socket: Socket? = null
        val url = "http://127.0.0.1:${server.localPort}/v1"
        private val done = CompletableFuture<Void>()
        private val thread =
            Thread {
                    try {
                        repeat(connectionCount) { index ->
                            server.accept().use { accepted ->
                                socket = accepted
                                accepted.soTimeout = 10000
                                val input = accepted.getInputStream()
                                val request = StringBuilder()
                                while (!request.endsWith("\r\n\r\n")) {
                                    val next = input.read()
                                    check(next != -1)
                                    request.append(next.toChar())
                                    check(request.length < 16384)
                                }
                                val lines = request.toString().split("\r\n")
                                val headers =
                                    lines
                                        .drop(1)
                                        .filter { it.contains(':') }
                                        .associate {
                                            it.substringBefore(':').lowercase() to
                                                it.substringAfter(':').trim()
                                        }
                                        .toMutableMap()
                                headers["request"] = lines.first()
                                val digest =
                                    MessageDigest.getInstance("SHA-1")
                                        .digest(
                                            (headers.getValue("sec-websocket-key") +
                                                    "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")
                                                .toByteArray(StandardCharsets.US_ASCII)
                                        )
                                val extensionHeader =
                                    extensions?.let { "Sec-WebSocket-Extensions: $it\r\n" } ?: ""
                                if (upgrade(index))
                                    accepted
                                        .getOutputStream()
                                        .write(
                                            ("HTTP/1.1 101 Switching Protocols\r\nUpgrade: websocket\r\nConnection: Upgrade\r\nSec-WebSocket-Accept: ${Base64.getEncoder().encodeToString(digest)}\r\n${extensionHeader}\r\n")
                                                .toByteArray(StandardCharsets.US_ASCII)
                                        )
                                accepted.getOutputStream().flush()
                                handler(accepted, headers)
                            }
                        }
                        done.complete(null)
                    } catch (error: Throwable) {
                        done.completeExceptionally(error)
                    }
                }
                .apply {
                    isDaemon = true
                    start()
                }

        fun await() {
            done.get(12, TimeUnit.SECONDS)
        }

        override fun close() {
            socket?.close()
            server.close()
            thread.join(1000)
        }
    }

    companion object {
        // A separate bounded-heap process keeps an allocation regression from
        // exhausting the test worker. This uses the actual default connection.
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.contentEquals(arrayOf("daemon-reader"))) {
                val peer = Peer { socket, _ -> while (socket.getInputStream().read() != -1) {} }
                val client = OkHttpClient.builder().build()
                Runtime.getRuntime()
                    .addShutdownHook(
                        Thread {
                            client.close()
                            peer.close()
                        }
                    )
                client
                    .connectWebSocket(
                        com.openai.core.http.HttpRequest.builder()
                            .method(com.openai.core.http.HttpMethod.GET)
                            .baseUrl(peer.url)
                            .addPathSegment("responses")
                            .build(),
                        com.openai.core.RequestOptions.none(),
                        Int.MAX_VALUE,
                        object : com.openai.core.http.WebSocketClient.Listener {
                            override fun onMessage(text: String) {}

                            override fun onClosed(code: Int) {}

                            override fun onFailure(error: Throwable) {}
                        },
                    )
                    .get(5, TimeUnit.SECONDS)
                return
            }
            check(args.contentEquals(arrayOf("header-only")))
            Thread.setDefaultUncaughtExceptionHandler { _, error ->
                error.printStackTrace()
                System.exit(3)
            }
            val connected = CountDownLatch(1)
            Peer { socket, _ ->
                    check(connected.await(5, TimeUnit.SECONDS))
                    val out = DataOutputStream(socket.getOutputStream())
                    out.writeByte(0x81)
                    out.writeByte(127)
                    out.writeLong(512L * 1024 * 1024)
                    out.flush()
                    // EOF after the header proves the reader processed it, without
                    // waiting for a timeout or sending any of the declared payload.
                }
                .use { peer ->
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-key")
                            .baseUrl(peer.url)
                            .build()
                    try {
                        client.responses().connect().get(5, TimeUnit.SECONDS).use { connection ->
                            val pending = connection.receive()
                            connected.countDown()
                            try {
                                pending.get(5, TimeUnit.SECONDS)
                                error("An incomplete frame cannot produce an event")
                            } catch (expected: java.util.concurrent.ExecutionException) {
                                check(expected.cause is Exception)
                            }
                        }
                        peer.await()
                    } finally {
                        client.close()
                    }
                }
        }

        private fun send(socket: Socket, text: String, first: Int = 0x81) =
            send(socket, text.toByteArray(Charsets.UTF_8), first)

        private fun send(socket: Socket, bytes: ByteArray, first: Int) {
            val out = DataOutputStream(socket.getOutputStream())
            out.writeByte(first)
            if (bytes.size < 126) out.writeByte(bytes.size)
            else if (bytes.size <= 65535) {
                out.writeByte(126)
                out.writeShort(bytes.size)
            } else {
                out.writeByte(127)
                out.writeLong(bytes.size.toLong())
            }
            out.write(bytes)
            out.flush()
        }

        private fun readMessage(
            socket: Socket,
            opcode: Int = 0x81,
            firstByte: Int? = null,
        ): String {
            val input = DataInputStream(socket.getInputStream())
            assertThat(firstByte ?: input.readUnsignedByte()).isEqualTo(opcode)
            val sizeByte = input.readUnsignedByte()
            val size =
                when (sizeByte and 127) {
                    126 -> input.readUnsignedShort()
                    127 -> input.readLong().toInt()
                    else -> sizeByte and 127
                }
            assertThat(sizeByte and 128).isEqualTo(128)
            val mask = ByteArray(4)
            input.readFully(mask)
            val bytes = ByteArray(size)
            input.readFully(bytes)
            bytes.indices.forEach {
                bytes[it] = (bytes[it].toInt() xor mask[it % 4].toInt()).toByte()
            }
            return String(bytes, Charsets.UTF_8)
        }
    }
}
