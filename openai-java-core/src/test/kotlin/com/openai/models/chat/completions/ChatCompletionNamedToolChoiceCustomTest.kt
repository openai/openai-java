// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionNamedToolChoiceCustomTest {

    @Test
    fun create() {
        val chatCompletionNamedToolChoiceCustom =
            ChatCompletionNamedToolChoiceCustom.builder()
                .custom(ChatCompletionNamedToolChoiceCustom.Custom.builder().name("name").build())
                .build()

        assertThat(chatCompletionNamedToolChoiceCustom.custom())
            .isEqualTo(ChatCompletionNamedToolChoiceCustom.Custom.builder().name("name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionNamedToolChoiceCustom =
            ChatCompletionNamedToolChoiceCustom.builder()
                .custom(ChatCompletionNamedToolChoiceCustom.Custom.builder().name("name").build())
                .build()

        val roundtrippedChatCompletionNamedToolChoiceCustom =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionNamedToolChoiceCustom),
                jacksonTypeRef<ChatCompletionNamedToolChoiceCustom>(),
            )

        assertThat(roundtrippedChatCompletionNamedToolChoiceCustom)
            .isEqualTo(chatCompletionNamedToolChoiceCustom)
    }
}
