// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentDisconnectedEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionEnvironmentDisconnectedEvent =
            AgentSessionEnvironmentDisconnectedEvent.builder()
                .environment(
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
                )
                .eventId("event_id")
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionEnvironmentDisconnectedEvent.environment())
            .contains(
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
            )
        assertThat(agentSessionEnvironmentDisconnectedEvent.eventId()).contains("event_id")
        assertThat(agentSessionEnvironmentDisconnectedEvent.sessionId()).contains("session_id")
        assertThat(agentSessionEnvironmentDisconnectedEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionEnvironmentDisconnectedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentDisconnectedEvent),
                jacksonTypeRef<AgentSessionEnvironmentDisconnectedEvent>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentDisconnectedEvent)
            .isEqualTo(agentSessionEnvironmentDisconnectedEvent)
    }
}
