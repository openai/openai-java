// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionToolCallDeltaTest {

    @Test
    fun create() {
        val functionToolCallDelta =
            FunctionToolCallDelta.builder()
                .index(0L)
                .id("id")
                .function(
                    FunctionToolCallDelta.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()

        assertThat(functionToolCallDelta.index()).isEqualTo(0L)
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionToolCallDelta =
            FunctionToolCallDelta.builder()
                .index(0L)
                .id("id")
                .function(
                    FunctionToolCallDelta.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()

        val roundtrippedFunctionToolCallDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionToolCallDelta),
                jacksonTypeRef<FunctionToolCallDelta>(),
            )

        assertThat(roundtrippedFunctionToolCallDelta).isEqualTo(functionToolCallDelta)
    }
}
