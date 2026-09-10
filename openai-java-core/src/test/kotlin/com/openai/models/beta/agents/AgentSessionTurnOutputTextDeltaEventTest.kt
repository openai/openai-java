// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnOutputTextDeltaEventTest {

    @Test
    fun create() {
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

        assertThat(agentSessionTurnOutputTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnOutputTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(agentSessionTurnOutputTextDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnOutputTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnOutputTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnOutputTextDeltaEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnOutputTextDeltaEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedAgentSessionTurnOutputTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnOutputTextDeltaEvent),
                jacksonTypeRef<AgentSessionTurnOutputTextDeltaEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnOutputTextDeltaEvent)
            .isEqualTo(agentSessionTurnOutputTextDeltaEvent)
    }
}
