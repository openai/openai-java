// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationOutputAudioDeltaEventTest {

    @Test
    fun create() {
        val realtimeTranslationOutputAudioDeltaEvent =
            RealtimeTranslationOutputAudioDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .channels(0L)
                .elapsedMs(0L)
                .format(RealtimeTranslationOutputAudioDeltaEvent.Format.PCM16)
                .sampleRate(0L)
                .build()

        assertThat(realtimeTranslationOutputAudioDeltaEvent.delta()).isEqualTo("delta")
        assertThat(realtimeTranslationOutputAudioDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(realtimeTranslationOutputAudioDeltaEvent.channels()).contains(0L)
        assertThat(realtimeTranslationOutputAudioDeltaEvent.elapsedMs()).contains(0L)
        assertThat(realtimeTranslationOutputAudioDeltaEvent.format())
            .contains(RealtimeTranslationOutputAudioDeltaEvent.Format.PCM16)
        assertThat(realtimeTranslationOutputAudioDeltaEvent.sampleRate()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationOutputAudioDeltaEvent =
            RealtimeTranslationOutputAudioDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .channels(0L)
                .elapsedMs(0L)
                .format(RealtimeTranslationOutputAudioDeltaEvent.Format.PCM16)
                .sampleRate(0L)
                .build()

        val roundtrippedRealtimeTranslationOutputAudioDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationOutputAudioDeltaEvent),
                jacksonTypeRef<RealtimeTranslationOutputAudioDeltaEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationOutputAudioDeltaEvent)
            .isEqualTo(realtimeTranslationOutputAudioDeltaEvent)
    }
}
