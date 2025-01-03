// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeInterpreterToolTest {

    @Test
    fun createCodeInterpreterTool() {
        val codeInterpreterTool =
            CodeInterpreterTool.builder().type(CodeInterpreterTool.Type.CODE_INTERPRETER).build()
        assertThat(codeInterpreterTool).isNotNull
        assertThat(codeInterpreterTool.type()).isEqualTo(CodeInterpreterTool.Type.CODE_INTERPRETER)
    }
}
