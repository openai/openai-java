// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputItemTest {

    @Test
    fun ofEasyInputMessage() {
        val easyInputMessage =
            EasyInputMessage.builder().content("string").role(EasyInputMessage.Role.USER).build()

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
    fun ofMessage() {
        val message =
            ResponseInputItem.Message.builder()
                .addInputTextContent("text")
                .role(ResponseInputItem.Message.Role.USER)
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
    fun ofFileSearchCall() {
        val fileSearchCall =
            ResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(ResponseFileSearchToolCall.Status.IN_PROGRESS)
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
    fun ofComputerCallOutput() {
        val computerCallOutput =
            ResponseInputItem.ComputerCallOutput.builder()
                .callId("call_id")
                .output(ResponseInputItem.ComputerCallOutput.Output.builder().build())
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
    fun ofFunctionCall() {
        val functionCall =
            ResponseFunctionToolCall.builder()
                .id("id")
                .arguments("arguments")
                .callId("call_id")
                .name("name")
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
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            ResponseInputItem.FunctionCallOutput.builder()
                .callId("call_id")
                .output("output")
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
    fun ofReasoning() {
        val reasoning =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
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
}
