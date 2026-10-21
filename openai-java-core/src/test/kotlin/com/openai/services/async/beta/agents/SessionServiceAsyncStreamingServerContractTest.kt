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
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SessionServiceAsyncStreamingServerContractTest {

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
                    .spendControl(SessionCreateParams.SpendControl.builder().limit(1L).build())
                    .addVaultId("string")
                    .build()
            )

        val received = java.util.concurrent.atomic.AtomicInteger()
        val onCompleteFuture =
            agentSessionStreamResponse
                .subscribe { event ->
                    event.validate()
                    received.incrementAndGet()
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        check(received.get() > 0) { "Expected at least one streaming event" }
    }
}
