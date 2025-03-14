// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.vectorstores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.beta.vectorstores.files.FileCreateParams
import com.openai.models.beta.vectorstores.files.FileDeleteParams
import com.openai.models.beta.vectorstores.files.FileListParams
import com.openai.models.beta.vectorstores.files.FileRetrieveParams
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
                FileCreateParams.builder()
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
                FileRetrieveParams.builder()
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
            fileServiceAsync.list(FileListParams.builder().vectorStoreId("vector_store_id").build())

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
                FileDeleteParams.builder()
                    .vectorStoreId("vector_store_id")
                    .fileId("file_id")
                    .build()
            )

        val vectorStoreFileDeleted = vectorStoreFileDeletedFuture.get()
        vectorStoreFileDeleted.validate()
    }
}
