// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.vectorStores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.AutoFileChunkingStrategyParam
import com.openai.models.BetaVectorStoreFileCreateParams
import com.openai.models.BetaVectorStoreFileDeleteParams
import com.openai.models.BetaVectorStoreFileListParams
import com.openai.models.BetaVectorStoreFileRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.beta().vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.create(
                BetaVectorStoreFileCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file_id")
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )

        val vectorStoreFile = vectorStoreFileFuture.get()
        vectorStoreFile.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.beta().vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.retrieve(
                BetaVectorStoreFileRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file-abc123")
                    .build()
            )

        val vectorStoreFile = vectorStoreFileFuture.get()
        vectorStoreFile.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.beta().vectorStores().files()

        val pageFuture =
            fileServiceAsync.list(
                BetaVectorStoreFileListParams.builder().vectorStoreId("vector_store_id").build()
            )

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
        val fileServiceAsync = client.beta().vectorStores().files()

        val vectorStoreFileDeletedFuture =
            fileServiceAsync.delete(
                BetaVectorStoreFileDeleteParams.builder()
                    .vectorStoreId("vector_store_id")
                    .fileId("file_id")
                    .build()
            )

        val vectorStoreFileDeleted = vectorStoreFileDeletedFuture.get()
        vectorStoreFileDeleted.validate()
    }
}
