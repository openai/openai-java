// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions.subagents.turns

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.subagents.turns.items.ItemListPageAsync
import com.openai.models.beta.agents.sessions.subagents.turns.items.ItemListParams
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
     * Lists items belonging to one turn of this subagent. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun list(turnId: String, params: ItemListParams): CompletableFuture<ItemListPageAsync> =
        list(turnId, params, RequestOptions.none())

    /** @see list */
    fun list(
        turnId: String,
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemListPageAsync> =
        list(params.toBuilder().turnId(turnId).build(), requestOptions)

    /** @see list */
    fun list(params: ItemListParams): CompletableFuture<ItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemListPageAsync>

    /** A view of [ItemServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}/turns/{turn_id}/items`, but is
         * otherwise the same as [ItemServiceAsync.list].
         */
        fun list(
            turnId: String,
            params: ItemListParams,
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(turnId, params, RequestOptions.none())

        /** @see list */
        fun list(
            turnId: String,
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(params.toBuilder().turnId(turnId).build(), requestOptions)

        /** @see list */
        fun list(params: ItemListParams): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>>
    }
}
