// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterCallCodeDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.delta()).contains("delta")
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.itemId()).contains("item_id")
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.outputIndex()).contains(0L)
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseCodeInterpreterCallCodeDeltaEvent.agent())
            .contains(
                BetaResponseCodeInterpreterCallCodeDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseCodeInterpreterCallCodeDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterCallCodeDeltaEvent),
                jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterCallCodeDeltaEvent)
            .isEqualTo(betaResponseCodeInterpreterCallCodeDeltaEvent)
    }
}
