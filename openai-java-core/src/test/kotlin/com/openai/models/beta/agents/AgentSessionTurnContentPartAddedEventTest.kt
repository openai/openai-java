// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnContentPartAddedEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionTurnContentPartAddedEvent =
            AgentSessionTurnContentPartAddedEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(OutputText.builder().text("text").build())
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnContentPartAddedEvent.contentIndex()).contains(0L)
        assertThat(agentSessionTurnContentPartAddedEvent.eventId()).contains("event_id")
        assertThat(agentSessionTurnContentPartAddedEvent.itemId()).contains("item_id")
        assertThat(agentSessionTurnContentPartAddedEvent.outputIndex()).contains(0L)
        assertThat(agentSessionTurnContentPartAddedEvent.part())
            .contains(OutputText.builder().text("text").build())
        assertThat(agentSessionTurnContentPartAddedEvent.sessionId()).contains("session_id")
        assertThat(agentSessionTurnContentPartAddedEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionTurnContentPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnContentPartAddedEvent),
                jacksonTypeRef<AgentSessionTurnContentPartAddedEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnContentPartAddedEvent)
            .isEqualTo(agentSessionTurnContentPartAddedEvent)
    }
}
