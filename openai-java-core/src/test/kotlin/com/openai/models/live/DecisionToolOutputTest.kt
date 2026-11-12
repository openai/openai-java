// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionToolOutputTest {

    @Test
    fun ofString() {
        val string = "string"

        val decisionToolOutput = DecisionToolOutput.ofString(string)

        assertThat(decisionToolOutput.string()).contains(string)
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionToolOutput = DecisionToolOutput.ofString("string")

        val roundtrippedDecisionToolOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionToolOutput),
                jacksonTypeRef<DecisionToolOutput>(),
            )

        assertThat(roundtrippedDecisionToolOutput).isEqualTo(decisionToolOutput)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val decisionToolOutput =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionToolOutput>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionToolOutput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
