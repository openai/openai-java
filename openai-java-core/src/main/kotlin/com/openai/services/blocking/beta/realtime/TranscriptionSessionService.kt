// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.realtime

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSession
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSessionCreateParams
import java.util.function.Consumer

interface TranscriptionSessionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranscriptionSessionService

    /**
     * Create an ephemeral API token for use in client-side applications with the Realtime API
     * specifically for realtime transcriptions. Can be configured with the same session parameters
     * as the `transcription_session.update` client event.
     *
     * It responds with a session object, plus a `client_secret` key which contains a usable
     * ephemeral API token that can be used to authenticate browser clients for the Realtime API.
     */
    fun create(): TranscriptionSession = create(TranscriptionSessionCreateParams.none())

    /** @see [create] */
    fun create(
        params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TranscriptionSession

    /** @see [create] */
    fun create(
        params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none()
    ): TranscriptionSession = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): TranscriptionSession =
        create(TranscriptionSessionCreateParams.none(), requestOptions)

    /**
     * A view of [TranscriptionSessionService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranscriptionSessionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /realtime/transcription_sessions`, but is otherwise
         * the same as [TranscriptionSessionService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<TranscriptionSession> =
            create(TranscriptionSessionCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TranscriptionSession>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: TranscriptionSessionCreateParams = TranscriptionSessionCreateParams.none()
        ): HttpResponseFor<TranscriptionSession> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<TranscriptionSession> =
            create(TranscriptionSessionCreateParams.none(), requestOptions)
    }
}
