// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompactedResponseTest {

    @Test
    fun createAndRoundtrip() {
        val compactedResponse =
            CompactedResponse.builder()
                .id("id")
                .createdAt(0L)
                .addOutput(
                    ResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            ResponseOutputText.builder()
                                .addAnnotation(
                                    ResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .phase(ResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .usage(
                    ResponseUsage.builder()
                        .inputTokens(0L)
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
                        .outputTokens(0L)
                        .outputTokensDetails(
                            ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                        )
                        .totalTokens(0L)
                        .build()
                )
                .image(
                    CompactedResponse.Image.builder()
                        .contextCompression(CompactedResponse.Image.ContextCompression.ENABLED)
                        .build()
                )
                .build()

        assertThat(compactedResponse.id()).contains("id")
        assertThat(compactedResponse.createdAt()).contains(0L)
        assertThat(compactedResponse.output().getOrNull())
            .containsExactly(
                ResponseOutputItem.ofMessage(
                    ResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            ResponseOutputText.builder()
                                .addAnnotation(
                                    ResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .phase(ResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
            )
        assertThat(compactedResponse.usage())
            .contains(
                ResponseUsage.builder()
                    .inputTokens(0L)
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
                    .outputTokens(0L)
                    .outputTokensDetails(
                        ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                    )
                    .totalTokens(0L)
                    .build()
            )
        assertThat(compactedResponse.image())
            .contains(
                CompactedResponse.Image.builder()
                    .contextCompression(CompactedResponse.Image.ContextCompression.ENABLED)
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
