// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.models.beta.agents.sessions.turns.TurnListPageAsync
import com.openai.models.beta.agents.sessions.turns.TurnListParams
import com.openai.models.beta.agents.sessions.turns.TurnRetrieveParams
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

    /**
     * Retrieves a turn's current status, timestamps, usage, and error. Returns 404 if the turn does
     * not belong to the session. See
     * [session turns](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage#inspect-session-turns).
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
     * Lists turns by creation time and turn ID. The after cursor is exclusive in the selected
     * order. See
     * [session turns](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage#inspect-session-turns).
     */
    fun list(sessionId: String): CompletableFuture<TurnListPageAsync> =
        list(sessionId, TurnListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: TurnListParams = TurnListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TurnListPageAsync> =
        list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: TurnListParams = TurnListParams.none(),
    ): CompletableFuture<TurnListPageAsync> = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TurnListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TurnListPageAsync>

    /** @see list */
    fun list(params: TurnListParams): CompletableFuture<TurnListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TurnListPageAsync> = list(sessionId, TurnListParams.none(), requestOptions)

    /** A view of [TurnServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/turns/{turn_id}`, but
         * is otherwise the same as [TurnServiceAsync.retrieve].
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
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/turns`, but is
         * otherwise the same as [TurnServiceAsync.list].
         */
        fun list(sessionId: String): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(sessionId, TurnListParams.none())

        /** @see list */
        fun list(
            sessionId: String,
            params: TurnListParams = TurnListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        fun list(
            sessionId: String,
            params: TurnListParams = TurnListParams.none(),
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(sessionId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TurnListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>>

        /** @see list */
        fun list(params: TurnListParams): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>> =
            list(sessionId, TurnListParams.none(), requestOptions)
    }
}
