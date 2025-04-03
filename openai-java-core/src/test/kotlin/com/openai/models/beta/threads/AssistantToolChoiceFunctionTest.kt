// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantToolChoiceFunctionTest {

    @Test
    fun create() {
        val assistantToolChoiceFunction = AssistantToolChoiceFunction.builder().name("name").build()

        assertThat(assistantToolChoiceFunction.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val assistantToolChoiceFunction = AssistantToolChoiceFunction.builder().name("name").build()

        val roundtrippedAssistantToolChoiceFunction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantToolChoiceFunction),
                jacksonTypeRef<AssistantToolChoiceFunction>(),
            )

        assertThat(roundtrippedAssistantToolChoiceFunction).isEqualTo(assistantToolChoiceFunction)
    }
}
