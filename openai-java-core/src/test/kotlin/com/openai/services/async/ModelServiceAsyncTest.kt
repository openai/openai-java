// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.models.ModelDeleteParams
import com.openai.models.models.ModelRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelServiceAsync = client.models()

        val modelFuture =
            modelServiceAsync.retrieve(ModelRetrieveParams.builder().model("gpt-4o-mini").build())

        val model = modelFuture.get()
        model.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelServiceAsync = client.models()

        val pageFuture = modelServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelServiceAsync = client.models()

        val modelDeletedFuture =
            modelServiceAsync.delete(
                ModelDeleteParams.builder().model("ft:gpt-4o-mini:acemeco:suffix:abc123").build()
            )

        val modelDeleted = modelDeletedFuture.get()
        modelDeleted.validate()
    }
}
