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

internal class AutomationTargetTest {

    @Test
    fun ofNewSession() {
        val newSession =
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
                                .build()
                        )
                        .compaction(AutomationAgentConfig.Compaction.builder().async(true).build())
                        .experimental(
                            AutomationAgentConfig.Experimental.builder().timeAwareness(true).build()
                        )
                        .build()
                )
                .agentId("agent_id")
                .environmentNone()
                .addInput(
                    AutomationTarget.NewSession.Input.builder().addInputTextContent("text").build()
                )
                .metadata(
                    AutomationTarget.NewSession.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addVaultId("string")
                .build()

        val automationTarget = AutomationTarget.ofNewSession(newSession)

        assertThat(automationTarget.newSession()).contains(newSession)
        assertThat(automationTarget.existingSession()).isEmpty
    }

    @Test
    fun ofNewSessionRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationTarget =
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

        val roundtrippedAutomationTarget =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationTarget),
                jacksonTypeRef<AutomationTarget>(),
            )

        assertThat(roundtrippedAutomationTarget).isEqualTo(automationTarget)
    }

    @Test
    fun ofExistingSession() {
        val existingSession =
            AutomationTarget.ExistingSession.builder()
                .instructions("instructions")
                .sessionId("session_id")
                .build()

        val automationTarget = AutomationTarget.ofExistingSession(existingSession)

        assertThat(automationTarget.newSession()).isEmpty
        assertThat(automationTarget.existingSession()).contains(existingSession)
    }

    @Test
    fun ofExistingSessionRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationTarget =
            AutomationTarget.ofExistingSession(
                AutomationTarget.ExistingSession.builder()
                    .instructions("instructions")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedAutomationTarget =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationTarget),
                jacksonTypeRef<AutomationTarget>(),
            )

        assertThat(roundtrippedAutomationTarget).isEqualTo(automationTarget)
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
        val automationTarget =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AutomationTarget>())

        val e = assertThrows<OpenAIInvalidDataException> { automationTarget.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
