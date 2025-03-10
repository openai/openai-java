// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionMessageToolCallTest {

    @Test
    fun createChatCompletionMessageToolCall() {
        val chatCompletionMessageToolCall =
            ChatCompletionMessageToolCall.builder()
                .id("id")
                .function(
                    ChatCompletionMessageToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .build()
        assertThat(chatCompletionMessageToolCall).isNotNull
        assertThat(chatCompletionMessageToolCall.id()).isEqualTo("id")
        assertThat(chatCompletionMessageToolCall.function())
            .isEqualTo(
                ChatCompletionMessageToolCall.Function.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
    }
}
