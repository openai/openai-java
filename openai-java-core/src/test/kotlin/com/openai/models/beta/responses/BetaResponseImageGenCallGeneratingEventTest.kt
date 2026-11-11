// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseImageGenCallGeneratingEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(betaResponseImageGenCallGeneratingEvent.itemId()).contains("item_id")
        assertThat(betaResponseImageGenCallGeneratingEvent.outputIndex()).contains(0L)
        assertThat(betaResponseImageGenCallGeneratingEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseImageGenCallGeneratingEvent.agent())
            .contains(
                BetaResponseImageGenCallGeneratingEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseImageGenCallGeneratingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseImageGenCallGeneratingEvent),
                jacksonTypeRef<BetaResponseImageGenCallGeneratingEvent>(),
            )

        assertThat(roundtrippedBetaResponseImageGenCallGeneratingEvent)
            .isEqualTo(betaResponseImageGenCallGeneratingEvent)
    }
}
