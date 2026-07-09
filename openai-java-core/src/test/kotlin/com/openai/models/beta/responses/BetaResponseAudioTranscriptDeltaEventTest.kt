// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseAudioTranscriptDeltaEventTest {

    @Test
    fun create() {
        val betaResponseAudioTranscriptDeltaEvent =
            BetaResponseAudioTranscriptDeltaEvent.builder()
                .delta("delta")
                .sequenceNumber(0L)
                .agent(
                    BetaResponseAudioTranscriptDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseAudioTranscriptDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseAudioTranscriptDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseAudioTranscriptDeltaEvent.agent())
            .contains(
                BetaResponseAudioTranscriptDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseAudioTranscriptDeltaEvent =
            BetaResponseAudioTranscriptDeltaEvent.builder()
                .delta("delta")
                .sequenceNumber(0L)
                .agent(
                    BetaResponseAudioTranscriptDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseAudioTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseAudioTranscriptDeltaEvent),
                jacksonTypeRef<BetaResponseAudioTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseAudioTranscriptDeltaEvent)
            .isEqualTo(betaResponseAudioTranscriptDeltaEvent)
    }
}
