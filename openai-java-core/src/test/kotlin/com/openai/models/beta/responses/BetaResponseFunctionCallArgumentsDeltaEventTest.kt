// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionCallArgumentsDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.delta()).contains("delta")
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.itemId()).contains("item_id")
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.outputIndex()).contains(0L)
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseFunctionCallArgumentsDeltaEvent.agent())
            .contains(
                BetaResponseFunctionCallArgumentsDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseFunctionCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionCallArgumentsDeltaEvent),
                jacksonTypeRef<BetaResponseFunctionCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseFunctionCallArgumentsDeltaEvent)
            .isEqualTo(betaResponseFunctionCallArgumentsDeltaEvent)
    }
}
