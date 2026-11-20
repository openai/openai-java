package com.openai.helpers

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.jsonMapper
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseOutputItem
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ResponseInputItemsTest {
    private val mapper = jsonMapper()

    private fun output(json: String) = mapper.readValue(json, ResponseOutputItem::class.java)

    private fun input(json: String) = mapper.readValue(json, ResponseInputItem::class.java)

    private fun json(value: Any): JsonNode = mapper.valueToTree(value)

    @Test
    fun preservesReasoningMessagesAndToolRelationshipsInNextRequest() {
        val source =
            listOf(
                output(
                    """{"type":"reasoning","id":"rs_1","summary":[],"encrypted_content":"opaque","created_by":"server"}"""
                ),
                output(
                    """{"type":"message","id":"msg_1","role":"assistant","status":"completed","phase":"commentary","content":[{"type":"output_text","text":"Checking","annotations":[],"parsed":{"private":"sdk"}}],"created_by":"server"}"""
                ),
                output(
                    """{"type":"function_call","id":"fc_1","call_id":"call_1","name":"weather","arguments":"{\"city\":\"Paris\"}","status":"completed","parsed_arguments":{"city":"Paris"},"created_by":"server","future_field":{"keep":true}}"""
                ),
            )
        val before = json(source)
        val history = ResponseInputItems.toInputItems(source).toMutableList()
        assertThat(history[0].reasoning().get().encryptedContent()).contains("opaque")
        assertThat(history[1].responseOutputMessage().get().phase().get().toString())
            .isEqualTo("commentary")
        assertThat(history[2].functionCall().get().callId()).isEqualTo("call_1")
        history.add(
            input("""{"type":"function_call_output","call_id":"call_1","output":"sunny"}""")
        )
        val request =
            ResponseCreateParams.builder()
                .model("test-model")
                .inputOfResponse(history)
                .store(false)
                .build()
        val body = json(request._body())
        val replayed = body.path("input")
        assertThat(replayed.map { it.path("type").asText() })
            .containsExactly("reasoning", "message", "function_call", "function_call_output")
        assertThat(replayed[0].path("encrypted_content").asText()).isEqualTo("opaque")
        assertThat(replayed[1].path("phase").asText()).isEqualTo("commentary")
        assertThat(replayed[1].path("content")[0].has("parsed")).isFalse()
        assertThat(replayed[2].has("parsed_arguments")).isFalse()
        assertThat(replayed[2].path("arguments").asText()).isEqualTo("""{"city":"Paris"}""")
        assertThat(replayed[2].path("future_field").path("keep").asBoolean()).isTrue()
        assertThat(replayed.any { it.has("created_by") }).isFalse()
        assertThat(json(source)).isEqualTo(before)
    }

    @ParameterizedTest
    @CsvSource(
        "additional_tools,completed,assistant,false",
        "additional_tools,completed,developer,true",
        "computer_call_output,failed,assistant,false",
        "computer_call_output,completed,assistant,true",
        "custom_tool_call_output,in_progress,assistant,false",
        "custom_tool_call_output,failed,assistant,false",
        "custom_tool_call_output,completed,assistant,true",
    )
    fun omitsOnlySpecifiedNonReplayableStates(
        type: String,
        status: String,
        role: String,
        retained: Boolean,
    ) {
        val item =
            output(
                """{"type":"$type","status":"$status","role":"$role","id":"item_1","call_id":"call_1","output":"result","tools":[],"created_by":"server"}"""
            )
        val before = json(item)
        val result = ResponseInputItems.toInputItem(item)
        assertThat(result.isPresent).isEqualTo(retained)
        if (retained) {
            assertThat(json(result.get()).has("created_by")).isFalse()
            assertThat(json(result.get()).has("status"))
                .isEqualTo(type != "custom_tool_call_output")
        }
        assertThat(json(item)).isEqualTo(before)
    }

    @Test
    fun customOutputWithoutStatusCanBeReplayed() {
        val item =
            input("""{"type":"custom_tool_call_output","call_id":"call_1","output":"result"}""")
        assertThat(json(ResponseInputItems.toInputItem(item).get())).isEqualTo(json(item))
    }

    @ParameterizedTest
    @ValueSource(strings = ["{}", "{\"type\":null}"])
    fun preservesTypedAccessForReferencesAndMessagesWithoutDiscriminator(typeFields: String) {
        val suffix = if (typeFields == "{}") "" else ",\"type\":null"
        val reference =
            ResponseInputItem.ofItemReference(
                ResponseInputItem.ItemReference.builder().id("msg_1").build()
            )
        for (item in listOf(reference, input("""{"id":"msg_1"$suffix}"""))) {
            val normalized = ResponseInputItems.toInputItem(item).get()
            assertThat(normalized.itemReference().get().id()).isEqualTo("msg_1")
            assertThat(json(normalized)).isEqualTo(json(item))
        }
        val message = input("""{"role":"user","content":"hello"$suffix}""")
        val normalized = ResponseInputItems.toInputItem(message).get()
        assertThat(normalized.easyInputMessage().get().content().asTextInput()).isEqualTo("hello")
        assertThat(json(normalized)).isEqualTo(json(message))
    }

    @Test
    fun shellChunksLoseOnlyTheirProvenance() {
        val item =
            output(
                """{"type":"shell_call_output","id":"out_1","call_id":"call_1","created_by":"server","output":[{"stdout":"ok","stderr":"","outcome":{"type":"exit","exit_code":0},"created_by":"server","extension":{"created_by":"application"}}]}"""
            )
        val before = json(item)
        val result = json(ResponseInputItems.toInputItem(item).get())
        assertThat(result.has("created_by")).isFalse()
        assertThat(result.path("output")[0].has("created_by")).isFalse()
        assertThat(result.path("output")[0].path("stdout").asText()).isEqualTo("ok")
        assertThat(result.path("output")[0].path("extension").path("created_by").asText())
            .isEqualTo("application")
        assertThat(json(item)).isEqualTo(before)
    }

    @Test
    fun inputHistoryPreservesUserContentAndIsIdempotent() {
        val user =
            ResponseInputItem.ofEasyInputMessage(
                EasyInputMessage.builder()
                    .role(EasyInputMessage.Role.USER)
                    .content("Continue")
                    .build()
            )
        val message =
            input(
                """{"type":"message","id":"msg_1","role":"assistant","status":"completed","content":[{"type":"refusal","refusal":"No","parsed":"sdk"}]}"""
            )
        val normalized = ResponseInputItems.normalizeInputItems(listOf(user, message))
        assertThat(json(normalized[0])).isEqualTo(json(user))
        assertThat(json(normalized[1]).path("content")[0].has("parsed")).isFalse()
        assertThat(json(ResponseInputItems.normalizeInputItems(normalized)))
            .isEqualTo(json(normalized))
        assertThat(ResponseInputItems.toInputItems(emptyList())).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "item_reference",
                "program",
                "program_output",
                "compaction",
                "compaction_trigger",
                "configuration_update",
                "tool_search_call",
                "tool_search_output",
                "mcp_approval_response",
            ]
    )
    fun preservesNewerReplayTypesAndOpaquePayloads(type: String) {
        // Deliberately use raw union fallback data: normalization must preserve extension fields
        // even when a newer payload cannot be hydrated into this release's typed variant.
        val item =
            input(
                """{"type":"$type","id":"item_1","created_by":"server","extension":{"data":[1,2,3],"encrypted_content":"opaque"}}"""
            )
        val result = json(ResponseInputItems.toInputItem(item).get())
        assertThat(result.path("type").asText()).isEqualTo(type)
        assertThat(result.path("extension")).isEqualTo(json(item).path("extension"))
        assertThat(result.has("created_by")).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["{\"type\":\"future_secret_type\"}", "{\"type\":42}", "{}", "[]"])
    fun unsupportedItemsFailExplicitlyWithoutEchoingHistory(raw: String) {
        val error = catchThrowable { ResponseInputItems.toInputItem(output(raw)) }
        assertThat(error).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(error.message).doesNotContain("future_secret_type")
    }
}
