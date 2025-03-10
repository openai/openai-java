// File generated from our OpenAPI spec by Stainless.

package com.openai.models.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionUsageTest {

    @Test
    fun createCompletionUsage() {
        val completionUsage =
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
        assertThat(completionUsage).isNotNull
        assertThat(completionUsage.completionTokens()).isEqualTo(0L)
        assertThat(completionUsage.promptTokens()).isEqualTo(0L)
        assertThat(completionUsage.totalTokens()).isEqualTo(0L)
        assertThat(completionUsage.completionTokensDetails())
            .contains(
                CompletionUsage.CompletionTokensDetails.builder()
                    .acceptedPredictionTokens(0L)
                    .audioTokens(0L)
                    .reasoningTokens(0L)
                    .rejectedPredictionTokens(0L)
                    .build()
            )
        assertThat(completionUsage.promptTokensDetails())
            .contains(
                CompletionUsage.PromptTokensDetails.builder()
                    .audioTokens(0L)
                    .cachedTokens(0L)
                    .build()
            )
    }
}
