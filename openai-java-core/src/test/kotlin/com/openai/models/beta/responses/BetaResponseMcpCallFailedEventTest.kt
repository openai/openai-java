// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpCallFailedEventTest {

    @Test
    fun create() {
        val betaResponseMcpCallFailedEvent =
            BetaResponseMcpCallFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallFailedEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseMcpCallFailedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpCallFailedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpCallFailedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpCallFailedEvent.agent())
            .contains(
                BetaResponseMcpCallFailedEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpCallFailedEvent =
            BetaResponseMcpCallFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallFailedEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseMcpCallFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpCallFailedEvent),
                jacksonTypeRef<BetaResponseMcpCallFailedEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpCallFailedEvent)
            .isEqualTo(betaResponseMcpCallFailedEvent)
    }
}
