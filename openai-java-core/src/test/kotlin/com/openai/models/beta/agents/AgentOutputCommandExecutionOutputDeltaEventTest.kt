// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentOutputCommandExecutionOutputDeltaEventTest {

    @Test
    fun create() {
        val agentOutputCommandExecutionOutputDeltaEvent =
            AgentOutputCommandExecutionOutputDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentOutputCommandExecutionOutputDeltaEvent.delta()).isEqualTo("delta")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.turnId()).contains("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputCommandExecutionOutputDeltaEvent =
            AgentOutputCommandExecutionOutputDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val roundtrippedAgentOutputCommandExecutionOutputDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputCommandExecutionOutputDeltaEvent),
                jacksonTypeRef<AgentOutputCommandExecutionOutputDeltaEvent>(),
            )

        assertThat(roundtrippedAgentOutputCommandExecutionOutputDeltaEvent)
            .isEqualTo(agentOutputCommandExecutionOutputDeltaEvent)
    }
}
