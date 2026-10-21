// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartTextTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionContentPartText =
            ChatCompletionContentPartText.builder()
                .text("text")
                .promptCacheBreakpoint(
                    ChatCompletionContentPartText.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(chatCompletionContentPartText.text()).isEqualTo("text")
        assertThat(chatCompletionContentPartText.promptCacheBreakpoint())
            .contains(ChatCompletionContentPartText.PromptCacheBreakpoint.builder().build())

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionContentPartText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartText),
                jacksonTypeRef<ChatCompletionContentPartText>(),
            )

        assertThat(roundtrippedChatCompletionContentPartText)
            .isEqualTo(chatCompletionContentPartText)
    }
}
