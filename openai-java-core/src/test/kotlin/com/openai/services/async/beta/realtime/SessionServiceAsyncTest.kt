// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.realtime

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.realtime.sessions.SessionCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SessionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sessionServiceAsync = client.beta().realtime().sessions()

        val sessionFuture =
            sessionServiceAsync.create(
                SessionCreateParams.builder()
                    .clientSecret(
                        SessionCreateParams.ClientSecret.builder()
                            .expiresAfter(
                                SessionCreateParams.ClientSecret.ExpiresAfter.builder()
                                    .anchor(
                                        SessionCreateParams.ClientSecret.ExpiresAfter.Anchor
                                            .CREATED_AT
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
            )

        val session = sessionFuture.get()
        session.validate()
    }
}
