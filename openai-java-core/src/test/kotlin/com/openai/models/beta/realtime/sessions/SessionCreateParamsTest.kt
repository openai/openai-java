// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.sessions

import com.openai.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCreateParamsTest {

    @Test
    fun create() {
        SessionCreateParams.builder()
            .clientSecret(
                SessionCreateParams.ClientSecret.builder()
                    .expiresAfter(
                        SessionCreateParams.ClientSecret.ExpiresAfter.builder()
                            .anchor(SessionCreateParams.ClientSecret.ExpiresAfter.Anchor.CREATED_AT)
                            .seconds(0L)
                            .build()
                    )
                    .build()
            )
            .inputAudioFormat(SessionCreateParams.InputAudioFormat.PCM16)
            .inputAudioNoiseReduction(
                SessionCreateParams.InputAudioNoiseReduction.builder()
                    .type(SessionCreateParams.InputAudioNoiseReduction.Type.NEAR_FIELD)
                    .build()
            )
            .inputAudioTranscription(
                SessionCreateParams.InputAudioTranscription.builder()
                    .language("language")
                    .model("model")
                    .prompt("prompt")
                    .build()
            )
            .instructions("instructions")
            .maxResponseOutputTokens(0L)
            .addModality(SessionCreateParams.Modality.TEXT)
            .model(SessionCreateParams.Model.GPT_4O_REALTIME_PREVIEW)
            .outputAudioFormat(SessionCreateParams.OutputAudioFormat.PCM16)
            .speed(0.25)
            .temperature(0.0)
            .toolChoice("tool_choice")
            .addTool(
                SessionCreateParams.Tool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(SessionCreateParams.Tool.Type.FUNCTION)
                    .build()
            )
            .tracingAuto()
            .turnDetection(
                SessionCreateParams.TurnDetection.builder()
                    .createResponse(true)
                    .eagerness(SessionCreateParams.TurnDetection.Eagerness.LOW)
                    .interruptResponse(true)
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type(SessionCreateParams.TurnDetection.Type.SERVER_VAD)
                    .build()
            )
            .voice(SessionCreateParams.Voice.ALLOY)
            .build()
    }

    @Test
    fun body() {
        val params =
            SessionCreateParams.builder()
                .clientSecret(
                    SessionCreateParams.ClientSecret.builder()
                        .expiresAfter(
                            SessionCreateParams.ClientSecret.ExpiresAfter.builder()
                                .anchor(
                                    SessionCreateParams.ClientSecret.ExpiresAfter.Anchor.CREATED_AT
                                )
                                .seconds(0L)
                                .build()
                        )
                        .build()
                )
                .inputAudioFormat(SessionCreateParams.InputAudioFormat.PCM16)
                .inputAudioNoiseReduction(
                    SessionCreateParams.InputAudioNoiseReduction.builder()
                        .type(SessionCreateParams.InputAudioNoiseReduction.Type.NEAR_FIELD)
                        .build()
                )
                .inputAudioTranscription(
                    SessionCreateParams.InputAudioTranscription.builder()
                        .language("language")
                        .model("model")
                        .prompt("prompt")
                        .build()
                )
                .instructions("instructions")
                .maxResponseOutputTokens(0L)
                .addModality(SessionCreateParams.Modality.TEXT)
                .model(SessionCreateParams.Model.GPT_4O_REALTIME_PREVIEW)
                .outputAudioFormat(SessionCreateParams.OutputAudioFormat.PCM16)
                .speed(0.25)
                .temperature(0.0)
                .toolChoice("tool_choice")
                .addTool(
                    SessionCreateParams.Tool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(SessionCreateParams.Tool.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .turnDetection(
                    SessionCreateParams.TurnDetection.builder()
                        .createResponse(true)
                        .eagerness(SessionCreateParams.TurnDetection.Eagerness.LOW)
                        .interruptResponse(true)
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type(SessionCreateParams.TurnDetection.Type.SERVER_VAD)
                        .build()
                )
                .voice(SessionCreateParams.Voice.ALLOY)
                .build()

        val body = params._body()

        assertThat(body.clientSecret())
            .contains(
                SessionCreateParams.ClientSecret.builder()
                    .expiresAfter(
                        SessionCreateParams.ClientSecret.ExpiresAfter.builder()
                            .anchor(SessionCreateParams.ClientSecret.ExpiresAfter.Anchor.CREATED_AT)
                            .seconds(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(body.inputAudioFormat()).contains(SessionCreateParams.InputAudioFormat.PCM16)
        assertThat(body.inputAudioNoiseReduction())
            .contains(
                SessionCreateParams.InputAudioNoiseReduction.builder()
                    .type(SessionCreateParams.InputAudioNoiseReduction.Type.NEAR_FIELD)
                    .build()
            )
        assertThat(body.inputAudioTranscription())
            .contains(
                SessionCreateParams.InputAudioTranscription.builder()
                    .language("language")
                    .model("model")
                    .prompt("prompt")
                    .build()
            )
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxResponseOutputTokens())
            .contains(SessionCreateParams.MaxResponseOutputTokens.ofInteger(0L))
        assertThat(body.modalities().getOrNull()).containsExactly(SessionCreateParams.Modality.TEXT)
        assertThat(body.model()).contains(SessionCreateParams.Model.GPT_4O_REALTIME_PREVIEW)
        assertThat(body.outputAudioFormat()).contains(SessionCreateParams.OutputAudioFormat.PCM16)
        assertThat(body.speed()).contains(0.25)
        assertThat(body.temperature()).contains(0.0)
        assertThat(body.toolChoice()).contains("tool_choice")
        assertThat(body.tools().getOrNull())
            .containsExactly(
                SessionCreateParams.Tool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(SessionCreateParams.Tool.Type.FUNCTION)
                    .build()
            )
        assertThat(body.tracing()).contains(SessionCreateParams.Tracing.ofAuto())
        assertThat(body.turnDetection())
            .contains(
                SessionCreateParams.TurnDetection.builder()
                    .createResponse(true)
                    .eagerness(SessionCreateParams.TurnDetection.Eagerness.LOW)
                    .interruptResponse(true)
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type(SessionCreateParams.TurnDetection.Type.SERVER_VAD)
                    .build()
            )
        assertThat(body.voice()).contains(SessionCreateParams.Voice.ALLOY)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SessionCreateParams.builder().build()

        val body = params._body()
    }
}
