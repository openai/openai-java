// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartTextTest {

    @Test
    fun create() {
        val chatCompletionContentPartText =
            ChatCompletionContentPartText.builder().text("text").build()

        assertThat(chatCompletionContentPartText.text()).isEqualTo("text")
    }
}
