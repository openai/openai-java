// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.Subagent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubagentListPageResponseTest {

    @Test
    fun create() {
        val subagentListPageResponse =
            SubagentListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(subagentListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(subagentListPageResponse.firstId()).contains("first_id")
        assertThat(subagentListPageResponse.hasMore()).isEqualTo(true)
        assertThat(subagentListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subagentListPageResponse =
            SubagentListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedSubagentListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subagentListPageResponse),
                jacksonTypeRef<SubagentListPageResponse>(),
            )

        assertThat(roundtrippedSubagentListPageResponse).isEqualTo(subagentListPageResponse)
    }
}
