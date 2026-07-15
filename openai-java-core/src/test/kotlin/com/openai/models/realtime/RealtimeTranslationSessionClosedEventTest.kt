// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionClosedEventTest {

    @Test
    fun create() {
        val realtimeTranslationSessionClosedEvent =
            RealtimeTranslationSessionClosedEvent.builder().eventId("event_id").build()

        assertThat(realtimeTranslationSessionClosedEvent.eventId()).isEqualTo("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSessionClosedEvent =
            RealtimeTranslationSessionClosedEvent.builder().eventId("event_id").build()

        val roundtrippedRealtimeTranslationSessionClosedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionClosedEvent),
                jacksonTypeRef<RealtimeTranslationSessionClosedEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionClosedEvent)
            .isEqualTo(realtimeTranslationSessionClosedEvent)
    }
}
