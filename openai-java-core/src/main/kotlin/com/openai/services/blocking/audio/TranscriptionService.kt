// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.AudioTranscriptionCreateParams
import com.openai.models.AudioTranscriptionCreateResponse

interface TranscriptionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Transcribes audio into the input language. */
    fun create(params: AudioTranscriptionCreateParams): AudioTranscriptionCreateResponse =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AudioTranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AudioTranscriptionCreateResponse

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
            params: AudioTranscriptionCreateParams
        ): HttpResponseFor<AudioTranscriptionCreateResponse> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AudioTranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudioTranscriptionCreateResponse>
    }
}
