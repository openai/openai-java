// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompactedResponseTest {

    @Test
    fun createAndRoundtrip() {
        val compactedResponse =
            CompactedResponse.builder()
                .id("resp_001")
                .createdAt(1731459200L)
                .addOutput(
                    ResponseInputMessageItem.builder()
                        .id("msg_001")
                        .addContent(
                            ResponseInputText.builder()
                                .text("Summarize our launch checklist from last week.")
                                .promptCacheBreakpoint(
                                    ResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.COMPLETED)
                        .build()
                )
                .addOutput(
                    ResponseInputMessageItem.builder()
                        .id("msg_002")
                        .addContent(
                            ResponseInputText.builder()
                                .text("You are performing a CONTEXT CHECKPOINT COMPACTION...")
                                .promptCacheBreakpoint(
                                    ResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.COMPLETED)
                        .build()
                )
                .addOutput(
                    ResponseCompactionItem.builder()
                        .id("cmp_001")
                        .encryptedContent("encrypted-summary")
                        .createdBy("created_by")
                        .build()
                )
                .usage(
                    ResponseUsage.builder()
                        .inputTokens(42897L)
                        .inputTokensDetails(
                            ResponseUsage.InputTokensDetails.builder()
                                .cacheWriteTokens(0L)
                                .cachedTokens(0L)
                                .cacheWriteTokensDetails(
                                    ResponseUsage.InputTokensDetails.CacheWriteTokensDetails
                                        .builder()
                                        .ttl12hTokens(0L)
                                        .ttl30mTokens(0L)
                                        .build()
                                )
                                .build()
                        )
                        .outputTokens(12000L)
                        .outputTokensDetails(
                            ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                        )
                        .totalTokens(54897L)
                        .build()
                )
                .image(
                    CompactedResponse.Image.builder()
                        .contextCompression(CompactedResponse.Image.ContextCompression.DISABLED)
                        .build()
                )
                .build()

        assertThat(compactedResponse.id()).contains("resp_001")
        assertThat(compactedResponse.createdAt()).contains(1731459200L)
        assertThat(compactedResponse.output().getOrNull())
            .containsExactly(
                ResponseItem.ofResponseInputMessageItem(
                    ResponseInputMessageItem.builder()
                        .id("msg_001")
                        .addContent(
                            ResponseInputText.builder()
                                .text("Summarize our launch checklist from last week.")
                                .promptCacheBreakpoint(
                                    ResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.COMPLETED)
                        .build()
                ),
                ResponseItem.ofResponseInputMessageItem(
                    ResponseInputMessageItem.builder()
                        .id("msg_002")
                        .addContent(
                            ResponseInputText.builder()
                                .text("You are performing a CONTEXT CHECKPOINT COMPACTION...")
                                .promptCacheBreakpoint(
                                    ResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.COMPLETED)
                        .build()
                ),
                ResponseItem.ofCompaction(
                    ResponseCompactionItem.builder()
                        .id("cmp_001")
                        .encryptedContent("encrypted-summary")
                        .createdBy("created_by")
                        .build()
                ),
            )
        assertThat(compactedResponse.usage())
            .contains(
                ResponseUsage.builder()
                    .inputTokens(42897L)
                    .inputTokensDetails(
                        ResponseUsage.InputTokensDetails.builder()
                            .cacheWriteTokens(0L)
                            .cachedTokens(0L)
                            .cacheWriteTokensDetails(
                                ResponseUsage.InputTokensDetails.CacheWriteTokensDetails.builder()
                                    .ttl12hTokens(0L)
                                    .ttl30mTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .outputTokens(12000L)
                    .outputTokensDetails(
                        ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                    )
                    .totalTokens(54897L)
                    .build()
            )
        assertThat(compactedResponse.image())
            .contains(
                CompactedResponse.Image.builder()
                    .contextCompression(CompactedResponse.Image.ContextCompression.DISABLED)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedCompactedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(compactedResponse),
                jacksonTypeRef<CompactedResponse>(),
            )

        assertThat(roundtrippedCompactedResponse).isEqualTo(compactedResponse)
    }
}
