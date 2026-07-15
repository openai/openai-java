// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFileSearchCallSearchingEventTest {

    @Test
    fun create() {
        val betaResponseFileSearchCallSearchingEvent =
            BetaResponseFileSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFileSearchCallSearchingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseFileSearchCallSearchingEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseFileSearchCallSearchingEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseFileSearchCallSearchingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseFileSearchCallSearchingEvent.agent())
            .contains(
                BetaResponseFileSearchCallSearchingEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFileSearchCallSearchingEvent =
            BetaResponseFileSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFileSearchCallSearchingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseFileSearchCallSearchingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFileSearchCallSearchingEvent),
                jacksonTypeRef<BetaResponseFileSearchCallSearchingEvent>(),
            )

        assertThat(roundtrippedBetaResponseFileSearchCallSearchingEvent)
            .isEqualTo(betaResponseFileSearchCallSearchingEvent)
    }
}
