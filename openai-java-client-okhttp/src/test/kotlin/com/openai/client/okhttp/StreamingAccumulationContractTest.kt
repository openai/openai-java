package com.openai.client.okhttp

import com.openai.core.jsonMapper
import com.openai.helpers.ChatCompletionAccumulator
import com.openai.helpers.ResponseAccumulator
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseStreamEvent
import java.time.Duration
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicReference
import okhttp3.Call
import okhttp3.EventListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StreamingAccumulationContractTest {
    @Test
    fun closeAbortsBlockedSynchronousStreamRead() {
        val call = AtomicReference<Call>()
        val native =
            okhttp3.OkHttpClient.Builder()
                .eventListener(
                    object : EventListener() {
                        override fun callStart(value: Call) {
                            call.set(value)
                        }
                    }
                )
                .build()
        val executor = Executors.newFixedThreadPool(2)
        MockWebServer().use { server ->
            // Deliver headers but withhold all body bytes, leaving the stream reader blocked.
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setBody("")
                    .setHeader("Content-Length", "100")
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .okHttpClient(native)
                    .apiKey("test-key")
                    .baseUrl(server.url("/").toString())
                    .maxRetries(0)
                    .timeout(Duration.ofSeconds(30))
                    .build()
            val stream =
                client
                    .chat()
                    .completions()
                    .createStreaming(
                        ChatCompletionCreateParams.builder()
                            .model("test-model")
                            .addUserMessage("synthetic")
                            .build()
                    )
            try {
                val started = CountDownLatch(1)
                val read =
                    executor.submit<Boolean> {
                        started.countDown()
                        stream.stream().iterator().hasNext()
                    }
                assertThat(started.await(5, TimeUnit.SECONDS)).isTrue()
                assertThrows<TimeoutException> { read.get(100, TimeUnit.MILLISECONDS) }
                val close = executor.submit { stream.close() }
                close.get(2, TimeUnit.SECONDS)
                assertThat(read.get(2, TimeUnit.SECONDS)).isFalse()
            } finally {
                call.get()?.cancel()
                stream.close()
                client.close()
                executor.shutdownNow()
                native.dispatcher.executorService.shutdownNow()
                native.connectionPool.evictAll()
            }
        }
    }

    private val mapper = jsonMapper()

    private fun encode(value: Any) = mapper.writeValueAsString(value)

    private fun chat(delta: Map<String, Any?>, finish: String? = null) =
        encode(
            mapOf(
                "id" to "chat-test",
                "object" to "chat.completion.chunk",
                "created" to 1,
                "model" to "test-model",
                "choices" to
                    listOf(mapOf("index" to 0, "delta" to delta, "finish_reason" to finish)),
            )
        )

    private fun usage() =
        encode(
            mapOf(
                "id" to "chat-test",
                "object" to "chat.completion.chunk",
                "created" to 1,
                "model" to "test-model",
                "choices" to emptyList<Any>(),
                "usage" to
                    mapOf("prompt_tokens" to 3, "completion_tokens" to 5, "total_tokens" to 8),
            )
        )

    private fun sse(events: List<String>, done: Boolean = true) =
        events.joinToString("") { ": keepalive\r\ndata: $it\r\n\r\n" } +
            if (done) "data: [DONE]\n\n" else ""

    private fun client(server: MockWebServer) =
        OpenAIOkHttpClient.builder()
            .baseUrl(server.url("/v1").toString())
            .apiKey("test-key")
            .maxRetries(0)
            .build()

    private fun chatParams() =
        ChatCompletionCreateParams.builder().model("test-model").addUserMessage("synthetic").build()

    private fun responseParams() =
        ResponseCreateParams.builder().model("test-model").input("synthetic").build()

    @ParameterizedTest
    @CsvSource(
        "false,text",
        "true,text",
        "false,tool",
        "true,tool",
        "false,legacy",
        "true,legacy",
        "false,refusal",
        "true,refusal",
    )
    fun chatAccumulatesFinalContentAndUsage(async: Boolean, kind: String) {
        val deltas =
            when (kind) {
                "text" ->
                    listOf(
                        mapOf("role" to "assistant", "content" to "Hello "),
                        mapOf("content" to "🌍"),
                    )
                "refusal" -> listOf(mapOf("refusal" to "Cannot "), mapOf("refusal" to "help"))
                "legacy" ->
                    listOf(
                        mapOf(
                            "function_call" to mapOf("name" to "lookup", "arguments" to "{\"x\":")
                        ),
                        mapOf("function_call" to mapOf("arguments" to "1}")),
                    )
                else ->
                    listOf(
                        mapOf(
                            "tool_calls" to
                                listOf(
                                    mapOf(
                                        "index" to 0,
                                        "id" to "call-test",
                                        "type" to "function",
                                        "function" to
                                            mapOf("name" to "lookup", "arguments" to "{\"x\":"),
                                    )
                                )
                        ),
                        mapOf(
                            "tool_calls" to
                                listOf(
                                    mapOf("index" to 0, "function" to mapOf("arguments" to "1}"))
                                )
                        ),
                    )
            }
        val finish =
            when (kind) {
                "tool" -> "tool_calls"
                "legacy" -> "function_call"
                else -> "stop"
            }
        MockWebServer().use { server ->
            // One-byte HTTP chunks exercise UTF-8 and SSE boundaries independently of model chunks.
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setChunkedBody(
                        sse(deltas.map { chat(it) } + chat(emptyMap(), finish) + usage()),
                        1,
                    )
            )
            val client = client(server)
            try {
                val accumulator = ChatCompletionAccumulator.create()
                if (async)
                    client
                        .async()
                        .chat()
                        .completions()
                        .createStreaming(chatParams())
                        .subscribe { accumulator.accumulate(it) }
                        .onCompleteFuture()
                        .get(10, TimeUnit.SECONDS)
                else
                    client.chat().completions().createStreaming(chatParams()).use {
                        it.stream().forEach(accumulator::accumulate)
                    }
                val result = accumulator.chatCompletion()
                val message = result.choices().single().message()
                when (kind) {
                    "text" -> assertThat(message.content()).contains("Hello 🌍")
                    "refusal" -> assertThat(message.refusal()).contains("Cannot help")
                    "legacy" -> {
                        assertThat(message.functionCall().get().name()).isEqualTo("lookup")
                        assertThat(message.functionCall().get().arguments()).isEqualTo("{\"x\":1}")
                    }
                    else -> {
                        val call = message.toolCalls().get().single().asFunction()
                        assertThat(call.id()).isEqualTo("call-test")
                        assertThat(call.function().arguments()).isEqualTo("{\"x\":1}")
                    }
                }
                assertThat(result.usage().get().totalTokens()).isEqualTo(8)
                assertThat(result.choices().single().finishReason().toString()).isEqualTo(finish)
            } finally {
                client.close()
            }
        }
    }

    private fun response(status: String, output: List<Any> = emptyList()) =
        mapOf(
            "id" to "resp-test",
            "object" to "response",
            "created_at" to 1,
            "model" to "test-model",
            "status" to status,
            "output" to output,
            "parallel_tool_calls" to true,
            "tool_choice" to "auto",
            "tools" to emptyList<Any>(),
            "error" to
                if (status == "failed") mapOf("code" to "server_error", "message" to "synthetic")
                else null,
            "incomplete_details" to
                if (status == "incomplete") mapOf("reason" to "max_output_tokens") else null,
        )

    private fun event(type: String, vararg fields: Pair<String, Any?>) =
        encode(mapOf("type" to type, "sequence_number" to 1) + fields.toMap())

    @ParameterizedTest
    @CsvSource("false,text", "true,text", "false,tool", "true,tool")
    fun responsesExposeIsolatedSnapshotsAndAuthoritativeFinal(async: Boolean, kind: String) {
        val text = kind == "text"
        val part =
            mapOf(
                "type" to "output_text",
                "text" to "",
                "annotations" to emptyList<Any>(),
                "logprobs" to emptyList<Any>(),
            )
        val initial: Map<String, Any?> =
            if (text)
                mapOf(
                    "id" to "item-test",
                    "type" to "message",
                    "role" to "assistant",
                    "status" to "in_progress",
                    "content" to emptyList<Any>(),
                )
            else
                mapOf(
                    "id" to "item-test",
                    "type" to "function_call",
                    "call_id" to "call-test",
                    "name" to "lookup",
                    "arguments" to "",
                    "status" to "in_progress",
                )
        val final: Map<String, Any?> =
            if (text)
                initial +
                    mapOf(
                        "status" to "completed",
                        "content" to listOf(part + ("text" to "Hello world")),
                    )
            else initial + mapOf("status" to "completed", "arguments" to "{\"x\":1}")
        val events =
            mutableListOf(
                event("response.created", "response" to response("in_progress")),
                event("response.output_item.added", "output_index" to 0, "item" to initial),
            )
        if (text)
            events.add(
                event(
                    "response.content_part.added",
                    "item_id" to "item-test",
                    "output_index" to 0,
                    "content_index" to 0,
                    "part" to part,
                )
            )
        for (delta in if (text) listOf("Hello ", "world") else listOf("{\"x\":", "1}")) {
            events.add(
                event(
                    if (text) "response.output_text.delta"
                    else "response.function_call_arguments.delta",
                    "item_id" to "item-test",
                    "output_index" to 0,
                    "content_index" to 0,
                    "delta" to delta,
                )
            )
        }
        events.add(event("response.output_item.done", "output_index" to 0, "item" to final))
        events.add(event("response.completed", "response" to response("completed", listOf(final))))
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setChunkedBody(sse(events), 7)
            )
            val client = client(server)
            try {
                val accumulator = ResponseAccumulator.createWithSnapshots()
                val snapshots = mutableListOf<Response>()
                val consume: (ResponseStreamEvent) -> Unit = { e ->
                    accumulator.accumulate(e)
                    if (e.outputTextDelta().isPresent || e.functionCallArgumentsDelta().isPresent)
                        snapshots.add(accumulator.snapshot().get())
                }
                if (async)
                    client
                        .async()
                        .responses()
                        .createStreaming(responseParams())
                        .subscribe { consume(it) }
                        .onCompleteFuture()
                        .get(10, TimeUnit.SECONDS)
                else
                    client.responses().createStreaming(responseParams()).use {
                        it.stream().forEach(consume)
                    }
                assertThat(snapshots).hasSize(2)
                fun content(r: Response): String =
                    if (text)
                        r.output().single().asMessage().content().single().asOutputText().text()
                    else r.output().single().asFunctionCall().arguments()
                assertThat(content(snapshots[0])).isEqualTo(if (text) "Hello " else "{\"x\":")
                assertThat(content(snapshots[1]))
                    .isEqualTo(if (text) "Hello world" else "{\"x\":1}")
                assertThat(content(accumulator.response())).isEqualTo(content(snapshots[1]))
                assertThat(accumulator.response().status().get().toString()).isEqualTo("completed")
                assertThat(accumulator.snapshot().get()).isSameAs(accumulator.response())
            } finally {
                client.close()
            }
        }
    }

    @ParameterizedTest
    @CsvSource("false,failed", "true,failed", "false,incomplete", "true,incomplete")
    fun responsesPreserveUnsuccessfulTerminalState(async: Boolean, status: String) {
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setBody(sse(listOf(event("response.$status", "response" to response(status)))))
            )
            val client = client(server)
            try {
                val accumulator = ResponseAccumulator.createWithSnapshots()
                if (async)
                    client
                        .async()
                        .responses()
                        .createStreaming(responseParams())
                        .subscribe { accumulator.accumulate(it) }
                        .onCompleteFuture()
                        .get(10, TimeUnit.SECONDS)
                else
                    client.responses().createStreaming(responseParams()).use {
                        it.stream().forEach(accumulator::accumulate)
                    }
                assertThat(accumulator.response().status().get().toString()).isEqualTo(status)
                if (status == "failed") assertThat(accumulator.response().error()).isPresent
                else assertThat(accumulator.response().incompleteDetails()).isPresent
            } finally {
                client.close()
            }
        }
    }

    @ParameterizedTest
    @CsvSource("false,chat", "true,chat", "false,responses", "true,responses")
    fun eofWithoutTerminalDoesNotProduceFinalResult(async: Boolean, endpoint: String) {
        MockWebServer().use { server ->
            val payload =
                if (endpoint == "chat") chat(mapOf("content" to "partial"))
                else event("response.created", "response" to response("in_progress"))
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setBody(sse(listOf(payload), done = false))
            )
            val client = client(server)
            try {
                if (endpoint == "chat") {
                    val accumulator = ChatCompletionAccumulator.create()
                    if (async)
                        client
                            .async()
                            .chat()
                            .completions()
                            .createStreaming(chatParams())
                            .subscribe { accumulator.accumulate(it) }
                            .onCompleteFuture()
                            .get(10, TimeUnit.SECONDS)
                    else
                        client.chat().completions().createStreaming(chatParams()).use {
                            it.stream().forEach(accumulator::accumulate)
                        }
                    assertThatThrownBy { accumulator.chatCompletion() }
                        .isInstanceOf(IllegalStateException::class.java)
                } else {
                    val accumulator = ResponseAccumulator.createWithSnapshots()
                    if (async)
                        client
                            .async()
                            .responses()
                            .createStreaming(responseParams())
                            .subscribe { accumulator.accumulate(it) }
                            .onCompleteFuture()
                            .get(10, TimeUnit.SECONDS)
                    else
                        client.responses().createStreaming(responseParams()).use {
                            it.stream().forEach(accumulator::accumulate)
                        }
                    assertThatThrownBy { accumulator.response() }
                        .isInstanceOf(IllegalStateException::class.java)
                    assertThat(accumulator.snapshot().get().status().get().toString())
                        .isEqualTo("in_progress")
                }
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun closingCompletedSseKeepsConnectionReuse() {
        MockWebServer().use { server ->
            repeat(2) {
                server.enqueue(
                    MockResponse()
                        .setHeader("Content-Type", "text/event-stream")
                        .setChunkedBody(sse(listOf(chat(mapOf("content" to "done"), "stop"))), 7)
                )
            }
            val client = client(server)
            try {
                repeat(2) {
                    val accumulator = ChatCompletionAccumulator.create()
                    client.chat().completions().createStreaming(chatParams()).use {
                        it.stream().forEach(accumulator::accumulate)
                    }
                    assertThat(accumulator.chatCompletion().choices().single().message().content())
                        .contains("done")
                }
                assertThat(server.takeRequest().sequenceNumber).isEqualTo(0)
                assertThat(server.takeRequest().sequenceNumber).isEqualTo(1)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun closingConsumedResponsesKeepsConnectionReuse() {
        MockWebServer().use { server ->
            repeat(2) { server.enqueue(MockResponse().setBody("[]")) }
            OkHttpClient.builder().build().use { transport ->
                val request =
                    com.openai.core.http.HttpRequest.builder()
                        .method(com.openai.core.http.HttpMethod.GET)
                        .baseUrl(server.url("/").toString())
                        .build()
                repeat(2) {
                    transport.execute(request).use {
                        assertThat(it.body().readBytes()).isEqualTo("[]".toByteArray())
                    }
                }
            }
            assertThat(server.takeRequest().sequenceNumber).isEqualTo(0)
            assertThat(server.takeRequest().sequenceNumber).isEqualTo(1)
        }
    }
}
