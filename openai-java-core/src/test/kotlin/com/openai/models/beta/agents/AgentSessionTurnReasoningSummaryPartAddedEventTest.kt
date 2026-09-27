// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnReasoningSummaryPartAddedEventTest {

    @Test
    fun create() {
        val agentSessionTurnReasoningSummaryPartAddedEvent =
            AgentSessionTurnReasoningSummaryPartAddedEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(SummaryText.builder().text("text").build())
                .sessionId("session_id")
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.part())
            .isEqualTo(SummaryText.builder().text("text").build())
        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.sessionId())
            .isEqualTo("session_id")
        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.summaryIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryPartAddedEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnReasoningSummaryPartAddedEvent =
            AgentSessionTurnReasoningSummaryPartAddedEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(SummaryText.builder().text("text").build())
                .sessionId("session_id")
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnReasoningSummaryPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnReasoningSummaryPartAddedEvent),
                jacksonTypeRef<AgentSessionTurnReasoningSummaryPartAddedEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnReasoningSummaryPartAddedEvent)
            .isEqualTo(agentSessionTurnReasoningSummaryPartAddedEvent)
    }
}
