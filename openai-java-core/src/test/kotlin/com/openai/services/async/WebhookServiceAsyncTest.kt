// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.http.Headers
import com.openai.errors.InvalidWebhookSignatureException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import com.openai.models.webhooks.WebhookVerificationParams
import java.nio.charset.StandardCharsets.UTF_8
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import java.util.Base64
import java.util.Optional
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
    fun unwrapAndVerifySignature() {
        val now = Instant.ofEpochSecond(1700000000)
        val client =
            OpenAIOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .clock(Clock.fixed(now, ZoneOffset.UTC))
                .build()
        try {
            val service = client.webhooks()
            val payload =
                "{\"id\":\"id\",\"created_at\":0,\"data\":{\"id\":\"id\"},\"object\":\"event\",\"type\":\"agent.environment.expired\"}"
            val secret = "whsec_c2VjcmV0Cg=="
            fun signature(body: String): String {
                val mac = Mac.getInstance("HmacSHA256")
                val key = Base64.getDecoder().decode(secret.removePrefix("whsec_"))
                mac.init(SecretKeySpec(key, "HmacSHA256"))
                val signed = "message-test.${now.epochSecond}.$body".toByteArray(UTF_8)
                return "v1," + Base64.getEncoder().encodeToString(mac.doFinal(signed))
            }
            fun headers(body: String): Headers =
                Headers.builder()
                    .put("webhook-id", "message-test")
                    .put("webhook-timestamp", now.epochSecond.toString())
                    .put("webhook-signature", signature(body))
                    .build()
            fun params(body: String, key: String = secret): WebhookVerificationParams =
                WebhookVerificationParams.builder()
                    .payload(body)
                    .headers(headers(body))
                    .secret(key)
                    .build()

            service.unwrap(params(payload)).validate()
            service.verifySignature(params(payload))
            val inherited =
                WebhookVerificationParams.builder()
                    .payload(payload)
                    .headers(headers(payload))
                    .build()
            service.withOptions { it.webhookSecret(secret) }.unwrap(inherited).validate()
            service.withOptions { it.webhookSecret(secret) }.verifySignature(inherited)
            service
                .withOptions { it.webhookSecret("wrong-client-secret") }
                .unwrap(params(payload))
                .validate()
            assertThrows<InvalidWebhookSignatureException> {
                service.unwrap(params(payload, "wrong-method-secret"))
            }
            assertThrows<InvalidWebhookSignatureException> {
                service.verifySignature(params(payload, "wrong-method-secret"))
            }
            assertThrows<IllegalArgumentException> {
                service.verifySignature(
                    WebhookVerificationParams.builder()
                        .payload(payload)
                        .headers(Headers.builder().build())
                        .secret(secret)
                        .build()
                )
            }
            assertThrows<OpenAIInvalidDataException> { service.unwrap(params("invalid JSON")) }
            assertThrows<InvalidWebhookSignatureException> {
                service.unwrap(
                    WebhookVerificationParams.builder()
                        .payload("invalid JSON")
                        .headers(headers(payload))
                        .secret(secret)
                        .build()
                )
            }
            val absent =
                WebhookVerificationParams.builder()
                    .payload(payload)
                    .headers(Headers.builder().build())
                    .build()
            val missingSecret =
                assertThrows<IllegalStateException> {
                    service
                        .withOptions { it.webhookSecret(Optional.empty()) }
                        .verifySignature(absent)
                }
            assertThat(missingSecret)
                .hasMessage(
                    "The webhook secret must either be set using the env var, OPENAI_WEBHOOK_SECRET, " +
                        "on the client class builder, .webhookSecret(...), or passed to this function"
                )
        } finally {
            client.close()
        }
    }

    @Test
    fun unwrapWithoutSecretShouldThrow() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .webhookSecret(Optional.empty())
                .build()
        try {
            val missingSecret =
                assertThrows<IllegalStateException> {
                    client
                        .webhooks()
                        .unwrap(
                            WebhookVerificationParams.builder()
                                .payload(
                                    "{\"id\":\"id\",\"created_at\":0,\"data\":{\"id\":\"id\"},\"object\":\"event\",\"type\":\"agent.environment.expired\"}"
                                )
                                .headers(Headers.builder().build())
                                .build()
                        )
                }
            assertThat(missingSecret)
                .hasMessage(
                    "The webhook secret must either be set using the env var, OPENAI_WEBHOOK_SECRET, " +
                        "on the client class builder, .webhookSecret(...), or passed to this function"
                )
        } finally {
            client.close()
        }
    }
}
