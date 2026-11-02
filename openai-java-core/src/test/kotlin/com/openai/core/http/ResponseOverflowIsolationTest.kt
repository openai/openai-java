package com.openai.core.http

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesServerEvent
import java.io.IOException
import java.util.ArrayDeque
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(20)
class ResponseOverflowIsolationTest {
    private fun frame(id: String?, text: String, sequence: Int = 0): String =
        jsonMapper()
            .createObjectNode()
            .apply {
                put("type", "response.output_text.delta")
                put("sequence_number", sequence)
                put("item_id", "item_fixture")
                put("output_index", 0)
                put("content_index", 0)
                put("delta", text)
                if (id != null) put("stream_id", id)
                putObject("future_metadata").put("retained", true)
            }
            .toString()

    private fun delta(event: ResponsesServerEvent): String =
        jsonMapper().valueToTree<JsonNode>(event).path("delta").asText()

    private fun cause(result: CompletableFuture<*>): Throwable {
        try {
            result.get(3, TimeUnit.SECONDS)
            throw AssertionError("Expected a failed receive")
        } catch (error: ExecutionException) {
            return checkNotNull(error.cause)
        }
    }

    @Test
    fun `opt in reclaims event and byte backlogs and drops later failed ID frames`() {
        for (bytes in listOf(false, true)) {
            val slow0 = frame("slow", "界".repeat(80))
            val slow1 = frame("slow", "界".repeat(80), 1)
            val fastFrame = frame("fast", "metadata survives", 2)
            val builder = ResponseWebSocketOptions.builder().isolateLaneOverflow(true)
            if (bytes) {
                builder.maxQueuedBytes(
                    listOf(slow0, slow1, fastFrame).sumOf {
                        it.toByteArray(Charsets.UTF_8).size.toLong()
                    } - 1
                )
            } else builder.maxQueuedEvents(2)
            Fixture(builder.build()).use { fixture ->
                val slow = fixture.connection.lane("slow")
                val fast = fixture.connection.lane("fast")
                listOf(slow0, slow1, fastFrame).forEach { fixture.listener.onMessage(it) }
                val event = fast.receive().get(3, TimeUnit.SECONDS)
                assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(event)))
                    .isEqualTo(jsonMapper().readTree(fastFrame))
                val first = cause(slow.receive())
                assertThat(first).isInstanceOf(IOException::class.java)
                slow.close()
                assertThat(cause(slow.receive())).isSameAs(first)
                assertThatThrownBy { slow.send(command()) }.isSameAs(first)
                assertThatThrownBy { fixture.connection.lane("slow") }
                    .hasMessageContaining("reserved")
                fixture.listener.onMessage(frame("slow", "late frame"))
                fixture.listener.onMessage(frame(null, "default survives"))
                assertThat(delta(fixture.connection.receive().get(3, TimeUnit.SECONDS)))
                    .isEqualTo("default survives")
                assertThat(fixture.transport.closes).isZero()
            }
        }
    }

    @Test
    fun `equal backlogs select the earliest registration`() {
        Fixture(
                ResponseWebSocketOptions.builder()
                    .isolateLaneOverflow(true)
                    .maxQueuedEvents(2)
                    .build()
            )
            .use { fixture ->
                val first = fixture.connection.lane("z-first")
                val second = fixture.connection.lane("a-second")
                val incoming = fixture.connection.lane("incoming")
                listOf("z-first", "a-second", "incoming").forEachIndexed { index, id ->
                    fixture.listener.onMessage(frame(id, id, index))
                }
                assertThat(cause(first.receive())).isInstanceOf(IOException::class.java)
                assertThat(delta(second.receive().get(3, TimeUnit.SECONDS))).isEqualTo("a-second")
                assertThat(delta(incoming.receive().get(3, TimeUnit.SECONDS))).isEqualTo("incoming")
                assertThat(fixture.transport.closes).isZero()
            }
    }

    @Test
    fun `default lane overflow leaves named delivery and raw writes available`() {
        Fixture(
                ResponseWebSocketOptions.builder()
                    .isolateLaneOverflow(true)
                    .maxQueuedEvents(1)
                    .build()
            )
            .use { fixture ->
                val named = fixture.connection.lane("named")
                fixture.listener.onMessage(frame(null, "older default"))
                fixture.listener.onMessage(frame("named", "survives", 1))
                assertThat(cause(fixture.connection.receive()))
                    .isInstanceOf(IOException::class.java)
                assertThat(delta(named.receive().get(3, TimeUnit.SECONDS))).isEqualTo("survives")
                fixture.connection.send(command())
                assertThat(fixture.transport.sends).isEqualTo(1)
                assertThat(fixture.transport.closes).isZero()
            }
    }

    @Test
    fun `oversized incoming frame wakes only its waiting lane`() {
        Fixture(
                ResponseWebSocketOptions.builder()
                    .isolateLaneOverflow(true)
                    .maxQueuedBytes(512)
                    .build()
            )
            .use { fixture ->
                val lane = fixture.connection.lane("oversized")
                val waiting = lane.receive()
                assertThat(waiting.isDone).isFalse()
                fixture.listener.onMessage(frame("oversized", "x".repeat(1024)))
                assertThat(cause(waiting)).isInstanceOf(IOException::class.java)
                fixture.listener.onMessage(frame(null, "healthy"))
                assertThat(delta(fixture.connection.receive().get(3, TimeUnit.SECONDS)))
                    .isEqualTo("healthy")
                assertThat(fixture.transport.closes).isZero()
            }
    }

    @Test
    fun `eviction does not revoke a claimed callback or reclaim its bytes twice`() {
        val claimedFrame = frame("claimed", "c".repeat(1000))
        val slowFrame = frame("slow", "s".repeat(200), 1)
        val fastFrame = frame("healthy", "h".repeat(200), 2)
        val maximum =
            listOf(claimedFrame, slowFrame, fastFrame).sumOf {
                it.toByteArray(Charsets.UTF_8).size.toLong()
            } - 1
        Fixture(
                ResponseWebSocketOptions.builder()
                    .isolateLaneOverflow(true)
                    .maxQueuedBytes(maximum)
                    .build()
            )
            .use { fixture ->
                val claimed = fixture.connection.lane("claimed")
                val slow = fixture.connection.lane("slow")
                val healthy = fixture.connection.lane("healthy")
                val result = claimed.receive()
                var completions = 0
                result.thenAccept { completions += 1 }
                fixture.executor.defer = true
                listOf(claimedFrame, slowFrame, fastFrame).forEach {
                    fixture.listener.onMessage(it)
                }
                assertThat(result.isDone).isFalse()
                assertThat(cause(slow.receive())).isInstanceOf(IOException::class.java)
                assertThat(delta(healthy.receive().get(3, TimeUnit.SECONDS)))
                    .isEqualTo("h".repeat(200))
                fixture.executor.flush()
                assertThat(delta(result.get(3, TimeUnit.SECONDS))).isEqualTo("c".repeat(1000))
                assertThat(completions).isEqualTo(1)
                val next = claimed.receive()
                assertThat(next.isDone).isFalse()
                assertThat(next.cancel(false)).isTrue()
                // These frames exceed the actual byte budget unless the first callback was
                // reclaimed twice.
                fixture.listener.onMessage(frame("healthy", "p".repeat(600), 3))
                fixture.listener.onMessage(frame("healthy", "p".repeat(600), 4))
                fixture.listener.onMessage(frame(null, "d".repeat(600), 5))
                assertThat(cause(healthy.receive())).isInstanceOf(IOException::class.java)
                assertThat(delta(fixture.connection.receive().get(3, TimeUnit.SECONDS)))
                    .isEqualTo("d".repeat(600))
                assertThat(completions).isEqualTo(1)
                assertThat(fixture.transport.closes).isZero()
            }
    }

    @Test
    fun `evicting a lane preserves its already claimed event`() {
        Fixture(
                ResponseWebSocketOptions.builder()
                    .isolateLaneOverflow(true)
                    .maxQueuedEvents(2)
                    .build()
            )
            .use { fixture ->
                val victim = fixture.connection.lane("victim")
                val healthy = fixture.connection.lane("healthy")
                val assigned = victim.receive()
                fixture.executor.defer = true
                fixture.listener.onMessage(frame("victim", "assigned"))
                fixture.listener.onMessage(frame("victim", "queued", 1))
                fixture.listener.onMessage(frame("healthy", "survives", 2))
                assertThat(delta(healthy.receive().get(3, TimeUnit.SECONDS))).isEqualTo("survives")
                val first = cause(victim.receive())
                assertThat(assigned.isDone).isFalse()
                fixture.executor.flush()
                assertThat(delta(assigned.get(3, TimeUnit.SECONDS))).isEqualTo("assigned")
                assertThat(cause(victim.receive())).isSameAs(first)
                // Exact event capacity remains available after the claimed callback completes.
                repeat(3) { fixture.listener.onMessage(frame("healthy", "next", it + 3)) }
                assertThat(cause(healthy.receive())).isInstanceOf(IOException::class.java)
                assertThat(fixture.transport.closes).isZero()
            }
    }

    @Test
    fun `reconnect releases failed IDs while old handles retain their first error`() {
        Fixture(
                ResponseWebSocketOptions.builder()
                    .isolateLaneOverflow(true)
                    .maxQueuedEvents(1)
                    .build()
            )
            .use { fixture ->
                val retired = fixture.connection.lane("retired")
                val healthy = fixture.connection.lane("healthy")
                fixture.listener.onMessage(frame("retired", "older"))
                fixture.listener.onMessage(frame("healthy", "survives", 1))
                val first = cause(retired.receive())
                assertThat(delta(healthy.receive().get(3, TimeUnit.SECONDS))).isEqualTo("survives")
                fixture.connection
                    .reconnect(
                        ResponseWebSocketOptions.builder()
                            .isolateLaneOverflow(true)
                            .maxLanes(1)
                            .build()
                    )
                    .get(3, TimeUnit.SECONDS)
                assertThat(cause(retired.receive())).isSameAs(first)
                assertThatThrownBy { retired.send(command()) }.isSameAs(first)
                fixture.listener.onMessage(frame("healthy", "same healthy handle", 2))
                assertThat(delta(healthy.receive().get(3, TimeUnit.SECONDS)))
                    .isEqualTo("same healthy handle")
                healthy.close()
                fixture.connection.reconnect().get(3, TimeUnit.SECONDS)
                val replacement = fixture.connection.lane("retired")
                fixture.listener.onMessage(frame("retired", "new handle", 3))
                assertThat(delta(replacement.receive().get(3, TimeUnit.SECONDS)))
                    .isEqualTo("new handle")
                assertThat(cause(retired.receive())).isSameAs(first)
            }
    }

    @Test
    fun `overflow remains fatal by default and decoder failures stay global when opted in`() {
        Fixture(ResponseWebSocketOptions.builder().maxQueuedEvents(1).build()).use { fixture ->
            val first = fixture.connection.lane("first")
            val second = fixture.connection.lane("second")
            fixture.listener.onMessage(frame("first", "accepted"))
            fixture.listener.onMessage(frame("second", "overflow", 1))
            val failure = cause(second.receive())
            assertThat(delta(first.receive().get(3, TimeUnit.SECONDS))).isEqualTo("accepted")
            assertThat(cause(first.receive())).isSameAs(failure)
            assertThat(cause(fixture.connection.receive())).isSameAs(failure)
            assertThat(fixture.transport.closes).isEqualTo(1)
        }
        Fixture(ResponseWebSocketOptions.builder().isolateLaneOverflow(true).build()).use { fixture
            ->
            val lane = fixture.connection.lane("named")
            val waiting = lane.receive()
            fixture.listener.onMessage("not JSON")
            val failure = cause(waiting)
            assertThat(cause(fixture.connection.receive())).isSameAs(failure)
            assertThat(fixture.transport.closes).isEqualTo(1)
        }
    }

    private fun command() =
        jsonMapper()
            .readValue(
                """{"type":"response.create","input":"fixture"}""",
                com.openai.models.responses.ResponsesClientEvent::class.java,
            )

    private class DeferredExecutor : Executor {
        var defer = false
        private val pending = ArrayDeque<Runnable>()

        override fun execute(command: Runnable) {
            if (defer) pending.add(command) else command.run()
        }

        fun flush() {
            while (pending.isNotEmpty()) pending.removeFirst().run()
        }
    }

    private class Fixture(limits: ResponseWebSocketOptions) : AutoCloseable {
        val executor = DeferredExecutor()
        val transport = FixtureTransport()
        val options =
            ClientOptions.builder()
                .apiKey("fake-key")
                .httpClient(transport)
                .streamHandlerExecutor(executor)
                .build()
        val connection = AsyncResponseConnection.connect(options, limits).get(3, TimeUnit.SECONDS)
        val listener
            get() = transport.listener

        override fun close() {
            executor.flush()
            connection.close()
            executor.flush()
            options.close()
        }
    }

    private class FixtureTransport : HttpClient, WebSocketClient {
        lateinit var listener: WebSocketClient.Listener
        var closes = 0
        var sends = 0

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            this.listener = listener
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {
                        sends += 1
                    }

                    override fun close() {
                        closes += 1
                    }
                }
            )
        }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            throw AssertionError("Unexpected HTTP")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = throw AssertionError("Unexpected HTTP")

        override fun close() {}
    }
}
