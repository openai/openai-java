// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionFunctionCallOptionTest {

    @Test
    fun create() {
        val chatCompletionFunctionCallOption =
            ChatCompletionFunctionCallOption.builder().name("name").build()

        assertThat(chatCompletionFunctionCallOption.name()).isEqualTo("name")
    }
}
