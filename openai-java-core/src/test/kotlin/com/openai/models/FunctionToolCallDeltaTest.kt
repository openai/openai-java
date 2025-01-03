// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionToolCallDeltaTest {

    @Test
    fun createFunctionToolCallDelta() {
        val functionToolCallDelta =
            FunctionToolCallDelta.builder()
                .index(0L)
                .type(FunctionToolCallDelta.Type.FUNCTION)
                .id("id")
                .function(
                    FunctionToolCallDelta.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()
        assertThat(functionToolCallDelta).isNotNull
        assertThat(functionToolCallDelta.index()).isEqualTo(0L)
        assertThat(functionToolCallDelta.type()).isEqualTo(FunctionToolCallDelta.Type.FUNCTION)
        assertThat(functionToolCallDelta.id()).contains("id")
        assertThat(functionToolCallDelta.function())
            .contains(
                FunctionToolCallDelta.Function.builder()
                    .arguments("arguments")
                    .name("name")
                    .output("output")
                    .build()
            )
    }
}
