// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaCompactedResponseTest {

    @Test
    fun createAndRoundtrip() {
        val betaCompactedResponse =
            BetaCompactedResponse.builder()
                .id("resp_001")
                .createdAt(1731459200L)
                .addOutput(
                    BetaResponseInputMessageItem.builder()
                        .id("msg_001")
                        .addContent(
                            BetaResponseInputText.builder()
                                .text("Summarize our launch checklist from last week.")
                                .promptCacheBreakpoint(
                                    BetaResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(BetaResponseInputMessageItem.Role.USER)
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.COMPLETED)
                        .build()
                )
                .addOutput(
                    BetaResponseInputMessageItem.builder()
                        .id("msg_002")
                        .addContent(
                            BetaResponseInputText.builder()
                                .text("You are performing a CONTEXT CHECKPOINT COMPACTION...")
                                .promptCacheBreakpoint(
                                    BetaResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(BetaResponseInputMessageItem.Role.USER)
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.COMPLETED)
                        .build()
                )
                .addOutput(
                    BetaResponseCompactionItem.builder()
                        .id("cmp_001")
                        .encryptedContent("encrypted-summary")
                        .agent(
                            BetaResponseCompactionItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .createdBy("created_by")
                        .build()
                )
                .usage(
                    BetaResponseUsage.builder()
                        .inputTokens(42897L)
                        .inputTokensDetails(
                            BetaResponseUsage.InputTokensDetails.builder()
                                .cacheWriteTokens(0L)
                                .cachedTokens(0L)
                                .cacheWriteTokensDetails(
                                    BetaResponseUsage.InputTokensDetails.CacheWriteTokensDetails
                                        .builder()
                                        .ttl12hTokens(0L)
                                        .ttl30mTokens(0L)
                                        .build()
                                )
                                .build()
                        )
                        .outputTokens(12000L)
                        .outputTokensDetails(
                            BetaResponseUsage.OutputTokensDetails.builder()
                                .reasoningTokens(0L)
                                .build()
                        )
                        .totalTokens(54897L)
                        .build()
                )
                .image(
                    BetaCompactedResponse.Image.builder()
                        .contextCompression(BetaCompactedResponse.Image.ContextCompression.DISABLED)
                        .build()
                )
                .build()

        assertThat(betaCompactedResponse.id()).contains("resp_001")
        assertThat(betaCompactedResponse.createdAt()).contains(1731459200L)
        assertThat(betaCompactedResponse.output().getOrNull())
            .containsExactly(
                BetaResponseItem.ofBetaResponseInputMessageItem(
                    BetaResponseInputMessageItem.builder()
                        .id("msg_001")
                        .addContent(
                            BetaResponseInputText.builder()
                                .text("Summarize our launch checklist from last week.")
                                .promptCacheBreakpoint(
                                    BetaResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(BetaResponseInputMessageItem.Role.USER)
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.COMPLETED)
                        .build()
                ),
                BetaResponseItem.ofBetaResponseInputMessageItem(
                    BetaResponseInputMessageItem.builder()
                        .id("msg_002")
                        .addContent(
                            BetaResponseInputText.builder()
                                .text("You are performing a CONTEXT CHECKPOINT COMPACTION...")
                                .promptCacheBreakpoint(
                                    BetaResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(BetaResponseInputMessageItem.Role.USER)
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.COMPLETED)
                        .build()
                ),
                BetaResponseItem.ofCompaction(
                    BetaResponseCompactionItem.builder()
                        .id("cmp_001")
                        .encryptedContent("encrypted-summary")
                        .agent(
                            BetaResponseCompactionItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .createdBy("created_by")
                        .build()
                ),
            )
        assertThat(betaCompactedResponse.usage())
            .contains(
                BetaResponseUsage.builder()
                    .inputTokens(42897L)
                    .inputTokensDetails(
                        BetaResponseUsage.InputTokensDetails.builder()
                            .cacheWriteTokens(0L)
                            .cachedTokens(0L)
                            .cacheWriteTokensDetails(
                                BetaResponseUsage.InputTokensDetails.CacheWriteTokensDetails
                                    .builder()
                                    .ttl12hTokens(0L)
                                    .ttl30mTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .outputTokens(12000L)
                    .outputTokensDetails(
                        BetaResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                    )
                    .totalTokens(54897L)
                    .build()
            )
        assertThat(betaCompactedResponse.image())
            .contains(
                BetaCompactedResponse.Image.builder()
                    .contextCompression(BetaCompactedResponse.Image.ContextCompression.DISABLED)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaCompactedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaCompactedResponse),
                jacksonTypeRef<BetaCompactedResponse>(),
            )

        assertThat(roundtrippedBetaCompactedResponse).isEqualTo(betaCompactedResponse)
    }
}
