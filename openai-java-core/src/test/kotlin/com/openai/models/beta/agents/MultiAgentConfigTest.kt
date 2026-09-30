// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiAgentConfigTest {

    @Test
    fun create() {
        val multiAgentConfig =
            MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build()

        assertThat(multiAgentConfig.enabled()).isEqualTo(true)
        assertThat(multiAgentConfig.maxConcurrentSubagents()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val multiAgentConfig =
            MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build()

        val roundtrippedMultiAgentConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiAgentConfig),
                jacksonTypeRef<MultiAgentConfig>(),
            )

        assertThat(roundtrippedMultiAgentConfig).isEqualTo(multiAgentConfig)
    }
}
