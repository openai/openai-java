// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions

import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.EnvironmentParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCreateParamsTest {

    @Test
    fun create() {
        SessionCreateParams.builder()
            .environmentNone()
            .agent(
                SessionCreateParams.Agent.builder()
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
                    .serviceTier(SessionCreateParams.Agent.ServiceTier.AUTO)
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
            .input("string")
            .metadata(
                SessionCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .addVaultId("string")
            .build()
    }

    @Test
    fun body() {
        val params =
            SessionCreateParams.builder()
                .environmentNone()
                .agent(
                    SessionCreateParams.Agent.builder()
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
                        .serviceTier(SessionCreateParams.Agent.ServiceTier.AUTO)
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
                .input("string")
                .metadata(
                    SessionCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addVaultId("string")
                .build()

        val body = params._body()

        assertThat(body.environment()).isEqualTo(EnvironmentParam.ofNone())
        assertThat(body.agent())
            .contains(
                SessionCreateParams.Agent.builder()
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
                    .serviceTier(SessionCreateParams.Agent.ServiceTier.AUTO)
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
        assertThat(body.agentId()).contains("agent_id")
        assertThat(body.input()).contains(SessionCreateParams.Input.ofString("string"))
        assertThat(body.metadata())
            .contains(
                SessionCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.vaultIds().getOrNull()).containsExactly("string")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SessionCreateParams.builder().environmentNone().build()

        val body = params._body()

        assertThat(body.environment()).isEqualTo(EnvironmentParam.ofNone())
    }
}
