// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAudioTest {

    @Test
    fun create() {
        val chatCompletionAudio =
            ChatCompletionAudio.builder()
                .id("id")
                .data("data")
                .expiresAt(0L)
                .transcript("transcript")
                .build()

        assertThat(chatCompletionAudio.id()).isEqualTo("id")
        assertThat(chatCompletionAudio.data()).isEqualTo("data")
        assertThat(chatCompletionAudio.expiresAt()).isEqualTo(0L)
        assertThat(chatCompletionAudio.transcript()).isEqualTo("transcript")
    }
}
