// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionCloseEventTest {

    @Test
    fun create() {
        val realtimeTranslationSessionCloseEvent =
            RealtimeTranslationSessionCloseEvent.builder().eventId("event_id").build()

        assertThat(realtimeTranslationSessionCloseEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSessionCloseEvent =
            RealtimeTranslationSessionCloseEvent.builder().eventId("event_id").build()

        val roundtrippedRealtimeTranslationSessionCloseEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionCloseEvent),
                jacksonTypeRef<RealtimeTranslationSessionCloseEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionCloseEvent)
            .isEqualTo(realtimeTranslationSessionCloseEvent)
    }
}
