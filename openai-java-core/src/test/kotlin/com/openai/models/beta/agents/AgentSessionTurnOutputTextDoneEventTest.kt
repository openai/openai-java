// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnOutputTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionTurnOutputTextDoneEvent =
            AgentSessionTurnOutputTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .text("text")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnOutputTextDoneEvent.contentIndex()).contains(0L)
        assertThat(agentSessionTurnOutputTextDoneEvent.eventId()).contains("event_id")
        assertThat(agentSessionTurnOutputTextDoneEvent.itemId()).contains("item_id")
        assertThat(agentSessionTurnOutputTextDoneEvent.outputIndex()).contains(0L)
        assertThat(agentSessionTurnOutputTextDoneEvent.sessionId()).contains("session_id")
        assertThat(agentSessionTurnOutputTextDoneEvent.text()).contains("text")
        assertThat(agentSessionTurnOutputTextDoneEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionTurnOutputTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnOutputTextDoneEvent),
                jacksonTypeRef<AgentSessionTurnOutputTextDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnOutputTextDoneEvent)
            .isEqualTo(agentSessionTurnOutputTextDoneEvent)
    }
}
