// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseShellCallCommandAddedEventTest {

    @Test
    fun create() {
        val betaResponseShellCallCommandAddedEvent =
            BetaResponseShellCallCommandAddedEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallCommandAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseShellCallCommandAddedEvent.command()).isEqualTo("command")
        assertThat(betaResponseShellCallCommandAddedEvent.commandIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallCommandAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseShellCallCommandAddedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseShellCallCommandAddedEvent.agent())
            .contains(
                BetaResponseShellCallCommandAddedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseShellCallCommandAddedEvent =
            BetaResponseShellCallCommandAddedEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallCommandAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseShellCallCommandAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseShellCallCommandAddedEvent),
                jacksonTypeRef<BetaResponseShellCallCommandAddedEvent>(),
            )

        assertThat(roundtrippedBetaResponseShellCallCommandAddedEvent)
            .isEqualTo(betaResponseShellCallCommandAddedEvent)
    }
}
