// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionsDelegationUpdateConfigTest {

    @Test
    fun create() {
        val decisionsDelegationUpdateConfig =
            DecisionsDelegationUpdateConfig.builder()
                .model("x")
                .addQuestion(
                    DecisionsDelegationUpdateConfig.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
                .build()

        assertThat(decisionsDelegationUpdateConfig.model()).contains("x")
        assertThat(decisionsDelegationUpdateConfig.questions().getOrNull())
            .containsExactly(
                DecisionsDelegationUpdateConfig.Question.ofPredicate(
                    DecisionsDelegationUpdateConfig.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionsDelegationUpdateConfig =
            DecisionsDelegationUpdateConfig.builder()
                .model("x")
                .addQuestion(
                    DecisionsDelegationUpdateConfig.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
                .build()

        val roundtrippedDecisionsDelegationUpdateConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionsDelegationUpdateConfig),
                jacksonTypeRef<DecisionsDelegationUpdateConfig>(),
            )

        assertThat(roundtrippedDecisionsDelegationUpdateConfig)
            .isEqualTo(decisionsDelegationUpdateConfig)
    }
}
