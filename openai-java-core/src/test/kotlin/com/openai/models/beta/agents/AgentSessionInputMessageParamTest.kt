// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionInputMessageParamTest {

    @Test
    fun create() {
        val agentSessionInputMessageParam =
            AgentSessionInputMessageParam.builder()
                .addInputTextContent("text")
                .type(AgentSessionInputMessageParam.Type.MESSAGE)
                .build()

        assertThat(agentSessionInputMessageParam.content())
            .containsExactly(
                InputContentParam.ofInputText(
                    InputContentParam.InputText.builder().text("text").build()
                )
            )
        assertThat(agentSessionInputMessageParam.type())
            .contains(AgentSessionInputMessageParam.Type.MESSAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionInputMessageParam =
            AgentSessionInputMessageParam.builder()
                .addInputTextContent("text")
                .type(AgentSessionInputMessageParam.Type.MESSAGE)
                .build()

        val roundtrippedAgentSessionInputMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionInputMessageParam),
                jacksonTypeRef<AgentSessionInputMessageParam>(),
            )

        assertThat(roundtrippedAgentSessionInputMessageParam)
            .isEqualTo(agentSessionInputMessageParam)
    }
}
