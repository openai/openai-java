// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokenUsageTest {

    @Test
    fun create() {
        val tokenUsage =
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

        assertThat(tokenUsage.inputTokens()).isEqualTo(0L)
        assertThat(tokenUsage.inputTokensDetails())
            .isEqualTo(TokenUsage.InputTokensDetails.builder().cachedTokens(0L).build())
        assertThat(tokenUsage.outputTokens()).isEqualTo(0L)
        assertThat(tokenUsage.outputTokensDetails())
            .isEqualTo(TokenUsage.OutputTokensDetails.builder().reasoningTokens(0L).build())
        assertThat(tokenUsage.totalTokens()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tokenUsage =
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

        val roundtrippedTokenUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenUsage),
                jacksonTypeRef<TokenUsage>(),
            )

        assertThat(roundtrippedTokenUsage).isEqualTo(tokenUsage)
    }
}
