// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeAudioConfigInputTest {

    @Test
    fun create() {
        val realtimeAudioConfigInput =
            RealtimeAudioConfigInput.builder()
                .format(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
                .noiseReduction(
                    RealtimeAudioConfigInput.NoiseReduction.builder()
                        .type(NoiseReductionType.NEAR_FIELD)
                        .build()
                )
                .transcription(
                    AudioTranscription.builder()
                        .language("language")
                        .model(AudioTranscription.Model.WHISPER_1)
                        .prompt("prompt")
                        .build()
                )
                .turnDetection(
                    RealtimeAudioInputTurnDetection.ServerVad.builder()
                        .createResponse(true)
                        .idleTimeoutMs(5000L)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .build()
                )
                .build()

        assertThat(realtimeAudioConfigInput.format())
            .contains(
                RealtimeAudioFormats.ofAudioPcm(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
            )
        assertThat(realtimeAudioConfigInput.noiseReduction())
            .contains(
                RealtimeAudioConfigInput.NoiseReduction.builder()
                    .type(NoiseReductionType.NEAR_FIELD)
                    .build()
            )
        assertThat(realtimeAudioConfigInput.transcription())
            .contains(
                AudioTranscription.builder()
                    .language("language")
                    .model(AudioTranscription.Model.WHISPER_1)
                    .prompt("prompt")
                    .build()
            )
        assertThat(realtimeAudioConfigInput.turnDetection())
            .contains(
                RealtimeAudioInputTurnDetection.ofServerVad(
                    RealtimeAudioInputTurnDetection.ServerVad.builder()
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
        val realtimeAudioConfigInput =
            RealtimeAudioConfigInput.builder()
                .format(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
                .noiseReduction(
                    RealtimeAudioConfigInput.NoiseReduction.builder()
                        .type(NoiseReductionType.NEAR_FIELD)
                        .build()
                )
                .transcription(
                    AudioTranscription.builder()
                        .language("language")
                        .model(AudioTranscription.Model.WHISPER_1)
                        .prompt("prompt")
                        .build()
                )
                .turnDetection(
                    RealtimeAudioInputTurnDetection.ServerVad.builder()
                        .createResponse(true)
                        .idleTimeoutMs(5000L)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .build()
                )
                .build()

        val roundtrippedRealtimeAudioConfigInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioConfigInput),
                jacksonTypeRef<RealtimeAudioConfigInput>(),
            )

        assertThat(roundtrippedRealtimeAudioConfigInput).isEqualTo(realtimeAudioConfigInput)
    }
}
