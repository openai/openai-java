// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnOutputTextDoneEventTest {

    @Test
    fun create() {
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

        assertThat(agentSessionTurnOutputTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnOutputTextDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnOutputTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnOutputTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnOutputTextDoneEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnOutputTextDoneEvent.text()).isEqualTo("text")
        assertThat(agentSessionTurnOutputTextDoneEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedAgentSessionTurnOutputTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnOutputTextDoneEvent),
                jacksonTypeRef<AgentSessionTurnOutputTextDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnOutputTextDoneEvent)
            .isEqualTo(agentSessionTurnOutputTextDoneEvent)
    }
}
