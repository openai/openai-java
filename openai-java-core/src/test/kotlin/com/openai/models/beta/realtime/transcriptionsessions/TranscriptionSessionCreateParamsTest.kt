// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.transcriptionsessions

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionCreateParamsTest {

    @Test
    fun create() {
        TranscriptionSessionCreateParams.builder()
            .clientSecret(
                TranscriptionSessionCreateParams.ClientSecret.builder()
                    .expiresAt(
                        TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.builder()
                            .anchor(
                                TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.Anchor
                                    .CREATED_AT
                            )
                            .seconds(0L)
                            .build()
                    )
                    .build()
            )
            .addInclude("string")
            .inputAudioFormat(TranscriptionSessionCreateParams.InputAudioFormat.PCM16)
            .inputAudioNoiseReduction(
                TranscriptionSessionCreateParams.InputAudioNoiseReduction.builder()
                    .type(TranscriptionSessionCreateParams.InputAudioNoiseReduction.Type.NEAR_FIELD)
                    .build()
            )
            .inputAudioTranscription(
                TranscriptionSessionCreateParams.InputAudioTranscription.builder()
                    .language("language")
                    .model(
                        TranscriptionSessionCreateParams.InputAudioTranscription.Model
                            .GPT_4O_TRANSCRIBE
                    )
                    .prompt("prompt")
                    .build()
            )
            .addModality(TranscriptionSessionCreateParams.Modality.TEXT)
            .turnDetection(
                TranscriptionSessionCreateParams.TurnDetection.builder()
                    .createResponse(true)
                    .eagerness(TranscriptionSessionCreateParams.TurnDetection.Eagerness.LOW)
                    .interruptResponse(true)
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type(TranscriptionSessionCreateParams.TurnDetection.Type.SERVER_VAD)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            TranscriptionSessionCreateParams.builder()
                .clientSecret(
                    TranscriptionSessionCreateParams.ClientSecret.builder()
                        .expiresAt(
                            TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.builder()
                                .anchor(
                                    TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.Anchor
                                        .CREATED_AT
                                )
                                .seconds(0L)
                                .build()
                        )
                        .build()
                )
                .addInclude("string")
                .inputAudioFormat(TranscriptionSessionCreateParams.InputAudioFormat.PCM16)
                .inputAudioNoiseReduction(
                    TranscriptionSessionCreateParams.InputAudioNoiseReduction.builder()
                        .type(
                            TranscriptionSessionCreateParams.InputAudioNoiseReduction.Type
                                .NEAR_FIELD
                        )
                        .build()
                )
                .inputAudioTranscription(
                    TranscriptionSessionCreateParams.InputAudioTranscription.builder()
                        .language("language")
                        .model(
                            TranscriptionSessionCreateParams.InputAudioTranscription.Model
                                .GPT_4O_TRANSCRIBE
                        )
                        .prompt("prompt")
                        .build()
                )
                .addModality(TranscriptionSessionCreateParams.Modality.TEXT)
                .turnDetection(
                    TranscriptionSessionCreateParams.TurnDetection.builder()
                        .createResponse(true)
                        .eagerness(TranscriptionSessionCreateParams.TurnDetection.Eagerness.LOW)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type(TranscriptionSessionCreateParams.TurnDetection.Type.SERVER_VAD)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.clientSecret())
            .contains(
                TranscriptionSessionCreateParams.ClientSecret.builder()
                    .expiresAt(
                        TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.builder()
                            .anchor(
                                TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.Anchor
                                    .CREATED_AT
                            )
                            .seconds(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(body.include().getOrNull()).containsExactly("string")
        assertThat(body.inputAudioFormat())
            .contains(TranscriptionSessionCreateParams.InputAudioFormat.PCM16)
        assertThat(body.inputAudioNoiseReduction())
            .contains(
                TranscriptionSessionCreateParams.InputAudioNoiseReduction.builder()
                    .type(TranscriptionSessionCreateParams.InputAudioNoiseReduction.Type.NEAR_FIELD)
                    .build()
            )
        assertThat(body.inputAudioTranscription())
            .contains(
                TranscriptionSessionCreateParams.InputAudioTranscription.builder()
                    .language("language")
                    .model(
                        TranscriptionSessionCreateParams.InputAudioTranscription.Model
                            .GPT_4O_TRANSCRIBE
                    )
                    .prompt("prompt")
                    .build()
            )
        assertThat(body.modalities().getOrNull())
            .containsExactly(TranscriptionSessionCreateParams.Modality.TEXT)
        assertThat(body.turnDetection())
            .contains(
                TranscriptionSessionCreateParams.TurnDetection.builder()
                    .createResponse(true)
                    .eagerness(TranscriptionSessionCreateParams.TurnDetection.Eagerness.LOW)
                    .interruptResponse(true)
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type(TranscriptionSessionCreateParams.TurnDetection.Type.SERVER_VAD)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TranscriptionSessionCreateParams.builder().build()

        val body = params._body()
    }
}
