// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionsDelegationConfigTest {

    @Test
    fun createAndRoundtrip() {
        val decisionsDelegationConfig =
            DecisionsDelegationConfig.builder()
                .model("x")
                .addQuestion(
                    DecisionsDelegationConfig.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
                .build()

        assertThat(decisionsDelegationConfig.model()).isEqualTo("x")
        assertThat(decisionsDelegationConfig.questions())
            .containsExactly(
                DecisionsDelegationConfig.Question.ofPredicate(
                    DecisionsDelegationConfig.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionsDelegationConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionsDelegationConfig),
                jacksonTypeRef<DecisionsDelegationConfig>(),
            )

        assertThat(roundtrippedDecisionsDelegationConfig).isEqualTo(decisionsDelegationConfig)
    }
}
