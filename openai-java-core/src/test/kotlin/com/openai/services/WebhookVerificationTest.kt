package com.openai.services

import com.openai.client.OpenAIClientAsyncImpl
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.errors.InvalidWebhookSignatureException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookVerificationParams
import java.nio.charset.StandardCharsets.UTF_8
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.Base64
import java.util.Optional
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.Mockito.mock

internal class WebhookVerificationTest {

    @ParameterizedTest
    @EnumSource(ServiceMode::class)
    fun usesClientSecretAndPerCallOverride(mode: ServiceMode) = withOptions { options ->
        mode.verify(options, params())
        mode.verify(
            options,
            params(secret = "per-call-test-secret", signingSecret = "per-call-test-secret"),
        )

        val error =
            assertThrows<InvalidWebhookSignatureException> {
                mode.verify(options, params(secret = "wrong-test-secret"))
            }
        assertThat(error).hasMessage(SIGNATURE_MISMATCH)
    }

    @ParameterizedTest
    @EnumSource(ServiceMode::class)
    fun acceptsInclusiveToleranceAndRejectsOutsideIt(mode: ServiceMode) = withOptions { options ->
        for (offset in listOf(-300L, 300L)) {
            mode.verify(options, params(timestamp = NOW + offset))
        }
        for ((offset, message) in
            listOf(
                -301L to "Webhook timestamp is too old",
                301L to "Webhook timestamp is too new",
            )) {
            val error =
                assertThrows<InvalidWebhookSignatureException> {
                    mode.verify(options, params(timestamp = NOW + offset))
                }
            assertThat(error).hasMessage(message)
        }
        mode.verify(options, params(timestamp = NOW - 400, tolerance = Duration.ofSeconds(400)))
    }

    @ParameterizedTest
    @EnumSource(ServiceMode::class)
    fun preservesRequiredHeaderAndTimestampErrors(mode: ServiceMode) {
        withOptions(secret = null) { options ->
            val error =
                assertThrows<IllegalStateException> {
                    mode.verify(options, params(headers = Headers.builder().build()))
                }
            assertThat(error)
                .hasMessage(
                    "The webhook secret must either be set using the env var, OPENAI_WEBHOOK_SECRET, " +
                        "on the client class builder, .webhookSecret(...), or passed to this function"
                )
        }
        withOptions { options ->
            val headers = Headers.builder()
            for (name in listOf("webhook-signature", "webhook-timestamp", "webhook-id")) {
                val error =
                    assertThrows<IllegalArgumentException> {
                        mode.verify(options, params(headers = headers.build()))
                    }
                assertThat(error).hasMessage("Missing required $name header")
                headers.put(name, if (name == "webhook-timestamp") "not-a-timestamp" else "test")
            }
            val error =
                assertThrows<InvalidWebhookSignatureException> {
                    mode.verify(options, params(headers = headers.build()))
                }
            assertThat(error)
                .hasMessage("Invalid webhook timestamp format")
                .hasCauseInstanceOf(NumberFormatException::class.java)
        }
    }

    @ParameterizedTest
    @EnumSource(ServiceMode::class)
    fun acceptsRawAndEncodedSecretsAndAnyMatchingSignature(mode: ServiceMode) =
        withOptions { options ->
            val encodedSecret =
                "whsec_" + Base64.getEncoder().encodeToString(CLIENT_SECRET.toByteArray(UTF_8))
            mode.verify(options, params(secret = encodedSecret))
            mode.verify(
                options,
                params(
                    signature =
                        "v1,invalid-test-signature \t ${signature(PAYLOAD, NOW, CLIENT_SECRET)}"
                ),
            )
            val error =
                assertThrows<InvalidWebhookSignatureException> {
                    mode.verify(options, params(signature = "v1,invalid-one v1,invalid-two"))
                }
            assertThat(error).hasMessage(SIGNATURE_MISMATCH)
        }

    @ParameterizedTest
    @EnumSource(ServiceMode::class)
    fun unwrapVerifiesBeforeParsing(mode: ServiceMode) = withOptions { options ->
        assertThat(mode.unwrap(options, params()).isResponseCompleted()).isTrue()
        val signatureError =
            assertThrows<InvalidWebhookSignatureException> {
                mode.unwrap(options, params(payload = "not-json", signature = "v1,invalid"))
            }
        assertThat(signatureError).hasMessage(SIGNATURE_MISMATCH)
        val parseError =
            assertThrows<OpenAIInvalidDataException> {
                mode.unwrap(options, params(payload = "not-json"))
            }
        assertThat(parseError)
            .hasMessage("Error parsing body")
            .hasCauseInstanceOf(Exception::class.java)
    }

    @ParameterizedTest
    @EnumSource(ServiceMode::class)
    fun withOptionsUsesUpdatedClock(mode: ServiceMode) = withOptions { options ->
        val error =
            assertThrows<InvalidWebhookSignatureException> {
                val laterClock = Clock.fixed(Instant.ofEpochSecond(NOW + 301), ZoneOffset.UTC)
                when (mode) {
                    ServiceMode.BLOCKING ->
                        OpenAIClientImpl(options)
                            .webhooks()
                            .withOptions { it.clock(laterClock) }
                            .verifySignature(params())
                    ServiceMode.ASYNC ->
                        OpenAIClientAsyncImpl(options)
                            .webhooks()
                            .withOptions { it.clock(laterClock) }
                            .verifySignature(params())
                }
            }
        assertThat(error).hasMessage("Webhook timestamp is too old")
    }

    enum class ServiceMode {
        BLOCKING,
        ASYNC;

        fun verify(options: ClientOptions, params: WebhookVerificationParams) {
            when (this) {
                BLOCKING -> OpenAIClientImpl(options).webhooks().verifySignature(params)
                ASYNC -> OpenAIClientAsyncImpl(options).webhooks().verifySignature(params)
            }
        }

        fun unwrap(options: ClientOptions, params: WebhookVerificationParams): UnwrapWebhookEvent =
            when (this) {
                BLOCKING -> OpenAIClientImpl(options).webhooks().unwrap(params)
                ASYNC -> OpenAIClientAsyncImpl(options).webhooks().unwrap(params)
            }
    }

    private fun withOptions(secret: String? = CLIENT_SECRET, block: (ClientOptions) -> Unit) {
        val options =
            ClientOptions.builder()
                .httpClient(mock(HttpClient::class.java))
                .apiKey("test-api-key")
                .webhookSecret(secret)
                .clock(Clock.fixed(Instant.ofEpochSecond(NOW), ZoneOffset.UTC))
                .build()
        try {
            block(options)
        } finally {
            options.close()
        }
    }

    private fun params(
        payload: String = PAYLOAD,
        timestamp: Long = NOW,
        secret: String? = null,
        signingSecret: String = CLIENT_SECRET,
        signature: String = signature(payload, timestamp, signingSecret),
        headers: Headers =
            Headers.builder()
                .put("webhook-signature", signature)
                .put("webhook-timestamp", timestamp.toString())
                .put("webhook-id", WEBHOOK_ID)
                .build(),
        tolerance: Duration = Duration.ofMinutes(5),
    ): WebhookVerificationParams =
        WebhookVerificationParams.builder()
            .payload(payload)
            .headers(headers)
            .secret(Optional.ofNullable(secret))
            .tolerance(tolerance)
            .build()

    private fun signature(payload: String, timestamp: Long, secret: String): String {
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(SecretKeySpec(secret.toByteArray(UTF_8), "HmacSHA256"))
        return "v1," +
            Base64.getEncoder()
                .encodeToString(mac.doFinal("$WEBHOOK_ID.$timestamp.$payload".toByteArray(UTF_8)))
    }

    companion object {
        private const val NOW = 1_750_861_210L
        private const val CLIENT_SECRET = "synthetic-client-secret"
        private const val WEBHOOK_ID = "webhook_test"
        private const val PAYLOAD =
            """{"id":"evt_test","object":"event","created_at":1750861210,"type":"response.completed","data":{"id":"resp_test"}}"""
        private const val SIGNATURE_MISMATCH =
            "The given webhook signature does not match the expected signature"
    }
}
