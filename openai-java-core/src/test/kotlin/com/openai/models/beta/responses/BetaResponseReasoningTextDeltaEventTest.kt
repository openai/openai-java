// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningTextDeltaEventTest {

    @Test
    fun create() {
        val betaResponseReasoningTextDeltaEvent =
            BetaResponseReasoningTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseReasoningTextDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseReasoningTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseReasoningTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseReasoningTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseReasoningTextDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseReasoningTextDeltaEvent.agent())
            .contains(
                BetaResponseReasoningTextDeltaEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseReasoningTextDeltaEvent =
            BetaResponseReasoningTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseReasoningTextDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseReasoningTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningTextDeltaEvent),
                jacksonTypeRef<BetaResponseReasoningTextDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseReasoningTextDeltaEvent)
            .isEqualTo(betaResponseReasoningTextDeltaEvent)
    }
}
