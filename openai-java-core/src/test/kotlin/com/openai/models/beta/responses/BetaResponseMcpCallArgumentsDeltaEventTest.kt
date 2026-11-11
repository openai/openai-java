// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpCallArgumentsDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(betaResponseMcpCallArgumentsDeltaEvent.delta()).contains("delta")
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.itemId()).contains("item_id")
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.outputIndex()).contains(0L)
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseMcpCallArgumentsDeltaEvent.agent())
            .contains(
                BetaResponseMcpCallArgumentsDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseMcpCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpCallArgumentsDeltaEvent),
                jacksonTypeRef<BetaResponseMcpCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpCallArgumentsDeltaEvent)
            .isEqualTo(betaResponseMcpCallArgumentsDeltaEvent)
    }
}
