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

internal class AutomationUpdateParamsTest {

    @Test
    fun create() {
        AutomationUpdateParams.builder()
            .automationId("automation_id")
            .expression("x")
            .metadata(
                AutomationUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
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
            .timezone("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params = AutomationUpdateParams.builder().automationId("automation_id").build()

        assertThat(params._pathParam(0)).isEqualTo("automation_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AutomationUpdateParams.builder()
                .automationId("automation_id")
                .expression("x")
                .metadata(
                    AutomationUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
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
                .timezone("x")
                .build()

        val body = params._body()

        assertThat(body.expression()).contains("x")
        assertThat(body.metadata())
            .contains(
                AutomationUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.name()).contains("x")
        assertThat(body.runAt()).contains(0L)
        assertThat(body.target())
            .contains(
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
            )
        assertThat(body.timezone()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AutomationUpdateParams.builder().automationId("automation_id").build()

        val body = params._body()
    }
}
