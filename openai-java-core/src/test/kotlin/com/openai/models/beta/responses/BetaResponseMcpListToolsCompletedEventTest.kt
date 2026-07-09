// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpListToolsCompletedEventTest {

    @Test
    fun create() {
        val betaResponseMcpListToolsCompletedEvent =
            BetaResponseMcpListToolsCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpListToolsCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpListToolsCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpListToolsCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpListToolsCompletedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpListToolsCompletedEvent.agent())
            .contains(
                BetaResponseMcpListToolsCompletedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpListToolsCompletedEvent =
            BetaResponseMcpListToolsCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpListToolsCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpListToolsCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpListToolsCompletedEvent),
                jacksonTypeRef<BetaResponseMcpListToolsCompletedEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpListToolsCompletedEvent)
            .isEqualTo(betaResponseMcpListToolsCompletedEvent)
    }
}
