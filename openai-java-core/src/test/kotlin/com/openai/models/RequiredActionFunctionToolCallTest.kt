// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RequiredActionFunctionToolCallTest {

    @Test
    fun createRequiredActionFunctionToolCall() {
        val requiredActionFunctionToolCall =
            RequiredActionFunctionToolCall.builder()
                .id("id")
                .function(
                    RequiredActionFunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .build()
        assertThat(requiredActionFunctionToolCall).isNotNull
        assertThat(requiredActionFunctionToolCall.id()).isEqualTo("id")
        assertThat(requiredActionFunctionToolCall.function())
            .isEqualTo(
                RequiredActionFunctionToolCall.Function.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
    }
}
