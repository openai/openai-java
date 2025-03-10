// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.uploads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.uploads.parts.PartCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PartServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val partService = client.uploads().parts()

        val uploadPart =
            partService.create(
                PartCreateParams.builder()
                    .uploadId("upload_abc123")
                    .data("some content".toByteArray())
                    .build()
            )

        uploadPart.validate()
    }
}
