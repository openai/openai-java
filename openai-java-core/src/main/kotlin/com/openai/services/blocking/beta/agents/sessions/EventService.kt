// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.models.beta.agents.sessions.events.EventStreamParams
import java.util.function.Consumer

interface EventService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService

    /**
     * Submits message, cancellation, or tool-result events to a managed agent session. See
     * [session events](https://developers.openai.com/api/docs/guides/agents-api/sessions/events).
     */
    fun create(sessionId: String, params: EventCreateParams) =
        create(sessionId, params, RequestOptions.none())

    /** @see create */
    fun create(
        sessionId: String,
        params: EventCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = create(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see create */
    fun create(params: EventCreateParams) = create(params, RequestOptions.none())

    /** @see create */
    fun create(params: EventCreateParams, requestOptions: RequestOptions = RequestOptions.none())

    /**
     * Streams live events for an agent session. See
     * [session events](https://developers.openai.com/api/docs/guides/agents-api/sessions/events).
     */
    @MustBeClosed
    fun streamStreaming(sessionId: String): StreamResponse<AgentSessionEvent> =
        streamStreaming(sessionId, EventStreamParams.none())

    /** @see streamStreaming */
    @MustBeClosed
    fun streamStreaming(
        sessionId: String,
        params: EventStreamParams = EventStreamParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AgentSessionEvent> =
        streamStreaming(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see streamStreaming */
    @MustBeClosed
    fun streamStreaming(
        sessionId: String,
        params: EventStreamParams = EventStreamParams.none(),
    ): StreamResponse<AgentSessionEvent> = streamStreaming(sessionId, params, RequestOptions.none())

    /** @see streamStreaming */
    @MustBeClosed
    fun streamStreaming(
        params: EventStreamParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AgentSessionEvent>

    /** @see streamStreaming */
    @MustBeClosed
    fun streamStreaming(params: EventStreamParams): StreamResponse<AgentSessionEvent> =
        streamStreaming(params, RequestOptions.none())

    /** @see streamStreaming */
    @MustBeClosed
    fun streamStreaming(
        sessionId: String,
        requestOptions: RequestOptions,
    ): StreamResponse<AgentSessionEvent> =
        streamStreaming(sessionId, EventStreamParams.none(), requestOptions)

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/sessions/{session_id}/events`, but is
         * otherwise the same as [EventService.create].
         */
        @MustBeClosed
        fun create(sessionId: String, params: EventCreateParams): HttpResponse =
            create(sessionId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            sessionId: String,
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = create(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: EventCreateParams): HttpResponse = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/events`, but is
         * otherwise the same as [EventService.streamStreaming].
         */
        @MustBeClosed
        fun streamStreaming(sessionId: String): HttpResponseFor<StreamResponse<AgentSessionEvent>> =
            streamStreaming(sessionId, EventStreamParams.none())

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String,
            params: EventStreamParams = EventStreamParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>> =
            streamStreaming(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String,
            params: EventStreamParams = EventStreamParams.none(),
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>> =
            streamStreaming(sessionId, params, RequestOptions.none())

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            params: EventStreamParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>>

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            params: EventStreamParams
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>> =
            streamStreaming(params, RequestOptions.none())

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>> =
            streamStreaming(sessionId, EventStreamParams.none(), requestOptions)
    }
}
