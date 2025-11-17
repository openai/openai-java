// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseApplyPatchToolCallTest {

    @Test
    fun create() {
        val responseApplyPatchToolCall =
            ResponseApplyPatchToolCall.builder()
                .id("id")
                .callId("call_id")
                .operation(
                    ResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
                .status(ResponseApplyPatchToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseApplyPatchToolCall.id()).isEqualTo("id")
        assertThat(responseApplyPatchToolCall.callId()).isEqualTo("call_id")
        assertThat(responseApplyPatchToolCall.operation())
            .isEqualTo(
                ResponseApplyPatchToolCall.Operation.ofCreateFile(
                    ResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
            )
        assertThat(responseApplyPatchToolCall.status())
            .isEqualTo(ResponseApplyPatchToolCall.Status.IN_PROGRESS)
        assertThat(responseApplyPatchToolCall.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseApplyPatchToolCall =
            ResponseApplyPatchToolCall.builder()
                .id("id")
                .callId("call_id")
                .operation(
                    ResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
                .status(ResponseApplyPatchToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseApplyPatchToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseApplyPatchToolCall),
                jacksonTypeRef<ResponseApplyPatchToolCall>(),
            )

        assertThat(roundtrippedResponseApplyPatchToolCall).isEqualTo(responseApplyPatchToolCall)
    }
}
