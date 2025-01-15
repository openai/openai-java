// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeInterpreterToolCallDeltaTest {

    @Test
    fun createCodeInterpreterToolCallDelta() {
        val codeInterpreterToolCallDelta =
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
        assertThat(codeInterpreterToolCallDelta).isNotNull
        assertThat(codeInterpreterToolCallDelta.index()).isEqualTo(0L)
        assertThat(codeInterpreterToolCallDelta.type())
            .isEqualTo(CodeInterpreterToolCallDelta.Type.CODE_INTERPRETER)
        assertThat(codeInterpreterToolCallDelta.id()).contains("id")
        assertThat(codeInterpreterToolCallDelta.codeInterpreter())
            .contains(
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
    }
}
