// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceTypesTest {

    @Test
    fun create() {
        val toolChoiceTypes =
            ToolChoiceTypes.builder().type(ToolChoiceTypes.Type.FILE_SEARCH).build()

        assertThat(toolChoiceTypes.type()).isEqualTo(ToolChoiceTypes.Type.FILE_SEARCH)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolChoiceTypes =
            ToolChoiceTypes.builder().type(ToolChoiceTypes.Type.FILE_SEARCH).build()

        val roundtrippedToolChoiceTypes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceTypes),
                jacksonTypeRef<ToolChoiceTypes>(),
            )

        assertThat(roundtrippedToolChoiceTypes).isEqualTo(toolChoiceTypes)
    }
}
