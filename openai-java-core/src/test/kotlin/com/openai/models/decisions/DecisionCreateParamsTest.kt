// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionCreateParamsTest {

    @Test
    fun create() {
        DecisionCreateParams.builder()
            .input("string")
            .model("model")
            .addQuestion(
                DecisionCreateParams.Question.Predicate.builder()
                    .instructions("instructions")
                    .name("name")
                    .build()
            )
            .safetyIdentifier("safety_identifier")
            .build()
    }

    @Test
    fun body() {
        val params =
            DecisionCreateParams.builder()
                .input("string")
                .model("model")
                .addQuestion(
                    DecisionCreateParams.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
                .safetyIdentifier("safety_identifier")
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo(DecisionCreateParams.Input.ofString("string"))
        assertThat(body.model()).isEqualTo("model")
        assertThat(body.questions())
            .containsExactly(
                DecisionCreateParams.Question.ofPredicate(
                    DecisionCreateParams.Question.Predicate.builder()
                        .instructions("instructions")
                        .name("name")
                        .build()
                )
            )
        assertThat(body.safetyIdentifier()).contains("safety_identifier")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            DecisionCreateParams.builder()
                .input("string")
                .model("model")
                .addPredicateQuestion("instructions")
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo(DecisionCreateParams.Input.ofString("string"))
        assertThat(body.model()).isEqualTo("model")
        assertThat(body.questions())
            .containsExactly(
                DecisionCreateParams.Question.ofPredicate(
                    DecisionCreateParams.Question.Predicate.builder()
                        .instructions("instructions")
                        .build()
                )
            )
    }
}
