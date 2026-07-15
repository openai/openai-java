// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseAudioTranscriptDoneEventTest {

    @Test
    fun create() {
        val betaResponseAudioTranscriptDoneEvent =
            BetaResponseAudioTranscriptDoneEvent.builder()
                .sequenceNumber(0L)
                .agent(
                    BetaResponseAudioTranscriptDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseAudioTranscriptDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseAudioTranscriptDoneEvent.agent())
            .contains(
                BetaResponseAudioTranscriptDoneEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseAudioTranscriptDoneEvent =
            BetaResponseAudioTranscriptDoneEvent.builder()
                .sequenceNumber(0L)
                .agent(
                    BetaResponseAudioTranscriptDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseAudioTranscriptDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseAudioTranscriptDoneEvent),
                jacksonTypeRef<BetaResponseAudioTranscriptDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseAudioTranscriptDoneEvent)
            .isEqualTo(betaResponseAudioTranscriptDoneEvent)
    }
}
