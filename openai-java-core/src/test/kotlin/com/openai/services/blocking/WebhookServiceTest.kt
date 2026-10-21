// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.http.Headers
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import com.openai.models.webhooks.WebhookVerificationParams
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceTest {

    private val testPayload =
        """{"id": "evt_685c059ae3a481909bdc86819b066fb6", "object": "event", "created_at": 1750861210, "type": "response.completed", "data": {"id": "resp_123"}}"""

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
    fun unwrapWithoutSecretShouldThrow() {
        val client =
            OpenAIOkHttpClient.builder()
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookService = client.webhooks()

        val exception =
            assertThrows<IllegalStateException> {
                webhookService.unwrap(
                    WebhookVerificationParams.builder()
                        .payload(testPayload)
                        .headers(Headers.builder().build())
                        // No secret provided, should throw error
                        .build()
                )
            }

        assertTrue(exception.message!!.contains("The webhook secret must either be set"))
    }
}
