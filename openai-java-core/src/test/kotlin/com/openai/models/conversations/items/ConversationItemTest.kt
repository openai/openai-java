// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.conversations.Message
import com.openai.models.responses.ResponseCodeInterpreterToolCall
import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseComputerToolCallOutputItem
import com.openai.models.responses.ResponseComputerToolCallOutputScreenshot
import com.openai.models.responses.ResponseCustomToolCall
import com.openai.models.responses.ResponseCustomToolCallOutput
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionToolCall
import com.openai.models.responses.ResponseFunctionToolCallItem
import com.openai.models.responses.ResponseFunctionToolCallOutputItem
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseReasoningItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ConversationItemTest {

    @Test
    fun ofMessage() {
        val message =
            Message.builder()
                .id("id")
                .addInputTextContent("text")
                .role(Message.Role.UNKNOWN)
                .status(Message.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofMessage(message)

        assertThat(conversationItem.message()).contains(message)
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMessage(
                Message.builder()
                    .id("id")
                    .addInputTextContent("text")
                    .role(Message.Role.UNKNOWN)
                    .status(Message.Status.IN_PROGRESS)
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
            ResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofFunctionCall(functionCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).contains(functionCall)
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofFunctionCall(
                ResponseFunctionToolCallItem.builder()
                    .arguments("arguments")
                    .callId("call_id")
                    .name("name")
                    .id("id")
                    .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
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
            ResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("string")
                .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofFunctionCallOutput(
                ResponseFunctionToolCallOutputItem.builder()
                    .id("id")
                    .callId("call_id")
                    .output("string")
                    .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
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
    fun ofFileSearchCall() {
        val fileSearchCall =
            ResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
                .addResult(
                    ResponseFileSearchToolCall.Result.builder()
                        .attributes(
                            ResponseFileSearchToolCall.Result.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0f)
                        .text("text")
                        .build()
                )
                .build()

        val conversationItem = ConversationItem.ofFileSearchCall(fileSearchCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofFileSearchCall(
                ResponseFileSearchToolCall.builder()
                    .id("id")
                    .addQuery("string")
                    .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
                    .addResult(
                        ResponseFileSearchToolCall.Result.builder()
                            .attributes(
                                ResponseFileSearchToolCall.Result.Attributes.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .fileId("file_id")
                            .filename("filename")
                            .score(0.0f)
                            .text("text")
                            .build()
                    )
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
    fun ofWebSearchCall() {
        val webSearchCall =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .action(
                    ResponseFunctionWebSearch.Action.Search.builder()
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("url")
                                .build()
                        )
                        .build()
                )
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofWebSearchCall(webSearchCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).contains(webSearchCall)
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofWebSearchCall(
                ResponseFunctionWebSearch.builder()
                    .id("id")
                    .action(
                        ResponseFunctionWebSearch.Action.Search.builder()
                            .query("query")
                            .addSource(
                                ResponseFunctionWebSearch.Action.Search.Source.builder()
                                    .url("url")
                                    .build()
                            )
                            .build()
                    )
                    .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
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
    fun ofImageGenerationCall() {
        val imageGenerationCall =
            ConversationItem.ImageGenerationCall.builder()
                .id("id")
                .result("result")
                .status(ConversationItem.ImageGenerationCall.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofImageGenerationCall(imageGenerationCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).contains(imageGenerationCall)
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofImageGenerationCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofImageGenerationCall(
                ConversationItem.ImageGenerationCall.builder()
                    .id("id")
                    .result("result")
                    .status(ConversationItem.ImageGenerationCall.Status.IN_PROGRESS)
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
    fun ofComputerCall() {
        val computerCall =
            ResponseComputerToolCall.builder()
                .id("id")
                .action(
                    ResponseComputerToolCall.Action.Click.builder()
                        .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .build()
                )
                .callId("call_id")
                .addPendingSafetyCheck(
                    ResponseComputerToolCall.PendingSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(ResponseComputerToolCall.Status.IN_PROGRESS)
                .type(ResponseComputerToolCall.Type.COMPUTER_CALL)
                .build()

        val conversationItem = ConversationItem.ofComputerCall(computerCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).contains(computerCall)
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofComputerCall(
                ResponseComputerToolCall.builder()
                    .id("id")
                    .action(
                        ResponseComputerToolCall.Action.Click.builder()
                            .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                            .x(0L)
                            .y(0L)
                            .build()
                    )
                    .callId("call_id")
                    .addPendingSafetyCheck(
                        ResponseComputerToolCall.PendingSafetyCheck.builder()
                            .id("id")
                            .code("code")
                            .message("message")
                            .build()
                    )
                    .status(ResponseComputerToolCall.Status.IN_PROGRESS)
                    .type(ResponseComputerToolCall.Type.COMPUTER_CALL)
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
    fun ofComputerCallOutput() {
        val computerCallOutput =
            ResponseComputerToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output(
                    ResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("image_url")
                        .build()
                )
                .addAcknowledgedSafetyCheck(
                    ResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(ResponseComputerToolCallOutputItem.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofComputerCallOutput(computerCallOutput)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).contains(computerCallOutput)
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofComputerCallOutput(
                ResponseComputerToolCallOutputItem.builder()
                    .id("id")
                    .callId("call_id")
                    .output(
                        ResponseComputerToolCallOutputScreenshot.builder()
                            .fileId("file_id")
                            .imageUrl("image_url")
                            .build()
                    )
                    .addAcknowledgedSafetyCheck(
                        ResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                            .id("id")
                            .code("code")
                            .message("message")
                            .build()
                    )
                    .status(ResponseComputerToolCallOutputItem.Status.IN_PROGRESS)
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
    fun ofReasoning() {
        val reasoning =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                .addContent(ResponseReasoningItem.Content.builder().text("text").build())
                .encryptedContent("encrypted_content")
                .status(ResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofReasoning(reasoning)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).contains(reasoning)
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofReasoning(
                ResponseReasoningItem.builder()
                    .id("id")
                    .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                    .addContent(ResponseReasoningItem.Content.builder().text("text").build())
                    .encryptedContent("encrypted_content")
                    .status(ResponseReasoningItem.Status.IN_PROGRESS)
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
    fun ofCodeInterpreterCall() {
        val codeInterpreterCall =
            ResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .containerId("container_id")
                .addLogsOutput("logs")
                .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofCodeInterpreterCall(codeInterpreterCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).contains(codeInterpreterCall)
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofCodeInterpreterCall(
                ResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .containerId("container_id")
                    .addLogsOutput("logs")
                    .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
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
    fun ofLocalShellCall() {
        val localShellCall =
            ConversationItem.LocalShellCall.builder()
                .id("id")
                .action(
                    ConversationItem.LocalShellCall.Action.builder()
                        .addCommand("string")
                        .env(
                            ConversationItem.LocalShellCall.Action.Env.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .timeoutMs(0L)
                        .user("user")
                        .workingDirectory("working_directory")
                        .build()
                )
                .callId("call_id")
                .status(ConversationItem.LocalShellCall.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofLocalShellCall(localShellCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).contains(localShellCall)
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofLocalShellCall(
                ConversationItem.LocalShellCall.builder()
                    .id("id")
                    .action(
                        ConversationItem.LocalShellCall.Action.builder()
                            .addCommand("string")
                            .env(
                                ConversationItem.LocalShellCall.Action.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .timeoutMs(0L)
                            .user("user")
                            .workingDirectory("working_directory")
                            .build()
                    )
                    .callId("call_id")
                    .status(ConversationItem.LocalShellCall.Status.IN_PROGRESS)
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
    fun ofLocalShellCallOutput() {
        val localShellCallOutput =
            ConversationItem.LocalShellCallOutput.builder()
                .id("id")
                .output("output")
                .status(ConversationItem.LocalShellCallOutput.Status.IN_PROGRESS)
                .build()

        val conversationItem = ConversationItem.ofLocalShellCallOutput(localShellCallOutput)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).contains(localShellCallOutput)
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofLocalShellCallOutput(
                ConversationItem.LocalShellCallOutput.builder()
                    .id("id")
                    .output("output")
                    .status(ConversationItem.LocalShellCallOutput.Status.IN_PROGRESS)
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
            ConversationItem.McpListTools.builder()
                .id("id")
                .serverLabel("server_label")
                .addTool(
                    ConversationItem.McpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .error("error")
                .build()

        val conversationItem = ConversationItem.ofMcpListTools(mcpListTools)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).contains(mcpListTools)
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpListTools(
                ConversationItem.McpListTools.builder()
                    .id("id")
                    .serverLabel("server_label")
                    .addTool(
                        ConversationItem.McpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .error("error")
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
            ConversationItem.McpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .build()

        val conversationItem = ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpApprovalRequest(
                ConversationItem.McpApprovalRequest.builder()
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

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            ConversationItem.McpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .reason("reason")
                .build()

        val conversationItem = ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).contains(mcpApprovalResponse)
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpApprovalResponse(
                ConversationItem.McpApprovalResponse.builder()
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
    fun ofMcpCall() {
        val mcpCall =
            ConversationItem.McpCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .error("error")
                .output("output")
                .build()

        val conversationItem = ConversationItem.ofMcpCall(mcpCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).contains(mcpCall)
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofMcpCall(
                ConversationItem.McpCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .error("error")
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
    fun ofCustomToolCall() {
        val customToolCall =
            ResponseCustomToolCall.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .build()

        val conversationItem = ConversationItem.ofCustomToolCall(customToolCall)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).contains(customToolCall)
        assertThat(conversationItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCustomToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofCustomToolCall(
                ResponseCustomToolCall.builder()
                    .callId("call_id")
                    .input("input")
                    .name("name")
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
    fun ofCustomToolCallOutput() {
        val customToolCallOutput =
            ResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .build()

        val conversationItem = ConversationItem.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(conversationItem.message()).isEmpty
        assertThat(conversationItem.functionCall()).isEmpty
        assertThat(conversationItem.functionCallOutput()).isEmpty
        assertThat(conversationItem.fileSearchCall()).isEmpty
        assertThat(conversationItem.webSearchCall()).isEmpty
        assertThat(conversationItem.imageGenerationCall()).isEmpty
        assertThat(conversationItem.computerCall()).isEmpty
        assertThat(conversationItem.computerCallOutput()).isEmpty
        assertThat(conversationItem.reasoning()).isEmpty
        assertThat(conversationItem.codeInterpreterCall()).isEmpty
        assertThat(conversationItem.localShellCall()).isEmpty
        assertThat(conversationItem.localShellCallOutput()).isEmpty
        assertThat(conversationItem.mcpListTools()).isEmpty
        assertThat(conversationItem.mcpApprovalRequest()).isEmpty
        assertThat(conversationItem.mcpApprovalResponse()).isEmpty
        assertThat(conversationItem.mcpCall()).isEmpty
        assertThat(conversationItem.customToolCall()).isEmpty
        assertThat(conversationItem.customToolCallOutput()).contains(customToolCallOutput)
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.ofCustomToolCallOutput(
                ResponseCustomToolCallOutput.builder()
                    .callId("call_id")
                    .output("string")
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
