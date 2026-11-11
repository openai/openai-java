// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionAssistantMessageTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionAssistantMessage =
            AgentSessionAssistantMessage.builder()
                .id("id")
                .addContent(OutputText.builder().text("text").build())
                .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentSessionAssistantMessage.id()).contains("id")
        assertThat(agentSessionAssistantMessage.content().getOrNull())
            .containsExactly(OutputText.builder().text("text").build())
        assertThat(agentSessionAssistantMessage.phase())
            .contains(AgentSessionAssistantMessage.Phase.COMMENTARY)
        assertThat(agentSessionAssistantMessage.status())
            .contains(AgentOutputItemStatus.IN_PROGRESS)
        assertThat(agentSessionAssistantMessage.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionAssistantMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionAssistantMessage),
                jacksonTypeRef<AgentSessionAssistantMessage>(),
            )

        assertThat(roundtrippedAgentSessionAssistantMessage).isEqualTo(agentSessionAssistantMessage)
    }
}
