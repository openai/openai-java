// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutoFileChunkingStrategyParamTest {

    @Test
    fun createAutoFileChunkingStrategyParam() {
        val autoFileChunkingStrategyParam = AutoFileChunkingStrategyParam.builder().build()
        assertThat(autoFileChunkingStrategyParam).isNotNull
    }
}
