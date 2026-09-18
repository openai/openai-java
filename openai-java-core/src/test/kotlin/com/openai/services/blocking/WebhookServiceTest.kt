// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.http.Headers
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val webhookEndpointWithSecret =
            webhookService.create(
                WebhookCreateParams.builder()
                    .addEventType(WebhookCreateParams.EventType.BATCH_COMPLETED)
                    .name("x")
                    .url("https://")
                    .build()
            )

        webhookEndpointWithSecret.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val webhookEndpoint = webhookService.retrieve("whe_123")

        webhookEndpoint.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val webhookEndpoint =
            webhookService.update(
                WebhookUpdateParams.builder()
                    .webhookEndpointId("whe_123")
                    .addEventType(WebhookUpdateParams.EventType.BATCH_COMPLETED)
                    .name("x")
                    .url("https://")
                    .build()
            )

        webhookEndpoint.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val page = webhookService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val deletedWebhookEndpoint = webhookService.delete("whe_123")

        deletedWebhookEndpoint.validate()
    }

    @Test
    fun rotateSecret() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val webhookEndpointWithSecret =
            webhookService.rotateSecret(
                WebhookRotateSecretParams.builder()
                    .webhookEndpointId("whe_123")
                    .keepOldSecretActiveFor24Hours(true)
                    .build()
            )

        webhookEndpointWithSecret.validate()
    }

    @Test
    fun test() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val webhookEndpointTestResult =
            webhookService.test(
                WebhookTestParams.builder()
                    .webhookEndpointId("whe_123")
                    .eventType(WebhookTestParams.EventType.BATCH_COMPLETED)
                    .build()
            )

        webhookEndpointTestResult.validate()
    }

    @Test
    fun unwrap() {
        val client =
            OpenAIOkHttpClient.builder()
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val payload =
            "{\"id\":\"id\",\"created_at\":0,\"data\":{\"id\":\"id\"},\"type\":\"batch.cancelled\",\"object\":\"event\"}"
        val webhookSecret = "whsec_c2VjcmV0Cg=="
        val headers = Headers.builder().build()

        webhookService.unwrap(payload).validate()
    }
}
