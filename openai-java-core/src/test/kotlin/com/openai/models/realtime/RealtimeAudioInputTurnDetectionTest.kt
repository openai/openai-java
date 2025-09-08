// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeAudioInputTurnDetectionTest {

    @Test
    fun create() {
        val realtimeAudioInputTurnDetection =
            RealtimeAudioInputTurnDetection.builder()
                .createResponse(true)
                .eagerness(RealtimeAudioInputTurnDetection.Eagerness.LOW)
                .idleTimeoutMs(0L)
                .interruptResponse(true)
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .type(RealtimeAudioInputTurnDetection.Type.SERVER_VAD)
                .build()

        assertThat(realtimeAudioInputTurnDetection.createResponse()).contains(true)
        assertThat(realtimeAudioInputTurnDetection.eagerness())
            .contains(RealtimeAudioInputTurnDetection.Eagerness.LOW)
        assertThat(realtimeAudioInputTurnDetection.idleTimeoutMs()).contains(0L)
        assertThat(realtimeAudioInputTurnDetection.interruptResponse()).contains(true)
        assertThat(realtimeAudioInputTurnDetection.prefixPaddingMs()).contains(0L)
        assertThat(realtimeAudioInputTurnDetection.silenceDurationMs()).contains(0L)
        assertThat(realtimeAudioInputTurnDetection.threshold()).contains(0.0)
        assertThat(realtimeAudioInputTurnDetection.type())
            .contains(RealtimeAudioInputTurnDetection.Type.SERVER_VAD)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioInputTurnDetection =
            RealtimeAudioInputTurnDetection.builder()
                .createResponse(true)
                .eagerness(RealtimeAudioInputTurnDetection.Eagerness.LOW)
                .idleTimeoutMs(0L)
                .interruptResponse(true)
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .type(RealtimeAudioInputTurnDetection.Type.SERVER_VAD)
                .build()

        val roundtrippedRealtimeAudioInputTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioInputTurnDetection),
                jacksonTypeRef<RealtimeAudioInputTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeAudioInputTurnDetection)
            .isEqualTo(realtimeAudioInputTurnDetection)
    }
}
