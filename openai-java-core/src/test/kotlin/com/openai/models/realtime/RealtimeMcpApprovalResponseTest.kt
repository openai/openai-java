// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcpApprovalResponseTest {

    @Test
    fun create() {
        val realtimeMcpApprovalResponse =
            RealtimeMcpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .reason("reason")
                .build()

        assertThat(realtimeMcpApprovalResponse.id()).isEqualTo("id")
        assertThat(realtimeMcpApprovalResponse.approvalRequestId()).isEqualTo("approval_request_id")
        assertThat(realtimeMcpApprovalResponse.approve()).isEqualTo(true)
        assertThat(realtimeMcpApprovalResponse.reason()).contains("reason")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcpApprovalResponse =
            RealtimeMcpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .reason("reason")
                .build()

        val roundtrippedRealtimeMcpApprovalResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcpApprovalResponse),
                jacksonTypeRef<RealtimeMcpApprovalResponse>(),
            )

        assertThat(roundtrippedRealtimeMcpApprovalResponse).isEqualTo(realtimeMcpApprovalResponse)
    }
}
