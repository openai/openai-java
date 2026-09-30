// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentPendingEventTest {

    @Test
    fun create() {
        val agentSessionEnvironmentPendingEvent =
            AgentSessionEnvironmentPendingEvent.builder()
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

        assertThat(agentSessionEnvironmentPendingEvent.environment())
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
        assertThat(agentSessionEnvironmentPendingEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionEnvironmentPendingEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionEnvironmentPendingEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEnvironmentPendingEvent =
            AgentSessionEnvironmentPendingEvent.builder()
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

        val roundtrippedAgentSessionEnvironmentPendingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentPendingEvent),
                jacksonTypeRef<AgentSessionEnvironmentPendingEvent>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentPendingEvent)
            .isEqualTo(agentSessionEnvironmentPendingEvent)
    }
}
