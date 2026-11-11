// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentOutputCommandExecutionOutputDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentOutputCommandExecutionOutputDeltaEvent =
            AgentOutputCommandExecutionOutputDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentOutputCommandExecutionOutputDeltaEvent.delta()).contains("delta")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.eventId()).contains("event_id")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.itemId()).contains("item_id")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.outputIndex()).contains(0L)
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.sessionId()).contains("session_id")
        assertThat(agentOutputCommandExecutionOutputDeltaEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentOutputCommandExecutionOutputDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputCommandExecutionOutputDeltaEvent),
                jacksonTypeRef<AgentOutputCommandExecutionOutputDeltaEvent>(),
            )

        assertThat(roundtrippedAgentOutputCommandExecutionOutputDeltaEvent)
            .isEqualTo(agentOutputCommandExecutionOutputDeltaEvent)
    }
}
