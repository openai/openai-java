// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnOutputTextDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionTurnOutputTextDeltaEvent =
            AgentSessionTurnOutputTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnOutputTextDeltaEvent.contentIndex()).contains(0L)
        assertThat(agentSessionTurnOutputTextDeltaEvent.delta()).contains("delta")
        assertThat(agentSessionTurnOutputTextDeltaEvent.eventId()).contains("event_id")
        assertThat(agentSessionTurnOutputTextDeltaEvent.itemId()).contains("item_id")
        assertThat(agentSessionTurnOutputTextDeltaEvent.outputIndex()).contains(0L)
        assertThat(agentSessionTurnOutputTextDeltaEvent.sessionId()).contains("session_id")
        assertThat(agentSessionTurnOutputTextDeltaEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionTurnOutputTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnOutputTextDeltaEvent),
                jacksonTypeRef<AgentSessionTurnOutputTextDeltaEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnOutputTextDeltaEvent)
            .isEqualTo(agentSessionTurnOutputTextDeltaEvent)
    }
}
