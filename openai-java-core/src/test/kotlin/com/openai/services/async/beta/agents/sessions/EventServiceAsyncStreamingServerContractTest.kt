// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceAsyncStreamingServerContractTest {

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

        val received = java.util.concurrent.atomic.AtomicInteger()
        val onCompleteFuture =
            agentSessionEventStreamResponse
                .subscribe { event ->
                    event.validate()
                    received.incrementAndGet()
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        check(received.get() > 0) { "Expected at least one streaming event" }
    }
}
