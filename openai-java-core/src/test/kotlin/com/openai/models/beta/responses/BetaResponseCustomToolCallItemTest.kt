// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCustomToolCallItemTest {

    @Test
    fun create() {
        val betaResponseCustomToolCallItem =
            BetaResponseCustomToolCallItem.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .agent(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseCustomToolCallItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(betaResponseCustomToolCallItem.callId()).isEqualTo("call_id")
        assertThat(betaResponseCustomToolCallItem.input()).isEqualTo("input")
        assertThat(betaResponseCustomToolCallItem.name()).isEqualTo("name")
        assertThat(betaResponseCustomToolCallItem.id()).contains("id")
        assertThat(betaResponseCustomToolCallItem.agent())
            .contains(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseCustomToolCallItem.caller())
            .contains(BetaResponseCustomToolCall.Caller.ofDirect())
        assertThat(betaResponseCustomToolCallItem.namespace()).contains("namespace")
        assertThat(betaResponseCustomToolCallItem.status())
            .isEqualTo(BetaResponseCustomToolCallItem.Status.IN_PROGRESS)
        assertThat(betaResponseCustomToolCallItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCustomToolCallItem =
            BetaResponseCustomToolCallItem.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .agent(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseCustomToolCallItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseCustomToolCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCustomToolCallItem),
                jacksonTypeRef<BetaResponseCustomToolCallItem>(),
            )

        assertThat(roundtrippedBetaResponseCustomToolCallItem)
            .isEqualTo(betaResponseCustomToolCallItem)
    }
}
