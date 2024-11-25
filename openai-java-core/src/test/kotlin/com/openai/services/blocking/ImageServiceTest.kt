// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ImageServiceTest {

    @Test
    fun callGenerate() {
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
                    .model(ImageGenerateParams.Model.DALL_E_2)
                    .n(1L)
                    .quality(ImageGenerateParams.Quality.STANDARD)
                    .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                    .size(ImageGenerateParams.Size._256X256)
                    .style(ImageGenerateParams.Style.VIVID)
                    .user("user-1234")
                    .build()
            )
        println(imagesResponse)
        imagesResponse.validate()
    }
}
