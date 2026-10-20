// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.items.ItemListPage
import com.openai.models.beta.agents.sessions.items.ItemListParams
import java.util.function.Consumer

interface ItemService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService

    /**
     * Lists items produced by the session's root agent, including its interactions with subagents.
     * Each subagent has its own item history. See
     * [inspecting agent output](https://developers.openai.com/api/docs/guides/agents-api/observability).
     */
    fun list(sessionId: String): ItemListPage = list(sessionId, ItemListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: ItemListParams = ItemListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemListPage = list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(sessionId: String, params: ItemListParams = ItemListParams.none()): ItemListPage =
        list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemListPage

    /** @see list */
    fun list(params: ItemListParams): ItemListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(sessionId: String, requestOptions: RequestOptions): ItemListPage =
        list(sessionId, ItemListParams.none(), requestOptions)

    /** A view of [ItemService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/items`, but is
         * otherwise the same as [ItemService.list].
         */
        @MustBeClosed
        fun list(sessionId: String): HttpResponseFor<ItemListPage> =
            list(sessionId, ItemListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: ItemListParams = ItemListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemListPage> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: ItemListParams = ItemListParams.none(),
        ): HttpResponseFor<ItemListPage> = list(sessionId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ItemListParams): HttpResponseFor<ItemListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(sessionId: String, requestOptions: RequestOptions): HttpResponseFor<ItemListPage> =
            list(sessionId, ItemListParams.none(), requestOptions)
    }
}
