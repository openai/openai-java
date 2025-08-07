// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCustomToolCallTest {

    @Test
    fun create() {
        val responseCustomToolCall =
            ResponseCustomToolCall.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .build()

        assertThat(responseCustomToolCall.callId()).isEqualTo("call_id")
        assertThat(responseCustomToolCall.input()).isEqualTo("input")
        assertThat(responseCustomToolCall.name()).isEqualTo("name")
        assertThat(responseCustomToolCall.id()).contains("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCall =
            ResponseCustomToolCall.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .build()

        val roundtrippedResponseCustomToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCall),
                jacksonTypeRef<ResponseCustomToolCall>(),
            )

        assertThat(roundtrippedResponseCustomToolCall).isEqualTo(responseCustomToolCall)
    }
}
