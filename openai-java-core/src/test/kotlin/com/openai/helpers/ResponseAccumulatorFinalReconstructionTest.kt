package com.openai.helpers

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesServerEvent
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ResponseAccumulatorFinalReconstructionTest {
    private val mapper = jsonMapper()

    private fun send(state: ResponseAccumulator, json: String): ResponsesServerEvent {
        val event = mapper.readValue(json, ResponsesServerEvent::class.java)
        assertThat(state.accumulate(event)).isSameAs(event)
        return event
    }

    private fun done(index: Long, arguments: String) =
        """{"type":"response.output_item.done","sequence_number":1,"output_index":$index,"item":{"type":"function_call","id":"f","call_id":"c","name":"never_run","arguments":"$arguments"}}"""

    // Omitted/null output is an explicit compatibility case, not schema-valid service output.
    private fun terminal(status: String = "completed", output: String = "") =
        """{"type":"response.$status","sequence_number":9,"response":{"id":"r","status":"$status","provider_metadata":{"retained":true}$output}}"""

    @Test
    fun finalizedRecordsAreSortedReplacedAndIndependentOfPartialSnapshots() {
        val state = ResponseAccumulator.createWithSnapshots()
        send(state, done(8, "first"))
        send(state, done(2, "second"))
        send(state, done(8, "replacement"))
        send(
            state,
            """{"type":"response.output_item.added","sequence_number":4,"output_index":2,"item":{"type":"function_call","id":"new","call_id":"new","name":"never_run","arguments":"partial"}}""",
        )
        send(state, terminal())
        val original = state.response()
        val reconstructed = state.reconstructedResponse()
        assertThat(reconstructed.outputOrThrow().map { it.asFunctionCall().argumentsOrThrow() })
            .containsExactly("second", "replacement")
        assertThat(original._output().isMissing()).isTrue()
        assertThat(state.snapshot().get()).isSameAs(original)
        assertThat(reconstructed._allProperties()["provider_metadata"])
            .isEqualTo(original._allProperties()["provider_metadata"])
        assertThat(state.response()).isSameAs(original)
        send(state, done(0, "late"))
        send(state, """{"type":"error","error":{"message":"late"}}""")
        assertThat(state.reconstructedResponse()).isEqualTo(reconstructed)
    }

    @Test
    fun everySuppliedNonNullOutputWinsWithoutReinterpretation() {
        for (output in listOf("[]", "[{\"type\":\"future_tool\"}]", "{\"opaque\":true}", "false")) {
            val state = ResponseAccumulator.createWithSnapshots()
            send(state, done(1, "ignored"))
            send(state, terminal(output = ",\"output\":$output"))
            assertThat(state.reconstructedResponse()).isSameAs(state.response())
            assertThat(state.snapshot().get()).isSameAs(state.response())
        }
    }

    @Test
    fun missingAndNullOutputKeepFailedAndIncompleteTerminalMetadata() {
        for (status in listOf("completed", "failed", "incomplete")) {
            for (output in listOf("", ",\"output\":null")) {
                val state = ResponseAccumulator.createWithSnapshots()
                send(state, done(10, "final"))
                send(state, terminal(status, output))
                val actual = mapper.valueToTree<JsonNode>(state.reconstructedResponse())
                val expected = mapper.valueToTree<JsonNode>(state.response()).deepCopy<JsonNode>()
                (expected as com.fasterxml.jackson.databind.node.ObjectNode).set<JsonNode>(
                    "output",
                    actual.path("output"),
                )
                assertThat(actual).isEqualTo(expected)
                assertThat(actual.path("status").asText()).isEqualTo(status)
                assertThat(actual.path("output").single().path("arguments").asText())
                    .isEqualTo("final")
            }
        }
    }

    @Test
    fun unfinishedItemsNeverBecomeFinalAndEmptyFinalizedStateProducesEmptyOutput() {
        val state = ResponseAccumulator.createWithSnapshots()
        send(
            state,
            """{"type":"response.created","sequence_number":0,"response":{"id":"r","output":[{"type":"function_call","id":"f","call_id":"c","name":"never_run","arguments":"partial"}]}}""",
        )
        send(
            state,
            """{"type":"response.function_call_arguments.delta","sequence_number":1,"output_index":0,"item_id":"f","delta":"more"}""",
        )
        assertThatThrownBy { state.reconstructedResponse() }
            .isInstanceOf(IllegalStateException::class.java)
        send(state, terminal())
        assertThat(state.reconstructedResponse().outputOrThrow()).isEmpty()
    }

    @Test
    fun reconstructionRequiresOptInAndProtocolErrorsGuardOnlyTheNewAccessor() {
        val legacy = ResponseAccumulator.create()
        send(legacy, terminal(output = ",\"output\":[]"))
        assertThatThrownBy { legacy.reconstructedResponse() }
            .isInstanceOf(IllegalStateException::class.java)
        val state = ResponseAccumulator.createWithSnapshots()
        send(state, done(0, "before error"))
        send(state, """{"type":"error","error":{"message":"synthetic"}}""")
        send(state, done(1, "after error"))
        send(state, terminal())
        assertThatThrownBy { state.reconstructedResponse() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("WebSocket error")
        assertThat(state.response().idOrThrow()).isEqualTo("r")
        assertThat(state.snapshot().get()).isSameAs(state.response())
    }

    @Test
    fun createdResetsErrorAndFinalizedRecordsBeforeAnyTerminal() {
        val state = ResponseAccumulator.createWithSnapshots()
        send(state, done(0, "old"))
        send(state, """{"type":"error","error":{"message":"synthetic"}}""")
        send(
            state,
            """{"type":"response.created","sequence_number":2,"response":{"id":"r","output":[]}}""",
        )
        send(state, done(5, "new"))
        send(state, terminal())
        assertThat(
                state
                    .reconstructedResponse()
                    .outputOrThrow()
                    .single()
                    .asFunctionCall()
                    .argumentsOrThrow()
            )
            .isEqualTo("new")
    }
}
