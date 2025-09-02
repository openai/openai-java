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
                .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                .addInclude(
                    RealtimeTranscriptionSessionCreateRequest.Include
                        .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .inputAudioFormat(RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16)
                .inputAudioNoiseReduction(
                    RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.builder()
                        .type(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.Type
                                .NEAR_FIELD
                        )
                        .build()
                )
                .inputAudioTranscription(
                    RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.builder()
                        .language("language")
                        .model(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.Model
                                .GPT_4O_TRANSCRIBE
                        )
                        .prompt("prompt")
                        .build()
                )
                .turnDetection(
                    RealtimeTranscriptionSessionCreateRequest.TurnDetection.builder()
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type(
                            RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type.SERVER_VAD
                        )
                        .build()
                )
                .build()

        assertThat(realtimeTranscriptionSessionCreateRequest.model())
            .isEqualTo(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
        assertThat(realtimeTranscriptionSessionCreateRequest.include().getOrNull())
            .containsExactly(
                RealtimeTranscriptionSessionCreateRequest.Include
                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            )
        assertThat(realtimeTranscriptionSessionCreateRequest.inputAudioFormat())
            .contains(RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16)
        assertThat(realtimeTranscriptionSessionCreateRequest.inputAudioNoiseReduction())
            .contains(
                RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.builder()
                    .type(
                        RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.Type
                            .NEAR_FIELD
                    )
                    .build()
            )
        assertThat(realtimeTranscriptionSessionCreateRequest.inputAudioTranscription())
            .contains(
                RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.builder()
                    .language("language")
                    .model(
                        RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.Model
                            .GPT_4O_TRANSCRIBE
                    )
                    .prompt("prompt")
                    .build()
            )
        assertThat(realtimeTranscriptionSessionCreateRequest.turnDetection())
            .contains(
                RealtimeTranscriptionSessionCreateRequest.TurnDetection.builder()
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type(RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type.SERVER_VAD)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionCreateRequest =
            RealtimeTranscriptionSessionCreateRequest.builder()
                .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                .addInclude(
                    RealtimeTranscriptionSessionCreateRequest.Include
                        .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .inputAudioFormat(RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16)
                .inputAudioNoiseReduction(
                    RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.builder()
                        .type(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.Type
                                .NEAR_FIELD
                        )
                        .build()
                )
                .inputAudioTranscription(
                    RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.builder()
                        .language("language")
                        .model(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.Model
                                .GPT_4O_TRANSCRIBE
                        )
                        .prompt("prompt")
                        .build()
                )
                .turnDetection(
                    RealtimeTranscriptionSessionCreateRequest.TurnDetection.builder()
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type(
                            RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type.SERVER_VAD
                        )
                        .build()
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
