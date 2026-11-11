// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSendSubagentInputCallItemTest {

    @Test
    fun createAndRoundtrip() {
        val agentSendSubagentInputCallItem =
            AgentSendSubagentInputCallItem.builder()
                .id("id")
                .addOutputTextContent("text")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentSendSubagentInputCallItem.id()).contains("id")
        assertThat(agentSendSubagentInputCallItem.content().getOrNull())
            .containsExactly(AgentContent.ofOutputText(OutputText.builder().text("text").build()))
        assertThat(agentSendSubagentInputCallItem.recipientAgentId()).contains("recipient_agent_id")
        assertThat(agentSendSubagentInputCallItem.senderAgentId()).contains("sender_agent_id")
        assertThat(agentSendSubagentInputCallItem.status())
            .contains(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentSendSubagentInputCallItem.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSendSubagentInputCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSendSubagentInputCallItem),
                jacksonTypeRef<AgentSendSubagentInputCallItem>(),
            )

        assertThat(roundtrippedAgentSendSubagentInputCallItem)
            .isEqualTo(agentSendSubagentInputCallItem)
    }
}
