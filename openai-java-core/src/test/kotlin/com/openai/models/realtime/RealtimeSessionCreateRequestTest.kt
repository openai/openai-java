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
                .audio(
                    RealtimeAudioConfig.builder()
                        .input(
                            RealtimeAudioConfigInput.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .noiseReduction(
                                    RealtimeAudioConfigInput.NoiseReduction.builder()
                                        .type(NoiseReductionType.NEAR_FIELD)
                                        .build()
                                )
                                .transcription(
                                    AudioTranscription.builder()
                                        .language("language")
                                        .model(AudioTranscription.Model.WHISPER_1)
                                        .prompt("prompt")
                                        .build()
                                )
                                .turnDetection(
                                    RealtimeAudioInputTurnDetection.ServerVad.builder()
                                        .createResponse(true)
                                        .idleTimeoutMs(5000L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeAudioConfigOutput.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .speed(0.25)
                                .voice(RealtimeAudioConfigOutput.Voice.ASH)
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
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
                .toolChoice(ToolChoiceOptions.NONE)
                .addTool(
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
                        .build()
                )
                .tracingAuto()
                .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                .build()

        assertThat(realtimeSessionCreateRequest.audio())
            .contains(
                RealtimeAudioConfig.builder()
                    .input(
                        RealtimeAudioConfigInput.builder()
                            .format(
                                RealtimeAudioFormats.AudioPcm.builder()
                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                    .build()
                            )
                            .noiseReduction(
                                RealtimeAudioConfigInput.NoiseReduction.builder()
                                    .type(NoiseReductionType.NEAR_FIELD)
                                    .build()
                            )
                            .transcription(
                                AudioTranscription.builder()
                                    .language("language")
                                    .model(AudioTranscription.Model.WHISPER_1)
                                    .prompt("prompt")
                                    .build()
                            )
                            .turnDetection(
                                RealtimeAudioInputTurnDetection.ServerVad.builder()
                                    .createResponse(true)
                                    .idleTimeoutMs(5000L)
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .build()
                            )
                            .build()
                    )
                    .output(
                        RealtimeAudioConfigOutput.builder()
                            .format(
                                RealtimeAudioFormats.AudioPcm.builder()
                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                    .build()
                            )
                            .speed(0.25)
                            .voice(RealtimeAudioConfigOutput.Voice.ASH)
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
        assertThat(realtimeSessionCreateRequest.model())
            .contains(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
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
        assertThat(realtimeSessionCreateRequest.toolChoice())
            .contains(RealtimeToolChoiceConfig.ofToolChoiceOptions(ToolChoiceOptions.NONE))
        assertThat(realtimeSessionCreateRequest.tools().getOrNull())
            .containsExactly(
                RealtimeToolsConfigUnion.ofFunction(
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
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
                .audio(
                    RealtimeAudioConfig.builder()
                        .input(
                            RealtimeAudioConfigInput.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .noiseReduction(
                                    RealtimeAudioConfigInput.NoiseReduction.builder()
                                        .type(NoiseReductionType.NEAR_FIELD)
                                        .build()
                                )
                                .transcription(
                                    AudioTranscription.builder()
                                        .language("language")
                                        .model(AudioTranscription.Model.WHISPER_1)
                                        .prompt("prompt")
                                        .build()
                                )
                                .turnDetection(
                                    RealtimeAudioInputTurnDetection.ServerVad.builder()
                                        .createResponse(true)
                                        .idleTimeoutMs(5000L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeAudioConfigOutput.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .speed(0.25)
                                .voice(RealtimeAudioConfigOutput.Voice.ASH)
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
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
                .toolChoice(ToolChoiceOptions.NONE)
                .addTool(
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
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
