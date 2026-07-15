// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionUpdatedEventTest {

    @Test
    fun create() {
        val realtimeTranslationSessionUpdatedEvent =
            RealtimeTranslationSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranslationSession.builder()
                        .id("id")
                        .audio(
                            RealtimeTranslationSession.Audio.builder()
                                .input(
                                    RealtimeTranslationSession.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSession.Audio.Input.NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSession.Audio.Input.Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSession.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .expiresAt(0L)
                        .model("model")
                        .build()
                )
                .build()

        assertThat(realtimeTranslationSessionUpdatedEvent.eventId()).isEqualTo("event_id")
        assertThat(realtimeTranslationSessionUpdatedEvent.session())
            .isEqualTo(
                RealtimeTranslationSession.builder()
                    .id("id")
                    .audio(
                        RealtimeTranslationSession.Audio.builder()
                            .input(
                                RealtimeTranslationSession.Audio.Input.builder()
                                    .noiseReduction(
                                        RealtimeTranslationSession.Audio.Input.NoiseReduction
                                            .builder()
                                            .type(NoiseReductionType.NEAR_FIELD)
                                            .build()
                                    )
                                    .transcription(
                                        RealtimeTranslationSession.Audio.Input.Transcription
                                            .builder()
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
                            .output(
                                RealtimeTranslationSession.Audio.Output.builder()
                                    .language("language")
                                    .build()
                            )
                            .build()
                    )
                    .expiresAt(0L)
                    .model("model")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSessionUpdatedEvent =
            RealtimeTranslationSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranslationSession.builder()
                        .id("id")
                        .audio(
                            RealtimeTranslationSession.Audio.builder()
                                .input(
                                    RealtimeTranslationSession.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSession.Audio.Input.NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSession.Audio.Input.Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSession.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .expiresAt(0L)
                        .model("model")
                        .build()
                )
                .build()

        val roundtrippedRealtimeTranslationSessionUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionUpdatedEvent),
                jacksonTypeRef<RealtimeTranslationSessionUpdatedEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionUpdatedEvent)
            .isEqualTo(realtimeTranslationSessionUpdatedEvent)
    }
}
