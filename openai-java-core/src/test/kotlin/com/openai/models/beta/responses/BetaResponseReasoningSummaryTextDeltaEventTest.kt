// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningSummaryTextDeltaEventTest {

    @Test
    fun create() {
        val betaResponseReasoningSummaryTextDeltaEvent =
            BetaResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .agent(
                    BetaResponseReasoningSummaryTextDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseReasoningSummaryTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.summaryIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.agent())
            .contains(
                BetaResponseReasoningSummaryTextDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseReasoningSummaryTextDeltaEvent =
            BetaResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .agent(
                    BetaResponseReasoningSummaryTextDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseReasoningSummaryTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningSummaryTextDeltaEvent),
                jacksonTypeRef<BetaResponseReasoningSummaryTextDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningSummaryTextDeltaEvent)
            .isEqualTo(betaResponseReasoningSummaryTextDeltaEvent)
    }
}
