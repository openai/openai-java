// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.sessions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionTest {

    @Test
    fun create() {
        val session =
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

        assertThat(session.id()).contains("id")
        assertThat(session.inputAudioFormat()).contains(Session.InputAudioFormat.PCM16)
        assertThat(session.inputAudioNoiseReduction())
            .contains(
                Session.InputAudioNoiseReduction.builder()
                    .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                    .build()
            )
        assertThat(session.inputAudioTranscription())
            .contains(
                Session.InputAudioTranscription.builder()
                    .language("language")
                    .model("model")
                    .prompt("prompt")
                    .build()
            )
        assertThat(session.instructions()).contains("instructions")
        assertThat(session.maxResponseOutputTokens())
            .contains(Session.MaxResponseOutputTokens.ofInteger(0L))
        assertThat(session.modalities().getOrNull()).containsExactly(Session.Modality.TEXT)
        assertThat(session.model()).contains(Session.Model.GPT_4O_REALTIME_PREVIEW)
        assertThat(session.outputAudioFormat()).contains(Session.OutputAudioFormat.PCM16)
        assertThat(session.speed()).contains(0.25)
        assertThat(session.temperature()).contains(0.0)
        assertThat(session.toolChoice()).contains("tool_choice")
        assertThat(session.tools().getOrNull())
            .containsExactly(
                Session.Tool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(Session.Tool.Type.FUNCTION)
                    .build()
            )
        assertThat(session.tracing()).contains(Session.Tracing.ofAuto())
        assertThat(session.turnDetection())
            .contains(
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
        assertThat(session.voice()).contains(Session.Voice.ALLOY)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val session =
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

        val roundtrippedSession =
            jsonMapper.readValue(jsonMapper.writeValueAsString(session), jacksonTypeRef<Session>())

        assertThat(roundtrippedSession).isEqualTo(session)
    }
}
