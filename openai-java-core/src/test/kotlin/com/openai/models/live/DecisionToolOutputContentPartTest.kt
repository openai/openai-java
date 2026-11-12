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

internal class DecisionToolOutputContentPartTest {

    @Test
    fun ofInputText() {
        val inputText = DecisionInputText.builder().text("text").build()

        val decisionToolOutputContentPart = DecisionToolOutputContentPart.ofInputText(inputText)

        assertThat(decisionToolOutputContentPart.inputText()).contains(inputText)
        assertThat(decisionToolOutputContentPart.inputImage()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionToolOutputContentPart =
            DecisionToolOutputContentPart.ofInputText(
                DecisionInputText.builder().text("text").build()
            )

        val roundtrippedDecisionToolOutputContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionToolOutputContentPart),
                jacksonTypeRef<DecisionToolOutputContentPart>(),
            )

        assertThat(roundtrippedDecisionToolOutputContentPart)
            .isEqualTo(decisionToolOutputContentPart)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            DecisionToolOutputContentPart.InputImage.builder()
                .imageUrl("https://")
                .detail(DecisionToolOutputContentPart.InputImage.Detail.LOW)
                .build()

        val decisionToolOutputContentPart = DecisionToolOutputContentPart.ofInputImage(inputImage)

        assertThat(decisionToolOutputContentPart.inputText()).isEmpty
        assertThat(decisionToolOutputContentPart.inputImage()).contains(inputImage)
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionToolOutputContentPart =
            DecisionToolOutputContentPart.ofInputImage(
                DecisionToolOutputContentPart.InputImage.builder()
                    .imageUrl("https://")
                    .detail(DecisionToolOutputContentPart.InputImage.Detail.LOW)
                    .build()
            )

        val roundtrippedDecisionToolOutputContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionToolOutputContentPart),
                jacksonTypeRef<DecisionToolOutputContentPart>(),
            )

        assertThat(roundtrippedDecisionToolOutputContentPart)
            .isEqualTo(decisionToolOutputContentPart)
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
        val decisionToolOutputContentPart =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<DecisionToolOutputContentPart>())

        val e =
            assertThrows<OpenAIInvalidDataException> { decisionToolOutputContentPart.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
