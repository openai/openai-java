// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterCallCompletedEventTest {

    @Test
    fun create() {
        val betaResponseCodeInterpreterCallCompletedEvent =
            BetaResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCodeInterpreterCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCodeInterpreterCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallCompletedEvent.agent())
            .contains(
                BetaResponseCodeInterpreterCallCompletedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCodeInterpreterCallCompletedEvent =
            BetaResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallCompletedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCodeInterpreterCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterCallCompletedEvent),
                jacksonTypeRef<BetaResponseCodeInterpreterCallCompletedEvent>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterCallCompletedEvent)
            .isEqualTo(betaResponseCodeInterpreterCallCompletedEvent)
    }
}
