// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.models.beta.agents.sessions.events.EventStreamParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EventServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventServiceAsync

    /**
     * Submits message, cancellation, or tool-result events to a managed agent session. See
     * [session events](https://developers.openai.com/api/docs/guides/agents-api/sessions/events).
     */
    fun create(sessionId: String, params: EventCreateParams): CompletableFuture<Void?> =
        create(sessionId, params, RequestOptions.none())

    /** @see create */
    fun create(
        sessionId: String,
        params: EventCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        create(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see create */
    fun create(params: EventCreateParams): CompletableFuture<Void?> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EventCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * Streams live events for an agent session. See
     * [session events](https://developers.openai.com/api/docs/guides/agents-api/sessions/events).
     */
    fun streamStreaming(sessionId: String): AsyncStreamResponse<AgentSessionEvent> =
        streamStreaming(sessionId, EventStreamParams.none())

    /** @see streamStreaming */
    fun streamStreaming(
        sessionId: String,
        params: EventStreamParams = EventStreamParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AgentSessionEvent> =
        streamStreaming(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see streamStreaming */
    fun streamStreaming(
        sessionId: String,
        params: EventStreamParams = EventStreamParams.none(),
    ): AsyncStreamResponse<AgentSessionEvent> =
        streamStreaming(sessionId, params, RequestOptions.none())

    /** @see streamStreaming */
    fun streamStreaming(
        params: EventStreamParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AgentSessionEvent>

    /** @see streamStreaming */
    fun streamStreaming(params: EventStreamParams): AsyncStreamResponse<AgentSessionEvent> =
        streamStreaming(params, RequestOptions.none())

    /** @see streamStreaming */
    fun streamStreaming(
        sessionId: String,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<AgentSessionEvent> =
        streamStreaming(sessionId, EventStreamParams.none(), requestOptions)

    /** A view of [EventServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/sessions/{session_id}/events`, but is
         * otherwise the same as [EventServiceAsync.create].
         */
        fun create(sessionId: String, params: EventCreateParams): CompletableFuture<HttpResponse> =
            create(sessionId, params, RequestOptions.none())

        /** @see create */
        fun create(
            sessionId: String,
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            create(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see create */
        fun create(params: EventCreateParams): CompletableFuture<HttpResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/events`, but is
         * otherwise the same as [EventServiceAsync.streamStreaming].
         */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>> =
            streamStreaming(sessionId, EventStreamParams.none())

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String,
            params: EventStreamParams = EventStreamParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>> =
            streamStreaming(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String,
            params: EventStreamParams = EventStreamParams.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>> =
            streamStreaming(sessionId, params, RequestOptions.none())

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            params: EventStreamParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>>

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            params: EventStreamParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>> =
            streamStreaming(params, RequestOptions.none())

        /** @see streamStreaming */
        @MustBeClosed
        fun streamStreaming(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<AgentSessionEvent>>> =
            streamStreaming(sessionId, EventStreamParams.none(), requestOptions)
    }
}
