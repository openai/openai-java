// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentReadyEventTest {

    @Test
    fun create() {
        val agentSessionEnvironmentReadyEvent =
            AgentSessionEnvironmentReadyEvent.builder()
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

        assertThat(agentSessionEnvironmentReadyEvent.environment())
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
        assertThat(agentSessionEnvironmentReadyEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionEnvironmentReadyEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionEnvironmentReadyEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEnvironmentReadyEvent =
            AgentSessionEnvironmentReadyEvent.builder()
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

        val roundtrippedAgentSessionEnvironmentReadyEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentReadyEvent),
                jacksonTypeRef<AgentSessionEnvironmentReadyEvent>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentReadyEvent)
            .isEqualTo(agentSessionEnvironmentReadyEvent)
    }
}
