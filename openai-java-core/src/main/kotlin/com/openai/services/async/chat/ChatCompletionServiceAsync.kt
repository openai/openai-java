// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionDeleteParams
import com.openai.models.chat.completions.ChatCompletionDeleted
import com.openai.models.chat.completions.ChatCompletionListPageAsync
import com.openai.models.chat.completions.ChatCompletionListParams
import com.openai.models.chat.completions.ChatCompletionRetrieveParams
import com.openai.models.chat.completions.ChatCompletionUpdateParams
import com.openai.services.async.chat.completions.MessageServiceAsync
import java.util.concurrent.CompletableFuture

interface ChatCompletionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun messages(): MessageServiceAsync

    /**
     * **Starting a new project?** We recommend trying
     * [Responses](https://platform.openai.com/docs/api-reference/responses) to take advantage of
     * the latest OpenAI platform features. Compare
     * [Chat Completions with Responses](https://platform.openai.com/docs/guides/responses-vs-chat-completions?api-mode=responses).
     *
     * ---
     *
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
    fun create(params: ChatCompletionCreateParams): CompletableFuture<ChatCompletion> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion>

    /**
     * **Starting a new project?** We recommend trying
     * [Responses](https://platform.openai.com/docs/api-reference/responses) to take advantage of
     * the latest OpenAI platform features. Compare
     * [Chat Completions with Responses](https://platform.openai.com/docs/guides/responses-vs-chat-completions?api-mode=responses).
     *
     * ---
     *
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
    fun createStreaming(
        params: ChatCompletionCreateParams
    ): AsyncStreamResponse<ChatCompletionChunk> = createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ChatCompletionChunk>

    /**
     * Get a stored chat completion. Only Chat Completions that have been created with the `store`
     * parameter set to `true` will be returned.
     */
    fun retrieve(params: ChatCompletionRetrieveParams): CompletableFuture<ChatCompletion> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion>

    /**
     * Modify a stored chat completion. Only Chat Completions that have been created with the
     * `store` parameter set to `true` can be modified. Currently, the only supported modification
     * is to update the `metadata` field.
     */
    fun update(params: ChatCompletionUpdateParams): CompletableFuture<ChatCompletion> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion>

    /**
     * List stored Chat Completions. Only Chat Completions that have been stored with the `store`
     * parameter set to `true` will be returned.
     */
    fun list(): CompletableFuture<ChatCompletionListPageAsync> =
        list(ChatCompletionListParams.none())

    /** @see [list] */
    fun list(
        params: ChatCompletionListParams = ChatCompletionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionListPageAsync>

    /** @see [list] */
    fun list(
        params: ChatCompletionListParams = ChatCompletionListParams.none()
    ): CompletableFuture<ChatCompletionListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<ChatCompletionListPageAsync> =
        list(ChatCompletionListParams.none(), requestOptions)

    /**
     * Delete a stored chat completion. Only Chat Completions that have been created with the
     * `store` parameter set to `true` can be deleted.
     */
    fun delete(params: ChatCompletionDeleteParams): CompletableFuture<ChatCompletionDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionDeleted>

    /**
     * A view of [ChatCompletionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun messages(): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [ChatCompletionServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: ChatCompletionCreateParams
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>>

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [ChatCompletionServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: ChatCompletionCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<ChatCompletionChunk>>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ChatCompletionChunk>>>

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}`, but is otherwise
         * the same as [ChatCompletionServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: ChatCompletionRetrieveParams
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ChatCompletionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>>

        /**
         * Returns a raw HTTP response for `post /chat/completions/{completion_id}`, but is
         * otherwise the same as [ChatCompletionServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            params: ChatCompletionUpdateParams
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>>

        /**
         * Returns a raw HTTP response for `get /chat/completions`, but is otherwise the same as
         * [ChatCompletionServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> =
            list(ChatCompletionListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ChatCompletionListParams = ChatCompletionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ChatCompletionListParams = ChatCompletionListParams.none()
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> =
            list(ChatCompletionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /chat/completions/{completion_id}`, but is
         * otherwise the same as [ChatCompletionServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: ChatCompletionDeleteParams
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ChatCompletionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>>
    }
}
