// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseUsageTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseUsage =
            BetaResponseUsage.builder()
                .inputTokens(0L)
                .inputTokensDetails(
                    BetaResponseUsage.InputTokensDetails.builder()
                        .cacheWriteTokens(0L)
                        .cachedTokens(0L)
                        .cacheWriteTokensDetails(
                            BetaResponseUsage.InputTokensDetails.CacheWriteTokensDetails.builder()
                                .ttl12hTokens(0L)
                                .ttl30mTokens(0L)
                                .build()
                        )
                        .build()
                )
                .outputTokens(0L)
                .outputTokensDetails(
                    BetaResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                )
                .totalTokens(0L)
                .build()

        assertThat(betaResponseUsage.inputTokens()).contains(0L)
        assertThat(betaResponseUsage.inputTokensDetails())
            .contains(
                BetaResponseUsage.InputTokensDetails.builder()
                    .cacheWriteTokens(0L)
                    .cachedTokens(0L)
                    .cacheWriteTokensDetails(
                        BetaResponseUsage.InputTokensDetails.CacheWriteTokensDetails.builder()
                            .ttl12hTokens(0L)
                            .ttl30mTokens(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(betaResponseUsage.outputTokens()).contains(0L)
        assertThat(betaResponseUsage.outputTokensDetails())
            .contains(BetaResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build())
        assertThat(betaResponseUsage.totalTokens()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseUsage),
                jacksonTypeRef<BetaResponseUsage>(),
            )

        assertThat(roundtrippedBetaResponseUsage).isEqualTo(betaResponseUsage)
    }
}
