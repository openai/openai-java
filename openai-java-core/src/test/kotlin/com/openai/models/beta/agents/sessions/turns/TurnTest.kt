// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.turns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.SessionTurnError
import com.openai.models.beta.agents.TokenUsage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TurnTest {

    @Test
    fun create() {
        val turn =
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

        assertThat(turn.id()).isEqualTo("id")
        assertThat(turn.agentId()).isEqualTo("agent_id")
        assertThat(turn.completedAt()).contains(0L)
        assertThat(turn.createdAt()).isEqualTo(0L)
        assertThat(turn.error())
            .contains(
                SessionTurnError.builder()
                    .code(SessionTurnError.Code.CONTEXT_LENGTH_EXCEEDED)
                    .message("message")
                    .build()
            )
        assertThat(turn.object_()).isEqualTo(Turn.Object.AGENT_SESSION_TURN)
        assertThat(turn.sessionId()).isEqualTo("session_id")
        assertThat(turn.startedAt()).contains(0L)
        assertThat(turn.status()).isEqualTo(Turn.Status.QUEUED)
        assertThat(turn.subagentId()).contains("subagent_id")
        assertThat(turn.usage())
            .contains(
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val turn =
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

        val roundtrippedTurn =
            jsonMapper.readValue(jsonMapper.writeValueAsString(turn), jacksonTypeRef<Turn>())

        assertThat(roundtrippedTurn).isEqualTo(turn)
    }
}
