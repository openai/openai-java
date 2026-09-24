// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnItemDoneEventTest {

    @Test
    fun create() {
        val agentSessionTurnItemDoneEvent =
            AgentSessionTurnItemDoneEvent.builder()
                .eventId("event_id")
                .item(
                    AgentSessionAssistantMessage.builder()
                        .id("id")
                        .addContent(OutputText.builder().text("text").build())
                        .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnItemDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnItemDoneEvent.item())
            .isEqualTo(
                AgentOutputItem.ofMessage(
                    AgentSessionAssistantMessage.builder()
                        .id("id")
                        .addContent(OutputText.builder().text("text").build())
                        .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
            )
        assertThat(agentSessionTurnItemDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnItemDoneEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnItemDoneEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnItemDoneEvent =
            AgentSessionTurnItemDoneEvent.builder()
                .eventId("event_id")
                .item(
                    AgentSessionAssistantMessage.builder()
                        .id("id")
                        .addContent(OutputText.builder().text("text").build())
                        .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnItemDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnItemDoneEvent),
                jacksonTypeRef<AgentSessionTurnItemDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnItemDoneEvent)
            .isEqualTo(agentSessionTurnItemDoneEvent)
    }
}
