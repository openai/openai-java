// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions.subagents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListParams
import com.openai.models.beta.agents.sessions.subagents.turns.TurnRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TurnServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val turnServiceAsync = client.beta().agents().sessions().subagents().turns()

        val turnFuture =
            turnServiceAsync.retrieve(
                TurnRetrieveParams.builder()
                    .sessionId("session_id")
                    .subagentId("subagent_id")
                    .turnId("turn_id")
                    .build()
            )

        val turn = turnFuture.get()
        turn.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val turnServiceAsync = client.beta().agents().sessions().subagents().turns()

        val pageFuture =
            turnServiceAsync.list(
                TurnListParams.builder().sessionId("session_id").subagentId("subagent_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
