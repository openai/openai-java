// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentCreateSubagentCallItemTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(agentCreateSubagentCallItem.id()).contains("id")
        assertThat(agentCreateSubagentCallItem.agentId()).contains("agent_id")
        assertThat(agentCreateSubagentCallItem.content().getOrNull())
            .containsExactly(AgentContent.ofOutputText(OutputText.builder().text("text").build()))
        assertThat(agentCreateSubagentCallItem.model()).contains("model")
        assertThat(agentCreateSubagentCallItem.reasoningEffort()).contains("reasoning_effort")
        assertThat(agentCreateSubagentCallItem.status())
            .contains(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentCreateSubagentCallItem.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentCreateSubagentCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentCreateSubagentCallItem),
                jacksonTypeRef<AgentCreateSubagentCallItem>(),
            )

        assertThat(roundtrippedAgentCreateSubagentCallItem).isEqualTo(agentCreateSubagentCallItem)
    }
}
