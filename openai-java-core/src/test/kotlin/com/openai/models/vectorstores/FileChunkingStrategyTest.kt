// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileChunkingStrategyTest {

    @Test
    fun ofStatic() {
        val static_ =
            StaticFileChunkingStrategyObject.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        val fileChunkingStrategy = FileChunkingStrategy.ofStatic(static_)

        assertThat(fileChunkingStrategy.static_()).contains(static_)
        assertThat(fileChunkingStrategy.other()).isEmpty
    }

    @Test
    fun ofOther() {
        val other = OtherFileChunkingStrategyObject.builder().build()

        val fileChunkingStrategy = FileChunkingStrategy.ofOther(other)

        assertThat(fileChunkingStrategy.static_()).isEmpty
        assertThat(fileChunkingStrategy.other()).contains(other)
    }
}
