// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.containers.files

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.containers.files.content.ContentRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contentServiceAsync = client.containers().files().content()

        val future =
            contentServiceAsync.retrieve(
                ContentRetrieveParams.builder()
                    .containerId("container_id")
                    .fileId("file_id")
                    .build()
            )

        val response = future.get()
    }
}
