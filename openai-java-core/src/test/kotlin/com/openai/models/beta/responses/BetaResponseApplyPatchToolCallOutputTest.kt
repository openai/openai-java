// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseApplyPatchToolCallOutputTest {

    @Test
    fun create() {
        val betaResponseApplyPatchToolCallOutput =
            BetaResponseApplyPatchToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .status(BetaResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .agent(
                    BetaResponseApplyPatchToolCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .output("output")
                .build()

        assertThat(betaResponseApplyPatchToolCallOutput.id()).isEqualTo("id")
        assertThat(betaResponseApplyPatchToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(betaResponseApplyPatchToolCallOutput.status())
            .isEqualTo(BetaResponseApplyPatchToolCallOutput.Status.COMPLETED)
        assertThat(betaResponseApplyPatchToolCallOutput.agent())
            .contains(
                BetaResponseApplyPatchToolCallOutput.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseApplyPatchToolCallOutput.caller())
            .contains(BetaResponseApplyPatchToolCallOutput.Caller.ofDirect())
        assertThat(betaResponseApplyPatchToolCallOutput.createdBy()).contains("created_by")
        assertThat(betaResponseApplyPatchToolCallOutput.output()).contains("output")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseApplyPatchToolCallOutput =
            BetaResponseApplyPatchToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .status(BetaResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .agent(
                    BetaResponseApplyPatchToolCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .output("output")
                .build()

        val roundtrippedBetaResponseApplyPatchToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseApplyPatchToolCallOutput),
                jacksonTypeRef<BetaResponseApplyPatchToolCallOutput>(),
            )

        assertThat(roundtrippedBetaResponseApplyPatchToolCallOutput)
            .isEqualTo(betaResponseApplyPatchToolCallOutput)
    }
}
