// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentTest {

    @Test
    fun createAndRoundtrip() {
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
                        .async(true)
                        .build()
                )
                .updatedAt(0L)
                .compaction(Agent.Compaction.builder().async(true).build())
                .experimental(Agent.Experimental.builder().timeAwareness(true).build())
                .build()

        assertThat(agent.id()).contains("id")
        assertThat(agent.createdAt()).contains(0L)
        assertThat(agent.instructions()).contains("instructions")
        assertThat(agent.metadata())
            .contains(
                Agent.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(agent.model()).contains("model")
        assertThat(agent.multiAgent())
            .contains(MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build())
        assertThat(agent.name()).contains("name")
        assertThat(agent.reasoning())
            .contains(
                AgentReasoning.builder()
                    .effort(AgentReasoning.Effort.NONE)
                    .summary(AgentReasoning.Summary.CONCISE)
                    .build()
            )
        assertThat(agent.serviceTier()).contains(Agent.ServiceTier.AUTO)
        assertThat(agent.text())
            .contains(AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build())
        assertThat(agent.tools().getOrNull())
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
                        .async(true)
                        .build()
                )
            )
        assertThat(agent.updatedAt()).contains(0L)
        assertThat(agent.compaction()).contains(Agent.Compaction.builder().async(true).build())
        assertThat(agent.experimental())
            .contains(Agent.Experimental.builder().timeAwareness(true).build())

        val jsonMapper = jsonMapper()

        val roundtrippedAgent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(agent), jacksonTypeRef<Agent>())

        assertThat(roundtrippedAgent).isEqualTo(agent)
    }
}
