// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.AgentSessionDeleted
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.beta.agents.sessions.SessionDeleteParams
import com.openai.models.beta.agents.sessions.SessionListPageAsync
import com.openai.models.beta.agents.sessions.SessionListParams
import com.openai.models.beta.agents.sessions.SessionRetrieveParams
import com.openai.models.beta.agents.sessions.SessionUpdateParams
import com.openai.services.async.beta.agents.sessions.ArtifactServiceAsync
import com.openai.services.async.beta.agents.sessions.EventServiceAsync
import com.openai.services.async.beta.agents.sessions.ItemServiceAsync
import com.openai.services.async.beta.agents.sessions.SubagentServiceAsync
import com.openai.services.async.beta.agents.sessions.TurnServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SessionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionServiceAsync

    fun subagents(): SubagentServiceAsync

    fun artifacts(): ArtifactServiceAsync

    fun items(): ItemServiceAsync

    fun events(): EventServiceAsync

    fun turns(): TurnServiceAsync

    /**
     * Creates a managed agent session, optionally submits initial input, and returns the session or
     * streams its events when stream is true. See
     * [running sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions).
     */
    fun create(params: SessionCreateParams): CompletableFuture<AgentSession> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSession>

    /**
     * Creates a managed agent session, optionally submits initial input, and returns the session or
     * streams its events when stream is true. See
     * [running sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions).
     */
    fun createStreaming(params: SessionCreateParams): AsyncStreamResponse<AgentSessionEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    fun createStreaming(
        params: SessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AgentSessionEvent>

    /**
     * Retrieves the current state of a managed agent session. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun retrieve(sessionId: String): CompletableFuture<AgentSession> =
        retrieve(sessionId, SessionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        sessionId: String,
        params: SessionRetrieveParams = SessionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSession> =
        retrieve(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        sessionId: String,
        params: SessionRetrieveParams = SessionRetrieveParams.none(),
    ): CompletableFuture<AgentSession> = retrieve(sessionId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SessionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSession>

    /** @see retrieve */
    fun retrieve(params: SessionRetrieveParams): CompletableFuture<AgentSession> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AgentSession> =
        retrieve(sessionId, SessionRetrieveParams.none(), requestOptions)

    /**
     * Updates session metadata. Omitted fields are unchanged. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun update(sessionId: String): CompletableFuture<AgentSession> =
        update(sessionId, SessionUpdateParams.none())

    /** @see update */
    fun update(
        sessionId: String,
        params: SessionUpdateParams = SessionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSession> =
        update(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see update */
    fun update(
        sessionId: String,
        params: SessionUpdateParams = SessionUpdateParams.none(),
    ): CompletableFuture<AgentSession> = update(sessionId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SessionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSession>

    /** @see update */
    fun update(params: SessionUpdateParams): CompletableFuture<AgentSession> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(sessionId: String, requestOptions: RequestOptions): CompletableFuture<AgentSession> =
        update(sessionId, SessionUpdateParams.none(), requestOptions)

    /**
     * Lists managed agent sessions using ID-based pagination and the requested sort order. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun list(): CompletableFuture<SessionListPageAsync> = list(SessionListParams.none())

    /** @see list */
    fun list(
        params: SessionListParams = SessionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionListPageAsync>

    /** @see list */
    fun list(
        params: SessionListParams = SessionListParams.none()
    ): CompletableFuture<SessionListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<SessionListPageAsync> =
        list(SessionListParams.none(), requestOptions)

    /**
     * Removes a managed agent session from the public API and returns a deletion confirmation.
     * Physical cleanup may continue asynchronously. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun delete(sessionId: String): CompletableFuture<AgentSessionDeleted> =
        delete(sessionId, SessionDeleteParams.none())

    /** @see delete */
    fun delete(
        sessionId: String,
        params: SessionDeleteParams = SessionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSessionDeleted> =
        delete(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see delete */
    fun delete(
        sessionId: String,
        params: SessionDeleteParams = SessionDeleteParams.none(),
    ): CompletableFuture<AgentSessionDeleted> = delete(sessionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SessionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentSessionDeleted>

    /** @see delete */
    fun delete(params: SessionDeleteParams): CompletableFuture<AgentSessionDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AgentSessionDeleted> =
        delete(sessionId, SessionDeleteParams.none(), requestOptions)

    /**
     * A view of [SessionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SessionServiceAsync.WithRawResponse

        fun subagents(): SubagentServiceAsync.WithRawResponse

        fun artifacts(): ArtifactServiceAsync.WithRawResponse

        fun items(): ItemServiceAsync.WithRawResponse

        fun events(): EventServiceAsync.WithRawResponse

        fun turns(): TurnServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/sessions`, but is otherwise the same as
         * [SessionServiceAsync.create].
         */
        fun create(params: SessionCreateParams): CompletableFuture<HttpResponseFor<AgentSession>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>>

        /**
         * Returns a raw HTTP response for `post /agents/sessions`, but is otherwise the same as
         * [SessionServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: SessionCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: SessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}`, but is otherwise the
         * same as [SessionServiceAsync.retrieve].
         */
        fun retrieve(sessionId: String): CompletableFuture<HttpResponseFor<AgentSession>> =
            retrieve(sessionId, SessionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            sessionId: String,
            params: SessionRetrieveParams = SessionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            retrieve(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            sessionId: String,
            params: SessionRetrieveParams = SessionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            retrieve(sessionId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: SessionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>>

        /** @see retrieve */
        fun retrieve(
            params: SessionRetrieveParams
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            retrieve(sessionId, SessionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/sessions/{session_id}`, but is otherwise
         * the same as [SessionServiceAsync.update].
         */
        fun update(sessionId: String): CompletableFuture<HttpResponseFor<AgentSession>> =
            update(sessionId, SessionUpdateParams.none())

        /** @see update */
        fun update(
            sessionId: String,
            params: SessionUpdateParams = SessionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            update(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see update */
        fun update(
            sessionId: String,
            params: SessionUpdateParams = SessionUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            update(sessionId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SessionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSession>>

        /** @see update */
        fun update(params: SessionUpdateParams): CompletableFuture<HttpResponseFor<AgentSession>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AgentSession>> =
            update(sessionId, SessionUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/sessions`, but is otherwise the same as
         * [SessionServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<SessionListPageAsync>> =
            list(SessionListParams.none())

        /** @see list */
        fun list(
            params: SessionListParams = SessionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionListPageAsync>>

        /** @see list */
        fun list(
            params: SessionListParams = SessionListParams.none()
        ): CompletableFuture<HttpResponseFor<SessionListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SessionListPageAsync>> =
            list(SessionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /agents/sessions/{session_id}`, but is otherwise
         * the same as [SessionServiceAsync.delete].
         */
        fun delete(sessionId: String): CompletableFuture<HttpResponseFor<AgentSessionDeleted>> =
            delete(sessionId, SessionDeleteParams.none())

        /** @see delete */
        fun delete(
            sessionId: String,
            params: SessionDeleteParams = SessionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSessionDeleted>> =
            delete(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see delete */
        fun delete(
            sessionId: String,
            params: SessionDeleteParams = SessionDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AgentSessionDeleted>> =
            delete(sessionId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: SessionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentSessionDeleted>>

        /** @see delete */
        fun delete(
            params: SessionDeleteParams
        ): CompletableFuture<HttpResponseFor<AgentSessionDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AgentSessionDeleted>> =
            delete(sessionId, SessionDeleteParams.none(), requestOptions)
    }
}
