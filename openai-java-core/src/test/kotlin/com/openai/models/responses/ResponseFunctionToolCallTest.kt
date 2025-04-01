// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionToolCallTest {

    @Test
    fun create() {
        val responseFunctionToolCall =
            ResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        assertThat(responseFunctionToolCall.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionToolCall.callId()).isEqualTo("call_id")
        assertThat(responseFunctionToolCall.name()).isEqualTo("name")
        assertThat(responseFunctionToolCall.id()).contains("id")
        assertThat(responseFunctionToolCall.status())
            .contains(ResponseFunctionToolCall.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionToolCall =
            ResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        val roundtrippedResponseFunctionToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionToolCall),
                jacksonTypeRef<ResponseFunctionToolCall>(),
            )

        assertThat(roundtrippedResponseFunctionToolCall).isEqualTo(responseFunctionToolCall)
    }
}
