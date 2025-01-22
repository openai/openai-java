// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionContentPartTextTest {

    @Test
    fun createChatCompletionContentPartText() {
        val chatCompletionContentPartText =
            ChatCompletionContentPartText.builder().text("text").build()
        assertThat(chatCompletionContentPartText).isNotNull
        assertThat(chatCompletionContentPartText.text()).isEqualTo("text")
    }
}
