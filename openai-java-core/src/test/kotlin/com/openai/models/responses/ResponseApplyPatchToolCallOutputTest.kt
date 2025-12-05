// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseApplyPatchToolCallOutputTest {

    @Test
    fun create() {
        val responseApplyPatchToolCallOutput =
            ResponseApplyPatchToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .status(ResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .createdBy("created_by")
                .output("output")
                .build()

        assertThat(responseApplyPatchToolCallOutput.id()).isEqualTo("id")
        assertThat(responseApplyPatchToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(responseApplyPatchToolCallOutput.status())
            .isEqualTo(ResponseApplyPatchToolCallOutput.Status.COMPLETED)
        assertThat(responseApplyPatchToolCallOutput.createdBy()).contains("created_by")
        assertThat(responseApplyPatchToolCallOutput.output()).contains("output")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseApplyPatchToolCallOutput =
            ResponseApplyPatchToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .status(ResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .createdBy("created_by")
                .output("output")
                .build()

        val roundtrippedResponseApplyPatchToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseApplyPatchToolCallOutput),
                jacksonTypeRef<ResponseApplyPatchToolCallOutput>(),
            )

        assertThat(roundtrippedResponseApplyPatchToolCallOutput)
            .isEqualTo(responseApplyPatchToolCallOutput)
    }
}
