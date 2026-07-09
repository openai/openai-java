// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseRefusalDoneEventTest {

    @Test
    fun create() {
        val betaResponseRefusalDoneEvent =
            BetaResponseRefusalDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .agent(BetaResponseRefusalDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseRefusalDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseRefusalDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseRefusalDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseRefusalDoneEvent.refusal()).isEqualTo("refusal")
        assertThat(betaResponseRefusalDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseRefusalDoneEvent.agent())
            .contains(BetaResponseRefusalDoneEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseRefusalDoneEvent =
            BetaResponseRefusalDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .agent(BetaResponseRefusalDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseRefusalDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseRefusalDoneEvent),
                jacksonTypeRef<BetaResponseRefusalDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseRefusalDoneEvent).isEqualTo(betaResponseRefusalDoneEvent)
    }
}
