// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.decisions.DecisionChoiceOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionQuestionTest {

    @Test
    fun ofChoice() {
        val choice =
            DecisionQuestion.Choice.builder()
                .addChoice(
                    DecisionChoiceOption.builder()
                        .value("string")
                        .description("description")
                        .build()
                )
                .instructions("string")
                .name("name")
                .build()

        val decisionQuestion = DecisionQuestion.ofChoice(choice)

        assertThat(decisionQuestion.choice()).contains(choice)
        assertThat(decisionQuestion.predicate()).isEmpty
        assertThat(decisionQuestion.score()).isEmpty
    }

    @Test
    fun ofChoiceRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionQuestion =
            DecisionQuestion.ofChoice(
                DecisionQuestion.Choice.builder()
                    .addChoice(
                        DecisionChoiceOption.builder()
                            .value("string")
                            .description("description")
                            .build()
                    )
                    .instructions("string")
                    .name("name")
                    .build()
            )

        val roundtrippedDecisionQuestion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestion),
                jacksonTypeRef<DecisionQuestion>(),
            )

        assertThat(roundtrippedDecisionQuestion).isEqualTo(decisionQuestion)
    }

    @Test
    fun ofPredicate() {
        val predicate =
            DecisionQuestion.Predicate.builder().instructions("string").name("name").build()

        val decisionQuestion = DecisionQuestion.ofPredicate(predicate)

        assertThat(decisionQuestion.choice()).isEmpty
        assertThat(decisionQuestion.predicate()).contains(predicate)
        assertThat(decisionQuestion.score()).isEmpty
    }

    @Test
    fun ofPredicateRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionQuestion =
            DecisionQuestion.ofPredicate(
                DecisionQuestion.Predicate.builder().instructions("string").name("name").build()
            )

        val roundtrippedDecisionQuestion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestion),
                jacksonTypeRef<DecisionQuestion>(),
            )

        assertThat(roundtrippedDecisionQuestion).isEqualTo(decisionQuestion)
    }

    @Test
    fun ofScore() {
        val score =
            DecisionQuestion.Score.builder()
                .instructions("string")
                .addLevel(
                    DecisionQuestion.Score.Level.builder()
                        .label("label")
                        .description("description")
                        .build()
                )
                .name("name")
                .build()

        val decisionQuestion = DecisionQuestion.ofScore(score)

        assertThat(decisionQuestion.choice()).isEmpty
        assertThat(decisionQuestion.predicate()).isEmpty
        assertThat(decisionQuestion.score()).contains(score)
    }

    @Test
    fun ofScoreRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionQuestion =
            DecisionQuestion.ofScore(
                DecisionQuestion.Score.builder()
                    .instructions("string")
                    .addLevel(
                        DecisionQuestion.Score.Level.builder()
                            .label("label")
                            .description("description")
                            .build()
                    )
                    .name("name")
                    .build()
            )

        val roundtrippedDecisionQuestion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestion),
                jacksonTypeRef<DecisionQuestion>(),
            )

        assertThat(roundtrippedDecisionQuestion).isEqualTo(decisionQuestion)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val decisionQuestion =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionQuestion>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionQuestion.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
