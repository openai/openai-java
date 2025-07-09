// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponseItemTest {

    @Test
    fun ofResponseInputMessageItem() {
        val responseInputMessageItem =
            ResponseInputMessageItem.builder()
                .id("id")
                .addInputTextContent("text")
                .role(ResponseInputMessageItem.Role.USER)
                .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                .type(ResponseInputMessageItem.Type.MESSAGE)
                .build()

        val responseItem = ResponseItem.ofResponseInputMessageItem(responseInputMessageItem)

        assertThat(responseItem.responseInputMessageItem()).contains(responseInputMessageItem)
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofResponseInputMessageItemRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofResponseInputMessageItem(
                ResponseInputMessageItem.builder()
                    .id("id")
                    .addInputTextContent("text")
                    .role(ResponseInputMessageItem.Role.USER)
                    .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                    .type(ResponseInputMessageItem.Type.MESSAGE)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofResponseOutputMessage() {
        val responseOutputMessage =
            ResponseOutputMessage.builder()
                .id("id")
                .addContent(
                    ResponseOutputText.builder()
                        .addAnnotation(
                            ResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            ResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                .build()

        val responseItem = ResponseItem.ofResponseOutputMessage(responseOutputMessage)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).contains(responseOutputMessage)
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofResponseOutputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofResponseOutputMessage(
                ResponseOutputMessage.builder()
                    .id("id")
                    .addContent(
                        ResponseOutputText.builder()
                            .addAnnotation(
                                ResponseOutputText.Annotation.FileCitation.builder()
                                    .fileId("file_id")
                                    .filename("filename")
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .addLogprob(
                                ResponseOutputText.Logprob.builder()
                                    .token("token")
                                    .addByte(0L)
                                    .logprob(0.0)
                                    .addTopLogprob(
                                        ResponseOutputText.Logprob.TopLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
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

        val responseItem = ResponseItem.ofFileSearchCall(fileSearchCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofFileSearchCall(
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

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
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

        val responseItem = ResponseItem.ofComputerCall(computerCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).contains(computerCall)
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofComputerCall(
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

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
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

        val responseItem = ResponseItem.ofComputerCallOutput(computerCallOutput)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).contains(computerCallOutput)
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofComputerCallOutput(
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

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofWebSearchCall() {
        val webSearchCall =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .searchAction("query")
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        val responseItem = ResponseItem.ofWebSearchCall(webSearchCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).contains(webSearchCall)
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofWebSearchCall(
                ResponseFunctionWebSearch.builder()
                    .id("id")
                    .searchAction("query")
                    .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
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

        val responseItem = ResponseItem.ofFunctionCall(functionCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).contains(functionCall)
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofFunctionCall(
                ResponseFunctionToolCallItem.builder()
                    .arguments("arguments")
                    .callId("call_id")
                    .name("name")
                    .id("id")
                    .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            ResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("output")
                .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .build()

        val responseItem = ResponseItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofFunctionCallOutput(
                ResponseFunctionToolCallOutputItem.builder()
                    .id("id")
                    .callId("call_id")
                    .output("output")
                    .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofImageGenerationCall() {
        val imageGenerationCall =
            ResponseItem.ImageGenerationCall.builder()
                .id("id")
                .result("result")
                .status(ResponseItem.ImageGenerationCall.Status.IN_PROGRESS)
                .build()

        val responseItem = ResponseItem.ofImageGenerationCall(imageGenerationCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).contains(imageGenerationCall)
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofImageGenerationCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofImageGenerationCall(
                ResponseItem.ImageGenerationCall.builder()
                    .id("id")
                    .result("result")
                    .status(ResponseItem.ImageGenerationCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
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

        val responseItem = ResponseItem.ofCodeInterpreterCall(codeInterpreterCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).contains(codeInterpreterCall)
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofCodeInterpreterCall(
                ResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .containerId("container_id")
                    .addLogsOutput("logs")
                    .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofLocalShellCall() {
        val localShellCall =
            ResponseItem.LocalShellCall.builder()
                .id("id")
                .action(
                    ResponseItem.LocalShellCall.Action.builder()
                        .addCommand("string")
                        .env(
                            ResponseItem.LocalShellCall.Action.Env.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .timeoutMs(0L)
                        .user("user")
                        .workingDirectory("working_directory")
                        .build()
                )
                .callId("call_id")
                .status(ResponseItem.LocalShellCall.Status.IN_PROGRESS)
                .build()

        val responseItem = ResponseItem.ofLocalShellCall(localShellCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).contains(localShellCall)
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofLocalShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofLocalShellCall(
                ResponseItem.LocalShellCall.builder()
                    .id("id")
                    .action(
                        ResponseItem.LocalShellCall.Action.builder()
                            .addCommand("string")
                            .env(
                                ResponseItem.LocalShellCall.Action.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .timeoutMs(0L)
                            .user("user")
                            .workingDirectory("working_directory")
                            .build()
                    )
                    .callId("call_id")
                    .status(ResponseItem.LocalShellCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofLocalShellCallOutput() {
        val localShellCallOutput =
            ResponseItem.LocalShellCallOutput.builder()
                .id("id")
                .output("output")
                .status(ResponseItem.LocalShellCallOutput.Status.IN_PROGRESS)
                .build()

        val responseItem = ResponseItem.ofLocalShellCallOutput(localShellCallOutput)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).contains(localShellCallOutput)
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofLocalShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofLocalShellCallOutput(
                ResponseItem.LocalShellCallOutput.builder()
                    .id("id")
                    .output("output")
                    .status(ResponseItem.LocalShellCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofMcpListTools() {
        val mcpListTools =
            ResponseItem.McpListTools.builder()
                .id("id")
                .serverLabel("server_label")
                .addTool(
                    ResponseItem.McpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .error("error")
                .build()

        val responseItem = ResponseItem.ofMcpListTools(mcpListTools)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).contains(mcpListTools)
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofMcpListTools(
                ResponseItem.McpListTools.builder()
                    .id("id")
                    .serverLabel("server_label")
                    .addTool(
                        ResponseItem.McpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .error("error")
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofMcpApprovalRequest() {
        val mcpApprovalRequest =
            ResponseItem.McpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .build()

        val responseItem = ResponseItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofMcpApprovalRequest(
                ResponseItem.McpApprovalRequest.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            ResponseItem.McpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .reason("reason")
                .build()

        val responseItem = ResponseItem.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).contains(mcpApprovalResponse)
        assertThat(responseItem.mcpCall()).isEmpty
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofMcpApprovalResponse(
                ResponseItem.McpApprovalResponse.builder()
                    .id("id")
                    .approvalRequestId("approval_request_id")
                    .approve(true)
                    .reason("reason")
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
    }

    @Test
    fun ofMcpCall() {
        val mcpCall =
            ResponseItem.McpCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .error("error")
                .output("output")
                .build()

        val responseItem = ResponseItem.ofMcpCall(mcpCall)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).isEmpty
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
        assertThat(responseItem.imageGenerationCall()).isEmpty
        assertThat(responseItem.codeInterpreterCall()).isEmpty
        assertThat(responseItem.localShellCall()).isEmpty
        assertThat(responseItem.localShellCallOutput()).isEmpty
        assertThat(responseItem.mcpListTools()).isEmpty
        assertThat(responseItem.mcpApprovalRequest()).isEmpty
        assertThat(responseItem.mcpApprovalResponse()).isEmpty
        assertThat(responseItem.mcpCall()).contains(mcpCall)
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseItem =
            ResponseItem.ofMcpCall(
                ResponseItem.McpCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .error("error")
                    .output("output")
                    .build()
            )

        val roundtrippedResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItem),
                jacksonTypeRef<ResponseItem>(),
            )

        assertThat(roundtrippedResponseItem).isEqualTo(responseItem)
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
        val responseItem = jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseItem>())

        val e = assertThrows<OpenAIInvalidDataException> { responseItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
