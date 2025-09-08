// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeAudioConfigTest {

    @Test
    fun create() {
        val realtimeAudioConfig =
            RealtimeAudioConfig.builder()
                .input(
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
                            RealtimeAudioInputTurnDetection.builder()
                                .createResponse(true)
                                .eagerness(RealtimeAudioInputTurnDetection.Eagerness.LOW)
                                .idleTimeoutMs(0L)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(RealtimeAudioInputTurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .build()
                )
                .output(
                    RealtimeAudioConfigOutput.builder()
                        .format(
                            RealtimeAudioFormats.AudioPcm.builder()
                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                .build()
                        )
                        .speed(0.25)
                        .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                        .build()
                )
                .build()

        assertThat(realtimeAudioConfig.input())
            .contains(
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
                        RealtimeAudioInputTurnDetection.builder()
                            .createResponse(true)
                            .eagerness(RealtimeAudioInputTurnDetection.Eagerness.LOW)
                            .idleTimeoutMs(0L)
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(RealtimeAudioInputTurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeAudioConfig.output())
            .contains(
                RealtimeAudioConfigOutput.builder()
                    .format(
                        RealtimeAudioFormats.AudioPcm.builder()
                            .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                            .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                            .build()
                    )
                    .speed(0.25)
                    .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioConfig =
            RealtimeAudioConfig.builder()
                .input(
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
                            RealtimeAudioInputTurnDetection.builder()
                                .createResponse(true)
                                .eagerness(RealtimeAudioInputTurnDetection.Eagerness.LOW)
                                .idleTimeoutMs(0L)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(RealtimeAudioInputTurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .build()
                )
                .output(
                    RealtimeAudioConfigOutput.builder()
                        .format(
                            RealtimeAudioFormats.AudioPcm.builder()
                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                .build()
                        )
                        .speed(0.25)
                        .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                        .build()
                )
                .build()

        val roundtrippedRealtimeAudioConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioConfig),
                jacksonTypeRef<RealtimeAudioConfig>(),
            )

        assertThat(roundtrippedRealtimeAudioConfig).isEqualTo(realtimeAudioConfig)
    }
}
