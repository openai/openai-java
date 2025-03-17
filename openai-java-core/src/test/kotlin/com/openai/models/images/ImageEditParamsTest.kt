// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.openai.core.MultipartField
import java.io.InputStream
import kotlin.test.assertNotNull
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
                    "image" to MultipartField.of("some content".toByteArray()),
                    "prompt" to MultipartField.of("A cute baby sea otter wearing a beret"),
                    "mask" to MultipartField.of("some content".toByteArray()),
                    "model" to MultipartField.of(ImageModel.DALL_E_2),
                    "n" to MultipartField.of(1L),
                    "response_format" to MultipartField.of(ImageEditParams.ResponseFormat.URL),
                    "size" to MultipartField.of(ImageEditParams.Size._256X256),
                    "user" to MultipartField.of("user-1234"),
                )
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
                    "image" to MultipartField.of("some content".toByteArray()),
                    "prompt" to MultipartField.of("A cute baby sea otter wearing a beret"),
                )
            )
    }
}
