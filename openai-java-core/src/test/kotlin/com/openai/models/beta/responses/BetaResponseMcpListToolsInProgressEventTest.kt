// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseMcpListToolsInProgressEventTest {

    @Test
    fun create() {
        val betaResponseMcpListToolsInProgressEvent =
            BetaResponseMcpListToolsInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpListToolsInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseMcpListToolsInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseMcpListToolsInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseMcpListToolsInProgressEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseMcpListToolsInProgressEvent.agent())
            .contains(
                BetaResponseMcpListToolsInProgressEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseMcpListToolsInProgressEvent =
            BetaResponseMcpListToolsInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseMcpListToolsInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseMcpListToolsInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseMcpListToolsInProgressEvent),
                jacksonTypeRef<BetaResponseMcpListToolsInProgressEvent>(),
            )

        assertThat(roundtrippedBetaResponseMcpListToolsInProgressEvent)
            .isEqualTo(betaResponseMcpListToolsInProgressEvent)
    }
}
