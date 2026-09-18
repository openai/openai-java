// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
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
internal class SessionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.beta().agents().sessions()

        val agentSessionFuture =
            sessionServiceAsync.create(
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
            )

        val agentSession = agentSessionFuture.get()
        agentSession.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.beta().agents().sessions()

        val agentSessionStreamResponse =
            sessionServiceAsync.createStreaming(
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
            )

        val onCompleteFuture =
            agentSessionStreamResponse
                .subscribe { agentSession -> agentSession.validate() }
                .onCompleteFuture()
        onCompleteFuture.get()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.beta().agents().sessions()

        val agentSessionFuture = sessionServiceAsync.retrieve("session_id")

        val agentSession = agentSessionFuture.get()
        agentSession.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.beta().agents().sessions()

        val agentSessionFuture =
            sessionServiceAsync.update(
                SessionUpdateParams.builder()
                    .sessionId("session_id")
                    .metadata(
                        SessionUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val agentSession = agentSessionFuture.get()
        agentSession.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.beta().agents().sessions()

        val pageFuture = sessionServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.beta().agents().sessions()

        val agentSessionDeletedFuture = sessionServiceAsync.delete("session_id")

        val agentSessionDeleted = agentSessionDeletedFuture.get()
        agentSessionDeleted.validate()
    }
}
