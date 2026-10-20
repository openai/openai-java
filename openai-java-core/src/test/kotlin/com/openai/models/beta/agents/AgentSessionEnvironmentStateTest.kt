// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentStateTest {

    @Test
    fun create() {
        val agentSessionEnvironmentState =
            AgentSessionEnvironmentState.builder()
                .id("id")
                .error(
                    AgentSessionEnvironmentState.Error.builder()
                        .code("code")
                        .message("message")
                        .type("type")
                        .build()
                )
                .status(AgentSessionEnvironmentState.Status.PENDING)
                .type("type")
                .build()

        assertThat(agentSessionEnvironmentState.id()).isEqualTo("id")
        assertThat(agentSessionEnvironmentState.error())
            .contains(
                AgentSessionEnvironmentState.Error.builder()
                    .code("code")
                    .message("message")
                    .type("type")
                    .build()
            )
        assertThat(agentSessionEnvironmentState.status())
            .isEqualTo(AgentSessionEnvironmentState.Status.PENDING)
        assertThat(agentSessionEnvironmentState.type()).isEqualTo("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEnvironmentState =
            AgentSessionEnvironmentState.builder()
                .id("id")
                .error(
                    AgentSessionEnvironmentState.Error.builder()
                        .code("code")
                        .message("message")
                        .type("type")
                        .build()
                )
                .status(AgentSessionEnvironmentState.Status.PENDING)
                .type("type")
                .build()

        val roundtrippedAgentSessionEnvironmentState =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentState),
                jacksonTypeRef<AgentSessionEnvironmentState>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentState).isEqualTo(agentSessionEnvironmentState)
    }
}
