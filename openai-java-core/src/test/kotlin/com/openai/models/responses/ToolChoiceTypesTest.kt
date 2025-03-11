// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ToolChoiceTypesTest {

    @Test
    fun createToolChoiceTypes() {
        val toolChoiceTypes =
            ToolChoiceTypes.builder().type(ToolChoiceTypes.Type.FILE_SEARCH).build()
        assertThat(toolChoiceTypes).isNotNull
        assertThat(toolChoiceTypes.type()).isEqualTo(ToolChoiceTypes.Type.FILE_SEARCH)
    }
}
