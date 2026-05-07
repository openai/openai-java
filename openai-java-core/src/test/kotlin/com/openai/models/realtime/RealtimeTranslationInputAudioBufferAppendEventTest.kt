// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationInputAudioBufferAppendEventTest {

    @Test
    fun create() {
        val realtimeTranslationInputAudioBufferAppendEvent =
            RealtimeTranslationInputAudioBufferAppendEvent.builder()
                .audio("audio")
                .eventId("event_id")
                .build()

        assertThat(realtimeTranslationInputAudioBufferAppendEvent.audio()).isEqualTo("audio")
        assertThat(realtimeTranslationInputAudioBufferAppendEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationInputAudioBufferAppendEvent =
            RealtimeTranslationInputAudioBufferAppendEvent.builder()
                .audio("audio")
                .eventId("event_id")
                .build()

        val roundtrippedRealtimeTranslationInputAudioBufferAppendEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationInputAudioBufferAppendEvent),
                jacksonTypeRef<RealtimeTranslationInputAudioBufferAppendEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationInputAudioBufferAppendEvent)
            .isEqualTo(realtimeTranslationInputAudioBufferAppendEvent)
    }
}
