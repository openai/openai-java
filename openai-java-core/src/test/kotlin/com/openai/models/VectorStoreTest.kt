// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreTest {

    @Test
    fun createVectorStore() {
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
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .status(VectorStore.Status.EXPIRED)
                .usageBytes(0L)
                .expiresAfter(VectorStore.ExpiresAfter.builder().days(1L).build())
                .expiresAt(0L)
                .build()
        assertThat(vectorStore).isNotNull
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
        assertThat(vectorStore._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(vectorStore.name()).isEqualTo("name")
        assertThat(vectorStore.status()).isEqualTo(VectorStore.Status.EXPIRED)
        assertThat(vectorStore.usageBytes()).isEqualTo(0L)
        assertThat(vectorStore.expiresAfter())
            .contains(VectorStore.ExpiresAfter.builder().days(1L).build())
        assertThat(vectorStore.expiresAt()).contains(0L)
    }
}
