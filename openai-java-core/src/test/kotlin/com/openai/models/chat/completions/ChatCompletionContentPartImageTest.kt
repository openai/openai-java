// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartImageTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionContentPartImage =
            ChatCompletionContentPartImage.builder()
                .imageUrl(
                    ChatCompletionContentPartImage.ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ChatCompletionContentPartImage.ImageUrl.Detail.AUTO)
                        .build()
                )
                .promptCacheBreakpoint(
                    ChatCompletionContentPartImage.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
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
        assertThat(chatCompletionContentPartImage.promptCacheBreakpoint())
            .contains(
                ChatCompletionContentPartImage.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionContentPartImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartImage),
                jacksonTypeRef<ChatCompletionContentPartImage>(),
            )

        assertThat(roundtrippedChatCompletionContentPartImage)
            .isEqualTo(chatCompletionContentPartImage)
    }
}
