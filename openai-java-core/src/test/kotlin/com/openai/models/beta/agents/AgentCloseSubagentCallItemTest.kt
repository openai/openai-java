// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentCloseSubagentCallItemTest {

    @Test
    fun create() {
        val agentCloseSubagentCallItem =
            AgentCloseSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentCloseSubagentCallItem.id()).isEqualTo("id")
        assertThat(agentCloseSubagentCallItem.recipientAgentId()).isEqualTo("recipient_agent_id")
        assertThat(agentCloseSubagentCallItem.senderAgentId()).isEqualTo("sender_agent_id")
        assertThat(agentCloseSubagentCallItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentCloseSubagentCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentCloseSubagentCallItem =
            AgentCloseSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentCloseSubagentCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentCloseSubagentCallItem),
                jacksonTypeRef<AgentCloseSubagentCallItem>(),
            )

        assertThat(roundtrippedAgentCloseSubagentCallItem).isEqualTo(agentCloseSubagentCallItem)
    }
}
