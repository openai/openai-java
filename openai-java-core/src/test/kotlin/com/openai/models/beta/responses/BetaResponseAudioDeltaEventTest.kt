// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseAudioDeltaEventTest {

    @Test
    fun create() {
        val betaResponseAudioDeltaEvent =
            BetaResponseAudioDeltaEvent.builder()
                .delta("delta")
                .sequenceNumber(0L)
                .agent(BetaResponseAudioDeltaEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseAudioDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseAudioDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseAudioDeltaEvent.agent())
            .contains(BetaResponseAudioDeltaEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseAudioDeltaEvent =
            BetaResponseAudioDeltaEvent.builder()
                .delta("delta")
                .sequenceNumber(0L)
                .agent(BetaResponseAudioDeltaEvent.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseAudioDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseAudioDeltaEvent),
                jacksonTypeRef<BetaResponseAudioDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseAudioDeltaEvent).isEqualTo(betaResponseAudioDeltaEvent)
    }
}
