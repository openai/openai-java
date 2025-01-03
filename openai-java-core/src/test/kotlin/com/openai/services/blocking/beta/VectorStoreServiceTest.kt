// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreListParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.FileChunkingStrategyParam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class VectorStoreServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()
        val vectorStore =
            vectorStoreService.create(
                BetaVectorStoreCreateParams.builder()
                    .chunkingStrategy(
                        FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                            AutoFileChunkingStrategyParam.builder()
                                .type(AutoFileChunkingStrategyParam.Type.AUTO)
                                .build()
                        )
                    )
                    .expiresAfter(
                        BetaVectorStoreCreateParams.ExpiresAfter.builder()
                            .anchor(BetaVectorStoreCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                            .days(1L)
                            .build()
                    )
                    .fileIds(listOf("string"))
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .name("name")
                    .build()
            )
        println(vectorStore)
        vectorStore.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()
        val vectorStore =
            vectorStoreService.retrieve(
                BetaVectorStoreRetrieveParams.builder().vectorStoreId("vector_store_id").build()
            )
        println(vectorStore)
        vectorStore.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()
        val vectorStore =
            vectorStoreService.update(
                BetaVectorStoreUpdateParams.builder()
                    .vectorStoreId("vector_store_id")
                    .expiresAfter(
                        BetaVectorStoreUpdateParams.ExpiresAfter.builder()
                            .anchor(BetaVectorStoreUpdateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                            .days(1L)
                            .build()
                    )
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .name("name")
                    .build()
            )
        println(vectorStore)
        vectorStore.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()
        val listVectorStoresResponse =
            vectorStoreService.list(BetaVectorStoreListParams.builder().build())
        println(listVectorStoresResponse)
        listVectorStoresResponse.data().forEach { it.validate() }
    }

    @Test
    fun callDelete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.beta().vectorStores()
        val vectorStoreDeleted =
            vectorStoreService.delete(
                BetaVectorStoreDeleteParams.builder().vectorStoreId("vector_store_id").build()
            )
        println(vectorStoreDeleted)
        vectorStoreDeleted.validate()
    }
}