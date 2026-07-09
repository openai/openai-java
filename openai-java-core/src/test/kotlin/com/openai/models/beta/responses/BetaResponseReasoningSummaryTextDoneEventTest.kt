// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningSummaryTextDoneEventTest {

    @Test
    fun create() {
        val betaResponseReasoningSummaryTextDoneEvent =
            BetaResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .agent(
                    BetaResponseReasoningSummaryTextDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseReasoningSummaryTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseReasoningSummaryTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryTextDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryTextDoneEvent.summaryIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryTextDoneEvent.text()).isEqualTo("text")
        assertThat(betaResponseReasoningSummaryTextDoneEvent.agent())
            .contains(
                BetaResponseReasoningSummaryTextDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseReasoningSummaryTextDoneEvent =
            BetaResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .agent(
                    BetaResponseReasoningSummaryTextDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseReasoningSummaryTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningSummaryTextDoneEvent),
                jacksonTypeRef<BetaResponseReasoningSummaryTextDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningSummaryTextDoneEvent)
            .isEqualTo(betaResponseReasoningSummaryTextDoneEvent)
    }
}
