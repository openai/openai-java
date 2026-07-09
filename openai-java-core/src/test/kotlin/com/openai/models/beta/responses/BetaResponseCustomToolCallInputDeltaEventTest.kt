// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCustomToolCallInputDeltaEventTest {

    @Test
    fun create() {
        val betaResponseCustomToolCallInputDeltaEvent =
            BetaResponseCustomToolCallInputDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCustomToolCallInputDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCustomToolCallInputDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseCustomToolCallInputDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCustomToolCallInputDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCustomToolCallInputDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCustomToolCallInputDeltaEvent.agent())
            .contains(
                BetaResponseCustomToolCallInputDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCustomToolCallInputDeltaEvent =
            BetaResponseCustomToolCallInputDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCustomToolCallInputDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCustomToolCallInputDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCustomToolCallInputDeltaEvent),
                jacksonTypeRef<BetaResponseCustomToolCallInputDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseCustomToolCallInputDeltaEvent)
            .isEqualTo(betaResponseCustomToolCallInputDeltaEvent)
    }
}
