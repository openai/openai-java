// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoFileChunkingStrategyParamTest {

    @Test
    fun create() {
        val autoFileChunkingStrategyParam = AutoFileChunkingStrategyParam.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val autoFileChunkingStrategyParam = AutoFileChunkingStrategyParam.builder().build()

        val roundtrippedAutoFileChunkingStrategyParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(autoFileChunkingStrategyParam),
                jacksonTypeRef<AutoFileChunkingStrategyParam>(),
            )

        assertThat(roundtrippedAutoFileChunkingStrategyParam)
            .isEqualTo(autoFileChunkingStrategyParam)
    }
}
