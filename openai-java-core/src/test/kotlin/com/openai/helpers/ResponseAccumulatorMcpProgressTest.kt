package com.openai.helpers

import com.openai.core.jsonMapper
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponsesServerEvent
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ResponseAccumulatorMcpProgressTest {
    private val mapper = jsonMapper()
    private var sequenceNumber = 0L

    private fun send(state: ResponseAccumulator, websocket: Boolean, frame: String) {
        val node = mapper.readTree(frame) as com.fasterxml.jackson.databind.node.ObjectNode
        node.put("sequence_number", sequenceNumber++)
        if (websocket) {
            val event = mapper.treeToValue(node, ResponsesServerEvent::class.java).validate()
            assertThat(state.accumulate(event)).isSameAs(event)
        } else {
            val event = mapper.treeToValue(node, ResponseStreamEvent::class.java).validate()
            assertThat(state.accumulate(event)).isSameAs(event)
        }
    }

    private fun start(state: ResponseAccumulator, websocket: Boolean, seed: String = "") {
        send(
            state,
            websocket,
            """{"type":"response.created","sequence_number":0,"response":{"id":"resp_mcp","object":"response","created_at":1.0,"model":"fixture-model","output":[],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"in_progress"}}""",
        )
        send(
            state,
            websocket,
            """{"type":"response.output_item.added","sequence_number":1,"output_index":0,"item":${mcpItem("mcp_current", seed)}}""",
        )
    }

    private fun mcpItem(id: String, arguments: String, status: String = "in_progress") =
        """{"type":"mcp_call","id":"$id","name":"lookup","server_label":"fixture","arguments":${mapper.writeValueAsString(arguments)},"status":"$status","fixture_metadata":{"keep":true}}"""

    private fun progress(
        state: ResponseAccumulator,
        websocket: Boolean,
        kind: String,
        value: String,
        id: String = "mcp_current",
        index: Int = 0,
    ) {
        val field = if (kind == "delta") "delta" else "arguments"
        send(
            state,
            websocket,
            """{"type":"response.mcp_call_arguments.$kind","sequence_number":2,"output_index":$index,"item_id":"$id","$field":${mapper.writeValueAsString(value)}}""",
        )
    }

    private fun terminal(item: String) =
        """{"type":"response.completed","sequence_number":9,"response":{"id":"resp_mcp","object":"response","created_at":1.0,"model":"fixture-model","output":[${item.replace("\"status\":\"in_progress\"", "\"status\":\"completed\"")}],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"completed"}}"""

    @ParameterizedTest(name = "{displayName} websocket={0}")
    @ValueSource(booleans = [true, false])
    fun mcpArgumentsDeltaAppearsBeforeTerminal(websocket: Boolean) {
        val state = ResponseAccumulator.createWithSnapshots()
        start(state, websocket)
        val before = state.snapshot().get()
        send(
            state,
            websocket,
            """{"type":"response.mcp_call_arguments.delta","sequence_number":2,"output_index":0,"item_id":"mcp_current","delta":"{}"}""",
        )
        assertThat(state.snapshot().get().outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{}")
        assertThat(before.outputOrThrow().single().asMcpCall().argumentsOrThrow()).isEmpty()
    }

    @ParameterizedTest(name = "{displayName} websocket={0}")
    @ValueSource(booleans = [true, false])
    fun mcpArgumentsDoneReplacesObservedInputBeforeTerminal(websocket: Boolean) {
        val state = ResponseAccumulator.createWithSnapshots()
        start(state, websocket)
        send(
            state,
            websocket,
            """{"type":"response.mcp_call_arguments.done","sequence_number":2,"output_index":0,"item_id":"mcp_current","arguments":"{}"}""",
        )
        assertThat(state.snapshot().get().outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{}")
    }

    @ParameterizedTest(name = "{displayName} websocket={0}")
    @ValueSource(booleans = [true, false])
    fun mcpProgressPreservesMetadataAndAuthoritativeReplacements(websocket: Boolean) {
        val state = ResponseAccumulator.createWithSnapshots()
        start(state, websocket, "{")
        val seed = state.snapshot().get()
        progress(state, websocket, "delta", "\"part\":")
        progress(state, websocket, "delta", "1}")
        val partial = state.snapshot().get()
        val call = partial.outputOrThrow().single().asMcpCall()
        assertThat(call.argumentsOrThrow()).isEqualTo("{\"part\":1}")
        assertThat(call.idOrThrow()).isEqualTo("mcp_current")
        assertThat(call.nameOrThrow()).isEqualTo("lookup")
        assertThat(call.serverLabelOrThrow()).isEqualTo("fixture")
        assertThat(
                mapper
                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(call)
                    .path("status")
                    .asText()
            )
            .isEqualTo("in_progress")
        assertThat(
                mapper
                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(call)
                    .path("fixture_metadata")
                    .path("keep")
                    .asBoolean()
            )
            .isTrue()
        progress(state, websocket, "done", "{\"done\":2}")
        val done = state.snapshot().get()
        assertThat(done.outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{\"done\":2}")
        assertThat(
                mapper
                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(
                        done.outputOrThrow().single()
                    )
                    .path("fixture_metadata")
                    .path("keep")
                    .asBoolean()
            )
            .isTrue()
        assertThat(partial.outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{\"part\":1}")
        assertThat(seed.outputOrThrow().single().asMcpCall().argumentsOrThrow()).isEqualTo("{")
        send(
            state,
            websocket,
            """{"type":"response.output_item.done","sequence_number":7,"output_index":0,"item":${mcpItem("mcp_current", "{\"full\":3}", "completed")}}""",
        )
        assertThat(state.snapshot().get().outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{\"full\":3}")
        send(state, websocket, terminal(mcpItem("mcp_current", "{\"final\":4}")))
        val authoritative = state.response()
        assertThat(authoritative.outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{\"final\":4}")
        progress(state, websocket, "done", "{\"late\":5}")
        assertThat(state.snapshot().get()).isSameAs(authoritative)
        assertThat(done.outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{\"done\":2}")
    }

    @ParameterizedTest(name = "{displayName} websocket={0}")
    @ValueSource(booleans = [true, false])
    fun mcpProgressRequiresCurrentMcpIdentityAndObservedScaffolding(websocket: Boolean) {
        val state = ResponseAccumulator.createWithSnapshots()
        start(state, websocket, "{}")
        val original = state.snapshot().get()
        for (kind in listOf("delta", "done")) {
            progress(state, websocket, kind, "{}", id = "old")
            progress(state, websocket, kind, "{}", index = 1)
        }
        assertThat(state.snapshot().get()).isSameAs(original)
        send(
            state,
            websocket,
            """{"type":"response.output_item.added","sequence_number":3,"output_index":0,"item":${mcpItem("replacement", "{\"new\":1}")}}""",
        )
        val replaced = state.snapshot().get()
        for (kind in listOf("delta", "done")) progress(state, websocket, kind, "{}")
        assertThat(state.snapshot().get()).isSameAs(replaced)
        send(
            state,
            websocket,
            """{"type":"response.output_item.added","sequence_number":4,"output_index":0,"item":{"type":"function_call","id":"mcp_current","call_id":"call_fixture","name":"lookup","arguments":"{}","status":"in_progress"}}""",
        )
        val function = state.snapshot().get()
        for (kind in listOf("delta", "done")) progress(state, websocket, kind, "{}")
        assertThat(state.snapshot().get()).isSameAs(function)
        val empty = ResponseAccumulator.createWithSnapshots()
        for (kind in listOf("delta", "done")) progress(empty, websocket, kind, "{}")
        assertThat(empty.snapshot()).isEmpty()
    }

    @ParameterizedTest(name = "{displayName} websocket={0}")
    @ValueSource(booleans = [true, false])
    fun defaultAccumulatorStillUsesOnlyTerminalMcpArguments(websocket: Boolean) {
        val state = ResponseAccumulator.create()
        start(state, websocket)
        progress(state, websocket, "delta", "{}")
        progress(state, websocket, "done", "{\"done\":1}")
        assertThatThrownBy { state.snapshot() }.isInstanceOf(IllegalStateException::class.java)
        send(state, websocket, terminal(mcpItem("mcp_current", "{\"final\":2}")))
        assertThat(state.response().outputOrThrow().single().asMcpCall().argumentsOrThrow())
            .isEqualTo("{\"final\":2}")
    }
}
