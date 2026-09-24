// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentListPageResponseTest {

    @Test
    fun create() {
        val agentListPageResponse =
            AgentListPageResponse.builder()
                .addData(
                    Agent.builder()
                        .id("id")
                        .createdAt(0L)
                        .instructions("instructions")
                        .metadata(
                            Agent.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model("model")
                        .multiAgent(
                            MultiAgentConfig.builder()
                                .enabled(true)
                                .maxConcurrentSubagents(1L)
                                .build()
                        )
                        .name("name")
                        .reasoning(
                            AgentReasoning.builder()
                                .effort(AgentReasoning.Effort.NONE)
                                .summary(AgentReasoning.Summary.CONCISE)
                                .build()
                        )
                        .serviceTier(Agent.ServiceTier.AUTO)
                        .text(
                            AgentText.builder()
                                .formatText()
                                .verbosity(AgentText.Verbosity.LOW)
                                .build()
                        )
                        .addTool(
                            PersistedAgentTool.Function.builder()
                                .deferLoading(true)
                                .description("description")
                                .name("name")
                                .parameters(
                                    PersistedAgentTool.Function.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(agentListPageResponse.data())
            .containsExactly(
                Agent.builder()
                    .id("id")
                    .createdAt(0L)
                    .instructions("instructions")
                    .metadata(
                        Agent.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model("model")
                    .multiAgent(
                        MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build()
                    )
                    .name("name")
                    .reasoning(
                        AgentReasoning.builder()
                            .effort(AgentReasoning.Effort.NONE)
                            .summary(AgentReasoning.Summary.CONCISE)
                            .build()
                    )
                    .serviceTier(Agent.ServiceTier.AUTO)
                    .text(
                        AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build()
                    )
                    .addTool(
                        PersistedAgentTool.Function.builder()
                            .deferLoading(true)
                            .description("description")
                            .name("name")
                            .parameters(
                                PersistedAgentTool.Function.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .updatedAt(0L)
                    .build()
            )
        assertThat(agentListPageResponse.firstId()).contains("first_id")
        assertThat(agentListPageResponse.hasMore()).isEqualTo(true)
        assertThat(agentListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentListPageResponse =
            AgentListPageResponse.builder()
                .addData(
                    Agent.builder()
                        .id("id")
                        .createdAt(0L)
                        .instructions("instructions")
                        .metadata(
                            Agent.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model("model")
                        .multiAgent(
                            MultiAgentConfig.builder()
                                .enabled(true)
                                .maxConcurrentSubagents(1L)
                                .build()
                        )
                        .name("name")
                        .reasoning(
                            AgentReasoning.builder()
                                .effort(AgentReasoning.Effort.NONE)
                                .summary(AgentReasoning.Summary.CONCISE)
                                .build()
                        )
                        .serviceTier(Agent.ServiceTier.AUTO)
                        .text(
                            AgentText.builder()
                                .formatText()
                                .verbosity(AgentText.Verbosity.LOW)
                                .build()
                        )
                        .addTool(
                            PersistedAgentTool.Function.builder()
                                .deferLoading(true)
                                .description("description")
                                .name("name")
                                .parameters(
                                    PersistedAgentTool.Function.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedAgentListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentListPageResponse),
                jacksonTypeRef<AgentListPageResponse>(),
            )

        assertThat(roundtrippedAgentListPageResponse).isEqualTo(agentListPageResponse)
    }
}
