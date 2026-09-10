// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnContentPartAddedEventTest {

    @Test
    fun create() {
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

        assertThat(agentSessionTurnContentPartAddedEvent.contentIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnContentPartAddedEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnContentPartAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(agentSessionTurnContentPartAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentSessionTurnContentPartAddedEvent.part())
            .isEqualTo(OutputText.builder().text("text").build())
        assertThat(agentSessionTurnContentPartAddedEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnContentPartAddedEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedAgentSessionTurnContentPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnContentPartAddedEvent),
                jacksonTypeRef<AgentSessionTurnContentPartAddedEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnContentPartAddedEvent)
            .isEqualTo(agentSessionTurnContentPartAddedEvent)
    }
}
