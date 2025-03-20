// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TranscriptionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transcriptionService = client.audio().transcriptions()

        val transcription =
            transcriptionService.create(
                TranscriptionCreateParams.builder()
                    .file("some content".toByteArray())
                    .model(AudioModel.WHISPER_1)
                    .addInclude(TranscriptionInclude.LOGPROBS)
                    .language("language")
                    .prompt("prompt")
                    .responseFormat(AudioResponseFormat.JSON)
                    .temperature(0.0)
                    .addTimestampGranularity(TranscriptionCreateParams.TimestampGranularity.WORD)
                    .build()
            )

        transcription.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transcriptionService = client.audio().transcriptions()

        val transcriptionStreamResponse =
            transcriptionService.createStreaming(
                TranscriptionCreateParams.builder()
                    .file("some content".toByteArray())
                    .model(AudioModel.WHISPER_1)
                    .addInclude(TranscriptionInclude.LOGPROBS)
                    .language("language")
                    .prompt("prompt")
                    .responseFormat(AudioResponseFormat.JSON)
                    .temperature(0.0)
                    .addTimestampGranularity(TranscriptionCreateParams.TimestampGranularity.WORD)
                    .build()
            )

        transcriptionStreamResponse.use {
            transcriptionStreamResponse.stream().forEach { transcription ->
                transcription.validate()
            }
        }
    }
}
