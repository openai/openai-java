// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionSubagentCreatedEventTest {

    @Test
    fun create() {
        val agentSessionSubagentCreatedEvent =
            AgentSessionSubagentCreatedEvent.builder()
                .eventId("event_id")
                .subagent(
                    Subagent.builder()
                        .id("id")
                        .closedAt(0L)
                        .addOutputTextInstruction("text")
                        .name("name")
                        .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                        .openedAt(0L)
                        .parentAgentId("parent_agent_id")
                        .sessionId("session_id")
                        .status(Subagent.Status.ACTIVE)
                        .build()
                )
                .build()

        assertThat(agentSessionSubagentCreatedEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionSubagentCreatedEvent.subagent())
            .isEqualTo(
                Subagent.builder()
                    .id("id")
                    .closedAt(0L)
                    .addOutputTextInstruction("text")
                    .name("name")
                    .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                    .openedAt(0L)
                    .parentAgentId("parent_agent_id")
                    .sessionId("session_id")
                    .status(Subagent.Status.ACTIVE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionSubagentCreatedEvent =
            AgentSessionSubagentCreatedEvent.builder()
                .eventId("event_id")
                .subagent(
                    Subagent.builder()
                        .id("id")
                        .closedAt(0L)
                        .addOutputTextInstruction("text")
                        .name("name")
                        .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                        .openedAt(0L)
                        .parentAgentId("parent_agent_id")
                        .sessionId("session_id")
                        .status(Subagent.Status.ACTIVE)
                        .build()
                )
                .build()

        val roundtrippedAgentSessionSubagentCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionSubagentCreatedEvent),
                jacksonTypeRef<AgentSessionSubagentCreatedEvent>(),
            )

        assertThat(roundtrippedAgentSessionSubagentCreatedEvent)
            .isEqualTo(agentSessionSubagentCreatedEvent)
    }
}
