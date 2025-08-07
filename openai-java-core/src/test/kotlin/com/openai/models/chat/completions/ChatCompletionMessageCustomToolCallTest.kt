// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionMessageCustomToolCallTest {

    @Test
    fun create() {
        val chatCompletionMessageCustomToolCall =
            ChatCompletionMessageCustomToolCall.builder()
                .id("id")
                .custom(
                    ChatCompletionMessageCustomToolCall.Custom.builder()
                        .input("input")
                        .name("name")
                        .build()
                )
                .build()

        assertThat(chatCompletionMessageCustomToolCall.id()).isEqualTo("id")
        assertThat(chatCompletionMessageCustomToolCall.custom())
            .isEqualTo(
                ChatCompletionMessageCustomToolCall.Custom.builder()
                    .input("input")
                    .name("name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageCustomToolCall =
            ChatCompletionMessageCustomToolCall.builder()
                .id("id")
                .custom(
                    ChatCompletionMessageCustomToolCall.Custom.builder()
                        .input("input")
                        .name("name")
                        .build()
                )
                .build()

        val roundtrippedChatCompletionMessageCustomToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageCustomToolCall),
                jacksonTypeRef<ChatCompletionMessageCustomToolCall>(),
            )

        assertThat(roundtrippedChatCompletionMessageCustomToolCall)
            .isEqualTo(chatCompletionMessageCustomToolCall)
    }
}
