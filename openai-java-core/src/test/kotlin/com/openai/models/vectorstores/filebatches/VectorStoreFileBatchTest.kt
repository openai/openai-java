// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores.filebatches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreFileBatchTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(vectorStoreFileBatch.id()).contains("id")
        assertThat(vectorStoreFileBatch.createdAt()).contains(0L)
        assertThat(vectorStoreFileBatch.fileCounts())
            .contains(
                VectorStoreFileBatch.FileCounts.builder()
                    .cancelled(0L)
                    .completed(0L)
                    .failed(0L)
                    .inProgress(0L)
                    .total(0L)
                    .build()
            )
        assertThat(vectorStoreFileBatch.status()).contains(VectorStoreFileBatch.Status.IN_PROGRESS)
        assertThat(vectorStoreFileBatch.vectorStoreId()).contains("vector_store_id")

        val jsonMapper = jsonMapper()

        val roundtrippedVectorStoreFileBatch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreFileBatch),
                jacksonTypeRef<VectorStoreFileBatch>(),
            )

        assertThat(roundtrippedVectorStoreFileBatch).isEqualTo(vectorStoreFileBatch)
    }
}
