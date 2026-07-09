// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionToolCallOutputItemTest {

    @Test
    fun create() {
        val betaResponseFunctionToolCallOutputItem =
            BetaResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("string")
                .status(BetaResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionToolCallOutputItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        assertThat(betaResponseFunctionToolCallOutputItem.id()).isEqualTo("id")
        assertThat(betaResponseFunctionToolCallOutputItem.callId()).isEqualTo("call_id")
        assertThat(betaResponseFunctionToolCallOutputItem.output())
            .isEqualTo(BetaResponseFunctionToolCallOutputItem.Output.ofString("string"))
        assertThat(betaResponseFunctionToolCallOutputItem.status())
            .isEqualTo(BetaResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
        assertThat(betaResponseFunctionToolCallOutputItem.agent())
            .contains(
                BetaResponseFunctionToolCallOutputItem.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseFunctionToolCallOutputItem.caller())
            .contains(BetaResponseFunctionToolCallOutputItem.Caller.ofDirect())
        assertThat(betaResponseFunctionToolCallOutputItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionToolCallOutputItem =
            BetaResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("string")
                .status(BetaResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionToolCallOutputItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseFunctionToolCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionToolCallOutputItem),
                jacksonTypeRef<BetaResponseFunctionToolCallOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseFunctionToolCallOutputItem)
            .isEqualTo(betaResponseFunctionToolCallOutputItem)
    }
}
