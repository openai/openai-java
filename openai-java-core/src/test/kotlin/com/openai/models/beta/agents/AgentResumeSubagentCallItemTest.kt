// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentResumeSubagentCallItemTest {

    @Test
    fun create() {
        val agentResumeSubagentCallItem =
            AgentResumeSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentResumeSubagentCallItem.id()).isEqualTo("id")
        assertThat(agentResumeSubagentCallItem.recipientAgentId()).isEqualTo("recipient_agent_id")
        assertThat(agentResumeSubagentCallItem.senderAgentId()).isEqualTo("sender_agent_id")
        assertThat(agentResumeSubagentCallItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentResumeSubagentCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentResumeSubagentCallItem =
            AgentResumeSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentResumeSubagentCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentResumeSubagentCallItem),
                jacksonTypeRef<AgentResumeSubagentCallItem>(),
            )

        assertThat(roundtrippedAgentResumeSubagentCallItem).isEqualTo(agentResumeSubagentCallItem)
    }
}
