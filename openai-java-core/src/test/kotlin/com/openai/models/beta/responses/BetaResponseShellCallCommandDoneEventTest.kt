// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseShellCallCommandDoneEventTest {

    @Test
    fun create() {
        val betaResponseShellCallCommandDoneEvent =
            BetaResponseShellCallCommandDoneEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallCommandDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseShellCallCommandDoneEvent.command()).isEqualTo("command")
        assertThat(betaResponseShellCallCommandDoneEvent.commandIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallCommandDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallCommandDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseShellCallCommandDoneEvent.agent())
            .contains(
                BetaResponseShellCallCommandDoneEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseShellCallCommandDoneEvent =
            BetaResponseShellCallCommandDoneEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallCommandDoneEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseShellCallCommandDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseShellCallCommandDoneEvent),
                jacksonTypeRef<BetaResponseShellCallCommandDoneEvent>(),
            )

        assertThat(roundtrippedBetaResponseShellCallCommandDoneEvent)
            .isEqualTo(betaResponseShellCallCommandDoneEvent)
    }
}
