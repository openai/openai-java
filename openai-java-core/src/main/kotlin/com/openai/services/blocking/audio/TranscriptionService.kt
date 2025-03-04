// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: AudioTranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudioTranscriptionCreateResponse>
    }
}
