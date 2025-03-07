// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat.completions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.ChatCompletionMessageListPage
import com.openai.models.ChatCompletionMessageListParams

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get the messages in a stored chat completion. Only chat completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    fun list(params: ChatCompletionMessageListParams): ChatCompletionMessageListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ChatCompletionMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletionMessageListPage

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}/messages`, but is
         * otherwise the same as [MessageService.list].
         */
        @MustBeClosed
        fun list(
            params: ChatCompletionMessageListParams
        ): HttpResponseFor<ChatCompletionMessageListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ChatCompletionMessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletionMessageListPage>
    }
}
