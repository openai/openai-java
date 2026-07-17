// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpCallArgumentsDeltaEventTest {

    @Test
    fun create() {
        val betaResponseMcpCallArgumentsDeltaEvent =
            BetaResponseMcpCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallArgumentsDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpCallArgumentsDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.agent())
            .contains(
                BetaResponseMcpCallArgumentsDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpCallArgumentsDeltaEvent =
            BetaResponseMcpCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallArgumentsDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpCallArgumentsDeltaEvent),
                jacksonTypeRef<BetaResponseMcpCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpCallArgumentsDeltaEvent)
            .isEqualTo(betaResponseMcpCallArgumentsDeltaEvent)
    }
}
