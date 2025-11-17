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

internal class ResponseOutputItemTest {

    @Test
    fun ofMessage() {
        val message =
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

        val responseOutputItem = ResponseOutputItem.ofMessage(message)

        assertThat(responseOutputItem.message()).contains(message)
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofMessage(
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

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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

        val responseOutputItem = ResponseOutputItem.ofFileSearchCall(fileSearchCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofFileSearchCall(
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

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofFunctionCall() {
        val functionCall =
            ResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        val responseOutputItem = ResponseOutputItem.ofFunctionCall(functionCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).contains(functionCall)
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofFunctionCall(
                ResponseFunctionToolCall.builder()
                    .arguments("arguments")
                    .callId("call_id")
                    .name("name")
                    .id("id")
                    .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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

        val responseOutputItem = ResponseOutputItem.ofWebSearchCall(webSearchCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).contains(webSearchCall)
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofWebSearchCall(
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

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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

        val responseOutputItem = ResponseOutputItem.ofComputerCall(computerCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).contains(computerCall)
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofComputerCall(
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

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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

        val responseOutputItem = ResponseOutputItem.ofReasoning(reasoning)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).contains(reasoning)
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofReasoning(
                ResponseReasoningItem.builder()
                    .id("id")
                    .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                    .addContent(ResponseReasoningItem.Content.builder().text("text").build())
                    .encryptedContent("encrypted_content")
                    .status(ResponseReasoningItem.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofImageGenerationCall() {
        val imageGenerationCall =
            ResponseOutputItem.ImageGenerationCall.builder()
                .id("id")
                .result("result")
                .status(ResponseOutputItem.ImageGenerationCall.Status.IN_PROGRESS)
                .build()

        val responseOutputItem = ResponseOutputItem.ofImageGenerationCall(imageGenerationCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).contains(imageGenerationCall)
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofImageGenerationCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofImageGenerationCall(
                ResponseOutputItem.ImageGenerationCall.builder()
                    .id("id")
                    .result("result")
                    .status(ResponseOutputItem.ImageGenerationCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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

        val responseOutputItem = ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).contains(codeInterpreterCall)
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofCodeInterpreterCall(
                ResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .containerId("container_id")
                    .addLogsOutput("logs")
                    .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofLocalShellCall() {
        val localShellCall =
            ResponseOutputItem.LocalShellCall.builder()
                .id("id")
                .action(
                    ResponseOutputItem.LocalShellCall.Action.builder()
                        .addCommand("string")
                        .env(
                            ResponseOutputItem.LocalShellCall.Action.Env.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .timeoutMs(0L)
                        .user("user")
                        .workingDirectory("working_directory")
                        .build()
                )
                .callId("call_id")
                .status(ResponseOutputItem.LocalShellCall.Status.IN_PROGRESS)
                .build()

        val responseOutputItem = ResponseOutputItem.ofLocalShellCall(localShellCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).contains(localShellCall)
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofLocalShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofLocalShellCall(
                ResponseOutputItem.LocalShellCall.builder()
                    .id("id")
                    .action(
                        ResponseOutputItem.LocalShellCall.Action.builder()
                            .addCommand("string")
                            .env(
                                ResponseOutputItem.LocalShellCall.Action.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .timeoutMs(0L)
                            .user("user")
                            .workingDirectory("working_directory")
                            .build()
                    )
                    .callId("call_id")
                    .status(ResponseOutputItem.LocalShellCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofShellCall() {
        val shellCall =
            ResponseFunctionShellToolCall.builder()
                .id("id")
                .action(
                    ResponseFunctionShellToolCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("call_id")
                .status(ResponseFunctionShellToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val responseOutputItem = ResponseOutputItem.ofShellCall(shellCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).contains(shellCall)
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofShellCall(
                ResponseFunctionShellToolCall.builder()
                    .id("id")
                    .action(
                        ResponseFunctionShellToolCall.Action.builder()
                            .addCommand("string")
                            .maxOutputLength(0L)
                            .timeoutMs(0L)
                            .build()
                    )
                    .callId("call_id")
                    .status(ResponseFunctionShellToolCall.Status.IN_PROGRESS)
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofShellCallOutput() {
        val shellCallOutput =
            ResponseFunctionShellToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .maxOutputLength(0L)
                .addOutput(
                    ResponseFunctionShellToolCallOutput.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .createdBy("created_by")
                .build()

        val responseOutputItem = ResponseOutputItem.ofShellCallOutput(shellCallOutput)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).contains(shellCallOutput)
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofShellCallOutput(
                ResponseFunctionShellToolCallOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .maxOutputLength(0L)
                    .addOutput(
                        ResponseFunctionShellToolCallOutput.Output.builder()
                            .outcomeTimeout()
                            .stderr("stderr")
                            .stdout("stdout")
                            .createdBy("created_by")
                            .build()
                    )
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofApplyPatchCall() {
        val applyPatchCall =
            ResponseApplyPatchToolCall.builder()
                .id("id")
                .callId("call_id")
                .operation(
                    ResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
                .status(ResponseApplyPatchToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val responseOutputItem = ResponseOutputItem.ofApplyPatchCall(applyPatchCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).contains(applyPatchCall)
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofApplyPatchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofApplyPatchCall(
                ResponseApplyPatchToolCall.builder()
                    .id("id")
                    .callId("call_id")
                    .operation(
                        ResponseApplyPatchToolCall.Operation.CreateFile.builder()
                            .diff("diff")
                            .path("path")
                            .build()
                    )
                    .status(ResponseApplyPatchToolCall.Status.IN_PROGRESS)
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofApplyPatchCallOutput() {
        val applyPatchCallOutput =
            ResponseApplyPatchToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .status(ResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .createdBy("created_by")
                .output("output")
                .build()

        val responseOutputItem = ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).contains(applyPatchCallOutput)
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofApplyPatchCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofApplyPatchCallOutput(
                ResponseApplyPatchToolCallOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .status(ResponseApplyPatchToolCallOutput.Status.COMPLETED)
                    .createdBy("created_by")
                    .output("output")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofMcpCall() {
        val mcpCall =
            ResponseOutputItem.McpCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .approvalRequestId("approval_request_id")
                .error("error")
                .output("output")
                .status(ResponseOutputItem.McpCall.Status.IN_PROGRESS)
                .build()

        val responseOutputItem = ResponseOutputItem.ofMcpCall(mcpCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).contains(mcpCall)
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofMcpCall(
                ResponseOutputItem.McpCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .approvalRequestId("approval_request_id")
                    .error("error")
                    .output("output")
                    .status(ResponseOutputItem.McpCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofMcpListTools() {
        val mcpListTools =
            ResponseOutputItem.McpListTools.builder()
                .id("id")
                .serverLabel("server_label")
                .addTool(
                    ResponseOutputItem.McpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .error("error")
                .build()

        val responseOutputItem = ResponseOutputItem.ofMcpListTools(mcpListTools)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).contains(mcpListTools)
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofMcpListTools(
                ResponseOutputItem.McpListTools.builder()
                    .id("id")
                    .serverLabel("server_label")
                    .addTool(
                        ResponseOutputItem.McpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .error("error")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
    }

    @Test
    fun ofMcpApprovalRequest() {
        val mcpApprovalRequest =
            ResponseOutputItem.McpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .build()

        val responseOutputItem = ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
        assertThat(responseOutputItem.customToolCall()).isEmpty
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofMcpApprovalRequest(
                ResponseOutputItem.McpApprovalRequest.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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

        val responseOutputItem = ResponseOutputItem.ofCustomToolCall(customToolCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
        assertThat(responseOutputItem.imageGenerationCall()).isEmpty
        assertThat(responseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(responseOutputItem.localShellCall()).isEmpty
        assertThat(responseOutputItem.shellCall()).isEmpty
        assertThat(responseOutputItem.shellCallOutput()).isEmpty
        assertThat(responseOutputItem.applyPatchCall()).isEmpty
        assertThat(responseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(responseOutputItem.mcpCall()).isEmpty
        assertThat(responseOutputItem.mcpListTools()).isEmpty
        assertThat(responseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(responseOutputItem.customToolCall()).contains(customToolCall)
    }

    @Test
    fun ofCustomToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofCustomToolCall(
                ResponseCustomToolCall.builder()
                    .callId("call_id")
                    .input("input")
                    .name("name")
                    .id("id")
                    .build()
            )

        val roundtrippedResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItem),
                jacksonTypeRef<ResponseOutputItem>(),
            )

        assertThat(roundtrippedResponseOutputItem).isEqualTo(responseOutputItem)
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
        val responseOutputItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseOutputItem>())

        val e = assertThrows<OpenAIInvalidDataException> { responseOutputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
