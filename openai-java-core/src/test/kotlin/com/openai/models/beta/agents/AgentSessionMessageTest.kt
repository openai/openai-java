// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionMessageTest {

    @Test
    fun create() {
        val agentSessionMessage =
            AgentSessionMessage.builder()
                .id("id")
                .addInputTextContent("text")
                .phase(AgentSessionMessage.Phase.COMMENTARY)
                .role(AgentSessionMessage.Role.USER)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentSessionMessage.id()).contains("id")
        assertThat(agentSessionMessage.content())
            .containsExactly(
                AgentSessionMessageContent.ofInputText(
                    AgentSessionMessageContent.InputText.builder().text("text").build()
                )
            )
        assertThat(agentSessionMessage.phase()).contains(AgentSessionMessage.Phase.COMMENTARY)
        assertThat(agentSessionMessage.role()).isEqualTo(AgentSessionMessage.Role.USER)
        assertThat(agentSessionMessage.status()).isEqualTo(AgentOutputItemStatus.IN_PROGRESS)
        assertThat(agentSessionMessage.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionMessage =
            AgentSessionMessage.builder()
                .id("id")
                .addInputTextContent("text")
                .phase(AgentSessionMessage.Phase.COMMENTARY)
                .role(AgentSessionMessage.Role.USER)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSessionMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionMessage),
                jacksonTypeRef<AgentSessionMessage>(),
            )

        assertThat(roundtrippedAgentSessionMessage).isEqualTo(agentSessionMessage)
    }
}
