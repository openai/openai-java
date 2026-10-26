// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.webhooks

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.webhooks.WebhookEventTypeList
import com.openai.models.webhooks.eventtypes.EventTypeListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EventTypeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventTypeServiceAsync

    /** Returns webhook event types visible to the authenticated project. */
    fun list(): CompletableFuture<WebhookEventTypeList> = list(EventTypeListParams.none())

    /** @see list */
    fun list(
        params: EventTypeListParams = EventTypeListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookEventTypeList>

    /** @see list */
    fun list(
        params: EventTypeListParams = EventTypeListParams.none()
    ): CompletableFuture<WebhookEventTypeList> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<WebhookEventTypeList> =
        list(EventTypeListParams.none(), requestOptions)

    /**
     * A view of [EventTypeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventTypeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /webhook_event_types`, but is otherwise the same as
         * [EventTypeServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<WebhookEventTypeList>> =
            list(EventTypeListParams.none())

        /** @see list */
        fun list(
            params: EventTypeListParams = EventTypeListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookEventTypeList>>

        /** @see list */
        fun list(
            params: EventTypeListParams = EventTypeListParams.none()
        ): CompletableFuture<HttpResponseFor<WebhookEventTypeList>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WebhookEventTypeList>> =
            list(EventTypeListParams.none(), requestOptions)
    }
}
