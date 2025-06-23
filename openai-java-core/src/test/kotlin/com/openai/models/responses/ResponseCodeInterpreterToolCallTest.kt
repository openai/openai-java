// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterToolCallTest {

    @Test
    fun create() {
        val responseCodeInterpreterToolCall =
            ResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .containerId("container_id")
                .addLogsOutput("logs")
                .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .build()

        assertThat(responseCodeInterpreterToolCall.id()).isEqualTo("id")
        assertThat(responseCodeInterpreterToolCall.code()).contains("code")
        assertThat(responseCodeInterpreterToolCall.containerId()).isEqualTo("container_id")
        assertThat(responseCodeInterpreterToolCall.outputs().getOrNull())
            .containsExactly(
                ResponseCodeInterpreterToolCall.Output.ofLogs(
                    ResponseCodeInterpreterToolCall.Output.Logs.builder().logs("logs").build()
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
                .containerId("container_id")
                .addLogsOutput("logs")
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
