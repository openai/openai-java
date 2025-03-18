// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolCallsStepDetailsTest {

    @Test
    fun create() {
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
    }
}
