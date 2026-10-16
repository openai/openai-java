// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.AgentBrowserAuthenticationSubmitParam
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
                        AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                            .builder()
                            .requestId("request_id")
                            .response(
                                AgentBrowserAuthenticationSubmitParam.builder()
                                    .addField(
                                        AgentBrowserAuthenticationSubmitParam.Field.builder()
                                            .fieldId("field_id")
                                            .value("value")
                                            .build()
                                    )
                                    .selectedOption("selected_option")
                                    .build()
                            )
                            .build()
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
