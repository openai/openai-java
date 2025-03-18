// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionToolCallOutputItemTest {

    @Test
    fun create() {
        val responseFunctionToolCallOutputItem =
            ResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("output")
                .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .build()

        assertThat(responseFunctionToolCallOutputItem.id()).isEqualTo("id")
        assertThat(responseFunctionToolCallOutputItem.callId()).isEqualTo("call_id")
        assertThat(responseFunctionToolCallOutputItem.output()).isEqualTo("output")
        assertThat(responseFunctionToolCallOutputItem.status())
            .contains(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
    }
}
