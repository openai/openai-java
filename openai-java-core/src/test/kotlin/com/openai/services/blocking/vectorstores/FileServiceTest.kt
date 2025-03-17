// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
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
internal class FileServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.vectorStores().files()

        val vectorStoreFile =
            fileService.create(
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

        vectorStoreFile.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.vectorStores().files()

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
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.vectorStores().files()

        val vectorStoreFile =
            fileService.update(
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

        vectorStoreFile.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.vectorStores().files()

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
        val fileService = client.vectorStores().files()

        val vectorStoreFileDeleted =
            fileService.delete(
                FileDeleteParams.builder()
                    .vectorStoreId("vector_store_id")
                    .fileId("file_id")
                    .build()
            )

        vectorStoreFileDeleted.validate()
    }

    @Test
    fun content() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileService = client.vectorStores().files()

        val page =
            fileService.content(
                FileContentParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()
            )

        page.response().validate()
    }
}
