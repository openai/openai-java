// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolCallTest {

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter =
            CodeInterpreterToolCall.builder()
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCall.CodeInterpreter.builder()
                        .input("input")
                        .addLogsOutput("logs")
                        .build()
                )
                .build()

        val toolCall = ToolCall.ofCodeInterpreter(codeInterpreter)

        assertThat(toolCall.codeInterpreter()).contains(codeInterpreter)
        assertThat(toolCall.fileSearch()).isEmpty
        assertThat(toolCall.function()).isEmpty
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchToolCall.builder()
                .id("id")
                .fileSearch(FileSearchToolCall.FileSearch.builder().build())
                .build()

        val toolCall = ToolCall.ofFileSearch(fileSearch)

        assertThat(toolCall.codeInterpreter()).isEmpty
        assertThat(toolCall.fileSearch()).contains(fileSearch)
        assertThat(toolCall.function()).isEmpty
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionToolCall.builder()
                .id("id")
                .function(
                    FunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()

        val toolCall = ToolCall.ofFunction(function)

        assertThat(toolCall.codeInterpreter()).isEmpty
        assertThat(toolCall.fileSearch()).isEmpty
        assertThat(toolCall.function()).contains(function)
    }
}
