// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionMessageToolCallTest {

    @Test
    fun create() {
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

        assertThat(chatCompletionMessageToolCall.id()).isEqualTo("id")
        assertThat(chatCompletionMessageToolCall.function())
            .isEqualTo(
                ChatCompletionMessageToolCall.Function.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedChatCompletionMessageToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageToolCall),
                jacksonTypeRef<ChatCompletionMessageToolCall>(),
            )

        assertThat(roundtrippedChatCompletionMessageToolCall)
            .isEqualTo(chatCompletionMessageToolCall)
    }
}
