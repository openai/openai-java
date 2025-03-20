// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageEditParamsTest {

    @Test
    fun create() {
        ImageEditParams.builder()
            .image("some content".toByteArray())
            .prompt("A cute baby sea otter wearing a beret")
            .mask("some content".toByteArray())
            .model(ImageModel.DALL_E_2)
            .n(1L)
            .responseFormat(ImageEditParams.ResponseFormat.URL)
            .size(ImageEditParams.Size._256X256)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ImageEditParams.builder()
                .image("some content".toByteArray())
                .prompt("A cute baby sea otter wearing a beret")
                .mask("some content".toByteArray())
                .model(ImageModel.DALL_E_2)
                .n(1L)
                .responseFormat(ImageEditParams.ResponseFormat.URL)
                .size(ImageEditParams.Size._256X256)
                .user("user-1234")
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
                        "image" to MultipartField.of("some content".toByteArray()),
                        "prompt" to MultipartField.of("A cute baby sea otter wearing a beret"),
                        "mask" to MultipartField.of("some content".toByteArray()),
                        "model" to MultipartField.of(ImageModel.DALL_E_2),
                        "n" to MultipartField.of(1L),
                        "response_format" to MultipartField.of(ImageEditParams.ResponseFormat.URL),
                        "size" to MultipartField.of(ImageEditParams.Size._256X256),
                        "user" to MultipartField.of("user-1234"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ImageEditParams.builder()
                .image("some content".toByteArray())
                .prompt("A cute baby sea otter wearing a beret")
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
                        "image" to MultipartField.of("some content".toByteArray()),
                        "prompt" to MultipartField.of("A cute baby sea otter wearing a beret"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
