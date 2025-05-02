// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImageModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ImageServiceAsyncTest {

    @Test
    fun createVariation() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val imageServiceAsync = client.images()

        val imagesResponseFuture =
            imageServiceAsync.createVariation(
                ImageCreateVariationParams.builder()
                    .image("some content".byteInputStream())
                    .model(ImageModel.DALL_E_2)
                    .n(1L)
                    .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
                    .size(ImageCreateVariationParams.Size._1024X1024)
                    .user("user-1234")
                    .build()
            )

        val imagesResponse = imagesResponseFuture.get()
        imagesResponse.validate()
    }

    @Test
    fun edit() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val imageServiceAsync = client.images()

        val imagesResponseFuture =
            imageServiceAsync.edit(
                ImageEditParams.builder()
                    .image("some content".byteInputStream())
                    .prompt("A cute baby sea otter wearing a beret")
                    .background(ImageEditParams.Background.TRANSPARENT)
                    .mask("some content".byteInputStream())
                    .model(ImageModel.DALL_E_2)
                    .n(1L)
                    .quality(ImageEditParams.Quality.HIGH)
                    .responseFormat(ImageEditParams.ResponseFormat.URL)
                    .size(ImageEditParams.Size._1024X1024)
                    .user("user-1234")
                    .build()
            )

        val imagesResponse = imagesResponseFuture.get()
        imagesResponse.validate()
    }

    @Test
    fun generate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val imageServiceAsync = client.images()

        val imagesResponseFuture =
            imageServiceAsync.generate(
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
            )

        val imagesResponse = imagesResponseFuture.get()
        imagesResponse.validate()
    }
}
