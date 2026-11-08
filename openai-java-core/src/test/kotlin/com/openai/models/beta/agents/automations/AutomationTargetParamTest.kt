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

internal class AutomationTargetParamTest {

    @Test
    fun ofNewSession() {
        val newSession =
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
                        .serviceTier(AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO)
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

        val automationTargetParam = AutomationTargetParam.ofNewSession(newSession)

        assertThat(automationTargetParam.newSession()).contains(newSession)
        assertThat(automationTargetParam.existingSession()).isEmpty
    }

    @Test
    fun ofNewSessionRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationTargetParam =
            AutomationTargetParam.ofNewSession(
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
                            .serviceTier(AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO)
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

        val roundtrippedAutomationTargetParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationTargetParam),
                jacksonTypeRef<AutomationTargetParam>(),
            )

        assertThat(roundtrippedAutomationTargetParam).isEqualTo(automationTargetParam)
    }

    @Test
    fun ofExistingSession() {
        val existingSession =
            AutomationTargetParam.ExistingSession.builder()
                .instructions("instructions")
                .sessionId("session_id")
                .build()

        val automationTargetParam = AutomationTargetParam.ofExistingSession(existingSession)

        assertThat(automationTargetParam.newSession()).isEmpty
        assertThat(automationTargetParam.existingSession()).contains(existingSession)
    }

    @Test
    fun ofExistingSessionRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationTargetParam =
            AutomationTargetParam.ofExistingSession(
                AutomationTargetParam.ExistingSession.builder()
                    .instructions("instructions")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedAutomationTargetParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationTargetParam),
                jacksonTypeRef<AutomationTargetParam>(),
            )

        assertThat(roundtrippedAutomationTargetParam).isEqualTo(automationTargetParam)
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
        val automationTargetParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AutomationTargetParam>())

        val e = assertThrows<OpenAIInvalidDataException> { automationTargetParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
