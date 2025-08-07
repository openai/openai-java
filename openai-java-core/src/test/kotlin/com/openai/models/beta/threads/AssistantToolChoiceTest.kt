// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantToolChoiceTest {

    @Test
    fun create() {
        val assistantToolChoice =
            AssistantToolChoice.builder()
                .type(AssistantToolChoice.Type.FUNCTION)
                .function(AssistantToolChoiceFunction.builder().name("name").build())
                .build()

        assertThat(assistantToolChoice.type()).isEqualTo(AssistantToolChoice.Type.FUNCTION)
        assertThat(assistantToolChoice.function())
            .contains(AssistantToolChoiceFunction.builder().name("name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val assistantToolChoice =
            AssistantToolChoice.builder()
                .type(AssistantToolChoice.Type.FUNCTION)
                .function(AssistantToolChoiceFunction.builder().name("name").build())
                .build()

        val roundtrippedAssistantToolChoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantToolChoice),
                jacksonTypeRef<AssistantToolChoice>(),
            )

        assertThat(roundtrippedAssistantToolChoice).isEqualTo(assistantToolChoice)
    }
}
