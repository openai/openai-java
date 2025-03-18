// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RequiredActionFunctionToolCallTest {

    @Test
    fun create() {
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
