// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.webhooks

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.webhooks.WebhookEventTypeList
import com.openai.models.webhooks.eventtypes.EventTypeListParams
import java.util.function.Consumer

interface EventTypeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventTypeService

    /** Returns webhook event types visible to the authenticated project. */
    fun list(): WebhookEventTypeList = list(EventTypeListParams.none())

    /** @see list */
    fun list(
        params: EventTypeListParams = EventTypeListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookEventTypeList

    /** @see list */
    fun list(params: EventTypeListParams = EventTypeListParams.none()): WebhookEventTypeList =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): WebhookEventTypeList =
        list(EventTypeListParams.none(), requestOptions)

    /** A view of [EventTypeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventTypeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /webhook_event_types`, but is otherwise the same as
         * [EventTypeService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<WebhookEventTypeList> = list(EventTypeListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventTypeListParams = EventTypeListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookEventTypeList>

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventTypeListParams = EventTypeListParams.none()
        ): HttpResponseFor<WebhookEventTypeList> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<WebhookEventTypeList> =
            list(EventTypeListParams.none(), requestOptions)
    }
}
