// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentFunctionCallItemTest {

    @Test
    fun create() {
        val agentFunctionCallItem =
            AgentFunctionCallItem.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .name("name")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        assertThat(agentFunctionCallItem.id()).isEqualTo("id")
        assertThat(agentFunctionCallItem._arguments())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(agentFunctionCallItem.callId()).isEqualTo("call_id")
        assertThat(agentFunctionCallItem.name()).isEqualTo("name")
        assertThat(agentFunctionCallItem.status()).isEqualTo(AgentFunctionCallStatus.IN_PROGRESS)
        assertThat(agentFunctionCallItem.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentFunctionCallItem =
            AgentFunctionCallItem.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .name("name")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val roundtrippedAgentFunctionCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentFunctionCallItem),
                jacksonTypeRef<AgentFunctionCallItem>(),
            )

        assertThat(roundtrippedAgentFunctionCallItem).isEqualTo(agentFunctionCallItem)
    }
}
