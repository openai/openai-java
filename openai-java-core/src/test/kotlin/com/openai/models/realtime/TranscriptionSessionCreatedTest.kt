// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionCreatedTest {

    @Test
    fun create() {
        val transcriptionSessionCreated =
            TranscriptionSessionCreated.builder()
                .eventId("event_id")
                .session(
                    TranscriptionSessionCreated.Session.builder()
                        .id("id")
                        .audio(
                            TranscriptionSessionCreated.Session.Audio.builder()
                                .input(
                                    TranscriptionSessionCreated.Session.Audio.Input.builder()
                                        .format("format")
                                        .noiseReduction(
                                            TranscriptionSessionCreated.Session.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(
                                                    TranscriptionSessionCreated.Session.Audio.Input
                                                        .NoiseReduction
                                                        .Type
                                                        .NEAR_FIELD
                                                )
                                                .build()
                                        )
                                        .transcription(
                                            TranscriptionSessionCreated.Session.Audio.Input
                                                .Transcription
                                                .builder()
                                                .language("language")
                                                .model(
                                                    TranscriptionSessionCreated.Session.Audio.Input
                                                        .Transcription
                                                        .Model
                                                        .GPT_4O_TRANSCRIBE
                                                )
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            TranscriptionSessionCreated.Session.Audio.Input
                                                .TurnDetection
                                                .builder()
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
                            TranscriptionSessionCreated.Session.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .object_("object")
                        .build()
                )
                .build()

        assertThat(transcriptionSessionCreated.eventId()).isEqualTo("event_id")
        assertThat(transcriptionSessionCreated.session())
            .isEqualTo(
                TranscriptionSessionCreated.Session.builder()
                    .id("id")
                    .audio(
                        TranscriptionSessionCreated.Session.Audio.builder()
                            .input(
                                TranscriptionSessionCreated.Session.Audio.Input.builder()
                                    .format("format")
                                    .noiseReduction(
                                        TranscriptionSessionCreated.Session.Audio.Input
                                            .NoiseReduction
                                            .builder()
                                            .type(
                                                TranscriptionSessionCreated.Session.Audio.Input
                                                    .NoiseReduction
                                                    .Type
                                                    .NEAR_FIELD
                                            )
                                            .build()
                                    )
                                    .transcription(
                                        TranscriptionSessionCreated.Session.Audio.Input
                                            .Transcription
                                            .builder()
                                            .language("language")
                                            .model(
                                                TranscriptionSessionCreated.Session.Audio.Input
                                                    .Transcription
                                                    .Model
                                                    .GPT_4O_TRANSCRIBE
                                            )
                                            .prompt("prompt")
                                            .build()
                                    )
                                    .turnDetection(
                                        TranscriptionSessionCreated.Session.Audio.Input
                                            .TurnDetection
                                            .builder()
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
                        TranscriptionSessionCreated.Session.Include
                            .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    )
                    .object_("object")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionSessionCreated =
            TranscriptionSessionCreated.builder()
                .eventId("event_id")
                .session(
                    TranscriptionSessionCreated.Session.builder()
                        .id("id")
                        .audio(
                            TranscriptionSessionCreated.Session.Audio.builder()
                                .input(
                                    TranscriptionSessionCreated.Session.Audio.Input.builder()
                                        .format("format")
                                        .noiseReduction(
                                            TranscriptionSessionCreated.Session.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(
                                                    TranscriptionSessionCreated.Session.Audio.Input
                                                        .NoiseReduction
                                                        .Type
                                                        .NEAR_FIELD
                                                )
                                                .build()
                                        )
                                        .transcription(
                                            TranscriptionSessionCreated.Session.Audio.Input
                                                .Transcription
                                                .builder()
                                                .language("language")
                                                .model(
                                                    TranscriptionSessionCreated.Session.Audio.Input
                                                        .Transcription
                                                        .Model
                                                        .GPT_4O_TRANSCRIBE
                                                )
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            TranscriptionSessionCreated.Session.Audio.Input
                                                .TurnDetection
                                                .builder()
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
                            TranscriptionSessionCreated.Session.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .object_("object")
                        .build()
                )
                .build()

        val roundtrippedTranscriptionSessionCreated =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSessionCreated),
                jacksonTypeRef<TranscriptionSessionCreated>(),
            )

        assertThat(roundtrippedTranscriptionSessionCreated).isEqualTo(transcriptionSessionCreated)
    }
}
