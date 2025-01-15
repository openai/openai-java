// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionPredictionContentTest {

    @Test
    fun createChatCompletionPredictionContent() {
        val chatCompletionPredictionContent =
            ChatCompletionPredictionContent.builder()
                .content("string")
                .type(ChatCompletionPredictionContent.Type.CONTENT)
                .build()
        assertThat(chatCompletionPredictionContent).isNotNull
        assertThat(chatCompletionPredictionContent.content())
            .isEqualTo(ChatCompletionPredictionContent.Content.ofTextContent("string"))
        assertThat(chatCompletionPredictionContent.type())
            .isEqualTo(ChatCompletionPredictionContent.Type.CONTENT)
    }
}
