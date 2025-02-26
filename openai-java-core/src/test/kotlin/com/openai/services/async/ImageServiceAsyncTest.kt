// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.ImageGenerateParams
import com.openai.models.ImageModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ImageServiceAsyncTest {

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
                    .model(ImageModel.DALL_E_2)
                    .n(1L)
                    .quality(ImageGenerateParams.Quality.STANDARD)
                    .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                    .size(ImageGenerateParams.Size._256X256)
                    .style(ImageGenerateParams.Style.VIVID)
                    .user("user-1234")
                    .build()
            )

        val imagesResponse = imagesResponseFuture.get()
        imagesResponse.validate()
    }
}
