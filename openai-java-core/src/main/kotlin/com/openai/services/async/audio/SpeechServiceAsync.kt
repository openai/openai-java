// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.audio.speech.SpeechCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SpeechServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpeechServiceAsync

    /** Generates audio from the input text. */
    fun create(params: SpeechCreateParams): CompletableFuture<HttpResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: SpeechCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /**
     * A view of [SpeechServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpeechServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/speech`, but is otherwise the same as
         * [SpeechServiceAsync.create].
         */
        fun create(params: SpeechCreateParams): CompletableFuture<HttpResponse> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: SpeechCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
