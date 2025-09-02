// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ConversationItemTest {

    @Test
    fun ofRealtimeConversationItemSystemMessage() {
        val realtimeConversationItemSystemMessage =
            RealtimeConversationItemSystemMessage.builder()
                .addContent(
                    RealtimeConversationItemSystemMessage.Content.builder()
                        .text("text")
                        .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                .build()

        val conversationItem =
            ConversationItem.ofRealtimeConversationItemSystemMessage(
                realtimeConversationItemSystemMessage
            )

        assertThat(conversationItem.realtimeConversationItemSystemMessage())
            .contains(realtimeConversationItemSystemMessage)
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofRealtimeConversationItemSystemMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofRealtimeConversationItemSystemMessage(
                RealtimeConversationItemSystemMessage.builder()
                    .addContent(
                        RealtimeConversationItemSystemMessage.Content.builder()
                            .text("text")
                            .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                            .build()
                    )
                    .id("id")
                    .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                    .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofRealtimeConversationItemUserMessage() {
        val realtimeConversationItemUserMessage =
            RealtimeConversationItemUserMessage.builder()
                .addContent(
                    RealtimeConversationItemUserMessage.Content.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(RealtimeConversationItemUserMessage.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemUserMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemUserMessage.Status.COMPLETED)
                .build()

        val conversationItem =
            ConversationItem.ofRealtimeConversationItemUserMessage(
                realtimeConversationItemUserMessage
            )

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage())
            .contains(realtimeConversationItemUserMessage)
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofRealtimeConversationItemUserMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofRealtimeConversationItemUserMessage(
                RealtimeConversationItemUserMessage.builder()
                    .addContent(
                        RealtimeConversationItemUserMessage.Content.builder()
                            .audio("audio")
                            .text("text")
                            .transcript("transcript")
                            .type(RealtimeConversationItemUserMessage.Content.Type.INPUT_TEXT)
                            .build()
                    )
                    .id("id")
                    .object_(RealtimeConversationItemUserMessage.Object.REALTIME_ITEM)
                    .status(RealtimeConversationItemUserMessage.Status.COMPLETED)
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofRealtimeConversationItemAssistantMessage() {
        val realtimeConversationItemAssistantMessage =
            RealtimeConversationItemAssistantMessage.builder()
                .addContent(
                    RealtimeConversationItemAssistantMessage.Content.builder()
                        .text("text")
                        .type(RealtimeConversationItemAssistantMessage.Content.Type.TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemAssistantMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemAssistantMessage.Status.COMPLETED)
                .build()

        val conversationItem =
            ConversationItem.ofRealtimeConversationItemAssistantMessage(
                realtimeConversationItemAssistantMessage
            )

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage())
            .contains(realtimeConversationItemAssistantMessage)
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofRealtimeConversationItemAssistantMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofRealtimeConversationItemAssistantMessage(
                RealtimeConversationItemAssistantMessage.builder()
                    .addContent(
                        RealtimeConversationItemAssistantMessage.Content.builder()
                            .text("text")
                            .type(RealtimeConversationItemAssistantMessage.Content.Type.TEXT)
                            .build()
                    )
                    .id("id")
                    .object_(RealtimeConversationItemAssistantMessage.Object.REALTIME_ITEM)
                    .status(RealtimeConversationItemAssistantMessage.Status.COMPLETED)
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofFunctionCall() {
        val functionCall =
            RealtimeConversationItemFunctionCall.builder()
                .arguments("arguments")
                .name("name")
                .id("id")
                .callId("call_id")
                .object_(RealtimeConversationItemFunctionCall.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCall.Status.COMPLETED)
                .build()

        val conversationItem = ConversationItem.ofFunctionCall(functionCall)

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).contains(functionCall)
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofFunctionCall(
                RealtimeConversationItemFunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .id("id")
                    .callId("call_id")
                    .object_(RealtimeConversationItemFunctionCall.Object.REALTIME_ITEM)
                    .status(RealtimeConversationItemFunctionCall.Status.COMPLETED)
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            RealtimeConversationItemFunctionCallOutput.builder()
                .callId("call_id")
                .output("output")
                .id("id")
                .object_(RealtimeConversationItemFunctionCallOutput.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCallOutput.Status.COMPLETED)
                .build()

        val conversationItem = ConversationItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofFunctionCallOutput(
                RealtimeConversationItemFunctionCallOutput.builder()
                    .callId("call_id")
                    .output("output")
                    .id("id")
                    .object_(RealtimeConversationItemFunctionCallOutput.Object.REALTIME_ITEM)
                    .status(RealtimeConversationItemFunctionCallOutput.Status.COMPLETED)
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            RealtimeMcpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .reason("reason")
                .build()

        val conversationItem = ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).contains(mcpApprovalResponse)
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpApprovalResponse(
                RealtimeMcpApprovalResponse.builder()
                    .id("id")
                    .approvalRequestId("approval_request_id")
                    .approve(true)
                    .reason("reason")
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofMcpListTools() {
        val mcpListTools =
            RealtimeMcpListTools.builder()
                .serverLabel("server_label")
                .addTool(
                    RealtimeMcpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .id("id")
                .build()

        val conversationItem = ConversationItem.ofMcpListTools(mcpListTools)

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).contains(mcpListTools)
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpListTools(
                RealtimeMcpListTools.builder()
                    .serverLabel("server_label")
                    .addTool(
                        RealtimeMcpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .id("id")
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofMcpToolCall() {
        val mcpToolCall =
            RealtimeMcpToolCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .approvalRequestId("approval_request_id")
                .error(RealtimeMcpProtocolError.builder().code(0L).message("message").build())
                .output("output")
                .build()

        val conversationItem = ConversationItem.ofMcpToolCall(mcpToolCall)

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).contains(mcpToolCall)
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
    }

    @Test
    fun ofMcpToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpToolCall(
                RealtimeMcpToolCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .approvalRequestId("approval_request_id")
                    .error(RealtimeMcpProtocolError.builder().code(0L).message("message").build())
                    .output("output")
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    @Test
    fun ofMcpApprovalRequest() {
        val mcpApprovalRequest =
            RealtimeMcpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .build()

        val conversationItem = ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(conversationItem.realtimeConversationItemSystemMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemUserMessage()).isEmpty
        assertThat(conversationItem.realtimeConversationItemAssistantMessage()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpToolCall()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpApprovalRequest(
                RealtimeMcpApprovalRequest.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .build()
            )

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val conversationItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ConversationItem>())

        val e = assertThrows<OpenAIInvalidDataException> { conversationItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
