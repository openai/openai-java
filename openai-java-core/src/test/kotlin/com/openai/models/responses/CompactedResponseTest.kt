// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompactedResponseTest {

    @Test
    fun create() {
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
                        .build()
                )
                .usage(
                    ResponseUsage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                        )
                        .outputTokens(0L)
                        .outputTokensDetails(
                            ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                        )
                        .totalTokens(0L)
                        .build()
                )
                .build()

        assertThat(compactedResponse.id()).isEqualTo("id")
        assertThat(compactedResponse.createdAt()).isEqualTo(0L)
        assertThat(compactedResponse.output())
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
                        .build()
                )
            )
        assertThat(compactedResponse.usage())
            .isEqualTo(
                ResponseUsage.builder()
                    .inputTokens(0L)
                    .inputTokensDetails(
                        ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                    )
                    .outputTokens(0L)
                    .outputTokensDetails(
                        ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                    )
                    .totalTokens(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                        .build()
                )
                .usage(
                    ResponseUsage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                        )
                        .outputTokens(0L)
                        .outputTokensDetails(
                            ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                        )
                        .totalTokens(0L)
                        .build()
                )
                .build()

        val roundtrippedCompactedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(compactedResponse),
                jacksonTypeRef<CompactedResponse>(),
            )

        assertThat(roundtrippedCompactedResponse).isEqualTo(compactedResponse)
    }
}
