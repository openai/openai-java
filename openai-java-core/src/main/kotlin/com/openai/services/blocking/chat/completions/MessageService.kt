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
     * Get the messages in a stored chat completion. Only chat completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    fun list(params: MessageListParams): MessageListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}/messages`, but is
         * otherwise the same as [MessageService.list].
         */
        @MustBeClosed
        fun list(params: MessageListParams): HttpResponseFor<MessageListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>
    }
}
