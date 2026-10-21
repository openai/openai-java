// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentCreateParams
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentUpdateParams
import com.openai.models.beta.agents.MultiAgentConfigParam
import com.openai.models.beta.agents.PersistedAgentToolParam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AgentServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentService = client.beta().agents()

        val agent =
            agentService.create(
                AgentCreateParams.builder()
                    .model("model")
                    .instructions("instructions")
                    .metadata(
                        AgentCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .multiAgent(
                        MultiAgentConfigParam.builder()
                            .enabled(true)
                            .maxConcurrentSubagents(1L)
                            .build()
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
            )

        agent.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentService = client.beta().agents()

        val agent = agentService.retrieve("agent_id")

        agent.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentService = client.beta().agents()

        val agent =
            agentService.update(
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
                        MultiAgentConfigParam.builder()
                            .enabled(true)
                            .maxConcurrentSubagents(1L)
                            .build()
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
            )

        agent.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentService = client.beta().agents()

        val page = agentService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentService = client.beta().agents()

        val agentDeleted = agentService.delete("agent_id")

        agentDeleted.validate()
    }
}
