package com.openai.services.beta.agents

import com.fasterxml.jackson.databind.JsonNode
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.*
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentSessionAttachmentTest {
    private val mapper = jsonMapper()
    private val options =
        RequestOptions.builder().timeout(Duration.ofSeconds(7)).responseValidation(false).build()

    private fun turn(id: String = "root", status: String = "in_progress", child: Boolean = false) =
        """{"id":"$id","session_id":"s","status":"$status","subagent_id":${if (child) "\"child\"" else "null"}}"""

    private fun turnEvent(status: String = "completed", id: String = "root") =
        """{"type":"agent.session.turn.$status","event_id":"$id-$status","session_id":"s","turn_id":"$id","turn":${turn(id, status)}}"""

    private fun call(id: String = "call", owner: String = "root", event: String = id) =
        """{"type":"agent.session.turn.item.added","event_id":"$event","session_id":"s","turn_id":"$owner","item":{"id":"item-$id","type":"function_call","name":"lookup","call_id":"$id","turn_id":"$owner","arguments":{"order_id":"A123"},"status":"in_progress"}}"""

    private fun message(
        id: String,
        text: String,
        owner: String = "root",
        phase: String = "final_answer",
    ) =
        """{"id":"$id","type":"message","turn_id":"$owner","role":"assistant","status":"completed","phase":"$phase","content":[{"type":"output_text","text":"$text","annotations":[]}]}"""

    private fun page(vararg data: String, more: Boolean = false) =
        """{"object":"list","data":[${data.joinToString(",")}],"has_more":$more}"""

    private inner class Transport : HttpClient {
        var events = listOf(call(), turnEvent())
        var turnPages = mutableListOf(page(turn()))
        var turnResponses = mutableListOf(turn())
        var itemPages = mutableListOf(page(message("answer", "Shipped")))
        var sessionStatus = "in_progress"
        var requiredActions = "[]"
        var forbidStreamRead = false
        var streamClosed = false
        var postFailure = false
        var turnRequests = 0
        var itemRequests = 0
        var onOpen: () -> Unit = {}
        var onItems: () -> Unit = {}
        val requests = mutableListOf<HttpRequest>()
        val requestOptions = mutableListOf<RequestOptions>()
        val posts = mutableListOf<JsonNode>()

        private fun response(
            text: String,
            streaming: Boolean = false,
            status: Int = 200,
        ): HttpResponse {
            val bytes =
                object : ByteArrayInputStream(text.toByteArray()) {
                    override fun close() {
                        if (streaming) streamClosed = true
                        super.close()
                    }
                }
            val body: InputStream =
                if (streaming && forbidStreamRead)
                    object : InputStream() {
                        override fun read(): Int =
                            throw AssertionError(
                                "Attachment must settle without another live event"
                            )

                        override fun close() {
                            streamClosed = true
                        }
                    }
                else bytes
            return object : HttpResponse {
                override fun statusCode() = status

                override fun headers() =
                    Headers.builder()
                        .put(
                            "Content-Type",
                            if (streaming) "text/event-stream" else "application/json",
                        )
                        .build()

                override fun body() = body

                override fun close() = body.close()
            }
        }

        private fun next(values: MutableList<String>): String =
            if (values.size > 1) values.removeAt(0) else values.single()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            this.requestOptions.add(requestOptions)
            val path = request.pathSegments
            return when {
                request.method == HttpMethod.POST -> {
                    val bytes = ByteArrayOutputStream()
                    request.body!!.writeTo(bytes)
                    posts.add(mapper.readTree(bytes.toByteArray()))
                    if (postFailure)
                        response(
                            """{"error":{"message":"delivery uncertain","type":"server_error"}}""",
                            status = 503,
                        )
                    else response("", status = 204)
                }
                path.last() == "events" -> {
                    onOpen()
                    response(events.joinToString("") { "data: $it\n\n" }, streaming = true)
                }
                path.last() == "turns" -> response(next(turnPages))
                path[path.size - 2] == "turns" -> {
                    turnRequests++
                    response(next(turnResponses))
                }
                path.last() == "items" -> {
                    itemRequests++
                    onItems()
                    response(next(itemPages))
                }
                else ->
                    response(
                        """{"id":"s","status":"$sessionStatus","required_actions":$requiredActions}"""
                    )
            }
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            try {
                CompletableFuture.completedFuture(execute(request, requestOptions))
            } catch (error: Throwable) {
                CompletableFuture<HttpResponse>().apply { completeExceptionally(error) }
            }

        override fun close() {}

        fun client() =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(this)
                    .apiKey("synthetic")
                    .maxRetries(0)
                    .streamHandlerExecutor(Executor { it.run() })
                    .build()
            )
    }

    private fun <T> OpenAIClientImpl.useClient(block: (OpenAIClientImpl) -> T): T =
        try {
            block(this)
        } finally {
            close()
        }

    private fun params() =
        AgentSessionStreamParams.builder()
            .sessionId("s")
            .putAdditionalHeader("X-Attachment", "present")

    private fun collect(
        t: Transport,
        async: Boolean,
        params: AgentSessionStreamParams = params().build(),
    ): AgentTurnResult =
        t.client().useClient { client ->
            if (async)
                AgentTurnResults.getFinalResult(
                        client.async().beta().agents().sessions().stream(params, options)
                    )
                    .get(5, TimeUnit.SECONDS)
            else
                AgentTurnResults.getFinalResult(
                    client.beta().agents().sessions().stream(params, options)
                )
        }

    private fun drain(
        t: Transport,
        async: Boolean,
        params: AgentSessionStreamParams = params().build(),
    ): List<AgentSessionEvent> =
        t.client().useClient { client ->
            val events = mutableListOf<AgentSessionEvent>()
            if (async)
                client
                    .async()
                    .beta()
                    .agents()
                    .sessions()
                    .stream(params, options)
                    .subscribe { events.add(it) }
                    .onCompleteFuture()
                    .get(5, TimeUnit.SECONDS)
            else
                client.beta().agents().sessions().stream(params, options).use {
                    it.stream().forEach(events::add)
                }
            events
        }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `attachment reuses dispatcher without input and deduplicates pending live overlap`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                sessionStatus = "requires_action"
                events = listOf(call(), call(event = "live-copy"), turnEvent())
            }
        var calls = 0
        val result =
            collect(
                t,
                async,
                params()
                    .toolHandler("lookup") {
                        calls++
                        "Shipped"
                    }
                    .build(),
            )
        assertThat(calls).isEqualTo(1)
        assertThat(t.posts).hasSize(1)
        assertThat(t.posts.single().path("events").single().path("type").asText())
            .isEqualTo("agent.session.input.tool_result")
        assertThat(result.outputText()).isEqualTo("Shipped")
        assertThat(t.streamClosed).isTrue()
        assertThat(t.requests).allSatisfy {
            assertThat(it.headers.values("X-Attachment")).contains("present")
        }
        assertThat(t.requestOptions).allSatisfy {
            assertThat(it.timeout).isEqualTo(options.timeout)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `raw attachment retains no output history and never reads durable items`(async: Boolean) {
        val t = Transport().apply { events = listOf(turnEvent()) }
        assertThat(drain(t, async)).hasSize(1)
        assertThat(t.itemRequests).isZero()
        assertThat(t.posts).isEmpty()
        assertThat(t.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `completion in handshake settles selected root while another root is running`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnResponses = mutableListOf(turn(status = "completed"))
                sessionStatus = "in_progress"
                forbidStreamRead = true
                events = listOf(call(owner = "new-root"))
            }
        var calls = 0
        assertThat(
                collect(
                        t,
                        async,
                        params()
                            .toolHandler("lookup") {
                                calls++
                                "unexpected"
                            }
                            .build(),
                    )
                    .turnId()
            )
            .isEqualTo("root")
        assertThat(calls).isZero()
        assertThat(t.posts).isEmpty()
        assertThat(t.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `idle existing history drains without selecting an old answer`(async: Boolean) {
        fun idleTransport() =
            Transport().apply {
                turnPages = mutableListOf(page(turn(status = "completed")))
                sessionStatus = "idle"
                forbidStreamRead = true
            }
        val raw = idleTransport()
        assertThat(drain(raw, async)).isEmpty()
        assertThat(raw.posts).isEmpty()
        assertThat(raw.itemRequests).isZero()
        assertThatThrownBy { collect(idleTransport(), async) }
            .hasStackTraceContaining("NO_SELECTED_TURN")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `new root can start and finish between the two attachment snapshots`(async: Boolean) {
        val t =
            Transport().apply {
                turnPages =
                    mutableListOf(page(turn("old", "completed")), page(turn(status = "completed")))
                sessionStatus = "idle"
                forbidStreamRead = true
            }
        assertThat(collect(t, async).turnId()).isEqualTo("root")
        assertThat(t.posts).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `turn and durable item pagination preserve options and selected root isolation`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnPages =
                    mutableListOf(page(turn("child-turn", child = true), more = true), page(turn()))
                events = listOf(turnEvent())
                itemPages =
                    mutableListOf(
                        page(
                            message("old", "Old", owner = "old"),
                            message("note", "Thinking", phase = "commentary"),
                            more = true,
                        ),
                        page(message("answer", "Shipped")),
                    )
            }
        val result = collect(t, async)
        assertThat(result.outputText()).isEqualTo("Shipped")
        assertThat(result.messages()).hasSize(1)
        assertThat(t.itemRequests).isEqualTo(2)
        assertThat(t.requestOptions).allSatisfy {
            assertThat(it.timeout).isEqualTo(options.timeout)
        }
        assertThat(t.requests).allSatisfy {
            assertThat(it.headers.values("X-Attachment")).contains("present")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `call first attachment identifies its root without a startup event`(async: Boolean) {
        val t = Transport().apply { turnPages = mutableListOf(page(), page(), page(turn())) }
        var calls = 0
        assertThat(
                collect(
                        t,
                        async,
                        params()
                            .toolHandler("lookup") {
                                calls++
                                "Shipped"
                            }
                            .build(),
                    )
                    .outputText()
            )
            .isEqualTo("Shipped")
        assertThat(calls).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `attachment never dispatches calls owned by another root`(async: Boolean) {
        val t =
            Transport().apply {
                events = listOf(call(id = "other-call", owner = "other"), call(), turnEvent())
            }
        var calls = 0
        collect(
            t,
            async,
            params()
                .toolHandler("lookup") {
                    calls++
                    "Shipped"
                }
                .build(),
        )
        assertThat(calls).isEqualTo(1)
        assertThat(t.posts.single().path("events").single().path("turn_id").asText())
            .isEqualTo("root")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `handler failures remain redacted and submission failures remain visible`(async: Boolean) {
        val t = Transport()
        collect(
            t,
            async,
            params().toolHandler("lookup") { throw IllegalStateException("private-canary") }.build(),
        )
        assertThat(t.posts.single().toString()).doesNotContain("private-canary")
        assertThat(t.posts.single().path("events").single().path("success").asBoolean()).isFalse()
        val failure = Transport().apply { postFailure = true }
        assertThatThrownBy {
                collect(failure, async, params().toolHandler("lookup") { "Shipped" }.build())
            }
            .hasStackTraceContaining("STREAM_ERROR")
        assertThat(failure.streamClosed).isTrue()
        assertThat(failure.turnRequests).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `observation loss reconciles only its known selected root once`(async: Boolean) {
        for (events in listOf(emptyList(), listOf("invalid-json"))) {
            val t =
                Transport().apply {
                    this.events = events
                    turnResponses = mutableListOf(turn(), turn(status = "completed"))
                }
            assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
            assertThat(t.turnRequests).isEqualTo(2)
            assertThat(t.posts).isEmpty()
            assertThat(t.streamClosed).isTrue()
        }
        val stillRunning = Transport().apply { events = emptyList() }
        assertThatThrownBy { collect(stillRunning, async) }.hasStackTraceContaining("STREAM_ERROR")
        assertThat(stillRunning.turnRequests).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `opt in progress collection reconciles durable answer before final getter`(async: Boolean) {
        val t = Transport().apply { events = listOf(turnEvent()) }
        t.client().useClient { client ->
            val result =
                if (async) {
                    val stream =
                        AgentTurnResults.withResultCollection(
                            client
                                .async()
                                .beta()
                                .agents()
                                .sessions()
                                .stream(params().build(), options)
                        )
                    stream.subscribe {}.onCompleteFuture().get(5, TimeUnit.SECONDS)
                    AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS)
                } else {
                    val stream =
                        AgentTurnResults.withResultCollection(
                            client.beta().agents().sessions().stream(params().build(), options)
                        )
                    stream.stream().forEach {}
                    AgentTurnResults.getFinalResult(stream)
                }
            assertThat(result.outputText()).isEqualTo("Shipped")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `reattachment does not execute calls already answered before disconnect`(async: Boolean) {
        var calls = 0
        val params =
            params()
                .toolHandler("lookup") {
                    calls++
                    "Shipped"
                }
                .build()
        val first = Transport().apply { events = listOf(call()) }
        assertThatThrownBy { collect(first, async, params) }.hasStackTraceContaining("STREAM_ERROR")
        val next = Transport().apply { events = listOf(turnEvent()) }
        assertThat(collect(next, async, params).outputText()).isEqualTo("Shipped")
        assertThat(calls).isEqualTo(1)
        assertThat(next.posts).isEmpty()
    }

    private fun requiresAction(owner: String) =
        """{"type":"agent.session.requires_action","event_id":"action-$owner","session":{"id":"s","status":"requires_action","required_actions":[{"type":"function_call","name":"manual","call_id":"call","turn_id":"$owner"}]}}"""

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `manual action first identifies selected root without executing snapshot actions`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page(), page(), page(turn()))
                events = listOf(requiresAction("root"))
            }
        assertThatThrownBy { collect(t, async) }.hasStackTraceContaining("REQUIRES_ACTION")
        assertThat(t.posts).isEmpty()
        assertThat(t.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `another root's required actions do not interrupt selected output`(async: Boolean) {
        val t = Transport().apply { events = listOf(requiresAction("other"), turnEvent()) }
        assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `zero event raw attachment cannot enable result retention after observation`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page(turn(status = "completed")))
                sessionStatus = "idle"
                forbidStreamRead = true
            }
        t.client().useClient { client ->
            if (async) {
                val stream =
                    client.async().beta().agents().sessions().stream(params().build(), options)
                stream.subscribe {}.onCompleteFuture().get(5, TimeUnit.SECONDS)
                assertThatThrownBy { AgentTurnResults.getFinalResult(stream) }
                    .hasMessageContaining("before consuming")
            } else {
                val stream = client.beta().agents().sessions().stream(params().build(), options)
                stream.stream().forEach {}
                assertThatThrownBy { AgentTurnResults.getFinalResult(stream) }
                    .hasMessageContaining("before consuming")
            }
        }
        assertThat(t.itemRequests).isZero()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `unhandled recovered call fails fast without needing a requires action event`(
        async: Boolean
    ) {
        val t = Transport().apply { events = listOf(call(), "invalid-json") }
        assertThatThrownBy { collect(t, async) }.hasStackTraceContaining("REQUIRES_ACTION")
        assertThat(t.posts).isEmpty()
        assertThat(t.turnRequests).isEqualTo(1)
        assertThat(t.streamClosed).isTrue()
    }

    private fun environmentAction() =
        """{"type":"agent.session.requires_action","event_id":"env-action","session":{"id":"s","status":"requires_action","required_actions":[{"type":"environment_connection","environment_id":"env"}]}}"""

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `live environment action cannot select or block an unidentified root`(async: Boolean) {
        val t =
            Transport().apply {
                turnPages =
                    mutableListOf(page(), page(), page(), page(), page(turn(status = "completed")))
                events = listOf(environmentAction(), turnEvent())
            }
        assertThat(collect(t, async).turnId()).isEqualTo("root")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `live environment action for successor settles the selected completed root`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page(turn()), page(turn("successor", "waiting")))
                turnResponses = mutableListOf(turn(), turn(status = "completed"))
                events = listOf(environmentAction(), call(owner = "successor"))
            }
        assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
        assertThat(t.posts).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `live environment action reports only the current selected waiting root`(async: Boolean) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page(turn(status = "waiting")))
                turnResponses = mutableListOf(turn(status = "waiting"))
                events = listOf(environmentAction(), "invalid-json")
            }
        assertThatThrownBy { collect(t, async) }.hasStackTraceContaining("REQUIRES_ACTION")
        assertThat(t.posts).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `failed and cancelled attachment errors retain paginated durable output`(async: Boolean) {
        for (status in listOf("failed", "cancelled")) {
            val t =
                Transport().apply {
                    turnResponses = mutableListOf(turn(status = status))
                    forbidStreamRead = true
                    itemPages =
                        mutableListOf(
                            page(message("old", "Old", owner = "other"), more = true),
                            page(message("answer", "Partial answer")),
                        )
                }
            val cause = catchThrowable { collect(t, async) }
            val error = unwrap(cause) as AgentTurnResultException
            assertThat(error.reason())
                .isEqualTo(
                    if (status == "failed") AgentTurnResultException.Reason.TURN_FAILED
                    else AgentTurnResultException.Reason.TURN_CANCELLED
                )
            assertThat(error.messages()).hasSize(1)
            assertThat(error.messages().single().content().single().asOutputText().text())
                .isEqualTo("Partial answer")
            assertThat(t.itemRequests).isEqualTo(2)
            assertThat(t.streamClosed).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `stale baseline and different historical roots cannot select a previous answer`(
        async: Boolean
    ) {
        for (old in listOf("baseline", "older")) {
            val t =
                Transport().apply {
                    turnPages =
                        mutableListOf(
                            page(turn("baseline", "completed")),
                            page(turn("baseline", "completed")),
                            page(turn("baseline", "completed")),
                            page(turn(status = "completed")),
                        )
                    events = listOf(turnEvent("created", old), turnEvent("completed"))
                }
            assertThat(collect(t, async).turnId()).isEqualTo("root")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `buffered idle cannot stop a nonidle attachment before root identification`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page(), page(), page(), page(turn()))
                events =
                    listOf(
                        """{"type":"agent.session.idle","event_id":"old-idle","session":{"id":"s","status":"idle","required_actions":[]}}""",
                        turnEvent(),
                    )
            }
        assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `session failure recovers earlier output even when cached turn has not settled`(
        async: Boolean
    ) {
        for (snapshot in listOf(false, true)) {
            val t =
                Transport().apply {
                    if (snapshot) {
                        sessionStatus = "failed"
                        forbidStreamRead = true
                    } else
                        events =
                            listOf(
                                """{"type":"agent.session.failed","event_id":"failed","session":{"id":"s","status":"failed","required_actions":[]}}"""
                            )
                }
            val error = unwrap(catchThrowable { collect(t, async) }) as AgentTurnResultException
            assertThat(error.reason()).isEqualTo(AgentTurnResultException.Reason.TURN_FAILED)
            assertThat(error.messages()).hasSize(1)
            assertThat(t.itemRequests).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `environment connection before any root reports a manual diagnostic`(async: Boolean) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page())
                sessionStatus = "requires_action"
                requiredActions = """[{"type":"environment_connection","environment_id":"env"}]"""
                forbidStreamRead = true
            }
        val error = unwrap(catchThrowable { collect(t, async) }) as AgentTurnResultException
        assertThat(error.reason()).isEqualTo(AgentTurnResultException.Reason.REQUIRES_ACTION)
        assertThat(error.turnId()).isEmpty()
        assertThat(error.sessionId()).contains("s")
        assertThat(error.requiredActions()).hasSize(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `closing during the first history page stops further reconciliation requests`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnResponses = mutableListOf(turn(status = "completed"))
                itemPages =
                    mutableListOf(
                        page(message("one", "One"), more = true),
                        page(message("two", "Two")),
                    )
                forbidStreamRead = true
            }
        t.client().useClient { client ->
            if (async) {
                val stream =
                    client.async().beta().agents().sessions().stream(params().build(), options)
                t.onItems = { stream.close() }
                assertThatThrownBy {
                        AgentTurnResults.getFinalResult(stream).get(5, TimeUnit.SECONDS)
                    }
                    .hasStackTraceContaining("CLOSED")
            } else {
                val stream = client.beta().agents().sessions().stream(params().build(), options)
                t.onItems = { stream.close() }
                assertThatThrownBy { AgentTurnResults.getFinalResult(stream) }
                    .hasStackTraceContaining("CLOSED")
            }
        }
        assertThat(t.itemRequests).isEqualTo(1)
        assertThat(t.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `session failure cannot replace a completed selected root outcome`(async: Boolean) {
        for (snapshot in listOf(false, true)) {
            val t =
                Transport().apply {
                    turnResponses = mutableListOf(turn(), turn(status = "completed"))
                    if (snapshot) {
                        sessionStatus = "failed"
                        forbidStreamRead = true
                    } else
                        events =
                            listOf(
                                """{"type":"agent.session.failed","event_id":"failed","session":{"id":"s","status":"failed","required_actions":[]}}"""
                            )
                }
            assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `failure without a selected root does not scan unrelated history`(async: Boolean) {
        val t =
            Transport().apply {
                turnPages = mutableListOf(page())
                sessionStatus = "failed"
                forbidStreamRead = true
            }
        assertThatThrownBy { collect(t, async) }.hasStackTraceContaining("TURN_FAILED")
        assertThat(t.itemRequests).isZero()
    }

    private fun approval(owner: String = "root", kind: String = "browser_authentication") =
        """{"type":"computer_use_approval_request","turn_id":"$owner","request_id":"approval","request":{"type":"$kind","origin":"https://example.com"}}"""

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `manual snapshot approvals stop collected attachment without waiting for replay`(
        async: Boolean
    ) {
        for (kind in
            listOf("browser_authentication", "browser_origin_access", "environment_connection")) {
            val t =
                Transport().apply {
                    turnPages = mutableListOf(page(turn(status = "waiting")))
                    turnResponses = mutableListOf(turn(status = "waiting"))
                    sessionStatus = "requires_action"
                    requiredActions =
                        if (kind == "environment_connection")
                            """[{"type":"environment_connection","environment_id":"env"}]"""
                        else "[${approval(kind = kind)}]"
                    forbidStreamRead = true
                }
            assertThatThrownBy { collect(t, async) }.hasStackTraceContaining("REQUIRES_ACTION")
            assertThat(t.posts).isEmpty()
            assertThat(t.streamClosed).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `snapshot diagnostics exclude function actions and approvals from other turns`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnResponses = mutableListOf(turn(status = "waiting"))
                sessionStatus = "requires_action"
                requiredActions =
                    """[${approval("other")},{"type":"function_call","turn_id":"root","name":"manual","call_id":"already-answered"}]"""
                events = listOf(turnEvent())
            }
        assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
        assertThat(t.posts).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `environment diagnostic verifies current root and exact selected turn after snapshot`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                turnPages =
                    mutableListOf(
                        page(turn(status = "waiting")),
                        page(turn("successor", "waiting")),
                    )
                turnResponses = mutableListOf(turn(status = "waiting"), turn(status = "completed"))
                sessionStatus = "requires_action"
                requiredActions = """[{"type":"environment_connection","environment_id":"env"}]"""
                forbidStreamRead = true
            }
        assertThat(collect(t, async).outputText()).isEqualTo("Shipped")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `raw attachments do not retain or stop on manual snapshot diagnostics`(async: Boolean) {
        val t =
            Transport().apply {
                turnResponses = mutableListOf(turn(status = "waiting"))
                sessionStatus = "requires_action"
                requiredActions = "[${approval()}]"
            }
        assertThat(drain(t, async)).hasSize(2)
        assertThat(t.itemRequests).isZero()
    }

    @Test
    fun `explicit empty input remains invalid while omitted input means attachment`() {
        params().build()
        assertThatThrownBy { params().input("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { params().input(emptyList()) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
