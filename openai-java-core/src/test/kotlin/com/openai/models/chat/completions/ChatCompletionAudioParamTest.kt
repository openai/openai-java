// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionAudioParamTest {

    @Test
    fun createChatCompletionAudioParam() {
        val chatCompletionAudioParam =
            ChatCompletionAudioParam.builder()
                .format(ChatCompletionAudioParam.Format.WAV)
                .voice(ChatCompletionAudioParam.Voice.ALLOY)
                .build()
        assertThat(chatCompletionAudioParam).isNotNull
        assertThat(chatCompletionAudioParam.format()).isEqualTo(ChatCompletionAudioParam.Format.WAV)
        assertThat(chatCompletionAudioParam.voice()).isEqualTo(ChatCompletionAudioParam.Voice.ALLOY)
    }
}
