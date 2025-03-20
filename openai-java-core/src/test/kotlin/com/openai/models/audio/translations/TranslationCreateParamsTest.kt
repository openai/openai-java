// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import com.openai.core.MultipartField
import com.openai.models.audio.AudioModel
import java.io.InputStream
import kotlin.test.assertNotNull
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
                    "prompt" to MultipartField.of("prompt"),
                    "response_format" to
                        MultipartField.of(TranslationCreateParams.ResponseFormat.JSON),
                    "temperature" to MultipartField.of(0.0),
                )
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
