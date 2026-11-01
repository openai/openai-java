package com.openai.client.okhttp

import com.openai.core.http.AsyncResponseConnection
import com.openai.core.http.ResponseCollectionLimitException
import com.openai.core.http.ResponseWebSocketException
import com.openai.core.http.ResponseWebSocketOptions
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesClientEvent
import java.nio.charset.StandardCharsets.UTF_8
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit.SECONDS
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(30)
@org.junit.jupiter.api.parallel.Execution(org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD)
internal class ResponsesManagedCollectionTest {
    private val mapper = jsonMapper()
    private val command =
        mapper.readValue(
            """{"type":"response.create","model":"fixture-model","input":"synthetic"}""",
            ResponsesClientEvent::class.java,
        )

    private class Peer : AutoCloseable {
        val server = MockWebServer()
        val sockets = LinkedBlockingQueue<WebSocket>()
        val commands = LinkedBlockingQueue<String>()
        private var socket: WebSocket? = null

        init {
            prepare()
            server.start(java.net.InetAddress.getByName("127.0.0.1"), 0)
        }

        fun prepare() {
            server.enqueue(
                MockResponse()
                    .withWebSocketUpgrade(
                        object : WebSocketListener() {
                            override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
                                sockets.add(webSocket)
                            }

                            override fun onMessage(webSocket: WebSocket, text: String) {
                                commands.add(text)
                            }
                        }
                    )
            )
        }

        fun select() {
            socket = checkNotNull(sockets.poll(5, SECONDS))
        }

        fun send(frame: String) {
            assertThat(checkNotNull(socket).send(frame)).isTrue()
        }

        fun abort() {
            checkNotNull(socket).close(1000, "synthetic close")
        }

        override fun close() {
            server.shutdown()
        }
    }

    private fun response(id: String, status: String, output: String? = "[]") =
        """{"id":"$id","object":"response","created_at":1.0,"model":"fixture-model","status":"$status","parallel_tool_calls":false,"tool_choice":"auto","tools":[]${output?.let { ",\"output\":$it" } ?: ""}}"""

    private fun bearing(type: String, id: String, lane: String? = "a", output: String? = "[]") =
        """{"type":"response.$type","sequence_number":0${lane?.let { ",\"stream_id\":\"$it\"" } ?: ""},"response":${response(id, if (type == "created") "in_progress" else type, output)}}"""

    private fun done(lane: String = "a", id: String = "f", index: Long = 0, extra: String = "") =
        """{"type":"response.output_item.done","sequence_number":1,"stream_id":"$lane","output_index":$index,"item":{"id":"$id","type":"function_call","call_id":"call_$id","name":"never_run","arguments":"{}"$extra}}"""

    private fun managed(budget: Long = 100_000, block: (Peer, AsyncResponseConnection) -> Unit) {
        Peer().use { peer ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("fake-key")
                    .baseUrl(peer.server.url("/").toString())
                    .build()
            try {
                client
                    .async()
                    .responses()
                    .connect(ResponseWebSocketOptions.builder().maxResponseBytes(budget).build())
                    .get(5, SECONDS)
                    .use { connection ->
                        peer.select()
                        block(peer, connection)
                    }
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun rawTerminalCanBeCollectedOnceAndNextTurnStartsFresh() = managed { peer, connection ->
        val lane = connection.lane("a")
        lane.send(command)
        peer.send(bearing("created", "first"))
        peer.send(done(id = "first"))
        // Missing terminal output is explicit compatibility coverage, not schema-valid service
        // output.
        peer.send(bearing("completed", "first", output = null))
        repeat(3) { lane.receive().get(5, SECONDS) }
        val first = lane.finalResponse().get(5, SECONDS)
        assertThat(first.output().single().asFunctionCall().id().get()).isEqualTo("first")
        val next = lane.finalResponse()
        assertThat(next.isDone).isFalse()
        assertThat(next.cancel(false)).isTrue()
        lane.send(command)
        peer.send(bearing("created", "second"))
        peer.send(done(id = "second", index = 7))
        peer.send(bearing("completed", "second", output = null))
        repeat(3) { lane.receive().get(5, SECONDS) }
        assertThat(
                lane.finalResponse().get(5, SECONDS).output().single().asFunctionCall().id().get()
            )
            .isEqualTo("second")
        assertThat(first.output().single().asFunctionCall().id().get()).isEqualTo("first")
    }

    @Test
    fun cancellingIdleReceiveAndFinalHelperPreservesPreviouslyConsumedItems() =
        managed { peer, connection ->
            val lane = connection.lane("a")
            peer.send(bearing("created", "r"))
            peer.send(done())
            repeat(2) { lane.receive().get(5, SECONDS) }
            assertThat(lane.receive().cancel(false)).isTrue()
            val helper = lane.finalResponse()
            assertThat(helper.cancel(false)).isTrue()
            peer.send(bearing("completed", "r", output = "null"))
            assertThat(
                    lane
                        .finalResponse()
                        .get(5, SECONDS)
                        .output()
                        .single()
                        .asFunctionCall()
                        .id()
                        .get()
                )
                .isEqualTo("f")
        }

    @Test
    fun exactUtf8BudgetIsAdmittedAndOverflowIsLocalToCollection() {
        val frames =
            listOf(
                bearing("created", "r"),
                done(extra = ",\"metadata\":{\"values\":[\"é😀\"]}"),
                bearing("completed", "r", output = null),
            )
        val bytes = frames.sumOf { it.toByteArray(UTF_8).size.toLong() }
        for (budget in listOf(bytes, bytes - 1)) managed(budget) { peer, connection ->
            val a = connection.lane("a")
            val b = connection.lane("b")
            frames.forEach(peer::send)
            repeat(3) { a.receive().get(5, SECONDS) }
            if (budget == bytes) assertThat(a.finalResponse().get(5, SECONDS).output()).hasSize(1)
            else {
                assertThatThrownBy { a.finalResponse().get(5, SECONDS) }
                    .hasCauseInstanceOf(ResponseCollectionLimitException::class.java)
                peer.send("""{"type":"response.future","stream_id":"a","opaque":true}""")
                assertThat(a.receive().get(5, SECONDS)._json()).isPresent()
                peer.send(bearing("created", "reset"))
                peer.send(bearing("completed", "reset"))
                repeat(2) { a.receive().get(5, SECONDS) }
                assertThat(a.finalResponse().get(5, SECONDS).id()).isEqualTo("reset")
            }
            peer.send(bearing("completed", "neighbor", "b"))
            assertThat(b.finalResponse().get(5, SECONDS).id()).isEqualTo("neighbor")
        }
    }

    @Test
    fun queuedSuccessorDoesNotReplaceTheConsumedParentsCache() = managed { peer, connection ->
        val a = connection.lane("a")
        val barrier = connection.lane("b")
        peer.send(bearing("created", "parent"))
        peer.send(bearing("completed", "parent"))
        repeat(2) { a.receive().get(5, SECONDS) }
        peer.send(bearing("created", "successor"))
        peer.send(done(id = "next"))
        peer.send(bearing("completed", "successor", output = null))
        peer.send("""{"type":"response.barrier","stream_id":"b"}""")
        barrier.receive().get(5, SECONDS) // The shared reader has queued all successor frames.
        assertThat(a.finalResponse().get(5, SECONDS).id()).isEqualTo("parent")
        assertThat(a.finalResponse().get(5, SECONDS).id()).isEqualTo("successor")
    }

    @Test
    fun consumedCreatedResetsCachedFinalAndUnknownItemsCannotBeMutated() =
        managed { peer, connection ->
            val a = connection.lane("a")
            peer.send(bearing("completed", "old"))
            a.receive().get(5, SECONDS)
            peer.send(bearing("created", "new"))
            a.receive().get(5, SECONDS)
            val waiting = a.finalResponse()
            assertThat(waiting.isDone).isFalse()
            assertThat(waiting.cancel(false)).isTrue()
            peer.send(
                """{"type":"response.output_item.done","sequence_number":1,"stream_id":"a","output_index":3,"item":{"type":"future_tool","metadata":{"values":["original"]}}}"""
            )
            val raw = a.receive().get(5, SECONDS)
            val json = raw.asResponseOutputItemDone().item()._json().get()
            val values =
                json
                    .asObject()
                    .get()
                    .getValue("metadata")
                    .asObject()
                    .get()
                    .getValue("values")
                    .asArray()
                    .get()
            assertThatThrownBy { (values as MutableList<*>).clear() }
                .isInstanceOf(UnsupportedOperationException::class.java)
            peer.send(bearing("completed", "new", output = null))
            a.receive().get(5, SECONDS)
            val result = a.finalResponse().get(5, SECONDS)
            assertThat(
                    mapper
                        .valueToTree<com.fasterxml.jackson.databind.JsonNode>(result)
                        .path("output")
                        .get(0)
                        .path("metadata")
                        .path("values")
                        .get(0)
                        .asText()
                )
                .isEqualTo("original")
            assertThatThrownBy { (result.output() as MutableList<*>).clear() }
                .isInstanceOf(UnsupportedOperationException::class.java)
        }

    @Test
    fun protocolErrorDoesNotBecomeSuccessAndDoesNotPoisonNeighbor() = managed { peer, connection ->
        val a = connection.lane("a")
        val b = connection.lane("b")
        peer.send(bearing("created", "r"))
        peer.send(done())
        peer.send("""{"type":"error","stream_id":"a","error":{"message":"synthetic"}}""")
        repeat(3) { a.receive().get(5, SECONDS) }
        assertThatThrownBy { a.finalResponse().get(5, SECONDS) }
            .hasCauseInstanceOf(ResponseWebSocketException::class.java)
        peer.send(bearing("completed", "b", "b"))
        assertThat(b.finalResponse().get(5, SECONDS).id()).isEqualTo("b")
    }

    @Test
    fun explicitResetRecoversAfterErrorWithoutConsumingRawEvents() = managed { peer, connection ->
        val a = connection.lane("a")
        peer.send(bearing("created", "old"))
        peer.send("""{"type":"error","stream_id":"a","error":{"message":"synthetic"}}""")
        repeat(2) { a.receive().get(5, SECONDS) }
        assertThatThrownBy { a.finalResponse().get(5, SECONDS) }
            .hasCauseInstanceOf(ResponseWebSocketException::class.java)
        peer.send(bearing("completed", "old"))
        a.receive()
            .get(5, SECONDS) // Drain the old turn before explicitly abandoning its collection.
        a.resetResponseCollection()
        a.send(command)
        peer.send(bearing("created", "new"))
        peer.send(done(id = "new"))
        peer.send(bearing("completed", "new", output = null))
        assertThat(a.finalResponse().get(5, SECONDS).output().single().asFunctionCall().id().get())
            .isEqualTo("new")
        val running = a.finalResponse()
        assertThatThrownBy { a.resetResponseCollection() }
            .isInstanceOf(IllegalStateException::class.java)
        assertThat(running.cancel(false)).isTrue()
        a.resetResponseCollection()
    }

    @Test
    fun eofCannotPromoteAnUnfinishedCollection() = managed { peer, connection ->
        val a = connection.lane("a")
        peer.send(bearing("created", "r"))
        peer.send(done())
        repeat(2) { a.receive().get(5, SECONDS) }
        val final = a.finalResponse()
        peer.abort()
        assertThatThrownBy { final.get(5, SECONDS) }
            .isInstanceOf(java.util.concurrent.ExecutionException::class.java)
    }

    @Test
    fun reconnectReplacesCachedStateAndUsesTheNewBudget() = managed { peer, connection ->
        val a = connection.lane("a")
        peer.send(bearing("completed", "old"))
        a.receive().get(5, SECONDS)
        peer.prepare()
        connection
            .reconnect(ResponseWebSocketOptions.builder().maxResponseBytes(1).build())
            .get(5, SECONDS)
        peer.select()
        val final = a.finalResponse()
        assertThat(final.isDone).isFalse()
        peer.send(bearing("completed", "new"))
        assertThatThrownBy { final.get(5, SECONDS) }
            .hasCauseInstanceOf(ResponseCollectionLimitException::class.java)
    }

    @Test
    fun closeAndLaneCloseDiscardTheCachedFinal() = managed { peer, connection ->
        val a = connection.lane("a")
        val b = connection.lane("b")
        peer.send(bearing("completed", "a"))
        a.receive().get(5, SECONDS)
        a.close()
        assertThatThrownBy { a.finalResponse().get(5, SECONDS) }
            .hasCauseInstanceOf(IllegalStateException::class.java)
        peer.send(bearing("completed", "b", "b"))
        b.receive().get(5, SECONDS)
        connection.close()
        assertThatThrownBy { b.finalResponse().get(5, SECONDS) }
            .isInstanceOf(java.util.concurrent.CancellationException::class.java)
    }

    @Test
    fun unregisteredNamedEventsRemainRawButDoNotEnterDefaultCollection() =
        managed { peer, connection ->
            peer.send(bearing("created", "unregistered", "ghost"))
            peer.send(done("ghost"))
            peer.send(bearing("completed", "unregistered", "ghost"))
            repeat(3) { connection.receive().get(5, SECONDS) }
            val pending = connection.finalResponse()
            assertThat(pending.isDone).isFalse()
            assertThat(pending.cancel(false)).isTrue()
            peer.send(bearing("completed", "default", lane = null))
            assertThat(connection.finalResponse().get(5, SECONDS).id()).isEqualTo("default")
        }

    @Test
    fun delayedAssignedHelperCannotLoseItsResultToAnotherHelperOrClose() {
        Peer().use { peer ->
            val callbacks = LinkedBlockingQueue<Runnable>()
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("fake-key")
                    .baseUrl(peer.server.url("/").toString())
                    .streamHandlerExecutor { callbacks.add(it) }
                    .build()
            try {
                val opening =
                    client
                        .async()
                        .responses()
                        .connect(
                            ResponseWebSocketOptions.builder().maxResponseBytes(10_000).build()
                        )
                checkNotNull(callbacks.poll(5, SECONDS)).run()
                opening.get(5, SECONDS).use { connection ->
                    peer.select()
                    val a = connection.lane("a")
                    val first = a.finalResponse()
                    peer.send(bearing("completed", "assigned"))
                    val delivery = checkNotNull(callbacks.poll(5, SECONDS))
                    assertThatThrownBy { a.finalResponse().get(5, SECONDS) }
                        .hasCauseInstanceOf(IllegalStateException::class.java)
                    assertThatThrownBy { a.receive().get(5, SECONDS) }
                        .hasCauseInstanceOf(IllegalStateException::class.java)
                    connection.close()
                    delivery.run()
                    checkNotNull(callbacks.poll(5, SECONDS)).run()
                    assertThat(first.get(5, SECONDS).id()).isEqualTo("assigned")
                }
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun suppliedTerminalOutputAndStatusRemainAuthoritative() {
        for (status in listOf("completed", "failed", "incomplete")) {
            for (output in
                listOf(
                    "[]",
                    "[{\"type\":\"future_tool\",\"metadata\":{\"keep\":true}}]",
                    "{\"opaque\":true}",
                )) {
                managed { peer, connection ->
                    val a = connection.lane("a")
                    peer.send(bearing("created", "r"))
                    peer.send(done())
                    peer.send(bearing(status, "r", output = output))
                    repeat(2) { a.receive().get(5, SECONDS) }
                    val terminal = a.receive().get(5, SECONDS)
                    val raw =
                        when (status) {
                            "completed" -> terminal.asResponseCompleted().response()
                            "failed" -> terminal.asResponseFailed().response()
                            else -> terminal.asResponseIncomplete().response()
                        }
                    assertThat(a.finalResponse().get(5, SECONDS)).isSameAs(raw)
                }
            }
        }
    }

    @Test
    fun blockingReceiversExposeTheSameCachedFinalAndExplicitReset() {
        Peer().use { peer ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("fake-key")
                    .baseUrl(peer.server.url("/").toString())
                    .build()
            try {
                client
                    .responses()
                    .connect(ResponseWebSocketOptions.builder().maxResponseBytes(10_000).build())
                    .use { connection ->
                        peer.select()
                        val a = connection.lane("a")
                        peer.send(bearing("created", "first"))
                        peer.send(done())
                        peer.send(bearing("completed", "first", output = null))
                        repeat(3) { a.receive() }
                        assertThat(a.finalResponse().output().single().asFunctionCall().arguments())
                            .isEqualTo("{}")
                        peer.send(
                            """{"type":"error","stream_id":"a","error":{"message":"synthetic"}}"""
                        )
                        a.receive()
                        assertThatThrownBy { a.finalResponse() }
                            .isInstanceOf(ResponseWebSocketException::class.java)
                        a.resetResponseCollection()
                        connection.resetResponseCollection()
                        a.send(command)
                        peer.send(bearing("created", "new"))
                        peer.send(bearing("completed", "new"))
                        assertThat(a.finalResponse().id()).isEqualTo("new")
                    }
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun callerChosenLargeBudgetRetainsMoreThanSixteenMiBWithoutANewDefaultLimit() =
        managed(32L * 1024 * 1024) { peer, connection ->
            val a = connection.lane("a")
            peer.send(bearing("created", "large"))
            a.receive().get(5, SECONDS)
            val arguments = "{\"value\":\"" + "x".repeat(8 * 1024 * 1024 - 12) + "\"}"
            assertThat(arguments.toByteArray(UTF_8).size).isEqualTo(8 * 1024 * 1024)
            for (index in 0..1) {
                val item =
                    """{"type":"response.output_item.done","sequence_number":1,"stream_id":"a","output_index":$index,"item":{"id":"f$index","type":"function_call","call_id":"c$index","name":"never_run","arguments":${mapper.writeValueAsString(arguments)}}}"""
                peer.send(item)
                a.receive().get(10, SECONDS)
            }
            peer.send(done(index = 2))
            a.receive().get(5, SECONDS)
            peer.send(bearing("completed", "large", output = null))
            a.receive().get(5, SECONDS)
            val result = a.finalResponse().get(5, SECONDS)
            assertThat(result.output().sumOf { it.asFunctionCall().arguments().length.toLong() })
                .isEqualTo(16L * 1024 * 1024 + 2)
        }

    @Test
    fun completionCallbacksCanStartTheNextConsumerOrReset() {
        for (action in listOf("helper", "receive", "reset")) managed { peer, connection ->
            val a = connection.lane("a")
            val first = a.finalResponse()
            val next =
                first.thenCompose {
                    when (action) {
                        "receive" -> a.receive().thenCompose { a.finalResponse() }
                        "reset" -> {
                            a.resetResponseCollection()
                            a.finalResponse()
                        }
                        else -> a.finalResponse()
                    }
                }
            peer.send(bearing("completed", "first"))
            assertThat(first.get(5, SECONDS).id()).isEqualTo("first")
            peer.send(bearing("completed", "second"))
            assertThat(next.get(5, SECONDS).id()).isEqualTo("second")
        }
    }

    @Test
    fun defaultCollectionIsDisabledAndPositiveBudgetIsRequired() {
        assertThat(ResponseWebSocketOptions.defaults().maxResponseBytes).isNull()
        for (budget in listOf(0L, -1L)) assertThatThrownBy {
                ResponseWebSocketOptions.builder().maxResponseBytes(budget)
            }
            .isInstanceOf(IllegalArgumentException::class.java)
        Peer().use { peer ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("fake-key")
                    .baseUrl(peer.server.url("/").toString())
                    .build()
            try {
                client.async().responses().connect().get(5, SECONDS).use { connection ->
                    peer.select()
                    val a = connection.lane("a")
                    peer.send(bearing("completed", "raw", output = null))
                    assertThat(a.finalResponse().get(5, SECONDS)._output().isMissing()).isTrue()
                    peer.send(bearing("completed", "consumed"))
                    a.receive().get(5, SECONDS)
                    val next = a.finalResponse()
                    assertThat(next.isDone).isFalse()
                    assertThat(next.cancel(false)).isTrue()
                }
            } finally {
                client.close()
            }
        }
    }
}
