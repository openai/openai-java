// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.AudioModel
import com.openai.models.AudioResponseFormat
import com.openai.models.AudioTranslationCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TranslationServiceAsyncTest {

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
                AudioTranslationCreateParams.builder()
                    .file("some content".toByteArray())
                    .model(AudioModel.WHISPER_1)
                    .prompt("prompt")
                    .responseFormat(AudioResponseFormat.JSON)
                    .temperature(0.0)
                    .build()
            )

        val translation = translationFuture.get()
        translation.validate()
    }
}
