// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionTest {

    @Test
    fun createCompletion() {
        val completion =
            Completion.builder()
                .id("id")
                .choices(
                    listOf(
                        CompletionChoice.builder()
                            .finishReason(CompletionChoice.FinishReason.STOP)
                            .index(0L)
                            .logprobs(
                                CompletionChoice.Logprobs.builder()
                                    .textOffset(listOf(0L))
                                    .tokenLogprobs(listOf(0.0))
                                    .tokens(listOf("string"))
                                    .topLogprobs(
                                        listOf(
                                            CompletionChoice.Logprobs.TopLogprob.builder().build()
                                        )
                                    )
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
                )
                .created(0L)
                .model("model")
                .object_(Completion.Object.TEXT_COMPLETION)
                .systemFingerprint("system_fingerprint")
                .usage(
                    CompletionUsage.builder()
                        .completionTokens(0L)
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .completionTokensDetails(
                            CompletionUsage.CompletionTokensDetails.builder()
                                .acceptedPredictionTokens(0L)
                                .audioTokens(0L)
                                .reasoningTokens(0L)
                                .rejectedPredictionTokens(0L)
                                .build()
                        )
                        .promptTokensDetails(
                            CompletionUsage.PromptTokensDetails.builder()
                                .audioTokens(0L)
                                .cachedTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(completion).isNotNull
        assertThat(completion.id()).isEqualTo("id")
        assertThat(completion.choices())
            .containsExactly(
                CompletionChoice.builder()
                    .finishReason(CompletionChoice.FinishReason.STOP)
                    .index(0L)
                    .logprobs(
                        CompletionChoice.Logprobs.builder()
                            .textOffset(listOf(0L))
                            .tokenLogprobs(listOf(0.0))
                            .tokens(listOf("string"))
                            .topLogprobs(
                                listOf(CompletionChoice.Logprobs.TopLogprob.builder().build())
                            )
                            .build()
                    )
                    .text("text")
                    .build()
            )
        assertThat(completion.created()).isEqualTo(0L)
        assertThat(completion.model()).isEqualTo("model")
        assertThat(completion.object_()).isEqualTo(Completion.Object.TEXT_COMPLETION)
        assertThat(completion.systemFingerprint()).contains("system_fingerprint")
        assertThat(completion.usage())
            .contains(
                CompletionUsage.builder()
                    .completionTokens(0L)
                    .promptTokens(0L)
                    .totalTokens(0L)
                    .completionTokensDetails(
                        CompletionUsage.CompletionTokensDetails.builder()
                            .acceptedPredictionTokens(0L)
                            .audioTokens(0L)
                            .reasoningTokens(0L)
                            .rejectedPredictionTokens(0L)
                            .build()
                    )
                    .promptTokensDetails(
                        CompletionUsage.PromptTokensDetails.builder()
                            .audioTokens(0L)
                            .cachedTokens(0L)
                            .build()
                    )
                    .build()
            )
    }
}
