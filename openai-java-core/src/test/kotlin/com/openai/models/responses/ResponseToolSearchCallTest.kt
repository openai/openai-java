// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseToolSearchCallTest {

    @Test
    fun create() {
        val responseToolSearchCall =
            ResponseToolSearchCall.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .execution(ResponseToolSearchCall.Execution.SERVER)
                .status(ResponseToolSearchCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseToolSearchCall.id()).isEqualTo("id")
        assertThat(responseToolSearchCall._arguments())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(responseToolSearchCall.callId()).contains("call_id")
        assertThat(responseToolSearchCall.execution())
            .isEqualTo(ResponseToolSearchCall.Execution.SERVER)
        assertThat(responseToolSearchCall.status())
            .isEqualTo(ResponseToolSearchCall.Status.IN_PROGRESS)
        assertThat(responseToolSearchCall.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseToolSearchCall =
            ResponseToolSearchCall.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .execution(ResponseToolSearchCall.Execution.SERVER)
                .status(ResponseToolSearchCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseToolSearchCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseToolSearchCall),
                jacksonTypeRef<ResponseToolSearchCall>(),
            )

        assertThat(roundtrippedResponseToolSearchCall).isEqualTo(responseToolSearchCall)
    }
}
