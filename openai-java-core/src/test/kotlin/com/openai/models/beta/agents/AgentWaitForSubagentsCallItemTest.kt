// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentWaitForSubagentsCallItemTest {

    @Test
    fun create() {
        val agentWaitForSubagentsCallItem =
            AgentWaitForSubagentsCallItem.builder()
                .id("id")
                .addRecipientAgentId("string")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentWaitForSubagentsCallItem.id()).isEqualTo("id")
        assertThat(agentWaitForSubagentsCallItem.recipientAgentIds()).containsExactly("string")
        assertThat(agentWaitForSubagentsCallItem.senderAgentId()).isEqualTo("sender_agent_id")
        assertThat(agentWaitForSubagentsCallItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentWaitForSubagentsCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentWaitForSubagentsCallItem =
            AgentWaitForSubagentsCallItem.builder()
                .id("id")
                .addRecipientAgentId("string")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentWaitForSubagentsCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentWaitForSubagentsCallItem),
                jacksonTypeRef<AgentWaitForSubagentsCallItem>(),
            )

        assertThat(roundtrippedAgentWaitForSubagentsCallItem)
            .isEqualTo(agentWaitForSubagentsCallItem)
    }
}
