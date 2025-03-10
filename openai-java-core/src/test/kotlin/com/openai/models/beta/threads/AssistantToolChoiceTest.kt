// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssistantToolChoiceTest {

    @Test
    fun createAssistantToolChoice() {
        val assistantToolChoice =
            AssistantToolChoice.builder()
                .type(AssistantToolChoice.Type.FUNCTION)
                .function(AssistantToolChoiceFunction.builder().name("name").build())
                .build()
        assertThat(assistantToolChoice).isNotNull
        assertThat(assistantToolChoice.type()).isEqualTo(AssistantToolChoice.Type.FUNCTION)
        assertThat(assistantToolChoice.function())
            .contains(AssistantToolChoiceFunction.builder().name("name").build())
    }
}
