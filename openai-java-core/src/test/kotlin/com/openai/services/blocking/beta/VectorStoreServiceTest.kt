// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.beta.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.beta.vectorstores.VectorStoreCreateParams
import com.openai.models.beta.vectorstores.VectorStoreDeleteParams
import com.openai.models.beta.vectorstores.VectorStoreRetrieveParams
import com.openai.models.beta.vectorstores.VectorStoreUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class VectorStoreServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()

        val vectorStore =
            vectorStoreService.create(
                VectorStoreCreateParams.builder()
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .expiresAfter(VectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
                    .addFileId("string")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )

        vectorStore.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()

        val vectorStore =
            vectorStoreService.retrieve(
                VectorStoreRetrieveParams.builder().vectorStoreId("vector_store_id").build()
            )

        vectorStore.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()

        val vectorStore =
            vectorStoreService.update(
                VectorStoreUpdateParams.builder()
                    .vectorStoreId("vector_store_id")
                    .expiresAfter(VectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )

        vectorStore.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()

        val page = vectorStoreService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()

        val vectorStoreDeleted =
            vectorStoreService.delete(
                VectorStoreDeleteParams.builder().vectorStoreId("vector_store_id").build()
            )

        vectorStoreDeleted.validate()
    }
}
