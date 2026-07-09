// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningSummaryPartAddedEventTest {

    @Test
    fun create() {
        val betaResponseReasoningSummaryPartAddedEvent =
            BetaResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    BetaResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build()
                )
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .agent(
                    BetaResponseReasoningSummaryPartAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseReasoningSummaryPartAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseReasoningSummaryPartAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryPartAddedEvent.part())
            .isEqualTo(
                BetaResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build()
            )
        assertThat(betaResponseReasoningSummaryPartAddedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryPartAddedEvent.summaryIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryPartAddedEvent.agent())
            .contains(
                BetaResponseReasoningSummaryPartAddedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseReasoningSummaryPartAddedEvent =
            BetaResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    BetaResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build()
                )
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .agent(
                    BetaResponseReasoningSummaryPartAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseReasoningSummaryPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningSummaryPartAddedEvent),
                jacksonTypeRef<BetaResponseReasoningSummaryPartAddedEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningSummaryPartAddedEvent)
            .isEqualTo(betaResponseReasoningSummaryPartAddedEvent)
    }
}
