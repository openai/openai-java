// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseWebSearchCallCompletedEventTest {

    @Test
    fun create() {
        val betaResponseWebSearchCallCompletedEvent =
            BetaResponseWebSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseWebSearchCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseWebSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseWebSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseWebSearchCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseWebSearchCallCompletedEvent.agent())
            .contains(
                BetaResponseWebSearchCallCompletedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseWebSearchCallCompletedEvent =
            BetaResponseWebSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseWebSearchCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseWebSearchCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseWebSearchCallCompletedEvent),
                jacksonTypeRef<BetaResponseWebSearchCallCompletedEvent>(),
            )

        assertThat(roundtrippedBetaResponseWebSearchCallCompletedEvent)
            .isEqualTo(betaResponseWebSearchCallCompletedEvent)
    }
}
