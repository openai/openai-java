// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssistantToolChoiceFunctionTest {

    @Test
    fun createAssistantToolChoiceFunction() {
        val assistantToolChoiceFunction = AssistantToolChoiceFunction.builder().name("name").build()
        assertThat(assistantToolChoiceFunction).isNotNull
        assertThat(assistantToolChoiceFunction.name()).isEqualTo("name")
    }
}
