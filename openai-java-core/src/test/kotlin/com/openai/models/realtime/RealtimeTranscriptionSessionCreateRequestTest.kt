// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionCreateRequestTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionCreateRequest =
            RealtimeTranscriptionSessionCreateRequest.builder()
                .audio(
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
                                    RealtimeTranscriptionSessionAudioInputTurnDetection.builder()
                                        .createResponse(true)
                                        .eagerness(
                                            RealtimeTranscriptionSessionAudioInputTurnDetection
                                                .Eagerness
                                                .LOW
                                        )
                                        .idleTimeoutMs(0L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type(
                                            RealtimeTranscriptionSessionAudioInputTurnDetection.Type
                                                .SERVER_VAD
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeTranscriptionSessionCreateRequest.Include
                        .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .build()

        assertThat(realtimeTranscriptionSessionCreateRequest.audio())
            .contains(
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
                                RealtimeTranscriptionSessionAudioInputTurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(
                                        RealtimeTranscriptionSessionAudioInputTurnDetection
                                            .Eagerness
                                            .LOW
                                    )
                                    .idleTimeoutMs(0L)
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(
                                        RealtimeTranscriptionSessionAudioInputTurnDetection.Type
                                            .SERVER_VAD
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeTranscriptionSessionCreateRequest.include().getOrNull())
            .containsExactly(
                RealtimeTranscriptionSessionCreateRequest.Include
                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionCreateRequest =
            RealtimeTranscriptionSessionCreateRequest.builder()
                .audio(
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
                                    RealtimeTranscriptionSessionAudioInputTurnDetection.builder()
                                        .createResponse(true)
                                        .eagerness(
                                            RealtimeTranscriptionSessionAudioInputTurnDetection
                                                .Eagerness
                                                .LOW
                                        )
                                        .idleTimeoutMs(0L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type(
                                            RealtimeTranscriptionSessionAudioInputTurnDetection.Type
                                                .SERVER_VAD
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeTranscriptionSessionCreateRequest.Include
                        .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .build()

        val roundtrippedRealtimeTranscriptionSessionCreateRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionCreateRequest),
                jacksonTypeRef<RealtimeTranscriptionSessionCreateRequest>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionCreateRequest)
            .isEqualTo(realtimeTranscriptionSessionCreateRequest)
    }
}
