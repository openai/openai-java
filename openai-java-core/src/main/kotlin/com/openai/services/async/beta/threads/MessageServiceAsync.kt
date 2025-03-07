// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaThreadMessageCreateParams
import com.openai.models.BetaThreadMessageDeleteParams
import com.openai.models.BetaThreadMessageListPageAsync
import com.openai.models.BetaThreadMessageListParams
import com.openai.models.BetaThreadMessageRetrieveParams
import com.openai.models.BetaThreadMessageUpdateParams
import com.openai.models.Message
import com.openai.models.MessageDeleted
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a message. */
    fun create(params: BetaThreadMessageCreateParams): CompletableFuture<Message> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaThreadMessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Retrieve a message. */
    fun retrieve(params: BetaThreadMessageRetrieveParams): CompletableFuture<Message> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadMessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Modifies a message. */
    fun update(params: BetaThreadMessageUpdateParams): CompletableFuture<Message> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaThreadMessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Returns a list of messages for a given thread. */
    fun list(
        params: BetaThreadMessageListParams
    ): CompletableFuture<BetaThreadMessageListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: BetaThreadMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaThreadMessageListPageAsync>

    /** Deletes a message. */
    fun delete(params: BetaThreadMessageDeleteParams): CompletableFuture<MessageDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaThreadMessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDeleted>

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages`, but is otherwise
         * the same as [MessageServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: BetaThreadMessageCreateParams
        ): CompletableFuture<HttpResponseFor<Message>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadMessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadMessageRetrieveParams
        ): CompletableFuture<HttpResponseFor<Message>> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadMessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            params: BetaThreadMessageUpdateParams
        ): CompletableFuture<HttpResponseFor<Message>> = update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaThreadMessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: BetaThreadMessageListParams
        ): CompletableFuture<HttpResponseFor<BetaThreadMessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaThreadMessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaThreadMessageListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}/messages/{message_id}`, but
         * is otherwise the same as [MessageServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: BetaThreadMessageDeleteParams
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaThreadMessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDeleted>>
    }
}
