// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookVerificationParams
import java.util.function.Consumer

interface WebhookService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService

    /**
     * Validates that the given payload was sent by OpenAI and parses the payload.
     *
     * @param params Verification parameters including payload, headers, secret and tolerance
     * @throws OpenAIInvalidDataException if the body could not be parsed.
     */
    fun unwrap(params: WebhookVerificationParams): UnwrapWebhookEvent

    /**
     * Validates whether or not the webhook payload was sent by OpenAI.
     *
     * @param params Verification parameters including payload, headers, secret and tolerance
     * @throws InvalidWebhookSignatureException if the signature is invalid or timestamp is too
     *   old/new
     */
    fun verifySignature(params: WebhookVerificationParams)

    /** A view of [WebhookService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService.WithRawResponse
    }
}
