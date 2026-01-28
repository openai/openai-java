// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioFormats
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTranscriptionSessionCreateResponseTest {

    @Test
    fun create() {
        val realtimeTranscriptionSessionCreateResponse =
            RealtimeTranscriptionSessionCreateResponse.builder()
                .id("id")
                .object_("object")
                .audio(
                    RealtimeTranscriptionSessionCreateResponse.Audio.builder()
                        .input(
                            RealtimeTranscriptionSessionCreateResponse.Audio.Input.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .noiseReduction(
                                    RealtimeTranscriptionSessionCreateResponse.Audio.Input
                                        .NoiseReduction
                                        .builder()
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
                )
                .expiresAt(0L)
                .addInclude(
                    RealtimeTranscriptionSessionCreateResponse.Include
                        .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .build()

        assertThat(realtimeTranscriptionSessionCreateResponse.id()).isEqualTo("id")
        assertThat(realtimeTranscriptionSessionCreateResponse.object_()).isEqualTo("object")
        assertThat(realtimeTranscriptionSessionCreateResponse.audio())
            .contains(
                RealtimeTranscriptionSessionCreateResponse.Audio.builder()
                    .input(
                        RealtimeTranscriptionSessionCreateResponse.Audio.Input.builder()
                            .format(
                                RealtimeAudioFormats.AudioPcm.builder()
                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                    .build()
                            )
                            .noiseReduction(
                                RealtimeTranscriptionSessionCreateResponse.Audio.Input
                                    .NoiseReduction
                                    .builder()
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
            )
        assertThat(realtimeTranscriptionSessionCreateResponse.expiresAt()).contains(0L)
        assertThat(realtimeTranscriptionSessionCreateResponse.include().getOrNull())
            .containsExactly(
                RealtimeTranscriptionSessionCreateResponse.Include
                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionCreateResponse =
            RealtimeTranscriptionSessionCreateResponse.builder()
                .id("id")
                .object_("object")
                .audio(
                    RealtimeTranscriptionSessionCreateResponse.Audio.builder()
                        .input(
                            RealtimeTranscriptionSessionCreateResponse.Audio.Input.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .noiseReduction(
                                    RealtimeTranscriptionSessionCreateResponse.Audio.Input
                                        .NoiseReduction
                                        .builder()
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
                )
                .expiresAt(0L)
                .addInclude(
                    RealtimeTranscriptionSessionCreateResponse.Include
                        .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
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
