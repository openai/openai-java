// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterCallCodeDeltaEventTest {

    @Test
    fun create() {
        val betaResponseCodeInterpreterCallCodeDeltaEvent =
            BetaResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallCodeDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.delta()).isEqualTo("delta")
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.agent())
            .contains(
                BetaResponseCodeInterpreterCallCodeDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCodeInterpreterCallCodeDeltaEvent =
            BetaResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallCodeDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCodeInterpreterCallCodeDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterCallCodeDeltaEvent),
                jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterCallCodeDeltaEvent)
            .isEqualTo(betaResponseCodeInterpreterCallCodeDeltaEvent)
    }
}
