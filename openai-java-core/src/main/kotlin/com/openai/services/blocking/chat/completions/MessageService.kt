// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat.completions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.chat.completions.messages.MessageListPage
import com.openai.models.chat.completions.messages.MessageListParams

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get the messages in a stored chat completion. Only Chat Completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    fun list(completionId: String): MessageListPage = list(completionId, MessageListParams.none())

    /** @see [list] */
    fun list(
        completionId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage = list(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see [list] */
    fun list(
        completionId: String,
        params: MessageListParams = MessageListParams.none(),
    ): MessageListPage = list(completionId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** @see [list] */
    fun list(params: MessageListParams): MessageListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(completionId: String, requestOptions: RequestOptions): MessageListPage =
        list(completionId, MessageListParams.none(), requestOptions)

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}/messages`, but is
         * otherwise the same as [MessageService.list].
         */
        @MustBeClosed
        fun list(completionId: String): HttpResponseFor<MessageListPage> =
            list(completionId, MessageListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            completionId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage> =
            list(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            completionId: String,
            params: MessageListParams = MessageListParams.none(),
        ): HttpResponseFor<MessageListPage> = list(completionId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: MessageListParams): HttpResponseFor<MessageListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            completionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> =
            list(completionId, MessageListParams.none(), requestOptions)
    }
}
