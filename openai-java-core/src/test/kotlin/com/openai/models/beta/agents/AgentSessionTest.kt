// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionTest {

    @Test
    fun createAndRoundtrip() {
        val agentSession =
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
                                .async(true)
                                .build()
                        )
                        .compaction(AgentSession.Agent.Compaction.builder().async(true).build())
                        .experimental(
                            AgentSession.Agent.Experimental.builder().timeAwareness(true).build()
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
                    AgentSession.RequiredAction.McpApprovalRequest.builder()
                        .request(
                            AgentSession.RequiredAction.McpApprovalRequest.Request.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .message("message")
                                .name("name")
                                .serverLabel("server_label")
                                .build()
                        )
                        .requestId("request_id")
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
                .promptCacheOptions(
                    AgentSession.PromptCacheOptions.builder()
                        .ttl(AgentSession.PromptCacheOptions.Ttl._30M)
                        .build()
                )
                .review(AgentSession.Review.NONE)
                .spendControl(AgentSession.SpendControl.builder().consumed(0L).limit(1L).build())
                .build()

        assertThat(agentSession.id()).isEqualTo("id")
        assertThat(agentSession.agent())
            .isEqualTo(
                AgentSession.Agent.builder()
                    .id("id")
                    .instructions("instructions")
                    .model("model")
                    .multiAgent(
                        MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build()
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
                        AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build()
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
                            .async(true)
                            .build()
                    )
                    .compaction(AgentSession.Agent.Compaction.builder().async(true).build())
                    .experimental(
                        AgentSession.Agent.Experimental.builder().timeAwareness(true).build()
                    )
                    .build()
            )
        assertThat(agentSession.createdAt()).isEqualTo(0L)
        assertThat(agentSession.environment()).isEqualTo(Environment.ofNone())
        assertThat(agentSession.error()).contains("error")
        assertThat(agentSession.lastActiveAt()).isEqualTo(0L)
        assertThat(agentSession.metadata())
            .isEqualTo(
                AgentSession.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(agentSession.requiredActions())
            .containsExactly(
                AgentSession.RequiredAction.ofMcpApprovalRequest(
                    AgentSession.RequiredAction.McpApprovalRequest.builder()
                        .request(
                            AgentSession.RequiredAction.McpApprovalRequest.Request.builder()
                                .arguments(JsonValue.from(mapOf<String, Any>()))
                                .message("message")
                                .name("name")
                                .serverLabel("server_label")
                                .build()
                        )
                        .requestId("request_id")
                        .turnId("turn_id")
                        .build()
                )
            )
        assertThat(agentSession.status()).isEqualTo(AgentSession.Status.IDLE)
        assertThat(agentSession.usage())
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
        assertThat(agentSession.vaultIds()).containsExactly("string")
        assertThat(agentSession.promptCacheOptions())
            .contains(
                AgentSession.PromptCacheOptions.builder()
                    .ttl(AgentSession.PromptCacheOptions.Ttl._30M)
                    .build()
            )
        assertThat(agentSession.review()).contains(AgentSession.Review.NONE)
        assertThat(agentSession.spendControl())
            .contains(AgentSession.SpendControl.builder().consumed(0L).limit(1L).build())

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSession),
                jacksonTypeRef<AgentSession>(),
            )

        assertThat(roundtrippedAgentSession).isEqualTo(agentSession)
    }
}
