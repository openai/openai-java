// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StaticFileChunkingStrategyTest {

    @Test
    fun createStaticFileChunkingStrategy() {
        val staticFileChunkingStrategy =
            StaticFileChunkingStrategy.builder()
                .chunkOverlapTokens(0L)
                .maxChunkSizeTokens(100L)
                .build()
        assertThat(staticFileChunkingStrategy).isNotNull
        assertThat(staticFileChunkingStrategy.chunkOverlapTokens()).isEqualTo(0L)
        assertThat(staticFileChunkingStrategy.maxChunkSizeTokens()).isEqualTo(100L)
    }
}
