// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningSummaryTextDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(betaResponseReasoningSummaryTextDeltaEvent.delta()).contains("delta")
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.itemId()).contains("item_id")
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.outputIndex()).contains(0L)
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.summaryIndex()).contains(0L)
        assertThat(betaResponseReasoningSummaryTextDeltaEvent.agent())
            .contains(
                BetaResponseReasoningSummaryTextDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseReasoningSummaryTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningSummaryTextDeltaEvent),
                jacksonTypeRef<BetaResponseReasoningSummaryTextDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningSummaryTextDeltaEvent)
            .isEqualTo(betaResponseReasoningSummaryTextDeltaEvent)
    }
}
