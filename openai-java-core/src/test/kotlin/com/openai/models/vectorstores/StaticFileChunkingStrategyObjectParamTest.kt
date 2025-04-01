// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val staticFileChunkingStrategyObjectParam =
            StaticFileChunkingStrategyObjectParam.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        val roundtrippedStaticFileChunkingStrategyObjectParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(staticFileChunkingStrategyObjectParam),
                jacksonTypeRef<StaticFileChunkingStrategyObjectParam>(),
            )

        assertThat(roundtrippedStaticFileChunkingStrategyObjectParam)
            .isEqualTo(staticFileChunkingStrategyObjectParam)
    }
}
