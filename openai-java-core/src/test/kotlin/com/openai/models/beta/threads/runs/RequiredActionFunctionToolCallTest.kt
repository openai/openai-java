// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedRequiredActionFunctionToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(requiredActionFunctionToolCall),
                jacksonTypeRef<RequiredActionFunctionToolCall>(),
            )

        assertThat(roundtrippedRequiredActionFunctionToolCall)
            .isEqualTo(requiredActionFunctionToolCall)
    }
}
