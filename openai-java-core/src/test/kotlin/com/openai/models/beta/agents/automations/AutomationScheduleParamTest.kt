// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AutomationScheduleParamTest {

    @Test
    fun ofPeriodic() {
        val periodic =
            AutomationScheduleParam.Periodic.builder()
                .expression("x")
                .name("x")
                .target(
                    AutomationTargetParam.NewSession.builder()
                        .environmentNone()
                        .addInput(
                            AgentSessionInputMessageParam.builder()
                                .addInputTextContent("text")
                                .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                .build()
                        )
                        .agent(
                            AutomationTargetParam.NewSession.Agent.builder()
                                .compaction(
                                    AutomationTargetParam.NewSession.Agent.Compaction.builder()
                                        .async(true)
                                        .build()
                                )
                                .experimental(
                                    AutomationTargetParam.NewSession.Agent.Experimental.builder()
                                        .timeAwareness(true)
                                        .build()
                                )
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfigParam.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .reasoning(
                                    AgentReasoningParam.builder()
                                        .effort(AgentReasoningParam.Effort.NONE)
                                        .summary(AgentReasoningParam.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(
                                    AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO
                                )
                                .text(
                                    AgentTextParam.builder()
                                        .formatText()
                                        .verbosity(AgentTextParam.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentToolParam.Function.builder()
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentToolParam.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .deferLoading(true)
                                        .build()
                                )
                                .build()
                        )
                        .agentId("agent_id")
                        .metadata(
                            AutomationTargetParam.NewSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addVaultId("string")
                        .build()
                )
                .timezone("x")
                .metadata(
                    AutomationScheduleParam.Periodic.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val automationScheduleParam = AutomationScheduleParam.ofPeriodic(periodic)

        assertThat(automationScheduleParam.periodic()).contains(periodic)
        assertThat(automationScheduleParam.once()).isEmpty
    }

    @Test
    fun ofPeriodicRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationScheduleParam =
            AutomationScheduleParam.ofPeriodic(
                AutomationScheduleParam.Periodic.builder()
                    .expression("x")
                    .name("x")
                    .target(
                        AutomationTargetParam.NewSession.builder()
                            .environmentNone()
                            .addInput(
                                AgentSessionInputMessageParam.builder()
                                    .addInputTextContent("text")
                                    .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                    .build()
                            )
                            .agent(
                                AutomationTargetParam.NewSession.Agent.builder()
                                    .compaction(
                                        AutomationTargetParam.NewSession.Agent.Compaction.builder()
                                            .async(true)
                                            .build()
                                    )
                                    .experimental(
                                        AutomationTargetParam.NewSession.Agent.Experimental
                                            .builder()
                                            .timeAwareness(true)
                                            .build()
                                    )
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfigParam.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .reasoning(
                                        AgentReasoningParam.builder()
                                            .effort(AgentReasoningParam.Effort.NONE)
                                            .summary(AgentReasoningParam.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(
                                        AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO
                                    )
                                    .text(
                                        AgentTextParam.builder()
                                            .formatText()
                                            .verbosity(AgentTextParam.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentToolParam.Function.builder()
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentToolParam.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .deferLoading(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .agentId("agent_id")
                            .metadata(
                                AutomationTargetParam.NewSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addVaultId("string")
                            .build()
                    )
                    .timezone("x")
                    .metadata(
                        AutomationScheduleParam.Periodic.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedAutomationScheduleParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationScheduleParam),
                jacksonTypeRef<AutomationScheduleParam>(),
            )

        assertThat(roundtrippedAutomationScheduleParam).isEqualTo(automationScheduleParam)
    }

    @Test
    fun ofOnce() {
        val once =
            AutomationScheduleParam.Once.builder()
                .name("x")
                .runAt(0L)
                .target(
                    AutomationTargetParam.NewSession.builder()
                        .environmentNone()
                        .addInput(
                            AgentSessionInputMessageParam.builder()
                                .addInputTextContent("text")
                                .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                .build()
                        )
                        .agent(
                            AutomationTargetParam.NewSession.Agent.builder()
                                .compaction(
                                    AutomationTargetParam.NewSession.Agent.Compaction.builder()
                                        .async(true)
                                        .build()
                                )
                                .experimental(
                                    AutomationTargetParam.NewSession.Agent.Experimental.builder()
                                        .timeAwareness(true)
                                        .build()
                                )
                                .instructions("instructions")
                                .model("model")
                                .multiAgent(
                                    MultiAgentConfigParam.builder()
                                        .enabled(true)
                                        .maxConcurrentSubagents(1L)
                                        .build()
                                )
                                .reasoning(
                                    AgentReasoningParam.builder()
                                        .effort(AgentReasoningParam.Effort.NONE)
                                        .summary(AgentReasoningParam.Summary.CONCISE)
                                        .build()
                                )
                                .serviceTier(
                                    AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO
                                )
                                .text(
                                    AgentTextParam.builder()
                                        .formatText()
                                        .verbosity(AgentTextParam.Verbosity.LOW)
                                        .build()
                                )
                                .addTool(
                                    AgentToolParam.Function.builder()
                                        .description("description")
                                        .name("name")
                                        .parameters(
                                            AgentToolParam.Function.Parameters.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .deferLoading(true)
                                        .build()
                                )
                                .build()
                        )
                        .agentId("agent_id")
                        .metadata(
                            AutomationTargetParam.NewSession.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addVaultId("string")
                        .build()
                )
                .metadata(
                    AutomationScheduleParam.Once.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val automationScheduleParam = AutomationScheduleParam.ofOnce(once)

        assertThat(automationScheduleParam.periodic()).isEmpty
        assertThat(automationScheduleParam.once()).contains(once)
    }

    @Test
    fun ofOnceRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationScheduleParam =
            AutomationScheduleParam.ofOnce(
                AutomationScheduleParam.Once.builder()
                    .name("x")
                    .runAt(0L)
                    .target(
                        AutomationTargetParam.NewSession.builder()
                            .environmentNone()
                            .addInput(
                                AgentSessionInputMessageParam.builder()
                                    .addInputTextContent("text")
                                    .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                    .build()
                            )
                            .agent(
                                AutomationTargetParam.NewSession.Agent.builder()
                                    .compaction(
                                        AutomationTargetParam.NewSession.Agent.Compaction.builder()
                                            .async(true)
                                            .build()
                                    )
                                    .experimental(
                                        AutomationTargetParam.NewSession.Agent.Experimental
                                            .builder()
                                            .timeAwareness(true)
                                            .build()
                                    )
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfigParam.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .reasoning(
                                        AgentReasoningParam.builder()
                                            .effort(AgentReasoningParam.Effort.NONE)
                                            .summary(AgentReasoningParam.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(
                                        AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO
                                    )
                                    .text(
                                        AgentTextParam.builder()
                                            .formatText()
                                            .verbosity(AgentTextParam.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentToolParam.Function.builder()
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentToolParam.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .deferLoading(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .agentId("agent_id")
                            .metadata(
                                AutomationTargetParam.NewSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addVaultId("string")
                            .build()
                    )
                    .metadata(
                        AutomationScheduleParam.Once.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedAutomationScheduleParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationScheduleParam),
                jacksonTypeRef<AutomationScheduleParam>(),
            )

        assertThat(roundtrippedAutomationScheduleParam).isEqualTo(automationScheduleParam)
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
        val automationScheduleParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AutomationScheduleParam>())

        val e = assertThrows<OpenAIInvalidDataException> { automationScheduleParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
