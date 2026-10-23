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

internal class DecisionInputItemTest {

    @Test
    fun ofFunctionCall() {
        val functionCall =
            DecisionInputItem.FunctionCall.builder()
                .arguments("arguments")
                .callId("x")
                .name("name")
                .id("id")
                .namespace("namespace")
                .status(DecisionInputItem.FunctionCall.Status.IN_PROGRESS)
                .build()

        val decisionInputItem = DecisionInputItem.ofFunctionCall(functionCall)

        assertThat(decisionInputItem.functionCall()).contains(functionCall)
        assertThat(decisionInputItem.functionCallOutput()).isEmpty
        assertThat(decisionInputItem.customToolCall()).isEmpty
        assertThat(decisionInputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputItem =
            DecisionInputItem.ofFunctionCall(
                DecisionInputItem.FunctionCall.builder()
                    .arguments("arguments")
                    .callId("x")
                    .name("name")
                    .id("id")
                    .namespace("namespace")
                    .status(DecisionInputItem.FunctionCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedDecisionInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputItem),
                jacksonTypeRef<DecisionInputItem>(),
            )

        assertThat(roundtrippedDecisionInputItem).isEqualTo(decisionInputItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            DecisionInputItem.FunctionCallOutput.builder()
                .callId("x")
                .output("string")
                .id("id")
                .status(DecisionInputItem.FunctionCallOutput.Status.IN_PROGRESS)
                .build()

        val decisionInputItem = DecisionInputItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(decisionInputItem.functionCall()).isEmpty
        assertThat(decisionInputItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(decisionInputItem.customToolCall()).isEmpty
        assertThat(decisionInputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputItem =
            DecisionInputItem.ofFunctionCallOutput(
                DecisionInputItem.FunctionCallOutput.builder()
                    .callId("x")
                    .output("string")
                    .id("id")
                    .status(DecisionInputItem.FunctionCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedDecisionInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputItem),
                jacksonTypeRef<DecisionInputItem>(),
            )

        assertThat(roundtrippedDecisionInputItem).isEqualTo(decisionInputItem)
    }

    @Test
    fun ofCustomToolCall() {
        val customToolCall =
            DecisionInputItem.CustomToolCall.builder()
                .callId("x")
                .input("input")
                .name("name")
                .id("id")
                .namespace("namespace")
                .status(DecisionInputItem.CustomToolCall.Status.IN_PROGRESS)
                .build()

        val decisionInputItem = DecisionInputItem.ofCustomToolCall(customToolCall)

        assertThat(decisionInputItem.functionCall()).isEmpty
        assertThat(decisionInputItem.functionCallOutput()).isEmpty
        assertThat(decisionInputItem.customToolCall()).contains(customToolCall)
        assertThat(decisionInputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCustomToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputItem =
            DecisionInputItem.ofCustomToolCall(
                DecisionInputItem.CustomToolCall.builder()
                    .callId("x")
                    .input("input")
                    .name("name")
                    .id("id")
                    .namespace("namespace")
                    .status(DecisionInputItem.CustomToolCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedDecisionInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputItem),
                jacksonTypeRef<DecisionInputItem>(),
            )

        assertThat(roundtrippedDecisionInputItem).isEqualTo(decisionInputItem)
    }

    @Test
    fun ofCustomToolCallOutput() {
        val customToolCallOutput =
            DecisionInputItem.CustomToolCallOutput.builder()
                .callId("x")
                .output("string")
                .id("id")
                .status(DecisionInputItem.CustomToolCallOutput.Status.IN_PROGRESS)
                .build()

        val decisionInputItem = DecisionInputItem.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(decisionInputItem.functionCall()).isEmpty
        assertThat(decisionInputItem.functionCallOutput()).isEmpty
        assertThat(decisionInputItem.customToolCall()).isEmpty
        assertThat(decisionInputItem.customToolCallOutput()).contains(customToolCallOutput)
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputItem =
            DecisionInputItem.ofCustomToolCallOutput(
                DecisionInputItem.CustomToolCallOutput.builder()
                    .callId("x")
                    .output("string")
                    .id("id")
                    .status(DecisionInputItem.CustomToolCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedDecisionInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputItem),
                jacksonTypeRef<DecisionInputItem>(),
            )

        assertThat(roundtrippedDecisionInputItem).isEqualTo(decisionInputItem)
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
        val decisionInputItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionInputItem>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionInputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
