// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.realtime.translations

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateRequest
import com.openai.models.realtime.RealtimeTranslationSessionCreateRequest
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
                .adminApiKey("My Admin API Key")
                .build()
        val clientSecretService = client.realtime().translations().clientSecrets()

        val realtimeTranslationClientSecretCreateResponse =
            clientSecretService.create(
                RealtimeTranslationClientSecretCreateRequest.builder()
                    .session(
                        RealtimeTranslationSessionCreateRequest.builder()
                            .model("model")
                            .audio(
                                RealtimeTranslationSessionCreateRequest.Audio.builder()
                                    .input(
                                        RealtimeTranslationSessionCreateRequest.Audio.Input
                                            .builder()
                                            .noiseReduction(
                                                RealtimeTranslationSessionCreateRequest.Audio.Input
                                                    .NoiseReduction
                                                    .builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                RealtimeTranslationSessionCreateRequest.Audio.Input
                                                    .Transcription
                                                    .builder()
                                                    .model("model")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeTranslationSessionCreateRequest.Audio.Output
                                            .builder()
                                            .language("language")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .expiresAfter(
                        RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.builder()
                            .anchor(
                                RealtimeTranslationClientSecretCreateRequest.ExpiresAfter.Anchor
                                    .CREATED_AT
                            )
                            .seconds(10L)
                            .build()
                    )
                    .build()
            )

        realtimeTranslationClientSecretCreateResponse.validate()
    }
}
