// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCustomToolCallTest {

    @Test
    fun create() {
        val betaResponseCustomToolCall =
            BetaResponseCustomToolCall.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .agent(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .build()

        assertThat(betaResponseCustomToolCall.callId()).isEqualTo("call_id")
        assertThat(betaResponseCustomToolCall.input()).isEqualTo("input")
        assertThat(betaResponseCustomToolCall.name()).isEqualTo("name")
        assertThat(betaResponseCustomToolCall.id()).contains("id")
        assertThat(betaResponseCustomToolCall.agent())
            .contains(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseCustomToolCall.caller())
            .contains(BetaResponseCustomToolCall.Caller.ofDirect())
        assertThat(betaResponseCustomToolCall.namespace()).contains("namespace")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCustomToolCall =
            BetaResponseCustomToolCall.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .agent(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .build()

        val roundtrippedBetaResponseCustomToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCustomToolCall),
                jacksonTypeRef<BetaResponseCustomToolCall>(),
            )

        assertThat(roundtrippedBetaResponseCustomToolCall).isEqualTo(betaResponseCustomToolCall)
    }
}
