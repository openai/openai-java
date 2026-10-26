// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionCloseEventTest {

    @Test
    fun createAndRoundtrip() {
        val realtimeTranslationSessionCloseEvent =
            RealtimeTranslationSessionCloseEvent.builder().eventId("event_id").build()

        assertThat(realtimeTranslationSessionCloseEvent.eventId()).contains("event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedRealtimeTranslationSessionCloseEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionCloseEvent),
                jacksonTypeRef<RealtimeTranslationSessionCloseEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionCloseEvent)
            .isEqualTo(realtimeTranslationSessionCloseEvent)
    }
}
