// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpCallArgumentsDoneEventTest {

    @Test
    fun create() {
        val betaResponseMcpCallArgumentsDoneEvent =
            BetaResponseMcpCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallArgumentsDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(betaResponseMcpCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpCallArgumentsDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpCallArgumentsDoneEvent.agent())
            .contains(
                BetaResponseMcpCallArgumentsDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpCallArgumentsDoneEvent =
            BetaResponseMcpCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpCallArgumentsDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpCallArgumentsDoneEvent),
                jacksonTypeRef<BetaResponseMcpCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpCallArgumentsDoneEvent)
            .isEqualTo(betaResponseMcpCallArgumentsDoneEvent)
    }
}
