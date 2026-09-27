// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.http.Headers
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import com.openai.models.webhooks.WebhookVerificationParams
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceAsyncTest {

    private val testPayload =
        """{"id": "evt_685c059ae3a481909bdc86819b066fb6", "object": "event", "created_at": 1750861210, "type": "response.completed", "data": {"id": "resp_123"}}"""
    private val testSecret = "whsec_RdvaYFYUXuIFuEbvZHwMfYFhUf7aMYjYcmM24+Aj40c="
    private val fixedTimestamp = "1750861210"
    private val webhookId = "wh_685c059ae39c8190af8c71ed1022a24d"
    private val validSignatureForSecret = "v1,gUAg4R2hWouRZqRQG4uJypNS8YK885G838+EHb4nKBY="
    private val fixedClock =
        Clock.fixed(Instant.ofEpochSecond(fixedTimestamp.toLong()), ZoneOffset.UTC)

    @Test
    fun unwrapWithValidSignatureAndSecret() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .clock(fixedClock)
                .build()
        val webhookServiceAsync = client.webhooks()

        val headers =
            Headers.builder()
                .put("webhook-signature", validSignatureForSecret)
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        val event =
            webhookServiceAsync
                .unwrap(
                    WebhookVerificationParams.builder()
                        .payload(testPayload)
                        .headers(headers)
                        .secret(testSecret)
                        .build()
                )
                .validate()

        assertTrue(event.isResponseCompleted())
    }

    @Test
    fun unwrapWithoutSecretShouldThrow() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val headers =
            Headers.builder()
                .put("webhook-signature", validSignatureForSecret)
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        assertThrows<IllegalStateException> {
            webhookServiceAsync.unwrap(
                WebhookVerificationParams.builder().payload(testPayload).headers(headers).build()
            )
        }
    }

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
}
