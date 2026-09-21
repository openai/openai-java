// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import com.openai.models.beta.agents.TokenUsage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionListPageResponseTest {

    @Test
    fun create() {
        val sessionListPageResponse =
            SessionListPageResponse.builder()
                .addData(
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
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(sessionListPageResponse.data())
            .containsExactly(
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
                                TokenUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                            )
                            .totalTokens(0L)
                            .build()
                    )
                    .addVaultId("string")
                    .build()
            )
        assertThat(sessionListPageResponse.firstId()).contains("first_id")
        assertThat(sessionListPageResponse.hasMore()).isEqualTo(true)
        assertThat(sessionListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionListPageResponse =
            SessionListPageResponse.builder()
                .addData(
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
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedSessionListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionListPageResponse),
                jacksonTypeRef<SessionListPageResponse>(),
            )

        assertThat(roundtrippedSessionListPageResponse).isEqualTo(sessionListPageResponse)
    }
}
