// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.chatkit

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.chatkit.sessions.SessionCancelParams
import com.openai.models.beta.chatkit.sessions.SessionCreateParams
import com.openai.models.beta.chatkit.threads.ChatSession
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

    /** Create a ChatKit session */
    fun create(params: SessionCreateParams): ChatSession = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatSession

    /** Cancel a ChatKit session */
    fun cancel(sessionId: String): ChatSession = cancel(sessionId, SessionCancelParams.none())

    /** @see cancel */
    fun cancel(
        sessionId: String,
        params: SessionCancelParams = SessionCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatSession = cancel(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        sessionId: String,
        params: SessionCancelParams = SessionCancelParams.none(),
    ): ChatSession = cancel(sessionId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: SessionCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatSession

    /** @see cancel */
    fun cancel(params: SessionCancelParams): ChatSession = cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(sessionId: String, requestOptions: RequestOptions): ChatSession =
        cancel(sessionId, SessionCancelParams.none(), requestOptions)

    /** A view of [SessionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chatkit/sessions`, but is otherwise the same as
         * [SessionService.create].
         */
        @MustBeClosed
        fun create(params: SessionCreateParams): HttpResponseFor<ChatSession> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatSession>

        /**
         * Returns a raw HTTP response for `post /chatkit/sessions/{session_id}/cancel`, but is
         * otherwise the same as [SessionService.cancel].
         */
        @MustBeClosed
        fun cancel(sessionId: String): HttpResponseFor<ChatSession> =
            cancel(sessionId, SessionCancelParams.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            sessionId: String,
            params: SessionCancelParams = SessionCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatSession> =
            cancel(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            sessionId: String,
            params: SessionCancelParams = SessionCancelParams.none(),
        ): HttpResponseFor<ChatSession> = cancel(sessionId, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: SessionCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatSession>

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: SessionCancelParams): HttpResponseFor<ChatSession> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatSession> =
            cancel(sessionId, SessionCancelParams.none(), requestOptions)
    }
}
