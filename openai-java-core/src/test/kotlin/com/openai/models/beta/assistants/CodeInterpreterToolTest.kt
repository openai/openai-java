// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeInterpreterToolTest {

    @Test
    fun createCodeInterpreterTool() {
        val codeInterpreterTool = CodeInterpreterTool.builder().build()
        assertThat(codeInterpreterTool).isNotNull
    }
}
