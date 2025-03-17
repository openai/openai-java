// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.vectorstores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.files.FileContentParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileDeleteParams
import com.openai.models.vectorstores.files.FileListParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.FileUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.create(
                FileCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file_id")
                    .attributes(
                        FileCreateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
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
        val fileServiceAsync = client.vectorStores().files()

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
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.update(
                FileUpdateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file-abc123")
                    .attributes(
                        FileUpdateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
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
        val fileServiceAsync = client.vectorStores().files()

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
        val fileServiceAsync = client.vectorStores().files()

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

    @Test
    fun content() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val pageFuture =
            fileServiceAsync.content(
                FileContentParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
