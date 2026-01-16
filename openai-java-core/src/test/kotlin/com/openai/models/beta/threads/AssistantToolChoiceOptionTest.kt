// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AssistantToolChoiceOptionTest {

    @Test
    fun ofAuto() {
        val auto = AssistantToolChoiceOption.Auto.NONE

        val assistantToolChoiceOption = AssistantToolChoiceOption.ofAuto(auto)

        assertThat(assistantToolChoiceOption.auto()).contains(auto)
        assertThat(assistantToolChoiceOption.assistantToolChoice()).isEmpty
    }

    @Test
    fun ofAutoRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantToolChoiceOption =
            AssistantToolChoiceOption.ofAuto(AssistantToolChoiceOption.Auto.NONE)

        val roundtrippedAssistantToolChoiceOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantToolChoiceOption),
                jacksonTypeRef<AssistantToolChoiceOption>(),
            )

        assertThat(roundtrippedAssistantToolChoiceOption).isEqualTo(assistantToolChoiceOption)
    }

    @Test
    fun ofAssistantToolChoice() {
        val assistantToolChoice =
            AssistantToolChoice.builder()
                .type(AssistantToolChoice.Type.FUNCTION)
                .function(AssistantToolChoiceFunction.builder().name("name").build())
                .build()

        val assistantToolChoiceOption =
            AssistantToolChoiceOption.ofAssistantToolChoice(assistantToolChoice)

        assertThat(assistantToolChoiceOption.auto()).isEmpty
        assertThat(assistantToolChoiceOption.assistantToolChoice()).contains(assistantToolChoice)
    }

    @Test
    fun ofAssistantToolChoiceRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantToolChoiceOption =
            AssistantToolChoiceOption.ofAssistantToolChoice(
                AssistantToolChoice.builder()
                    .type(AssistantToolChoice.Type.FUNCTION)
                    .function(AssistantToolChoiceFunction.builder().name("name").build())
                    .build()
            )

        val roundtrippedAssistantToolChoiceOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantToolChoiceOption),
                jacksonTypeRef<AssistantToolChoiceOption>(),
            )

        assertThat(roundtrippedAssistantToolChoiceOption).isEqualTo(assistantToolChoiceOption)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val assistantToolChoiceOption =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AssistantToolChoiceOption>())

        val e = assertThrows<OpenAIInvalidDataException> { assistantToolChoiceOption.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
