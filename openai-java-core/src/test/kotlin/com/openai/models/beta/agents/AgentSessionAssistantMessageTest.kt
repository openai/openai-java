// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionAssistantMessageTest {

    @Test
    fun create() {
        val agentSessionAssistantMessage =
            AgentSessionAssistantMessage.builder()
                .id("id")
                .addContent(OutputText.builder().text("text").build())
                .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentSessionAssistantMessage.id()).isEqualTo("id")
        assertThat(agentSessionAssistantMessage.content())
            .containsExactly(OutputText.builder().text("text").build())
        assertThat(agentSessionAssistantMessage.phase())
            .contains(AgentSessionAssistantMessage.Phase.COMMENTARY)
        assertThat(agentSessionAssistantMessage.status())
            .isEqualTo(AgentOutputItemStatus.IN_PROGRESS)
        assertThat(agentSessionAssistantMessage.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionAssistantMessage =
            AgentSessionAssistantMessage.builder()
                .id("id")
                .addContent(OutputText.builder().text("text").build())
                .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionAssistantMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionAssistantMessage),
                jacksonTypeRef<AgentSessionAssistantMessage>(),
            )

        assertThat(roundtrippedAgentSessionAssistantMessage).isEqualTo(agentSessionAssistantMessage)
    }
}
