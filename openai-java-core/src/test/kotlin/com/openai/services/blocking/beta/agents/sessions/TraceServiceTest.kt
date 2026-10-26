// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TraceServiceTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val traceService = client.beta().agents().sessions().traces()

        val page = traceService.list("session_id")

        page.response().validate()
    }
}
