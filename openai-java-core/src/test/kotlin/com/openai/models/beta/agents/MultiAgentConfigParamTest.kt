// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiAgentConfigParamTest {

    @Test
    fun create() {
        val multiAgentConfigParam =
            MultiAgentConfigParam.builder().enabled(true).maxConcurrentSubagents(1L).build()

        assertThat(multiAgentConfigParam.enabled()).isEqualTo(true)
        assertThat(multiAgentConfigParam.maxConcurrentSubagents()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val multiAgentConfigParam =
            MultiAgentConfigParam.builder().enabled(true).maxConcurrentSubagents(1L).build()

        val roundtrippedMultiAgentConfigParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiAgentConfigParam),
                jacksonTypeRef<MultiAgentConfigParam>(),
            )

        assertThat(roundtrippedMultiAgentConfigParam).isEqualTo(multiAgentConfigParam)
    }
}
