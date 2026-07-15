// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationInputTranscriptDeltaEventTest {

    @Test
    fun create() {
        val realtimeTranslationInputTranscriptDeltaEvent =
            RealtimeTranslationInputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        assertThat(realtimeTranslationInputTranscriptDeltaEvent.delta()).isEqualTo("delta")
        assertThat(realtimeTranslationInputTranscriptDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(realtimeTranslationInputTranscriptDeltaEvent.elapsedMs()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationInputTranscriptDeltaEvent =
            RealtimeTranslationInputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        val roundtrippedRealtimeTranslationInputTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationInputTranscriptDeltaEvent),
                jacksonTypeRef<RealtimeTranslationInputTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationInputTranscriptDeltaEvent)
            .isEqualTo(realtimeTranslationInputTranscriptDeltaEvent)
    }
}
