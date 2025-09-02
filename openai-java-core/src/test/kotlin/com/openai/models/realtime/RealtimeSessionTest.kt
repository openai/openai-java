// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsePrompt
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeSessionTest {

    @Test
    fun create() {
        val realtimeSession =
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

        assertThat(realtimeSession.id()).contains("id")
        assertThat(realtimeSession.expiresAt()).contains(0L)
        assertThat(realtimeSession.include().getOrNull())
            .containsExactly(RealtimeSession.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS)
        assertThat(realtimeSession.inputAudioFormat())
            .contains(RealtimeSession.InputAudioFormat.PCM16)
        assertThat(realtimeSession.inputAudioNoiseReduction())
            .contains(
                RealtimeSession.InputAudioNoiseReduction.builder()
                    .type(RealtimeSession.InputAudioNoiseReduction.Type.NEAR_FIELD)
                    .build()
            )
        assertThat(realtimeSession.inputAudioTranscription())
            .contains(
                RealtimeSession.InputAudioTranscription.builder()
                    .language("language")
                    .model("model")
                    .prompt("prompt")
                    .build()
            )
        assertThat(realtimeSession.instructions()).contains("instructions")
        assertThat(realtimeSession.maxResponseOutputTokens())
            .contains(RealtimeSession.MaxResponseOutputTokens.ofInteger(0L))
        assertThat(realtimeSession.modalities().getOrNull())
            .containsExactly(RealtimeSession.Modality.TEXT)
        assertThat(realtimeSession.model()).contains(RealtimeSession.Model.GPT_4O_REALTIME_PREVIEW)
        assertThat(realtimeSession.object_()).contains(RealtimeSession.Object.REALTIME_SESSION)
        assertThat(realtimeSession.outputAudioFormat())
            .contains(RealtimeSession.OutputAudioFormat.PCM16)
        assertThat(realtimeSession.prompt())
            .contains(
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
        assertThat(realtimeSession.speed()).contains(0.25)
        assertThat(realtimeSession.temperature()).contains(0.0)
        assertThat(realtimeSession.toolChoice()).contains("tool_choice")
        assertThat(realtimeSession.tools().getOrNull())
            .containsExactly(
                RealtimeSession.Tool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(RealtimeSession.Tool.Type.FUNCTION)
                    .build()
            )
        assertThat(realtimeSession.tracing()).contains(RealtimeSession.Tracing.ofAuto())
        assertThat(realtimeSession.turnDetection())
            .contains(
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
        assertThat(realtimeSession.voice()).contains(RealtimeSession.Voice.ALLOY)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeSession =
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

        val roundtrippedRealtimeSession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeSession),
                jacksonTypeRef<RealtimeSession>(),
            )

        assertThat(roundtrippedRealtimeSession).isEqualTo(realtimeSession)
    }
}
