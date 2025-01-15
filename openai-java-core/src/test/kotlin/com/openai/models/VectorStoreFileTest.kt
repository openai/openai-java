// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreFileTest {

    @Test
    fun createVectorStoreFile() {
        val vectorStoreFile =
            VectorStoreFile.builder()
                .id("id")
                .createdAt(0L)
                .lastError(
                    VectorStoreFile.LastError.builder()
                        .code(VectorStoreFile.LastError.Code.SERVER_ERROR)
                        .message("message")
                        .build()
                )
                .object_(VectorStoreFile.Object.VECTOR_STORE_FILE)
                .status(VectorStoreFile.Status.IN_PROGRESS)
                .usageBytes(0L)
                .vectorStoreId("vector_store_id")
                .chunkingStrategy(
                    StaticFileChunkingStrategyObject.builder()
                        .static_(
                            StaticFileChunkingStrategy.builder()
                                .chunkOverlapTokens(0L)
                                .maxChunkSizeTokens(100L)
                                .build()
                        )
                        .type(StaticFileChunkingStrategyObject.Type.STATIC)
                        .build()
                )
                .build()
        assertThat(vectorStoreFile).isNotNull
        assertThat(vectorStoreFile.id()).isEqualTo("id")
        assertThat(vectorStoreFile.createdAt()).isEqualTo(0L)
        assertThat(vectorStoreFile.lastError())
            .contains(
                VectorStoreFile.LastError.builder()
                    .code(VectorStoreFile.LastError.Code.SERVER_ERROR)
                    .message("message")
                    .build()
            )
        assertThat(vectorStoreFile.object_()).isEqualTo(VectorStoreFile.Object.VECTOR_STORE_FILE)
        assertThat(vectorStoreFile.status()).isEqualTo(VectorStoreFile.Status.IN_PROGRESS)
        assertThat(vectorStoreFile.usageBytes()).isEqualTo(0L)
        assertThat(vectorStoreFile.vectorStoreId()).isEqualTo("vector_store_id")
        assertThat(vectorStoreFile.chunkingStrategy())
            .contains(
                FileChunkingStrategy.ofStaticFileChunkingStrategyObject(
                    StaticFileChunkingStrategyObject.builder()
                        .static_(
                            StaticFileChunkingStrategy.builder()
                                .chunkOverlapTokens(0L)
                                .maxChunkSizeTokens(100L)
                                .build()
                        )
                        .type(StaticFileChunkingStrategyObject.Type.STATIC)
                        .build()
                )
            )
    }
}
