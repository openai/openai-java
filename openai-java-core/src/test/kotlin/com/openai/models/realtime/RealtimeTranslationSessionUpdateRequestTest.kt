// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationSessionUpdateRequestTest {

    @Test
    fun create() {
        val realtimeTranslationSessionUpdateRequest =
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

        assertThat(realtimeTranslationSessionUpdateRequest.audio())
            .contains(
                RealtimeTranslationSessionUpdateRequest.Audio.builder()
                    .input(
                        RealtimeTranslationSessionUpdateRequest.Audio.Input.builder()
                            .noiseReduction(
                                RealtimeTranslationSessionUpdateRequest.Audio.Input.NoiseReduction
                                    .builder()
                                    .type(NoiseReductionType.NEAR_FIELD)
                                    .build()
                            )
                            .transcription(
                                RealtimeTranslationSessionUpdateRequest.Audio.Input.Transcription
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationSessionUpdateRequest =
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

        val roundtrippedRealtimeTranslationSessionUpdateRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationSessionUpdateRequest),
                jacksonTypeRef<RealtimeTranslationSessionUpdateRequest>(),
            )

        assertThat(roundtrippedRealtimeTranslationSessionUpdateRequest)
            .isEqualTo(realtimeTranslationSessionUpdateRequest)
    }
}
