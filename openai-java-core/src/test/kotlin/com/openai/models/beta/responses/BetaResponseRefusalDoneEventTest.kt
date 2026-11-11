// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseRefusalDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseRefusalDoneEvent =
            BetaResponseRefusalDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .agent(BetaResponseRefusalDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseRefusalDoneEvent.contentIndex()).contains(0L)
        assertThat(betaResponseRefusalDoneEvent.itemId()).contains("item_id")
        assertThat(betaResponseRefusalDoneEvent.outputIndex()).contains(0L)
        assertThat(betaResponseRefusalDoneEvent.refusal()).contains("refusal")
        assertThat(betaResponseRefusalDoneEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseRefusalDoneEvent.agent())
            .contains(BetaResponseRefusalDoneEvent.Agent.builder().agentName("agent_name").build())

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseRefusalDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseRefusalDoneEvent),
                jacksonTypeRef<BetaResponseRefusalDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseRefusalDoneEvent).isEqualTo(betaResponseRefusalDoneEvent)
    }
}
