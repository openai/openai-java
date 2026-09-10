// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.sessions.turns.Turn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AgentSessionEventTest {

    @Test
    fun ofError() {
        val error =
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

        val agentSessionEvent = AgentSessionEvent.ofError(error)

        assertThat(agentSessionEvent.error()).contains(error)
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofError(
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
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofEnvironmentReady() {
        val environmentReady =
            AgentSessionEnvironmentReadyEvent.builder()
                .environment(
                    AgentSessionEnvironmentState.builder()
                        .id("id")
                        .error(
                            AgentSessionEnvironmentState.Error.builder()
                                .code("code")
                                .message("message")
                                .type("type")
                                .build()
                        )
                        .status(AgentSessionEnvironmentState.Status.PENDING)
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofEnvironmentReady(environmentReady)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).contains(environmentReady)
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofEnvironmentReadyRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofEnvironmentReady(
                AgentSessionEnvironmentReadyEvent.builder()
                    .environment(
                        AgentSessionEnvironmentState.builder()
                            .id("id")
                            .error(
                                AgentSessionEnvironmentState.Error.builder()
                                    .code("code")
                                    .message("message")
                                    .type("type")
                                    .build()
                            )
                            .status(AgentSessionEnvironmentState.Status.PENDING)
                            .type("type")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofOutputCommandExecutionOutputDelta() {
        val outputCommandExecutionOutputDelta =
            AgentOutputCommandExecutionOutputDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent =
            AgentSessionEvent.ofOutputCommandExecutionOutputDelta(outputCommandExecutionOutputDelta)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta())
            .contains(outputCommandExecutionOutputDelta)
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofOutputCommandExecutionOutputDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofOutputCommandExecutionOutputDelta(
                AgentOutputCommandExecutionOutputDeltaEvent.builder()
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofCreated() {
        val created =
            AgentSessionCreatedEvent.builder()
                .eventId("event_id")
                .session(
                    AgentSession.builder()
                        .id("id")
                        .agent(
                            AgentSession.Agent.builder()
                                .id("id")
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .name("name")
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentTool.Function.builder()
                                        .deferLoading(true)
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentTool.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .createdAt(0L)
                        .environmentNone()
                        .error("error")
                        .lastActiveAt(0L)
                        .metadata(
                            AgentSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addRequiredAction(
                            AgentSession.RequiredAction.FunctionCall.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .callId("call_id")
                                .name("name")
                                .turnId("turn_id")
                                .build()
                        )
                        .status(AgentSession.Status.IDLE)
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
                        .addVaultId("string")
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofCreated(created)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).contains(created)
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofCreated(
                AgentSessionCreatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        AgentSession.builder()
                            .id("id")
                            .agent(
                                AgentSession.Agent.builder()
                                    .id("id")
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfig.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .name("name")
                                    .reasoning(
                                        AgentReasoning.builder()
                                            .effort(AgentReasoning.Effort.NONE)
                                            .summary(AgentReasoning.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                    .text(
                                        AgentText.builder()
                                            .formatText()
                                            .verbosity(AgentText.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentTool.Function.builder()
                                            .deferLoading(true)
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentTool.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .createdAt(0L)
                            .environmentNone()
                            .error("error")
                            .lastActiveAt(0L)
                            .metadata(
                                AgentSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addRequiredAction(
                                AgentSession.RequiredAction.FunctionCall.builder()
                                    .arguments(JsonValue.from(mapOf<String, Any>()))
                                    .callId("call_id")
                                    .name("name")
                                    .turnId("turn_id")
                                    .build()
                            )
                            .status(AgentSession.Status.IDLE)
                            .usage(
                                TokenUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
                            .addVaultId("string")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnCreated() {
        val turnCreated =
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

        val agentSessionEvent = AgentSessionEvent.ofTurnCreated(turnCreated)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).contains(turnCreated)
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnCreated(
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
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnInProgress() {
        val turnInProgress =
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

        val agentSessionEvent = AgentSessionEvent.ofTurnInProgress(turnInProgress)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).contains(turnInProgress)
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnInProgress(
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
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnCompleted() {
        val turnCompleted =
            AgentSessionTurnCompletedEvent.builder()
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

        val agentSessionEvent = AgentSessionEvent.ofTurnCompleted(turnCompleted)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).contains(turnCompleted)
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnCompleted(
                AgentSessionTurnCompletedEvent.builder()
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
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnFailed() {
        val turnFailed =
            AgentSessionTurnFailedEvent.builder()
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

        val agentSessionEvent = AgentSessionEvent.ofTurnFailed(turnFailed)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).contains(turnFailed)
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnFailed(
                AgentSessionTurnFailedEvent.builder()
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
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnCancelled() {
        val turnCancelled =
            AgentSessionTurnCancelledEvent.builder()
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

        val agentSessionEvent = AgentSessionEvent.ofTurnCancelled(turnCancelled)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).contains(turnCancelled)
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnCancelled(
                AgentSessionTurnCancelledEvent.builder()
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
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnItemAdded() {
        val turnItemAdded =
            AgentSessionTurnItemAddedEvent.builder()
                .eventId("event_id")
                .item(
                    AgentSessionMessage.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .phase(AgentSessionMessage.Phase.COMMENTARY)
                        .role(AgentSessionMessage.Role.USER)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofTurnItemAdded(turnItemAdded)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).contains(turnItemAdded)
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnItemAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnItemAdded(
                AgentSessionTurnItemAddedEvent.builder()
                    .eventId("event_id")
                    .item(
                        AgentSessionMessage.builder()
                            .id("id")
                            .addInputTextContent("text")
                            .phase(AgentSessionMessage.Phase.COMMENTARY)
                            .role(AgentSessionMessage.Role.USER)
                            .status(AgentOutputItemStatus.IN_PROGRESS)
                            .turnId("turn_id")
                            .build()
                    )
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofIdle() {
        val idle =
            AgentSessionIdleEvent.builder()
                .eventId("event_id")
                .session(
                    AgentSession.builder()
                        .id("id")
                        .agent(
                            AgentSession.Agent.builder()
                                .id("id")
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .name("name")
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentTool.Function.builder()
                                        .deferLoading(true)
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentTool.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .createdAt(0L)
                        .environmentNone()
                        .error("error")
                        .lastActiveAt(0L)
                        .metadata(
                            AgentSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addRequiredAction(
                            AgentSession.RequiredAction.FunctionCall.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .callId("call_id")
                                .name("name")
                                .turnId("turn_id")
                                .build()
                        )
                        .status(AgentSession.Status.IDLE)
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
                        .addVaultId("string")
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofIdle(idle)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).contains(idle)
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofIdleRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofIdle(
                AgentSessionIdleEvent.builder()
                    .eventId("event_id")
                    .session(
                        AgentSession.builder()
                            .id("id")
                            .agent(
                                AgentSession.Agent.builder()
                                    .id("id")
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfig.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .name("name")
                                    .reasoning(
                                        AgentReasoning.builder()
                                            .effort(AgentReasoning.Effort.NONE)
                                            .summary(AgentReasoning.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                    .text(
                                        AgentText.builder()
                                            .formatText()
                                            .verbosity(AgentText.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentTool.Function.builder()
                                            .deferLoading(true)
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentTool.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .createdAt(0L)
                            .environmentNone()
                            .error("error")
                            .lastActiveAt(0L)
                            .metadata(
                                AgentSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addRequiredAction(
                                AgentSession.RequiredAction.FunctionCall.builder()
                                    .arguments(JsonValue.from(mapOf<String, Any>()))
                                    .callId("call_id")
                                    .name("name")
                                    .turnId("turn_id")
                                    .build()
                            )
                            .status(AgentSession.Status.IDLE)
                            .usage(
                                TokenUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
                            .addVaultId("string")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofInProgress() {
        val inProgress =
            AgentSessionInProgressEvent.builder()
                .eventId("event_id")
                .session(
                    AgentSession.builder()
                        .id("id")
                        .agent(
                            AgentSession.Agent.builder()
                                .id("id")
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .name("name")
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentTool.Function.builder()
                                        .deferLoading(true)
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentTool.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .createdAt(0L)
                        .environmentNone()
                        .error("error")
                        .lastActiveAt(0L)
                        .metadata(
                            AgentSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addRequiredAction(
                            AgentSession.RequiredAction.FunctionCall.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .callId("call_id")
                                .name("name")
                                .turnId("turn_id")
                                .build()
                        )
                        .status(AgentSession.Status.IDLE)
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
                        .addVaultId("string")
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofInProgress(inProgress)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).contains(inProgress)
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofInProgress(
                AgentSessionInProgressEvent.builder()
                    .eventId("event_id")
                    .session(
                        AgentSession.builder()
                            .id("id")
                            .agent(
                                AgentSession.Agent.builder()
                                    .id("id")
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfig.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .name("name")
                                    .reasoning(
                                        AgentReasoning.builder()
                                            .effort(AgentReasoning.Effort.NONE)
                                            .summary(AgentReasoning.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                    .text(
                                        AgentText.builder()
                                            .formatText()
                                            .verbosity(AgentText.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentTool.Function.builder()
                                            .deferLoading(true)
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentTool.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .createdAt(0L)
                            .environmentNone()
                            .error("error")
                            .lastActiveAt(0L)
                            .metadata(
                                AgentSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addRequiredAction(
                                AgentSession.RequiredAction.FunctionCall.builder()
                                    .arguments(JsonValue.from(mapOf<String, Any>()))
                                    .callId("call_id")
                                    .name("name")
                                    .turnId("turn_id")
                                    .build()
                            )
                            .status(AgentSession.Status.IDLE)
                            .usage(
                                TokenUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
                            .addVaultId("string")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofRequiresAction() {
        val requiresAction =
            AgentSessionRequiresActionEvent.builder()
                .eventId("event_id")
                .session(
                    AgentSession.builder()
                        .id("id")
                        .agent(
                            AgentSession.Agent.builder()
                                .id("id")
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .name("name")
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentTool.Function.builder()
                                        .deferLoading(true)
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentTool.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .createdAt(0L)
                        .environmentNone()
                        .error("error")
                        .lastActiveAt(0L)
                        .metadata(
                            AgentSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addRequiredAction(
                            AgentSession.RequiredAction.FunctionCall.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .callId("call_id")
                                .name("name")
                                .turnId("turn_id")
                                .build()
                        )
                        .status(AgentSession.Status.IDLE)
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
                        .addVaultId("string")
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofRequiresAction(requiresAction)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).contains(requiresAction)
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofRequiresActionRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofRequiresAction(
                AgentSessionRequiresActionEvent.builder()
                    .eventId("event_id")
                    .session(
                        AgentSession.builder()
                            .id("id")
                            .agent(
                                AgentSession.Agent.builder()
                                    .id("id")
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfig.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .name("name")
                                    .reasoning(
                                        AgentReasoning.builder()
                                            .effort(AgentReasoning.Effort.NONE)
                                            .summary(AgentReasoning.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                    .text(
                                        AgentText.builder()
                                            .formatText()
                                            .verbosity(AgentText.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentTool.Function.builder()
                                            .deferLoading(true)
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentTool.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .createdAt(0L)
                            .environmentNone()
                            .error("error")
                            .lastActiveAt(0L)
                            .metadata(
                                AgentSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addRequiredAction(
                                AgentSession.RequiredAction.FunctionCall.builder()
                                    .arguments(JsonValue.from(mapOf<String, Any>()))
                                    .callId("call_id")
                                    .name("name")
                                    .turnId("turn_id")
                                    .build()
                            )
                            .status(AgentSession.Status.IDLE)
                            .usage(
                                TokenUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
                            .addVaultId("string")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofFailed() {
        val failed =
            AgentSessionFailedEvent.builder()
                .eventId("event_id")
                .session(
                    AgentSession.builder()
                        .id("id")
                        .agent(
                            AgentSession.Agent.builder()
                                .id("id")
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .name("name")
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentTool.Function.builder()
                                        .deferLoading(true)
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentTool.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .createdAt(0L)
                        .environmentNone()
                        .error("error")
                        .lastActiveAt(0L)
                        .metadata(
                            AgentSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addRequiredAction(
                            AgentSession.RequiredAction.FunctionCall.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .callId("call_id")
                                .name("name")
                                .turnId("turn_id")
                                .build()
                        )
                        .status(AgentSession.Status.IDLE)
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
                        .addVaultId("string")
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofFailed(failed)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).contains(failed)
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofFailed(
                AgentSessionFailedEvent.builder()
                    .eventId("event_id")
                    .session(
                        AgentSession.builder()
                            .id("id")
                            .agent(
                                AgentSession.Agent.builder()
                                    .id("id")
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfig.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .name("name")
                                    .reasoning(
                                        AgentReasoning.builder()
                                            .effort(AgentReasoning.Effort.NONE)
                                            .summary(AgentReasoning.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(AgentSession.Agent.ServiceTier.AUTO)
                                    .text(
                                        AgentText.builder()
                                            .formatText()
                                            .verbosity(AgentText.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentTool.Function.builder()
                                            .deferLoading(true)
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentTool.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .createdAt(0L)
                            .environmentNone()
                            .error("error")
                            .lastActiveAt(0L)
                            .metadata(
                                AgentSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addRequiredAction(
                                AgentSession.RequiredAction.FunctionCall.builder()
                                    .arguments(JsonValue.from(mapOf<String, Any>()))
                                    .callId("call_id")
                                    .name("name")
                                    .turnId("turn_id")
                                    .build()
                            )
                            .status(AgentSession.Status.IDLE)
                            .usage(
                                TokenUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        TokenUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
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
                            .addVaultId("string")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofEnvironmentPending() {
        val environmentPending =
            AgentSessionEnvironmentPendingEvent.builder()
                .environment(
                    AgentSessionEnvironmentState.builder()
                        .id("id")
                        .error(
                            AgentSessionEnvironmentState.Error.builder()
                                .code("code")
                                .message("message")
                                .type("type")
                                .build()
                        )
                        .status(AgentSessionEnvironmentState.Status.PENDING)
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofEnvironmentPending(environmentPending)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).contains(environmentPending)
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofEnvironmentPendingRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofEnvironmentPending(
                AgentSessionEnvironmentPendingEvent.builder()
                    .environment(
                        AgentSessionEnvironmentState.builder()
                            .id("id")
                            .error(
                                AgentSessionEnvironmentState.Error.builder()
                                    .code("code")
                                    .message("message")
                                    .type("type")
                                    .build()
                            )
                            .status(AgentSessionEnvironmentState.Status.PENDING)
                            .type("type")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofEnvironmentConnected() {
        val environmentConnected =
            AgentSessionEnvironmentConnectedEvent.builder()
                .environment(
                    AgentSessionEnvironmentState.builder()
                        .id("id")
                        .error(
                            AgentSessionEnvironmentState.Error.builder()
                                .code("code")
                                .message("message")
                                .type("type")
                                .build()
                        )
                        .status(AgentSessionEnvironmentState.Status.PENDING)
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofEnvironmentConnected(environmentConnected)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).contains(environmentConnected)
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofEnvironmentConnectedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofEnvironmentConnected(
                AgentSessionEnvironmentConnectedEvent.builder()
                    .environment(
                        AgentSessionEnvironmentState.builder()
                            .id("id")
                            .error(
                                AgentSessionEnvironmentState.Error.builder()
                                    .code("code")
                                    .message("message")
                                    .type("type")
                                    .build()
                            )
                            .status(AgentSessionEnvironmentState.Status.PENDING)
                            .type("type")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofEnvironmentDisconnected() {
        val environmentDisconnected =
            AgentSessionEnvironmentDisconnectedEvent.builder()
                .environment(
                    AgentSessionEnvironmentState.builder()
                        .id("id")
                        .error(
                            AgentSessionEnvironmentState.Error.builder()
                                .code("code")
                                .message("message")
                                .type("type")
                                .build()
                        )
                        .status(AgentSessionEnvironmentState.Status.PENDING)
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofEnvironmentDisconnected(environmentDisconnected)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).contains(environmentDisconnected)
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofEnvironmentDisconnectedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofEnvironmentDisconnected(
                AgentSessionEnvironmentDisconnectedEvent.builder()
                    .environment(
                        AgentSessionEnvironmentState.builder()
                            .id("id")
                            .error(
                                AgentSessionEnvironmentState.Error.builder()
                                    .code("code")
                                    .message("message")
                                    .type("type")
                                    .build()
                            )
                            .status(AgentSessionEnvironmentState.Status.PENDING)
                            .type("type")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofEnvironmentFailed() {
        val environmentFailed =
            AgentSessionEnvironmentFailedEvent.builder()
                .environment(
                    AgentSessionEnvironmentState.builder()
                        .id("id")
                        .error(
                            AgentSessionEnvironmentState.Error.builder()
                                .code("code")
                                .message("message")
                                .type("type")
                                .build()
                        )
                        .status(AgentSessionEnvironmentState.Status.PENDING)
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofEnvironmentFailed(environmentFailed)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).contains(environmentFailed)
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofEnvironmentFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofEnvironmentFailed(
                AgentSessionEnvironmentFailedEvent.builder()
                    .environment(
                        AgentSessionEnvironmentState.builder()
                            .id("id")
                            .error(
                                AgentSessionEnvironmentState.Error.builder()
                                    .code("code")
                                    .message("message")
                                    .type("type")
                                    .build()
                            )
                            .status(AgentSessionEnvironmentState.Status.PENDING)
                            .type("type")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofSubagentCreated() {
        val subagentCreated =
            AgentSessionSubagentCreatedEvent.builder()
                .eventId("event_id")
                .subagent(
                    Subagent.builder()
                        .id("id")
                        .closedAt(0L)
                        .addOutputTextInstruction("text")
                        .name("name")
                        .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                        .openedAt(0L)
                        .parentAgentId("parent_agent_id")
                        .sessionId("session_id")
                        .status(Subagent.Status.ACTIVE)
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofSubagentCreated(subagentCreated)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).contains(subagentCreated)
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofSubagentCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofSubagentCreated(
                AgentSessionSubagentCreatedEvent.builder()
                    .eventId("event_id")
                    .subagent(
                        Subagent.builder()
                            .id("id")
                            .closedAt(0L)
                            .addOutputTextInstruction("text")
                            .name("name")
                            .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                            .openedAt(0L)
                            .parentAgentId("parent_agent_id")
                            .sessionId("session_id")
                            .status(Subagent.Status.ACTIVE)
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofSubagentActive() {
        val subagentActive =
            AgentSessionSubagentActiveEvent.builder()
                .eventId("event_id")
                .subagent(
                    Subagent.builder()
                        .id("id")
                        .closedAt(0L)
                        .addOutputTextInstruction("text")
                        .name("name")
                        .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                        .openedAt(0L)
                        .parentAgentId("parent_agent_id")
                        .sessionId("session_id")
                        .status(Subagent.Status.ACTIVE)
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofSubagentActive(subagentActive)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).contains(subagentActive)
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofSubagentActiveRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofSubagentActive(
                AgentSessionSubagentActiveEvent.builder()
                    .eventId("event_id")
                    .subagent(
                        Subagent.builder()
                            .id("id")
                            .closedAt(0L)
                            .addOutputTextInstruction("text")
                            .name("name")
                            .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                            .openedAt(0L)
                            .parentAgentId("parent_agent_id")
                            .sessionId("session_id")
                            .status(Subagent.Status.ACTIVE)
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofSubagentClosed() {
        val subagentClosed =
            AgentSessionSubagentClosedEvent.builder()
                .eventId("event_id")
                .subagent(
                    Subagent.builder()
                        .id("id")
                        .closedAt(0L)
                        .addOutputTextInstruction("text")
                        .name("name")
                        .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                        .openedAt(0L)
                        .parentAgentId("parent_agent_id")
                        .sessionId("session_id")
                        .status(Subagent.Status.ACTIVE)
                        .build()
                )
                .build()

        val agentSessionEvent = AgentSessionEvent.ofSubagentClosed(subagentClosed)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).contains(subagentClosed)
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofSubagentClosedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofSubagentClosed(
                AgentSessionSubagentClosedEvent.builder()
                    .eventId("event_id")
                    .subagent(
                        Subagent.builder()
                            .id("id")
                            .closedAt(0L)
                            .addOutputTextInstruction("text")
                            .name("name")
                            .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                            .openedAt(0L)
                            .parentAgentId("parent_agent_id")
                            .sessionId("session_id")
                            .status(Subagent.Status.ACTIVE)
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnItemDone() {
        val turnItemDone =
            AgentSessionTurnItemDoneEvent.builder()
                .eventId("event_id")
                .item(
                    AgentSessionAssistantMessage.builder()
                        .id("id")
                        .addContent(OutputText.builder().text("text").build())
                        .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                        .status(AgentOutputItemStatus.IN_PROGRESS)
                        .turnId("turn_id")
                        .build()
                )
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofTurnItemDone(turnItemDone)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).contains(turnItemDone)
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnItemDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnItemDone(
                AgentSessionTurnItemDoneEvent.builder()
                    .eventId("event_id")
                    .item(
                        AgentSessionAssistantMessage.builder()
                            .id("id")
                            .addContent(OutputText.builder().text("text").build())
                            .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                            .status(AgentOutputItemStatus.IN_PROGRESS)
                            .turnId("turn_id")
                            .build()
                    )
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnContentPartAdded() {
        val turnContentPartAdded =
            AgentSessionTurnContentPartAddedEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(OutputText.builder().text("text").build())
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofTurnContentPartAdded(turnContentPartAdded)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).contains(turnContentPartAdded)
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnContentPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnContentPartAdded(
                AgentSessionTurnContentPartAddedEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(OutputText.builder().text("text").build())
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnContentPartDone() {
        val turnContentPartDone =
            AgentSessionTurnContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(OutputText.builder().text("text").build())
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofTurnContentPartDone(turnContentPartDone)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).contains(turnContentPartDone)
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnContentPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnContentPartDone(
                AgentSessionTurnContentPartDoneEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(OutputText.builder().text("text").build())
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnOutputTextDelta() {
        val turnOutputTextDelta =
            AgentSessionTurnOutputTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofTurnOutputTextDelta(turnOutputTextDelta)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).contains(turnOutputTextDelta)
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnOutputTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnOutputTextDelta(
                AgentSessionTurnOutputTextDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnOutputTextDone() {
        val turnOutputTextDone =
            AgentSessionTurnOutputTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .text("text")
                .turnId("turn_id")
                .build()

        val agentSessionEvent = AgentSessionEvent.ofTurnOutputTextDone(turnOutputTextDone)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).contains(turnOutputTextDone)
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnOutputTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnOutputTextDone(
                AgentSessionTurnOutputTextDoneEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .text("text")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnReasoningSummaryPartAdded() {
        val turnReasoningSummaryPartAdded =
            AgentSessionTurnReasoningSummaryPartAddedEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(SummaryText.builder().text("text").build())
                .sessionId("session_id")
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryPartAdded(turnReasoningSummaryPartAdded)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded())
            .contains(turnReasoningSummaryPartAdded)
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnReasoningSummaryPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryPartAdded(
                AgentSessionTurnReasoningSummaryPartAddedEvent.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(SummaryText.builder().text("text").build())
                    .sessionId("session_id")
                    .summaryIndex(0L)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnReasoningSummaryPartDone() {
        val turnReasoningSummaryPartDone =
            AgentSessionTurnReasoningSummaryPartDoneEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(SummaryText.builder().text("text").build())
                .sessionId("session_id")
                .status(AgentSessionTurnReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryPartDone(turnReasoningSummaryPartDone)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone())
            .contains(turnReasoningSummaryPartDone)
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnReasoningSummaryPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryPartDone(
                AgentSessionTurnReasoningSummaryPartDoneEvent.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(SummaryText.builder().text("text").build())
                    .sessionId("session_id")
                    .status(AgentSessionTurnReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                    .summaryIndex(0L)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnReasoningSummaryTextDelta() {
        val turnReasoningSummaryTextDelta =
            AgentSessionTurnReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .summaryIndex(0L)
                .turnId("turn_id")
                .build()

        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryTextDelta(turnReasoningSummaryTextDelta)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta())
            .contains(turnReasoningSummaryTextDelta)
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone()).isEmpty
    }

    @Test
    fun ofTurnReasoningSummaryTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryTextDelta(
                AgentSessionTurnReasoningSummaryTextDeltaEvent.builder()
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .summaryIndex(0L)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    @Test
    fun ofTurnReasoningSummaryTextDone() {
        val turnReasoningSummaryTextDone =
            AgentSessionTurnReasoningSummaryTextDoneEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .sessionId("session_id")
                .summaryIndex(0L)
                .text("text")
                .turnId("turn_id")
                .build()

        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryTextDone(turnReasoningSummaryTextDone)

        assertThat(agentSessionEvent.error()).isEmpty
        assertThat(agentSessionEvent.environmentReady()).isEmpty
        assertThat(agentSessionEvent.outputCommandExecutionOutputDelta()).isEmpty
        assertThat(agentSessionEvent.created()).isEmpty
        assertThat(agentSessionEvent.turnCreated()).isEmpty
        assertThat(agentSessionEvent.turnInProgress()).isEmpty
        assertThat(agentSessionEvent.turnCompleted()).isEmpty
        assertThat(agentSessionEvent.turnFailed()).isEmpty
        assertThat(agentSessionEvent.turnCancelled()).isEmpty
        assertThat(agentSessionEvent.turnItemAdded()).isEmpty
        assertThat(agentSessionEvent.idle()).isEmpty
        assertThat(agentSessionEvent.inProgress()).isEmpty
        assertThat(agentSessionEvent.requiresAction()).isEmpty
        assertThat(agentSessionEvent.failed()).isEmpty
        assertThat(agentSessionEvent.environmentPending()).isEmpty
        assertThat(agentSessionEvent.environmentConnected()).isEmpty
        assertThat(agentSessionEvent.environmentDisconnected()).isEmpty
        assertThat(agentSessionEvent.environmentFailed()).isEmpty
        assertThat(agentSessionEvent.subagentCreated()).isEmpty
        assertThat(agentSessionEvent.subagentActive()).isEmpty
        assertThat(agentSessionEvent.subagentClosed()).isEmpty
        assertThat(agentSessionEvent.turnItemDone()).isEmpty
        assertThat(agentSessionEvent.turnContentPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnContentPartDone()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnOutputTextDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartAdded()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryPartDone()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDelta()).isEmpty
        assertThat(agentSessionEvent.turnReasoningSummaryTextDone())
            .contains(turnReasoningSummaryTextDone)
    }

    @Test
    fun ofTurnReasoningSummaryTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionEvent =
            AgentSessionEvent.ofTurnReasoningSummaryTextDone(
                AgentSessionTurnReasoningSummaryTextDoneEvent.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sessionId("session_id")
                    .summaryIndex(0L)
                    .text("text")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionEvent),
                jacksonTypeRef<AgentSessionEvent>(),
            )

        assertThat(roundtrippedAgentSessionEvent).isEqualTo(agentSessionEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val agentSessionEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentSessionEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { agentSessionEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
