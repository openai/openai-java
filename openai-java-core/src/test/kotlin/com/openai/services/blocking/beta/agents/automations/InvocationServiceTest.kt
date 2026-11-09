// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.automations

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.agents.automations.invocations.InvocationRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InvocationServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val invocationService = client.beta().agents().automations().invocations()

        val automationInvocation = invocationService.create("automation_id")

        automationInvocation.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val invocationService = client.beta().agents().automations().invocations()

        val automationInvocation =
            invocationService.retrieve(
                InvocationRetrieveParams.builder()
                    .automationId("automation_id")
                    .invocationId("invocation_id")
                    .build()
            )

        automationInvocation.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val invocationService = client.beta().agents().automations().invocations()

        val page = invocationService.list("automation_id")

        page.response().validate()
    }
}
