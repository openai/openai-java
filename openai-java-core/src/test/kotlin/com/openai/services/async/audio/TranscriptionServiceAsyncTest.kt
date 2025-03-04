// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.AudioModel
import com.openai.models.AudioResponseFormat
import com.openai.models.AudioTranscriptionCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TranscriptionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transcriptionServiceAsync = client.audio().transcriptions()

        val transcriptionFuture =
            transcriptionServiceAsync.create(
                AudioTranscriptionCreateParams.builder()
                    .file("some content".toByteArray())
                    .model(AudioModel.WHISPER_1)
                    .language("language")
                    .prompt("prompt")
                    .responseFormat(AudioResponseFormat.JSON)
                    .temperature(0.0)
                    .addTimestampGranularity(
                        AudioTranscriptionCreateParams.TimestampGranularity.WORD
                    )
                    .build()
            )

        val transcription = transcriptionFuture.get()
        transcription.validate()
    }
}
