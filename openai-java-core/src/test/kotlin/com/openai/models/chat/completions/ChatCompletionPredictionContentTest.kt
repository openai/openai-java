// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionPredictionContentTest {

    @Test
    fun create() {
        val chatCompletionPredictionContent =
            ChatCompletionPredictionContent.builder().content("string").build()

        assertThat(chatCompletionPredictionContent.content())
            .isEqualTo(ChatCompletionPredictionContent.Content.ofText("string"))
    }
}
