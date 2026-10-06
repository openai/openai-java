// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionTest {

    @Test
    fun create() {
        val decision =
            Decision.builder()
                .addAnswer(
                    Decision.Answer.Predicate.builder().name("name").probability(0.0).build()
                )
                .model("model")
                .usage(
                    Decision.Usage.builder()
                        .inputTokens(-2147483648L)
                        .inputTokensDetails(
                            Decision.Usage.InputTokensDetails.builder()
                                .cacheWriteTokens(-2147483648L)
                                .cachedTokens(-2147483648L)
                                .build()
                        )
                        .outputTokens(-2147483648L)
                        .outputTokensDetails(
                            Decision.Usage.OutputTokensDetails.builder()
                                .reasoningTokens(-2147483648L)
                                .build()
                        )
                        .totalTokens(-2147483648L)
                        .build()
                )
                .build()

        assertThat(decision.answers())
            .containsExactly(
                Decision.Answer.ofPredicate(
                    Decision.Answer.Predicate.builder().name("name").probability(0.0).build()
                )
            )
        assertThat(decision.model()).isEqualTo("model")
        assertThat(decision.usage())
            .isEqualTo(
                Decision.Usage.builder()
                    .inputTokens(-2147483648L)
                    .inputTokensDetails(
                        Decision.Usage.InputTokensDetails.builder()
                            .cacheWriteTokens(-2147483648L)
                            .cachedTokens(-2147483648L)
                            .build()
                    )
                    .outputTokens(-2147483648L)
                    .outputTokensDetails(
                        Decision.Usage.OutputTokensDetails.builder()
                            .reasoningTokens(-2147483648L)
                            .build()
                    )
                    .totalTokens(-2147483648L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decision =
            Decision.builder()
                .addAnswer(
                    Decision.Answer.Predicate.builder().name("name").probability(0.0).build()
                )
                .model("model")
                .usage(
                    Decision.Usage.builder()
                        .inputTokens(-2147483648L)
                        .inputTokensDetails(
                            Decision.Usage.InputTokensDetails.builder()
                                .cacheWriteTokens(-2147483648L)
                                .cachedTokens(-2147483648L)
                                .build()
                        )
                        .outputTokens(-2147483648L)
                        .outputTokensDetails(
                            Decision.Usage.OutputTokensDetails.builder()
                                .reasoningTokens(-2147483648L)
                                .build()
                        )
                        .totalTokens(-2147483648L)
                        .build()
                )
                .build()

        val roundtrippedDecision =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decision),
                jacksonTypeRef<Decision>(),
            )

        assertThat(roundtrippedDecision).isEqualTo(decision)
    }
}
