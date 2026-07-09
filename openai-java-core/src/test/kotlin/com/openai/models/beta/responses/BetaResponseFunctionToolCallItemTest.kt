// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionToolCallItemTest {

    @Test
    fun create() {
        val betaResponseFunctionToolCallItem =
            BetaResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .agent(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(betaResponseFunctionToolCallItem.arguments()).isEqualTo("arguments")
        assertThat(betaResponseFunctionToolCallItem.callId()).isEqualTo("call_id")
        assertThat(betaResponseFunctionToolCallItem.name()).isEqualTo("name")
        assertThat(betaResponseFunctionToolCallItem.id()).contains("id")
        assertThat(betaResponseFunctionToolCallItem.agent())
            .contains(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseFunctionToolCallItem.caller())
            .contains(BetaResponseFunctionToolCall.Caller.ofDirect())
        assertThat(betaResponseFunctionToolCallItem.namespace()).contains("namespace")
        assertThat(betaResponseFunctionToolCallItem.status())
            .contains(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
        assertThat(betaResponseFunctionToolCallItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionToolCallItem =
            BetaResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .agent(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseFunctionToolCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionToolCallItem),
                jacksonTypeRef<BetaResponseFunctionToolCallItem>(),
            )

        assertThat(roundtrippedBetaResponseFunctionToolCallItem)
            .isEqualTo(betaResponseFunctionToolCallItem)
    }
}
