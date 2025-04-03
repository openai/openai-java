// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceFunctionTest {

    @Test
    fun create() {
        val toolChoiceFunction = ToolChoiceFunction.builder().name("name").build()

        assertThat(toolChoiceFunction.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolChoiceFunction = ToolChoiceFunction.builder().name("name").build()

        val roundtrippedToolChoiceFunction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceFunction),
                jacksonTypeRef<ToolChoiceFunction>(),
            )

        assertThat(roundtrippedToolChoiceFunction).isEqualTo(toolChoiceFunction)
    }
}
