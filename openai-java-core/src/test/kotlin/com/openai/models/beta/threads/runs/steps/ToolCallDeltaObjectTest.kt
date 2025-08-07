// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolCallDeltaObjectTest {

    @Test
    fun create() {
        val toolCallDeltaObject =
            ToolCallDeltaObject.builder()
                .addToolCall(
                    CodeInterpreterToolCallDelta.builder()
                        .index(0L)
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterLogs.builder().index(0L).logs("logs").build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(toolCallDeltaObject.toolCalls().getOrNull())
            .containsExactly(
                ToolCallDelta.ofCodeInterpreter(
                    CodeInterpreterToolCallDelta.builder()
                        .index(0L)
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterLogs.builder().index(0L).logs("logs").build()
                                )
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolCallDeltaObject =
            ToolCallDeltaObject.builder()
                .addToolCall(
                    CodeInterpreterToolCallDelta.builder()
                        .index(0L)
                        .id("id")
                        .codeInterpreter(
                            CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                                .input("input")
                                .addOutput(
                                    CodeInterpreterLogs.builder().index(0L).logs("logs").build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedToolCallDeltaObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCallDeltaObject),
                jacksonTypeRef<ToolCallDeltaObject>(),
            )

        assertThat(roundtrippedToolCallDeltaObject).isEqualTo(toolCallDeltaObject)
    }
}
