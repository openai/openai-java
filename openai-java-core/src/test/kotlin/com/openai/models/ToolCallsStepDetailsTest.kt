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
                                        .type(
                                            CodeInterpreterToolCall.CodeInterpreter.Output
                                                .LogsOutput
                                                .Type
                                                .LOGS
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .type(CodeInterpreterToolCall.Type.CODE_INTERPRETER)
                        .build()
                )
                .type(ToolCallsStepDetails.Type.TOOL_CALLS)
                .build()
        assertThat(toolCallsStepDetails).isNotNull
        assertThat(toolCallsStepDetails.toolCalls())
            .containsExactly(
                ToolCall.ofCodeInterpreterToolCall(
                    CodeInterpreterToolCall.builder()
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCall.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput
                                        .builder()
                                        .logs("logs")
                                        .type(
                                            CodeInterpreterToolCall.CodeInterpreter.Output
                                                .LogsOutput
                                                .Type
                                                .LOGS
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .type(CodeInterpreterToolCall.Type.CODE_INTERPRETER)
                        .build()
                )
            )
        assertThat(toolCallsStepDetails.type()).isEqualTo(ToolCallsStepDetails.Type.TOOL_CALLS)
    }
}
