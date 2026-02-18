// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.chatkit

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.chatkit.sessions.SessionCancelParams
import com.openai.models.beta.chatkit.sessions.SessionCreateParams
import com.openai.models.beta.chatkit.threads.ChatSession
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

    /** Create a ChatKit session. */
    fun create(params: SessionCreateParams): CompletableFuture<ChatSession> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatSession>

    /**
     * Cancel an active ChatKit session and return its most recent metadata.
     *
     * Cancelling prevents new requests from using the issued client secret.
     */
    fun cancel(sessionId: String): CompletableFuture<ChatSession> =
        cancel(sessionId, SessionCancelParams.none())

    /** @see cancel */
    fun cancel(
        sessionId: String,
        params: SessionCancelParams = SessionCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatSession> =
        cancel(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        sessionId: String,
        params: SessionCancelParams = SessionCancelParams.none(),
    ): CompletableFuture<ChatSession> = cancel(sessionId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: SessionCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatSession>

    /** @see cancel */
    fun cancel(params: SessionCancelParams): CompletableFuture<ChatSession> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(sessionId: String, requestOptions: RequestOptions): CompletableFuture<ChatSession> =
        cancel(sessionId, SessionCancelParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `post /chatkit/sessions`, but is otherwise the same as
         * [SessionServiceAsync.create].
         */
        fun create(params: SessionCreateParams): CompletableFuture<HttpResponseFor<ChatSession>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatSession>>

        /**
         * Returns a raw HTTP response for `post /chatkit/sessions/{session_id}/cancel`, but is
         * otherwise the same as [SessionServiceAsync.cancel].
         */
        fun cancel(sessionId: String): CompletableFuture<HttpResponseFor<ChatSession>> =
            cancel(sessionId, SessionCancelParams.none())

        /** @see cancel */
        fun cancel(
            sessionId: String,
            params: SessionCancelParams = SessionCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatSession>> =
            cancel(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see cancel */
        fun cancel(
            sessionId: String,
            params: SessionCancelParams = SessionCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<ChatSession>> =
            cancel(sessionId, params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            params: SessionCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatSession>>

        /** @see cancel */
        fun cancel(params: SessionCancelParams): CompletableFuture<HttpResponseFor<ChatSession>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatSession>> =
            cancel(sessionId, SessionCancelParams.none(), requestOptions)
    }
}
