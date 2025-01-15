// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ToolCallDeltaObjectTest {

    @Test
    fun createToolCallDeltaObject() {
        val toolCallDeltaObject =
            ToolCallDeltaObject.builder()
                .type(ToolCallDeltaObject.Type.TOOL_CALLS)
                .addToolCall(
                    CodeInterpreterToolCallDelta.builder()
                        .index(0L)
                        .type(CodeInterpreterToolCallDelta.Type.CODE_INTERPRETER)
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterLogs.builder()
                                        .index(0L)
                                        .type(CodeInterpreterLogs.Type.LOGS)
                                        .logs("logs")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(toolCallDeltaObject).isNotNull
        assertThat(toolCallDeltaObject.type()).isEqualTo(ToolCallDeltaObject.Type.TOOL_CALLS)
        assertThat(toolCallDeltaObject.toolCalls().get())
            .containsExactly(
                ToolCallDelta.ofCodeInterpreterToolCallDelta(
                    CodeInterpreterToolCallDelta.builder()
                        .index(0L)
                        .type(CodeInterpreterToolCallDelta.Type.CODE_INTERPRETER)
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterLogs.builder()
                                        .index(0L)
                                        .type(CodeInterpreterLogs.Type.LOGS)
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
