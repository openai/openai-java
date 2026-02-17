// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.http.Headers
import com.openai.errors.InvalidWebhookSignatureException
import com.openai.models.webhooks.WebhookVerificationParams
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceTest {

    // Standardized test data (matches TypeScript implementation)
    private val testPayload =
        """{"id": "evt_685c059ae3a481909bdc86819b066fb6", "object": "event", "created_at": 1750861210, "type": "response.completed", "data": {"id": "resp_123"}}"""
    private val testSecret = "whsec_RdvaYFYUXuIFuEbvZHwMfYFhUf7aMYjYcmM24+Aj40c="

    // Use a fixed timestamp for consistent testing (matches the created_at in payload)
    private val fixedTimestamp = "1750861210"
    private val webhookId = "wh_685c059ae39c8190af8c71ed1022a24d"

    // Pre-computed valid signatures for consistent testing
    private val validSignatureForSecret = "v1,gUAg4R2hWouRZqRQG4uJypNS8YK885G838+EHb4nKBY="

    // Fixed clock for deterministic testing
    private val fixedClock =
        Clock.fixed(Instant.ofEpochSecond(fixedTimestamp.toLong()), ZoneOffset.UTC)

    private fun createClientWithFixedClock(): OpenAIClient {
        return OpenAIOkHttpClient.builder()
            .baseUrl(TestServerExtension.BASE_URL)
            .apiKey("My API Key")
            .clock(fixedClock)
            .build()
    }

    @Test
    fun unwrapWithValidSignatureAndSecret() {
        val client = createClientWithFixedClock()
        val webhookService = client.webhooks()

        val headers =
            Headers.builder()
                .put("webhook-signature", validSignatureForSecret)
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        val event =
            webhookService
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
        val client = OpenAIOkHttpClient.builder().apiKey("My API Key").build()
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

    @Test
    fun verifySignatureWithInvalidSecret() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val headers =
            Headers.builder()
                .put("webhook-signature", "v1,invalid_signature")
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        assertThrows<InvalidWebhookSignatureException> {
            webhookService.verifySignature(
                WebhookVerificationParams.builder()
                    .payload(testPayload)
                    .headers(headers)
                    .secret("invalid_secret")
                    .build()
            )
        }
    }

    @Test
    fun verifySignatureWithOldTimestamp() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        // Use a timestamp that's older than 5 minutes (300 seconds)
        val oldTimestamp = (1643723400 - 400).toString()
        val headers =
            Headers.builder()
                .put("webhook-signature", "v1,signature")
                .put("webhook-timestamp", oldTimestamp)
                .put("webhook-id", webhookId)
                .build()

        assertThrows<InvalidWebhookSignatureException> {
            webhookService.verifySignature(
                WebhookVerificationParams.builder()
                    .payload(testPayload)
                    .headers(headers)
                    .secret(testSecret)
                    .build()
            )
        }
    }

    @Test
    fun verifySignatureWithInvalidTimestampFormat() {
        val client = createClientWithFixedClock()
        val webhookService = client.webhooks()

        val headers =
            Headers.builder()
                .put("webhook-signature", "v1,invalid_signature")
                .put("webhook-timestamp", "not_a_number")
                .put("webhook-id", webhookId)
                .build()

        assertThrows<InvalidWebhookSignatureException> {
            webhookService.verifySignature(
                WebhookVerificationParams.builder()
                    .payload(testPayload)
                    .headers(headers)
                    .secret(testSecret)
                    .build()
            )
        }
    }

    @Test
    fun verifySignatureWithValidSignature() {
        val client = createClientWithFixedClock()
        val webhookService = client.webhooks()

        val headers =
            Headers.builder()
                .put("webhook-signature", validSignatureForSecret)
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        // Should not throw any exception when using correct signature
        webhookService.verifySignature(
            WebhookVerificationParams.builder()
                .payload(testPayload)
                .headers(headers)
                .secret(testSecret)
                .build()
        )
    }

    @Test
    fun verifySignatureWithCustomTolerance() {
        val client = createClientWithFixedClock()
        val webhookService = client.webhooks()

        // Use a timestamp that's very old (should fail with default tolerance)
        val oldTimestamp = (1750861210 - 400).toString() // 400 seconds before our payload timestamp

        val headers =
            Headers.builder()
                .put(
                    "webhook-signature",
                    validSignatureForSecret,
                ) // This won't match old timestamp but we're testing time validation
                .put("webhook-timestamp", oldTimestamp)
                .put("webhook-id", webhookId)
                .build()

        // Should fail due to old timestamp
        assertThrows<InvalidWebhookSignatureException> {
            webhookService.verifySignature(
                WebhookVerificationParams.builder()
                    .payload(testPayload)
                    .headers(headers)
                    .secret(testSecret)
                    .tolerance(Duration.ofMinutes(5))
                    .build()
            )
        }
    }

    @Test
    fun verifySignatureWithMultipleSignatures() {
        val client = createClientWithFixedClock()
        val webhookService = client.webhooks()

        // Create a signature header with multiple signatures: one valid, one invalid
        val multipleSignatures = "v1,invalid_signature $validSignatureForSecret"
        val headers =
            Headers.builder()
                .put("webhook-signature", multipleSignatures)
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        // Should not throw any exception when at least one signature is correct
        webhookService.verifySignature(
            WebhookVerificationParams.builder()
                .payload(testPayload)
                .headers(headers)
                .secret(testSecret)
                .build()
        )
    }

    @Test
    fun verifySignatureWithAllInvalidMultipleSignatures() {
        val client = createClientWithFixedClock()
        val webhookService = client.webhooks()

        // Create a signature header with multiple invalid signatures
        val multipleInvalidSignatures = "v1,invalid_signature1 v1,invalid_signature2"
        val headers =
            Headers.builder()
                .put("webhook-signature", multipleInvalidSignatures)
                .put("webhook-timestamp", fixedTimestamp)
                .put("webhook-id", webhookId)
                .build()

        // Should throw exception when all signatures are invalid
        assertThrows<InvalidWebhookSignatureException> {
            webhookService.verifySignature(
                WebhookVerificationParams.builder()
                    .payload(testPayload)
                    .headers(headers)
                    .secret(testSecret)
                    .build()
            )
        }
    }
}
