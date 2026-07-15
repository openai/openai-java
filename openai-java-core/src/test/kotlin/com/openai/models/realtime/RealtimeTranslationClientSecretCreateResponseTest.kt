// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationClientSecretCreateResponseTest {

    @Test
    fun create() {
        val realtimeTranslationClientSecretCreateResponse =
            RealtimeTranslationClientSecretCreateResponse.builder()
                .expiresAt(0L)
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
                .value("value")
                .build()

        assertThat(realtimeTranslationClientSecretCreateResponse.expiresAt()).isEqualTo(0L)
        assertThat(realtimeTranslationClientSecretCreateResponse.session())
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
        assertThat(realtimeTranslationClientSecretCreateResponse.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationClientSecretCreateResponse =
            RealtimeTranslationClientSecretCreateResponse.builder()
                .expiresAt(0L)
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
                .value("value")
                .build()

        val roundtrippedRealtimeTranslationClientSecretCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationClientSecretCreateResponse),
                jacksonTypeRef<RealtimeTranslationClientSecretCreateResponse>(),
            )

        assertThat(roundtrippedRealtimeTranslationClientSecretCreateResponse)
            .isEqualTo(realtimeTranslationClientSecretCreateResponse)
    }
}
