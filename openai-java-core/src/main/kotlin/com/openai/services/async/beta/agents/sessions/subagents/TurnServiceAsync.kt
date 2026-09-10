// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions.subagents

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListPageAsync
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListParams
import com.openai.models.beta.agents.sessions.subagents.turns.TurnRetrieveParams
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.async.beta.agents.sessions.subagents.turns.ItemServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TurnServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnServiceAsync

    fun items(): ItemServiceAsync

    /**
     * Retrieves a turn belonging to this subagent. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun retrieve(turnId: String, params: TurnRetrieveParams): CompletableFuture<Turn> =
        retrieve(turnId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        turnId: String,
        params: TurnRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Turn> = retrieve(params.toBuilder().turnId(turnId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: TurnRetrieveParams): CompletableFuture<Turn> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TurnRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Turn>

    /**
     * Lists all turns of this subagent, including turns after a resume. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun list(subagentId: String, params: TurnListParams): CompletableFuture<TurnListPageAsync> =
        list(subagentId, params, RequestOptions.none())

    /** @see list */
    fun list(
        subagentId: String,
        params: TurnListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TurnListPageAsync> =
        list(params.toBuilder().subagentId(subagentId).build(), requestOptions)

    /** @see list */
    fun list(params: TurnListParams): CompletableFuture<TurnListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TurnListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TurnListPageAsync>

    /** A view of [TurnServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnServiceAsync.WithRawResponse

        fun items(): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}/turns/{turn_id}`, but is otherwise
         * the same as [TurnServiceAsync.retrieve].
         */
        fun retrieve(
            turnId: String,
            params: TurnRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Turn>> =
            retrieve(turnId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            turnId: String,
            params: TurnRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Turn>> =
            retrieve(params.toBuilder().turnId(turnId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(params: TurnRetrieveParams): CompletableFuture<HttpResponseFor<Turn>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TurnRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Turn>>

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}/turns`, but is otherwise the same
         * as [TurnServiceAsync.list].
         */
        fun list(
            subagentId: String,
            params: TurnListParams,
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(subagentId, params, RequestOptions.none())

        /** @see list */
        fun list(
            subagentId: String,
            params: TurnListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(params.toBuilder().subagentId(subagentId).build(), requestOptions)

        /** @see list */
        fun list(params: TurnListParams): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TurnListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>>
    }
}
