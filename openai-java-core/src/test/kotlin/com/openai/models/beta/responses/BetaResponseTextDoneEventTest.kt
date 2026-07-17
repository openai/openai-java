// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseTextDoneEventTest {

    @Test
    fun create() {
        val betaResponseTextDoneEvent =
            BetaResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .addLogprob(
                    BetaResponseTextDoneEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            BetaResponseTextDoneEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .agent(BetaResponseTextDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseTextDoneEvent.logprobs())
            .containsExactly(
                BetaResponseTextDoneEvent.Logprob.builder()
                    .token("token")
                    .logprob(0.0)
                    .addTopLogprob(
                        BetaResponseTextDoneEvent.Logprob.TopLogprob.builder()
                            .token("token")
                            .logprob(0.0)
                            .build()
                    )
                    .build()
            )
        assertThat(betaResponseTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseTextDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseTextDoneEvent.text()).isEqualTo("text")
        assertThat(betaResponseTextDoneEvent.agent())
            .contains(BetaResponseTextDoneEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseTextDoneEvent =
            BetaResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .addLogprob(
                    BetaResponseTextDoneEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            BetaResponseTextDoneEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .agent(BetaResponseTextDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseTextDoneEvent),
                jacksonTypeRef<BetaResponseTextDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseTextDoneEvent).isEqualTo(betaResponseTextDoneEvent)
    }
}
