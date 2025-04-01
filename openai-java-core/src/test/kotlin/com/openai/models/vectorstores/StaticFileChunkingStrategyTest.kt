// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StaticFileChunkingStrategyTest {

    @Test
    fun create() {
        val staticFileChunkingStrategy =
            StaticFileChunkingStrategy.builder()
                .chunkOverlapTokens(0L)
                .maxChunkSizeTokens(100L)
                .build()

        assertThat(staticFileChunkingStrategy.chunkOverlapTokens()).isEqualTo(0L)
        assertThat(staticFileChunkingStrategy.maxChunkSizeTokens()).isEqualTo(100L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val staticFileChunkingStrategy =
            StaticFileChunkingStrategy.builder()
                .chunkOverlapTokens(0L)
                .maxChunkSizeTokens(100L)
                .build()

        val roundtrippedStaticFileChunkingStrategy =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(staticFileChunkingStrategy),
                jacksonTypeRef<StaticFileChunkingStrategy>(),
            )

        assertThat(roundtrippedStaticFileChunkingStrategy).isEqualTo(staticFileChunkingStrategy)
    }
}
