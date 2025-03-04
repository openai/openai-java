// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.MultipartField
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AudioTranscriptionCreateParamsTest {

    @Test
    fun create() {
        AudioTranscriptionCreateParams.builder()
            .file("some content".toByteArray())
            .model(AudioModel.WHISPER_1)
            .language("language")
            .prompt("prompt")
            .responseFormat(AudioResponseFormat.JSON)
            .temperature(0.0)
            .addTimestampGranularity(AudioTranscriptionCreateParams.TimestampGranularity.WORD)
            .build()
    }

    @Test
    fun body() {
        val params =
            AudioTranscriptionCreateParams.builder()
                .file("some content".toByteArray())
                .model(AudioModel.WHISPER_1)
                .language("language")
                .prompt("prompt")
                .responseFormat(AudioResponseFormat.JSON)
                .temperature(0.0)
                .addTimestampGranularity(AudioTranscriptionCreateParams.TimestampGranularity.WORD)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.filterValues { !it.value.isNull() })
            .isEqualTo(
                mapOf(
                    "file" to MultipartField.of("some content".toByteArray()),
                    "model" to MultipartField.of(AudioModel.WHISPER_1),
                    "language" to MultipartField.of("language"),
                    "prompt" to MultipartField.of("prompt"),
                    "response_format" to MultipartField.of(AudioResponseFormat.JSON),
                    "temperature" to MultipartField.of(0.0),
                    "timestamp_granularities" to
                        MultipartField.of(
                            listOf(AudioTranscriptionCreateParams.TimestampGranularity.WORD)
                        ),
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AudioTranscriptionCreateParams.builder()
                .file("some content".toByteArray())
                .model(AudioModel.WHISPER_1)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.filterValues { !it.value.isNull() })
            .isEqualTo(
                mapOf(
                    "file" to MultipartField.of("some content".toByteArray()),
                    "model" to MultipartField.of(AudioModel.WHISPER_1),
                )
            )
    }
}
