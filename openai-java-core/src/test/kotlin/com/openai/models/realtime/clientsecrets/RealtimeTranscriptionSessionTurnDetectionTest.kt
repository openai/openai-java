// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionTurnDetectionTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionTurnDetection =
            RealtimeTranscriptionSessionTurnDetection.builder()
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .type("type")
                .build()

        assertThat(realtimeTranscriptionSessionTurnDetection.prefixPaddingMs()).contains(0L)
        assertThat(realtimeTranscriptionSessionTurnDetection.silenceDurationMs()).contains(0L)
        assertThat(realtimeTranscriptionSessionTurnDetection.threshold()).contains(0.0)
        assertThat(realtimeTranscriptionSessionTurnDetection.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionTurnDetection =
            RealtimeTranscriptionSessionTurnDetection.builder()
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .type("type")
                .build()

        val roundtrippedRealtimeTranscriptionSessionTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionTurnDetection),
                jacksonTypeRef<RealtimeTranscriptionSessionTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionTurnDetection)
            .isEqualTo(realtimeTranscriptionSessionTurnDetection)
    }
}
