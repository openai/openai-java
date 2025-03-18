// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
    fun ofFileSearchCall() {
        val fileSearchCall =
            ResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
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
    fun ofFunctionCall() {
        val functionCall =
            ResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
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
    fun ofReasoning() {
        val reasoning =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                .build()

        val responseOutputItem = ResponseOutputItem.ofReasoning(reasoning)

        assertThat(responseOutputItem.message()).isEmpty
        assertThat(responseOutputItem.fileSearchCall()).isEmpty
        assertThat(responseOutputItem.functionCall()).isEmpty
        assertThat(responseOutputItem.webSearchCall()).isEmpty
        assertThat(responseOutputItem.computerCall()).isEmpty
        assertThat(responseOutputItem.reasoning()).contains(reasoning)
    }
}
