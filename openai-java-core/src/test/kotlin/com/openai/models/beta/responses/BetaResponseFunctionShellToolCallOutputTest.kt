// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionShellToolCallOutputTest {

    @Test
    fun create() {
        val betaResponseFunctionShellToolCallOutput =
            BetaResponseFunctionShellToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .maxOutputLength(0L)
                .addOutput(
                    BetaResponseFunctionShellToolCallOutput.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .status(BetaResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionShellToolCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        assertThat(betaResponseFunctionShellToolCallOutput.id()).isEqualTo("id")
        assertThat(betaResponseFunctionShellToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(betaResponseFunctionShellToolCallOutput.maxOutputLength()).contains(0L)
        assertThat(betaResponseFunctionShellToolCallOutput.output())
            .containsExactly(
                BetaResponseFunctionShellToolCallOutput.Output.builder()
                    .outcomeTimeout()
                    .stderr("stderr")
                    .stdout("stdout")
                    .createdBy("created_by")
                    .build()
            )
        assertThat(betaResponseFunctionShellToolCallOutput.status())
            .isEqualTo(BetaResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
        assertThat(betaResponseFunctionShellToolCallOutput.agent())
            .contains(
                BetaResponseFunctionShellToolCallOutput.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseFunctionShellToolCallOutput.caller())
            .contains(BetaResponseFunctionShellToolCallOutput.Caller.ofDirect())
        assertThat(betaResponseFunctionShellToolCallOutput.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionShellToolCallOutput =
            BetaResponseFunctionShellToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .maxOutputLength(0L)
                .addOutput(
                    BetaResponseFunctionShellToolCallOutput.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .status(BetaResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionShellToolCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseFunctionShellToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionShellToolCallOutput),
                jacksonTypeRef<BetaResponseFunctionShellToolCallOutput>(),
            )

        assertThat(roundtrippedBetaResponseFunctionShellToolCallOutput)
            .isEqualTo(betaResponseFunctionShellToolCallOutput)
    }
}
