// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.uploads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.uploads.parts.PartCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PartServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val partServiceAsync = client.uploads().parts()

        val uploadPartFuture =
            partServiceAsync.create(
                PartCreateParams.builder()
                    .uploadId("upload_abc123")
                    .data("some content".toByteArray())
                    .build()
            )

        val uploadPart = uploadPartFuture.get()
        uploadPart.validate()
    }
}
