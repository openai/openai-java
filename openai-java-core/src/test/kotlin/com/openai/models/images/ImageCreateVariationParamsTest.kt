// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageCreateVariationParamsTest {

    @Test
    fun create() {
        ImageCreateVariationParams.builder()
            .image("some content".byteInputStream())
            .model(ImageModel.DALL_E_2)
            .n(1L)
            .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
            .size(ImageCreateVariationParams.Size._1024X1024)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ImageCreateVariationParams.builder()
                .image("some content".byteInputStream())
                .model(ImageModel.DALL_E_2)
                .n(1L)
                .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
                .size(ImageCreateVariationParams.Size._1024X1024)
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
                        "image" to MultipartField.of("some content".byteInputStream()),
                        "model" to MultipartField.of(ImageModel.DALL_E_2),
                        "n" to MultipartField.of(1L),
                        "response_format" to
                            MultipartField.of(ImageCreateVariationParams.ResponseFormat.URL),
                        "size" to MultipartField.of(ImageCreateVariationParams.Size._1024X1024),
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
            ImageCreateVariationParams.builder().image("some content".byteInputStream()).build()

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
                mapOf("image" to MultipartField.of("some content".byteInputStream())).mapValues {
                    (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }
}
