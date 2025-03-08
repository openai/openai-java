// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionChunk
import com.openai.models.ChatCompletionCreateParams
import com.openai.models.ChatCompletionDeleteParams
import com.openai.models.ChatCompletionDeleted
import com.openai.models.ChatCompletionRetrieveParams
import com.openai.models.ChatCompletionUpdateParams
import com.openai.services.blocking.chat.completions.MessageService

interface CompletionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun messages(): MessageService

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
     * Get a stored chat completion. Only chat completions that have been created with the `store`
     * parameter set to `true` will be returned.
     */
    fun retrieve(params: ChatCompletionRetrieveParams): ChatCompletion =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Modify a stored chat completion. Only chat completions that have been created with the
     * `store` parameter set to `true` can be modified. Currently, the only supported modification
     * is to update the `metadata` field.
     */
    fun update(params: ChatCompletionUpdateParams): ChatCompletion =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Delete a stored chat completion. Only chat completions that have been created with the
     * `store` parameter set to `true` can be deleted.
     */
    fun delete(params: ChatCompletionDeleteParams): ChatCompletionDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletionDeleted

    /** A view of [CompletionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun messages(): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [CompletionService.create].
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
         * [CompletionService.createStreaming].
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

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}`, but is otherwise
         * the same as [CompletionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: ChatCompletionRetrieveParams): HttpResponseFor<ChatCompletion> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ChatCompletionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion>

        /**
         * Returns a raw HTTP response for `post /chat/completions/{completion_id}`, but is
         * otherwise the same as [CompletionService.update].
         */
        @MustBeClosed
        fun update(params: ChatCompletionUpdateParams): HttpResponseFor<ChatCompletion> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion>

        /**
         * Returns a raw HTTP response for `delete /chat/completions/{completion_id}`, but is
         * otherwise the same as [CompletionService.delete].
         */
        @MustBeClosed
        fun delete(params: ChatCompletionDeleteParams): HttpResponseFor<ChatCompletionDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ChatCompletionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletionDeleted>
    }
}
