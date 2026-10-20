// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCompactionCompactingEventTest {

    @Test
    fun create() {
        val betaResponseCompactionCompactingEvent =
            BetaResponseCompactionCompactingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCompactionCompactingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCompactionCompactingEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCompactionCompactingEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCompactionCompactingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCompactionCompactingEvent.agent())
            .contains(
                BetaResponseCompactionCompactingEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCompactionCompactingEvent =
            BetaResponseCompactionCompactingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCompactionCompactingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCompactionCompactingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCompactionCompactingEvent),
                jacksonTypeRef<BetaResponseCompactionCompactingEvent>(),
            )

        assertThat(roundtrippedBetaResponseCompactionCompactingEvent)
            .isEqualTo(betaResponseCompactionCompactingEvent)
    }
}
