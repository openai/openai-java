// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionFunctionCallOptionTest {

    @Test
    fun createChatCompletionFunctionCallOption() {
        val chatCompletionFunctionCallOption =
            ChatCompletionFunctionCallOption.builder().name("name").build()
        assertThat(chatCompletionFunctionCallOption).isNotNull
        assertThat(chatCompletionFunctionCallOption.name()).isEqualTo("name")
    }
}
