// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionNamedToolChoice =
            ChatCompletionNamedToolChoice.builder()
                .function(ChatCompletionNamedToolChoice.Function.builder().name("name").build())
                .build()

        val roundtrippedChatCompletionNamedToolChoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionNamedToolChoice),
                jacksonTypeRef<ChatCompletionNamedToolChoice>(),
            )

        assertThat(roundtrippedChatCompletionNamedToolChoice)
            .isEqualTo(chatCompletionNamedToolChoice)
    }
}
