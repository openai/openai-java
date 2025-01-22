// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StaticFileChunkingStrategyObjectParamTest {

    @Test
    fun createStaticFileChunkingStrategyObjectParam() {
        val staticFileChunkingStrategyObjectParam =
            StaticFileChunkingStrategyObjectParam.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()
        assertThat(staticFileChunkingStrategyObjectParam).isNotNull
        assertThat(staticFileChunkingStrategyObjectParam.static_())
            .isEqualTo(
                StaticFileChunkingStrategy.builder()
                    .chunkOverlapTokens(0L)
                    .maxChunkSizeTokens(100L)
                    .build()
            )
    }
}
