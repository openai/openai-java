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

internal class ResponseInputItemTest {

    @Test
    fun ofEasyInputMessage() {
        val easyInputMessage =
            EasyInputMessage.builder()
                .content("string")
                .role(EasyInputMessage.Role.USER)
                .type(EasyInputMessage.Type.MESSAGE)
                .build()

        val responseInputItem = ResponseInputItem.ofEasyInputMessage(easyInputMessage)

        assertThat(responseInputItem.easyInputMessage()).contains(easyInputMessage)
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofEasyInputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofEasyInputMessage(
                EasyInputMessage.builder()
                    .content("string")
                    .role(EasyInputMessage.Role.USER)
                    .type(EasyInputMessage.Type.MESSAGE)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
    }

    @Test
    fun ofMessage() {
        val message =
            ResponseInputItem.Message.builder()
                .addInputTextContent("text")
                .role(ResponseInputItem.Message.Role.USER)
                .status(ResponseInputItem.Message.Status.IN_PROGRESS)
                .type(ResponseInputItem.Message.Type.MESSAGE)
                .build()

        val responseInputItem = ResponseInputItem.ofMessage(message)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).contains(message)
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofMessage(
                ResponseInputItem.Message.builder()
                    .addInputTextContent("text")
                    .role(ResponseInputItem.Message.Role.USER)
                    .status(ResponseInputItem.Message.Status.IN_PROGRESS)
                    .type(ResponseInputItem.Message.Type.MESSAGE)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
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
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .build()
                )
                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                .build()

        val responseInputItem = ResponseInputItem.ofResponseOutputMessage(responseOutputMessage)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).contains(responseOutputMessage)
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofResponseOutputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofResponseOutputMessage(
                ResponseOutputMessage.builder()
                    .id("id")
                    .addContent(
                        ResponseOutputText.builder()
                            .addAnnotation(
                                ResponseOutputText.Annotation.FileCitation.builder()
                                    .fileId("file_id")
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
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
                        .score(0.0)
                        .text("text")
                        .build()
                )
                .build()

        val responseInputItem = ResponseInputItem.ofFileSearchCall(fileSearchCall)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofFileSearchCall(
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
                            .score(0.0)
                            .text("text")
                            .build()
                    )
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
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

        val responseInputItem = ResponseInputItem.ofComputerCall(computerCall)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).contains(computerCall)
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofComputerCall(
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

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
    }

    @Test
    fun ofComputerCallOutput() {
        val computerCallOutput =
            ResponseInputItem.ComputerCallOutput.builder()
                .callId("call_id")
                .output(
                    ResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("image_url")
                        .build()
                )
                .id("id")
                .addAcknowledgedSafetyCheck(
                    ResponseInputItem.ComputerCallOutput.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(ResponseInputItem.ComputerCallOutput.Status.IN_PROGRESS)
                .build()

        val responseInputItem = ResponseInputItem.ofComputerCallOutput(computerCallOutput)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).contains(computerCallOutput)
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofComputerCallOutput(
                ResponseInputItem.ComputerCallOutput.builder()
                    .callId("call_id")
                    .output(
                        ResponseComputerToolCallOutputScreenshot.builder()
                            .fileId("file_id")
                            .imageUrl("image_url")
                            .build()
                    )
                    .id("id")
                    .addAcknowledgedSafetyCheck(
                        ResponseInputItem.ComputerCallOutput.AcknowledgedSafetyCheck.builder()
                            .id("id")
                            .code("code")
                            .message("message")
                            .build()
                    )
                    .status(ResponseInputItem.ComputerCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
    }

    @Test
    fun ofWebSearchCall() {
        val webSearchCall =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        val responseInputItem = ResponseInputItem.ofWebSearchCall(webSearchCall)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).contains(webSearchCall)
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofWebSearchCall(
                ResponseFunctionWebSearch.builder()
                    .id("id")
                    .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
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

        val responseInputItem = ResponseInputItem.ofFunctionCall(functionCall)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).contains(functionCall)
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofFunctionCall(
                ResponseFunctionToolCall.builder()
                    .arguments("arguments")
                    .callId("call_id")
                    .name("name")
                    .id("id")
                    .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            ResponseInputItem.FunctionCallOutput.builder()
                .callId("call_id")
                .output("output")
                .id("id")
                .status(ResponseInputItem.FunctionCallOutput.Status.IN_PROGRESS)
                .build()

        val responseInputItem = ResponseInputItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofFunctionCallOutput(
                ResponseInputItem.FunctionCallOutput.builder()
                    .callId("call_id")
                    .output("output")
                    .id("id")
                    .status(ResponseInputItem.FunctionCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
    }

    @Test
    fun ofReasoning() {
        val reasoning =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                .status(ResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        val responseInputItem = ResponseInputItem.ofReasoning(reasoning)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).contains(reasoning)
        assertThat(responseInputItem.itemReference()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofReasoning(
                ResponseReasoningItem.builder()
                    .id("id")
                    .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                    .status(ResponseReasoningItem.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
    }

    @Test
    fun ofItemReference() {
        val itemReference = ResponseInputItem.ItemReference.builder().id("id").build()

        val responseInputItem = ResponseInputItem.ofItemReference(itemReference)

        assertThat(responseInputItem.easyInputMessage()).isEmpty
        assertThat(responseInputItem.message()).isEmpty
        assertThat(responseInputItem.responseOutputMessage()).isEmpty
        assertThat(responseInputItem.fileSearchCall()).isEmpty
        assertThat(responseInputItem.computerCall()).isEmpty
        assertThat(responseInputItem.computerCallOutput()).isEmpty
        assertThat(responseInputItem.webSearchCall()).isEmpty
        assertThat(responseInputItem.functionCall()).isEmpty
        assertThat(responseInputItem.functionCallOutput()).isEmpty
        assertThat(responseInputItem.reasoning()).isEmpty
        assertThat(responseInputItem.itemReference()).contains(itemReference)
    }

    @Test
    fun ofItemReferenceRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputItem =
            ResponseInputItem.ofItemReference(
                ResponseInputItem.ItemReference.builder().id("id").build()
            )

        val roundtrippedResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputItem),
                jacksonTypeRef<ResponseInputItem>(),
            )

        assertThat(roundtrippedResponseInputItem).isEqualTo(responseInputItem)
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
        val responseInputItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseInputItem>())

        val e = assertThrows<OpenAIInvalidDataException> { responseInputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
