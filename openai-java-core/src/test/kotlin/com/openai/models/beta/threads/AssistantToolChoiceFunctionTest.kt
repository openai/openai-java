// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantToolChoiceFunctionTest {

    @Test
    fun create() {
        val assistantToolChoiceFunction = AssistantToolChoiceFunction.builder().name("name").build()

        assertThat(assistantToolChoiceFunction.name()).isEqualTo("name")
    }
}
