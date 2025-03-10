// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.completions.Completion
import com.openai.models.completions.CompletionCreateParams
import java.util.concurrent.CompletableFuture

interface CompletionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates a completion for the provided prompt and parameters. */
    fun create(params: CompletionCreateParams): CompletableFuture<Completion> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Completion>

    /** Creates a completion for the provided prompt and parameters. */
    fun createStreaming(params: CompletionCreateParams): AsyncStreamResponse<Completion> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<Completion>

    /**
     * A view of [CompletionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /completions`, but is otherwise the same as
         * [CompletionServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: CompletionCreateParams): CompletableFuture<HttpResponseFor<Completion>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: CompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Completion>>

        /**
         * Returns a raw HTTP response for `post /completions`, but is otherwise the same as
         * [CompletionServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: CompletionCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<Completion>>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: CompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<Completion>>>
    }
}
