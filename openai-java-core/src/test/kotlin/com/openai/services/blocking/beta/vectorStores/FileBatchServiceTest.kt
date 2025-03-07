// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.vectorStores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileBatchServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.beta().vectorStores().fileBatches()

        val vectorStoreFileBatch =
            fileBatchService.create(
                BetaVectorStoreFileBatchCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .addFileId("string")
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )

        vectorStoreFileBatch.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.beta().vectorStores().fileBatches()

        val vectorStoreFileBatch =
            fileBatchService.retrieve(
                BetaVectorStoreFileBatchRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .batchId("vsfb_abc123")
                    .build()
            )

        vectorStoreFileBatch.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.beta().vectorStores().fileBatches()

        val vectorStoreFileBatch =
            fileBatchService.cancel(
                BetaVectorStoreFileBatchCancelParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        vectorStoreFileBatch.validate()
    }

    @Test
    fun listFiles() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.beta().vectorStores().fileBatches()

        val page =
            fileBatchService.listFiles(
                BetaVectorStoreFileBatchListFilesParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        page.response().validate()
    }
}
