// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.realtime.sessions.Session
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdatedEventTest {

    @Test
    fun create() {
        val sessionUpdatedEvent =
            SessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    Session.builder()
                        .id("id")
                        .inputAudioFormat(Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            Session.InputAudioNoiseReduction.builder()
                                .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(Session.Modality.TEXT)
                        .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(Session.Voice.ALLOY)
                        .build()
                )
                .build()

        assertThat(sessionUpdatedEvent.eventId()).isEqualTo("event_id")
        assertThat(sessionUpdatedEvent.session())
            .isEqualTo(
                Session.builder()
                    .id("id")
                    .inputAudioFormat(Session.InputAudioFormat.PCM16)
                    .inputAudioNoiseReduction(
                        Session.InputAudioNoiseReduction.builder()
                            .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                            .build()
                    )
                    .inputAudioTranscription(
                        Session.InputAudioTranscription.builder()
                            .language("language")
                            .model("model")
                            .prompt("prompt")
                            .build()
                    )
                    .instructions("instructions")
                    .maxResponseOutputTokens(0L)
                    .addModality(Session.Modality.TEXT)
                    .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                    .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                    .speed(0.25)
                    .temperature(0.0)
                    .toolChoice("tool_choice")
                    .addTool(
                        Session.Tool.builder()
                            .description("description")
                            .name("name")
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .type(Session.Tool.Type.FUNCTION)
                            .build()
                    )
                    .tracingAuto()
                    .turnDetection(
                        Session.TurnDetection.builder()
                            .createResponse(true)
                            .eagerness(Session.TurnDetection.Eagerness.LOW)
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(Session.TurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .voice(Session.Voice.ALLOY)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUpdatedEvent =
            SessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    Session.builder()
                        .id("id")
                        .inputAudioFormat(Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            Session.InputAudioNoiseReduction.builder()
                                .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(Session.Modality.TEXT)
                        .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(Session.Voice.ALLOY)
                        .build()
                )
                .build()

        val roundtrippedSessionUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUpdatedEvent),
                jacksonTypeRef<SessionUpdatedEvent>(),
            )

        assertThat(roundtrippedSessionUpdatedEvent).isEqualTo(sessionUpdatedEvent)
    }
}
