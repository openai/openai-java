// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterCallInProgressEventTest {

    @Test
    fun create() {
        val betaResponseCodeInterpreterCallInProgressEvent =
            BetaResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCodeInterpreterCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCodeInterpreterCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallInProgressEvent.agent())
            .contains(
                BetaResponseCodeInterpreterCallInProgressEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCodeInterpreterCallInProgressEvent =
            BetaResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallInProgressEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCodeInterpreterCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterCallInProgressEvent),
                jacksonTypeRef<BetaResponseCodeInterpreterCallInProgressEvent>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterCallInProgressEvent)
            .isEqualTo(betaResponseCodeInterpreterCallInProgressEvent)
    }
}
