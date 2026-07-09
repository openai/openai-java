// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionShellToolCallTest {

    @Test
    fun create() {
        val betaResponseFunctionShellToolCall =
            BetaResponseFunctionShellToolCall.builder()
                .id("id")
                .action(
                    BetaResponseFunctionShellToolCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("call_id")
                .environment(BetaResponseLocalEnvironment.builder().build())
                .status(BetaResponseFunctionShellToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionShellToolCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        assertThat(betaResponseFunctionShellToolCall.id()).isEqualTo("id")
        assertThat(betaResponseFunctionShellToolCall.action())
            .isEqualTo(
                BetaResponseFunctionShellToolCall.Action.builder()
                    .addCommand("string")
                    .maxOutputLength(0L)
                    .timeoutMs(0L)
                    .build()
            )
        assertThat(betaResponseFunctionShellToolCall.callId()).isEqualTo("call_id")
        assertThat(betaResponseFunctionShellToolCall.environment())
            .contains(
                BetaResponseFunctionShellToolCall.Environment.ofLocal(
                    BetaResponseLocalEnvironment.builder().build()
                )
            )
        assertThat(betaResponseFunctionShellToolCall.status())
            .isEqualTo(BetaResponseFunctionShellToolCall.Status.IN_PROGRESS)
        assertThat(betaResponseFunctionShellToolCall.agent())
            .contains(
                BetaResponseFunctionShellToolCall.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseFunctionShellToolCall.caller())
            .contains(BetaResponseFunctionShellToolCall.Caller.ofDirect())
        assertThat(betaResponseFunctionShellToolCall.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionShellToolCall =
            BetaResponseFunctionShellToolCall.builder()
                .id("id")
                .action(
                    BetaResponseFunctionShellToolCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("call_id")
                .environment(BetaResponseLocalEnvironment.builder().build())
                .status(BetaResponseFunctionShellToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionShellToolCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseFunctionShellToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionShellToolCall),
                jacksonTypeRef<BetaResponseFunctionShellToolCall>(),
            )

        assertThat(roundtrippedBetaResponseFunctionShellToolCall)
            .isEqualTo(betaResponseFunctionShellToolCall)
    }
}
