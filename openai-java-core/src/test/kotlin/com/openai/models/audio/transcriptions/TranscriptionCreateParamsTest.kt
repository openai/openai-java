// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.openai.core.MultipartField
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "file" to MultipartField.of("some content".byteInputStream()),
                        "model" to MultipartField.of(AudioModel.WHISPER_1),
                        "include" to MultipartField.of(listOf(TranscriptionInclude.LOGPROBS)),
                        "language" to MultipartField.of("language"),
                        "prompt" to MultipartField.of("prompt"),
                        "response_format" to MultipartField.of(AudioResponseFormat.JSON),
                        "temperature" to MultipartField.of(0.0),
                        "timestamp_granularities" to
                            MultipartField.of(
                                listOf(TranscriptionCreateParams.TimestampGranularity.WORD)
                            ),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TranscriptionCreateParams.builder()
                .file("some content".byteInputStream())
                .model(AudioModel.WHISPER_1)
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "file" to MultipartField.of("some content".byteInputStream()),
                        "model" to MultipartField.of(AudioModel.WHISPER_1),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
