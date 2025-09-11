// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionAudioTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionAudio =
            RealtimeTranscriptionSessionAudio.builder()
                .input(
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
                                .model(AudioTranscription.Model.WHISPER_1)
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
                )
                .build()

        assertThat(realtimeTranscriptionSessionAudio.input())
            .contains(
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
                            .model(AudioTranscription.Model.WHISPER_1)
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionAudio =
            RealtimeTranscriptionSessionAudio.builder()
                .input(
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
                                .model(AudioTranscription.Model.WHISPER_1)
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
                )
                .build()

        val roundtrippedRealtimeTranscriptionSessionAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionAudio),
                jacksonTypeRef<RealtimeTranscriptionSessionAudio>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionAudio)
            .isEqualTo(realtimeTranscriptionSessionAudio)
    }
}
