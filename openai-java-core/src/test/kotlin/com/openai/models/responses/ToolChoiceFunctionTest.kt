// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceFunctionTest {

    @Test
    fun createAndRoundtrip() {
        val toolChoiceFunction = ToolChoiceFunction.builder().name("name").build()

        assertThat(toolChoiceFunction.name()).isEqualTo("name")

        val jsonMapper = jsonMapper()

        val roundtrippedToolChoiceFunction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceFunction),
                jacksonTypeRef<ToolChoiceFunction>(),
            )

        assertThat(roundtrippedToolChoiceFunction).isEqualTo(toolChoiceFunction)
    }
}
