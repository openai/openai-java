// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionTest {

    @Test
    fun create() {
        val realtimeTranslationSession =
            RealtimeTranslationSession.builder()
                .id("id")
                .audio(
                    RealtimeTranslationSession.Audio.builder()
                        .input(
                            RealtimeTranslationSession.Audio.Input.builder()
                                .noiseReduction(
                                    RealtimeTranslationSession.Audio.Input.NoiseReduction.builder()
                                        .type(NoiseReductionType.NEAR_FIELD)
                                        .build()
                                )
                                .transcription(
                                    RealtimeTranslationSession.Audio.Input.Transcription.builder()
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

        assertThat(realtimeTranslationSession.id()).isEqualTo("id")
        assertThat(realtimeTranslationSession.audio())
            .isEqualTo(
                RealtimeTranslationSession.Audio.builder()
                    .input(
                        RealtimeTranslationSession.Audio.Input.builder()
                            .noiseReduction(
                                RealtimeTranslationSession.Audio.Input.NoiseReduction.builder()
                                    .type(NoiseReductionType.NEAR_FIELD)
                                    .build()
                            )
                            .transcription(
                                RealtimeTranslationSession.Audio.Input.Transcription.builder()
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
        assertThat(realtimeTranslationSession.expiresAt()).isEqualTo(0L)
        assertThat(realtimeTranslationSession.model()).isEqualTo("model")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSession =
            RealtimeTranslationSession.builder()
                .id("id")
                .audio(
                    RealtimeTranslationSession.Audio.builder()
                        .input(
                            RealtimeTranslationSession.Audio.Input.builder()
                                .noiseReduction(
                                    RealtimeTranslationSession.Audio.Input.NoiseReduction.builder()
                                        .type(NoiseReductionType.NEAR_FIELD)
                                        .build()
                                )
                                .transcription(
                                    RealtimeTranslationSession.Audio.Input.Transcription.builder()
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

        val roundtrippedRealtimeTranslationSession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSession),
                jacksonTypeRef<RealtimeTranslationSession>(),
            )

        assertThat(roundtrippedRealtimeTranslationSession).isEqualTo(realtimeTranslationSession)
    }
}
