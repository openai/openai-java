// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageGenerateParamsTest {

    @Test
    fun create() {
        ImageGenerateParams.builder()
            .prompt("A cute baby sea otter")
            .model(ImageModel.DALL_E_2)
            .n(1L)
            .quality(ImageGenerateParams.Quality.STANDARD)
            .responseFormat(ImageGenerateParams.ResponseFormat.URL)
            .size(ImageGenerateParams.Size._256X256)
            .style(ImageGenerateParams.Style.VIVID)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ImageGenerateParams.builder()
                .prompt("A cute baby sea otter")
                .model(ImageModel.DALL_E_2)
                .n(1L)
                .quality(ImageGenerateParams.Quality.STANDARD)
                .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                .size(ImageGenerateParams.Size._256X256)
                .style(ImageGenerateParams.Style.VIVID)
                .user("user-1234")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
        assertThat(body.model()).contains(ImageModel.DALL_E_2)
        assertThat(body.n()).contains(1L)
        assertThat(body.quality()).contains(ImageGenerateParams.Quality.STANDARD)
        assertThat(body.responseFormat()).contains(ImageGenerateParams.ResponseFormat.URL)
        assertThat(body.size()).contains(ImageGenerateParams.Size._256X256)
        assertThat(body.style()).contains(ImageGenerateParams.Style.VIVID)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ImageGenerateParams.builder().prompt("A cute baby sea otter").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
    }
}
