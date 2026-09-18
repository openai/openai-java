// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.http.Headers
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookEndpointWithSecretFuture =
            webhookServiceAsync.create(
                WebhookCreateParams.builder()
                    .addEventType(WebhookCreateParams.EventType.BATCH_COMPLETED)
                    .name("x")
                    .url("https://")
                    .build()
            )

        val webhookEndpointWithSecret = webhookEndpointWithSecretFuture.get()
        webhookEndpointWithSecret.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookEndpointFuture = webhookServiceAsync.retrieve("whe_123")

        val webhookEndpoint = webhookEndpointFuture.get()
        webhookEndpoint.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookEndpointFuture =
            webhookServiceAsync.update(
                WebhookUpdateParams.builder()
                    .webhookEndpointId("whe_123")
                    .addEventType(WebhookUpdateParams.EventType.BATCH_COMPLETED)
                    .name("x")
                    .url("https://")
                    .build()
            )

        val webhookEndpoint = webhookEndpointFuture.get()
        webhookEndpoint.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val pageFuture = webhookServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val deletedWebhookEndpointFuture = webhookServiceAsync.delete("whe_123")

        val deletedWebhookEndpoint = deletedWebhookEndpointFuture.get()
        deletedWebhookEndpoint.validate()
    }

    @Test
    fun rotateSecret() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookEndpointWithSecretFuture =
            webhookServiceAsync.rotateSecret(
                WebhookRotateSecretParams.builder()
                    .webhookEndpointId("whe_123")
                    .keepOldSecretActiveFor24Hours(true)
                    .build()
            )

        val webhookEndpointWithSecret = webhookEndpointWithSecretFuture.get()
        webhookEndpointWithSecret.validate()
    }

    @Test
    fun test() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookEndpointTestResultFuture =
            webhookServiceAsync.test(
                WebhookTestParams.builder()
                    .webhookEndpointId("whe_123")
                    .eventType(WebhookTestParams.EventType.BATCH_COMPLETED)
                    .build()
            )

        val webhookEndpointTestResult = webhookEndpointTestResultFuture.get()
        webhookEndpointTestResult.validate()
    }

    @Test
    fun unwrap() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val payload =
            "{\"id\":\"id\",\"created_at\":0,\"data\":{\"id\":\"id\"},\"type\":\"batch.cancelled\",\"object\":\"event\"}"
        val webhookSecret = "whsec_c2VjcmV0Cg=="
        val headers = Headers.builder().build()

        webhookServiceAsync.unwrap(payload).validate()
    }
}
