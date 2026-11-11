// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseShellCallCommandDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseShellCallCommandDeltaEvent =
            BetaResponseShellCallCommandDeltaEvent.builder()
                .commandIndex(0L)
                .delta("delta")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseShellCallCommandDeltaEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .obfuscation("obfuscation")
                .build()

        assertThat(betaResponseShellCallCommandDeltaEvent.commandIndex()).contains(0L)
        assertThat(betaResponseShellCallCommandDeltaEvent.delta()).contains("delta")
        assertThat(betaResponseShellCallCommandDeltaEvent.outputIndex()).contains(0L)
        assertThat(betaResponseShellCallCommandDeltaEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseShellCallCommandDeltaEvent.agent())
            .contains(
                BetaResponseShellCallCommandDeltaEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseShellCallCommandDeltaEvent.obfuscation()).contains("obfuscation")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseShellCallCommandDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseShellCallCommandDeltaEvent),
                jacksonTypeRef<BetaResponseShellCallCommandDeltaEvent>(),
            )

        assertThat(roundtrippedBetaResponseShellCallCommandDeltaEvent)
            .isEqualTo(betaResponseShellCallCommandDeltaEvent)
    }
}
