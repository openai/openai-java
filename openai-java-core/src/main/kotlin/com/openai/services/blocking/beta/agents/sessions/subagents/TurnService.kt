// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions.subagents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListPage
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListParams
import com.openai.models.beta.agents.sessions.subagents.turns.TurnRetrieveParams
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.blocking.beta.agents.sessions.subagents.turns.ItemService
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

    fun items(): ItemService

    /**
     * Retrieves a turn belonging to this subagent. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
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
     * Lists all turns of this subagent, including turns after a resume. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun list(subagentId: String, params: TurnListParams): TurnListPage =
        list(subagentId, params, RequestOptions.none())

    /** @see list */
    fun list(
        subagentId: String,
        params: TurnListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TurnListPage = list(params.toBuilder().subagentId(subagentId).build(), requestOptions)

    /** @see list */
    fun list(params: TurnListParams): TurnListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TurnListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TurnListPage

    /** A view of [TurnService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnService.WithRawResponse

        fun items(): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}/turns/{turn_id}`, but is otherwise
         * the same as [TurnService.retrieve].
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
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}/turns`, but is otherwise the same
         * as [TurnService.list].
         */
        @MustBeClosed
        fun list(subagentId: String, params: TurnListParams): HttpResponseFor<TurnListPage> =
            list(subagentId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            subagentId: String,
            params: TurnListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TurnListPage> =
            list(params.toBuilder().subagentId(subagentId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(params: TurnListParams): HttpResponseFor<TurnListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TurnListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TurnListPage>
    }
}
