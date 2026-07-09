// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterCallCodeDoneEventTest {

    @Test
    fun create() {
        val betaResponseCodeInterpreterCallCodeDoneEvent =
            BetaResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallCodeDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCodeInterpreterCallCodeDoneEvent.code()).isEqualTo("code")
        assertThat(betaResponseCodeInterpreterCallCodeDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseCodeInterpreterCallCodeDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallCodeDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseCodeInterpreterCallCodeDoneEvent.agent())
            .contains(
                BetaResponseCodeInterpreterCallCodeDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCodeInterpreterCallCodeDoneEvent =
            BetaResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseCodeInterpreterCallCodeDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCodeInterpreterCallCodeDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterCallCodeDoneEvent),
                jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterCallCodeDoneEvent)
            .isEqualTo(betaResponseCodeInterpreterCallCodeDoneEvent)
    }
}
