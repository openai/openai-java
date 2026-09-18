// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.AgentSessionDeleted
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.beta.agents.sessions.SessionDeleteParams
import com.openai.models.beta.agents.sessions.SessionListPage
import com.openai.models.beta.agents.sessions.SessionListParams
import com.openai.models.beta.agents.sessions.SessionRetrieveParams
import com.openai.models.beta.agents.sessions.SessionUpdateParams
import com.openai.services.blocking.beta.agents.sessions.ArtifactService
import com.openai.services.blocking.beta.agents.sessions.EventService
import com.openai.services.blocking.beta.agents.sessions.ItemService
import com.openai.services.blocking.beta.agents.sessions.SubagentService
import com.openai.services.blocking.beta.agents.sessions.TurnService
import java.util.function.Consumer

interface SessionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService

    fun subagents(): SubagentService

    fun artifacts(): ArtifactService

    fun items(): ItemService

    fun events(): EventService

    fun turns(): TurnService

    /**
     * Creates a managed agent session, optionally submits initial input, and returns the session or
     * streams its events when stream is true. See
     * [running sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions).
     */
    fun create(params: SessionCreateParams): AgentSession = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSession

    /**
     * Creates a managed agent session, optionally submits initial input, and returns the session or
     * streams its events when stream is true. See
     * [running sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions).
     */
    @MustBeClosed
    fun createStreaming(params: SessionCreateParams): StreamResponse<AgentSessionEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    @MustBeClosed
    fun createStreaming(
        params: SessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AgentSessionEvent>

    /**
     * Retrieves the current state of a managed agent session. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun retrieve(sessionId: String): AgentSession =
        retrieve(sessionId, SessionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        sessionId: String,
        params: SessionRetrieveParams = SessionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSession = retrieve(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        sessionId: String,
        params: SessionRetrieveParams = SessionRetrieveParams.none(),
    ): AgentSession = retrieve(sessionId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SessionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSession

    /** @see retrieve */
    fun retrieve(params: SessionRetrieveParams): AgentSession =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(sessionId: String, requestOptions: RequestOptions): AgentSession =
        retrieve(sessionId, SessionRetrieveParams.none(), requestOptions)

    /**
     * Updates session metadata. Omitted fields are unchanged. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun update(sessionId: String): AgentSession = update(sessionId, SessionUpdateParams.none())

    /** @see update */
    fun update(
        sessionId: String,
        params: SessionUpdateParams = SessionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSession = update(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see update */
    fun update(
        sessionId: String,
        params: SessionUpdateParams = SessionUpdateParams.none(),
    ): AgentSession = update(sessionId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SessionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSession

    /** @see update */
    fun update(params: SessionUpdateParams): AgentSession = update(params, RequestOptions.none())

    /** @see update */
    fun update(sessionId: String, requestOptions: RequestOptions): AgentSession =
        update(sessionId, SessionUpdateParams.none(), requestOptions)

    /**
     * Lists managed agent sessions using ID-based pagination and the requested sort order. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun list(): SessionListPage = list(SessionListParams.none())

    /** @see list */
    fun list(
        params: SessionListParams = SessionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionListPage

    /** @see list */
    fun list(params: SessionListParams = SessionListParams.none()): SessionListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): SessionListPage =
        list(SessionListParams.none(), requestOptions)

    /**
     * Removes a managed agent session from the public API and returns a deletion confirmation.
     * Physical cleanup may continue asynchronously. See
     * [managing sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions/manage).
     */
    fun delete(sessionId: String): AgentSessionDeleted =
        delete(sessionId, SessionDeleteParams.none())

    /** @see delete */
    fun delete(
        sessionId: String,
        params: SessionDeleteParams = SessionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSessionDeleted = delete(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see delete */
    fun delete(
        sessionId: String,
        params: SessionDeleteParams = SessionDeleteParams.none(),
    ): AgentSessionDeleted = delete(sessionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SessionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentSessionDeleted

    /** @see delete */
    fun delete(params: SessionDeleteParams): AgentSessionDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(sessionId: String, requestOptions: RequestOptions): AgentSessionDeleted =
        delete(sessionId, SessionDeleteParams.none(), requestOptions)

    /** A view of [SessionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService.WithRawResponse

        fun subagents(): SubagentService.WithRawResponse

        fun artifacts(): ArtifactService.WithRawResponse

        fun items(): ItemService.WithRawResponse

        fun events(): EventService.WithRawResponse

        fun turns(): TurnService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/sessions`, but is otherwise the same as
         * [SessionService.create].
         */
        @MustBeClosed
        fun create(params: SessionCreateParams): HttpResponseFor<AgentSession> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSession>

        /**
         * Returns a raw HTTP response for `post /agents/sessions`, but is otherwise the same as
         * [SessionService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: SessionCreateParams
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>> =
            createStreaming(params, RequestOptions.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: SessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}`, but is otherwise the
         * same as [SessionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(sessionId: String): HttpResponseFor<AgentSession> =
            retrieve(sessionId, SessionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            sessionId: String,
            params: SessionRetrieveParams = SessionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSession> =
            retrieve(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            sessionId: String,
            params: SessionRetrieveParams = SessionRetrieveParams.none(),
        ): HttpResponseFor<AgentSession> = retrieve(sessionId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SessionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSession>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: SessionRetrieveParams): HttpResponseFor<AgentSession> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSession> =
            retrieve(sessionId, SessionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/sessions/{session_id}`, but is otherwise
         * the same as [SessionService.update].
         */
        @MustBeClosed
        fun update(sessionId: String): HttpResponseFor<AgentSession> =
            update(sessionId, SessionUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            sessionId: String,
            params: SessionUpdateParams = SessionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSession> =
            update(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            sessionId: String,
            params: SessionUpdateParams = SessionUpdateParams.none(),
        ): HttpResponseFor<AgentSession> = update(sessionId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SessionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSession>

        /** @see update */
        @MustBeClosed
        fun update(params: SessionUpdateParams): HttpResponseFor<AgentSession> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSession> =
            update(sessionId, SessionUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/sessions`, but is otherwise the same as
         * [SessionService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<SessionListPage> = list(SessionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SessionListParams = SessionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: SessionListParams = SessionListParams.none()
        ): HttpResponseFor<SessionListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<SessionListPage> =
            list(SessionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /agents/sessions/{session_id}`, but is otherwise
         * the same as [SessionService.delete].
         */
        @MustBeClosed
        fun delete(sessionId: String): HttpResponseFor<AgentSessionDeleted> =
            delete(sessionId, SessionDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            sessionId: String,
            params: SessionDeleteParams = SessionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSessionDeleted> =
            delete(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            sessionId: String,
            params: SessionDeleteParams = SessionDeleteParams.none(),
        ): HttpResponseFor<AgentSessionDeleted> = delete(sessionId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SessionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentSessionDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: SessionDeleteParams): HttpResponseFor<AgentSessionDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSessionDeleted> =
            delete(sessionId, SessionDeleteParams.none(), requestOptions)
    }
}
