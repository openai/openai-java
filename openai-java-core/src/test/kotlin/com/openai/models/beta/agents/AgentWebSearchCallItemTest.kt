// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentWebSearchCallItemTest {

    @Test
    fun create() {
        val agentWebSearchCallItem =
            AgentWebSearchCallItem.builder()
                .id("id")
                .action(WebSearchAction.Search.builder().addQuery("string").query("query").build())
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentWebSearchCallItem.id()).isEqualTo("id")
        assertThat(agentWebSearchCallItem.action())
            .contains(
                WebSearchAction.ofSearch(
                    WebSearchAction.Search.builder().addQuery("string").query("query").build()
                )
            )
        assertThat(agentWebSearchCallItem.status()).isEqualTo(AgentOutputItemStatus.IN_PROGRESS)
        assertThat(agentWebSearchCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentWebSearchCallItem =
            AgentWebSearchCallItem.builder()
                .id("id")
                .action(WebSearchAction.Search.builder().addQuery("string").query("query").build())
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentWebSearchCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentWebSearchCallItem),
                jacksonTypeRef<AgentWebSearchCallItem>(),
            )

        assertThat(roundtrippedAgentWebSearchCallItem).isEqualTo(agentWebSearchCallItem)
    }
}
