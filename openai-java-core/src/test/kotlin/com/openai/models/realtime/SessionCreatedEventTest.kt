// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsePrompt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCreatedEventTest {

    @Test
    fun create() {
        val sessionCreatedEvent =
            SessionCreatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeSession.builder()
                        .id("id")
                        .expiresAt(0L)
                        .addInclude(RealtimeSession.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS)
                        .inputAudioFormat(RealtimeSession.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            RealtimeSession.InputAudioNoiseReduction.builder()
                                .type(RealtimeSession.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            RealtimeSession.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(RealtimeSession.Modality.TEXT)
                        .model(RealtimeSession.Model.GPT_4O_REALTIME_PREVIEW)
                        .object_(RealtimeSession.Object.REALTIME_SESSION)
                        .outputAudioFormat(RealtimeSession.OutputAudioFormat.PCM16)
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            RealtimeSession.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(RealtimeSession.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            RealtimeSession.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(RealtimeSession.TurnDetection.Eagerness.LOW)
                                .idleTimeoutMs(0L)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(RealtimeSession.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(RealtimeSession.Voice.ALLOY)
                        .build()
                )
                .build()

        assertThat(sessionCreatedEvent.eventId()).isEqualTo("event_id")
        assertThat(sessionCreatedEvent.session())
            .isEqualTo(
                RealtimeSession.builder()
                    .id("id")
                    .expiresAt(0L)
                    .addInclude(RealtimeSession.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS)
                    .inputAudioFormat(RealtimeSession.InputAudioFormat.PCM16)
                    .inputAudioNoiseReduction(
                        RealtimeSession.InputAudioNoiseReduction.builder()
                            .type(RealtimeSession.InputAudioNoiseReduction.Type.NEAR_FIELD)
                            .build()
                    )
                    .inputAudioTranscription(
                        RealtimeSession.InputAudioTranscription.builder()
                            .language("language")
                            .model("model")
                            .prompt("prompt")
                            .build()
                    )
                    .instructions("instructions")
                    .maxResponseOutputTokens(0L)
                    .addModality(RealtimeSession.Modality.TEXT)
                    .model(RealtimeSession.Model.GPT_4O_REALTIME_PREVIEW)
                    .object_(RealtimeSession.Object.REALTIME_SESSION)
                    .outputAudioFormat(RealtimeSession.OutputAudioFormat.PCM16)
                    .prompt(
                        ResponsePrompt.builder()
                            .id("id")
                            .variables(
                                ResponsePrompt.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .version("version")
                            .build()
                    )
                    .speed(0.25)
                    .temperature(0.0)
                    .toolChoice("tool_choice")
                    .addTool(
                        RealtimeSession.Tool.builder()
                            .description("description")
                            .name("name")
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .type(RealtimeSession.Tool.Type.FUNCTION)
                            .build()
                    )
                    .tracingAuto()
                    .turnDetection(
                        RealtimeSession.TurnDetection.builder()
                            .createResponse(true)
                            .eagerness(RealtimeSession.TurnDetection.Eagerness.LOW)
                            .idleTimeoutMs(0L)
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(RealtimeSession.TurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .voice(RealtimeSession.Voice.ALLOY)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionCreatedEvent =
            SessionCreatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeSession.builder()
                        .id("id")
                        .expiresAt(0L)
                        .addInclude(RealtimeSession.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS)
                        .inputAudioFormat(RealtimeSession.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            RealtimeSession.InputAudioNoiseReduction.builder()
                                .type(RealtimeSession.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            RealtimeSession.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(RealtimeSession.Modality.TEXT)
                        .model(RealtimeSession.Model.GPT_4O_REALTIME_PREVIEW)
                        .object_(RealtimeSession.Object.REALTIME_SESSION)
                        .outputAudioFormat(RealtimeSession.OutputAudioFormat.PCM16)
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            RealtimeSession.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(RealtimeSession.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            RealtimeSession.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(RealtimeSession.TurnDetection.Eagerness.LOW)
                                .idleTimeoutMs(0L)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(RealtimeSession.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(RealtimeSession.Voice.ALLOY)
                        .build()
                )
                .build()

        val roundtrippedSessionCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionCreatedEvent),
                jacksonTypeRef<SessionCreatedEvent>(),
            )

        assertThat(roundtrippedSessionCreatedEvent).isEqualTo(sessionCreatedEvent)
    }
}
