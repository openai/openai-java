// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StaticFileChunkingStrategyObjectTest {

    @Test
    fun createStaticFileChunkingStrategyObject() {
        val staticFileChunkingStrategyObject =
            StaticFileChunkingStrategyObject.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()
        assertThat(staticFileChunkingStrategyObject).isNotNull
        assertThat(staticFileChunkingStrategyObject.static_())
            .isEqualTo(
                StaticFileChunkingStrategy.builder()
                    .chunkOverlapTokens(0L)
                    .maxChunkSizeTokens(100L)
                    .build()
            )
    }
}
