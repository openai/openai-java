// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(betaResponseTextDoneEvent.contentIndex()).contains(0L)
        assertThat(betaResponseTextDoneEvent.itemId()).contains("item_id")
        assertThat(betaResponseTextDoneEvent.logprobs().getOrNull())
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
        assertThat(betaResponseTextDoneEvent.outputIndex()).contains(0L)
        assertThat(betaResponseTextDoneEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseTextDoneEvent.text()).contains("text")
        assertThat(betaResponseTextDoneEvent.agent())
            .contains(BetaResponseTextDoneEvent.Agent.builder().agentName("agent_name").build())

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseTextDoneEvent),
                jacksonTypeRef<BetaResponseTextDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseTextDoneEvent).isEqualTo(betaResponseTextDoneEvent)
    }
}
