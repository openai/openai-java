// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.vectorstores.StaticFileChunkingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListPageResponseTest {

    @Test
    fun create() {
        val fileListPageResponse =
            FileListPageResponse.builder()
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

        assertThat(fileListPageResponse.data())
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
        assertThat(fileListPageResponse.firstId()).isEqualTo("file-abc123")
        assertThat(fileListPageResponse.hasMore()).isEqualTo(false)
        assertThat(fileListPageResponse.lastId()).isEqualTo("file-abc456")
        assertThat(fileListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListPageResponse =
            FileListPageResponse.builder()
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

        val roundtrippedFileListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListPageResponse),
                jacksonTypeRef<FileListPageResponse>(),
            )

        assertThat(roundtrippedFileListPageResponse).isEqualTo(fileListPageResponse)
    }
}
