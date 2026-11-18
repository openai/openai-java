package com.openai.services.beta.agents

import com.fasterxml.jackson.databind.JsonNode
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.*
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import com.openai.models.beta.agents.AgentToolHandlers
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.beta.agents.sessions.events.EventStreamParams
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class AgentBudgetStreamTest {
    private val domainError =
        """{"type":"error","event_id":"error","session_id":"s","error":{"type":"server_error","code":"session_budget_exceeded","message":"Session error."}}"""
    private val created =
        """{"type":"agent.session.created","event_id":"created","session":{"id":"s","status":"in_progress"}}"""
    private val idle =
        """{"type":"agent.session.idle","event_id":"idle","session":{"id":"s","status":"idle"}}"""

    private fun budget(
        sessionId: String = "s",
        limit: Long? = 1234L,
        eventId: String = "budget-$sessionId",
    ) =
        """{"type":"agent.session.budget_reached","event_id":"$eventId","session":{"id":"$sessionId","status":"budget_reached","spend_control":{"consumed":321,"limit":$limit}}}"""

    private fun turn(kind: String) =
        """{"type":"agent.session.turn.$kind","event_id":"turn-$kind","session_id":"s","turn_id":"root","turn":{"id":"root","session_id":"s","status":"${if (kind == "created") "in_progress" else kind}"}}"""

    private fun creationParams() =
        SessionCreateParams.builder().agentId("agent").environmentNone().input("Question").build()

    private fun followUp() =
        AgentSessionStreamParams.builder().sessionId("s").input("Question").build()

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `raw creation and event subscriptions preserve unknown budget payloads`(async: Boolean) {
        for ((creation, limit) in
            listOf(false to 1234L, true to 1234L, false to null, true to null)) {
            val transport = Transport(listOf(domainError, budget(limit = limit)))
            transport.client().useClient { client ->
                val events = mutableListOf<AgentSessionEvent>()
                if (async) {
                    val sessions = client.async().beta().agents().sessions()
                    val stream =
                        if (creation) sessions.createStreaming(creationParams())
                        else
                            sessions
                                .events()
                                .streamStreaming(EventStreamParams.builder().sessionId("s").build())
                    stream.subscribe { events.add(it) }.onCompleteFuture().get(5, TimeUnit.SECONDS)
                } else {
                    val sessions = client.beta().agents().sessions()
                    val stream =
                        if (creation) sessions.createStreaming(creationParams())
                        else
                            sessions
                                .events()
                                .streamStreaming(EventStreamParams.builder().sessionId("s").build())
                    stream.use { it.stream().forEach { events.add(it) } }
                }
                assertThat(events).hasSize(2)
                assertThat(events.first().asError().error().message()).isEqualTo("Session error.")
                val frame = jsonMapper().valueToTree<JsonNode>(events.last())
                assertThat(frame.path("type").asText()).isEqualTo("agent.session.budget_reached")
                assertThat(frame.path("session").path("id").asText()).isEqualTo("s")
                assertThat(frame.path("session").path("spend_control").path("consumed").asLong())
                    .isEqualTo(321L)
                assertThat(frame.path("session").path("spend_control").path("limit").isNull)
                    .isEqualTo(limit == null)
                assertThat(transport.awaitStreamClosed()).isTrue()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `matching budget terminates creation and follow-up helpers`(async: Boolean) {
        for ((creation, active) in
            listOf(false to false, true to false, false to true, true to true)) {
            val eventsOnWire =
                if (active) listOf(domainError, created, turn("created"), budget())
                else
                    listOf(domainError, created, turn("created"), turn("completed"), budget(), idle)
            val transport = Transport(eventsOnWire)
            transport.client().useClient { client ->
                val events = mutableListOf<AgentSessionEvent>()
                val handlers = AgentToolHandlers.builder().build()
                if (async) {
                    val sessions = client.async().beta().agents().sessions()
                    val stream =
                        if (creation) sessions.createStreaming(creationParams(), handlers)
                        else sessions.stream(followUp())
                    stream.subscribe { events.add(it) }.onCompleteFuture().get(5, TimeUnit.SECONDS)
                } else {
                    val sessions = client.beta().agents().sessions()
                    val stream =
                        if (creation) sessions.createStreaming(creationParams(), handlers)
                        else sessions.stream(followUp())
                    stream.use { it.stream().forEach { events.add(it) } }
                }
                assertThat(events).hasSize(if (active) 4 else 5)
                assertThat(events.first().isError()).isTrue()
                assertThat(jsonMapper().valueToTree<JsonNode>(events.last()).path("type").asText())
                    .isEqualTo("agent.session.budget_reached")
                assertThat(transport.awaitStreamClosed()).isTrue()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `creation helpers stop when budget is the first session snapshot`(async: Boolean) {
        val failed =
            """{"type":"agent.session.failed","event_id":"sentinel","session":{"id":"s","status":"failed"}}"""
        val unknown =
            """{"type":"agent.session.future","event_id":"unknown","session":{"id":"s"}}"""
        val malformed = """{"type":"agent.session.budget_reached","event_id":"missing-session"}"""
        val transport =
            Transport(listOf(domainError, unknown, malformed, budget(""), budget(), failed))
        transport.client().useClient { client ->
            val events = mutableListOf<AgentSessionEvent>()
            val handlers = AgentToolHandlers.builder().build()
            if (async) {
                client
                    .async()
                    .beta()
                    .agents()
                    .sessions()
                    .createStreaming(creationParams(), handlers)
                    .subscribe { events.add(it) }
                    .onCompleteFuture()
                    .get(5, TimeUnit.SECONDS)
            } else {
                client.beta().agents().sessions().createStreaming(creationParams(), handlers).use {
                    it.stream().forEach { events.add(it) }
                }
            }
            assertThat(events).hasSize(5)
            assertThat(events.first().isError()).isTrue()
            assertThat(jsonMapper().valueToTree<JsonNode>(events.last()).path("type").asText())
                .isEqualTo("agent.session.budget_reached")
            assertThat(transport.awaitStreamClosed()).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `another session budget does not terminate the helper`(async: Boolean) {
        val transport =
            Transport(
                listOf(
                    created,
                    turn("created"),
                    turn("completed"),
                    domainError,
                    budget("other"),
                    idle,
                )
            )
        transport.client().useClient { client ->
            val events = mutableListOf<AgentSessionEvent>()
            if (async)
                client
                    .async()
                    .beta()
                    .agents()
                    .sessions()
                    .stream(followUp())
                    .subscribe { events.add(it) }
                    .onCompleteFuture()
                    .get(5, TimeUnit.SECONDS)
            else
                client.beta().agents().sessions().stream(followUp()).use {
                    it.stream().forEach { events.add(it) }
                }
            assertThat(events).hasSize(6)
            assertThat(events.last().isIdle()).isTrue()
            assertThat(transport.awaitStreamClosed()).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `budget boundaries preserve completed helper results`(async: Boolean) {
        for (creation in listOf(false, true)) {
            val transport =
                Transport(
                    listOf(
                        created,
                        turn("created"),
                        budget(eventId = "early-budget"),
                        turn("completed"),
                        domainError,
                        budget(),
                        idle,
                    )
                )
            transport.client().useClient { client ->
                val handlers = AgentToolHandlers.builder().build()
                val result =
                    if (async) {
                        val sessions = client.async().beta().agents().sessions()
                        val stream =
                            if (creation) sessions.createStreaming(creationParams(), handlers)
                            else sessions.stream(followUp())
                        AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS)
                    } else {
                        val sessions = client.beta().agents().sessions()
                        val stream =
                            if (creation) sessions.createStreaming(creationParams(), handlers)
                            else sessions.stream(followUp())
                        stream.use { AgentTurnResults.getFinalResult(it) }
                    }
                assertThat(result.turnId()).isEqualTo("root")
                assertThat(transport.awaitStreamClosed()).isTrue()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `raw result collection stops at a matching budget before a root`(async: Boolean) {
        val failed =
            """{"type":"agent.session.failed","event_id":"sentinel","session":{"id":"s","status":"failed"}}"""
        for (identified in listOf(false, true)) {
            val events =
                if (identified) listOf(created, budget("other"), budget(""), budget(), failed)
                else listOf(domainError, budget(""), budget(), failed)
            val transport = Transport(events)
            transport.client().useClient { client ->
                val failure =
                    if (async) {
                        val stream =
                            client
                                .async()
                                .beta()
                                .agents()
                                .sessions()
                                .createStreaming(creationParams())
                        assertThrows<ExecutionException> {
                                AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS)
                            }
                            .cause as AgentTurnResultException
                    } else {
                        val stream =
                            client.beta().agents().sessions().createStreaming(creationParams())
                        assertThrows<AgentTurnResultException> {
                            AgentTurnResults.getFinalResult(stream)
                        }
                    }
                assertThat(failure.reason())
                    .isEqualTo(AgentTurnResultException.Reason.INCOMPLETE_STREAM)
                assertThat(failure.sessionId()).contains("s")
                assertThat(failure.turn()).isEmpty()
                assertThat(transport.awaitStreamClosed()).isTrue()
            }
        }
    }

    @ParameterizedTest
    @CsvSource(
        "false, creation, matching, INCOMPLETE_STREAM",
        "true, creation, matching, INCOMPLETE_STREAM",
        "false, followup, matching, INCOMPLETE_STREAM",
        "true, followup, matching, INCOMPLETE_STREAM",
        "false, raw, matching, INCOMPLETE_STREAM",
        "true, raw, matching, INCOMPLETE_STREAM",
        "false, creation, completed, INCOMPLETE_STREAM",
        "true, creation, completed, INCOMPLETE_STREAM",
        "false, followup, completed, INCOMPLETE_STREAM",
        "true, followup, completed, INCOMPLETE_STREAM",
        "false, creation, foreign, STREAM_ERROR",
        "true, creation, foreign, STREAM_ERROR",
        "false, creation, resumed, STREAM_ERROR",
        "true, creation, resumed, STREAM_ERROR",
    )
    fun `budget EOF preserves boundary-specific failure and turn identity`(
        async: Boolean,
        streamKind: String,
        boundary: String,
        expectedReason: AgentTurnResultException.Reason,
    ) {
        val inProgress =
            """{"type":"agent.session.in_progress","event_id":"resumed","session":{"id":"s","status":"in_progress"}}"""
        val frames =
            mutableListOf(turn("created"), budget(if (boundary == "foreign") "other" else "s"))
        if (boundary != "foreign") frames.add(0, created)
        if (boundary == "completed") frames.add(turn("completed"))
        if (boundary == "resumed") frames.add(inProgress)
        val transport = Transport(frames)
        transport.client().useClient { client ->
            val handlers = AgentToolHandlers.builder().build()
            val failure =
                if (async) {
                    val sessions = client.async().beta().agents().sessions()
                    val stream =
                        if (streamKind == "raw") sessions.createStreaming(creationParams())
                        else if (streamKind == "creation")
                            sessions.createStreaming(creationParams(), handlers)
                        else sessions.stream(followUp())
                    assertThrows<ExecutionException> {
                            AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS)
                        }
                        .cause as AgentTurnResultException
                } else {
                    val sessions = client.beta().agents().sessions()
                    val stream =
                        if (streamKind == "raw") sessions.createStreaming(creationParams())
                        else if (streamKind == "creation")
                            sessions.createStreaming(creationParams(), handlers)
                        else sessions.stream(followUp())
                    stream.use {
                        assertThrows<AgentTurnResultException> {
                            AgentTurnResults.getFinalResult(it)
                        }
                    }
                }
            assertThat(failure.reason()).isEqualTo(expectedReason)
            assertThat(failure.sessionId()).contains("s")
            assertThat(failure.turnId()).contains("root")
            assertThat(failure.turn()).isPresent()
            if (boundary == "completed")
                assertThat(failure.turn().get().status().toString()).isEqualTo("completed")
            assertThat(transport.awaitStreamClosed()).isTrue()
        }
    }

    private fun <T> OpenAIClientImpl.useClient(block: (OpenAIClientImpl) -> T): T =
        try {
            block(this)
        } finally {
            close()
        }

    private inner class Transport(private val events: List<String>) : HttpClient {
        private val streamClosed = CountDownLatch(1)

        fun awaitStreamClosed() = streamClosed.await(5, TimeUnit.SECONDS)

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            val streaming =
                request.pathSegments.last() == "events" && request.method == HttpMethod.GET ||
                    request.pathSegments.last() == "sessions" && request.method == HttpMethod.POST
            val body =
                if (streaming) events.joinToString("") { "data: $it\n\n" }
                else if (request.method == HttpMethod.POST) "" else """{"id":"s","status":"idle"}"""
            return object : HttpResponse {
                override fun statusCode() =
                    if (request.method == HttpMethod.POST && !streaming) 204 else 200

                override fun headers() =
                    Headers.builder()
                        .put(
                            "Content-Type",
                            if (streaming) "text/event-stream" else "application/json",
                        )
                        .build()

                override fun body() = ByteArrayInputStream(body.toByteArray())

                override fun close() {
                    if (streaming) streamClosed.countDown()
                }
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}

        fun client() =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(this)
                    .apiKey("synthetic")
                    .streamHandlerExecutor(Executor { it.run() })
                    .maxRetries(0)
                    .build()
            )
    }
}
