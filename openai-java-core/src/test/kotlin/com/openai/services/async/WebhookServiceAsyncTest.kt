// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.http.Headers
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
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
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
}
