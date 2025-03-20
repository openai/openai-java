// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import com.openai.core.MultipartField
import com.openai.models.audio.AudioModel
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranslationCreateParamsTest {

    @Test
    fun create() {
        TranslationCreateParams.builder()
            .file("some content".toByteArray())
            .model(AudioModel.WHISPER_1)
            .prompt("prompt")
            .responseFormat(TranslationCreateParams.ResponseFormat.JSON)
            .temperature(0.0)
            .build()
    }

    @Test
    fun body() {
        val params =
            TranslationCreateParams.builder()
                .file("some content".toByteArray())
                .model(AudioModel.WHISPER_1)
                .prompt("prompt")
                .responseFormat(TranslationCreateParams.ResponseFormat.JSON)
                .temperature(0.0)
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
                        "file" to MultipartField.of("some content".toByteArray()),
                        "model" to MultipartField.of(AudioModel.WHISPER_1),
                        "prompt" to MultipartField.of("prompt"),
                        "response_format" to
                            MultipartField.of(TranslationCreateParams.ResponseFormat.JSON),
                        "temperature" to MultipartField.of(0.0),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TranslationCreateParams.builder()
                .file("some content".toByteArray())
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
                        "file" to MultipartField.of("some content".toByteArray()),
                        "model" to MultipartField.of(AudioModel.WHISPER_1),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
