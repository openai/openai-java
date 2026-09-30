// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime.translations.clientsecrets

import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateRequest
import com.openai.models.realtime.RealtimeTranslationSessionCreateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientSecretCreateParamsTest {

    @Test
    fun create() {
        ClientSecretCreateParams.builder()
            .realtimeTranslationClientSecretCreateRequest(
                RealtimeTranslationClientSecretCreateRequest.builder()
                    .session(
                        RealtimeTranslationSessionCreateRequest.builder()
                            .model("model")
                            .audio(
                                RealtimeTranslationSessionCreateRequest.Audio.builder()
                                    .input(
                                        RealtimeTranslationSessionCreateRequest.Audio.Input
                                            .builder()
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
                                        RealtimeTranslationSessionCreateRequest.Audio.Output
                                            .builder()
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ClientSecretCreateParams.builder()
                .realtimeTranslationClientSecretCreateRequest(
                    RealtimeTranslationClientSecretCreateRequest.builder()
                        .session(
                            RealtimeTranslationSessionCreateRequest.builder()
                                .model("model")
                                .audio(
                                    RealtimeTranslationSessionCreateRequest.Audio.builder()
                                        .input(
                                            RealtimeTranslationSessionCreateRequest.Audio.Input
                                                .builder()
                                                .noiseReduction(
                                                    RealtimeTranslationSessionCreateRequest.Audio
                                                        .Input
                                                        .NoiseReduction
                                                        .builder()
                                                        .type(NoiseReductionType.NEAR_FIELD)
                                                        .build()
                                                )
                                                .transcription(
                                                    RealtimeTranslationSessionCreateRequest.Audio
                                                        .Input
                                                        .Transcription
                                                        .builder()
                                                        .model("model")
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .output(
                                            RealtimeTranslationSessionCreateRequest.Audio.Output
                                                .builder()
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                RealtimeTranslationClientSecretCreateRequest.builder()
                    .session(
                        RealtimeTranslationSessionCreateRequest.builder()
                            .model("model")
                            .audio(
                                RealtimeTranslationSessionCreateRequest.Audio.builder()
                                    .input(
                                        RealtimeTranslationSessionCreateRequest.Audio.Input
                                            .builder()
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
                                        RealtimeTranslationSessionCreateRequest.Audio.Output
                                            .builder()
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ClientSecretCreateParams.builder()
                .realtimeTranslationClientSecretCreateRequest(
                    RealtimeTranslationClientSecretCreateRequest.builder()
                        .session(
                            RealtimeTranslationSessionCreateRequest.builder().model("model").build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                RealtimeTranslationClientSecretCreateRequest.builder()
                    .session(
                        RealtimeTranslationSessionCreateRequest.builder().model("model").build()
                    )
                    .build()
            )
    }
}
