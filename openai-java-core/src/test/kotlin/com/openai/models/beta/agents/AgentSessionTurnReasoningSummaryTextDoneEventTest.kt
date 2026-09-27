// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnReasoningSummaryTextDoneEventTest {

    @Test
    fun create() {
        val agentSessionTurnReasoningSummaryTextDoneEvent =
            AgentSessionTurnReasoningSummaryTextDoneEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .summaryIndex(0L)
                .text("text")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.sessionId())
            .isEqualTo("session_id")
        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.summaryIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.text()).isEqualTo("text")
        assertThat(agentSessionTurnReasoningSummaryTextDoneEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnReasoningSummaryTextDoneEvent =
            AgentSessionTurnReasoningSummaryTextDoneEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .summaryIndex(0L)
                .text("text")
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnReasoningSummaryTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnReasoningSummaryTextDoneEvent),
                jacksonTypeRef<AgentSessionTurnReasoningSummaryTextDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnReasoningSummaryTextDoneEvent)
            .isEqualTo(agentSessionTurnReasoningSummaryTextDoneEvent)
    }
}
