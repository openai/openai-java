// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionShellToolCallOutputTest {

    @Test
    fun create() {
        val responseFunctionShellToolCallOutput =
            ResponseFunctionShellToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .maxOutputLength(0L)
                .addOutput(
                    ResponseFunctionShellToolCallOutput.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .status(ResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseFunctionShellToolCallOutput.id()).isEqualTo("id")
        assertThat(responseFunctionShellToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(responseFunctionShellToolCallOutput.maxOutputLength()).contains(0L)
        assertThat(responseFunctionShellToolCallOutput.output())
            .containsExactly(
                ResponseFunctionShellToolCallOutput.Output.builder()
                    .outcomeTimeout()
                    .stderr("stderr")
                    .stdout("stdout")
                    .createdBy("created_by")
                    .build()
            )
        assertThat(responseFunctionShellToolCallOutput.status())
            .isEqualTo(ResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
        assertThat(responseFunctionShellToolCallOutput.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionShellToolCallOutput =
            ResponseFunctionShellToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .maxOutputLength(0L)
                .addOutput(
                    ResponseFunctionShellToolCallOutput.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .status(ResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseFunctionShellToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionShellToolCallOutput),
                jacksonTypeRef<ResponseFunctionShellToolCallOutput>(),
            )

        assertThat(roundtrippedResponseFunctionShellToolCallOutput)
            .isEqualTo(responseFunctionShellToolCallOutput)
    }
}
