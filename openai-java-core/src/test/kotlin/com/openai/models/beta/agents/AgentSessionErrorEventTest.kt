// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionErrorEventTest {

    @Test
    fun create() {
        val agentSessionErrorEvent =
            AgentSessionErrorEvent.builder()
                .error(
                    SessionError.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        assertThat(agentSessionErrorEvent.error())
            .isEqualTo(
                SessionError.builder()
                    .code("code")
                    .message("message")
                    .param("param")
                    .type("type")
                    .build()
            )
        assertThat(agentSessionErrorEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionErrorEvent.sessionId()).isEqualTo("session_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionErrorEvent =
            AgentSessionErrorEvent.builder()
                .error(
                    SessionError.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val roundtrippedAgentSessionErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionErrorEvent),
                jacksonTypeRef<AgentSessionErrorEvent>(),
            )

        assertThat(roundtrippedAgentSessionErrorEvent).isEqualTo(agentSessionErrorEvent)
    }
}
