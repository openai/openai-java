// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentCreateSubagentCallItemTest {

    @Test
    fun create() {
        val agentCreateSubagentCallItem =
            AgentCreateSubagentCallItem.builder()
                .id("id")
                .agentId("agent_id")
                .addOutputTextContent("text")
                .model("model")
                .reasoningEffort("reasoning_effort")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentCreateSubagentCallItem.id()).isEqualTo("id")
        assertThat(agentCreateSubagentCallItem.agentId()).isEqualTo("agent_id")
        assertThat(agentCreateSubagentCallItem.content())
            .containsExactly(AgentContent.ofOutputText(OutputText.builder().text("text").build()))
        assertThat(agentCreateSubagentCallItem.model()).contains("model")
        assertThat(agentCreateSubagentCallItem.reasoningEffort()).contains("reasoning_effort")
        assertThat(agentCreateSubagentCallItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentCreateSubagentCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentCreateSubagentCallItem =
            AgentCreateSubagentCallItem.builder()
                .id("id")
                .agentId("agent_id")
                .addOutputTextContent("text")
                .model("model")
                .reasoningEffort("reasoning_effort")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentCreateSubagentCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentCreateSubagentCallItem),
                jacksonTypeRef<AgentCreateSubagentCallItem>(),
            )

        assertThat(roundtrippedAgentCreateSubagentCallItem).isEqualTo(agentCreateSubagentCallItem)
    }
}
