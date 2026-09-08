// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseShellCallOutputContentDeltaEventTest {

    @Test
    fun create() {
        val betaResponseShellCallOutputContentDeltaEvent =
            BetaResponseShellCallOutputContentDeltaEvent.builder()
                .commandIndex(0L)
                .delta(
                    BetaResponseShellCallOutputContentDeltaEvent.Delta.builder()
                        .stderr("stderr")
                        .stdout("stdout")
                        .build()
                )
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallOutputContentDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseShellCallOutputContentDeltaEvent.commandIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallOutputContentDeltaEvent.delta())
            .isEqualTo(
                BetaResponseShellCallOutputContentDeltaEvent.Delta.builder()
                    .stderr("stderr")
                    .stdout("stdout")
                    .build()
            )
        assertThat(betaResponseShellCallOutputContentDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseShellCallOutputContentDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallOutputContentDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseShellCallOutputContentDeltaEvent.agent())
            .contains(
                BetaResponseShellCallOutputContentDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseShellCallOutputContentDeltaEvent =
            BetaResponseShellCallOutputContentDeltaEvent.builder()
                .commandIndex(0L)
                .delta(
                    BetaResponseShellCallOutputContentDeltaEvent.Delta.builder()
                        .stderr("stderr")
                        .stdout("stdout")
                        .build()
                )
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallOutputContentDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseShellCallOutputContentDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseShellCallOutputContentDeltaEvent),
                jacksonTypeRef<BetaResponseShellCallOutputContentDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseShellCallOutputContentDeltaEvent)
            .isEqualTo(betaResponseShellCallOutputContentDeltaEvent)
    }
}
