// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.realtime.RealtimeAudioConfig
import com.openai.models.realtime.RealtimeClientSecretConfig
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.RealtimeToolsConfigUnion
import com.openai.models.realtime.RealtimeTruncation
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ClientSecretServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val clientSecretService = client.realtime().clientSecrets()

        val clientSecret =
            clientSecretService.create(
                ClientSecretCreateParams.builder()
                    .expiresAfter(
                        ClientSecretCreateParams.ExpiresAfter.builder()
                            .anchor(ClientSecretCreateParams.ExpiresAfter.Anchor.CREATED_AT)
                            .seconds(10L)
                            .build()
                    )
                    .session(
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
                                                        RealtimeAudioConfig.Input.NoiseReduction
                                                            .Type
                                                            .NEAR_FIELD
                                                    )
                                                    .build()
                                            )
                                            .transcription(
                                                RealtimeAudioConfig.Input.Transcription.builder()
                                                    .language("language")
                                                    .model(
                                                        RealtimeAudioConfig.Input.Transcription
                                                            .Model
                                                            .WHISPER_1
                                                    )
                                                    .prompt("prompt")
                                                    .build()
                                            )
                                            .turnDetection(
                                                RealtimeAudioConfig.Input.TurnDetection.builder()
                                                    .createResponse(true)
                                                    .eagerness(
                                                        RealtimeAudioConfig.Input.TurnDetection
                                                            .Eagerness
                                                            .LOW
                                                    )
                                                    .idleTimeoutMs(0L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .type(
                                                        RealtimeAudioConfig.Input.TurnDetection.Type
                                                            .SERVER_VAD
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
                                            .anchor(
                                                RealtimeClientSecretConfig.ExpiresAfter.Anchor
                                                    .CREATED_AT
                                            )
                                            .seconds(0L)
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
                    )
                    .build()
            )

        clientSecret.validate()
    }
}
