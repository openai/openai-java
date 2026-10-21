// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAudioParamTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionAudioParam =
            ChatCompletionAudioParam.builder()
                .format(ChatCompletionAudioParam.Format.WAV)
                .voice(ChatCompletionAudioParam.Voice.UnionMember1.ALLOY)
                .build()

        assertThat(chatCompletionAudioParam.format()).isEqualTo(ChatCompletionAudioParam.Format.WAV)
        assertThat(chatCompletionAudioParam.voice())
            .isEqualTo(
                ChatCompletionAudioParam.Voice.ofUnionMember1(
                    ChatCompletionAudioParam.Voice.UnionMember1.ALLOY
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionAudioParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionAudioParam),
                jacksonTypeRef<ChatCompletionAudioParam>(),
            )

        assertThat(roundtrippedChatCompletionAudioParam).isEqualTo(chatCompletionAudioParam)
    }
}
