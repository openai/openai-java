// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolCallsStepDetailsTest {

    @Test
    fun createAndRoundtrip() {
        val toolCallsStepDetails =
            ToolCallsStepDetails.builder()
                .addToolCall(
                    CodeInterpreterToolCall.builder()
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCall.CodeInterpreter.builder()
                                .input("input")
                                .addLogsOutput("logs")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(toolCallsStepDetails.toolCalls())
            .containsExactly(
                ToolCall.ofCodeInterpreter(
                    CodeInterpreterToolCall.builder()
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCall.CodeInterpreter.builder()
                                .input("input")
                                .addLogsOutput("logs")
                                .build()
                        )
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedToolCallsStepDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCallsStepDetails),
                jacksonTypeRef<ToolCallsStepDetails>(),
            )

        assertThat(roundtrippedToolCallsStepDetails).isEqualTo(toolCallsStepDetails)
    }
}
