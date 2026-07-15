// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFileSearchCallInProgressEventTest {

    @Test
    fun create() {
        val betaResponseFileSearchCallInProgressEvent =
            BetaResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFileSearchCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseFileSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseFileSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseFileSearchCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseFileSearchCallInProgressEvent.agent())
            .contains(
                BetaResponseFileSearchCallInProgressEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFileSearchCallInProgressEvent =
            BetaResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFileSearchCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseFileSearchCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFileSearchCallInProgressEvent),
                jacksonTypeRef<BetaResponseFileSearchCallInProgressEvent>(),
            )

        assertThat(roundtrippedBetaResponseFileSearchCallInProgressEvent)
            .isEqualTo(betaResponseFileSearchCallInProgressEvent)
    }
}
