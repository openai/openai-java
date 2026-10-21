// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceStreamingServerContractTest {

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

        var received = 0
        agentSessionEventStreamResponse.use {
            agentSessionEventStreamResponse.stream().forEach { event ->
                event.validate()
                received++
            }
        }
        check(received > 0) { "Expected at least one streaming event" }
    }
}
