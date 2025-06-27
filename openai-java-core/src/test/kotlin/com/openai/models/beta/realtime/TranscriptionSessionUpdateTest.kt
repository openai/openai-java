// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionUpdateTest {

    @Test
    fun create() {
        val transcriptionSessionUpdate =
            TranscriptionSessionUpdate.builder()
                .session(
                    TranscriptionSessionUpdate.Session.builder()
                        .clientSecret(
                            TranscriptionSessionUpdate.Session.ClientSecret.builder()
                                .expiresAt(
                                    TranscriptionSessionUpdate.Session.ClientSecret.ExpiresAt
                                        .builder()
                                        .anchor(
                                            TranscriptionSessionUpdate.Session.ClientSecret
                                                .ExpiresAt
                                                .Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude("string")
                        .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                                .type(
                                    TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            TranscriptionSessionUpdate.Session.InputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    TranscriptionSessionUpdate.Session.InputAudioTranscription.Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(TranscriptionSessionUpdate.Session.Modality.TEXT)
                        .turnDetection(
                            TranscriptionSessionUpdate.Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Eagerness.LOW
                                )
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(transcriptionSessionUpdate.session())
            .isEqualTo(
                TranscriptionSessionUpdate.Session.builder()
                    .clientSecret(
                        TranscriptionSessionUpdate.Session.ClientSecret.builder()
                            .expiresAt(
                                TranscriptionSessionUpdate.Session.ClientSecret.ExpiresAt.builder()
                                    .anchor(
                                        TranscriptionSessionUpdate.Session.ClientSecret.ExpiresAt
                                            .Anchor
                                            .CREATED_AT
                                    )
                                    .seconds(0L)
                                    .build()
                            )
                            .build()
                    )
                    .addInclude("string")
                    .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                    .inputAudioNoiseReduction(
                        TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                            .type(
                                TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.Type
                                    .NEAR_FIELD
                            )
                            .build()
                    )
                    .inputAudioTranscription(
                        TranscriptionSessionUpdate.Session.InputAudioTranscription.builder()
                            .language("language")
                            .model(
                                TranscriptionSessionUpdate.Session.InputAudioTranscription.Model
                                    .GPT_4O_TRANSCRIBE
                            )
                            .prompt("prompt")
                            .build()
                    )
                    .addModality(TranscriptionSessionUpdate.Session.Modality.TEXT)
                    .turnDetection(
                        TranscriptionSessionUpdate.Session.TurnDetection.builder()
                            .createResponse(true)
                            .eagerness(
                                TranscriptionSessionUpdate.Session.TurnDetection.Eagerness.LOW
                            )
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .build()
            )
        assertThat(transcriptionSessionUpdate.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionSessionUpdate =
            TranscriptionSessionUpdate.builder()
                .session(
                    TranscriptionSessionUpdate.Session.builder()
                        .clientSecret(
                            TranscriptionSessionUpdate.Session.ClientSecret.builder()
                                .expiresAt(
                                    TranscriptionSessionUpdate.Session.ClientSecret.ExpiresAt
                                        .builder()
                                        .anchor(
                                            TranscriptionSessionUpdate.Session.ClientSecret
                                                .ExpiresAt
                                                .Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude("string")
                        .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                                .type(
                                    TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            TranscriptionSessionUpdate.Session.InputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    TranscriptionSessionUpdate.Session.InputAudioTranscription.Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(TranscriptionSessionUpdate.Session.Modality.TEXT)
                        .turnDetection(
                            TranscriptionSessionUpdate.Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Eagerness.LOW
                                )
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedTranscriptionSessionUpdate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSessionUpdate),
                jacksonTypeRef<TranscriptionSessionUpdate>(),
            )

        assertThat(roundtrippedTranscriptionSessionUpdate).isEqualTo(transcriptionSessionUpdate)
    }
}
