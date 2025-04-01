// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StaticFileChunkingStrategyObjectTest {

    @Test
    fun create() {
        val staticFileChunkingStrategyObject =
            StaticFileChunkingStrategyObject.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        assertThat(staticFileChunkingStrategyObject.static_())
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
        val staticFileChunkingStrategyObject =
            StaticFileChunkingStrategyObject.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        val roundtrippedStaticFileChunkingStrategyObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(staticFileChunkingStrategyObject),
                jacksonTypeRef<StaticFileChunkingStrategyObject>(),
            )

        assertThat(roundtrippedStaticFileChunkingStrategyObject)
            .isEqualTo(staticFileChunkingStrategyObject)
    }
}
