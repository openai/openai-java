// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartInputAudioTest {

    @Test
    fun create() {
        val chatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio.builder()
                .inputAudio(
                    ChatCompletionContentPartInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio.builder()
                .inputAudio(
                    ChatCompletionContentPartInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                        .build()
                )
                .build()

        val roundtrippedChatCompletionContentPartInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartInputAudio),
                jacksonTypeRef<ChatCompletionContentPartInputAudio>(),
            )

        assertThat(roundtrippedChatCompletionContentPartInputAudio)
            .isEqualTo(chatCompletionContentPartInputAudio)
    }
}
