// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCustomToolCallOutputTest {

    @Test
    fun create() {
        val responseCustomToolCallOutput =
            ResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .callerDirect()
                .build()

        assertThat(responseCustomToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(responseCustomToolCallOutput.output())
            .isEqualTo(ResponseCustomToolCallOutput.Output.ofString("string"))
        assertThat(responseCustomToolCallOutput.id()).contains("id")
        assertThat(responseCustomToolCallOutput.caller())
            .contains(ResponseCustomToolCallOutput.Caller.ofDirect())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCallOutput =
            ResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .callerDirect()
                .build()

        val roundtrippedResponseCustomToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCallOutput),
                jacksonTypeRef<ResponseCustomToolCallOutput>(),
            )

        assertThat(roundtrippedResponseCustomToolCallOutput).isEqualTo(responseCustomToolCallOutput)
    }
}
