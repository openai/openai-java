// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CodeInterpreterToolCallDeltaTest {

    @Test
    fun createAndRoundtrip() {
        val codeInterpreterToolCallDelta =
            CodeInterpreterToolCallDelta.builder()
                .index(0L)
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                        .input("input")
                        .addOutput(CodeInterpreterLogs.builder().index(0L).logs("logs").build())
                        .build()
                )
                .build()

        assertThat(codeInterpreterToolCallDelta.index()).isEqualTo(0L)
        assertThat(codeInterpreterToolCallDelta.id()).contains("id")
        assertThat(codeInterpreterToolCallDelta.codeInterpreter())
            .contains(
                CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                    .input("input")
                    .addOutput(CodeInterpreterLogs.builder().index(0L).logs("logs").build())
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedCodeInterpreterToolCallDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(codeInterpreterToolCallDelta),
                jacksonTypeRef<CodeInterpreterToolCallDelta>(),
            )

        assertThat(roundtrippedCodeInterpreterToolCallDelta).isEqualTo(codeInterpreterToolCallDelta)
    }
}
