// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreFileBatchTest {

    @Test
    fun create() {
        val vectorStoreFileBatch =
            VectorStoreFileBatch.builder()
                .id("id")
                .createdAt(0L)
                .fileCounts(
                    VectorStoreFileBatch.FileCounts.builder()
                        .cancelled(0L)
                        .completed(0L)
                        .failed(0L)
                        .inProgress(0L)
                        .total(0L)
                        .build()
                )
                .status(VectorStoreFileBatch.Status.IN_PROGRESS)
                .vectorStoreId("vector_store_id")
                .build()

        assertThat(vectorStoreFileBatch.id()).isEqualTo("id")
        assertThat(vectorStoreFileBatch.createdAt()).isEqualTo(0L)
        assertThat(vectorStoreFileBatch.fileCounts())
            .isEqualTo(
                VectorStoreFileBatch.FileCounts.builder()
                    .cancelled(0L)
                    .completed(0L)
                    .failed(0L)
                    .inProgress(0L)
                    .total(0L)
                    .build()
            )
        assertThat(vectorStoreFileBatch.status()).isEqualTo(VectorStoreFileBatch.Status.IN_PROGRESS)
        assertThat(vectorStoreFileBatch.vectorStoreId()).isEqualTo("vector_store_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vectorStoreFileBatch =
            VectorStoreFileBatch.builder()
                .id("id")
                .createdAt(0L)
                .fileCounts(
                    VectorStoreFileBatch.FileCounts.builder()
                        .cancelled(0L)
                        .completed(0L)
                        .failed(0L)
                        .inProgress(0L)
                        .total(0L)
                        .build()
                )
                .status(VectorStoreFileBatch.Status.IN_PROGRESS)
                .vectorStoreId("vector_store_id")
                .build()

        val roundtrippedVectorStoreFileBatch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreFileBatch),
                jacksonTypeRef<VectorStoreFileBatch>(),
            )

        assertThat(roundtrippedVectorStoreFileBatch).isEqualTo(vectorStoreFileBatch)
    }
}
