// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseTextDeltaEventTest {

    @Test
    fun create() {
        val betaResponseTextDeltaEvent =
            BetaResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .addLogprob(
                    BetaResponseTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            BetaResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(BetaResponseTextDeltaEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseTextDeltaEvent.logprobs())
            .containsExactly(
                BetaResponseTextDeltaEvent.Logprob.builder()
                    .token("token")
                    .logprob(0.0)
                    .addTopLogprob(
                        BetaResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                            .token("token")
                            .logprob(0.0)
                            .build()
                    )
                    .build()
            )
        assertThat(betaResponseTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseTextDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseTextDeltaEvent.agent())
            .contains(BetaResponseTextDeltaEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseTextDeltaEvent =
            BetaResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .addLogprob(
                    BetaResponseTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            BetaResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(BetaResponseTextDeltaEvent.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseTextDeltaEvent),
                jacksonTypeRef<BetaResponseTextDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseTextDeltaEvent).isEqualTo(betaResponseTextDeltaEvent)
    }
}
