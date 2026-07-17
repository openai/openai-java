// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCustomToolCallOutputTest {

    @Test
    fun create() {
        val betaResponseCustomToolCallOutput =
            BetaResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .agent(
                    BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .build()

        assertThat(betaResponseCustomToolCallOutput.callId()).isEqualTo("call_id")
        assertThat(betaResponseCustomToolCallOutput.output())
            .isEqualTo(BetaResponseCustomToolCallOutput.Output.ofString("string"))
        assertThat(betaResponseCustomToolCallOutput.id()).contains("id")
        assertThat(betaResponseCustomToolCallOutput.agent())
            .contains(
                BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseCustomToolCallOutput.caller())
            .contains(BetaResponseCustomToolCallOutput.Caller.ofDirect())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCustomToolCallOutput =
            BetaResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .agent(
                    BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .build()

        val roundtrippedBetaResponseCustomToolCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCustomToolCallOutput),
                jacksonTypeRef<BetaResponseCustomToolCallOutput>(),
            )

        assertThat(roundtrippedBetaResponseCustomToolCallOutput)
            .isEqualTo(betaResponseCustomToolCallOutput)
    }
}
