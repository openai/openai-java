// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseAudioDoneEventTest {

    @Test
    fun create() {
        val betaResponseAudioDoneEvent =
            BetaResponseAudioDoneEvent.builder()
                .sequenceNumber(0L)
                .agent(BetaResponseAudioDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseAudioDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseAudioDoneEvent.agent())
            .contains(BetaResponseAudioDoneEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseAudioDoneEvent =
            BetaResponseAudioDoneEvent.builder()
                .sequenceNumber(0L)
                .agent(BetaResponseAudioDoneEvent.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseAudioDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseAudioDoneEvent),
                jacksonTypeRef<BetaResponseAudioDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseAudioDoneEvent).isEqualTo(betaResponseAudioDoneEvent)
    }
}
