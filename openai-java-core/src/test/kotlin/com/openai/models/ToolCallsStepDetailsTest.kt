// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ToolCallsStepDetailsTest {

    @Test
    fun createToolCallsStepDetails() {
        val toolCallsStepDetails =
            ToolCallsStepDetails.builder()
                .addToolCall(
                    CodeInterpreterToolCall.builder()
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCall.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput
                                        .builder()
                                        .logs("logs")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(toolCallsStepDetails).isNotNull
        assertThat(toolCallsStepDetails.toolCalls())
            .containsExactly(
                ToolCall.ofCodeInterpreter(
                    CodeInterpreterToolCall.builder()
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCall.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput
                                        .builder()
                                        .logs("logs")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
            )
    }
}
