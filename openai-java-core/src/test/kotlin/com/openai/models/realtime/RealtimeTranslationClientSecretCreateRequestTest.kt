// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranslationClientSecretCreateRequestTest {

    @Test
    fun create() {
        val realtimeTranslationClientSecretCreateRequest =
            RealtimeTranslationClientSecretCreateRequest.builder()
                .session(
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
                )
                .expiresAfter(
                    RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.builder()
                        .anchor(
                            RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.Anchor
                                .CREATED_AT
                        )
                        .seconds(10L)
                        .build()
                )
                .build()

        assertThat(realtimeTranslationClientSecretCreateRequest.session())
            .isEqualTo(
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
            )
        assertThat(realtimeTranslationClientSecretCreateRequest.expiresAfter())
            .contains(
                RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.builder()
                    .anchor(
                        RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.Anchor.CREATED_AT
                    )
                    .seconds(10L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationClientSecretCreateRequest =
            RealtimeTranslationClientSecretCreateRequest.builder()
                .session(
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
                )
                .expiresAfter(
                    RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.builder()
                        .anchor(
                            RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.Anchor
                                .CREATED_AT
                        )
                        .seconds(10L)
                        .build()
                )
                .build()

        val roundtrippedRealtimeTranslationClientSecretCreateRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationClientSecretCreateRequest),
                jacksonTypeRef<RealtimeTranslationClientSecretCreateRequest>(),
            )

        assertThat(roundtrippedRealtimeTranslationClientSecretCreateRequest)
            .isEqualTo(realtimeTranslationClientSecretCreateRequest)
    }
}
