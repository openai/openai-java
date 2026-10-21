// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentReasoningTest {

    @Test
    fun createAndRoundtrip() {
        val agentReasoning =
            AgentReasoning.builder()
                .effort(AgentReasoning.Effort.NONE)
                .summary(AgentReasoning.Summary.CONCISE)
                .build()

        assertThat(agentReasoning.effort()).contains(AgentReasoning.Effort.NONE)
        assertThat(agentReasoning.summary()).contains(AgentReasoning.Summary.CONCISE)

        val jsonMapper = jsonMapper()

        val roundtrippedAgentReasoning =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentReasoning),
                jacksonTypeRef<AgentReasoning>(),
            )

        assertThat(roundtrippedAgentReasoning).isEqualTo(agentReasoning)
    }
}
