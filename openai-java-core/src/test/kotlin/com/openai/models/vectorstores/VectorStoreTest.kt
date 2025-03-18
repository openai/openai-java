// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.JsonValue
import com.openai.models.Metadata
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreTest {

    @Test
    fun create() {
        val vectorStore =
            VectorStore.builder()
                .id("id")
                .createdAt(0L)
                .fileCounts(
                    VectorStore.FileCounts.builder()
                        .cancelled(0L)
                        .completed(0L)
                        .failed(0L)
                        .inProgress(0L)
                        .total(0L)
                        .build()
                )
                .lastActiveAt(0L)
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .status(VectorStore.Status.EXPIRED)
                .usageBytes(0L)
                .expiresAfter(VectorStore.ExpiresAfter.builder().days(1L).build())
                .expiresAt(0L)
                .build()

        assertThat(vectorStore.id()).isEqualTo("id")
        assertThat(vectorStore.createdAt()).isEqualTo(0L)
        assertThat(vectorStore.fileCounts())
            .isEqualTo(
                VectorStore.FileCounts.builder()
                    .cancelled(0L)
                    .completed(0L)
                    .failed(0L)
                    .inProgress(0L)
                    .total(0L)
                    .build()
            )
        assertThat(vectorStore.lastActiveAt()).contains(0L)
        assertThat(vectorStore.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(vectorStore.name()).isEqualTo("name")
        assertThat(vectorStore.status()).isEqualTo(VectorStore.Status.EXPIRED)
        assertThat(vectorStore.usageBytes()).isEqualTo(0L)
        assertThat(vectorStore.expiresAfter())
            .contains(VectorStore.ExpiresAfter.builder().days(1L).build())
        assertThat(vectorStore.expiresAt()).contains(0L)
    }
}
