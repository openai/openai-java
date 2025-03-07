// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaThreadMessageCreateParams
import com.openai.models.BetaThreadMessageDeleteParams
import com.openai.models.BetaThreadMessageListPage
import com.openai.models.BetaThreadMessageListParams
import com.openai.models.BetaThreadMessageRetrieveParams
import com.openai.models.BetaThreadMessageUpdateParams
import com.openai.models.Message
import com.openai.models.MessageDeleted

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a message. */
    fun create(params: BetaThreadMessageCreateParams): Message =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaThreadMessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Retrieve a message. */
    fun retrieve(params: BetaThreadMessageRetrieveParams): Message =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadMessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Modifies a message. */
    fun update(params: BetaThreadMessageUpdateParams): Message =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaThreadMessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Returns a list of messages for a given thread. */
    fun list(params: BetaThreadMessageListParams): BetaThreadMessageListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: BetaThreadMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaThreadMessageListPage

    /** Deletes a message. */
    fun delete(params: BetaThreadMessageDeleteParams): MessageDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaThreadMessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDeleted

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages`, but is otherwise
         * the same as [MessageService.create].
         */
        @MustBeClosed
        fun create(params: BetaThreadMessageCreateParams): HttpResponseFor<Message> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadMessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaThreadMessageRetrieveParams): HttpResponseFor<Message> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadMessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.update].
         */
        @MustBeClosed
        fun update(params: BetaThreadMessageUpdateParams): HttpResponseFor<Message> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaThreadMessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageService.list].
         */
        @MustBeClosed
        fun list(params: BetaThreadMessageListParams): HttpResponseFor<BetaThreadMessageListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaThreadMessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaThreadMessageListPage>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}/messages/{message_id}`, but
         * is otherwise the same as [MessageService.delete].
         */
        @MustBeClosed
        fun delete(params: BetaThreadMessageDeleteParams): HttpResponseFor<MessageDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaThreadMessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDeleted>
    }
}
