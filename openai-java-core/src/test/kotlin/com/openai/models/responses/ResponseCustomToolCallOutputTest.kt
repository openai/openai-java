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
                .output("output")
                .id("id")
                .build()

        assertThat(responseCustomToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(responseCustomToolCallOutput.output()).isEqualTo("output")
        assertThat(responseCustomToolCallOutput.id()).contains("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCallOutput =
            ResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("output")
                .id("id")
                .build()

        val roundtrippedResponseCustomToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCallOutput),
                jacksonTypeRef<ResponseCustomToolCallOutput>(),
            )

        assertThat(roundtrippedResponseCustomToolCallOutput).isEqualTo(responseCustomToolCallOutput)
    }
}
