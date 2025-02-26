// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class VectorStoreServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreServiceAsync = client.beta().vectorStores()

        val vectorStoreFuture =
            vectorStoreServiceAsync.create(
                BetaVectorStoreCreateParams.builder()
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .expiresAfter(
                        BetaVectorStoreCreateParams.ExpiresAfter.builder().days(1L).build()
                    )
                    .addFileId("string")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )

        val vectorStore = vectorStoreFuture.get()
        vectorStore.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreServiceAsync = client.beta().vectorStores()

        val vectorStoreFuture =
            vectorStoreServiceAsync.retrieve(
                BetaVectorStoreRetrieveParams.builder().vectorStoreId("vector_store_id").build()
            )

        val vectorStore = vectorStoreFuture.get()
        vectorStore.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreServiceAsync = client.beta().vectorStores()

        val vectorStoreFuture =
            vectorStoreServiceAsync.update(
                BetaVectorStoreUpdateParams.builder()
                    .vectorStoreId("vector_store_id")
                    .expiresAfter(
                        BetaVectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build()
                    )
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )

        val vectorStore = vectorStoreFuture.get()
        vectorStore.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreServiceAsync = client.beta().vectorStores()

        val pageFuture = vectorStoreServiceAsync.list()

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
        val vectorStoreServiceAsync = client.beta().vectorStores()

        val vectorStoreDeletedFuture =
            vectorStoreServiceAsync.delete(
                BetaVectorStoreDeleteParams.builder().vectorStoreId("vector_store_id").build()
            )

        val vectorStoreDeleted = vectorStoreDeletedFuture.get()
        vectorStoreDeleted.validate()
    }
}
