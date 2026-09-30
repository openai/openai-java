package com.openai.services.beta.agents

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.*
import com.openai.models.beta.agents.*
import com.openai.models.beta.agents.sessions.SessionCreateParams
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentTurnResultsTest {
    private val direct = Executor { it.run() }

    private fun turn(kind: String, id: String = "root", subagent: String? = null) =
        """{"type":"agent.session.turn.$kind","event_id":"$kind-$id","session_id":"s","turn_id":"$id","turn":{"id":"$id","session_id":"s","status":"${if (kind == "created") "in_progress" else kind}","subagent_id":${subagent?.let { "\"$it\"" } ?: "null"}}}"""

    private fun idle() =
        """{"type":"agent.session.idle","event_id":"idle","session":{"id":"s","status":"idle"}}"""

    private fun message(
        id: String = "answer",
        index: Int = 0,
        text: String = "Answer",
        phase: String = "\"final_answer\"",
        turn: String = "root",
        done: Boolean = true,
    ) =
        """{"type":"agent.session.turn.item.${if (done) "done" else "added"}","event_id":"$id-$done","session_id":"s","turn_id":"$turn","output_index":$index,"item":{"id":"$id","type":"message","role":"assistant","turn_id":"$turn","phase":$phase,"status":"${if (done) "completed" else "in_progress"}","content":[{"type":"output_text","text":"$text","annotations":[]}]}}"""

    private fun events() = listOf(turn("created"), message(), turn("completed"), idle())

    private fun source(
        events: List<String>,
        failure: Throwable? = null,
    ): StreamResponse<AgentSessionEvent> =
        Transport(events, failure)
            .client()
            .beta()
            .agents()
            .sessions()
            .createStreaming(createParams())

    @Test
    fun `collects all final messages in output order and caches result`() {
        val stream =
            source(
                listOf(
                    idle(),
                    turn("created"),
                    turn("created", "child", "worker"),
                    message("child", text = "Excluded", turn = "child"),
                    turn("completed", "child", "worker"),
                    message("comment", text = "Thinking", phase = "\"commentary\""),
                    message("a", 1, "partial", done = false),
                    message("b", 2, "Second"),
                    message("a", 1, "First"),
                    message("a", 1, "First"),
                    turn("completed"),
                    idle(),
                )
            )

        val result = AgentTurnResults.getFinalResult(stream)
        assertThat(result.outputText()).isEqualTo("FirstSecond")
        assertThat(result.turnId()).isEqualTo("root")
        assertThat(result.sessionId()).isEqualTo("s")
        assertThat(result.messages()).hasSize(2)
        assertThat(
                result
                    .messages()[0]
                    .content()[0]
                    .asOutputText()
                    ._additionalProperties()["annotations"]
            )
            .isEqualTo(com.openai.core.JsonValue.from(emptyList<Any>()))
        assertThat(AgentTurnResults.getFinalResult(stream)).isSameAs(result)
        assertThatThrownBy { (result.messages() as MutableList).clear() }
            .isInstanceOf(UnsupportedOperationException::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 4])
    fun `iteration then getter consumes only remaining events`(consumed: Int) {
        val stream = AgentTurnResults.withResultCollection(source(events()))
        assertThat(stream.stream().limit(consumed.toLong()).count()).isEqualTo(consumed.toLong())
        assertThat(AgentTurnResults.getFinalResult(stream).outputText()).isEqualTo("Answer")
    }

    @Test
    fun `selected result survives later turns and transport failure during raw iteration`() {
        val cause = java.io.IOException("later disconnect")
        val input =
            events() +
                listOf(
                    turn("created", "later"),
                    message("later-answer", text = "Wrong", turn = "later"),
                    turn("failed", "later"),
                )
        val stream = AgentTurnResults.withResultCollection(source(input, cause))
        assertThatThrownBy { stream.stream().forEach {} }.hasRootCause(cause)
        assertThat(AgentTurnResults.getFinalResult(stream).outputText()).isEqualTo("Answer")
    }

    @Test
    fun `unknown added phase can resolve to completed commentary`() {
        val stream =
            source(
                listOf(
                    turn("created"),
                    message(phase = "null", done = false),
                    message(phase = "\"commentary\""),
                    turn("completed"),
                    idle(),
                )
            )

        assertThat(AgentTurnResults.getFinalResult(stream).outputText()).isEmpty()
    }

    @Test
    fun `completed messages with an unspecified phase are included`() {
        val stream =
            source(listOf(turn("created"), message(phase = "null"), turn("completed"), idle()))

        assertThat(AgentTurnResults.getFinalResult(stream).outputText()).isEqualTo("Answer")
    }

    @Test
    fun `completed text free turn is a valid result`() {
        val stream = source(listOf(turn("created"), turn("completed"), idle()))
        assertThat(AgentTurnResults.getFinalResult(stream).outputText()).isEmpty()
    }

    @Test
    fun `getter stops at idle without waiting for stream EOF`() {
        val stream =
            source(events(), AssertionError("Read after the completed turn's idle boundary"))
        assertThat(AgentTurnResults.getFinalResult(stream).outputText()).isEqualTo("Answer")
    }

    @ParameterizedTest
    @ValueSource(strings = ["failed", "cancelled"])
    fun `unsuccessful turns preserve metadata and output`(status: String) {
        val stream = source(listOf(turn("created"), message(), turn(status), idle()))

        val failure =
            catchThrowable { AgentTurnResults.getFinalResult(stream) } as AgentTurnResultException
        assertThat(failure.reason().name).isEqualTo("TURN_${status.uppercase()}")
        assertThat(failure.turnId()).contains("root")
        assertThat(failure.messages()).hasSize(1)
    }

    @Test
    fun `EOF and close do not claim final output`() {
        val stream = source(events().dropLast(1))
        val eof =
            catchThrowable { AgentTurnResults.getFinalResult(stream) } as AgentTurnResultException
        assertThat(eof.reason()).isEqualTo(AgentTurnResultException.Reason.INCOMPLETE_STREAM)
        val closed = source(events())
        closed.close()
        assertThat(
                (catchThrowable { AgentTurnResults.getFinalResult(closed) }
                        as AgentTurnResultException)
                    .reason()
            )
            .isEqualTo(AgentTurnResultException.Reason.CLOSED)
    }

    @Test
    fun `unhandled actions do not wait forever`() {
        val action =
            """{"type":"agent.session.requires_action","event_id":"action","session":{"id":"s","status":"requires_action","required_actions":[{"type":"function_call","name":"lookup","call_id":"call","turn_id":"root"}]}}"""
        val stream = source(listOf(turn("created"), action))
        val failure =
            catchThrowable { AgentTurnResults.getFinalResult(stream) } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.REQUIRES_ACTION)
        assertThat(failure.requiredActions()).hasSize(1)
    }

    @Test
    fun `transport cause remains available`() {
        val cause = java.io.IOException("synthetic disconnect")
        val failure =
            catchThrowable { AgentTurnResults.getFinalResult(source(emptyList(), cause)) }
                as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.STREAM_ERROR)
        assertThat(failure).hasRootCause(cause)
        assertThat(failure.turn()).isEmpty()
    }

    private inner class Transport(
        var events: List<String> = events(),
        private val failure: Throwable? = null,
    ) : HttpClient {
        var responseReady = CompletableFuture.completedFuture<Void?>(null)
        val posts = AtomicInteger()
        val closed = AtomicInteger()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            val streaming =
                request.pathSegments.last() == "events" && request.method == HttpMethod.GET ||
                    request.pathSegments.last() == "sessions" && request.method == HttpMethod.POST
            if (request.method == HttpMethod.POST) posts.incrementAndGet()
            val body =
                if (streaming) events.joinToString("") { "data: $it\n\n" }
                else if (request.method == HttpMethod.POST) "" else """{"id":"s","status":"idle"}"""
            return object : HttpResponse {
                override fun statusCode() =
                    if (request.method == HttpMethod.POST && !streaming) 204 else 200

                override fun headers() =
                    Headers.builder()
                        .put("x-request-id", "synthetic-request")
                        .put(
                            "Content-Type",
                            if (streaming) "text/event-stream" else "application/json",
                        )
                        .build()

                override fun body() =
                    object : ByteArrayInputStream(body.toByteArray()) {
                        override fun read(): Int {
                            if (available() == 0 && failure != null) throw failure
                            return super.read()
                        }

                        // Limit read-ahead so a synthetic disconnect occurs only after queued
                        // events.
                        override fun read(bytes: ByteArray, offset: Int, length: Int): Int {
                            val next = read()
                            if (next == -1) return -1
                            bytes[offset] = next.toByte()
                            return 1
                        }
                    }

                override fun close() {
                    closed.incrementAndGet()
                }
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            responseReady.thenApply { execute(request, requestOptions) }

        override fun close() {}

        fun client() =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(this)
                    .apiKey("synthetic")
                    .streamHandlerExecutor(direct)
                    .build()
            )
    }

    private fun <T> OpenAIClientImpl.useClient(block: (OpenAIClientImpl) -> T): T =
        try {
            block(this)
        } finally {
            close()
        }

    private fun createParams() =
        SessionCreateParams.builder().agentId("agent").environmentNone().input("Question").build()

    @Test
    fun `creation and raw header paths retain stream interface and collect results`() {
        val transport = Transport()
        transport.client().useClient { client ->
            val sessions = client.beta().agents().sessions()
            val stream: StreamResponse<AgentSessionEvent> = sessions.createStreaming(createParams())
            stream.use {
                assertThat(AgentTurnResults.getFinalResult(it).outputText()).isEqualTo("Answer")
            }
            sessions.withRawResponse().createStreaming(createParams()).use { response ->
                assertThat(response.headers().values("x-request-id"))
                    .containsExactly("synthetic-request")
                assertThat(AgentTurnResults.getFinalResult(response.parse()).outputText())
                    .isEqualTo("Answer")
            }
        }
        assertThat(transport.posts.get()).isEqualTo(2)
    }

    @Test
    fun `follow up getter keeps existing dispatch and never reruns handlers`() {
        val call =
            """{"type":"agent.session.turn.item.added","event_id":"call","session_id":"s","turn_id":"root","output_index":0,"item":{"id":"call","type":"function_call","name":"lookup","call_id":"call","turn_id":"root","arguments":{},"status":"in_progress"}}"""
        val transport =
            Transport(listOf(turn("created"), call, message(), turn("completed"), idle()))
        val calls = AtomicInteger()
        transport.client().useClient { client ->
            val params =
                AgentSessionStreamParams.builder()
                    .sessionId("s")
                    .input("Question")
                    .toolHandler("lookup") {
                        calls.incrementAndGet()
                        "Result"
                    }
                    .build()
            client.beta().agents().sessions().stream(params).use { stream ->
                val result = AgentTurnResults.getFinalResult(stream)
                assertThat(result.outputText()).isEqualTo("Answer")
                assertThat(AgentTurnResults.getFinalResult(stream)).isSameAs(result)
            }
        }
        assertThat(calls.get()).isEqualTo(1)
        assertThat(transport.posts.get()).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `async creation supports getter only and subscription then getter`(subscribe: Boolean) {
        val transport = Transport()
        transport.client().useClient { client ->
            val stream: AsyncStreamResponse<AgentSessionEvent> =
                client.async().beta().agents().sessions().createStreaming(createParams())
            val observed = AtomicInteger()
            if (subscribe)
                AgentTurnResults.withResultCollection(stream).subscribe {
                    observed.incrementAndGet()
                }
            val result = AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS)
            assertThat(result.outputText()).isEqualTo("Answer")
            assertThat(AgentTurnResults.getFinalResult(stream).get()).isSameAs(result)
            if (subscribe) assertThat(observed.get()).isEqualTo(4)
        }
    }

    @Test
    fun `async follow up collects after handler dispatch`() {
        val transport = Transport()
        transport.client().useClient { client ->
            val stream =
                client
                    .async()
                    .beta()
                    .agents()
                    .sessions()
                    .stream(
                        AgentSessionStreamParams.builder().sessionId("s").input("Question").build()
                    )
            assertThat(
                    AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS).outputText()
                )
                .isEqualTo("Answer")
        }
    }

    private fun assertNoCollectedPayload(stream: Any) {
        val collectorField =
            stream.javaClass.getDeclaredField("collector").apply { isAccessible = true }
        val collector = collectorField.get(stream)
        val messages =
            collector.javaClass.getDeclaredField("messages").apply { isAccessible = true }
        val turn = collector.javaClass.getDeclaredField("turn").apply { isAccessible = true }
        assertThat(messages.get(collector) as Map<*, *>).isEmpty()
        assertThat(turn.get(collector)).isNull()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `raw sync streams retain no result payload and reject late collection`(followUp: Boolean) {
        val transport =
            Transport(
                listOf(turn("created")) +
                    (0 until 1000).map { message("answer-$it", it) } +
                    listOf(turn("completed"), idle())
            )
        transport.client().useClient { client ->
            val sessions = client.beta().agents().sessions()
            val stream =
                if (followUp)
                    sessions.stream(
                        AgentSessionStreamParams.builder().sessionId("s").input("Question").build()
                    )
                else sessions.createStreaming(createParams())
            stream.use {
                assertThat(it.stream().count()).isEqualTo(1003)
                assertNoCollectedPayload(it)
                assertThatThrownBy { AgentTurnResults.getFinalResult(it) }
                    .isInstanceOf(IllegalStateException::class.java)
                    .hasMessageContaining("before consuming events")
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `raw async streams retain no result payload and reject late collection`(followUp: Boolean) {
        val transport =
            Transport(
                listOf(turn("created")) +
                    (0 until 1000).map { message("answer-$it", it) } +
                    listOf(turn("completed"), idle())
            )
        transport.client().useClient { client ->
            val sessions = client.async().beta().agents().sessions()
            val stream =
                if (followUp)
                    sessions.stream(
                        AgentSessionStreamParams.builder().sessionId("s").input("Question").build()
                    )
                else sessions.createStreaming(createParams())
            if (followUp) stream.subscribe(AsyncStreamResponse.Handler {}, direct)
            else stream.subscribe {}
            stream.onCompleteFuture().get(5, TimeUnit.SECONDS)
            assertNoCollectedPayload(stream)
            assertThatThrownBy { AgentTurnResults.withResultCollection(stream) }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessageContaining("before consuming events")
            assertThatThrownBy { AgentTurnResults.getFinalResult(stream) }
                .isInstanceOf(IllegalStateException::class.java)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `getter after raw async completion without events does not hang`(failed: Boolean) {
        val transport =
            Transport(emptyList(), if (failed) java.io.IOException("early disconnect") else null)
        transport.client().useClient { client ->
            val stream = client.async().beta().agents().sessions().createStreaming(createParams())
            stream.subscribe {}
            assertThatThrownBy { AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS) }
                .hasCauseInstanceOf(AgentTurnResultException::class.java)
        }
    }

    @Test
    fun `async result callbacks can await source completion and read the result`() {
        val transport = Transport()
        transport.responseReady = CompletableFuture()
        val stream =
            transport.client().async().beta().agents().sessions().createStreaming(createParams())
        val future = AgentTurnResults.getFinalResult(stream)
        val checked =
            future.thenApply {
                stream.onCompleteFuture().get(5, TimeUnit.SECONDS)
                CompletableFuture.supplyAsync {
                        AgentTurnResults.getFinalResult(stream).get().outputText()
                    }
                    .get(5, TimeUnit.SECONDS)
            }
        transport.responseReady.complete(null)
        assertThat(checked.get(5, TimeUnit.SECONDS)).isEqualTo("Answer")
    }
}
