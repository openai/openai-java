// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionShellToolCallTest {

    @Test
    fun create() {
        val responseFunctionShellToolCall =
            ResponseFunctionShellToolCall.builder()
                .id("id")
                .action(
                    ResponseFunctionShellToolCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("call_id")
                .status(ResponseFunctionShellToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseFunctionShellToolCall.id()).isEqualTo("id")
        assertThat(responseFunctionShellToolCall.action())
            .isEqualTo(
                ResponseFunctionShellToolCall.Action.builder()
                    .addCommand("string")
                    .maxOutputLength(0L)
                    .timeoutMs(0L)
                    .build()
            )
        assertThat(responseFunctionShellToolCall.callId()).isEqualTo("call_id")
        assertThat(responseFunctionShellToolCall.status())
            .isEqualTo(ResponseFunctionShellToolCall.Status.IN_PROGRESS)
        assertThat(responseFunctionShellToolCall.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionShellToolCall =
            ResponseFunctionShellToolCall.builder()
                .id("id")
                .action(
                    ResponseFunctionShellToolCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("call_id")
                .status(ResponseFunctionShellToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseFunctionShellToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionShellToolCall),
                jacksonTypeRef<ResponseFunctionShellToolCall>(),
            )

        assertThat(roundtrippedResponseFunctionShellToolCall)
            .isEqualTo(responseFunctionShellToolCall)
    }
}
