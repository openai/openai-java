// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseRefusalDeltaEventTest {

    @Test
    fun create() {
        val betaResponseRefusalDeltaEvent =
            BetaResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseRefusalDeltaEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseRefusalDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseRefusalDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseRefusalDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseRefusalDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseRefusalDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseRefusalDeltaEvent.agent())
            .contains(BetaResponseRefusalDeltaEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseRefusalDeltaEvent =
            BetaResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseRefusalDeltaEvent.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseRefusalDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseRefusalDeltaEvent),
                jacksonTypeRef<BetaResponseRefusalDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseRefusalDeltaEvent)
            .isEqualTo(betaResponseRefusalDeltaEvent)
    }
}
