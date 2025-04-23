// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.audio.AudioModel
import com.openai.models.audio.translations.TranslationCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TranslationServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val translationService = client.audio().translations()

        val translation =
            translationService.create(
                TranslationCreateParams.builder()
                    .file("some content".byteInputStream())
                    .model(AudioModel.WHISPER_1)
                    .prompt("prompt")
                    .responseFormat(TranslationCreateParams.ResponseFormat.JSON)
                    .temperature(0.0)
                    .build()
            )

        translation.validate()
    }
}
