// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseWebSearchCallSearchingEventTest {

    @Test
    fun create() {
        val betaResponseWebSearchCallSearchingEvent =
            BetaResponseWebSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseWebSearchCallSearchingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseWebSearchCallSearchingEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseWebSearchCallSearchingEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseWebSearchCallSearchingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseWebSearchCallSearchingEvent.agent())
            .contains(
                BetaResponseWebSearchCallSearchingEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseWebSearchCallSearchingEvent =
            BetaResponseWebSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseWebSearchCallSearchingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseWebSearchCallSearchingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseWebSearchCallSearchingEvent),
                jacksonTypeRef<BetaResponseWebSearchCallSearchingEvent>(),
            )

        assertThat(roundtrippedBetaResponseWebSearchCallSearchingEvent)
            .isEqualTo(betaResponseWebSearchCallSearchingEvent)
    }
}
