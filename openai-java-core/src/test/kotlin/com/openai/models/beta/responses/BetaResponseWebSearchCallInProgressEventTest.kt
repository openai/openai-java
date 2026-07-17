// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseWebSearchCallInProgressEventTest {

    @Test
    fun create() {
        val betaResponseWebSearchCallInProgressEvent =
            BetaResponseWebSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseWebSearchCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseWebSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseWebSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseWebSearchCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseWebSearchCallInProgressEvent.agent())
            .contains(
                BetaResponseWebSearchCallInProgressEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseWebSearchCallInProgressEvent =
            BetaResponseWebSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseWebSearchCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseWebSearchCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseWebSearchCallInProgressEvent),
                jacksonTypeRef<BetaResponseWebSearchCallInProgressEvent>(),
            )

        assertThat(roundtrippedBetaResponseWebSearchCallInProgressEvent)
            .isEqualTo(betaResponseWebSearchCallInProgressEvent)
    }
}
