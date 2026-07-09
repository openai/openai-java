// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionCallArgumentsDeltaEventTest {

    @Test
    fun create() {
        val betaResponseFunctionCallArgumentsDeltaEvent =
            BetaResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFunctionCallArgumentsDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.agent())
            .contains(
                BetaResponseFunctionCallArgumentsDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionCallArgumentsDeltaEvent =
            BetaResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFunctionCallArgumentsDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseFunctionCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionCallArgumentsDeltaEvent),
                jacksonTypeRef<BetaResponseFunctionCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseFunctionCallArgumentsDeltaEvent)
            .isEqualTo(betaResponseFunctionCallArgumentsDeltaEvent)
    }
}
