// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.AgentSessionInputParam
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
                    .addEvent(
                        AgentSessionInputParam.AgentSessionInputMcpApprovalRequestResult.builder()
                            .requestId("request_id")
                            .response(
                                AgentSessionInputParam.AgentSessionInputMcpApprovalRequestResult
                                    .Response
                                    .builder()
                                    .decision(
                                        AgentSessionInputParam
                                            .AgentSessionInputMcpApprovalRequestResult
                                            .Response
                                            .Decision
                                            .APPROVE
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val response = future.get()
    }

    // Streaming assertions and lifecycle remain in SDK-owned suite
    // com.openai.services.async.beta.agents.sessions.AgentSessionEventStreamingRegressionTest.
    // The callable reference is checked at compile time and never invoked here.
    private fun streamStreamingContractCases() =
        listOf(
            com.openai.services.async.beta.agents.sessions
                .AgentSessionEventStreamingRegressionTest::streamStreaming
        )
}
