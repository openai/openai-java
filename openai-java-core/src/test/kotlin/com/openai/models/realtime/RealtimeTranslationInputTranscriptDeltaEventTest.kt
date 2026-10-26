// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationInputTranscriptDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val realtimeTranslationInputTranscriptDeltaEvent =
            RealtimeTranslationInputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        assertThat(realtimeTranslationInputTranscriptDeltaEvent.delta()).isEqualTo("delta")
        assertThat(realtimeTranslationInputTranscriptDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(realtimeTranslationInputTranscriptDeltaEvent.elapsedMs()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedRealtimeTranslationInputTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationInputTranscriptDeltaEvent),
                jacksonTypeRef<RealtimeTranslationInputTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationInputTranscriptDeltaEvent)
            .isEqualTo(realtimeTranslationInputTranscriptDeltaEvent)
    }
}
