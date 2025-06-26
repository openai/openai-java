// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.ClientOptions
import com.openai.errors.InvalidWebhookSignatureException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookVerificationParams
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.time.Instant
import java.util.Base64
import java.util.function.Consumer
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class WebhookServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookService {

    private val withRawResponse: WebhookService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WebhookService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService =
        WebhookServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Validates that the given payload was sent by OpenAI and parses the payload.
     *
     * @param params Verification parameters including payload, headers, secret and tolerance
     * @return The parsed webhook event
     * @throws IllegalArgumentException if the signature is invalid or headers are missing
     */
    override fun unwrap(params: WebhookVerificationParams): UnwrapWebhookEvent {
        verifySignature(params)

        val bodyString = String(params.payload, StandardCharsets.UTF_8)
        return try {
            clientOptions.jsonMapper.readValue(bodyString, jacksonTypeRef<UnwrapWebhookEvent>())
        } catch (e: Exception) {
            throw OpenAIInvalidDataException("Error parsing body", e)
        }
    }

    /**
     * Validates whether or not the webhook payload was sent by OpenAI.
     *
     * @param params Verification parameters including payload, headers, secret and tolerance
     * @throws IllegalArgumentException if the signature is invalid
     */
    override fun verifySignature(params: WebhookVerificationParams) {
        val webhookSecret =
            params.secret.orElse(null)
                ?: clientOptions.webhookSecret().orElse(null)
                ?: throw IllegalStateException(
                    "The webhook secret must either be set using the env var, OPENAI_WEBHOOK_SECRET, " +
                        "on the client class builder, .webhookSecret(...), or passed to this function"
                )

        // Extract required headers
        val signatureHeader =
            params.headers.values("webhook-signature").firstOrNull()
                ?: throw IllegalArgumentException("Missing required webhook-signature header")

        val timestampHeader =
            params.headers.values("webhook-timestamp").firstOrNull()
                ?: throw IllegalArgumentException("Missing required webhook-timestamp header")

        val webhookId =
            params.headers.values("webhook-id").firstOrNull()
                ?: throw IllegalArgumentException("Missing required webhook-id header")

        // Validate timestamp to prevent replay attacks
        val timestampSeconds =
            try {
                timestampHeader.toLong()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("Invalid webhook timestamp format", e)
            }

        val now = Instant.now(clientOptions.clock)
        val timestampInstant = Instant.ofEpochSecond(timestampSeconds)
        val toleranceDuration = params.tolerance

        if (timestampInstant.isBefore(now.minus(toleranceDuration))) {
            throw InvalidWebhookSignatureException("Webhook timestamp is too old")
        }

        if (timestampInstant.isAfter(now.plus(toleranceDuration))) {
            throw InvalidWebhookSignatureException("Webhook timestamp is too new")
        }

        // The signature header can have multiple values, separated by spaces.
        val signatures = signatureHeader.split(" ").map { it.removePrefix("v1,") }

        // Decode the secret if it starts with whsec_
        val decodedSecret =
            if (webhookSecret.startsWith("whsec_")) {
                Base64.getDecoder().decode(webhookSecret.substring(6))
            } else {
                webhookSecret.toByteArray(StandardCharsets.UTF_8)
            }

        // Create the signed payload: {webhook_id}.{timestamp}.{payload}
        val bodyString = String(params.payload, StandardCharsets.UTF_8)
        val signedPayload = "$webhookId.$timestampHeader.$bodyString"

        // Compute HMAC-SHA256 signature
        val mac = Mac.getInstance("HmacSHA256")
        val secretKey = SecretKeySpec(decodedSecret, "HmacSHA256")
        mac.init(secretKey)
        val expectedSignatureBytes = mac.doFinal(signedPayload.toByteArray(StandardCharsets.UTF_8))
        val expectedSignature = Base64.getEncoder().encodeToString(expectedSignatureBytes)

        // Accept if any signature matches using timing-safe comparison
        val signatureMatches =
            signatures.any { signature ->
                MessageDigest.isEqual(expectedSignature.toByteArray(), signature.toByteArray())
            }

        if (!signatureMatches) {
            throw InvalidWebhookSignatureException(
                "The given webhook signature does not match the expected signature"
            )
        }
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WebhookService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookService.WithRawResponse =
            WebhookServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
