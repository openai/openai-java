// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores.filebatches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.vectorstores.StaticFileChunkingStrategy
import com.openai.models.vectorstores.files.VectorStoreFile
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchListFilesPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(fileBatchListFilesPageResponse.data().getOrNull())
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
        assertThat(fileBatchListFilesPageResponse.firstId()).contains("file-abc123")
        assertThat(fileBatchListFilesPageResponse.hasMore()).contains(false)
        assertThat(fileBatchListFilesPageResponse.lastId()).contains("file-abc456")
        assertThat(fileBatchListFilesPageResponse.object_()).contains("list")

        val jsonMapper = jsonMapper()

        val roundtrippedFileBatchListFilesPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileBatchListFilesPageResponse),
                jacksonTypeRef<FileBatchListFilesPageResponse>(),
            )

        assertThat(roundtrippedFileBatchListFilesPageResponse)
            .isEqualTo(fileBatchListFilesPageResponse)
    }
}
