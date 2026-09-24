// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentDisconnectedEventTest {

    @Test
    fun create() {
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
            .isEqualTo(
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
        assertThat(agentSessionEnvironmentDisconnectedEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionEnvironmentDisconnectedEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionEnvironmentDisconnectedEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedAgentSessionEnvironmentDisconnectedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentDisconnectedEvent),
                jacksonTypeRef<AgentSessionEnvironmentDisconnectedEvent>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentDisconnectedEvent)
            .isEqualTo(agentSessionEnvironmentDisconnectedEvent)
    }
}
