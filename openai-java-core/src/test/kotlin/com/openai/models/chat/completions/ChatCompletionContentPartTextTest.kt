// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartTextTest {

    @Test
    fun create() {
        val chatCompletionContentPartText =
            ChatCompletionContentPartText.builder().text("text").build()

        assertThat(chatCompletionContentPartText.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPartText =
            ChatCompletionContentPartText.builder().text("text").build()

        val roundtrippedChatCompletionContentPartText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartText),
                jacksonTypeRef<ChatCompletionContentPartText>(),
            )

        assertThat(roundtrippedChatCompletionContentPartText)
            .isEqualTo(chatCompletionContentPartText)
    }
}
