// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.DecisionInputJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionInputPartTest {

    @Test
    fun ofInputText() {
        val inputText =
            DecisionInputText.builder()
                .text("text")
                .promptCacheBreakpoint(DecisionPromptCacheBreakpoint.builder().build())
                .build()

        val decisionInputPart = DecisionInputPart.ofInputText(inputText)

        assertThat(decisionInputPart.inputText()).contains(inputText)
        assertThat(decisionInputPart.inputImage()).isEmpty
        assertThat(decisionInputPart.inputJson()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputPart =
            DecisionInputPart.ofInputText(
                DecisionInputText.builder()
                    .text("text")
                    .promptCacheBreakpoint(DecisionPromptCacheBreakpoint.builder().build())
                    .build()
            )

        val roundtrippedDecisionInputPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputPart),
                jacksonTypeRef<DecisionInputPart>(),
            )

        assertThat(roundtrippedDecisionInputPart).isEqualTo(decisionInputPart)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            DecisionInputImage.builder()
                .imageUrl("https://")
                .detail(DecisionInputImage.Detail.LOW)
                .promptCacheBreakpoint(DecisionPromptCacheBreakpoint.builder().build())
                .build()

        val decisionInputPart = DecisionInputPart.ofInputImage(inputImage)

        assertThat(decisionInputPart.inputText()).isEmpty
        assertThat(decisionInputPart.inputImage()).contains(inputImage)
        assertThat(decisionInputPart.inputJson()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputPart =
            DecisionInputPart.ofInputImage(
                DecisionInputImage.builder()
                    .imageUrl("https://")
                    .detail(DecisionInputImage.Detail.LOW)
                    .promptCacheBreakpoint(DecisionPromptCacheBreakpoint.builder().build())
                    .build()
            )

        val roundtrippedDecisionInputPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputPart),
                jacksonTypeRef<DecisionInputPart>(),
            )

        assertThat(roundtrippedDecisionInputPart).isEqualTo(decisionInputPart)
    }

    @Test
    fun ofInputJson() {
        val inputJson =
            DecisionInputJson.builder()
                .data(DecisionInputJson.Data.UnionMember0.builder().build())
                .build()

        val decisionInputPart = DecisionInputPart.ofInputJson(inputJson)

        assertThat(decisionInputPart.inputText()).isEmpty
        assertThat(decisionInputPart.inputImage()).isEmpty
        assertThat(decisionInputPart.inputJson()).contains(inputJson)
    }

    @Test
    fun ofInputJsonRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputPart =
            DecisionInputPart.ofInputJson(
                DecisionInputJson.builder()
                    .data(DecisionInputJson.Data.UnionMember0.builder().build())
                    .build()
            )

        val roundtrippedDecisionInputPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputPart),
                jacksonTypeRef<DecisionInputPart>(),
            )

        assertThat(roundtrippedDecisionInputPart).isEqualTo(decisionInputPart)
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
        val decisionInputPart =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionInputPart>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionInputPart.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
