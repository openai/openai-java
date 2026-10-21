// SDK-owned streaming regression; generated service tests retain typed references.

package com.openai.services.async.beta.agents

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.services.agentsStreamFixture
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class AgentSessionStreamingRegressionTest {

    @Test
    fun createStreaming(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(post(urlPathEqualTo("/agents/sessions")).willReturn(agentsStreamFixture()))
        val deltas = ConcurrentLinkedQueue<String>()
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
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
                .subscribe { agentSession ->
                    agentSession.validate()
                    received.incrementAndGet()
                    deltas.add(agentSession.asTurnOutputTextDelta().delta())
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        assertThat(deltas).containsExactly("hello")
        check(received.get() > 0) { "Expected at least one streaming event" }
    }
}
