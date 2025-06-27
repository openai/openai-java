// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.transcriptionsessions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionTest {

    @Test
    fun create() {
        val transcriptionSession =
            TranscriptionSession.builder()
                .clientSecret(
                    TranscriptionSession.ClientSecret.builder().expiresAt(0L).value("value").build()
                )
                .inputAudioFormat("input_audio_format")
                .inputAudioTranscription(
                    TranscriptionSession.InputAudioTranscription.builder()
                        .language("language")
                        .model(TranscriptionSession.InputAudioTranscription.Model.GPT_4O_TRANSCRIBE)
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

        assertThat(transcriptionSession.clientSecret())
            .isEqualTo(
                TranscriptionSession.ClientSecret.builder().expiresAt(0L).value("value").build()
            )
        assertThat(transcriptionSession.inputAudioFormat()).contains("input_audio_format")
        assertThat(transcriptionSession.inputAudioTranscription())
            .contains(
                TranscriptionSession.InputAudioTranscription.builder()
                    .language("language")
                    .model(TranscriptionSession.InputAudioTranscription.Model.GPT_4O_TRANSCRIBE)
                    .prompt("prompt")
                    .build()
            )
        assertThat(transcriptionSession.modalities().getOrNull())
            .containsExactly(TranscriptionSession.Modality.TEXT)
        assertThat(transcriptionSession.turnDetection())
            .contains(
                TranscriptionSession.TurnDetection.builder()
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
        val transcriptionSession =
            TranscriptionSession.builder()
                .clientSecret(
                    TranscriptionSession.ClientSecret.builder().expiresAt(0L).value("value").build()
                )
                .inputAudioFormat("input_audio_format")
                .inputAudioTranscription(
                    TranscriptionSession.InputAudioTranscription.builder()
                        .language("language")
                        .model(TranscriptionSession.InputAudioTranscription.Model.GPT_4O_TRANSCRIBE)
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

        val roundtrippedTranscriptionSession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSession),
                jacksonTypeRef<TranscriptionSession>(),
            )

        assertThat(roundtrippedTranscriptionSession).isEqualTo(transcriptionSession)
    }
}
