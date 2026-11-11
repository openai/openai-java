// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentWaitForSubagentsCallItemTest {

    @Test
    fun createAndRoundtrip() {
        val agentWaitForSubagentsCallItem =
            AgentWaitForSubagentsCallItem.builder()
                .id("id")
                .addRecipientAgentId("string")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentWaitForSubagentsCallItem.id()).contains("id")
        assertThat(agentWaitForSubagentsCallItem.recipientAgentIds().getOrNull())
            .containsExactly("string")
        assertThat(agentWaitForSubagentsCallItem.senderAgentId()).contains("sender_agent_id")
        assertThat(agentWaitForSubagentsCallItem.status())
            .contains(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentWaitForSubagentsCallItem.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedAgentWaitForSubagentsCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentWaitForSubagentsCallItem),
                jacksonTypeRef<AgentWaitForSubagentsCallItem>(),
            )

        assertThat(roundtrippedAgentWaitForSubagentsCallItem)
            .isEqualTo(agentWaitForSubagentsCallItem)
    }
}
