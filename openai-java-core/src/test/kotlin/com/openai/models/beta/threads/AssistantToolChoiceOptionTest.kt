// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantToolChoiceOptionTest {

    @Test
    fun ofAuto() {
        val auto = AssistantToolChoiceOption.Auto.NONE

        val assistantToolChoiceOption = AssistantToolChoiceOption.ofAuto(auto)

        assertThat(assistantToolChoiceOption.auto()).contains(auto)
        assertThat(assistantToolChoiceOption.assistantToolChoice()).isEmpty
    }

    @Test
    fun ofAssistantToolChoice() {
        val assistantToolChoice =
            AssistantToolChoice.builder().type(AssistantToolChoice.Type.FUNCTION).build()

        val assistantToolChoiceOption =
            AssistantToolChoiceOption.ofAssistantToolChoice(assistantToolChoice)

        assertThat(assistantToolChoiceOption.auto()).isEmpty
        assertThat(assistantToolChoiceOption.assistantToolChoice()).contains(assistantToolChoice)
    }
}
