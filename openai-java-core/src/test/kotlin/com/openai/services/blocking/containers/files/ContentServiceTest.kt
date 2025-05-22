// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.containers.files

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.containers.files.content.ContentRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contentService = client.containers().files().content()

        contentService.retrieve(
            ContentRetrieveParams.builder().containerId("container_id").fileId("file_id").build()
        )
    }
}
