// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val eventService = client.beta().agents().sessions().events()

        eventService.create(
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
    }

    @Test
    fun streamStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val eventService = client.beta().agents().sessions().events()

        val agentSessionEventStreamResponse = eventService.streamStreaming("session_id")

        agentSessionEventStreamResponse.use {
            agentSessionEventStreamResponse.stream().forEach { agentSessionEvent ->
                agentSessionEvent.validate()
            }
        }
    }
}
