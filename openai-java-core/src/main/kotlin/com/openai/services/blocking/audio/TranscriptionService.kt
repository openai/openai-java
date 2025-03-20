// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse
import com.openai.models.audio.transcriptions.TranscriptionStreamEvent

interface TranscriptionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Transcribes audio into the input language. */
    fun create(params: TranscriptionCreateParams): TranscriptionCreateResponse =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TranscriptionCreateResponse

    /** Transcribes audio into the input language. */
    @MustBeClosed
    fun createStreaming(
        params: TranscriptionCreateParams
    ): StreamResponse<TranscriptionStreamEvent> = createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<TranscriptionStreamEvent>

    /**
     * A view of [TranscriptionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /audio/transcriptions`, but is otherwise the same
         * as [TranscriptionService.create].
         */
        @MustBeClosed
        fun create(
            params: TranscriptionCreateParams
        ): HttpResponseFor<TranscriptionCreateResponse> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TranscriptionCreateResponse>

        /**
         * Returns a raw HTTP response for `post /audio/transcriptions`, but is otherwise the same
         * as [TranscriptionService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: TranscriptionCreateParams
        ): HttpResponseFor<StreamResponse<TranscriptionStreamEvent>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<TranscriptionStreamEvent>>
    }
}
