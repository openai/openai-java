// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcpToolCallTest {

    @Test
    fun create() {
        val realtimeMcpToolCall =
            RealtimeMcpToolCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .approvalRequestId("approval_request_id")
                .error(RealtimeMcpProtocolError.builder().code(0L).message("message").build())
                .output("output")
                .build()

        assertThat(realtimeMcpToolCall.id()).isEqualTo("id")
        assertThat(realtimeMcpToolCall.arguments()).isEqualTo("arguments")
        assertThat(realtimeMcpToolCall.name()).isEqualTo("name")
        assertThat(realtimeMcpToolCall.serverLabel()).isEqualTo("server_label")
        assertThat(realtimeMcpToolCall.approvalRequestId()).contains("approval_request_id")
        assertThat(realtimeMcpToolCall.error())
            .contains(
                RealtimeMcpToolCall.Error.ofProtocol(
                    RealtimeMcpProtocolError.builder().code(0L).message("message").build()
                )
            )
        assertThat(realtimeMcpToolCall.output()).contains("output")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcpToolCall =
            RealtimeMcpToolCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .approvalRequestId("approval_request_id")
                .error(RealtimeMcpProtocolError.builder().code(0L).message("message").build())
                .output("output")
                .build()

        val roundtrippedRealtimeMcpToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcpToolCall),
                jacksonTypeRef<RealtimeMcpToolCall>(),
            )

        assertThat(roundtrippedRealtimeMcpToolCall).isEqualTo(realtimeMcpToolCall)
    }
}
