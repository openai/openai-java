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
                    RealtimeAudioConfig.Input.builder()
                        .format(RealtimeAudioConfig.Input.Format.PCM16)
                        .noiseReduction(
                            RealtimeAudioConfig.Input.NoiseReduction.builder()
                                .type(RealtimeAudioConfig.Input.NoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .transcription(
                            RealtimeAudioConfig.Input.Transcription.builder()
                                .language("language")
                                .model(RealtimeAudioConfig.Input.Transcription.Model.WHISPER_1)
                                .prompt("prompt")
                                .build()
                        )
                        .turnDetection(
                            RealtimeAudioConfig.Input.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(RealtimeAudioConfig.Input.TurnDetection.Eagerness.LOW)
                                .idleTimeoutMs(0L)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(RealtimeAudioConfig.Input.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .build()
                )
                .output(
                    RealtimeAudioConfig.Output.builder()
                        .format(RealtimeAudioConfig.Output.Format.PCM16)
                        .speed(0.25)
                        .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                        .build()
                )
                .build()

        assertThat(realtimeAudioConfig.input())
            .contains(
                RealtimeAudioConfig.Input.builder()
                    .format(RealtimeAudioConfig.Input.Format.PCM16)
                    .noiseReduction(
                        RealtimeAudioConfig.Input.NoiseReduction.builder()
                            .type(RealtimeAudioConfig.Input.NoiseReduction.Type.NEAR_FIELD)
                            .build()
                    )
                    .transcription(
                        RealtimeAudioConfig.Input.Transcription.builder()
                            .language("language")
                            .model(RealtimeAudioConfig.Input.Transcription.Model.WHISPER_1)
                            .prompt("prompt")
                            .build()
                    )
                    .turnDetection(
                        RealtimeAudioConfig.Input.TurnDetection.builder()
                            .createResponse(true)
                            .eagerness(RealtimeAudioConfig.Input.TurnDetection.Eagerness.LOW)
                            .idleTimeoutMs(0L)
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(RealtimeAudioConfig.Input.TurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeAudioConfig.output())
            .contains(
                RealtimeAudioConfig.Output.builder()
                    .format(RealtimeAudioConfig.Output.Format.PCM16)
                    .speed(0.25)
                    .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioConfig =
            RealtimeAudioConfig.builder()
                .input(
                    RealtimeAudioConfig.Input.builder()
                        .format(RealtimeAudioConfig.Input.Format.PCM16)
                        .noiseReduction(
                            RealtimeAudioConfig.Input.NoiseReduction.builder()
                                .type(RealtimeAudioConfig.Input.NoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .transcription(
                            RealtimeAudioConfig.Input.Transcription.builder()
                                .language("language")
                                .model(RealtimeAudioConfig.Input.Transcription.Model.WHISPER_1)
                                .prompt("prompt")
                                .build()
                        )
                        .turnDetection(
                            RealtimeAudioConfig.Input.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(RealtimeAudioConfig.Input.TurnDetection.Eagerness.LOW)
                                .idleTimeoutMs(0L)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(RealtimeAudioConfig.Input.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .build()
                )
                .output(
                    RealtimeAudioConfig.Output.builder()
                        .format(RealtimeAudioConfig.Output.Format.PCM16)
                        .speed(0.25)
                        .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
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
