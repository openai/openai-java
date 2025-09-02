// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionSessionUpdatedEventTest {

    @Test
    fun create() {
        val transcriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    TranscriptionSessionUpdatedEvent.Session.builder()
                        .id("id")
                        .audio(
                            TranscriptionSessionUpdatedEvent.Session.Audio.builder()
                                .input(
                                    TranscriptionSessionUpdatedEvent.Session.Audio.Input.builder()
                                        .format("format")
                                        .noiseReduction(
                                            TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(
                                                    TranscriptionSessionUpdatedEvent.Session.Audio
                                                        .Input
                                                        .NoiseReduction
                                                        .Type
                                                        .NEAR_FIELD
                                                )
                                                .build()
                                        )
                                        .transcription(
                                            TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                                .Transcription
                                                .builder()
                                                .language("language")
                                                .model(
                                                    TranscriptionSessionUpdatedEvent.Session.Audio
                                                        .Input
                                                        .Transcription
                                                        .Model
                                                        .GPT_4O_TRANSCRIBE
                                                )
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            TranscriptionSessionUpdatedEvent.Session.Audio.Input
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
                            TranscriptionSessionUpdatedEvent.Session.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .object_("object")
                        .build()
                )
                .build()

        assertThat(transcriptionSessionUpdatedEvent.eventId()).isEqualTo("event_id")
        assertThat(transcriptionSessionUpdatedEvent.session())
            .isEqualTo(
                TranscriptionSessionUpdatedEvent.Session.builder()
                    .id("id")
                    .audio(
                        TranscriptionSessionUpdatedEvent.Session.Audio.builder()
                            .input(
                                TranscriptionSessionUpdatedEvent.Session.Audio.Input.builder()
                                    .format("format")
                                    .noiseReduction(
                                        TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                            .NoiseReduction
                                            .builder()
                                            .type(
                                                TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                                    .NoiseReduction
                                                    .Type
                                                    .NEAR_FIELD
                                            )
                                            .build()
                                    )
                                    .transcription(
                                        TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                            .Transcription
                                            .builder()
                                            .language("language")
                                            .model(
                                                TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                                    .Transcription
                                                    .Model
                                                    .GPT_4O_TRANSCRIBE
                                            )
                                            .prompt("prompt")
                                            .build()
                                    )
                                    .turnDetection(
                                        TranscriptionSessionUpdatedEvent.Session.Audio.Input
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
                        TranscriptionSessionUpdatedEvent.Session.Include
                            .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    )
                    .object_("object")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    TranscriptionSessionUpdatedEvent.Session.builder()
                        .id("id")
                        .audio(
                            TranscriptionSessionUpdatedEvent.Session.Audio.builder()
                                .input(
                                    TranscriptionSessionUpdatedEvent.Session.Audio.Input.builder()
                                        .format("format")
                                        .noiseReduction(
                                            TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(
                                                    TranscriptionSessionUpdatedEvent.Session.Audio
                                                        .Input
                                                        .NoiseReduction
                                                        .Type
                                                        .NEAR_FIELD
                                                )
                                                .build()
                                        )
                                        .transcription(
                                            TranscriptionSessionUpdatedEvent.Session.Audio.Input
                                                .Transcription
                                                .builder()
                                                .language("language")
                                                .model(
                                                    TranscriptionSessionUpdatedEvent.Session.Audio
                                                        .Input
                                                        .Transcription
                                                        .Model
                                                        .GPT_4O_TRANSCRIBE
                                                )
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            TranscriptionSessionUpdatedEvent.Session.Audio.Input
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
                            TranscriptionSessionUpdatedEvent.Session.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .object_("object")
                        .build()
                )
                .build()

        val roundtrippedTranscriptionSessionUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionSessionUpdatedEvent),
                jacksonTypeRef<TranscriptionSessionUpdatedEvent>(),
            )

        assertThat(roundtrippedTranscriptionSessionUpdatedEvent)
            .isEqualTo(transcriptionSessionUpdatedEvent)
    }
}
