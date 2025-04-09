// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.vectorstores.StaticFileChunkingStrategy
import com.openai.models.vectorstores.files.VectorStoreFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchListFilesPageResponseTest {

    @Test
    fun create() {
        val fileBatchListFilesPageResponse =
            FileBatchListFilesPageResponse.builder()
                .addData(
                    VectorStoreFile.builder()
                        .id("id")
                        .createdAt(0L)
                        .lastError(
                            VectorStoreFile.LastError.builder()
                                .code(VectorStoreFile.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .status(VectorStoreFile.Status.IN_PROGRESS)
                        .usageBytes(0L)
                        .vectorStoreId("vector_store_id")
                        .attributes(
                            VectorStoreFile.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .staticChunkingStrategy(
                            StaticFileChunkingStrategy.builder()
                                .chunkOverlapTokens(0L)
                                .maxChunkSizeTokens(100L)
                                .build()
                        )
                        .build()
                )
                .firstId("file-abc123")
                .hasMore(false)
                .lastId("file-abc456")
                .object_("list")
                .build()

        assertThat(fileBatchListFilesPageResponse.data())
            .containsExactly(
                VectorStoreFile.builder()
                    .id("id")
                    .createdAt(0L)
                    .lastError(
                        VectorStoreFile.LastError.builder()
                            .code(VectorStoreFile.LastError.Code.SERVER_ERROR)
                            .message("message")
                            .build()
                    )
                    .status(VectorStoreFile.Status.IN_PROGRESS)
                    .usageBytes(0L)
                    .vectorStoreId("vector_store_id")
                    .attributes(
                        VectorStoreFile.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .staticChunkingStrategy(
                        StaticFileChunkingStrategy.builder()
                            .chunkOverlapTokens(0L)
                            .maxChunkSizeTokens(100L)
                            .build()
                    )
                    .build()
            )
        assertThat(fileBatchListFilesPageResponse.firstId()).isEqualTo("file-abc123")
        assertThat(fileBatchListFilesPageResponse.hasMore()).isEqualTo(false)
        assertThat(fileBatchListFilesPageResponse.lastId()).isEqualTo("file-abc456")
        assertThat(fileBatchListFilesPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileBatchListFilesPageResponse =
            FileBatchListFilesPageResponse.builder()
                .addData(
                    VectorStoreFile.builder()
                        .id("id")
                        .createdAt(0L)
                        .lastError(
                            VectorStoreFile.LastError.builder()
                                .code(VectorStoreFile.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .status(VectorStoreFile.Status.IN_PROGRESS)
                        .usageBytes(0L)
                        .vectorStoreId("vector_store_id")
                        .attributes(
                            VectorStoreFile.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .staticChunkingStrategy(
                            StaticFileChunkingStrategy.builder()
                                .chunkOverlapTokens(0L)
                                .maxChunkSizeTokens(100L)
                                .build()
                        )
                        .build()
                )
                .firstId("file-abc123")
                .hasMore(false)
                .lastId("file-abc456")
                .object_("list")
                .build()

        val roundtrippedFileBatchListFilesPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileBatchListFilesPageResponse),
                jacksonTypeRef<FileBatchListFilesPageResponse>(),
            )

        assertThat(roundtrippedFileBatchListFilesPageResponse)
            .isEqualTo(fileBatchListFilesPageResponse)
    }
}
