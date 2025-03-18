// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileChunkingStrategyParamTest {

    @Test
    fun ofAuto() {
        val auto = AutoFileChunkingStrategyParam.builder().build()

        val fileChunkingStrategyParam = FileChunkingStrategyParam.ofAuto(auto)

        assertThat(fileChunkingStrategyParam.auto()).contains(auto)
        assertThat(fileChunkingStrategyParam.static_()).isEmpty
    }

    @Test
    fun ofStatic() {
        val static_ =
            StaticFileChunkingStrategyObjectParam.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        val fileChunkingStrategyParam = FileChunkingStrategyParam.ofStatic(static_)

        assertThat(fileChunkingStrategyParam.auto()).isEmpty
        assertThat(fileChunkingStrategyParam.static_()).contains(static_)
    }
}
