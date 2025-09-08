// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionInputAudioTranscriptionTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionInputAudioTranscription =
            RealtimeTranscriptionSessionInputAudioTranscription.builder()
                .language("language")
                .model(RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1)
                .prompt("prompt")
                .build()

        assertThat(realtimeTranscriptionSessionInputAudioTranscription.language())
            .contains("language")
        assertThat(realtimeTranscriptionSessionInputAudioTranscription.model())
            .contains(RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1)
        assertThat(realtimeTranscriptionSessionInputAudioTranscription.prompt()).contains("prompt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionInputAudioTranscription =
            RealtimeTranscriptionSessionInputAudioTranscription.builder()
                .language("language")
                .model(RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1)
                .prompt("prompt")
                .build()

        val roundtrippedRealtimeTranscriptionSessionInputAudioTranscription =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionInputAudioTranscription),
                jacksonTypeRef<RealtimeTranscriptionSessionInputAudioTranscription>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionInputAudioTranscription)
            .isEqualTo(realtimeTranscriptionSessionInputAudioTranscription)
    }
}
