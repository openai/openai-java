// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StaticFileChunkingStrategyObjectTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedStaticFileChunkingStrategyObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(staticFileChunkingStrategyObject),
                jacksonTypeRef<StaticFileChunkingStrategyObject>(),
            )

        assertThat(roundtrippedStaticFileChunkingStrategyObject)
            .isEqualTo(staticFileChunkingStrategyObject)
    }
}
