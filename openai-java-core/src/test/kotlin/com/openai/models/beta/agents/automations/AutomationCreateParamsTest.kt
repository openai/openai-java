// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutomationCreateParamsTest {

    @Test
    fun create() {
        AutomationCreateParams.builder()
            .automationScheduleParam(
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
                                            .async(true)
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
            .build()
    }

    @Test
    fun body() {
        val params =
            AutomationCreateParams.builder()
                .automationScheduleParam(
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
                                            AutomationTargetParam.NewSession.Agent.Compaction
                                                .builder()
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
                                                .async(true)
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
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
                                            AutomationTargetParam.NewSession.Agent.Compaction
                                                .builder()
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
                                                .async(true)
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AutomationCreateParams.builder()
                .automationScheduleParam(
                    AutomationScheduleParam.Periodic.builder()
                        .expression("x")
                        .name("x")
                        .target(
                            AutomationTargetParam.NewSession.builder()
                                .environmentNone()
                                .addInput(
                                    AgentSessionInputMessageParam.builder()
                                        .addInputTextContent("text")
                                        .build()
                                )
                                .build()
                        )
                        .timezone("x")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
                                        .build()
                                )
                                .build()
                        )
                        .timezone("x")
                        .build()
                )
            )
    }
}
