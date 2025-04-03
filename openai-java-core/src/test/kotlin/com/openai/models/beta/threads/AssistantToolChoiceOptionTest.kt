// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val assistantToolChoiceOption =
            jsonMapper().convertValue(value, jacksonTypeRef<AssistantToolChoiceOption>())

        val e = assertThrows<OpenAIInvalidDataException> { assistantToolChoiceOption.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
