// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.models.vectorstores.FileChunkingStrategy
import com.openai.models.vectorstores.StaticFileChunkingStrategy
import com.openai.models.vectorstores.StaticFileChunkingStrategyObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreFileTest {

    @Test
    fun create() {
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

        assertThat(vectorStoreFile.id()).isEqualTo("id")
        assertThat(vectorStoreFile.createdAt()).isEqualTo(0L)
        assertThat(vectorStoreFile.lastError())
            .contains(
                VectorStoreFile.LastError.builder()
                    .code(VectorStoreFile.LastError.Code.SERVER_ERROR)
                    .message("message")
                    .build()
            )
        assertThat(vectorStoreFile.status()).isEqualTo(VectorStoreFile.Status.IN_PROGRESS)
        assertThat(vectorStoreFile.usageBytes()).isEqualTo(0L)
        assertThat(vectorStoreFile.vectorStoreId()).isEqualTo("vector_store_id")
        assertThat(vectorStoreFile.attributes())
            .contains(
                VectorStoreFile.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(vectorStoreFile.chunkingStrategy())
            .contains(
                FileChunkingStrategy.ofStatic(
                    StaticFileChunkingStrategyObject.builder()
                        .static_(
                            StaticFileChunkingStrategy.builder()
                                .chunkOverlapTokens(0L)
                                .maxChunkSizeTokens(100L)
                                .build()
                        )
                        .build()
                )
            )
    }
}
