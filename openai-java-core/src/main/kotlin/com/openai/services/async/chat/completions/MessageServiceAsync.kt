// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat.completions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.chat.completions.messages.MessageListPageAsync
import com.openai.models.chat.completions.messages.MessageListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync

    /**
     * Get the messages in a stored chat completion. Only Chat Completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    fun list(completionId: String): CompletableFuture<MessageListPageAsync> =
        list(completionId, MessageListParams.none())

    /** @see list */
    fun list(
        completionId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync> =
        list(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see list */
    fun list(
        completionId: String,
        params: MessageListParams = MessageListParams.none(),
    ): CompletableFuture<MessageListPageAsync> = list(completionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** @see list */
    fun list(params: MessageListParams): CompletableFuture<MessageListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        completionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListPageAsync> =
        list(completionId, MessageListParams.none(), requestOptions)

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}/messages`, but is
         * otherwise the same as [MessageServiceAsync.list].
         */
        fun list(completionId: String): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(completionId, MessageListParams.none())

        /** @see list */
        fun list(
            completionId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see list */
        fun list(
            completionId: String,
            params: MessageListParams = MessageListParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(completionId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see list */
        fun list(
            params: MessageListParams
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            completionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(completionId, MessageListParams.none(), requestOptions)
    }
}
