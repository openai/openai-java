// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.vectorstores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.beta.vectorstores.files.FileCreateParams
import com.openai.models.beta.vectorstores.files.FileDeleteParams
import com.openai.models.beta.vectorstores.files.FileListParams
import com.openai.models.beta.vectorstores.files.FileRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.beta().vectorStores().files()

        val vectorStoreFile =
            fileService.create(
                FileCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file_id")
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )

        vectorStoreFile.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.beta().vectorStores().files()

        val vectorStoreFile =
            fileService.retrieve(
                FileRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file-abc123")
                    .build()
            )

        vectorStoreFile.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.beta().vectorStores().files()

        val page =
            fileService.list(FileListParams.builder().vectorStoreId("vector_store_id").build())

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.beta().vectorStores().files()

        val vectorStoreFileDeleted =
            fileService.delete(
                FileDeleteParams.builder()
                    .vectorStoreId("vector_store_id")
                    .fileId("file_id")
                    .build()
            )

        vectorStoreFileDeleted.validate()
    }
}
