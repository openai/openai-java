// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CodeInterpreterToolTest {

    @Test
    fun create() {
        val codeInterpreterTool = CodeInterpreterTool.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val codeInterpreterTool = CodeInterpreterTool.builder().build()

        val roundtrippedCodeInterpreterTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(codeInterpreterTool),
                jacksonTypeRef<CodeInterpreterTool>(),
            )

        assertThat(roundtrippedCodeInterpreterTool).isEqualTo(codeInterpreterTool)
    }
}
