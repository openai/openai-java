// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions.subagents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.subagents.items.ItemListPage
import com.openai.models.beta.agents.sessions.subagents.items.ItemListParams
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
     * Lists this subagent's own items across all of its turns. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun list(subagentId: String, params: ItemListParams): ItemListPage =
        list(subagentId, params, RequestOptions.none())

    /** @see list */
    fun list(
        subagentId: String,
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemListPage = list(params.toBuilder().subagentId(subagentId).build(), requestOptions)

    /** @see list */
    fun list(params: ItemListParams): ItemListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemListPage

    /** A view of [ItemService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}/items`, but is otherwise the same
         * as [ItemService.list].
         */
        @MustBeClosed
        fun list(subagentId: String, params: ItemListParams): HttpResponseFor<ItemListPage> =
            list(subagentId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            subagentId: String,
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemListPage> =
            list(params.toBuilder().subagentId(subagentId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(params: ItemListParams): HttpResponseFor<ItemListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemListPage>
    }
}
