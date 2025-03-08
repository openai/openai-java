// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.AudioSpeechCreateParams

interface SpeechService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Generates audio from the input text. */
    @MustBeClosed
    fun create(params: AudioSpeechCreateParams): HttpResponse =
        create(params, RequestOptions.none())

    /** @see [create] */
    @MustBeClosed
    fun create(
        params: AudioSpeechCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** A view of [SpeechService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /audio/speech`, but is otherwise the same as
         * [SpeechService.create].
         */
        @MustBeClosed
        fun create(params: AudioSpeechCreateParams): HttpResponse =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AudioSpeechCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
