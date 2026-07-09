// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseImageGenCallGeneratingEventTest {

    @Test
    fun create() {
        val betaResponseImageGenCallGeneratingEvent =
            BetaResponseImageGenCallGeneratingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallGeneratingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseImageGenCallGeneratingEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseImageGenCallGeneratingEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallGeneratingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallGeneratingEvent.agent())
            .contains(
                BetaResponseImageGenCallGeneratingEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseImageGenCallGeneratingEvent =
            BetaResponseImageGenCallGeneratingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallGeneratingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseImageGenCallGeneratingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseImageGenCallGeneratingEvent),
                jacksonTypeRef<BetaResponseImageGenCallGeneratingEvent>(),
            )

        assertThat(roundtrippedBetaResponseImageGenCallGeneratingEvent)
            .isEqualTo(betaResponseImageGenCallGeneratingEvent)
    }
}
