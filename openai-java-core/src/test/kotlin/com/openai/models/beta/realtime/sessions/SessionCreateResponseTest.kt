// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.sessions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCreateResponseTest {

    @Test
    fun create() {
        val sessionCreateResponse =
            SessionCreateResponse.builder()
                .clientSecret(
                    SessionCreateResponse.ClientSecret.builder()
                        .expiresAt(0L)
                        .value("value")
                        .build()
                )
                .inputAudioFormat("input_audio_format")
                .inputAudioTranscription(
                    SessionCreateResponse.InputAudioTranscription.builder().model("model").build()
                )
                .instructions("instructions")
                .maxResponseOutputTokens(0L)
                .addModality(SessionCreateResponse.Modality.TEXT)
                .outputAudioFormat("output_audio_format")
                .speed(0.25)
                .temperature(0.0)
                .toolChoice("tool_choice")
                .addTool(
                    SessionCreateResponse.Tool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(SessionCreateResponse.Tool.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .turnDetection(
                    SessionCreateResponse.TurnDetection.builder()
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type("type")
                        .build()
                )
                .voice(SessionCreateResponse.Voice.ALLOY)
                .build()

        assertThat(sessionCreateResponse.clientSecret())
            .isEqualTo(
                SessionCreateResponse.ClientSecret.builder().expiresAt(0L).value("value").build()
            )
        assertThat(sessionCreateResponse.inputAudioFormat()).contains("input_audio_format")
        assertThat(sessionCreateResponse.inputAudioTranscription())
            .contains(
                SessionCreateResponse.InputAudioTranscription.builder().model("model").build()
            )
        assertThat(sessionCreateResponse.instructions()).contains("instructions")
        assertThat(sessionCreateResponse.maxResponseOutputTokens())
            .contains(SessionCreateResponse.MaxResponseOutputTokens.ofInteger(0L))
        assertThat(sessionCreateResponse.modalities().getOrNull())
            .containsExactly(SessionCreateResponse.Modality.TEXT)
        assertThat(sessionCreateResponse.outputAudioFormat()).contains("output_audio_format")
        assertThat(sessionCreateResponse.speed()).contains(0.25)
        assertThat(sessionCreateResponse.temperature()).contains(0.0)
        assertThat(sessionCreateResponse.toolChoice()).contains("tool_choice")
        assertThat(sessionCreateResponse.tools().getOrNull())
            .containsExactly(
                SessionCreateResponse.Tool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(SessionCreateResponse.Tool.Type.FUNCTION)
                    .build()
            )
        assertThat(sessionCreateResponse.tracing()).contains(SessionCreateResponse.Tracing.ofAuto())
        assertThat(sessionCreateResponse.turnDetection())
            .contains(
                SessionCreateResponse.TurnDetection.builder()
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type("type")
                    .build()
            )
        assertThat(sessionCreateResponse.voice()).contains(SessionCreateResponse.Voice.ALLOY)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionCreateResponse =
            SessionCreateResponse.builder()
                .clientSecret(
                    SessionCreateResponse.ClientSecret.builder()
                        .expiresAt(0L)
                        .value("value")
                        .build()
                )
                .inputAudioFormat("input_audio_format")
                .inputAudioTranscription(
                    SessionCreateResponse.InputAudioTranscription.builder().model("model").build()
                )
                .instructions("instructions")
                .maxResponseOutputTokens(0L)
                .addModality(SessionCreateResponse.Modality.TEXT)
                .outputAudioFormat("output_audio_format")
                .speed(0.25)
                .temperature(0.0)
                .toolChoice("tool_choice")
                .addTool(
                    SessionCreateResponse.Tool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(SessionCreateResponse.Tool.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .turnDetection(
                    SessionCreateResponse.TurnDetection.builder()
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type("type")
                        .build()
                )
                .voice(SessionCreateResponse.Voice.ALLOY)
                .build()

        val roundtrippedSessionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionCreateResponse),
                jacksonTypeRef<SessionCreateResponse>(),
            )

        assertThat(roundtrippedSessionCreateResponse).isEqualTo(sessionCreateResponse)
    }
}
