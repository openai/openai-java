// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnContentPartDoneEventTest {

    @Test
    fun create() {
        val agentSessionTurnContentPartDoneEvent =
            AgentSessionTurnContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(OutputText.builder().text("text").build())
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnContentPartDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnContentPartDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnContentPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnContentPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnContentPartDoneEvent.part())
            .isEqualTo(OutputText.builder().text("text").build())
        assertThat(agentSessionTurnContentPartDoneEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnContentPartDoneEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnContentPartDoneEvent =
            AgentSessionTurnContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(OutputText.builder().text("text").build())
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnContentPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnContentPartDoneEvent),
                jacksonTypeRef<AgentSessionTurnContentPartDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnContentPartDoneEvent)
            .isEqualTo(agentSessionTurnContentPartDoneEvent)
    }
}
