// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StaticFileChunkingStrategyParamTest {

    @Test
    fun createStaticFileChunkingStrategyParam() {
        val staticFileChunkingStrategyParam =
            StaticFileChunkingStrategyParam.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .type(StaticFileChunkingStrategyParam.Type.STATIC)
                .build()
        assertThat(staticFileChunkingStrategyParam).isNotNull
        assertThat(staticFileChunkingStrategyParam.static_())
            .isEqualTo(
                StaticFileChunkingStrategy.builder()
                    .chunkOverlapTokens(0L)
                    .maxChunkSizeTokens(100L)
                    .build()
            )
        assertThat(staticFileChunkingStrategyParam.type())
            .isEqualTo(StaticFileChunkingStrategyParam.Type.STATIC)
    }
}
