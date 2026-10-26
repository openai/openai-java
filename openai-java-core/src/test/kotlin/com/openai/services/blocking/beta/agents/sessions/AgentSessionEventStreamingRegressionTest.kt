// SDK-owned streaming regression; generated service tests retain typed references.

package com.openai.services.blocking.beta.agents.sessions

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.services.agentsStreamFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class AgentSessionEventStreamingRegressionTest {

    @Test
    fun streamStreaming(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            get(urlPathEqualTo("/agents/sessions/session_id/events"))
                .willReturn(agentsStreamFixture())
        )
        val deltas = mutableListOf<String>()
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val eventService = client.beta().agents().sessions().events()

        val agentSessionEventStreamResponse = eventService.streamStreaming("session_id")

        var received = 0
        agentSessionEventStreamResponse.use {
            agentSessionEventStreamResponse.stream().forEach { agentSessionEvent ->
                agentSessionEvent.validate()
                received++
                deltas.add(agentSessionEvent.asTurnOutputTextDelta().delta())
            }
        }
        assertThat(deltas).containsExactly("hello")
        check(received > 0) { "Expected at least one streaming event" }
    }
}
