// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentTextTest {

    @Test
    fun createAndRoundtrip() {
        val agentText = AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build()

        assertThat(agentText.format()).isEqualTo(TextFormat.ofText())
        assertThat(agentText.verbosity()).isEqualTo(AgentText.Verbosity.LOW)

        val jsonMapper = jsonMapper()

        val roundtrippedAgentText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentText),
                jacksonTypeRef<AgentText>(),
            )

        assertThat(roundtrippedAgentText).isEqualTo(agentText)
    }
}
