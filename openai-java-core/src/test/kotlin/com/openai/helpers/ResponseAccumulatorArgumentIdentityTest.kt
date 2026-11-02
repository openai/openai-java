package com.openai.helpers

import com.fasterxml.jackson.databind.node.ObjectNode
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesServerEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ResponseAccumulatorArgumentIdentityTest {
    private val mapper = jsonMapper()
    private var sequenceNumber = 0L

    private fun send(state: ResponseAccumulator, frame: String) {
        val node = mapper.readTree(frame) as ObjectNode
        node.put("sequence_number", sequenceNumber++)
        val event = mapper.treeToValue(node, ResponsesServerEvent::class.java).validate()
        assertThat(state.accumulate(event)).isSameAs(event)
    }

    private fun current(state: ResponseAccumulator): ObjectNode =
        mapper.readTree(mapper.writeValueAsString(state.snapshot().get().output().single()))
            as ObjectNode

    @ParameterizedTest(name = "existing argument snapshots {0}, id present={1}")
    @CsvSource(
        "function_call, true",
        "function_call, false",
        "custom_tool_call, true",
        "custom_tool_call, false",
    )
    fun initialAndFinalScalarUpdatesRespectCurrentSlotAndPreserveRawId(
        kind: String,
        present: Boolean,
    ) {
        val field = if (kind == "function_call") "arguments" else "input"
        val eventKind =
            if (kind == "function_call") "function_call_arguments" else "custom_tool_call_input"
        val otherKind =
            if (kind == "function_call") "custom_tool_call_input" else "function_call_arguments"
        val prefix = if (kind == "function_call") "{\"v\":\"" else "seed:"
        val scalar = """{"v":"authoritative scalar"}"""
        val firstDone = """{"v":"first done"}"""
        val ignored = """{"v":"ignored"}"""
        val item =
            mapper
                .createObjectNode()
                .put("type", kind)
                .put("call_id", "call_fixture")
                .put("name", "fixture")
                .put(field, prefix)
                .put("status", "in_progress")
                .put("future_metadata", "received")
        if (present) item.put("id", "observed")
        fun start(): ResponseAccumulator {
            val state = ResponseAccumulator.createWithSnapshots()
            send(
                state,
                """{"type":"response.created","response":{"id":"resp_fixture","object":"response","created_at":1.0,"model":"fixture-model","output":[],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"in_progress"}}""",
            )
            send(state, """{"type":"response.output_item.added","output_index":0,"item":$item}""")
            assertThat(current(state)).isEqualTo(item)
            return state
        }

        val state = start()
        val before = current(state)
        // A scalar event for a different item kind must not claim an absent optional id.
        send(
            state,
            """{"type":"response.$otherKind.delta","output_index":0,"item_id":"wrong_kind","delta":"ignored"}""",
        )
        // Empty content is still an admitted update, so a different id cannot take its place.
        send(
            state,
            """{"type":"response.$eventKind.delta","output_index":0,"item_id":"observed","delta":""}""",
        )
        send(
            state,
            """{"type":"response.$eventKind.delta","output_index":0,"item_id":"conflicting","delta":"ignored"}""",
        )
        assertThat(current(state)).isEqualTo(item)
        send(
            state,
            """{"type":"response.$eventKind.delta","output_index":0,"item_id":"observed","delta":"first"}""",
        )
        send(
            state,
            """{"type":"response.$eventKind.delta","output_index":0,"item_id":"conflicting","delta":"ignored"}""",
        )
        assertThat(current(state)).isEqualTo(item.deepCopy().put(field, prefix + "first"))
        assertThat(before).isEqualTo(item)
        send(
            state,
            """{"type":"response.$eventKind.done","output_index":0,"item_id":"observed","$field":${mapper.writeValueAsString(scalar)}}""",
        )
        send(
            state,
            """{"type":"response.$eventKind.delta","output_index":0,"item_id":"conflicting","delta":"ignored"}""",
        )
        send(
            state,
            """{"type":"response.$eventKind.done","output_index":0,"item_id":"conflicting","$field":${mapper.writeValueAsString(ignored)}}""",
        )
        assertThat(current(state)).isEqualTo(item.deepCopy().put(field, scalar))
        val whole =
            item
                .deepCopy()
                .put(field, """{"v":"whole item"}""")
                .put("status", "completed")
                .put("future_metadata", "authoritative")
        send(state, """{"type":"response.output_item.done","output_index":0,"item":$whole}""")
        assertThat(current(state)).isEqualTo(whole)

        // First accepted update may be field-done on a new, fully scaffolded item.
        val direct = start()
        send(
            direct,
            """{"type":"response.$eventKind.done","output_index":0,"item_id":"observed","$field":${mapper.writeValueAsString(firstDone)}}""",
        )
        send(
            direct,
            """{"type":"response.$eventKind.done","output_index":0,"item_id":"conflicting","$field":${mapper.writeValueAsString(ignored)}}""",
        )
        assertThat(current(direct)).isEqualTo(item.deepCopy().put(field, firstDone))
        val terminal = whole.deepCopy().put(field, """{"v":"terminal"}""")
        send(
            direct,
            """{"type":"response.completed","response":{"id":"resp_fixture","object":"response","created_at":1.0,"model":"fixture-model","output":[$terminal],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"completed"}}""",
        )
        assertThat(current(direct)).isEqualTo(terminal)
        assertThat(mapper.readTree(mapper.writeValueAsString(direct.response().output().single())))
            .isEqualTo(terminal)
    }
}
