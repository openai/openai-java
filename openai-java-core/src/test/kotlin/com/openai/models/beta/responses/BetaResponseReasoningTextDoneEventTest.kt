// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningTextDoneEventTest {

    @Test
    fun create() {
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

        assertThat(betaResponseReasoningTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseReasoningTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningTextDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseReasoningTextDoneEvent.text()).isEqualTo("text")
        assertThat(betaResponseReasoningTextDoneEvent.agent())
            .contains(
                BetaResponseReasoningTextDoneEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedBetaResponseReasoningTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningTextDoneEvent),
                jacksonTypeRef<BetaResponseReasoningTextDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningTextDoneEvent)
            .isEqualTo(betaResponseReasoningTextDoneEvent)
    }
}
