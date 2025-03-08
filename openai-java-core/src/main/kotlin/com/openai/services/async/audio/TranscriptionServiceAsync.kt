// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.AudioTranscriptionCreateParams
import com.openai.models.AudioTranscriptionCreateResponse
import java.util.concurrent.CompletableFuture

interface TranscriptionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Transcribes audio into the input language. */
    fun create(
        params: AudioTranscriptionCreateParams
    ): CompletableFuture<AudioTranscriptionCreateResponse> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AudioTranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AudioTranscriptionCreateResponse>

    /**
     * A view of [TranscriptionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /audio/transcriptions`, but is otherwise the same
         * as [TranscriptionServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: AudioTranscriptionCreateParams
        ): CompletableFuture<HttpResponseFor<AudioTranscriptionCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AudioTranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AudioTranscriptionCreateResponse>>
    }
}
