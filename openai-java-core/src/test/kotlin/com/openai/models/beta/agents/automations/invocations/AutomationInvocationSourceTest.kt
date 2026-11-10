// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import com.openai.models.beta.agents.automations.AutomationAgentConfig
import com.openai.models.beta.agents.automations.AutomationTarget
import com.openai.models.beta.agents.automations.PeriodicAutomation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AutomationInvocationSourceTest {

    @Test
    fun ofManual() {
        val automationInvocationSource = AutomationInvocationSource.ofManual()

        assertThat(automationInvocationSource.manual())
            .contains(JsonValue.from(mapOf("type" to "manual")))
        assertThat(automationInvocationSource.automation()).isEmpty
    }

    @Test
    fun ofManualRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationInvocationSource = AutomationInvocationSource.ofManual()

        val roundtrippedAutomationInvocationSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationInvocationSource),
                jacksonTypeRef<AutomationInvocationSource>(),
            )

        assertThat(roundtrippedAutomationInvocationSource).isEqualTo(automationInvocationSource)
    }

    @Test
    fun ofAutomation() {
        val automation =
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

        val automationInvocationSource = AutomationInvocationSource.ofAutomation(automation)

        assertThat(automationInvocationSource.manual()).isEmpty
        assertThat(automationInvocationSource.automation()).contains(automation)
    }

    @Test
    fun ofAutomationRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationInvocationSource =
            AutomationInvocationSource.ofAutomation(
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
            )

        val roundtrippedAutomationInvocationSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationInvocationSource),
                jacksonTypeRef<AutomationInvocationSource>(),
            )

        assertThat(roundtrippedAutomationInvocationSource).isEqualTo(automationInvocationSource)
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
        val automationInvocationSource =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AutomationInvocationSource>())

        val e = assertThrows<OpenAIInvalidDataException> { automationInvocationSource.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
