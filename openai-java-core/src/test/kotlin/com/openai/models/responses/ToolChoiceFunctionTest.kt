// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceFunctionTest {

    @Test
    fun create() {
        val toolChoiceFunction = ToolChoiceFunction.builder().name("name").build()

        assertThat(toolChoiceFunction.name()).isEqualTo("name")
    }
}
