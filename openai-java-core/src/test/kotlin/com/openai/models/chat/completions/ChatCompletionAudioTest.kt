// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAudioTest {

    @Test
    fun createAndRoundtrip() {
        val chatCompletionAudio =
            ChatCompletionAudio.builder()
                .id("id")
                .data("data")
                .expiresAt(0L)
                .transcript("transcript")
                .build()

        assertThat(chatCompletionAudio.id()).contains("id")
        assertThat(chatCompletionAudio.data()).contains("data")
        assertThat(chatCompletionAudio.expiresAt()).contains(0L)
        assertThat(chatCompletionAudio.transcript()).contains("transcript")

        val jsonMapper = jsonMapper()

        val roundtrippedChatCompletionAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionAudio),
                jacksonTypeRef<ChatCompletionAudio>(),
            )

        assertThat(roundtrippedChatCompletionAudio).isEqualTo(chatCompletionAudio)
    }
}
