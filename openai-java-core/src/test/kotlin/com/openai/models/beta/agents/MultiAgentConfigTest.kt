// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiAgentConfigTest {

    @Test
    fun createAndRoundtrip() {
        val multiAgentConfig =
            MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build()

        assertThat(multiAgentConfig.enabled()).isEqualTo(true)
        assertThat(multiAgentConfig.maxConcurrentSubagents()).contains(1L)

        val jsonMapper = jsonMapper()

        val roundtrippedMultiAgentConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiAgentConfig),
                jacksonTypeRef<MultiAgentConfig>(),
            )

        assertThat(roundtrippedMultiAgentConfig).isEqualTo(multiAgentConfig)
    }
}
