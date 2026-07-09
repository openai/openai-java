// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpListToolsFailedEventTest {

    @Test
    fun create() {
        val betaResponseMcpListToolsFailedEvent =
            BetaResponseMcpListToolsFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpListToolsFailedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpListToolsFailedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpListToolsFailedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpListToolsFailedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpListToolsFailedEvent.agent())
            .contains(
                BetaResponseMcpListToolsFailedEvent.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpListToolsFailedEvent =
            BetaResponseMcpListToolsFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpListToolsFailedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpListToolsFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpListToolsFailedEvent),
                jacksonTypeRef<BetaResponseMcpListToolsFailedEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpListToolsFailedEvent)
            .isEqualTo(betaResponseMcpListToolsFailedEvent)
    }
}
