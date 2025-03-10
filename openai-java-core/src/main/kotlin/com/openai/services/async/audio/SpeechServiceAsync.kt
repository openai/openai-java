// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.audio.speech.SpeechCreateParams
import java.util.concurrent.CompletableFuture

interface SpeechServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Generates audio from the input text. */
    @MustBeClosed
    fun create(params: SpeechCreateParams): CompletableFuture<HttpResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    @MustBeClosed
    fun create(
        params: SpeechCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /**
     * A view of [SpeechServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /audio/speech`, but is otherwise the same as
         * [SpeechServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: SpeechCreateParams): CompletableFuture<HttpResponse> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: SpeechCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
