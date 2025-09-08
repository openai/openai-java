// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionCreateResponseTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionCreateResponse =
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
                        .model(RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1)
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

        assertThat(realtimeTranscriptionSessionCreateResponse.clientSecret())
            .isEqualTo(
                RealtimeTranscriptionSessionClientSecret.builder()
                    .expiresAt(0L)
                    .value("value")
                    .build()
            )
        assertThat(realtimeTranscriptionSessionCreateResponse.inputAudioFormat())
            .contains("input_audio_format")
        assertThat(realtimeTranscriptionSessionCreateResponse.inputAudioTranscription())
            .contains(
                RealtimeTranscriptionSessionInputAudioTranscription.builder()
                    .language("language")
                    .model(RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1)
                    .prompt("prompt")
                    .build()
            )
        assertThat(realtimeTranscriptionSessionCreateResponse.modalities().getOrNull())
            .containsExactly(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
        assertThat(realtimeTranscriptionSessionCreateResponse.turnDetection())
            .contains(
                RealtimeTranscriptionSessionTurnDetection.builder()
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type("type")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionCreateResponse =
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
                        .model(RealtimeTranscriptionSessionInputAudioTranscription.Model.WHISPER_1)
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

        val roundtrippedRealtimeTranscriptionSessionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionCreateResponse),
                jacksonTypeRef<RealtimeTranscriptionSessionCreateResponse>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionCreateResponse)
            .isEqualTo(realtimeTranscriptionSessionCreateResponse)
    }
}
