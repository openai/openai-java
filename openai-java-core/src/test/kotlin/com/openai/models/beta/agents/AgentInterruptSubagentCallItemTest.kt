// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentInterruptSubagentCallItemTest {

    @Test
    fun create() {
        val agentInterruptSubagentCallItem =
            AgentInterruptSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentInterruptSubagentCallItem.id()).isEqualTo("id")
        assertThat(agentInterruptSubagentCallItem.recipientAgentId())
            .isEqualTo("recipient_agent_id")
        assertThat(agentInterruptSubagentCallItem.senderAgentId()).isEqualTo("sender_agent_id")
        assertThat(agentInterruptSubagentCallItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentInterruptSubagentCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentInterruptSubagentCallItem =
            AgentInterruptSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentInterruptSubagentCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentInterruptSubagentCallItem),
                jacksonTypeRef<AgentInterruptSubagentCallItem>(),
            )

        assertThat(roundtrippedAgentInterruptSubagentCallItem)
            .isEqualTo(agentInterruptSubagentCallItem)
    }
}
