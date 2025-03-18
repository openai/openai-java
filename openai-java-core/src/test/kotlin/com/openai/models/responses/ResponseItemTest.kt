// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseItemTest {

    @Test
    fun ofResponseInputMessageItem() {
        val responseInputMessageItem =
            ResponseInputMessageItem.builder()
                .id("id")
                .addInputTextContent("text")
                .role(ResponseInputMessageItem.Role.USER)
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

        val responseItem = ResponseItem.ofResponseOutputMessage(responseOutputMessage)

        assertThat(responseItem.responseInputMessageItem()).isEmpty
        assertThat(responseItem.responseOutputMessage()).contains(responseOutputMessage)
        assertThat(responseItem.fileSearchCall()).isEmpty
        assertThat(responseItem.computerCall()).isEmpty
        assertThat(responseItem.computerCallOutput()).isEmpty
        assertThat(responseItem.webSearchCall()).isEmpty
        assertThat(responseItem.functionCall()).isEmpty
        assertThat(responseItem.functionCallOutput()).isEmpty
    }

    @Test
    fun ofFileSearchCall() {
        val fileSearchCall =
            ResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
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
    }

    @Test
    fun ofComputerCallOutput() {
        val computerCallOutput =
            ResponseComputerToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output(ResponseComputerToolCallOutputScreenshot.builder().build())
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
    }

    @Test
    fun ofWebSearchCall() {
        val webSearchCall =
            ResponseFunctionWebSearch.builder()
                .id("id")
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
    }

    @Test
    fun ofFunctionCall() {
        val functionCall =
            ResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
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
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            ResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("output")
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
    }
}
