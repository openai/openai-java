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
                                .index(0L)
                                .build()
                        )
                        .text("text")
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
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
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
                        .score(0.0)
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
                            .score(0.0)
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
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        val responseOutputItem = ResponseOutputItem.ofWebSearchCall(webSearchCall)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).contains(webSearchCall)
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofWebSearchCall(
                ResponseFunctionWebSearch.builder()
                    .id("id")
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
                .status(ResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        val responseOutputItem = ResponseOutputItem.ofReasoning(reasoning)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).contains(reasoning)
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItem =
            ResponseOutputItem.ofReasoning(
                ResponseReasoningItem.builder()
                    .id("id")
                    .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
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
