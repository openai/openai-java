// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TranscriptionServiceAsyncTest {

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
                TranscriptionCreateParams.builder()
                    .file("some content".byteInputStream())
                    .model(AudioModel.WHISPER_1)
                    .addInclude(TranscriptionInclude.LOGPROBS)
                    .language("language")
                    .prompt("prompt")
                    .responseFormat(AudioResponseFormat.JSON)
                    .temperature(0.0)
                    .addTimestampGranularity(TranscriptionCreateParams.TimestampGranularity.WORD)
                    .build()
            )

        val transcription = transcriptionFuture.get()
        transcription.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transcriptionServiceAsync = client.audio().transcriptions()

        val transcriptionStreamResponse =
            transcriptionServiceAsync.createStreaming(
                TranscriptionCreateParams.builder()
                    .file("some content".byteInputStream())
                    .model(AudioModel.WHISPER_1)
                    .addInclude(TranscriptionInclude.LOGPROBS)
                    .language("language")
                    .prompt("prompt")
                    .responseFormat(AudioResponseFormat.JSON)
                    .temperature(0.0)
                    .addTimestampGranularity(TranscriptionCreateParams.TimestampGranularity.WORD)
                    .build()
            )

        val onCompleteFuture =
            transcriptionStreamResponse
                .subscribe { transcription -> transcription.validate() }
                .onCompleteFuture()
        onCompleteFuture.get()
    }
}
