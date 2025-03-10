// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImageModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ImageServiceTest {

    @Test
    fun createVariation() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val imageService = client.images()

        val imagesResponse =
            imageService.createVariation(
                ImageCreateVariationParams.builder()
                    .image("some content".toByteArray())
                    .model(ImageModel.DALL_E_2)
                    .n(1L)
                    .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
                    .size(ImageCreateVariationParams.Size._256X256)
                    .user("user-1234")
                    .build()
            )

        imagesResponse.validate()
    }

    @Test
    fun edit() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val imageService = client.images()

        val imagesResponse =
            imageService.edit(
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
            )

        imagesResponse.validate()
    }

    @Test
    fun generate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val imageService = client.images()

        val imagesResponse =
            imageService.generate(
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
            )

        imagesResponse.validate()
    }
}
