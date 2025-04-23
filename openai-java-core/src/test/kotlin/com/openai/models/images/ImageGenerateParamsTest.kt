// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageGenerateParamsTest {

    @Test
    fun create() {
        ImageGenerateParams.builder()
            .prompt("A cute baby sea otter")
            .background(ImageGenerateParams.Background.TRANSPARENT)
            .model(ImageModel.DALL_E_2)
            .moderation(ImageGenerateParams.Moderation.LOW)
            .n(1L)
            .outputCompression(100L)
            .outputFormat(ImageGenerateParams.OutputFormat.PNG)
            .quality(ImageGenerateParams.Quality.MEDIUM)
            .responseFormat(ImageGenerateParams.ResponseFormat.URL)
            .size(ImageGenerateParams.Size._1024X1024)
            .style(ImageGenerateParams.Style.VIVID)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ImageGenerateParams.builder()
                .prompt("A cute baby sea otter")
                .background(ImageGenerateParams.Background.TRANSPARENT)
                .model(ImageModel.DALL_E_2)
                .moderation(ImageGenerateParams.Moderation.LOW)
                .n(1L)
                .outputCompression(100L)
                .outputFormat(ImageGenerateParams.OutputFormat.PNG)
                .quality(ImageGenerateParams.Quality.MEDIUM)
                .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                .size(ImageGenerateParams.Size._1024X1024)
                .style(ImageGenerateParams.Style.VIVID)
                .user("user-1234")
                .build()

        val body = params._body()

        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
        assertThat(body.background()).contains(ImageGenerateParams.Background.TRANSPARENT)
        assertThat(body.model()).contains(ImageModel.DALL_E_2)
        assertThat(body.moderation()).contains(ImageGenerateParams.Moderation.LOW)
        assertThat(body.n()).contains(1L)
        assertThat(body.outputCompression()).contains(100L)
        assertThat(body.outputFormat()).contains(ImageGenerateParams.OutputFormat.PNG)
        assertThat(body.quality()).contains(ImageGenerateParams.Quality.MEDIUM)
        assertThat(body.responseFormat()).contains(ImageGenerateParams.ResponseFormat.URL)
        assertThat(body.size()).contains(ImageGenerateParams.Size._1024X1024)
        assertThat(body.style()).contains(ImageGenerateParams.Style.VIVID)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ImageGenerateParams.builder().prompt("A cute baby sea otter").build()

        val body = params._body()

        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
    }
}
