// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionAudioInputTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionAudioInput =
            RealtimeTranscriptionSessionAudioInput.builder()
                .format(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
                .noiseReduction(
                    RealtimeTranscriptionSessionAudioInput.NoiseReduction.builder()
                        .type(NoiseReductionType.NEAR_FIELD)
                        .build()
                )
                .transcription(
                    AudioTranscription.builder()
                        .language("language")
                        .model(AudioTranscription.Model.of("string"))
                        .prompt("prompt")
                        .build()
                )
                .turnDetection(
                    RealtimeTranscriptionSessionAudioInputTurnDetection.ServerVad.builder()
                        .createResponse(true)
                        .idleTimeoutMs(5000L)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .build()
                )
                .build()

        assertThat(realtimeTranscriptionSessionAudioInput.format())
            .contains(
                RealtimeAudioFormats.ofAudioPcm(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
            )
        assertThat(realtimeTranscriptionSessionAudioInput.noiseReduction())
            .contains(
                RealtimeTranscriptionSessionAudioInput.NoiseReduction.builder()
                    .type(NoiseReductionType.NEAR_FIELD)
                    .build()
            )
        assertThat(realtimeTranscriptionSessionAudioInput.transcription())
            .contains(
                AudioTranscription.builder()
                    .language("language")
                    .model(AudioTranscription.Model.of("string"))
                    .prompt("prompt")
                    .build()
            )
        assertThat(realtimeTranscriptionSessionAudioInput.turnDetection())
            .contains(
                RealtimeTranscriptionSessionAudioInputTurnDetection.ofServerVad(
                    RealtimeTranscriptionSessionAudioInputTurnDetection.ServerVad.builder()
                        .createResponse(true)
                        .idleTimeoutMs(5000L)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionAudioInput =
            RealtimeTranscriptionSessionAudioInput.builder()
                .format(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
                .noiseReduction(
                    RealtimeTranscriptionSessionAudioInput.NoiseReduction.builder()
                        .type(NoiseReductionType.NEAR_FIELD)
                        .build()
                )
                .transcription(
                    AudioTranscription.builder()
                        .language("language")
                        .model(AudioTranscription.Model.of("string"))
                        .prompt("prompt")
                        .build()
                )
                .turnDetection(
                    RealtimeTranscriptionSessionAudioInputTurnDetection.ServerVad.builder()
                        .createResponse(true)
                        .idleTimeoutMs(5000L)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .build()
                )
                .build()

        val roundtrippedRealtimeTranscriptionSessionAudioInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionAudioInput),
                jacksonTypeRef<RealtimeTranscriptionSessionAudioInput>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionAudioInput)
            .isEqualTo(realtimeTranscriptionSessionAudioInput)
    }
}
