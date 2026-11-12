// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AutomationTest {

    @Test
    fun ofPeriodic() {
        val periodic =
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
                .timezone("timezone")
                .build()

        val automation = Automation.ofPeriodic(periodic)

        assertThat(automation.periodic()).contains(periodic)
        assertThat(automation.once()).isEmpty
    }

    @Test
    fun ofPeriodicRoundtrip() {
        val jsonMapper = jsonMapper()
        val automation =
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

        val roundtrippedAutomation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automation),
                jacksonTypeRef<Automation>(),
            )

        assertThat(roundtrippedAutomation).isEqualTo(automation)
    }

    @Test
    fun ofOnce() {
        val once =
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

        val automation = Automation.ofOnce(once)

        assertThat(automation.periodic()).isEmpty
        assertThat(automation.once()).contains(once)
    }

    @Test
    fun ofOnceRoundtrip() {
        val jsonMapper = jsonMapper()
        val automation =
            Automation.ofOnce(
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
                    .build()
            )

        val roundtrippedAutomation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automation),
                jacksonTypeRef<Automation>(),
            )

        assertThat(roundtrippedAutomation).isEqualTo(automation)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val automation = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Automation>())

        val e = assertThrows<OpenAIInvalidDataException> { automation.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
