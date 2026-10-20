// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.openai.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentCreateParamsTest {

    @Test
    fun create() {
        AgentCreateParams.builder()
            .model("model")
            .instructions("instructions")
            .metadata(
                AgentCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
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
            .serviceTier(AgentCreateParams.ServiceTier.AUTO)
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
    fun body() {
        val params =
            AgentCreateParams.builder()
                .model("model")
                .instructions("instructions")
                .metadata(
                    AgentCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
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
                .serviceTier(AgentCreateParams.ServiceTier.AUTO)
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

        assertThat(body.model()).isEqualTo("model")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata())
            .contains(
                AgentCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
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
        assertThat(body.serviceTier()).contains(AgentCreateParams.ServiceTier.AUTO)
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
        val params = AgentCreateParams.builder().model("model").build()

        val body = params._body()

        assertThat(body.model()).isEqualTo("model")
    }
}
