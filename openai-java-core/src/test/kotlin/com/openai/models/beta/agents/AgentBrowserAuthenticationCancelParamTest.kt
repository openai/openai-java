// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentBrowserAuthenticationCancelParamTest {

    @Test
    fun create() {
        val agentBrowserAuthenticationCancelParam =
            AgentBrowserAuthenticationCancelParam.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentBrowserAuthenticationCancelParam =
            AgentBrowserAuthenticationCancelParam.builder().build()

        val roundtrippedAgentBrowserAuthenticationCancelParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentBrowserAuthenticationCancelParam),
                jacksonTypeRef<AgentBrowserAuthenticationCancelParam>(),
            )

        assertThat(roundtrippedAgentBrowserAuthenticationCancelParam)
            .isEqualTo(agentBrowserAuthenticationCancelParam)
    }
}
