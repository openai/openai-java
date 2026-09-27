// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentTextParamTest {

    @Test
    fun create() {
        val agentTextParam =
            AgentTextParam.builder().formatText().verbosity(AgentTextParam.Verbosity.LOW).build()

        assertThat(agentTextParam.format()).contains(TextFormatParam.ofText())
        assertThat(agentTextParam.verbosity()).contains(AgentTextParam.Verbosity.LOW)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentTextParam =
            AgentTextParam.builder().formatText().verbosity(AgentTextParam.Verbosity.LOW).build()

        val roundtrippedAgentTextParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentTextParam),
                jacksonTypeRef<AgentTextParam>(),
            )

        assertThat(roundtrippedAgentTextParam).isEqualTo(agentTextParam)
    }
}
