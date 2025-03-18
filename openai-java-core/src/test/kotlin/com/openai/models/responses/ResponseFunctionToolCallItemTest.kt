// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionToolCallItemTest {

    @Test
    fun create() {
        val responseFunctionToolCallItem =
            ResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        assertThat(responseFunctionToolCallItem.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionToolCallItem.callId()).isEqualTo("call_id")
        assertThat(responseFunctionToolCallItem.name()).isEqualTo("name")
        assertThat(responseFunctionToolCallItem.id()).contains("id")
        assertThat(responseFunctionToolCallItem.status())
            .contains(ResponseFunctionToolCall.Status.IN_PROGRESS)
    }
}
