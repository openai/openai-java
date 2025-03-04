// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.MultipartField
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageCreateVariationParamsTest {

    @Test
    fun create() {
        ImageCreateVariationParams.builder()
            .image("some content".toByteArray())
            .model(ImageModel.DALL_E_2)
            .n(1L)
            .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
            .size(ImageCreateVariationParams.Size._256X256)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ImageCreateVariationParams.builder()
                .image("some content".toByteArray())
                .model(ImageModel.DALL_E_2)
                .n(1L)
                .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
                .size(ImageCreateVariationParams.Size._256X256)
                .user("user-1234")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.filterValues { !it.value.isNull() })
            .isEqualTo(
                mapOf(
                    "image" to MultipartField.of("some content".toByteArray()),
                    "model" to MultipartField.of(ImageModel.DALL_E_2),
                    "n" to MultipartField.of(1L),
                    "response_format" to
                        MultipartField.of(ImageCreateVariationParams.ResponseFormat.URL),
                    "size" to MultipartField.of(ImageCreateVariationParams.Size._256X256),
                    "user" to MultipartField.of("user-1234"),
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ImageCreateVariationParams.builder().image("some content".toByteArray()).build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.filterValues { !it.value.isNull() })
            .isEqualTo(mapOf("image" to MultipartField.of("some content".toByteArray())))
    }
}
