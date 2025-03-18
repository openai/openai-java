// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StaticFileChunkingStrategyObjectParamTest {

    @Test
    fun create() {
        val staticFileChunkingStrategyObjectParam =
            StaticFileChunkingStrategyObjectParam.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        assertThat(staticFileChunkingStrategyObjectParam.static_())
            .isEqualTo(
                StaticFileChunkingStrategy.builder()
                    .chunkOverlapTokens(0L)
                    .maxChunkSizeTokens(100L)
                    .build()
            )
    }
}
