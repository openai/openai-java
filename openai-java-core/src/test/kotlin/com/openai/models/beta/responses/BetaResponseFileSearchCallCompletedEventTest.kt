// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFileSearchCallCompletedEventTest {

    @Test
    fun create() {
        val betaResponseFileSearchCallCompletedEvent =
            BetaResponseFileSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFileSearchCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseFileSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseFileSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseFileSearchCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseFileSearchCallCompletedEvent.agent())
            .contains(
                BetaResponseFileSearchCallCompletedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFileSearchCallCompletedEvent =
            BetaResponseFileSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFileSearchCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseFileSearchCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFileSearchCallCompletedEvent),
                jacksonTypeRef<BetaResponseFileSearchCallCompletedEvent>(),
            )

        assertThat(roundtrippedBetaResponseFileSearchCallCompletedEvent)
            .isEqualTo(betaResponseFileSearchCallCompletedEvent)
    }
}
