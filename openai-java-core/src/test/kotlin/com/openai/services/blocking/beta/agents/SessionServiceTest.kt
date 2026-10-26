// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.beta.agents.sessions.SessionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SessionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionService = client.beta().agents().sessions()

        val agentSession =
            sessionService.create(
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
                    .spendControl(SessionCreateParams.SpendControl.builder().limit(1L).build())
                    .addVaultId("string")
                    .build()
            )

        agentSession.validate()
    }

    // Streaming assertions and lifecycle remain in SDK-owned suite
    // com.openai.services.blocking.beta.agents.AgentSessionStreamingRegressionTest.
    // The callable reference is checked at compile time and never invoked here.
    private fun createStreamingContractCases() =
        listOf(
            com.openai.services.blocking.beta.agents.AgentSessionStreamingRegressionTest::
                createStreaming
        )

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionService = client.beta().agents().sessions()

        val agentSession = sessionService.retrieve("session_id")

        agentSession.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionService = client.beta().agents().sessions()

        val agentSession =
            sessionService.update(
                SessionUpdateParams.builder()
                    .sessionId("session_id")
                    .agent(
                        SessionUpdateParams.Agent.builder()
                            .model("model")
                            .reasoning(
                                SessionUpdateParams.Agent.Reasoning.builder()
                                    .effort(SessionUpdateParams.Agent.Reasoning.Effort.NONE)
                                    .build()
                            )
                            .serviceTier(SessionUpdateParams.Agent.ServiceTier.AUTO)
                            .build()
                    )
                    .metadata(
                        SessionUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .spendControl(SessionUpdateParams.SpendControl.builder().limit(1L).build())
                    .build()
            )

        agentSession.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionService = client.beta().agents().sessions()

        val page = sessionService.list()

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
        val sessionService = client.beta().agents().sessions()

        val agentSessionDeleted = sessionService.delete("session_id")

        agentSessionDeleted.validate()
    }
}
