// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.openai.core.MultipartField
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import java.io.InputStream
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TranscriptionCreateParamsTest {

    @Test
    fun create() {
        TranscriptionCreateParams.builder()
            .file("some content".toByteArray())
            .model(AudioModel.WHISPER_1)
            .language("language")
            .prompt("prompt")
            .responseFormat(AudioResponseFormat.JSON)
            .temperature(0.0)
            .addTimestampGranularity(TranscriptionCreateParams.TimestampGranularity.WORD)
            .build()
    }

    @Test
    fun body() {
        val params =
            TranscriptionCreateParams.builder()
                .file("some content".toByteArray())
                .model(AudioModel.WHISPER_1)
                .language("language")
                .prompt("prompt")
                .responseFormat(AudioResponseFormat.JSON)
                .temperature(0.0)
                .addTimestampGranularity(TranscriptionCreateParams.TimestampGranularity.WORD)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(
                body
                    .filterValues { !it.value.isNull() }
                    .mapValues { (_, field) ->
                        field.map { if (it is InputStream) it.readBytes() else it }
                    }
            )
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
                            listOf(TranscriptionCreateParams.TimestampGranularity.WORD)
                        ),
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TranscriptionCreateParams.builder()
                .file("some content".toByteArray())
                .model(AudioModel.WHISPER_1)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(
                body
                    .filterValues { !it.value.isNull() }
                    .mapValues { (_, field) ->
                        field.map { if (it is InputStream) it.readBytes() else it }
                    }
            )
            .isEqualTo(
                mapOf(
                    "file" to MultipartField.of("some content".toByteArray()),
                    "model" to MultipartField.of(AudioModel.WHISPER_1),
                )
            )
    }
}
