// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpCallInProgressEventTest {

    @Test
    fun create() {
        val betaResponseMcpCallInProgressEvent =
            BetaResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpCallInProgressEvent.agent())
            .contains(
                BetaResponseMcpCallInProgressEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpCallInProgressEvent =
            BetaResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpCallInProgressEvent),
                jacksonTypeRef<BetaResponseMcpCallInProgressEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpCallInProgressEvent)
            .isEqualTo(betaResponseMcpCallInProgressEvent)
    }
}
