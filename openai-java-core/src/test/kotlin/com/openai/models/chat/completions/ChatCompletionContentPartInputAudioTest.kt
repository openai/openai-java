// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
}
