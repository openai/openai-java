// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.openai.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentUpdateParamsTest {

    @Test
    fun create() {
        AgentUpdateParams.builder()
            .agentId("agent_id")
            .instructions("instructions")
            .metadata(
                AgentUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .model("model")
            .multiAgent(
                MultiAgentConfigParam.builder().enabled(true).maxConcurrentSubagents(1L).build()
            )
            .name("name")
            .reasoning(
                AgentReasoningParam.builder()
                    .effort(AgentReasoningParam.Effort.NONE)
                    .summary(AgentReasoningParam.Summary.CONCISE)
                    .build()
            )
            .serviceTier(AgentUpdateParams.ServiceTier.AUTO)
            .text(
                AgentTextParam.builder()
                    .formatText()
                    .verbosity(AgentTextParam.Verbosity.LOW)
                    .build()
            )
            .addTool(
                PersistedAgentToolParam.Function.builder()
                    .description("description")
                    .name("name")
                    .parameters(
                        PersistedAgentToolParam.Function.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .deferLoading(true)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = AgentUpdateParams.builder().agentId("agent_id").build()

        assertThat(params._pathParam(0)).isEqualTo("agent_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AgentUpdateParams.builder()
                .agentId("agent_id")
                .instructions("instructions")
                .metadata(
                    AgentUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .multiAgent(
                    MultiAgentConfigParam.builder().enabled(true).maxConcurrentSubagents(1L).build()
                )
                .name("name")
                .reasoning(
                    AgentReasoningParam.builder()
                        .effort(AgentReasoningParam.Effort.NONE)
                        .summary(AgentReasoningParam.Summary.CONCISE)
                        .build()
                )
                .serviceTier(AgentUpdateParams.ServiceTier.AUTO)
                .text(
                    AgentTextParam.builder()
                        .formatText()
                        .verbosity(AgentTextParam.Verbosity.LOW)
                        .build()
                )
                .addTool(
                    PersistedAgentToolParam.Function.builder()
                        .description("description")
                        .name("name")
                        .parameters(
                            PersistedAgentToolParam.Function.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .deferLoading(true)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata())
            .contains(
                AgentUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.model()).contains("model")
        assertThat(body.multiAgent())
            .contains(
                MultiAgentConfigParam.builder().enabled(true).maxConcurrentSubagents(1L).build()
            )
        assertThat(body.name()).contains("name")
        assertThat(body.reasoning())
            .contains(
                AgentReasoningParam.builder()
                    .effort(AgentReasoningParam.Effort.NONE)
                    .summary(AgentReasoningParam.Summary.CONCISE)
                    .build()
            )
        assertThat(body.serviceTier()).contains(AgentUpdateParams.ServiceTier.AUTO)
        assertThat(body.text())
            .contains(
                AgentTextParam.builder()
                    .formatText()
                    .verbosity(AgentTextParam.Verbosity.LOW)
                    .build()
            )
        assertThat(body.tools().getOrNull())
            .containsExactly(
                PersistedAgentToolParam.ofFunction(
                    PersistedAgentToolParam.Function.builder()
                        .description("description")
                        .name("name")
                        .parameters(
                            PersistedAgentToolParam.Function.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .deferLoading(true)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AgentUpdateParams.builder().agentId("agent_id").build()

        val body = params._body()
    }
}
