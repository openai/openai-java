// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentBrowserOriginAccessParamTest {

    @Test
    fun create() {
        val agentBrowserOriginAccessParam =
            AgentBrowserOriginAccessParam.builder()
                .decision(AgentBrowserOriginAccessParam.Decision.APPROVE)
                .build()

        assertThat(agentBrowserOriginAccessParam.decision())
            .isEqualTo(AgentBrowserOriginAccessParam.Decision.APPROVE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentBrowserOriginAccessParam =
            AgentBrowserOriginAccessParam.builder()
                .decision(AgentBrowserOriginAccessParam.Decision.APPROVE)
                .build()

        val roundtrippedAgentBrowserOriginAccessParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentBrowserOriginAccessParam),
                jacksonTypeRef<AgentBrowserOriginAccessParam>(),
            )

        assertThat(roundtrippedAgentBrowserOriginAccessParam)
            .isEqualTo(agentBrowserOriginAccessParam)
    }
}
