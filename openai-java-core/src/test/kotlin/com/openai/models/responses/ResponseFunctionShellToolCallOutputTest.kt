// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionShellToolCallOutputTest {

    @Test
    fun createAndRoundtrip() {
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
                .callerDirect()
                .createdBy("created_by")
                .build()

        assertThat(responseFunctionShellToolCallOutput.id()).contains("id")
        assertThat(responseFunctionShellToolCallOutput.callId()).contains("call_id")
        assertThat(responseFunctionShellToolCallOutput.maxOutputLength()).contains(0L)
        assertThat(responseFunctionShellToolCallOutput.output().getOrNull())
            .containsExactly(
                ResponseFunctionShellToolCallOutput.Output.builder()
                    .outcomeTimeout()
                    .stderr("stderr")
                    .stdout("stdout")
                    .createdBy("created_by")
                    .build()
            )
        assertThat(responseFunctionShellToolCallOutput.status())
            .contains(ResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
        assertThat(responseFunctionShellToolCallOutput.caller())
            .contains(ResponseFunctionShellToolCallOutput.Caller.ofDirect())
        assertThat(responseFunctionShellToolCallOutput.createdBy()).contains("created_by")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFunctionShellToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionShellToolCallOutput),
                jacksonTypeRef<ResponseFunctionShellToolCallOutput>(),
            )

        assertThat(roundtrippedResponseFunctionShellToolCallOutput)
            .isEqualTo(responseFunctionShellToolCallOutput)
    }
}
