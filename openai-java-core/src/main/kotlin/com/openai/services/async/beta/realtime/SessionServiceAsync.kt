// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.realtime.sessions.SessionCreateParams
import com.openai.models.beta.realtime.sessions.SessionCreateResponse
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

    /**
     * Create an ephemeral API token for use in client-side applications with the Realtime API. Can
     * be configured with the same session parameters as the `session.update` client event.
     *
     * It responds with a session object, plus a `client_secret` key which contains a usable
     * ephemeral API token that can be used to authenticate browser clients for the Realtime API.
     */
    fun create(): CompletableFuture<SessionCreateResponse> = create(SessionCreateParams.none())

    /** @see create */
    fun create(
        params: SessionCreateParams = SessionCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionCreateResponse>

    /** @see create */
    fun create(
        params: SessionCreateParams = SessionCreateParams.none()
    ): CompletableFuture<SessionCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<SessionCreateResponse> =
        create(SessionCreateParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `post /realtime/sessions`, but is otherwise the same as
         * [SessionServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<SessionCreateResponse>> =
            create(SessionCreateParams.none())

        /** @see create */
        fun create(
            params: SessionCreateParams = SessionCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionCreateResponse>>

        /** @see create */
        fun create(
            params: SessionCreateParams = SessionCreateParams.none()
        ): CompletableFuture<HttpResponseFor<SessionCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SessionCreateResponse>> =
            create(SessionCreateParams.none(), requestOptions)
    }
}
