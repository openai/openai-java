// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCustomToolCallOutputItemTest {

    @Test
    fun create() {
        val betaResponseCustomToolCallOutputItem =
            BetaResponseCustomToolCallOutputItem.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .agent(
                    BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .status(BetaResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(betaResponseCustomToolCallOutputItem.callId()).isEqualTo("call_id")
        assertThat(betaResponseCustomToolCallOutputItem.output())
            .isEqualTo(BetaResponseCustomToolCallOutput.Output.ofString("string"))
        assertThat(betaResponseCustomToolCallOutputItem.id()).contains("id")
        assertThat(betaResponseCustomToolCallOutputItem.agent())
            .contains(
                BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseCustomToolCallOutputItem.caller())
            .contains(BetaResponseCustomToolCallOutput.Caller.ofDirect())
        assertThat(betaResponseCustomToolCallOutputItem.status())
            .isEqualTo(BetaResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
        assertThat(betaResponseCustomToolCallOutputItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCustomToolCallOutputItem =
            BetaResponseCustomToolCallOutputItem.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .agent(
                    BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .status(BetaResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseCustomToolCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCustomToolCallOutputItem),
                jacksonTypeRef<BetaResponseCustomToolCallOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseCustomToolCallOutputItem)
            .isEqualTo(betaResponseCustomToolCallOutputItem)
    }
}
