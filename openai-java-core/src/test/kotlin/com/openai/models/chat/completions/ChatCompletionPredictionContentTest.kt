// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionPredictionContent =
            ChatCompletionPredictionContent.builder().content("string").build()

        val roundtrippedChatCompletionPredictionContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionPredictionContent),
                jacksonTypeRef<ChatCompletionPredictionContent>(),
            )

        assertThat(roundtrippedChatCompletionPredictionContent)
            .isEqualTo(chatCompletionPredictionContent)
    }
}
