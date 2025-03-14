// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams

interface ChatCompletionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     *
     * Parameter support can differ depending on the model used to generate the response,
     * particularly for newer reasoning models. Parameters that are only supported for reasoning
     * models are noted below. For the current state of unsupported parameters in reasoning models,
     * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
     */
    fun create(params: ChatCompletionCreateParams): ChatCompletion =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     *
     * Parameter support can differ depending on the model used to generate the response,
     * particularly for newer reasoning models. Parameters that are only supported for reasoning
     * models are noted below. For the current state of unsupported parameters in reasoning models,
     * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
     */
    @MustBeClosed
    fun createStreaming(params: ChatCompletionCreateParams): StreamResponse<ChatCompletionChunk> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ChatCompletionChunk>

    /**
     * A view of [ChatCompletionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [ChatCompletionService.create].
         */
        @MustBeClosed
        fun create(params: ChatCompletionCreateParams): HttpResponseFor<ChatCompletion> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion>

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [ChatCompletionService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: ChatCompletionCreateParams
        ): HttpResponseFor<StreamResponse<ChatCompletionChunk>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<ChatCompletionChunk>>
    }
}
