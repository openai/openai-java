// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.ClientOptions
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookVerificationParams
import com.openai.services.verifyWebhookSignature
import java.nio.charset.StandardCharsets
import java.util.function.Consumer

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
    override fun verifySignature(params: WebhookVerificationParams) =
        verifyWebhookSignature(clientOptions, params)

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
