// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubagentTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(subagent.id()).contains("id")
        assertThat(subagent.closedAt()).contains(0L)
        assertThat(subagent.instructions().getOrNull())
            .containsExactly(AgentContent.ofOutputText(OutputText.builder().text("text").build()))
        assertThat(subagent.name()).contains("name")
        assertThat(subagent.object_()).contains(JsonValue.from("agent.session.subagent"))
        assertThat(subagent.openedAt()).contains(0L)
        assertThat(subagent.parentAgentId()).contains("parent_agent_id")
        assertThat(subagent.sessionId()).contains("session_id")
        assertThat(subagent.status()).contains(Subagent.Status.ACTIVE)

        val jsonMapper = jsonMapper()

        val roundtrippedSubagent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subagent),
                jacksonTypeRef<Subagent>(),
            )

        assertThat(roundtrippedSubagent).isEqualTo(subagent)
    }
}
