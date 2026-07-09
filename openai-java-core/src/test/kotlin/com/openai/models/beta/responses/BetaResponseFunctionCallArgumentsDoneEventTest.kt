// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionCallArgumentsDoneEventTest {

    @Test
    fun create() {
        val betaResponseFunctionCallArgumentsDoneEvent =
            BetaResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFunctionCallArgumentsDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseFunctionCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(betaResponseFunctionCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseFunctionCallArgumentsDoneEvent.name()).isEqualTo("name")
        assertThat(betaResponseFunctionCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseFunctionCallArgumentsDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseFunctionCallArgumentsDoneEvent.agent())
            .contains(
                BetaResponseFunctionCallArgumentsDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionCallArgumentsDoneEvent =
            BetaResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseFunctionCallArgumentsDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseFunctionCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionCallArgumentsDoneEvent),
                jacksonTypeRef<BetaResponseFunctionCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseFunctionCallArgumentsDoneEvent)
            .isEqualTo(betaResponseFunctionCallArgumentsDoneEvent)
    }
}
