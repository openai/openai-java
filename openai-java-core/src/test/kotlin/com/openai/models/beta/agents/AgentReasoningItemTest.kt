// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentReasoningItemTest {

    @Test
    fun create() {
        val agentReasoningItem =
            AgentReasoningItem.builder()
                .id("id")
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .addSummary(SummaryText.builder().text("text").build())
                .turnId("turn_id")
                .build()

        assertThat(agentReasoningItem.id()).isEqualTo("id")
        assertThat(agentReasoningItem.status()).contains(AgentOutputItemStatus.IN_PROGRESS)
        assertThat(agentReasoningItem.summary())
            .containsExactly(SummaryText.builder().text("text").build())
        assertThat(agentReasoningItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentReasoningItem =
            AgentReasoningItem.builder()
                .id("id")
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .addSummary(SummaryText.builder().text("text").build())
                .turnId("turn_id")
                .build()

        val roundtrippedAgentReasoningItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentReasoningItem),
                jacksonTypeRef<AgentReasoningItem>(),
            )

        assertThat(roundtrippedAgentReasoningItem).isEqualTo(agentReasoningItem)
    }
}
