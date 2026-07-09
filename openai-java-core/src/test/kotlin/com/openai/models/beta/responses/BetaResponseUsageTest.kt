// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseUsageTest {

    @Test
    fun create() {
        val betaResponseUsage =
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

        assertThat(betaResponseUsage.inputTokens()).isEqualTo(0L)
        assertThat(betaResponseUsage.inputTokensDetails())
            .isEqualTo(
                BetaResponseUsage.InputTokensDetails.builder()
                    .cacheWriteTokens(0L)
                    .cachedTokens(0L)
                    .build()
            )
        assertThat(betaResponseUsage.outputTokens()).isEqualTo(0L)
        assertThat(betaResponseUsage.outputTokensDetails())
            .isEqualTo(BetaResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build())
        assertThat(betaResponseUsage.totalTokens()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseUsage =
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

        val roundtrippedBetaResponseUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseUsage),
                jacksonTypeRef<BetaResponseUsage>(),
            )

        assertThat(roundtrippedBetaResponseUsage).isEqualTo(betaResponseUsage)
    }
}
