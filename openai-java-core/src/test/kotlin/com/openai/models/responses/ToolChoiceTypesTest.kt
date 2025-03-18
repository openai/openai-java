// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceTypesTest {

    @Test
    fun create() {
        val toolChoiceTypes =
            ToolChoiceTypes.builder().type(ToolChoiceTypes.Type.FILE_SEARCH).build()

        assertThat(toolChoiceTypes.type()).isEqualTo(ToolChoiceTypes.Type.FILE_SEARCH)
    }
}
