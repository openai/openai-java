// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

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
}
