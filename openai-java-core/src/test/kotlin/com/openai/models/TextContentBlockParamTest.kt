// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextContentBlockParamTest {

    @Test
    fun createTextContentBlockParam() {
        val textContentBlockParam =
            TextContentBlockParam.builder()
                .text("text")
                .type(TextContentBlockParam.Type.TEXT)
                .build()
        assertThat(textContentBlockParam).isNotNull
        assertThat(textContentBlockParam.text()).isEqualTo("text")
        assertThat(textContentBlockParam.type()).isEqualTo(TextContentBlockParam.Type.TEXT)
    }
}
