// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.realtime

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSessionCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TranscriptionSessionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transcriptionSessionService = client.beta().realtime().transcriptionSessions()

        val transcriptionSession =
            transcriptionSessionService.create(
                TranscriptionSessionCreateParams.builder()
                    .clientSecret(
                        TranscriptionSessionCreateParams.ClientSecret.builder()
                            .expiresAt(
                                TranscriptionSessionCreateParams.ClientSecret.ExpiresAt.builder()
                                    .anchor(
                                        TranscriptionSessionCreateParams.ClientSecret.ExpiresAt
                                            .Anchor
                                            .CREATED_AT
                                    )
                                    .seconds(0L)
                                    .build()
                            )
                            .build()
                    )
                    .addInclude("string")
                    .inputAudioFormat(TranscriptionSessionCreateParams.InputAudioFormat.PCM16)
                    .inputAudioNoiseReduction(
                        TranscriptionSessionCreateParams.InputAudioNoiseReduction.builder()
                            .type(
                                TranscriptionSessionCreateParams.InputAudioNoiseReduction.Type
                                    .NEAR_FIELD
                            )
                            .build()
                    )
                    .inputAudioTranscription(
                        TranscriptionSessionCreateParams.InputAudioTranscription.builder()
                            .language("language")
                            .model(
                                TranscriptionSessionCreateParams.InputAudioTranscription.Model
                                    .GPT_4O_TRANSCRIBE
                            )
                            .prompt("prompt")
                            .build()
                    )
                    .addModality(TranscriptionSessionCreateParams.Modality.TEXT)
                    .turnDetection(
                        TranscriptionSessionCreateParams.TurnDetection.builder()
                            .createResponse(true)
                            .eagerness(TranscriptionSessionCreateParams.TurnDetection.Eagerness.LOW)
                            .interruptResponse(true)
                            .prefixPaddingMs(0L)
                            .silenceDurationMs(0L)
                            .threshold(0.0)
                            .type(TranscriptionSessionCreateParams.TurnDetection.Type.SERVER_VAD)
                            .build()
                    )
                    .build()
            )

        transcriptionSession.validate()
    }
}
