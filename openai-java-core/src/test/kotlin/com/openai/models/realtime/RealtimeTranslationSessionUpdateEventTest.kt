// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionUpdateEventTest {

    @Test
    fun create() {
        val realtimeTranslationSessionUpdateEvent =
            RealtimeTranslationSessionUpdateEvent.builder()
                .session(
                    RealtimeTranslationSessionUpdateRequest.builder()
                        .audio(
                            RealtimeTranslationSessionUpdateRequest.Audio.builder()
                                .input(
                                    RealtimeTranslationSessionUpdateRequest.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                .Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSessionUpdateRequest.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(realtimeTranslationSessionUpdateEvent.session())
            .isEqualTo(
                RealtimeTranslationSessionUpdateRequest.builder()
                    .audio(
                        RealtimeTranslationSessionUpdateRequest.Audio.builder()
                            .input(
                                RealtimeTranslationSessionUpdateRequest.Audio.Input.builder()
                                    .noiseReduction(
                                        RealtimeTranslationSessionUpdateRequest.Audio.Input
                                            .NoiseReduction
                                            .builder()
                                            .type(NoiseReductionType.NEAR_FIELD)
                                            .build()
                                    )
                                    .transcription(
                                        RealtimeTranslationSessionUpdateRequest.Audio.Input
                                            .Transcription
                                            .builder()
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
                            .output(
                                RealtimeTranslationSessionUpdateRequest.Audio.Output.builder()
                                    .language("language")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeTranslationSessionUpdateEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSessionUpdateEvent =
            RealtimeTranslationSessionUpdateEvent.builder()
                .session(
                    RealtimeTranslationSessionUpdateRequest.builder()
                        .audio(
                            RealtimeTranslationSessionUpdateRequest.Audio.builder()
                                .input(
                                    RealtimeTranslationSessionUpdateRequest.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                .Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSessionUpdateRequest.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedRealtimeTranslationSessionUpdateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionUpdateEvent),
                jacksonTypeRef<RealtimeTranslationSessionUpdateEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionUpdateEvent)
            .isEqualTo(realtimeTranslationSessionUpdateEvent)
    }
}
