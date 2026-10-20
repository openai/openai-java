// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentReasoningParamTest {

    @Test
    fun create() {
        val agentReasoningParam =
            AgentReasoningParam.builder()
                .effort(AgentReasoningParam.Effort.NONE)
                .summary(AgentReasoningParam.Summary.CONCISE)
                .build()

        assertThat(agentReasoningParam.effort()).contains(AgentReasoningParam.Effort.NONE)
        assertThat(agentReasoningParam.summary()).contains(AgentReasoningParam.Summary.CONCISE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentReasoningParam =
            AgentReasoningParam.builder()
                .effort(AgentReasoningParam.Effort.NONE)
                .summary(AgentReasoningParam.Summary.CONCISE)
                .build()

        val roundtrippedAgentReasoningParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentReasoningParam),
                jacksonTypeRef<AgentReasoningParam>(),
            )

        assertThat(roundtrippedAgentReasoningParam).isEqualTo(agentReasoningParam)
    }
}
