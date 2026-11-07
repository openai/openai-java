// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.automations

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.automations.invocations.InvocationRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InvocationServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val invocationServiceAsync = client.beta().agents().automations().invocations()

        val automationInvocationFuture = invocationServiceAsync.create("automation_id")

        val automationInvocation = automationInvocationFuture.get()
        automationInvocation.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val invocationServiceAsync = client.beta().agents().automations().invocations()

        val automationInvocationFuture =
            invocationServiceAsync.retrieve(
                InvocationRetrieveParams.builder()
                    .automationId("automation_id")
                    .invocationId("invocation_id")
                    .build()
            )

        val automationInvocation = automationInvocationFuture.get()
        automationInvocation.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val invocationServiceAsync = client.beta().agents().automations().invocations()

        val pageFuture = invocationServiceAsync.list("automation_id")

        val page = pageFuture.get()
        page.response().validate()
    }
}
