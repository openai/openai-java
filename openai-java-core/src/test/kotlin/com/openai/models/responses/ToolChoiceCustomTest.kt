// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceCustomTest {

    @Test
    fun create() {
        val toolChoiceCustom = ToolChoiceCustom.builder().name("name").build()

        assertThat(toolChoiceCustom.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolChoiceCustom = ToolChoiceCustom.builder().name("name").build()

        val roundtrippedToolChoiceCustom =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceCustom),
                jacksonTypeRef<ToolChoiceCustom>(),
            )

        assertThat(roundtrippedToolChoiceCustom).isEqualTo(toolChoiceCustom)
    }
}
