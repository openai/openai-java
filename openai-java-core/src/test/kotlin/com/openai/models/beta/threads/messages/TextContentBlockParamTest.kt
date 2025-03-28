// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextContentBlockParamTest {

    @Test
    fun create() {
        val textContentBlockParam = TextContentBlockParam.builder().text("text").build()

        assertThat(textContentBlockParam.text()).isEqualTo("text")
    }
}
