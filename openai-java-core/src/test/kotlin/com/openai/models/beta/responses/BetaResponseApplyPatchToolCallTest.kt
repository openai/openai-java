// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseApplyPatchToolCallTest {

    @Test
    fun create() {
        val betaResponseApplyPatchToolCall =
            BetaResponseApplyPatchToolCall.builder()
                .id("id")
                .callId("call_id")
                .operation(
                    BetaResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
                .status(BetaResponseApplyPatchToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseApplyPatchToolCall.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        assertThat(betaResponseApplyPatchToolCall.id()).isEqualTo("id")
        assertThat(betaResponseApplyPatchToolCall.callId()).isEqualTo("call_id")
        assertThat(betaResponseApplyPatchToolCall.operation())
            .isEqualTo(
                BetaResponseApplyPatchToolCall.Operation.ofCreateFile(
                    BetaResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
            )
        assertThat(betaResponseApplyPatchToolCall.status())
            .isEqualTo(BetaResponseApplyPatchToolCall.Status.IN_PROGRESS)
        assertThat(betaResponseApplyPatchToolCall.agent())
            .contains(
                BetaResponseApplyPatchToolCall.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseApplyPatchToolCall.caller())
            .contains(BetaResponseApplyPatchToolCall.Caller.ofDirect())
        assertThat(betaResponseApplyPatchToolCall.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseApplyPatchToolCall =
            BetaResponseApplyPatchToolCall.builder()
                .id("id")
                .callId("call_id")
                .operation(
                    BetaResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
                .status(BetaResponseApplyPatchToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseApplyPatchToolCall.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseApplyPatchToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseApplyPatchToolCall),
                jacksonTypeRef<BetaResponseApplyPatchToolCall>(),
            )

        assertThat(roundtrippedBetaResponseApplyPatchToolCall)
            .isEqualTo(betaResponseApplyPatchToolCall)
    }
}
