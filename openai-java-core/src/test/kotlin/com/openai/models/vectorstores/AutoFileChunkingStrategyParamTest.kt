// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoFileChunkingStrategyParamTest {

    @Test
    fun createAndRoundtrip() {
        val autoFileChunkingStrategyParam = AutoFileChunkingStrategyParam.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedAutoFileChunkingStrategyParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(autoFileChunkingStrategyParam),
                jacksonTypeRef<AutoFileChunkingStrategyParam>(),
            )

        assertThat(roundtrippedAutoFileChunkingStrategyParam)
            .isEqualTo(autoFileChunkingStrategyParam)
    }
}
