// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentResetEventTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionEnvironmentResetEvent =
            AgentSessionEnvironmentResetEvent.builder()
                .environmentId("environment_id")
                .eventId("event_id")
                .resetCount(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        assertThat(agentSessionEnvironmentResetEvent.environmentId()).isEqualTo("environment_id")
        assertThat(agentSessionEnvironmentResetEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionEnvironmentResetEvent.resetCount()).isEqualTo(0L)
        assertThat(agentSessionEnvironmentResetEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionEnvironmentResetEvent.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionEnvironmentResetEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEnvironmentResetEvent),
                jacksonTypeRef<AgentSessionEnvironmentResetEvent>(),
            )

        assertThat(roundtrippedAgentSessionEnvironmentResetEvent)
            .isEqualTo(agentSessionEnvironmentResetEvent)
    }
}
