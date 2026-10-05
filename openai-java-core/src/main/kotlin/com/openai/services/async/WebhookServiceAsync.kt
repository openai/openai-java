// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.webhooks.DeletedWebhookEndpoint
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookDeleteParams
import com.openai.models.webhooks.WebhookEndpoint
import com.openai.models.webhooks.WebhookEndpointTestResult
import com.openai.models.webhooks.WebhookEndpointWithSecret
import com.openai.models.webhooks.WebhookListPageAsync
import com.openai.models.webhooks.WebhookListParams
import com.openai.models.webhooks.WebhookRetrieveParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import com.openai.models.webhooks.WebhookVerificationParams
import com.openai.services.async.webhooks.EventTypeServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface WebhookServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookServiceAsync

    /**
     * Validates that the given payload was sent by OpenAI and parses the payload.
     *
     * @param params Verification parameters including payload, headers, secret and tolerance
     * @throws com.openai.errors.InvalidWebhookSignatureException if the body could not be parsed.
     */
    fun unwrap(params: WebhookVerificationParams): UnwrapWebhookEvent

    /**
     * Validates whether or not the webhook payload was sent by OpenAI.
     *
     * @param params Verification parameters including payload, headers, secret and tolerance
     * @throws com.openai.errors.InvalidWebhookSignatureException if the signature is invalid or
     *   timestamp is too old/new
     */
    fun verifySignature(params: WebhookVerificationParams)

    fun eventTypes(): EventTypeServiceAsync

    /** Creates a webhook endpoint for the authenticated project. */
    fun create(params: WebhookCreateParams): CompletableFuture<WebhookEndpointWithSecret> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpointWithSecret>

    /** Retrieves a webhook endpoint for the authenticated project. */
    fun retrieve(webhookEndpointId: String): CompletableFuture<WebhookEndpoint> =
        retrieve(webhookEndpointId, WebhookRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        webhookEndpointId: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpoint> =
        retrieve(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        webhookEndpointId: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
    ): CompletableFuture<WebhookEndpoint> =
        retrieve(webhookEndpointId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpoint>

    /** @see retrieve */
    fun retrieve(params: WebhookRetrieveParams): CompletableFuture<WebhookEndpoint> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        webhookEndpointId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookEndpoint> =
        retrieve(webhookEndpointId, WebhookRetrieveParams.none(), requestOptions)

    /** Updates a webhook endpoint for the authenticated project. */
    fun update(webhookEndpointId: String): CompletableFuture<WebhookEndpoint> =
        update(webhookEndpointId, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        webhookEndpointId: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpoint> =
        update(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see update */
    fun update(
        webhookEndpointId: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): CompletableFuture<WebhookEndpoint> = update(webhookEndpointId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpoint>

    /** @see update */
    fun update(params: WebhookUpdateParams): CompletableFuture<WebhookEndpoint> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        webhookEndpointId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookEndpoint> =
        update(webhookEndpointId, WebhookUpdateParams.none(), requestOptions)

    /** Returns webhook endpoints for the authenticated project in newest-first order. */
    fun list(): CompletableFuture<WebhookListPageAsync> = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListPageAsync>

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none()
    ): CompletableFuture<WebhookListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<WebhookListPageAsync> =
        list(WebhookListParams.none(), requestOptions)

    /** Deletes a webhook endpoint for the authenticated project. */
    fun delete(webhookEndpointId: String): CompletableFuture<DeletedWebhookEndpoint> =
        delete(webhookEndpointId, WebhookDeleteParams.none())

    /** @see delete */
    fun delete(
        webhookEndpointId: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DeletedWebhookEndpoint> =
        delete(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see delete */
    fun delete(
        webhookEndpointId: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
    ): CompletableFuture<DeletedWebhookEndpoint> =
        delete(webhookEndpointId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: WebhookDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DeletedWebhookEndpoint>

    /** @see delete */
    fun delete(params: WebhookDeleteParams): CompletableFuture<DeletedWebhookEndpoint> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        webhookEndpointId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DeletedWebhookEndpoint> =
        delete(webhookEndpointId, WebhookDeleteParams.none(), requestOptions)

    /** Rotates the signing secret for a webhook endpoint in the authenticated project. */
    fun rotateSecret(webhookEndpointId: String): CompletableFuture<WebhookEndpointWithSecret> =
        rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none())

    /** @see rotateSecret */
    fun rotateSecret(
        webhookEndpointId: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpointWithSecret> =
        rotateSecret(
            params.toBuilder().webhookEndpointId(webhookEndpointId).build(),
            requestOptions,
        )

    /** @see rotateSecret */
    fun rotateSecret(
        webhookEndpointId: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
    ): CompletableFuture<WebhookEndpointWithSecret> =
        rotateSecret(webhookEndpointId, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpointWithSecret>

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams
    ): CompletableFuture<WebhookEndpointWithSecret> = rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        webhookEndpointId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookEndpointWithSecret> =
        rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none(), requestOptions)

    /** Sends a sample event to a webhook endpoint for the authenticated project. */
    fun test(
        webhookEndpointId: String,
        params: WebhookTestParams,
    ): CompletableFuture<WebhookEndpointTestResult> =
        test(webhookEndpointId, params, RequestOptions.none())

    /** @see test */
    fun test(
        webhookEndpointId: String,
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpointTestResult> =
        test(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

    /** @see test */
    fun test(params: WebhookTestParams): CompletableFuture<WebhookEndpointTestResult> =
        test(params, RequestOptions.none())

    /** @see test */
    fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEndpointTestResult>

    /**
     * A view of [WebhookServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookServiceAsync.WithRawResponse

        fun eventTypes(): EventTypeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /webhook_endpoints`, but is otherwise the same as
         * [WebhookServiceAsync.create].
         */
        fun create(
            params: WebhookCreateParams
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>>

        /**
         * Returns a raw HTTP response for `get /webhook_endpoints/{webhook_endpoint_id}`, but is
         * otherwise the same as [WebhookServiceAsync.retrieve].
         */
        fun retrieve(
            webhookEndpointId: String
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            retrieve(webhookEndpointId, WebhookRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            webhookEndpointId: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            retrieve(
                params.toBuilder().webhookEndpointId(webhookEndpointId).build(),
                requestOptions,
            )

        /** @see retrieve */
        fun retrieve(
            webhookEndpointId: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            retrieve(webhookEndpointId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>>

        /** @see retrieve */
        fun retrieve(
            params: WebhookRetrieveParams
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            retrieve(webhookEndpointId, WebhookRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /webhook_endpoints/{webhook_endpoint_id}`, but is
         * otherwise the same as [WebhookServiceAsync.update].
         */
        fun update(webhookEndpointId: String): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            update(webhookEndpointId, WebhookUpdateParams.none())

        /** @see update */
        fun update(
            webhookEndpointId: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            update(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

        /** @see update */
        fun update(
            webhookEndpointId: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            update(webhookEndpointId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>>

        /** @see update */
        fun update(
            params: WebhookUpdateParams
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookEndpoint>> =
            update(webhookEndpointId, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhook_endpoints`, but is otherwise the same as
         * [WebhookServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<WebhookListPageAsync>> =
            list(WebhookListParams.none())

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListPageAsync>>

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): CompletableFuture<HttpResponseFor<WebhookListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WebhookListPageAsync>> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /webhook_endpoints/{webhook_endpoint_id}`, but is
         * otherwise the same as [WebhookServiceAsync.delete].
         */
        fun delete(
            webhookEndpointId: String
        ): CompletableFuture<HttpResponseFor<DeletedWebhookEndpoint>> =
            delete(webhookEndpointId, WebhookDeleteParams.none())

        /** @see delete */
        fun delete(
            webhookEndpointId: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DeletedWebhookEndpoint>> =
            delete(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

        /** @see delete */
        fun delete(
            webhookEndpointId: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<DeletedWebhookEndpoint>> =
            delete(webhookEndpointId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DeletedWebhookEndpoint>>

        /** @see delete */
        fun delete(
            params: WebhookDeleteParams
        ): CompletableFuture<HttpResponseFor<DeletedWebhookEndpoint>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DeletedWebhookEndpoint>> =
            delete(webhookEndpointId, WebhookDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /webhook_endpoints/{webhook_endpoint_id}/rotate_secret`, but is otherwise the same as
         * [WebhookServiceAsync.rotateSecret].
         */
        fun rotateSecret(
            webhookEndpointId: String
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>> =
            rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none())

        /** @see rotateSecret */
        fun rotateSecret(
            webhookEndpointId: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>> =
            rotateSecret(
                params.toBuilder().webhookEndpointId(webhookEndpointId).build(),
                requestOptions,
            )

        /** @see rotateSecret */
        fun rotateSecret(
            webhookEndpointId: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>> =
            rotateSecret(webhookEndpointId, params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>>

        /** @see rotateSecret */
        fun rotateSecret(
            params: WebhookRotateSecretParams
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>> =
            rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            webhookEndpointId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookEndpointWithSecret>> =
            rotateSecret(webhookEndpointId, WebhookRotateSecretParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /webhook_endpoints/{webhook_endpoint_id}/test`, but
         * is otherwise the same as [WebhookServiceAsync.test].
         */
        fun test(
            webhookEndpointId: String,
            params: WebhookTestParams,
        ): CompletableFuture<HttpResponseFor<WebhookEndpointTestResult>> =
            test(webhookEndpointId, params, RequestOptions.none())

        /** @see test */
        fun test(
            webhookEndpointId: String,
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpointTestResult>> =
            test(params.toBuilder().webhookEndpointId(webhookEndpointId).build(), requestOptions)

        /** @see test */
        fun test(
            params: WebhookTestParams
        ): CompletableFuture<HttpResponseFor<WebhookEndpointTestResult>> =
            test(params, RequestOptions.none())

        /** @see test */
        fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEndpointTestResult>>
    }
}
