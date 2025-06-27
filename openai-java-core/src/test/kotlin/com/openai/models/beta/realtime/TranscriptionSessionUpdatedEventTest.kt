// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSession
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionUpdatedEventTest {

    @Test
    fun create() {
        val transcriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    TranscriptionSession.builder()
                        .clientSecret(
                            TranscriptionSession.ClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            TranscriptionSession.InputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    TranscriptionSession.InputAudioTranscription.Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(TranscriptionSession.Modality.TEXT)
                        .turnDetection(
                            TranscriptionSession.TurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type("type")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(transcriptionSessionUpdatedEvent.eventId()).isEqualTo("event_id")
        assertThat(transcriptionSessionUpdatedEvent.session())
            .isEqualTo(
                TranscriptionSession.builder()
                    .clientSecret(
                        TranscriptionSession.ClientSecret.builder()
                            .expiresAt(0L)
                            .value("value")
                            .build()
                    )
                    .inputAudioFormat("input_audio_format")
                    .inputAudioTranscription(
                        TranscriptionSession.InputAudioTranscription.builder()
                            .language("language")
                            .model(
                                TranscriptionSession.InputAudioTranscription.Model.GPT_4O_TRANSCRIBE
                            )
                            .prompt("prompt")
                            .build()
                    )
                    .addModality(TranscriptionSession.Modality.TEXT)
                    .turnDetection(
                        TranscriptionSession.TurnDetection.builder()
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type("type")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    TranscriptionSession.builder()
                        .clientSecret(
                            TranscriptionSession.ClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            TranscriptionSession.InputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    TranscriptionSession.InputAudioTranscription.Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(TranscriptionSession.Modality.TEXT)
                        .turnDetection(
                            TranscriptionSession.TurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type("type")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedTranscriptionSessionUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSessionUpdatedEvent),
                jacksonTypeRef<TranscriptionSessionUpdatedEvent>(),
            )

        assertThat(roundtrippedTranscriptionSessionUpdatedEvent)
            .isEqualTo(transcriptionSessionUpdatedEvent)
    }
}
