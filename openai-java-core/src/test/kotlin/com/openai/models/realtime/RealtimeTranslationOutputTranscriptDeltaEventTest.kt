// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationOutputTranscriptDeltaEventTest {

    @Test
    fun create() {
        val realtimeTranslationOutputTranscriptDeltaEvent =
            RealtimeTranslationOutputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        assertThat(realtimeTranslationOutputTranscriptDeltaEvent.delta()).isEqualTo("delta")
        assertThat(realtimeTranslationOutputTranscriptDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(realtimeTranslationOutputTranscriptDeltaEvent.elapsedMs()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationOutputTranscriptDeltaEvent =
            RealtimeTranslationOutputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        val roundtrippedRealtimeTranslationOutputTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationOutputTranscriptDeltaEvent),
                jacksonTypeRef<RealtimeTranslationOutputTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationOutputTranscriptDeltaEvent)
            .isEqualTo(realtimeTranslationOutputTranscriptDeltaEvent)
    }
}
