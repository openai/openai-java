// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSendSubagentInputCallItemTest {

    @Test
    fun create() {
        val agentSendSubagentInputCallItem =
            AgentSendSubagentInputCallItem.builder()
                .id("id")
                .addOutputTextContent("text")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentSendSubagentInputCallItem.id()).isEqualTo("id")
        assertThat(agentSendSubagentInputCallItem.content())
            .containsExactly(AgentContent.ofOutputText(OutputText.builder().text("text").build()))
        assertThat(agentSendSubagentInputCallItem.recipientAgentId())
            .isEqualTo("recipient_agent_id")
        assertThat(agentSendSubagentInputCallItem.senderAgentId()).isEqualTo("sender_agent_id")
        assertThat(agentSendSubagentInputCallItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentSendSubagentInputCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSendSubagentInputCallItem =
            AgentSendSubagentInputCallItem.builder()
                .id("id")
                .addOutputTextContent("text")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentSendSubagentInputCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSendSubagentInputCallItem),
                jacksonTypeRef<AgentSendSubagentInputCallItem>(),
            )

        assertThat(roundtrippedAgentSendSubagentInputCallItem)
            .isEqualTo(agentSendSubagentInputCallItem)
    }
}
