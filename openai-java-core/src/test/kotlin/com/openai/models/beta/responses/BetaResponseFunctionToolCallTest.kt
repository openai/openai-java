// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionToolCallTest {

    @Test
    fun create() {
        val betaResponseFunctionToolCall =
            BetaResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .agent(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        assertThat(betaResponseFunctionToolCall.arguments()).isEqualTo("arguments")
        assertThat(betaResponseFunctionToolCall.callId()).isEqualTo("call_id")
        assertThat(betaResponseFunctionToolCall.name()).isEqualTo("name")
        assertThat(betaResponseFunctionToolCall.id()).contains("id")
        assertThat(betaResponseFunctionToolCall.agent())
            .contains(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseFunctionToolCall.caller())
            .contains(BetaResponseFunctionToolCall.Caller.ofDirect())
        assertThat(betaResponseFunctionToolCall.namespace()).contains("namespace")
        assertThat(betaResponseFunctionToolCall.status())
            .contains(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionToolCall =
            BetaResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .agent(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        val roundtrippedBetaResponseFunctionToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionToolCall),
                jacksonTypeRef<BetaResponseFunctionToolCall>(),
            )

        assertThat(roundtrippedBetaResponseFunctionToolCall).isEqualTo(betaResponseFunctionToolCall)
    }
}
