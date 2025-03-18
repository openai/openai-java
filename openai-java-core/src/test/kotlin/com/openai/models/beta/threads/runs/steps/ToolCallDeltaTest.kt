// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolCallDeltaTest {

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter = CodeInterpreterToolCallDelta.builder().index(0L).build()

        val toolCallDelta = ToolCallDelta.ofCodeInterpreter(codeInterpreter)

        assertThat(toolCallDelta.codeInterpreter()).contains(codeInterpreter)
        assertThat(toolCallDelta.fileSearch()).isEmpty
        assertThat(toolCallDelta.function()).isEmpty
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchToolCallDelta.builder()
                .fileSearch(JsonValue.from(mapOf<String, Any>()))
                .index(0L)
                .build()

        val toolCallDelta = ToolCallDelta.ofFileSearch(fileSearch)

        assertThat(toolCallDelta.codeInterpreter()).isEmpty
        assertThat(toolCallDelta.fileSearch()).contains(fileSearch)
        assertThat(toolCallDelta.function()).isEmpty
    }

    @Test
    fun ofFunction() {
        val function = FunctionToolCallDelta.builder().index(0L).build()

        val toolCallDelta = ToolCallDelta.ofFunction(function)

        assertThat(toolCallDelta.codeInterpreter()).isEmpty
        assertThat(toolCallDelta.fileSearch()).isEmpty
        assertThat(toolCallDelta.function()).contains(function)
    }
}
