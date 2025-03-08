// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat.completions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.ChatCompletionMessageListPageAsync
import com.openai.models.ChatCompletionMessageListParams
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get the messages in a stored chat completion. Only chat completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    fun list(
        params: ChatCompletionMessageListParams
    ): CompletableFuture<ChatCompletionMessageListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ChatCompletionMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionMessageListPageAsync>

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}/messages`, but is
         * otherwise the same as [MessageServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: ChatCompletionMessageListParams
        ): CompletableFuture<HttpResponseFor<ChatCompletionMessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ChatCompletionMessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionMessageListPageAsync>>
    }
}
