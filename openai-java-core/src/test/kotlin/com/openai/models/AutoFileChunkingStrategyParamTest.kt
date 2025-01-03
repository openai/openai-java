// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutoFileChunkingStrategyParamTest {

    @Test
    fun createAutoFileChunkingStrategyParam() {
        val autoFileChunkingStrategyParam =
            AutoFileChunkingStrategyParam.builder()
                .type(AutoFileChunkingStrategyParam.Type.AUTO)
                .build()
        assertThat(autoFileChunkingStrategyParam).isNotNull
        assertThat(autoFileChunkingStrategyParam.type())
            .isEqualTo(AutoFileChunkingStrategyParam.Type.AUTO)
    }
}
