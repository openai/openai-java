// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.Subagent
import com.openai.models.beta.agents.sessions.subagents.SubagentListPageAsync
import com.openai.models.beta.agents.sessions.subagents.SubagentListParams
import com.openai.models.beta.agents.sessions.subagents.SubagentRetrieveParams
import com.openai.services.async.beta.agents.sessions.subagents.ItemServiceAsync
import com.openai.services.async.beta.agents.sessions.subagents.TurnServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SubagentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubagentServiceAsync

    fun items(): ItemServiceAsync

    fun turns(): TurnServiceAsync

    /**
     * Retrieves a subagent belonging to this session. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun retrieve(subagentId: String, params: SubagentRetrieveParams): CompletableFuture<Subagent> =
        retrieve(subagentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        subagentId: String,
        params: SubagentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Subagent> =
        retrieve(params.toBuilder().subagentId(subagentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: SubagentRetrieveParams): CompletableFuture<Subagent> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SubagentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Subagent>

    /**
     * Lists subagents in a session, including nested and closed subagents. See
     * [subagent workflows](https://developers.openai.com/api/docs/guides/agents-api/multi-agent).
     */
    fun list(sessionId: String): CompletableFuture<SubagentListPageAsync> =
        list(sessionId, SubagentListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: SubagentListParams = SubagentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SubagentListPageAsync> =
        list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: SubagentListParams = SubagentListParams.none(),
    ): CompletableFuture<SubagentListPageAsync> = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: SubagentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SubagentListPageAsync>

    /** @see list */
    fun list(params: SubagentListParams): CompletableFuture<SubagentListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<SubagentListPageAsync> =
        list(sessionId, SubagentListParams.none(), requestOptions)

    /**
     * A view of [SubagentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubagentServiceAsync.WithRawResponse

        fun items(): ItemServiceAsync.WithRawResponse

        fun turns(): TurnServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/subagents/{subagent_id}`, but is otherwise the same as
         * [SubagentServiceAsync.retrieve].
         */
        fun retrieve(
            subagentId: String,
            params: SubagentRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Subagent>> =
            retrieve(subagentId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            subagentId: String,
            params: SubagentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Subagent>> =
            retrieve(params.toBuilder().subagentId(subagentId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(params: SubagentRetrieveParams): CompletableFuture<HttpResponseFor<Subagent>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: SubagentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Subagent>>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/subagents`, but is
         * otherwise the same as [SubagentServiceAsync.list].
         */
        fun list(sessionId: String): CompletableFuture<HttpResponseFor<SubagentListPageAsync>> =
            list(sessionId, SubagentListParams.none())

        /** @see list */
        fun list(
            sessionId: String,
            params: SubagentListParams = SubagentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SubagentListPageAsync>> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        fun list(
            sessionId: String,
            params: SubagentListParams = SubagentListParams.none(),
        ): CompletableFuture<HttpResponseFor<SubagentListPageAsync>> =
            list(sessionId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: SubagentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SubagentListPageAsync>>

        /** @see list */
        fun list(
            params: SubagentListParams
        ): CompletableFuture<HttpResponseFor<SubagentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SubagentListPageAsync>> =
            list(sessionId, SubagentListParams.none(), requestOptions)
    }
}
