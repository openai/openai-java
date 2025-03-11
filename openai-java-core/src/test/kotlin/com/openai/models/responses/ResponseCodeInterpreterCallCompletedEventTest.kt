// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseCodeInterpreterCallCompletedEventTest {

    @Test
    fun createResponseCodeInterpreterCallCompletedEvent() {
        val responseCodeInterpreterCallCompletedEvent =
            ResponseCodeInterpreterCallCompletedEvent.builder()
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
        assertThat(responseCodeInterpreterCallCompletedEvent).isNotNull
        assertThat(responseCodeInterpreterCallCompletedEvent.codeInterpreterCall())
            .isEqualTo(
                ResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .addLogsResult("logs")
                    .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                    .build()
            )
        assertThat(responseCodeInterpreterCallCompletedEvent.outputIndex()).isEqualTo(0L)
    }
}
