// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.Completion
import com.openai.models.CompletionCreateParams

interface CompletionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates a completion for the provided prompt and parameters. */
    fun create(params: CompletionCreateParams): Completion = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Completion

    /** Creates a completion for the provided prompt and parameters. */
    @MustBeClosed
    fun createStreaming(params: CompletionCreateParams): StreamResponse<Completion> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<Completion>

    /** A view of [CompletionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /completions`, but is otherwise the same as
         * [CompletionService.create].
         */
        @MustBeClosed
        fun create(params: CompletionCreateParams): HttpResponseFor<Completion> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: CompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Completion>

        /**
         * Returns a raw HTTP response for `post /completions`, but is otherwise the same as
         * [CompletionService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: CompletionCreateParams
        ): HttpResponseFor<StreamResponse<Completion>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: CompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<Completion>>
    }
}
