// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

import com.openai.core.JsonValue
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioConfig
import com.openai.models.realtime.RealtimeAudioConfigInput
import com.openai.models.realtime.RealtimeAudioConfigOutput
import com.openai.models.realtime.RealtimeAudioFormats
import com.openai.models.realtime.RealtimeAudioInputTurnDetection
import com.openai.models.realtime.RealtimeFunctionTool
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.RealtimeTruncation
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientSecretCreateParamsTest {

    @Test
    fun create() {
        ClientSecretCreateParams.builder()
            .expiresAfter(
                ClientSecretCreateParams.ExpiresAfter.builder()
                    .anchor(ClientSecretCreateParams.ExpiresAfter.Anchor.CREATED_AT)
                    .seconds(10L)
                    .build()
            )
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
                                    .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ClientSecretCreateParams.builder()
                .expiresAfter(
                    ClientSecretCreateParams.ExpiresAfter.builder()
                        .anchor(ClientSecretCreateParams.ExpiresAfter.Anchor.CREATED_AT)
                        .seconds(10L)
                        .build()
                )
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
                                        .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
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
                )
                .build()

        val body = params._body()

        assertThat(body.expiresAfter())
            .contains(
                ClientSecretCreateParams.ExpiresAfter.builder()
                    .anchor(ClientSecretCreateParams.ExpiresAfter.Anchor.CREATED_AT)
                    .seconds(10L)
                    .build()
            )
        assertThat(body.session())
            .contains(
                ClientSecretCreateParams.Session.ofRealtime(
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
                                        .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
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
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ClientSecretCreateParams.builder().build()

        val body = params._body()
    }
}
