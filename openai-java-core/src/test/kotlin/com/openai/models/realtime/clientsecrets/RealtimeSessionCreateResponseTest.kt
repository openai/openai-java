// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioFormats
import com.openai.models.realtime.RealtimeFunctionTool
import com.openai.models.realtime.RealtimeTruncation
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeSessionCreateResponseTest {

    @Test
    fun create() {
        val realtimeSessionCreateResponse =
            RealtimeSessionCreateResponse.builder()
                .clientSecret(
                    RealtimeSessionClientSecret.builder().expiresAt(0L).value("value").build()
                )
                .audio(
                    RealtimeSessionCreateResponse.Audio.builder()
                        .input(
                            RealtimeSessionCreateResponse.Audio.Input.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .noiseReduction(
                                    RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                        .builder()
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
                                    RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                        .builder()
                                        .createResponse(true)
                                        .eagerness(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .Eagerness
                                                .LOW
                                        )
                                        .idleTimeoutMs(0L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .Type
                                                .SERVER_VAD
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeSessionCreateResponse.Audio.Output.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .speed(0.25)
                                .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ALLOY)
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeSessionCreateResponse.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .model(RealtimeSessionCreateResponse.Model.GPT_REALTIME)
                .addOutputModality(RealtimeSessionCreateResponse.OutputModality.TEXT)
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

        assertThat(realtimeSessionCreateResponse.clientSecret())
            .isEqualTo(RealtimeSessionClientSecret.builder().expiresAt(0L).value("value").build())
        assertThat(realtimeSessionCreateResponse.audio())
            .contains(
                RealtimeSessionCreateResponse.Audio.builder()
                    .input(
                        RealtimeSessionCreateResponse.Audio.Input.builder()
                            .format(
                                RealtimeAudioFormats.AudioPcm.builder()
                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                    .build()
                            )
                            .noiseReduction(
                                RealtimeSessionCreateResponse.Audio.Input.NoiseReduction.builder()
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
                                RealtimeSessionCreateResponse.Audio.Input.TurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(
                                        RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                            .Eagerness
                                            .LOW
                                    )
                                    .idleTimeoutMs(0L)
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(
                                        RealtimeSessionCreateResponse.Audio.Input.TurnDetection.Type
                                            .SERVER_VAD
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .output(
                        RealtimeSessionCreateResponse.Audio.Output.builder()
                            .format(
                                RealtimeAudioFormats.AudioPcm.builder()
                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                    .build()
                            )
                            .speed(0.25)
                            .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ALLOY)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeSessionCreateResponse.include().getOrNull())
            .containsExactly(
                RealtimeSessionCreateResponse.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
            )
        assertThat(realtimeSessionCreateResponse.instructions()).contains("instructions")
        assertThat(realtimeSessionCreateResponse.maxOutputTokens())
            .contains(RealtimeSessionCreateResponse.MaxOutputTokens.ofInteger(0L))
        assertThat(realtimeSessionCreateResponse.model())
            .contains(RealtimeSessionCreateResponse.Model.GPT_REALTIME)
        assertThat(realtimeSessionCreateResponse.outputModalities().getOrNull())
            .containsExactly(RealtimeSessionCreateResponse.OutputModality.TEXT)
        assertThat(realtimeSessionCreateResponse.prompt())
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
        assertThat(realtimeSessionCreateResponse.toolChoice())
            .contains(RealtimeSessionCreateResponse.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
        assertThat(realtimeSessionCreateResponse.tools().getOrNull())
            .containsExactly(
                RealtimeSessionCreateResponse.Tool.ofRealtimeFunction(
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
                        .build()
                )
            )
        assertThat(realtimeSessionCreateResponse.tracing())
            .contains(RealtimeSessionCreateResponse.Tracing.ofAuto())
        assertThat(realtimeSessionCreateResponse.truncation())
            .contains(
                RealtimeTruncation.ofStrategy(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeSessionCreateResponse =
            RealtimeSessionCreateResponse.builder()
                .clientSecret(
                    RealtimeSessionClientSecret.builder().expiresAt(0L).value("value").build()
                )
                .audio(
                    RealtimeSessionCreateResponse.Audio.builder()
                        .input(
                            RealtimeSessionCreateResponse.Audio.Input.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .noiseReduction(
                                    RealtimeSessionCreateResponse.Audio.Input.NoiseReduction
                                        .builder()
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
                                    RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                        .builder()
                                        .createResponse(true)
                                        .eagerness(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .Eagerness
                                                .LOW
                                        )
                                        .idleTimeoutMs(0L)
                                        .interruptResponse(true)
                                        .prefixPaddingMs(0L)
                                        .silenceDurationMs(0L)
                                        .threshold(0.0)
                                        .type(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .Type
                                                .SERVER_VAD
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .output(
                            RealtimeSessionCreateResponse.Audio.Output.builder()
                                .format(
                                    RealtimeAudioFormats.AudioPcm.builder()
                                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                        .build()
                                )
                                .speed(0.25)
                                .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ALLOY)
                                .build()
                        )
                        .build()
                )
                .addInclude(
                    RealtimeSessionCreateResponse.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                )
                .instructions("instructions")
                .maxOutputTokens(0L)
                .model(RealtimeSessionCreateResponse.Model.GPT_REALTIME)
                .addOutputModality(RealtimeSessionCreateResponse.OutputModality.TEXT)
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

        val roundtrippedRealtimeSessionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeSessionCreateResponse),
                jacksonTypeRef<RealtimeSessionCreateResponse>(),
            )

        assertThat(roundtrippedRealtimeSessionCreateResponse)
            .isEqualTo(realtimeSessionCreateResponse)
    }
}
