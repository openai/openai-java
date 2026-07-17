// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCustomToolCallInputDoneEventTest {

    @Test
    fun create() {
        val betaResponseCustomToolCallInputDoneEvent =
            BetaResponseCustomToolCallInputDoneEvent.builder()
                .input("input")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCustomToolCallInputDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCustomToolCallInputDoneEvent.input()).isEqualTo("input")
        assertThat(betaResponseCustomToolCallInputDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCustomToolCallInputDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCustomToolCallInputDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCustomToolCallInputDoneEvent.agent())
            .contains(
                BetaResponseCustomToolCallInputDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCustomToolCallInputDoneEvent =
            BetaResponseCustomToolCallInputDoneEvent.builder()
                .input("input")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCustomToolCallInputDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCustomToolCallInputDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCustomToolCallInputDoneEvent),
                jacksonTypeRef<BetaResponseCustomToolCallInputDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseCustomToolCallInputDoneEvent)
            .isEqualTo(betaResponseCustomToolCallInputDoneEvent)
    }
}
