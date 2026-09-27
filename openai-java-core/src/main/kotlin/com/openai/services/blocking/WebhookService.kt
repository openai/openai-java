// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.DeletedWebhookEndpoint
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookDeleteParams
import com.openai.models.webhooks.WebhookEndpoint
import com.openai.models.webhooks.WebhookEndpointTestResult
import com.openai.models.webhooks.WebhookEndpointWithSecret
import com.openai.models.webhooks.WebhookListPage
import com.openai.models.webhooks.WebhookListParams
import com.openai.models.webhooks.WebhookRetrieveParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import com.openai.models.webhooks.WebhookVerificationParams
import com.openai.services.blocking.webhooks.EventTypeService
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

    fun eventTypes(): EventTypeService

    /** Creates a webhook endpoint for the authenticated project. */
    fun create(params: WebhookCreateParams): WebhookEndpointWithSecret =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpointWithSecret

    /** Retrieves a webhook endpoint for the authenticated project. */
    fun retrieve(webhookEndpointId: String): WebhookEndpoint =
        retrieve(webhookEndpointId, WebhookRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        webhookEndpointId: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpoint =
        retrieve(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        webhookEndpointId: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
    ): WebhookEndpoint = retrieve(webhookEndpointId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpoint

    /** @see retrieve */
    fun retrieve(params: WebhookRetrieveParams): WebhookEndpoint =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(webhookEndpointId: String, requestOptions: RequestOptions): WebhookEndpoint =
        retrieve(webhookEndpointId, WebhookRetrieveParams.none(), requestOptions)

    /** Updates a webhook endpoint for the authenticated project. */
    fun update(webhookEndpointId: String): WebhookEndpoint =
        update(webhookEndpointId, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        webhookEndpointId: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpoint =
        update(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see update */
    fun update(
        webhookEndpointId: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): WebhookEndpoint = update(webhookEndpointId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpoint

    /** @see update */
    fun update(params: WebhookUpdateParams): WebhookEndpoint = update(params, RequestOptions.none())

    /** @see update */
    fun update(webhookEndpointId: String, requestOptions: RequestOptions): WebhookEndpoint =
        update(webhookEndpointId, WebhookUpdateParams.none(), requestOptions)

    /** Returns webhook endpoints for the authenticated project in newest-first order. */
    fun list(): WebhookListPage = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListPage

    /** @see list */
    fun list(params: WebhookListParams = WebhookListParams.none()): WebhookListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): WebhookListPage =
        list(WebhookListParams.none(), requestOptions)

    /** Deletes a webhook endpoint for the authenticated project. */
    fun delete(webhookEndpointId: String): DeletedWebhookEndpoint =
        delete(webhookEndpointId, WebhookDeleteParams.none())

    /** @see delete */
    fun delete(
        webhookEndpointId: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DeletedWebhookEndpoint =
        delete(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see delete */
    fun delete(
        webhookEndpointId: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
    ): DeletedWebhookEndpoint = delete(webhookEndpointId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: WebhookDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DeletedWebhookEndpoint

    /** @see delete */
    fun delete(params: WebhookDeleteParams): DeletedWebhookEndpoint =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(webhookEndpointId: String, requestOptions: RequestOptions): DeletedWebhookEndpoint =
        delete(webhookEndpointId, WebhookDeleteParams.none(), requestOptions)

    /** Rotates the signing secret for a webhook endpoint in the authenticated project. */
    fun rotateSecret(webhookEndpointId: String): WebhookEndpointWithSecret =
        rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none())

    /** @see rotateSecret */
    fun rotateSecret(
        webhookEndpointId: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpointWithSecret =
        rotateSecret(
            params.toBuilder().webhookEndpointId(webhookEndpointId).build(),
            requestOptions,
        )

    /** @see rotateSecret */
    fun rotateSecret(
        webhookEndpointId: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
    ): WebhookEndpointWithSecret = rotateSecret(webhookEndpointId, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpointWithSecret

    /** @see rotateSecret */
    fun rotateSecret(params: WebhookRotateSecretParams): WebhookEndpointWithSecret =
        rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        webhookEndpointId: String,
        requestOptions: RequestOptions,
    ): WebhookEndpointWithSecret =
        rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none(), requestOptions)

    /** Sends a sample event to a webhook endpoint for the authenticated project. */
    fun test(webhookEndpointId: String, params: WebhookTestParams): WebhookEndpointTestResult =
        test(webhookEndpointId, params, RequestOptions.none())

    /** @see test */
    fun test(
        webhookEndpointId: String,
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpointTestResult =
        test(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see test */
    fun test(params: WebhookTestParams): WebhookEndpointTestResult =
        test(params, RequestOptions.none())

    /** @see test */
    fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEndpointTestResult

    /** A view of [WebhookService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService.WithRawResponse

        fun eventTypes(): EventTypeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /webhook_endpoints`, but is otherwise the same as
         * [WebhookService.create].
         */
        @MustBeClosed
        fun create(params: WebhookCreateParams): HttpResponseFor<WebhookEndpointWithSecret> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpointWithSecret>

        /**
         * Returns a raw HTTP response for `get /webhook_endpoints/{webhook_endpoint_id}`, but is
         * otherwise the same as [WebhookService.retrieve].
         */
        @MustBeClosed
        fun retrieve(webhookEndpointId: String): HttpResponseFor<WebhookEndpoint> =
            retrieve(webhookEndpointId, WebhookRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            webhookEndpointId: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpoint> =
            retrieve(
                params.toBuilder().webhookEndpointId(webhookEndpointId).build(),
                requestOptions,
            )

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            webhookEndpointId: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        ): HttpResponseFor<WebhookEndpoint> =
            retrieve(webhookEndpointId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpoint>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: WebhookRetrieveParams): HttpResponseFor<WebhookEndpoint> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpoint> =
            retrieve(webhookEndpointId, WebhookRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /webhook_endpoints/{webhook_endpoint_id}`, but is
         * otherwise the same as [WebhookService.update].
         */
        @MustBeClosed
        fun update(webhookEndpointId: String): HttpResponseFor<WebhookEndpoint> =
            update(webhookEndpointId, WebhookUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            webhookEndpointId: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpoint> =
            update(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            webhookEndpointId: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): HttpResponseFor<WebhookEndpoint> =
            update(webhookEndpointId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpoint>

        /** @see update */
        @MustBeClosed
        fun update(params: WebhookUpdateParams): HttpResponseFor<WebhookEndpoint> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpoint> =
            update(webhookEndpointId, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhook_endpoints`, but is otherwise the same as
         * [WebhookService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<WebhookListPage> = list(WebhookListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): HttpResponseFor<WebhookListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<WebhookListPage> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /webhook_endpoints/{webhook_endpoint_id}`, but is
         * otherwise the same as [WebhookService.delete].
         */
        @MustBeClosed
        fun delete(webhookEndpointId: String): HttpResponseFor<DeletedWebhookEndpoint> =
            delete(webhookEndpointId, WebhookDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            webhookEndpointId: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DeletedWebhookEndpoint> =
            delete(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            webhookEndpointId: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
        ): HttpResponseFor<DeletedWebhookEndpoint> =
            delete(webhookEndpointId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DeletedWebhookEndpoint>

        /** @see delete */
        @MustBeClosed
        fun delete(params: WebhookDeleteParams): HttpResponseFor<DeletedWebhookEndpoint> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DeletedWebhookEndpoint> =
            delete(webhookEndpointId, WebhookDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /webhook_endpoints/{webhook_endpoint_id}/rotate_secret`, but is otherwise the same as
         * [WebhookService.rotateSecret].
         */
        @MustBeClosed
        fun rotateSecret(webhookEndpointId: String): HttpResponseFor<WebhookEndpointWithSecret> =
            rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            webhookEndpointId: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpointWithSecret> =
            rotateSecret(
                params.toBuilder().webhookEndpointId(webhookEndpointId).build(),
                requestOptions,
            )

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            webhookEndpointId: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        ): HttpResponseFor<WebhookEndpointWithSecret> =
            rotateSecret(webhookEndpointId, params, RequestOptions.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpointWithSecret>

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            params: WebhookRotateSecretParams
        ): HttpResponseFor<WebhookEndpointWithSecret> = rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpointWithSecret> =
            rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /webhook_endpoints/{webhook_endpoint_id}/test`, but
         * is otherwise the same as [WebhookService.test].
         */
        @MustBeClosed
        fun test(
            webhookEndpointId: String,
            params: WebhookTestParams,
        ): HttpResponseFor<WebhookEndpointTestResult> =
            test(webhookEndpointId, params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(
            webhookEndpointId: String,
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpointTestResult> =
            test(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

        /** @see test */
        @MustBeClosed
        fun test(params: WebhookTestParams): HttpResponseFor<WebhookEndpointTestResult> =
            test(params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEndpointTestResult>
    }
}
