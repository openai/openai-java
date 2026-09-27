// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.items.ItemListPageAsync
import com.openai.models.beta.agents.sessions.items.ItemListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync

    /**
     * Lists items produced by the session's root agent, including its interactions with subagents.
     * Each subagent has its own item history. See
     * [inspecting agent output](https://developers.openai.com/api/docs/guides/agents-api/observability).
     */
    fun list(sessionId: String): CompletableFuture<ItemListPageAsync> =
        list(sessionId, ItemListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: ItemListParams = ItemListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemListPageAsync> =
        list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: ItemListParams = ItemListParams.none(),
    ): CompletableFuture<ItemListPageAsync> = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemListPageAsync>

    /** @see list */
    fun list(params: ItemListParams): CompletableFuture<ItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ItemListPageAsync> = list(sessionId, ItemListParams.none(), requestOptions)

    /** A view of [ItemServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/items`, but is
         * otherwise the same as [ItemServiceAsync.list].
         */
        fun list(sessionId: String): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(sessionId, ItemListParams.none())

        /** @see list */
        fun list(
            sessionId: String,
            params: ItemListParams = ItemListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        fun list(
            sessionId: String,
            params: ItemListParams = ItemListParams.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(sessionId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>>

        /** @see list */
        fun list(params: ItemListParams): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(sessionId, ItemListParams.none(), requestOptions)
    }
}
