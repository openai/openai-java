// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterCallInterpretingEventTest {

    @Test
    fun create() {
        val betaResponseCodeInterpreterCallInterpretingEvent =
            BetaResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallInterpretingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCodeInterpreterCallInterpretingEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCodeInterpreterCallInterpretingEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallInterpretingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallInterpretingEvent.agent())
            .contains(
                BetaResponseCodeInterpreterCallInterpretingEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCodeInterpreterCallInterpretingEvent =
            BetaResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallInterpretingEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCodeInterpreterCallInterpretingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterCallInterpretingEvent),
                jacksonTypeRef<BetaResponseCodeInterpreterCallInterpretingEvent>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterCallInterpretingEvent)
            .isEqualTo(betaResponseCodeInterpreterCallInterpretingEvent)
    }
}
