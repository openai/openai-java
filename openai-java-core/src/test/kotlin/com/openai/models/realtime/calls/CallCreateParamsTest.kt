// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime.calls

import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioConfig
import com.openai.models.realtime.RealtimeAudioConfigInput
import com.openai.models.realtime.RealtimeAudioConfigOutput
import com.openai.models.realtime.RealtimeAudioFormats
import com.openai.models.realtime.RealtimeAudioInputTurnDetection
import com.openai.models.realtime.RealtimeFunctionTool
import com.openai.models.realtime.RealtimeReasoning
import com.openai.models.realtime.RealtimeReasoningEffort
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.RealtimeTruncation
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallCreateParamsTest {

    @Test
    fun create() {
        CallCreateParams.builder()
            .sdp("sdp")
            .session(
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
                                            .delay(AudioTranscription.Delay.MINIMAL)
                                            .addKeyword("string")
                                            .language("language")
                                            .addLanguage("string")
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
                                    .voice(RealtimeAudioConfigOutput.Voice.UnionMember1.ALLOY)
                                    .build()
                            )
                            .build()
                    )
                    .addInclude(
                        RealtimeSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    )
                    .instructions("instructions")
                    .maxOutputTokensInf()
                    .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                    .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
                    .parallelToolCalls(true)
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
                    .reasoning(
                        RealtimeReasoning.builder().effort(RealtimeReasoningEffort.MINIMAL).build()
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            CallCreateParams.builder()
                .sdp("sdp")
                .session(
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
                                                .delay(AudioTranscription.Delay.MINIMAL)
                                                .addKeyword("string")
                                                .language("language")
                                                .addLanguage("string")
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
                                        .voice(RealtimeAudioConfigOutput.Voice.UnionMember1.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .instructions("instructions")
                        .maxOutputTokensInf()
                        .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                        .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
                        .parallelToolCalls(true)
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
                        .reasoning(
                            RealtimeReasoning.builder()
                                .effort(RealtimeReasoningEffort.MINIMAL)
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
                )
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() && !it.value.isMissing() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "sdp" to MultipartField.of("sdp"),
                        "session" to
                            MultipartField.of(
                                RealtimeSessionCreateRequest.builder()
                                    .audio(
                                        RealtimeAudioConfig.builder()
                                            .input(
                                                RealtimeAudioConfigInput.builder()
                                                    .format(
                                                        RealtimeAudioFormats.AudioPcm.builder()
                                                            .rate(
                                                                RealtimeAudioFormats.AudioPcm.Rate
                                                                    ._24000
                                                            )
                                                            .type(
                                                                RealtimeAudioFormats.AudioPcm.Type
                                                                    .AUDIO_PCM
                                                            )
                                                            .build()
                                                    )
                                                    .noiseReduction(
                                                        RealtimeAudioConfigInput.NoiseReduction
                                                            .builder()
                                                            .type(NoiseReductionType.NEAR_FIELD)
                                                            .build()
                                                    )
                                                    .transcription(
                                                        AudioTranscription.builder()
                                                            .delay(AudioTranscription.Delay.MINIMAL)
                                                            .addKeyword("string")
                                                            .language("language")
                                                            .addLanguage("string")
                                                            .model(
                                                                AudioTranscription.Model.WHISPER_1
                                                            )
                                                            .prompt("prompt")
                                                            .build()
                                                    )
                                                    .turnDetection(
                                                        RealtimeAudioInputTurnDetection.ServerVad
                                                            .builder()
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
                                                            .rate(
                                                                RealtimeAudioFormats.AudioPcm.Rate
                                                                    ._24000
                                                            )
                                                            .type(
                                                                RealtimeAudioFormats.AudioPcm.Type
                                                                    .AUDIO_PCM
                                                            )
                                                            .build()
                                                    )
                                                    .speed(0.25)
                                                    .voice(
                                                        RealtimeAudioConfigOutput.Voice.UnionMember1
                                                            .ALLOY
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .addInclude(
                                        RealtimeSessionCreateRequest.Include
                                            .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                                    )
                                    .instructions("instructions")
                                    .maxOutputTokensInf()
                                    .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                                    .addOutputModality(
                                        RealtimeSessionCreateRequest.OutputModality.TEXT
                                    )
                                    .parallelToolCalls(true)
                                    .prompt(
                                        ResponsePrompt.builder()
                                            .id("id")
                                            .variables(
                                                ResponsePrompt.Variables.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("string"),
                                                    )
                                                    .build()
                                            )
                                            .version("version")
                                            .build()
                                    )
                                    .reasoning(
                                        RealtimeReasoning.builder()
                                            .effort(RealtimeReasoningEffort.MINIMAL)
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
                            ),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CallCreateParams.builder().sdp("sdp").build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() && !it.value.isMissing() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf("sdp" to MultipartField.of("sdp")).mapValues { (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }
}
