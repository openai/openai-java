// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseShellCallOutputContentDoneEventTest {

    @Test
    fun create() {
        val betaResponseShellCallOutputContentDoneEvent =
            BetaResponseShellCallOutputContentDoneEvent.builder()
                .commandIndex(0L)
                .itemId("item_id")
                .addOutput(
                    BetaResponseShellCallOutputContentDoneEvent.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallOutputContentDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseShellCallOutputContentDoneEvent.commandIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallOutputContentDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseShellCallOutputContentDoneEvent.output())
            .containsExactly(
                BetaResponseShellCallOutputContentDoneEvent.Output.builder()
                    .outcomeTimeout()
                    .stderr("stderr")
                    .stdout("stdout")
                    .createdBy("created_by")
                    .build()
            )
        assertThat(betaResponseShellCallOutputContentDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallOutputContentDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseShellCallOutputContentDoneEvent.agent())
            .contains(
                BetaResponseShellCallOutputContentDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseShellCallOutputContentDoneEvent =
            BetaResponseShellCallOutputContentDoneEvent.builder()
                .commandIndex(0L)
                .itemId("item_id")
                .addOutput(
                    BetaResponseShellCallOutputContentDoneEvent.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallOutputContentDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseShellCallOutputContentDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseShellCallOutputContentDoneEvent),
                jacksonTypeRef<BetaResponseShellCallOutputContentDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseShellCallOutputContentDoneEvent)
            .isEqualTo(betaResponseShellCallOutputContentDoneEvent)
    }
}
