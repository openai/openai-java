// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationAgentConfigTest {

    @Test
    fun createAndRoundtrip() {
        val automationAgentConfig =
            AutomationAgentConfig.builder()
                .instructions("instructions")
                .model("model")
                .multiAgent(
                    MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build()
                )
                .reasoning(
                    AgentReasoning.builder()
                        .effort(AgentReasoning.Effort.NONE)
                        .summary(AgentReasoning.Summary.CONCISE)
                        .build()
                )
                .serviceTier(AutomationAgentConfig.ServiceTier.AUTO)
                .text(AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build())
                .addTool(
                    AgentTool.Function.builder()
                        .deferLoading(true)
                        .description("description")
                        .name("name")
                        .parameters(
                            AgentTool.Function.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .compaction(AutomationAgentConfig.Compaction.builder().async(true).build())
                .experimental(
                    AutomationAgentConfig.Experimental.builder().timeAwareness(true).build()
                )
                .build()

        assertThat(automationAgentConfig.instructions()).contains("instructions")
        assertThat(automationAgentConfig.model()).contains("model")
        assertThat(automationAgentConfig.multiAgent())
            .contains(MultiAgentConfig.builder().enabled(true).maxConcurrentSubagents(1L).build())
        assertThat(automationAgentConfig.reasoning())
            .contains(
                AgentReasoning.builder()
                    .effort(AgentReasoning.Effort.NONE)
                    .summary(AgentReasoning.Summary.CONCISE)
                    .build()
            )
        assertThat(automationAgentConfig.serviceTier())
            .contains(AutomationAgentConfig.ServiceTier.AUTO)
        assertThat(automationAgentConfig.text())
            .contains(AgentText.builder().formatText().verbosity(AgentText.Verbosity.LOW).build())
        assertThat(automationAgentConfig.tools().getOrNull())
            .containsExactly(
                AgentTool.ofFunction(
                    AgentTool.Function.builder()
                        .deferLoading(true)
                        .description("description")
                        .name("name")
                        .parameters(
                            AgentTool.Function.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(automationAgentConfig.compaction())
            .contains(AutomationAgentConfig.Compaction.builder().async(true).build())
        assertThat(automationAgentConfig.experimental())
            .contains(AutomationAgentConfig.Experimental.builder().timeAwareness(true).build())

        val jsonMapper = jsonMapper()

        val roundtrippedAutomationAgentConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationAgentConfig),
                jacksonTypeRef<AutomationAgentConfig>(),
            )

        assertThat(roundtrippedAutomationAgentConfig).isEqualTo(automationAgentConfig)
    }
}
