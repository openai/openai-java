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
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientSecretCreateResponseTest {

    @Test
    fun create() {
        val clientSecretCreateResponse =
            ClientSecretCreateResponse.builder()
                .expiresAt(0L)
                .session(
                    RealtimeSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
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
                                                .model(AudioTranscription.Model.of("string"))
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .ServerVad
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
                                    RealtimeSessionCreateResponse.Audio.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .speed(0.25)
                                        .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ASH)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateResponse.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .instructions("instructions")
                        .maxOutputTokens(0L)
                        .model(RealtimeSessionCreateResponse.Model.of("string"))
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
                )
                .value("value")
                .build()

        assertThat(clientSecretCreateResponse.expiresAt()).isEqualTo(0L)
        assertThat(clientSecretCreateResponse.session())
            .isEqualTo(
                ClientSecretCreateResponse.Session.ofRealtime(
                    RealtimeSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
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
                                                .model(AudioTranscription.Model.of("string"))
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .ServerVad
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
                                    RealtimeSessionCreateResponse.Audio.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .speed(0.25)
                                        .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ASH)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateResponse.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .instructions("instructions")
                        .maxOutputTokens(0L)
                        .model(RealtimeSessionCreateResponse.Model.of("string"))
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
                )
            )
        assertThat(clientSecretCreateResponse.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clientSecretCreateResponse =
            ClientSecretCreateResponse.builder()
                .expiresAt(0L)
                .session(
                    RealtimeSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
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
                                                .model(AudioTranscription.Model.of("string"))
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            RealtimeSessionCreateResponse.Audio.Input.TurnDetection
                                                .ServerVad
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
                                    RealtimeSessionCreateResponse.Audio.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .speed(0.25)
                                        .voice(RealtimeSessionCreateResponse.Audio.Output.Voice.ASH)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateResponse.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .instructions("instructions")
                        .maxOutputTokens(0L)
                        .model(RealtimeSessionCreateResponse.Model.of("string"))
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
                )
                .value("value")
                .build()

        val roundtrippedClientSecretCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientSecretCreateResponse),
                jacksonTypeRef<ClientSecretCreateResponse>(),
            )

        assertThat(roundtrippedClientSecretCreateResponse).isEqualTo(clientSecretCreateResponse)
    }
}
