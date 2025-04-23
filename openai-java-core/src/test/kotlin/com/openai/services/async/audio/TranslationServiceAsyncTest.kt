// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.audio.AudioModel
import com.openai.models.audio.translations.TranslationCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TranslationServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val translationServiceAsync = client.audio().translations()

        val translationFuture =
            translationServiceAsync.create(
                TranslationCreateParams.builder()
                    .file("some content".byteInputStream())
                    .model(AudioModel.WHISPER_1)
                    .prompt("prompt")
                    .responseFormat(TranslationCreateParams.ResponseFormat.JSON)
                    .temperature(0.0)
                    .build()
            )

        val translation = translationFuture.get()
        translation.validate()
    }
}
