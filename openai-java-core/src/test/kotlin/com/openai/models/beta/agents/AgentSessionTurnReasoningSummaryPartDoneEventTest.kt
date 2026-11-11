// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnReasoningSummaryPartDoneEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.eventId()).contains("event_id")
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.itemId()).contains("item_id")
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.outputIndex()).contains(0L)
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.part())
            .contains(SummaryText.builder().text("text").build())
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.sessionId()).contains("session_id")
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.status())
            .contains(JsonValue.from("incomplete"))
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.summaryIndex()).contains(0L)
        assertThat(agentSessionTurnReasoningSummaryPartDoneEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionTurnReasoningSummaryPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnReasoningSummaryPartDoneEvent),
                jacksonTypeRef<AgentSessionTurnReasoningSummaryPartDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnReasoningSummaryPartDoneEvent)
            .isEqualTo(agentSessionTurnReasoningSummaryPartDoneEvent)
    }
}
