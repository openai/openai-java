// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse
import com.openai.models.audio.transcriptions.TranscriptionStreamEvent
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TranscriptionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranscriptionServiceAsync

    /** Transcribes audio into the input language. */
    fun create(params: TranscriptionCreateParams): CompletableFuture<TranscriptionCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TranscriptionCreateResponse>

    /** Transcribes audio into the input language. */
    fun createStreaming(
        params: TranscriptionCreateParams
    ): AsyncStreamResponse<TranscriptionStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    fun createStreaming(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<TranscriptionStreamEvent>

    /**
     * A view of [TranscriptionServiceAsync] that provides access to raw HTTP responses for each
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
        ): TranscriptionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/transcriptions`, but is otherwise the same
         * as [TranscriptionServiceAsync.create].
         */
        fun create(
            params: TranscriptionCreateParams
        ): CompletableFuture<HttpResponseFor<TranscriptionCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TranscriptionCreateResponse>>

        /**
         * Returns a raw HTTP response for `post /audio/transcriptions`, but is otherwise the same
         * as [TranscriptionServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: TranscriptionCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<TranscriptionStreamEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<TranscriptionStreamEvent>>>
    }
}
