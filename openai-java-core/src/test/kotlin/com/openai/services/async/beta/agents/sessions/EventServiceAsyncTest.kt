// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.services.agentsStreamFixture
import java.util.concurrent.ConcurrentLinkedQueue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class EventServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val eventServiceAsync = client.beta().agents().sessions().events()

        val future =
            eventServiceAsync.create(
                EventCreateParams.builder()
                    .sessionId("session_id")
                    .idempotencyKey("x")
                    .addAgentSessionInputMessageEvent(
                        listOf(
                            AgentSessionInputMessageParam.builder()
                                .addInputTextContent("text")
                                .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                .build()
                        )
                    )
                    .build()
            )

        val response = future.get()
    }

    @Test
    fun streamStreaming(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            get(urlPathEqualTo("/agents/sessions/session_id/events"))
                .willReturn(agentsStreamFixture())
        )
        val deltas = ConcurrentLinkedQueue<String>()
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val eventServiceAsync = client.beta().agents().sessions().events()

        val agentSessionEventStreamResponse = eventServiceAsync.streamStreaming("session_id")

        val onCompleteFuture =
            agentSessionEventStreamResponse
                .subscribe { agentSessionEvent ->
                    agentSessionEvent.validate()
                    deltas.add(agentSessionEvent.asTurnOutputTextDelta().delta())
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        assertThat(deltas).containsExactly("hello")
    }
}
