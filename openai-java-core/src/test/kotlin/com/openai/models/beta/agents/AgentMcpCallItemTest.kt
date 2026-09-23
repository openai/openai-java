// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentMcpCallItemTest {

    @Test
    fun create() {
        val agentMcpCallItem =
            AgentMcpCallItem.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .error(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .output(JsonValue.from(mapOf<String, Any>()))
                .serverLabel("server_label")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentMcpCallItem.id()).isEqualTo("id")
        assertThat(agentMcpCallItem._arguments()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(agentMcpCallItem._error()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(agentMcpCallItem.name()).isEqualTo("name")
        assertThat(agentMcpCallItem._output()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(agentMcpCallItem.serverLabel()).isEqualTo("server_label")
        assertThat(agentMcpCallItem.status()).isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentMcpCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentMcpCallItem =
            AgentMcpCallItem.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .error(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .output(JsonValue.from(mapOf<String, Any>()))
                .serverLabel("server_label")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentMcpCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentMcpCallItem),
                jacksonTypeRef<AgentMcpCallItem>(),
            )

        assertThat(roundtrippedAgentMcpCallItem).isEqualTo(agentMcpCallItem)
    }
}
