// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnReasoningSummaryTextDeltaEventTest {

    @Test
    fun create() {
        val agentSessionTurnReasoningSummaryTextDeltaEvent =
            AgentSessionTurnReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.sessionId())
            .isEqualTo("session_id")
        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.summaryIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnReasoningSummaryTextDeltaEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnReasoningSummaryTextDeltaEvent =
            AgentSessionTurnReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnReasoningSummaryTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnReasoningSummaryTextDeltaEvent),
                jacksonTypeRef<AgentSessionTurnReasoningSummaryTextDeltaEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnReasoningSummaryTextDeltaEvent)
            .isEqualTo(agentSessionTurnReasoningSummaryTextDeltaEvent)
    }
}
