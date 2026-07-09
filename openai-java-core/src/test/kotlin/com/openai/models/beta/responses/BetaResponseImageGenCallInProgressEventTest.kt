// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseImageGenCallInProgressEventTest {

    @Test
    fun create() {
        val betaResponseImageGenCallInProgressEvent =
            BetaResponseImageGenCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseImageGenCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseImageGenCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseImageGenCallInProgressEvent.agent())
            .contains(
                BetaResponseImageGenCallInProgressEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseImageGenCallInProgressEvent =
            BetaResponseImageGenCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseImageGenCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseImageGenCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseImageGenCallInProgressEvent),
                jacksonTypeRef<BetaResponseImageGenCallInProgressEvent>(),
            )

        assertThat(roundtrippedBetaResponseImageGenCallInProgressEvent)
            .isEqualTo(betaResponseImageGenCallInProgressEvent)
    }
}
