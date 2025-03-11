// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseCodeInterpreterToolCallTest {

    @Test
    fun createResponseCodeInterpreterToolCall() {
        val responseCodeInterpreterToolCall =
            ResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .addLogsResult("logs")
                .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .build()
        assertThat(responseCodeInterpreterToolCall).isNotNull
        assertThat(responseCodeInterpreterToolCall.id()).isEqualTo("id")
        assertThat(responseCodeInterpreterToolCall.code()).isEqualTo("code")
        assertThat(responseCodeInterpreterToolCall.results())
            .containsExactly(
                ResponseCodeInterpreterToolCall.Result.ofLogs(
                    ResponseCodeInterpreterToolCall.Result.Logs.builder().logs("logs").build()
                )
            )
        assertThat(responseCodeInterpreterToolCall.status())
            .isEqualTo(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
    }
}
