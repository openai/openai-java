// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartImageTest {

    @Test
    fun create() {
        val chatCompletionContentPartImage =
            ChatCompletionContentPartImage.builder()
                .imageUrl(
                    ChatCompletionContentPartImage.ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ChatCompletionContentPartImage.ImageUrl.Detail.AUTO)
                        .build()
                )
                .build()

        assertThat(chatCompletionContentPartImage.imageUrl())
            .isEqualTo(
                ChatCompletionContentPartImage.ImageUrl.builder()
                    .url("https://example.com")
                    .detail(ChatCompletionContentPartImage.ImageUrl.Detail.AUTO)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPartImage =
            ChatCompletionContentPartImage.builder()
                .imageUrl(
                    ChatCompletionContentPartImage.ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ChatCompletionContentPartImage.ImageUrl.Detail.AUTO)
                        .build()
                )
                .build()

        val roundtrippedChatCompletionContentPartImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartImage),
                jacksonTypeRef<ChatCompletionContentPartImage>(),
            )

        assertThat(roundtrippedChatCompletionContentPartImage)
            .isEqualTo(chatCompletionContentPartImage)
    }
}
