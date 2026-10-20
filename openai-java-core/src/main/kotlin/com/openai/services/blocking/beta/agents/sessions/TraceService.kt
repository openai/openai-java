// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.traces.TraceListPage
import com.openai.models.beta.agents.sessions.traces.TraceListParams
import java.util.function.Consumer

interface TraceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceService

    /**
     * Lists published root-turn traces as OTLP JSON, ordered by turn creation time and ID.
     * Unpublished traces are skipped. Each page returns data available when read; it does not wait
     * for late traces. Trace reads and the JSON response are limited to 16 MiB per request. If the
     * limit is exceeded, request fewer traces.
     */
    fun list(sessionId: String): TraceListPage = list(sessionId, TraceListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: TraceListParams = TraceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TraceListPage = list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(sessionId: String, params: TraceListParams = TraceListParams.none()): TraceListPage =
        list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TraceListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TraceListPage

    /** @see list */
    fun list(params: TraceListParams): TraceListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(sessionId: String, requestOptions: RequestOptions): TraceListPage =
        list(sessionId, TraceListParams.none(), requestOptions)

    /** A view of [TraceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/traces`, but is
         * otherwise the same as [TraceService.list].
         */
        @MustBeClosed
        fun list(sessionId: String): HttpResponseFor<TraceListPage> =
            list(sessionId, TraceListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: TraceListParams = TraceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TraceListPage> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: TraceListParams = TraceListParams.none(),
        ): HttpResponseFor<TraceListPage> = list(sessionId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TraceListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TraceListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: TraceListParams): HttpResponseFor<TraceListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TraceListPage> = list(sessionId, TraceListParams.none(), requestOptions)
    }
}
