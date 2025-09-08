// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionAudioInputTurnDetectionTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionAudioInputTurnDetection =
            RealtimeTranscriptionSessionAudioInputTurnDetection.builder()
                .createResponse(true)
                .eagerness(RealtimeTranscriptionSessionAudioInputTurnDetection.Eagerness.LOW)
                .idleTimeoutMs(0L)
                .interruptResponse(true)
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .type(RealtimeTranscriptionSessionAudioInputTurnDetection.Type.SERVER_VAD)
                .build()

        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.createResponse())
            .contains(true)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.eagerness())
            .contains(RealtimeTranscriptionSessionAudioInputTurnDetection.Eagerness.LOW)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.idleTimeoutMs()).contains(0L)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.interruptResponse())
            .contains(true)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.prefixPaddingMs())
            .contains(0L)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.silenceDurationMs())
            .contains(0L)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.threshold()).contains(0.0)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.type())
            .contains(RealtimeTranscriptionSessionAudioInputTurnDetection.Type.SERVER_VAD)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionAudioInputTurnDetection =
            RealtimeTranscriptionSessionAudioInputTurnDetection.builder()
                .createResponse(true)
                .eagerness(RealtimeTranscriptionSessionAudioInputTurnDetection.Eagerness.LOW)
                .idleTimeoutMs(0L)
                .interruptResponse(true)
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .type(RealtimeTranscriptionSessionAudioInputTurnDetection.Type.SERVER_VAD)
                .build()

        val roundtrippedRealtimeTranscriptionSessionAudioInputTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionAudioInputTurnDetection),
                jacksonTypeRef<RealtimeTranscriptionSessionAudioInputTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionAudioInputTurnDetection)
            .isEqualTo(realtimeTranscriptionSessionAudioInputTurnDetection)
    }
}
