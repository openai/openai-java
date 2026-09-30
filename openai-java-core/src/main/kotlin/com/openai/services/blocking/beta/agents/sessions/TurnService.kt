// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.models.beta.agents.sessions.turns.TurnListPage
import com.openai.models.beta.agents.sessions.turns.TurnListParams
import com.openai.models.beta.agents.sessions.turns.TurnRetrieveParams
import java.util.function.Consumer

interface TurnService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnService

    /**
     * Retrieves a turn's current status, timestamps, usage, and error. Returns 404 if the turn does
     * not belong to the session. See
     * [session turns](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage#inspect-session-turns).
     */
    fun retrieve(turnId: String, params: TurnRetrieveParams): Turn =
        retrieve(turnId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        turnId: String,
        params: TurnRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Turn = retrieve(params.toBuilder().turnId(turnId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: TurnRetrieveParams): Turn = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TurnRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Turn

    /**
     * Lists turns by creation time and turn ID. The after cursor is exclusive in the selected
     * order. See
     * [session turns](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage#inspect-session-turns).
     */
    fun list(sessionId: String): TurnListPage = list(sessionId, TurnListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: TurnListParams = TurnListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TurnListPage = list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(sessionId: String, params: TurnListParams = TurnListParams.none()): TurnListPage =
        list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TurnListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TurnListPage

    /** @see list */
    fun list(params: TurnListParams): TurnListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(sessionId: String, requestOptions: RequestOptions): TurnListPage =
        list(sessionId, TurnListParams.none(), requestOptions)

    /** A view of [TurnService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/turns/{turn_id}`, but
         * is otherwise the same as [TurnService.retrieve].
         */
        @MustBeClosed
        fun retrieve(turnId: String, params: TurnRetrieveParams): HttpResponseFor<Turn> =
            retrieve(turnId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            turnId: String,
            params: TurnRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Turn> =
            retrieve(params.toBuilder().turnId(turnId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TurnRetrieveParams): HttpResponseFor<Turn> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TurnRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Turn>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/turns`, but is
         * otherwise the same as [TurnService.list].
         */
        @MustBeClosed
        fun list(sessionId: String): HttpResponseFor<TurnListPage> =
            list(sessionId, TurnListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: TurnListParams = TurnListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TurnListPage> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: TurnListParams = TurnListParams.none(),
        ): HttpResponseFor<TurnListPage> = list(sessionId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TurnListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TurnListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: TurnListParams): HttpResponseFor<TurnListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(sessionId: String, requestOptions: RequestOptions): HttpResponseFor<TurnListPage> =
            list(sessionId, TurnListParams.none(), requestOptions)
    }
}
