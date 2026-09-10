// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
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
    fun streamStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val eventServiceAsync = client.beta().agents().sessions().events()

        val agentSessionEventStreamResponse = eventServiceAsync.streamStreaming("session_id")

        val onCompleteFuture =
            agentSessionEventStreamResponse
                .subscribe { agentSessionEvent -> agentSessionEvent.validate() }
                .onCompleteFuture()
        onCompleteFuture.get()
    }
}
