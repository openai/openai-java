// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnItemAddedEventTest {

    @Test
    fun create() {
        val agentSessionTurnItemAddedEvent =
            AgentSessionTurnItemAddedEvent.builder()
                .eventId("event_id")
                .item(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnItemAddedEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnItemAddedEvent.item())
            .isEqualTo(
                AgentSessionItem.ofMessage(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
            )
        assertThat(agentSessionTurnItemAddedEvent.outputIndex()).contains(0L)
        assertThat(agentSessionTurnItemAddedEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnItemAddedEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnItemAddedEvent =
            AgentSessionTurnItemAddedEvent.builder()
                .eventId("event_id")
                .item(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnItemAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnItemAddedEvent),
                jacksonTypeRef<AgentSessionTurnItemAddedEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnItemAddedEvent)
            .isEqualTo(agentSessionTurnItemAddedEvent)
    }
}
