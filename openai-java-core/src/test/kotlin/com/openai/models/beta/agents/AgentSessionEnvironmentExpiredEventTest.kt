// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentExpiredEventTest {

    @Test
    fun create() {
        val agentSessionEnvironmentExpiredEvent =
            AgentSessionEnvironmentExpiredEvent.builder()
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

        assertThat(agentSessionEnvironmentExpiredEvent.environment())
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
        assertThat(agentSessionEnvironmentExpiredEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionEnvironmentExpiredEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionEnvironmentExpiredEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEnvironmentExpiredEvent =
            AgentSessionEnvironmentExpiredEvent.builder()
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

        val roundtrippedAgentSessionEnvironmentExpiredEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentExpiredEvent),
                jacksonTypeRef<AgentSessionEnvironmentExpiredEvent>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentExpiredEvent)
            .isEqualTo(agentSessionEnvironmentExpiredEvent)
    }
}
