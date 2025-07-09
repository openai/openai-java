// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSession
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSessionCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TranscriptionSessionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranscriptionSessionServiceAsync

    /**
     * Create an ephemeral API token for use in client-side applications with the Realtime API
     * specifically for realtime transcriptions. Can be configured with the same session parameters
     * as the `transcription_session.update` client event.
     *
     * It responds with a session object, plus a `client_secret` key which contains a usable
     * ephemeral API token that can be used to authenticate browser clients for the Realtime API.
     */
    fun create(): CompletableFuture<TranscriptionSession> =
        create(TranscriptionSessionCreateParams.none())

    /** @see [create] */
    fun create(
        params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TranscriptionSession>

    /** @see [create] */
    fun create(
        params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none()
    ): CompletableFuture<TranscriptionSession> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): CompletableFuture<TranscriptionSession> =
        create(TranscriptionSessionCreateParams.none(), requestOptions)

    /**
     * A view of [TranscriptionSessionServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranscriptionSessionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /realtime/transcription_sessions`, but is otherwise
         * the same as [TranscriptionSessionServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<TranscriptionSession>> =
            create(TranscriptionSessionCreateParams.none())

        /** @see [create] */
        fun create(
            params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TranscriptionSession>>

        /** @see [create] */
        fun create(
            params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none()
        ): CompletableFuture<HttpResponseFor<TranscriptionSession>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TranscriptionSession>> =
            create(TranscriptionSessionCreateParams.none(), requestOptions)
    }
}
