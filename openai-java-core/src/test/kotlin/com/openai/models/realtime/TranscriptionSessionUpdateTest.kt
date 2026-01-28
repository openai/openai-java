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
                    TranscriptionSessionUpdate.Session.builder()
                        .addInclude(
                            TranscriptionSessionUpdate.Session.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                                .type(NoiseReductionType.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            AudioTranscription.builder()
                                .language("language")
                                .model(AudioTranscription.Model.WHISPER_1)
                                .prompt("prompt")
                                .build()
                        )
                        .turnDetection(
                            TranscriptionSessionUpdate.Session.TurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(transcriptionSessionUpdate.session())
            .isEqualTo(
                TranscriptionSessionUpdate.Session.builder()
                    .addInclude(
                        TranscriptionSessionUpdate.Session.Include
                            .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    )
                    .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                    .inputAudioNoiseReduction(
                        TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                            .type(NoiseReductionType.NEAR_FIELD)
                            .build()
                    )
                    .inputAudioTranscription(
                        AudioTranscription.builder()
                            .language("language")
                            .model(AudioTranscription.Model.WHISPER_1)
                            .prompt("prompt")
                            .build()
                    )
                    .turnDetection(
                        TranscriptionSessionUpdate.Session.TurnDetection.builder()
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD)
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
                    TranscriptionSessionUpdate.Session.builder()
                        .addInclude(
                            TranscriptionSessionUpdate.Session.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                                .type(NoiseReductionType.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            AudioTranscription.builder()
                                .language("language")
                                .model(AudioTranscription.Model.WHISPER_1)
                                .prompt("prompt")
                                .build()
                        )
                        .turnDetection(
                            TranscriptionSessionUpdate.Session.TurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD
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
