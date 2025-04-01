// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterToolCallTest {

    @Test
    fun create() {
        val responseCodeInterpreterToolCall =
            ResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .addLogsResult("logs")
                .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .build()

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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCodeInterpreterToolCall =
            ResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .addLogsResult("logs")
                .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .build()

        val roundtrippedResponseCodeInterpreterToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterToolCall),
                jacksonTypeRef<ResponseCodeInterpreterToolCall>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterToolCall)
            .isEqualTo(responseCodeInterpreterToolCall)
    }
}
