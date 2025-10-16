// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.VectorStoreCreateParams
import com.openai.models.vectorstores.VectorStoreSearchParams
import com.openai.models.vectorstores.VectorStoreUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VectorStoreServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.vectorStores()

        val vectorStore =
            vectorStoreService.create(
                VectorStoreCreateParams.builder()
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .description("description")
                    .expiresAfter(VectorStoreCreateParams.ExpiresAfter.builder().days(1L).build())
                    .addFileId("string")
                    .metadata(
                        VectorStoreCreateParams.Metadata.builder()
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
        val vectorStoreService = client.vectorStores()

        val vectorStore = vectorStoreService.retrieve("vector_store_id")

        vectorStore.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.vectorStores()

        val vectorStore =
            vectorStoreService.update(
                VectorStoreUpdateParams.builder()
                    .vectorStoreId("vector_store_id")
                    .expiresAfter(VectorStoreUpdateParams.ExpiresAfter.builder().days(1L).build())
                    .metadata(
                        VectorStoreUpdateParams.Metadata.builder()
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
        val vectorStoreService = client.vectorStores()

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
        val vectorStoreService = client.vectorStores()

        val vectorStoreDeleted = vectorStoreService.delete("vector_store_id")

        vectorStoreDeleted.validate()
    }

    @Test
    fun search() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val vectorStoreService = client.vectorStores()

        val page =
            vectorStoreService.search(
                VectorStoreSearchParams.builder().vectorStoreId("vs_abc123").query("string").build()
            )

        page.response().validate()
    }
}
