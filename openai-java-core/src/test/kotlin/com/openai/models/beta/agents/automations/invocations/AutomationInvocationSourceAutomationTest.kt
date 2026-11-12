// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import com.openai.models.beta.agents.automations.Automation
import com.openai.models.beta.agents.automations.AutomationAgentConfig
import com.openai.models.beta.agents.automations.AutomationTarget
import com.openai.models.beta.agents.automations.PeriodicAutomation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationInvocationSourceAutomationTest {

    @Test
    fun createAndRoundtrip() {
        val automationInvocationSourceAutomation =
            AutomationInvocationSourceAutomation.builder()
                .automation(
                    PeriodicAutomation.builder()
                        .id("id")
                        .createdAt(0L)
                        .createdByDeveloper()
                        .expression("expression")
                        .metadata(
                            PeriodicAutomation.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .name("name")
                        .status(PeriodicAutomation.Status.ACTIVE)
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
                                                        .putAdditionalProperty(
                                                            "foo",
                                                            JsonValue.from("bar"),
                                                        )
                                                        .build()
                                                )
                                                .async(true)
                                                .build()
                                        )
                                        .compaction(
                                            AutomationAgentConfig.Compaction.builder()
                                                .async(true)
                                                .build()
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
                        .timezone("timezone")
                        .build()
                )
                .build()

        assertThat(automationInvocationSourceAutomation.automation())
            .contains(
                Automation.ofPeriodic(
                    PeriodicAutomation.builder()
                        .id("id")
                        .createdAt(0L)
                        .createdByDeveloper()
                        .expression("expression")
                        .metadata(
                            PeriodicAutomation.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .name("name")
                        .status(PeriodicAutomation.Status.ACTIVE)
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
                                                        .putAdditionalProperty(
                                                            "foo",
                                                            JsonValue.from("bar"),
                                                        )
                                                        .build()
                                                )
                                                .async(true)
                                                .build()
                                        )
                                        .compaction(
                                            AutomationAgentConfig.Compaction.builder()
                                                .async(true)
                                                .build()
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
                        .timezone("timezone")
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedAutomationInvocationSourceAutomation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationInvocationSourceAutomation),
                jacksonTypeRef<AutomationInvocationSourceAutomation>(),
            )

        assertThat(roundtrippedAutomationInvocationSourceAutomation)
            .isEqualTo(automationInvocationSourceAutomation)
    }
}
