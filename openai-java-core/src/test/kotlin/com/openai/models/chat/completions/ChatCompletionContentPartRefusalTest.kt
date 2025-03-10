// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionContentPartRefusalTest {

    @Test
    fun createChatCompletionContentPartRefusal() {
        val chatCompletionContentPartRefusal =
            ChatCompletionContentPartRefusal.builder().refusal("refusal").build()
        assertThat(chatCompletionContentPartRefusal).isNotNull
        assertThat(chatCompletionContentPartRefusal.refusal()).isEqualTo("refusal")
    }
}
