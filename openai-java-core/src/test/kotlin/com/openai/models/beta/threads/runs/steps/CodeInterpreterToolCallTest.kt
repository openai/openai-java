// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CodeInterpreterToolCallTest {

    @Test
    fun create() {
        val codeInterpreterToolCall =
            CodeInterpreterToolCall.builder()
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCall.CodeInterpreter.builder()
                        .input("input")
                        .addLogsOutput("logs")
                        .build()
                )
                .build()

        assertThat(codeInterpreterToolCall.id()).isEqualTo("id")
        assertThat(codeInterpreterToolCall.codeInterpreter())
            .isEqualTo(
                CodeInterpreterToolCall.CodeInterpreter.builder()
                    .input("input")
                    .addLogsOutput("logs")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val codeInterpreterToolCall =
            CodeInterpreterToolCall.builder()
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCall.CodeInterpreter.builder()
                        .input("input")
                        .addLogsOutput("logs")
                        .build()
                )
                .build()

        val roundtrippedCodeInterpreterToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(codeInterpreterToolCall),
                jacksonTypeRef<CodeInterpreterToolCall>(),
            )

        assertThat(roundtrippedCodeInterpreterToolCall).isEqualTo(codeInterpreterToolCall)
    }
}
