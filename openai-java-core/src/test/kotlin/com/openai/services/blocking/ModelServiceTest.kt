// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.ModelDeleteParams
import com.openai.models.ModelRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ModelServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelService = client.models()
        val model =
            modelService.retrieve(ModelRetrieveParams.builder().model("gpt-4o-mini").build())
        println(model)
        model.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelService = client.models()
        val listModelsResponse = modelService.list()
        println(listModelsResponse)
        listModelsResponse.data().forEach { it.validate() }
    }

    @Test
    fun callDelete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelService = client.models()
        val modelDeleted =
            modelService.delete(
                ModelDeleteParams.builder().model("ft:gpt-4o-mini:acemeco:suffix:abc123").build()
            )
        println(modelDeleted)
        modelDeleted.validate()
    }
}
