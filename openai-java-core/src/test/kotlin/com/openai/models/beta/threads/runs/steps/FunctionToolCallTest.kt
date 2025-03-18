// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionToolCallTest {

    @Test
    fun create() {
        val functionToolCall =
            FunctionToolCall.builder()
                .id("id")
                .function(
                    FunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()

        assertThat(functionToolCall.id()).isEqualTo("id")
        assertThat(functionToolCall.function())
            .isEqualTo(
                FunctionToolCall.Function.builder()
                    .arguments("arguments")
                    .name("name")
                    .output("output")
                    .build()
            )
    }
}
