// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeInterpreterToolCallTest {

    @Test
    fun createCodeInterpreterToolCall() {
        val codeInterpreterToolCall =
            CodeInterpreterToolCall.builder()
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCall.CodeInterpreter.builder()
                        .input("input")
                        .addOutput(
                            CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput.builder()
                                .logs("logs")
                                .type(
                                    CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput.Type
                                        .LOGS
                                )
                                .build()
                        )
                        .build()
                )
                .type(CodeInterpreterToolCall.Type.CODE_INTERPRETER)
                .build()
        assertThat(codeInterpreterToolCall).isNotNull
        assertThat(codeInterpreterToolCall.id()).isEqualTo("id")
        assertThat(codeInterpreterToolCall.codeInterpreter())
            .isEqualTo(
                CodeInterpreterToolCall.CodeInterpreter.builder()
                    .input("input")
                    .addOutput(
                        CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput.builder()
                            .logs("logs")
                            .type(
                                CodeInterpreterToolCall.CodeInterpreter.Output.LogsOutput.Type.LOGS
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(codeInterpreterToolCall.type())
            .isEqualTo(CodeInterpreterToolCall.Type.CODE_INTERPRETER)
    }
}
