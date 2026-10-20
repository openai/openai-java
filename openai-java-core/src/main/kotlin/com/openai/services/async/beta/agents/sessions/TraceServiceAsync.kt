// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.traces.TraceListPageAsync
import com.openai.models.beta.agents.sessions.traces.TraceListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TraceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceServiceAsync

    /**
     * Lists published root-turn traces as OTLP JSON, ordered by turn creation time and ID.
     * Unpublished traces are skipped. Each page returns data available when read; it does not wait
     * for late traces. Trace reads and the JSON response are limited to 16 MiB per request. If the
     * limit is exceeded, request fewer traces.
     */
    fun list(sessionId: String): CompletableFuture<TraceListPageAsync> =
        list(sessionId, TraceListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: TraceListParams = TraceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TraceListPageAsync> =
        list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: TraceListParams = TraceListParams.none(),
    ): CompletableFuture<TraceListPageAsync> = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TraceListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TraceListPageAsync>

    /** @see list */
    fun list(params: TraceListParams): CompletableFuture<TraceListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TraceListPageAsync> =
        list(sessionId, TraceListParams.none(), requestOptions)

    /** A view of [TraceServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TraceServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/traces`, but is
         * otherwise the same as [TraceServiceAsync.list].
         */
        fun list(sessionId: String): CompletableFuture<HttpResponseFor<TraceListPageAsync>> =
            list(sessionId, TraceListParams.none())

        /** @see list */
        fun list(
            sessionId: String,
            params: TraceListParams = TraceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TraceListPageAsync>> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        fun list(
            sessionId: String,
            params: TraceListParams = TraceListParams.none(),
        ): CompletableFuture<HttpResponseFor<TraceListPageAsync>> =
            list(sessionId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TraceListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TraceListPageAsync>>

        /** @see list */
        fun list(params: TraceListParams): CompletableFuture<HttpResponseFor<TraceListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TraceListPageAsync>> =
            list(sessionId, TraceListParams.none(), requestOptions)
    }
}
