// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionMessageFunctionToolCallTest {

    @Test
    fun create() {
        val chatCompletionMessageFunctionToolCall =
            ChatCompletionMessageFunctionToolCall.builder()
                .id("id")
                .function(
                    ChatCompletionMessageFunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .build()

        assertThat(chatCompletionMessageFunctionToolCall.id()).isEqualTo("id")
        assertThat(chatCompletionMessageFunctionToolCall.function())
            .isEqualTo(
                ChatCompletionMessageFunctionToolCall.Function.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionMessageFunctionToolCall =
            ChatCompletionMessageFunctionToolCall.builder()
                .id("id")
                .function(
                    ChatCompletionMessageFunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .build()

        val roundtrippedChatCompletionMessageFunctionToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageFunctionToolCall),
                jacksonTypeRef<ChatCompletionMessageFunctionToolCall>(),
            )

        assertThat(roundtrippedChatCompletionMessageFunctionToolCall)
            .isEqualTo(chatCompletionMessageFunctionToolCall)
    }
}
