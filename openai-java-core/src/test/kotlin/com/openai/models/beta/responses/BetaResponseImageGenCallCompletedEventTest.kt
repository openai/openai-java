// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseImageGenCallCompletedEventTest {

    @Test
    fun create() {
        val betaResponseImageGenCallCompletedEvent =
            BetaResponseImageGenCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseImageGenCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseImageGenCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallCompletedEvent.agent())
            .contains(
                BetaResponseImageGenCallCompletedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseImageGenCallCompletedEvent =
            BetaResponseImageGenCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseImageGenCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseImageGenCallCompletedEvent),
                jacksonTypeRef<BetaResponseImageGenCallCompletedEvent>(),
            )

        assertThat(roundtrippedBetaResponseImageGenCallCompletedEvent)
            .isEqualTo(betaResponseImageGenCallCompletedEvent)
    }
}
