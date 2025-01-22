// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionToolCallTest {

    @Test
    fun createFunctionToolCall() {
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
        assertThat(functionToolCall).isNotNull
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
