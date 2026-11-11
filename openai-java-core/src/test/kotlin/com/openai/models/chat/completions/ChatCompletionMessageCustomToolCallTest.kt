// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionMessageCustomToolCallTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(chatCompletionMessageCustomToolCall.id()).contains("id")
        assertThat(chatCompletionMessageCustomToolCall.custom())
            .contains(
                ChatCompletionMessageCustomToolCall.Custom.builder()
                    .input("input")
                    .name("name")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionMessageCustomToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionMessageCustomToolCall),
                jacksonTypeRef<ChatCompletionMessageCustomToolCall>(),
            )

        assertThat(roundtrippedChatCompletionMessageCustomToolCall)
            .isEqualTo(chatCompletionMessageCustomToolCall)
    }
}
