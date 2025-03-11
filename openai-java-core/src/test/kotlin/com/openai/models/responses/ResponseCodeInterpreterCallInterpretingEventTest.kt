// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseCodeInterpreterCallInterpretingEventTest {

    @Test
    fun createResponseCodeInterpreterCallInterpretingEvent() {
        val responseCodeInterpreterCallInterpretingEvent =
            ResponseCodeInterpreterCallInterpretingEvent.builder()
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
        assertThat(responseCodeInterpreterCallInterpretingEvent).isNotNull
        assertThat(responseCodeInterpreterCallInterpretingEvent.codeInterpreterCall())
            .isEqualTo(
                ResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .addLogsResult("logs")
                    .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                    .build()
            )
        assertThat(responseCodeInterpreterCallInterpretingEvent.outputIndex()).isEqualTo(0L)
    }
}
