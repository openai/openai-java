// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningSummaryPartDoneEventTest {

    @Test
    fun create() {
        val betaResponseReasoningSummaryPartDoneEvent =
            BetaResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(BetaResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .agent(
                    BetaResponseReasoningSummaryPartDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .status(BetaResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .build()

        assertThat(betaResponseReasoningSummaryPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseReasoningSummaryPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryPartDoneEvent.part())
            .isEqualTo(
                BetaResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build()
            )
        assertThat(betaResponseReasoningSummaryPartDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryPartDoneEvent.summaryIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryPartDoneEvent.agent())
            .contains(
                BetaResponseReasoningSummaryPartDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseReasoningSummaryPartDoneEvent.status())
            .contains(BetaResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseReasoningSummaryPartDoneEvent =
            BetaResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(BetaResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .agent(
                    BetaResponseReasoningSummaryPartDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .status(BetaResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .build()

        val roundtrippedBetaResponseReasoningSummaryPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningSummaryPartDoneEvent),
                jacksonTypeRef<BetaResponseReasoningSummaryPartDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningSummaryPartDoneEvent)
            .isEqualTo(betaResponseReasoningSummaryPartDoneEvent)
    }
}
