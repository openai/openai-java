// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseCodeInterpreterCallInProgressEventTest {

    @Test
    fun createResponseCodeInterpreterCallInProgressEvent() {
        val responseCodeInterpreterCallInProgressEvent =
            ResponseCodeInterpreterCallInProgressEvent.builder()
                .codeInterpreterCall(
                    ResponseCodeInterpreterToolCall.builder()
                        .id("id")
                        .code("code")
                        .addLogsResult("logs")
                        .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
                .build()
        assertThat(responseCodeInterpreterCallInProgressEvent).isNotNull
        assertThat(responseCodeInterpreterCallInProgressEvent.codeInterpreterCall())
            .isEqualTo(
                ResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .addLogsResult("logs")
                    .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                    .build()
            )
        assertThat(responseCodeInterpreterCallInProgressEvent.outputIndex()).isEqualTo(0L)
    }
}
