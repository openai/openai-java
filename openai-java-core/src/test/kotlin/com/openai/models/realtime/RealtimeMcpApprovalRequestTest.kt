// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcpApprovalRequestTest {

    @Test
    fun create() {
        val realtimeMcpApprovalRequest =
            RealtimeMcpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .build()

        assertThat(realtimeMcpApprovalRequest.id()).isEqualTo("id")
        assertThat(realtimeMcpApprovalRequest.arguments()).isEqualTo("arguments")
        assertThat(realtimeMcpApprovalRequest.name()).isEqualTo("name")
        assertThat(realtimeMcpApprovalRequest.serverLabel()).isEqualTo("server_label")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcpApprovalRequest =
            RealtimeMcpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .build()

        val roundtrippedRealtimeMcpApprovalRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcpApprovalRequest),
                jacksonTypeRef<RealtimeMcpApprovalRequest>(),
            )

        assertThat(roundtrippedRealtimeMcpApprovalRequest).isEqualTo(realtimeMcpApprovalRequest)
    }
}
