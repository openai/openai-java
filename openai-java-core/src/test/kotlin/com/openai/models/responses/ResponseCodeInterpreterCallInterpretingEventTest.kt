// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallInterpretingEventTest {

    @Test
    fun create() {
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedResponseCodeInterpreterCallInterpretingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallInterpretingEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallInterpretingEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallInterpretingEvent)
            .isEqualTo(responseCodeInterpreterCallInterpretingEvent)
    }
}
