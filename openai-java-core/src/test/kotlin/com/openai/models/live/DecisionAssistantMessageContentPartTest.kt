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

internal class DecisionAssistantMessageContentPartTest {

    @Test
    fun ofOutputText() {
        val outputText =
            DecisionAssistantMessageContentPart.OutputText.builder().text("text").build()

        val decisionAssistantMessageContentPart =
            DecisionAssistantMessageContentPart.ofOutputText(outputText)

        assertThat(decisionAssistantMessageContentPart.outputText()).contains(outputText)
        assertThat(decisionAssistantMessageContentPart.refusal()).isEmpty
    }

    @Test
    fun ofOutputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionAssistantMessageContentPart =
            DecisionAssistantMessageContentPart.ofOutputText(
                DecisionAssistantMessageContentPart.OutputText.builder().text("text").build()
            )

        val roundtrippedDecisionAssistantMessageContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionAssistantMessageContentPart),
                jacksonTypeRef<DecisionAssistantMessageContentPart>(),
            )

        assertThat(roundtrippedDecisionAssistantMessageContentPart)
            .isEqualTo(decisionAssistantMessageContentPart)
    }

    @Test
    fun ofRefusal() {
        val refusal =
            DecisionAssistantMessageContentPart.Refusal.builder().refusal("refusal").build()

        val decisionAssistantMessageContentPart =
            DecisionAssistantMessageContentPart.ofRefusal(refusal)

        assertThat(decisionAssistantMessageContentPart.outputText()).isEmpty
        assertThat(decisionAssistantMessageContentPart.refusal()).contains(refusal)
    }

    @Test
    fun ofRefusalRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionAssistantMessageContentPart =
            DecisionAssistantMessageContentPart.ofRefusal(
                DecisionAssistantMessageContentPart.Refusal.builder().refusal("refusal").build()
            )

        val roundtrippedDecisionAssistantMessageContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionAssistantMessageContentPart),
                jacksonTypeRef<DecisionAssistantMessageContentPart>(),
            )

        assertThat(roundtrippedDecisionAssistantMessageContentPart)
            .isEqualTo(decisionAssistantMessageContentPart)
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
        val decisionAssistantMessageContentPart =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<DecisionAssistantMessageContentPart>())

        val e =
            assertThrows<OpenAIInvalidDataException> {
                decisionAssistantMessageContentPart.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
