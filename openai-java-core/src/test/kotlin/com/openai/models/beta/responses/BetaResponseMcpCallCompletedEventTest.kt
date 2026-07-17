// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpCallCompletedEventTest {

    @Test
    fun create() {
        val betaResponseMcpCallCompletedEvent =
            BetaResponseMcpCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpCallCompletedEvent.agent())
            .contains(
                BetaResponseMcpCallCompletedEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpCallCompletedEvent =
            BetaResponseMcpCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpCallCompletedEvent),
                jacksonTypeRef<BetaResponseMcpCallCompletedEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpCallCompletedEvent)
            .isEqualTo(betaResponseMcpCallCompletedEvent)
    }
}
