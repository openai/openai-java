// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeSessionCreateResponseTest {

    @Test
    fun create() {
        val realtimeSessionCreateResponse =
            RealtimeSessionCreateResponse.builder()
                .id("id")
                .audio(
                    RealtimeSessionCreateResponse.Audio.builder()
                        .input(
                            RealtimeSessionCreateResponse.Audio.Input.builder()
                                .format("format")
                                .noiseReduction(
                                    RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                        .builder()
                                        .type(
                                            RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                                .Type
                                                .NEAR_FIELD
                                        )
                                        .build()
                                )
                                .transcription(
                                    RealtimeSessionCreateResponse.Audio.Input.Transcription
                                        .builder()
                                        .language("language")
                                        .model("model")
                                        .prompt("prompt")
                                        .build()
                                )
                                .turnDetection(
                                    RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                        .builder()
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type("type")
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeSessionCreateResponse.Audio.Output.builder()
                                .format("format")
                                .speed(0.0)
                                .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ALLOY)
                                .build()
                        )
                        .build()
                )
                .expiresAt(0L)
                .addInclude(
                    RealtimeSessionCreateResponse.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .model("model")
                .object_("object")
                .addOutputModality(RealtimeSessionCreateResponse.OutputModality.TEXT)
                .toolChoice("tool_choice")
                .addTool(
                    RealtimeSessionCreateResponse.Tool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeSessionCreateResponse.Tool.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .turnDetection(
                    RealtimeSessionCreateResponse.TurnDetection.builder()
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type("type")
                        .build()
                )
                .build()

        assertThat(realtimeSessionCreateResponse.id()).contains("id")
        assertThat(realtimeSessionCreateResponse.audio())
            .contains(
                RealtimeSessionCreateResponse.Audio.builder()
                    .input(
                        RealtimeSessionCreateResponse.Audio.Input.builder()
                            .format("format")
                            .noiseReduction(
                                RealtimeSessionCreateResponse.Audio.Input.NoiseReduction.builder()
                                    .type(
                                        RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                            .Type
                                            .NEAR_FIELD
                                    )
                                    .build()
                            )
                            .transcription(
                                RealtimeSessionCreateResponse.Audio.Input.Transcription.builder()
                                    .language("language")
                                    .model("model")
                                    .prompt("prompt")
                                    .build()
                            )
                            .turnDetection(
                                RealtimeSessionCreateResponse.Audio.Input.TurnDetection.builder()
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type("type")
                                    .build()
                            )
                            .build()
                    )
                    .output(
                        RealtimeSessionCreateResponse.Audio.Output.builder()
                            .format("format")
                            .speed(0.0)
                            .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ALLOY)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeSessionCreateResponse.expiresAt()).contains(0L)
        assertThat(realtimeSessionCreateResponse.include().getOrNull())
            .containsExactly(
                RealtimeSessionCreateResponse.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            )
        assertThat(realtimeSessionCreateResponse.instructions()).contains("instructions")
        assertThat(realtimeSessionCreateResponse.maxOutputTokens())
            .contains(RealtimeSessionCreateResponse.MaxOutputTokens.ofInteger(0L))
        assertThat(realtimeSessionCreateResponse.model()).contains("model")
        assertThat(realtimeSessionCreateResponse.object_()).contains("object")
        assertThat(realtimeSessionCreateResponse.outputModalities().getOrNull())
            .containsExactly(RealtimeSessionCreateResponse.OutputModality.TEXT)
        assertThat(realtimeSessionCreateResponse.toolChoice()).contains("tool_choice")
        assertThat(realtimeSessionCreateResponse.tools().getOrNull())
            .containsExactly(
                RealtimeSessionCreateResponse.Tool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(RealtimeSessionCreateResponse.Tool.Type.FUNCTION)
                    .build()
            )
        assertThat(realtimeSessionCreateResponse.tracing())
            .contains(RealtimeSessionCreateResponse.Tracing.ofAuto())
        assertThat(realtimeSessionCreateResponse.turnDetection())
            .contains(
                RealtimeSessionCreateResponse.TurnDetection.builder()
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .type("type")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeSessionCreateResponse =
            RealtimeSessionCreateResponse.builder()
                .id("id")
                .audio(
                    RealtimeSessionCreateResponse.Audio.builder()
                        .input(
                            RealtimeSessionCreateResponse.Audio.Input.builder()
                                .format("format")
                                .noiseReduction(
                                    RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                        .builder()
                                        .type(
                                            RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                                .Type
                                                .NEAR_FIELD
                                        )
                                        .build()
                                )
                                .transcription(
                                    RealtimeSessionCreateResponse.Audio.Input.Transcription
                                        .builder()
                                        .language("language")
                                        .model("model")
                                        .prompt("prompt")
                                        .build()
                                )
                                .turnDetection(
                                    RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                        .builder()
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type("type")
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeSessionCreateResponse.Audio.Output.builder()
                                .format("format")
                                .speed(0.0)
                                .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ALLOY)
                                .build()
                        )
                        .build()
                )
                .expiresAt(0L)
                .addInclude(
                    RealtimeSessionCreateResponse.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .model("model")
                .object_("object")
                .addOutputModality(RealtimeSessionCreateResponse.OutputModality.TEXT)
                .toolChoice("tool_choice")
                .addTool(
                    RealtimeSessionCreateResponse.Tool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeSessionCreateResponse.Tool.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .turnDetection(
                    RealtimeSessionCreateResponse.TurnDetection.builder()
                        .prefixPaddingMs(0L)
                        .silenceDurationMs(0L)
                        .threshold(0.0)
                        .type("type")
                        .build()
                )
                .build()

        val roundtrippedRealtimeSessionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeSessionCreateResponse),
                jacksonTypeRef<RealtimeSessionCreateResponse>(),
            )

        assertThat(roundtrippedRealtimeSessionCreateResponse)
            .isEqualTo(realtimeSessionCreateResponse)
    }
}
