// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.vectorstores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
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
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.create(
                FileBatchCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .addFileId("string")
                    .attributes(
                        FileBatchCreateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
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
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.retrieve(
                FileBatchRetrieveParams.builder()
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
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.cancel(
                FileBatchCancelParams.builder()
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
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val pageFuture =
            fileBatchServiceAsync.listFiles(
                FileBatchListFilesParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
