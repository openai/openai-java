// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.models.FunctionDefinition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantToolTest {

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter = CodeInterpreterTool.builder().build()

        val assistantTool = AssistantTool.ofCodeInterpreter(codeInterpreter)

        assertThat(assistantTool.codeInterpreter()).contains(codeInterpreter)
        assertThat(assistantTool.fileSearch()).isEmpty
        assertThat(assistantTool.function()).isEmpty
    }

    @Test
    fun ofFileSearch() {
        val fileSearch = FileSearchTool.builder().build()

        val assistantTool = AssistantTool.ofFileSearch(fileSearch)

        assertThat(assistantTool.codeInterpreter()).isEmpty
        assertThat(assistantTool.fileSearch()).contains(fileSearch)
        assertThat(assistantTool.function()).isEmpty
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionTool.builder()
                .function(FunctionDefinition.builder().name("name").build())
                .build()

        val assistantTool = AssistantTool.ofFunction(function)

        assertThat(assistantTool.codeInterpreter()).isEmpty
        assertThat(assistantTool.fileSearch()).isEmpty
        assertThat(assistantTool.function()).contains(function)
    }
}
