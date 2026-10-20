// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionChoiceValueTest {

    @Test
    fun ofString() {
        val string = "string"

        val decisionChoiceValue = DecisionChoiceValue.ofString(string)

        assertThat(decisionChoiceValue.string()).contains(string)
        assertThat(decisionChoiceValue.bool()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionChoiceValue = DecisionChoiceValue.ofString("string")

        val roundtrippedDecisionChoiceValue =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionChoiceValue),
                jacksonTypeRef<DecisionChoiceValue>(),
            )

        assertThat(roundtrippedDecisionChoiceValue).isEqualTo(decisionChoiceValue)
    }

    @Test
    fun ofBool() {
        val bool = true

        val decisionChoiceValue = DecisionChoiceValue.ofBool(bool)

        assertThat(decisionChoiceValue.string()).isEmpty
        assertThat(decisionChoiceValue.bool()).contains(bool)
    }

    @Test
    fun ofBoolRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionChoiceValue = DecisionChoiceValue.ofBool(true)

        val roundtrippedDecisionChoiceValue =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionChoiceValue),
                jacksonTypeRef<DecisionChoiceValue>(),
            )

        assertThat(roundtrippedDecisionChoiceValue).isEqualTo(decisionChoiceValue)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val decisionChoiceValue =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionChoiceValue>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionChoiceValue.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
