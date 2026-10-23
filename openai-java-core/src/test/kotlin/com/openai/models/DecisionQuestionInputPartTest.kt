// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionQuestionInputPartTest {

    @Test
    fun ofInputText() {
        val inputText = DecisionQuestionInputText.builder().text("text").build()

        val decisionQuestionInputPart = DecisionQuestionInputPart.ofInputText(inputText)

        assertThat(decisionQuestionInputPart.inputText()).contains(inputText)
        assertThat(decisionQuestionInputPart.inputImage()).isEmpty
        assertThat(decisionQuestionInputPart.inputJson()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionQuestionInputPart =
            DecisionQuestionInputPart.ofInputText(
                DecisionQuestionInputText.builder().text("text").build()
            )

        val roundtrippedDecisionQuestionInputPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestionInputPart),
                jacksonTypeRef<DecisionQuestionInputPart>(),
            )

        assertThat(roundtrippedDecisionQuestionInputPart).isEqualTo(decisionQuestionInputPart)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            DecisionQuestionInputImage.builder()
                .imageUrl("https://")
                .detail(DecisionQuestionInputImage.Detail.LOW)
                .build()

        val decisionQuestionInputPart = DecisionQuestionInputPart.ofInputImage(inputImage)

        assertThat(decisionQuestionInputPart.inputText()).isEmpty
        assertThat(decisionQuestionInputPart.inputImage()).contains(inputImage)
        assertThat(decisionQuestionInputPart.inputJson()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionQuestionInputPart =
            DecisionQuestionInputPart.ofInputImage(
                DecisionQuestionInputImage.builder()
                    .imageUrl("https://")
                    .detail(DecisionQuestionInputImage.Detail.LOW)
                    .build()
            )

        val roundtrippedDecisionQuestionInputPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestionInputPart),
                jacksonTypeRef<DecisionQuestionInputPart>(),
            )

        assertThat(roundtrippedDecisionQuestionInputPart).isEqualTo(decisionQuestionInputPart)
    }

    @Test
    fun ofInputJson() {
        val inputJson =
            DecisionInputJson.builder()
                .data(DecisionInputJson.Data.UnionMember0.builder().build())
                .build()

        val decisionQuestionInputPart = DecisionQuestionInputPart.ofInputJson(inputJson)

        assertThat(decisionQuestionInputPart.inputText()).isEmpty
        assertThat(decisionQuestionInputPart.inputImage()).isEmpty
        assertThat(decisionQuestionInputPart.inputJson()).contains(inputJson)
    }

    @Test
    fun ofInputJsonRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionQuestionInputPart =
            DecisionQuestionInputPart.ofInputJson(
                DecisionInputJson.builder()
                    .data(DecisionInputJson.Data.UnionMember0.builder().build())
                    .build()
            )

        val roundtrippedDecisionQuestionInputPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestionInputPart),
                jacksonTypeRef<DecisionQuestionInputPart>(),
            )

        assertThat(roundtrippedDecisionQuestionInputPart).isEqualTo(decisionQuestionInputPart)
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
        val decisionQuestionInputPart =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionQuestionInputPart>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionQuestionInputPart.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
