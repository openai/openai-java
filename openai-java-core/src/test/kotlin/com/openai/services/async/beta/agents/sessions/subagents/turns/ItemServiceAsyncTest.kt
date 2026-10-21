// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions.subagents.turns

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.sessions.subagents.turns.items.ItemListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ItemServiceAsyncTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val itemServiceAsync = client.beta().agents().sessions().subagents().turns().items()

        val pageFuture =
            itemServiceAsync.list(
                ItemListParams.builder()
                    .sessionId("session_id")
                    .subagentId("subagent_id")
                    .turnId("turn_id")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
