// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionNamedToolChoiceTest {

    @Test
    fun create() {
        val chatCompletionNamedToolChoice =
            ChatCompletionNamedToolChoice.builder()
                .function(ChatCompletionNamedToolChoice.Function.builder().name("name").build())
                .build()

        assertThat(chatCompletionNamedToolChoice.function())
            .isEqualTo(ChatCompletionNamedToolChoice.Function.builder().name("name").build())
    }
}
