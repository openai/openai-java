// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionCreateRequestTest {

    @Test
    fun create() {
        val realtimeTranslationSessionCreateRequest =
            RealtimeTranslationSessionCreateRequest.builder()
                .model("model")
                .audio(
                    RealtimeTranslationSessionCreateRequest.Audio.builder()
                        .input(
                            RealtimeTranslationSessionCreateRequest.Audio.Input.builder()
                                .noiseReduction(
                                    RealtimeTranslationSessionCreateRequest.Audio.Input
                                        .NoiseReduction
                                        .builder()
                                        .type(NoiseReductionType.NEAR_FIELD)
                                        .build()
                                )
                                .transcription(
                                    RealtimeTranslationSessionCreateRequest.Audio.Input
                                        .Transcription
                                        .builder()
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeTranslationSessionCreateRequest.Audio.Output.builder()
                                .language("language")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(realtimeTranslationSessionCreateRequest.model()).isEqualTo("model")
        assertThat(realtimeTranslationSessionCreateRequest.audio())
            .contains(
                RealtimeTranslationSessionCreateRequest.Audio.builder()
                    .input(
                        RealtimeTranslationSessionCreateRequest.Audio.Input.builder()
                            .noiseReduction(
                                RealtimeTranslationSessionCreateRequest.Audio.Input.NoiseReduction
                                    .builder()
                                    .type(NoiseReductionType.NEAR_FIELD)
                                    .build()
                            )
                            .transcription(
                                RealtimeTranslationSessionCreateRequest.Audio.Input.Transcription
                                    .builder()
                                    .model("model")
                                    .build()
                            )
                            .build()
                    )
                    .output(
                        RealtimeTranslationSessionCreateRequest.Audio.Output.builder()
                            .language("language")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSessionCreateRequest =
            RealtimeTranslationSessionCreateRequest.builder()
                .model("model")
                .audio(
                    RealtimeTranslationSessionCreateRequest.Audio.builder()
                        .input(
                            RealtimeTranslationSessionCreateRequest.Audio.Input.builder()
                                .noiseReduction(
                                    RealtimeTranslationSessionCreateRequest.Audio.Input
                                        .NoiseReduction
                                        .builder()
                                        .type(NoiseReductionType.NEAR_FIELD)
                                        .build()
                                )
                                .transcription(
                                    RealtimeTranslationSessionCreateRequest.Audio.Input
                                        .Transcription
                                        .builder()
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeTranslationSessionCreateRequest.Audio.Output.builder()
                                .language("language")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedRealtimeTranslationSessionCreateRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionCreateRequest),
                jacksonTypeRef<RealtimeTranslationSessionCreateRequest>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionCreateRequest)
            .isEqualTo(realtimeTranslationSessionCreateRequest)
    }
}
