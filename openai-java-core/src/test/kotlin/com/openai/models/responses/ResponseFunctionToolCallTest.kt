// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFunctionToolCallTest {

    @Test
    fun createResponseFunctionToolCall() {
        val responseFunctionToolCall =
            ResponseFunctionToolCall.builder()
                .id("id")
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()
        assertThat(responseFunctionToolCall).isNotNull
        assertThat(responseFunctionToolCall.id()).isEqualTo("id")
        assertThat(responseFunctionToolCall.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionToolCall.callId()).isEqualTo("call_id")
        assertThat(responseFunctionToolCall.name()).isEqualTo("name")
        assertThat(responseFunctionToolCall.status())
            .contains(ResponseFunctionToolCall.Status.IN_PROGRESS)
    }
}
