// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.sessions.turns.Turn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTurnInProgressEventTest {

    @Test
    fun create() {
        val agentSessionTurnInProgressEvent =
            AgentSessionTurnInProgressEvent.builder()
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

        assertThat(agentSessionTurnInProgressEvent.eventId()).isEqualTo("event_id")
        assertThat(agentSessionTurnInProgressEvent.sessionId()).isEqualTo("session_id")
        assertThat(agentSessionTurnInProgressEvent.turn())
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
        assertThat(agentSessionTurnInProgressEvent.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionTurnInProgressEvent =
            AgentSessionTurnInProgressEvent.builder()
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

        val roundtrippedAgentSessionTurnInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionTurnInProgressEvent),
                jacksonTypeRef<AgentSessionTurnInProgressEvent>(),
            )

        assertThat(roundtrippedAgentSessionTurnInProgressEvent)
            .isEqualTo(agentSessionTurnInProgressEvent)
    }
}
