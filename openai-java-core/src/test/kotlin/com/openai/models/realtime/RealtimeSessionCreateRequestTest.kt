// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeSessionCreateRequestTest {

    @Test
    fun create() {
        val realtimeSessionCreateRequest =
            RealtimeSessionCreateRequest.builder()
                .model(RealtimeSessionCreateRequest.Model.GPT_4O_REALTIME)
                .audio(
                    RealtimeAudioConfig.builder()
                        .input(
                            RealtimeAudioConfig.Input.builder()
                                .format(RealtimeAudioConfig.Input.Format.PCM16)
                                .noiseReduction(
                                    RealtimeAudioConfig.Input.NoiseReduction.builder()
                                        .type(
                                            RealtimeAudioConfig.Input.NoiseReduction.Type.NEAR_FIELD
                                        )
                                        .build()
                                )
                                .transcription(
                                    RealtimeAudioConfig.Input.Transcription.builder()
                                        .language("language")
                                        .model(
                                            RealtimeAudioConfig.Input.Transcription.Model.WHISPER_1
                                        )
                                        .prompt("prompt")
                                        .build()
                                )
                                .turnDetection(
                                    RealtimeAudioConfig.Input.TurnDetection.builder()
                                        .createResponse(true)
                                        .eagerness(
                                            RealtimeAudioConfig.Input.TurnDetection.Eagerness.LOW
                                        )
                                        .idleTimeoutMs(0L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type(
                                            RealtimeAudioConfig.Input.TurnDetection.Type.SERVER_VAD
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeAudioConfig.Output.builder()
                                .format(RealtimeAudioConfig.Output.Format.PCM16)
                                .speed(0.25)
                                .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                                .build()
                        )
                        .build()
                )
                .clientSecret(
                    RealtimeClientSecretConfig.builder()
                        .expiresAfter(
                            RealtimeClientSecretConfig.ExpiresAfter.builder()
                                .anchor(RealtimeClientSecretConfig.ExpiresAfter.Anchor.CREATED_AT)
                                .seconds(0L)
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
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
                .temperature(0.0)
                .toolChoice(ToolChoiceOptions.NONE)
                .addTool(
                    RealtimeToolsConfigUnion.Function.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeToolsConfigUnion.Function.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                .build()

        assertThat(realtimeSessionCreateRequest.model())
            .isEqualTo(RealtimeSessionCreateRequest.Model.GPT_4O_REALTIME)
        assertThat(realtimeSessionCreateRequest.audio())
            .contains(
                RealtimeAudioConfig.builder()
                    .input(
                        RealtimeAudioConfig.Input.builder()
                            .format(RealtimeAudioConfig.Input.Format.PCM16)
                            .noiseReduction(
                                RealtimeAudioConfig.Input.NoiseReduction.builder()
                                    .type(RealtimeAudioConfig.Input.NoiseReduction.Type.NEAR_FIELD)
                                    .build()
                            )
                            .transcription(
                                RealtimeAudioConfig.Input.Transcription.builder()
                                    .language("language")
                                    .model(RealtimeAudioConfig.Input.Transcription.Model.WHISPER_1)
                                    .prompt("prompt")
                                    .build()
                            )
                            .turnDetection(
                                RealtimeAudioConfig.Input.TurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(
                                        RealtimeAudioConfig.Input.TurnDetection.Eagerness.LOW
                                    )
                                    .idleTimeoutMs(0L)
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(RealtimeAudioConfig.Input.TurnDetection.Type.SERVER_VAD)
                                    .build()
                            )
                            .build()
                    )
                    .output(
                        RealtimeAudioConfig.Output.builder()
                            .format(RealtimeAudioConfig.Output.Format.PCM16)
                            .speed(0.25)
                            .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeSessionCreateRequest.clientSecret())
            .contains(
                RealtimeClientSecretConfig.builder()
                    .expiresAfter(
                        RealtimeClientSecretConfig.ExpiresAfter.builder()
                            .anchor(RealtimeClientSecretConfig.ExpiresAfter.Anchor.CREATED_AT)
                            .seconds(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeSessionCreateRequest.include().getOrNull())
            .containsExactly(
                RealtimeSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            )
        assertThat(realtimeSessionCreateRequest.instructions()).contains("instructions")
        assertThat(realtimeSessionCreateRequest.maxOutputTokens())
            .contains(RealtimeSessionCreateRequest.MaxOutputTokens.ofInteger(0L))
        assertThat(realtimeSessionCreateRequest.outputModalities().getOrNull())
            .containsExactly(RealtimeSessionCreateRequest.OutputModality.TEXT)
        assertThat(realtimeSessionCreateRequest.prompt())
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
        assertThat(realtimeSessionCreateRequest.temperature()).contains(0.0)
        assertThat(realtimeSessionCreateRequest.toolChoice())
            .contains(RealtimeToolChoiceConfig.ofToolChoiceOptions(ToolChoiceOptions.NONE))
        assertThat(realtimeSessionCreateRequest.tools().getOrNull())
            .containsExactly(
                RealtimeToolsConfigUnion.ofFunction(
                    RealtimeToolsConfigUnion.Function.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeToolsConfigUnion.Function.Type.FUNCTION)
                        .build()
                )
            )
        assertThat(realtimeSessionCreateRequest.tracing()).contains(RealtimeTracingConfig.ofAuto())
        assertThat(realtimeSessionCreateRequest.truncation())
            .contains(
                RealtimeTruncation.ofStrategy(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeSessionCreateRequest =
            RealtimeSessionCreateRequest.builder()
                .model(RealtimeSessionCreateRequest.Model.GPT_4O_REALTIME)
                .audio(
                    RealtimeAudioConfig.builder()
                        .input(
                            RealtimeAudioConfig.Input.builder()
                                .format(RealtimeAudioConfig.Input.Format.PCM16)
                                .noiseReduction(
                                    RealtimeAudioConfig.Input.NoiseReduction.builder()
                                        .type(
                                            RealtimeAudioConfig.Input.NoiseReduction.Type.NEAR_FIELD
                                        )
                                        .build()
                                )
                                .transcription(
                                    RealtimeAudioConfig.Input.Transcription.builder()
                                        .language("language")
                                        .model(
                                            RealtimeAudioConfig.Input.Transcription.Model.WHISPER_1
                                        )
                                        .prompt("prompt")
                                        .build()
                                )
                                .turnDetection(
                                    RealtimeAudioConfig.Input.TurnDetection.builder()
                                        .createResponse(true)
                                        .eagerness(
                                            RealtimeAudioConfig.Input.TurnDetection.Eagerness.LOW
                                        )
                                        .idleTimeoutMs(0L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type(
                                            RealtimeAudioConfig.Input.TurnDetection.Type.SERVER_VAD
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeAudioConfig.Output.builder()
                                .format(RealtimeAudioConfig.Output.Format.PCM16)
                                .speed(0.25)
                                .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                                .build()
                        )
                        .build()
                )
                .clientSecret(
                    RealtimeClientSecretConfig.builder()
                        .expiresAfter(
                            RealtimeClientSecretConfig.ExpiresAfter.builder()
                                .anchor(RealtimeClientSecretConfig.ExpiresAfter.Anchor.CREATED_AT)
                                .seconds(0L)
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
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
                .temperature(0.0)
                .toolChoice(ToolChoiceOptions.NONE)
                .addTool(
                    RealtimeToolsConfigUnion.Function.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeToolsConfigUnion.Function.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                .build()

        val roundtrippedRealtimeSessionCreateRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeSessionCreateRequest),
                jacksonTypeRef<RealtimeSessionCreateRequest>(),
            )

        assertThat(roundtrippedRealtimeSessionCreateRequest).isEqualTo(realtimeSessionCreateRequest)
    }
}
