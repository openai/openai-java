// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.Subagent
import com.openai.models.beta.agents.sessions.subagents.SubagentListPage
import com.openai.models.beta.agents.sessions.subagents.SubagentListParams
import com.openai.models.beta.agents.sessions.subagents.SubagentRetrieveParams
import com.openai.services.blocking.beta.agents.sessions.subagents.ItemService
import com.openai.services.blocking.beta.agents.sessions.subagents.TurnService
import java.util.function.Consumer

interface SubagentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubagentService

    fun items(): ItemService

    fun turns(): TurnService

    /**
     * Retrieves a subagent belonging to this session. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun retrieve(subagentId: String, params: SubagentRetrieveParams): Subagent =
        retrieve(subagentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        subagentId: String,
        params: SubagentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Subagent = retrieve(params.toBuilder().subagentId(subagentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: SubagentRetrieveParams): Subagent = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SubagentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Subagent

    /**
     * Lists subagents in a session, including nested and closed subagents. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun list(sessionId: String): SubagentListPage = list(sessionId, SubagentListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: SubagentListParams = SubagentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubagentListPage = list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: SubagentListParams = SubagentListParams.none(),
    ): SubagentListPage = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: SubagentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubagentListPage

    /** @see list */
    fun list(params: SubagentListParams): SubagentListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(sessionId: String, requestOptions: RequestOptions): SubagentListPage =
        list(sessionId, SubagentListParams.none(), requestOptions)

    /** A view of [SubagentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubagentService.WithRawResponse

        fun items(): ItemService.WithRawResponse

        fun turns(): TurnService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}`, but is otherwise the same as
         * [SubagentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            subagentId: String,
            params: SubagentRetrieveParams,
        ): HttpResponseFor<Subagent> = retrieve(subagentId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            subagentId: String,
            params: SubagentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Subagent> =
            retrieve(params.toBuilder().subagentId(subagentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: SubagentRetrieveParams): HttpResponseFor<Subagent> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SubagentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Subagent>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/subagents`, but is
         * otherwise the same as [SubagentService.list].
         */
        @MustBeClosed
        fun list(sessionId: String): HttpResponseFor<SubagentListPage> =
            list(sessionId, SubagentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: SubagentListParams = SubagentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubagentListPage> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: SubagentListParams = SubagentListParams.none(),
        ): HttpResponseFor<SubagentListPage> = list(sessionId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SubagentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubagentListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: SubagentListParams): HttpResponseFor<SubagentListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SubagentListPage> =
            list(sessionId, SubagentListParams.none(), requestOptions)
    }
}
