// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OneTimeAutomationTest {

    @Test
    fun createAndRoundtrip() {
        val oneTimeAutomation =
            OneTimeAutomation.builder()
                .id("id")
                .createdAt(0L)
                .createdByDeveloper()
                .metadata(
                    OneTimeAutomation.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .runAt(0L)
                .status(OneTimeAutomation.Status.ACTIVE)
                .target(
                    AutomationTarget.NewSession.builder()
                        .agent(
                            AutomationAgentConfig.builder()
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AutomationAgentConfig.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
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
                                        .async(true)
                                        .build()
                                )
                                .compaction(
                                    AutomationAgentConfig.Compaction.builder().async(true).build()
                                )
                                .experimental(
                                    AutomationAgentConfig.Experimental.builder()
                                        .timeAwareness(true)
                                        .build()
                                )
                                .build()
                        )
                        .agentId("agent_id")
                        .environmentNone()
                        .addInput(
                            AutomationTarget.NewSession.Input.builder()
                                .addInputTextContent("text")
                                .build()
                        )
                        .metadata(
                            AutomationTarget.NewSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addVaultId("string")
                        .build()
                )
                .build()

        assertThat(oneTimeAutomation.id()).isEqualTo("id")
        assertThat(oneTimeAutomation.createdAt()).isEqualTo(0L)
        assertThat(oneTimeAutomation.createdBy()).isEqualTo(AutomationCreatedBy.ofDeveloper())
        assertThat(oneTimeAutomation.metadata())
            .isEqualTo(
                OneTimeAutomation.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(oneTimeAutomation.name()).isEqualTo("name")
        assertThat(oneTimeAutomation.runAt()).isEqualTo(0L)
        assertThat(oneTimeAutomation.status()).isEqualTo(OneTimeAutomation.Status.ACTIVE)
        assertThat(oneTimeAutomation.target())
            .isEqualTo(
                AutomationTarget.ofNewSession(
                    AutomationTarget.NewSession.builder()
                        .agent(
                            AutomationAgentConfig.builder()
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfig.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .reasoning(
                                    AgentReasoning.builder()
                                        .effort(AgentReasoning.Effort.NONE)
                                        .summary(AgentReasoning.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(AutomationAgentConfig.ServiceTier.AUTO)
                                .text(
                                    AgentText.builder()
                                        .formatText()
                                        .verbosity(AgentText.Verbosity.LOW)
                                        .build()
                                )
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
                                        .async(true)
                                        .build()
                                )
                                .compaction(
                                    AutomationAgentConfig.Compaction.builder().async(true).build()
                                )
                                .experimental(
                                    AutomationAgentConfig.Experimental.builder()
                                        .timeAwareness(true)
                                        .build()
                                )
                                .build()
                        )
                        .agentId("agent_id")
                        .environmentNone()
                        .addInput(
                            AutomationTarget.NewSession.Input.builder()
                                .addInputTextContent("text")
                                .build()
                        )
                        .metadata(
                            AutomationTarget.NewSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addVaultId("string")
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedOneTimeAutomation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(oneTimeAutomation),
                jacksonTypeRef<OneTimeAutomation>(),
            )

        assertThat(roundtrippedOneTimeAutomation).isEqualTo(oneTimeAutomation)
    }
}
