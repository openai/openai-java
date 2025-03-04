// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: BetaThreadMessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Retrieve a message. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadMessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Modifies a message. */
    @JvmOverloads
    fun update(
        params: BetaThreadMessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Returns a list of messages for a given thread. */
    @JvmOverloads
    fun list(
        params: BetaThreadMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaThreadMessageListPage

    /** Deletes a message. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: BetaThreadMessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaThreadMessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: BetaThreadMessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: BetaThreadMessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaThreadMessageListPage>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}/messages/{message_id}`, but
         * is otherwise the same as [MessageService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: BetaThreadMessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDeleted>
    }
}
