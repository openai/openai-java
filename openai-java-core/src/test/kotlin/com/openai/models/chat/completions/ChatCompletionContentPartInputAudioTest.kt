// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartInputAudioTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio.builder()
                .inputAudio(
                    ChatCompletionContentPartInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                        .build()
                )
                .promptCacheBreakpoint(
                    ChatCompletionContentPartInputAudio.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(chatCompletionContentPartInputAudio.inputAudio())
            .isEqualTo(
                ChatCompletionContentPartInputAudio.InputAudio.builder()
                    .data("data")
                    .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                    .build()
            )
        assertThat(chatCompletionContentPartInputAudio.promptCacheBreakpoint())
            .contains(
                ChatCompletionContentPartInputAudio.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionContentPartInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartInputAudio),
                jacksonTypeRef<ChatCompletionContentPartInputAudio>(),
            )

        assertThat(roundtrippedChatCompletionContentPartInputAudio)
            .isEqualTo(chatCompletionContentPartInputAudio)
    }
}
