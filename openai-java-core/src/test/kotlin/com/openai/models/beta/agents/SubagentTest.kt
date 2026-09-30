// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubagentTest {

    @Test
    fun create() {
        val subagent =
            Subagent.builder()
                .id("id")
                .closedAt(0L)
                .addOutputTextInstruction("text")
                .name("name")
                .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                .openedAt(0L)
                .parentAgentId("parent_agent_id")
                .sessionId("session_id")
                .status(Subagent.Status.ACTIVE)
                .build()

        assertThat(subagent.id()).isEqualTo("id")
        assertThat(subagent.closedAt()).contains(0L)
        assertThat(subagent.instructions().getOrNull())
            .containsExactly(AgentContent.ofOutputText(OutputText.builder().text("text").build()))
        assertThat(subagent.name()).contains("name")
        assertThat(subagent.object_()).isEqualTo(Subagent.Object.AGENT_SESSION_SUBAGENT)
        assertThat(subagent.openedAt()).isEqualTo(0L)
        assertThat(subagent.parentAgentId()).isEqualTo("parent_agent_id")
        assertThat(subagent.sessionId()).isEqualTo("session_id")
        assertThat(subagent.status()).isEqualTo(Subagent.Status.ACTIVE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subagent =
            Subagent.builder()
                .id("id")
                .closedAt(0L)
                .addOutputTextInstruction("text")
                .name("name")
                .object_(Subagent.Object.AGENT_SESSION_SUBAGENT)
                .openedAt(0L)
                .parentAgentId("parent_agent_id")
                .sessionId("session_id")
                .status(Subagent.Status.ACTIVE)
                .build()

        val roundtrippedSubagent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subagent),
                jacksonTypeRef<Subagent>(),
            )

        assertThat(roundtrippedSubagent).isEqualTo(subagent)
    }
}
