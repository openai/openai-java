// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaCompactedResponseTest {

    @Test
    fun create() {
        val betaCompactedResponse =
            BetaCompactedResponse.builder()
                .id("id")
                .createdAt(0L)
                .addOutput(
                    BetaResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            BetaResponseOutputText.builder()
                                .addAnnotation(
                                    BetaResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    BetaResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            BetaResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                        .agent(
                            BetaResponseOutputMessage.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .usage(
                    BetaResponseUsage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            BetaResponseUsage.InputTokensDetails.builder()
                                .cacheWriteTokens(0L)
                                .cachedTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .outputTokensDetails(
                            BetaResponseUsage.OutputTokensDetails.builder()
                                .reasoningTokens(0L)
                                .build()
                        )
                        .totalTokens(0L)
                        .build()
                )
                .build()

        assertThat(betaCompactedResponse.id()).isEqualTo("id")
        assertThat(betaCompactedResponse.createdAt()).isEqualTo(0L)
        assertThat(betaCompactedResponse.output())
            .containsExactly(
                BetaResponseOutputItem.ofMessage(
                    BetaResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            BetaResponseOutputText.builder()
                                .addAnnotation(
                                    BetaResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    BetaResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            BetaResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                        .agent(
                            BetaResponseOutputMessage.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
            )
        assertThat(betaCompactedResponse.usage())
            .isEqualTo(
                BetaResponseUsage.builder()
                    .inputTokens(0L)
                    .inputTokensDetails(
                        BetaResponseUsage.InputTokensDetails.builder()
                            .cacheWriteTokens(0L)
                            .cachedTokens(0L)
                            .build()
                    )
                    .outputTokens(0L)
                    .outputTokensDetails(
                        BetaResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                    )
                    .totalTokens(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaCompactedResponse =
            BetaCompactedResponse.builder()
                .id("id")
                .createdAt(0L)
                .addOutput(
                    BetaResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            BetaResponseOutputText.builder()
                                .addAnnotation(
                                    BetaResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    BetaResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            BetaResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                        .agent(
                            BetaResponseOutputMessage.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .usage(
                    BetaResponseUsage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            BetaResponseUsage.InputTokensDetails.builder()
                                .cacheWriteTokens(0L)
                                .cachedTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .outputTokensDetails(
                            BetaResponseUsage.OutputTokensDetails.builder()
                                .reasoningTokens(0L)
                                .build()
                        )
                        .totalTokens(0L)
                        .build()
                )
                .build()

        val roundtrippedBetaCompactedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaCompactedResponse),
                jacksonTypeRef<BetaCompactedResponse>(),
            )

        assertThat(roundtrippedBetaCompactedResponse).isEqualTo(betaCompactedResponse)
    }
}
