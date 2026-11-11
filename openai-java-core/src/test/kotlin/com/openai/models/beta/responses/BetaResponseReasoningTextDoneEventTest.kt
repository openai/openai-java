// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseReasoningTextDoneEvent =
            BetaResponseReasoningTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .agent(
                    BetaResponseReasoningTextDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseReasoningTextDoneEvent.contentIndex()).contains(0L)
        assertThat(betaResponseReasoningTextDoneEvent.itemId()).contains("item_id")
        assertThat(betaResponseReasoningTextDoneEvent.outputIndex()).contains(0L)
        assertThat(betaResponseReasoningTextDoneEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseReasoningTextDoneEvent.text()).contains("text")
        assertThat(betaResponseReasoningTextDoneEvent.agent())
            .contains(
                BetaResponseReasoningTextDoneEvent.Agent.builder().agentName("agent_name").build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseReasoningTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningTextDoneEvent),
                jacksonTypeRef<BetaResponseReasoningTextDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningTextDoneEvent)
            .isEqualTo(betaResponseReasoningTextDoneEvent)
    }
}
