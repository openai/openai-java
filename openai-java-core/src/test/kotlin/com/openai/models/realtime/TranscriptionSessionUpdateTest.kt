// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionUpdateTest {

    @Test
    fun create() {
        val transcriptionSessionUpdate =
            TranscriptionSessionUpdate.builder()
                .session(
                    RealtimeTranscriptionSessionCreateRequest.builder()
                        .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                        .addInclude(
                            RealtimeTranscriptionSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .inputAudioFormat(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16
                        )
                        .inputAudioNoiseReduction(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction
                                .builder()
                                .type(
                                    RealtimeTranscriptionSessionCreateRequest
                                        .InputAudioNoiseReduction
                                        .Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription
                                .builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionCreateRequest
                                        .InputAudioTranscription
                                        .Model
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
                                    RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type
                                        .SERVER_VAD
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(transcriptionSessionUpdate.session())
            .isEqualTo(
                RealtimeTranscriptionSessionCreateRequest.builder()
                    .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                    .addInclude(
                        RealtimeTranscriptionSessionCreateRequest.Include
                            .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    )
                    .inputAudioFormat(
                        RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16
                    )
                    .inputAudioNoiseReduction(
                        RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction.builder()
                            .type(
                                RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction
                                    .Type
                                    .NEAR_FIELD
                            )
                            .build()
                    )
                    .inputAudioTranscription(
                        RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription.builder()
                            .language("language")
                            .model(
                                RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription
                                    .Model
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
                                RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type
                                    .SERVER_VAD
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(transcriptionSessionUpdate.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionSessionUpdate =
            TranscriptionSessionUpdate.builder()
                .session(
                    RealtimeTranscriptionSessionCreateRequest.builder()
                        .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                        .addInclude(
                            RealtimeTranscriptionSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .inputAudioFormat(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16
                        )
                        .inputAudioNoiseReduction(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction
                                .builder()
                                .type(
                                    RealtimeTranscriptionSessionCreateRequest
                                        .InputAudioNoiseReduction
                                        .Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription
                                .builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionCreateRequest
                                        .InputAudioTranscription
                                        .Model
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
                                    RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type
                                        .SERVER_VAD
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedTranscriptionSessionUpdate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSessionUpdate),
                jacksonTypeRef<TranscriptionSessionUpdate>(),
            )

        assertThat(roundtrippedTranscriptionSessionUpdate).isEqualTo(transcriptionSessionUpdate)
    }
}
