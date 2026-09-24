// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentTest {

    @Test
    fun create() {
        val agent =
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
                .text(AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build())
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

        assertThat(agent.id()).isEqualTo("id")
        assertThat(agent.createdAt()).isEqualTo(0L)
        assertThat(agent.instructions()).contains("instructions")
        assertThat(agent.metadata())
            .isEqualTo(
                Agent.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(agent.model()).isEqualTo("model")
        assertThat(agent.multiAgent())
            .isEqualTo(MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build())
        assertThat(agent.name()).contains("name")
        assertThat(agent.reasoning())
            .isEqualTo(
                AgentReasoning.builder()
                    .effort(AgentReasoning.Effort.NONE)
                    .summary(AgentReasoning.Summary.CONCISE)
                    .build()
            )
        assertThat(agent.serviceTier()).isEqualTo(Agent.ServiceTier.AUTO)
        assertThat(agent.text())
            .isEqualTo(AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build())
        assertThat(agent.tools())
            .containsExactly(
                PersistedAgentTool.ofFunction(
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
            )
        assertThat(agent.updatedAt()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agent =
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
                .text(AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build())
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

        val roundtrippedAgent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(agent), jacksonTypeRef<Agent>())

        assertThat(roundtrippedAgent).isEqualTo(agent)
    }
}
