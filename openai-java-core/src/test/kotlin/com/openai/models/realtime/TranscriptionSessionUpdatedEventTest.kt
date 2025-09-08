// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionClientSecret
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionCreateResponse
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionInputAudioTranscription
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionTurnDetection
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionUpdatedEventTest {

    @Test
    fun create() {
        val transcriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranscriptionSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeTranscriptionSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionInputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionInputAudioTranscription.Model
                                        .WHISPER_1
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                        .turnDetection(
                            RealtimeTranscriptionSessionTurnDetection.builder()
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
                RealtimeTranscriptionSessionCreateResponse.builder()
                    .clientSecret(
                        RealtimeTranscriptionSessionClientSecret.builder()
                            .expiresAt(0L)
                            .value("value")
                            .build()
                    )
                    .inputAudioFormat("input_audio_format")
                    .inputAudioTranscription(
                        RealtimeTranscriptionSessionInputAudioTranscription.builder()
                            .language("language")
                            .model(
                                RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1
                            )
                            .prompt("prompt")
                            .build()
                    )
                    .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                    .turnDetection(
                        RealtimeTranscriptionSessionTurnDetection.builder()
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
                    RealtimeTranscriptionSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeTranscriptionSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionInputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionInputAudioTranscription.Model
                                        .WHISPER_1
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                        .turnDetection(
                            RealtimeTranscriptionSessionTurnDetection.builder()
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
