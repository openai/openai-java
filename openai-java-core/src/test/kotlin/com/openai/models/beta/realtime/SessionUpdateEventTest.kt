// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdateEventTest {

    @Test
    fun create() {
        val sessionUpdateEvent =
            SessionUpdateEvent.builder()
                .session(
                    SessionUpdateEvent.Session.builder()
                        .clientSecret(
                            SessionUpdateEvent.Session.ClientSecret.builder()
                                .expiresAfter(
                                    SessionUpdateEvent.Session.ClientSecret.ExpiresAfter.builder()
                                        .anchor(
                                            SessionUpdateEvent.Session.ClientSecret.ExpiresAfter
                                                .Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .inputAudioFormat(SessionUpdateEvent.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            SessionUpdateEvent.Session.InputAudioNoiseReduction.builder()
                                .type(
                                    SessionUpdateEvent.Session.InputAudioNoiseReduction.Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            SessionUpdateEvent.Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(SessionUpdateEvent.Session.Modality.TEXT)
                        .model(SessionUpdateEvent.Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(SessionUpdateEvent.Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            SessionUpdateEvent.Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(SessionUpdateEvent.Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            SessionUpdateEvent.Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(SessionUpdateEvent.Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(SessionUpdateEvent.Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(SessionUpdateEvent.Session.Voice.ALLOY)
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(sessionUpdateEvent.session())
            .isEqualTo(
                SessionUpdateEvent.Session.builder()
                    .clientSecret(
                        SessionUpdateEvent.Session.ClientSecret.builder()
                            .expiresAfter(
                                SessionUpdateEvent.Session.ClientSecret.ExpiresAfter.builder()
                                    .anchor(
                                        SessionUpdateEvent.Session.ClientSecret.ExpiresAfter.Anchor
                                            .CREATED_AT
                                    )
                                    .seconds(0L)
                                    .build()
                            )
                            .build()
                    )
                    .inputAudioFormat(SessionUpdateEvent.Session.InputAudioFormat.PCM16)
                    .inputAudioNoiseReduction(
                        SessionUpdateEvent.Session.InputAudioNoiseReduction.builder()
                            .type(
                                SessionUpdateEvent.Session.InputAudioNoiseReduction.Type.NEAR_FIELD
                            )
                            .build()
                    )
                    .inputAudioTranscription(
                        SessionUpdateEvent.Session.InputAudioTranscription.builder()
                            .language("language")
                            .model("model")
                            .prompt("prompt")
                            .build()
                    )
                    .instructions("instructions")
                    .maxResponseOutputTokens(0L)
                    .addModality(SessionUpdateEvent.Session.Modality.TEXT)
                    .model(SessionUpdateEvent.Session.Model.GPT_4O_REALTIME_PREVIEW)
                    .outputAudioFormat(SessionUpdateEvent.Session.OutputAudioFormat.PCM16)
                    .speed(0.25)
                    .temperature(0.0)
                    .toolChoice("tool_choice")
                    .addTool(
                        SessionUpdateEvent.Session.Tool.builder()
                            .description("description")
                            .name("name")
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .type(SessionUpdateEvent.Session.Tool.Type.FUNCTION)
                            .build()
                    )
                    .tracingAuto()
                    .turnDetection(
                        SessionUpdateEvent.Session.TurnDetection.builder()
                            .createResponse(true)
                            .eagerness(SessionUpdateEvent.Session.TurnDetection.Eagerness.LOW)
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(SessionUpdateEvent.Session.TurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .voice(SessionUpdateEvent.Session.Voice.ALLOY)
                    .build()
            )
        assertThat(sessionUpdateEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUpdateEvent =
            SessionUpdateEvent.builder()
                .session(
                    SessionUpdateEvent.Session.builder()
                        .clientSecret(
                            SessionUpdateEvent.Session.ClientSecret.builder()
                                .expiresAfter(
                                    SessionUpdateEvent.Session.ClientSecret.ExpiresAfter.builder()
                                        .anchor(
                                            SessionUpdateEvent.Session.ClientSecret.ExpiresAfter
                                                .Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .inputAudioFormat(SessionUpdateEvent.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            SessionUpdateEvent.Session.InputAudioNoiseReduction.builder()
                                .type(
                                    SessionUpdateEvent.Session.InputAudioNoiseReduction.Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            SessionUpdateEvent.Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(SessionUpdateEvent.Session.Modality.TEXT)
                        .model(SessionUpdateEvent.Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(SessionUpdateEvent.Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            SessionUpdateEvent.Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(SessionUpdateEvent.Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            SessionUpdateEvent.Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(SessionUpdateEvent.Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(SessionUpdateEvent.Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(SessionUpdateEvent.Session.Voice.ALLOY)
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedSessionUpdateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUpdateEvent),
                jacksonTypeRef<SessionUpdateEvent>(),
            )

        assertThat(roundtrippedSessionUpdateEvent).isEqualTo(sessionUpdateEvent)
    }
}
