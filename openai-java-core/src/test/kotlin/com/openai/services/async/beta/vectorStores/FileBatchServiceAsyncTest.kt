// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.vectorStores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileBatchServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchServiceAsync = client.beta().vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.create(
                BetaVectorStoreFileBatchCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .addFileId("string")
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )

        val vectorStoreFileBatch = vectorStoreFileBatchFuture.get()
        vectorStoreFileBatch.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchServiceAsync = client.beta().vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.retrieve(
                BetaVectorStoreFileBatchRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .batchId("vsfb_abc123")
                    .build()
            )

        val vectorStoreFileBatch = vectorStoreFileBatchFuture.get()
        vectorStoreFileBatch.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchServiceAsync = client.beta().vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.cancel(
                BetaVectorStoreFileBatchCancelParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        val vectorStoreFileBatch = vectorStoreFileBatchFuture.get()
        vectorStoreFileBatch.validate()
    }

    @Test
    fun listFiles() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchServiceAsync = client.beta().vectorStores().fileBatches()

        val pageFuture =
            fileBatchServiceAsync.listFiles(
                BetaVectorStoreFileBatchListFilesParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
