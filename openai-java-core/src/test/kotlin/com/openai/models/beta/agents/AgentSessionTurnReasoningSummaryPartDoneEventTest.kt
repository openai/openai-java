// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnReasoningSummaryPartDoneEventTest {

    @Test
    fun create() {
        val agentSessionTurnReasoningSummaryPartDoneEvent =
            AgentSessionTurnReasoningSummaryPartDoneEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(SummaryText.builder().text("text").build())
                .sessionId("session_id")
                .status(AgentSessionTurnReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.part())
            .isEqualTo(SummaryText.builder().text("text").build())
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.sessionId())
            .isEqualTo("session_id")
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.status())
            .contains(AgentSessionTurnReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.summaryIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnReasoningSummaryPartDoneEvent =
            AgentSessionTurnReasoningSummaryPartDoneEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(SummaryText.builder().text("text").build())
                .sessionId("session_id")
                .status(AgentSessionTurnReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnReasoningSummaryPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnReasoningSummaryPartDoneEvent),
                jacksonTypeRef<AgentSessionTurnReasoningSummaryPartDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnReasoningSummaryPartDoneEvent)
            .isEqualTo(agentSessionTurnReasoningSummaryPartDoneEvent)
    }
}
