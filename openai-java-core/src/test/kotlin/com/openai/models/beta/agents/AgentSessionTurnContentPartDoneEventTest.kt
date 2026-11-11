// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnContentPartDoneEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(agentSessionTurnContentPartDoneEvent.contentIndex()).contains(0L)
        assertThat(agentSessionTurnContentPartDoneEvent.eventId()).contains("event_id")
        assertThat(agentSessionTurnContentPartDoneEvent.itemId()).contains("item_id")
        assertThat(agentSessionTurnContentPartDoneEvent.outputIndex()).contains(0L)
        assertThat(agentSessionTurnContentPartDoneEvent.part())
            .contains(OutputText.builder().text("text").build())
        assertThat(agentSessionTurnContentPartDoneEvent.sessionId()).contains("session_id")
        assertThat(agentSessionTurnContentPartDoneEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionTurnContentPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnContentPartDoneEvent),
                jacksonTypeRef<AgentSessionTurnContentPartDoneEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnContentPartDoneEvent)
            .isEqualTo(agentSessionTurnContentPartDoneEvent)
    }
}
