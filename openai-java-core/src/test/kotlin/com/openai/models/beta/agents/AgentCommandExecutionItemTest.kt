// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentCommandExecutionItemTest {

    @Test
    fun create() {
        val agentCommandExecutionItem =
            AgentCommandExecutionItem.builder()
                .id("id")
                .command("command")
                .cwd("cwd")
                .durationMs(0L)
                .exitCode(0L)
                .output("output")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentCommandExecutionItem.id()).isEqualTo("id")
        assertThat(agentCommandExecutionItem.command()).isEqualTo("command")
        assertThat(agentCommandExecutionItem.cwd()).contains("cwd")
        assertThat(agentCommandExecutionItem.durationMs()).contains(0L)
        assertThat(agentCommandExecutionItem.exitCode()).contains(0L)
        assertThat(agentCommandExecutionItem.output()).contains("output")
        assertThat(agentCommandExecutionItem.status())
            .isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentCommandExecutionItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentCommandExecutionItem =
            AgentCommandExecutionItem.builder()
                .id("id")
                .command("command")
                .cwd("cwd")
                .durationMs(0L)
                .exitCode(0L)
                .output("output")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentCommandExecutionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentCommandExecutionItem),
                jacksonTypeRef<AgentCommandExecutionItem>(),
            )

        assertThat(roundtrippedAgentCommandExecutionItem).isEqualTo(agentCommandExecutionItem)
    }
}
