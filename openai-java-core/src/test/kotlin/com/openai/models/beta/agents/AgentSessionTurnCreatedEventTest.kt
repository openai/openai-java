// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.sessions.turns.Turn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnCreatedEventTest {

    @Test
    fun create() {
        val agentSessionTurnCreatedEvent =
            AgentSessionTurnCreatedEvent.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .turn(
                    Turn.builder()
                        .id("id")
                        .agentId("agent_id")
                        .completedAt(0L)
                        .createdAt(0L)
                        .error(
                            SessionTurnError.builder()
                                .code(SessionTurnError.Code.CONTEXT_LENGTH_EXCEEDED)
                                .message("message")
                                .build()
                        )
                        .object_(Turn.Object.AGENT_SESSION_TURN)
                        .sessionId("session_id")
                        .startedAt(0L)
                        .status(Turn.Status.QUEUED)
                        .subagentId("subagent_id")
                        .usage(
                            TokenUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    TokenUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    TokenUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .turnId("turn_id")
                .build()

        assertThat(agentSessionTurnCreatedEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnCreatedEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnCreatedEvent.turn())
            .isEqualTo(
                Turn.builder()
                    .id("id")
                    .agentId("agent_id")
                    .completedAt(0L)
                    .createdAt(0L)
                    .error(
                        SessionTurnError.builder()
                            .code(SessionTurnError.Code.CONTEXT_LENGTH_EXCEEDED)
                            .message("message")
                            .build()
                    )
                    .object_(Turn.Object.AGENT_SESSION_TURN)
                    .sessionId("session_id")
                    .startedAt(0L)
                    .status(Turn.Status.QUEUED)
                    .subagentId("subagent_id")
                    .usage(
                        TokenUsage.builder()
                            .inputTokens(0L)
                            .inputTokensDetails(
                                TokenUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                            )
                            .outputTokens(0L)
                            .outputTokensDetails(
                                TokenUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                            )
                            .totalTokens(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(agentSessionTurnCreatedEvent.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnCreatedEvent =
            AgentSessionTurnCreatedEvent.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .turn(
                    Turn.builder()
                        .id("id")
                        .agentId("agent_id")
                        .completedAt(0L)
                        .createdAt(0L)
                        .error(
                            SessionTurnError.builder()
                                .code(SessionTurnError.Code.CONTEXT_LENGTH_EXCEEDED)
                                .message("message")
                                .build()
                        )
                        .object_(Turn.Object.AGENT_SESSION_TURN)
                        .sessionId("session_id")
                        .startedAt(0L)
                        .status(Turn.Status.QUEUED)
                        .subagentId("subagent_id")
                        .usage(
                            TokenUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    TokenUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    TokenUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionTurnCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnCreatedEvent),
                jacksonTypeRef<AgentSessionTurnCreatedEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnCreatedEvent).isEqualTo(agentSessionTurnCreatedEvent)
    }
}
