// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
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
import com.openai.models.chat.completions.StructuredChatCompletion
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams
import com.openai.services.async.chat.completions.MessageServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ChatCompletionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatCompletionServiceAsync

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

    /** @see create */
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion>

    /**
     * Creates a model response for the given chat conversation. The model's structured output in
     * JSON form will be deserialized automatically into an instance of the class `T`. See the SDK
     * documentation for more details.
     *
     * @see create
     */
    fun <T : Any> create(
        params: StructuredChatCompletionCreateParams<T>
    ): CompletableFuture<StructuredChatCompletion<T>> = create(params, RequestOptions.none())

    /**
     * Creates a model response for the given chat conversation. The model's structured output in
     * JSON form will be deserialized automatically into an instance of the class `T`. See the SDK
     * documentation for more details.
     *
     * @see create
     */
    fun <T : Any> create(
        params: StructuredChatCompletionCreateParams<T>,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StructuredChatCompletion<T>> =
        create(params.rawParams, requestOptions).thenApply {
            StructuredChatCompletion<T>(params.responseType, it)
        }

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

    /** @see createStreaming */
    fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ChatCompletionChunk>

    /**
     * Creates a streaming model response for the given chat conversation. The input parameters can
     * define a JSON schema derived automatically from an arbitrary class to request a structured
     * output in JSON form. However, that structured output is split over multiple streamed events,
     * so it will not be deserialized automatically into an instance of that class. To deserialize
     * the output, first use a helper class to accumulate the stream of events into a single output
     * value. See the
     * [SDK documentation](https://github.com/openai/openai-java/#usage-with-streaming) for full
     * details.
     */
    fun createStreaming(
        params: StructuredChatCompletionCreateParams<*>
    ): AsyncStreamResponse<ChatCompletionChunk> = createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    fun createStreaming(
        params: StructuredChatCompletionCreateParams<*>,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ChatCompletionChunk> = createStreaming(params.rawParams, requestOptions)

    /**
     * Get a stored chat completion. Only Chat Completions that have been created with the `store`
     * parameter set to `true` will be returned.
     */
    fun retrieve(completionId: String): CompletableFuture<ChatCompletion> =
        retrieve(completionId, ChatCompletionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        completionId: String,
        params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion> =
        retrieve(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        completionId: String,
        params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
    ): CompletableFuture<ChatCompletion> = retrieve(completionId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion>

    /** @see retrieve */
    fun retrieve(params: ChatCompletionRetrieveParams): CompletableFuture<ChatCompletion> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        completionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletion> =
        retrieve(completionId, ChatCompletionRetrieveParams.none(), requestOptions)

    /**
     * Modify a stored chat completion. Only Chat Completions that have been created with the
     * `store` parameter set to `true` can be modified. Currently, the only supported modification
     * is to update the `metadata` field.
     */
    fun update(
        completionId: String,
        params: ChatCompletionUpdateParams,
    ): CompletableFuture<ChatCompletion> = update(completionId, params, RequestOptions.none())

    /** @see update */
    fun update(
        completionId: String,
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletion> =
        update(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see update */
    fun update(params: ChatCompletionUpdateParams): CompletableFuture<ChatCompletion> =
        update(params, RequestOptions.none())

    /** @see update */
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

    /** @see list */
    fun list(
        params: ChatCompletionListParams = ChatCompletionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionListPageAsync>

    /** @see list */
    fun list(
        params: ChatCompletionListParams = ChatCompletionListParams.none()
    ): CompletableFuture<ChatCompletionListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ChatCompletionListPageAsync> =
        list(ChatCompletionListParams.none(), requestOptions)

    /**
     * Delete a stored chat completion. Only Chat Completions that have been created with the
     * `store` parameter set to `true` can be deleted.
     */
    fun delete(completionId: String): CompletableFuture<ChatCompletionDeleted> =
        delete(completionId, ChatCompletionDeleteParams.none())

    /** @see delete */
    fun delete(
        completionId: String,
        params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionDeleted> =
        delete(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see delete */
    fun delete(
        completionId: String,
        params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
    ): CompletableFuture<ChatCompletionDeleted> =
        delete(completionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionDeleted>

    /** @see delete */
    fun delete(params: ChatCompletionDeleteParams): CompletableFuture<ChatCompletionDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        completionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletionDeleted> =
        delete(completionId, ChatCompletionDeleteParams.none(), requestOptions)

    /**
     * A view of [ChatCompletionServiceAsync] that provides access to raw HTTP responses for each
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
        ): ChatCompletionServiceAsync.WithRawResponse

        fun messages(): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [ChatCompletionServiceAsync.create].
         */
        fun create(
            params: ChatCompletionCreateParams
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            create(params, RequestOptions.none())

        /** @see create */
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

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ChatCompletionChunk>>>

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}`, but is otherwise
         * the same as [ChatCompletionServiceAsync.retrieve].
         */
        fun retrieve(completionId: String): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            retrieve(completionId, ChatCompletionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            completionId: String,
            params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            retrieve(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            completionId: String,
            params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            retrieve(completionId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ChatCompletionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>>

        /** @see retrieve */
        fun retrieve(
            params: ChatCompletionRetrieveParams
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            completionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            retrieve(completionId, ChatCompletionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /chat/completions/{completion_id}`, but is
         * otherwise the same as [ChatCompletionServiceAsync.update].
         */
        fun update(
            completionId: String,
            params: ChatCompletionUpdateParams,
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            update(completionId, params, RequestOptions.none())

        /** @see update */
        fun update(
            completionId: String,
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            update(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see update */
        fun update(
            params: ChatCompletionUpdateParams
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletion>>

        /**
         * Returns a raw HTTP response for `get /chat/completions`, but is otherwise the same as
         * [ChatCompletionServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> =
            list(ChatCompletionListParams.none())

        /** @see list */
        fun list(
            params: ChatCompletionListParams = ChatCompletionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>>

        /** @see list */
        fun list(
            params: ChatCompletionListParams = ChatCompletionListParams.none()
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> =
            list(ChatCompletionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /chat/completions/{completion_id}`, but is
         * otherwise the same as [ChatCompletionServiceAsync.delete].
         */
        fun delete(
            completionId: String
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> =
            delete(completionId, ChatCompletionDeleteParams.none())

        /** @see delete */
        fun delete(
            completionId: String,
            params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> =
            delete(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see delete */
        fun delete(
            completionId: String,
            params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> =
            delete(completionId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ChatCompletionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>>

        /** @see delete */
        fun delete(
            params: ChatCompletionDeleteParams
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            completionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> =
            delete(completionId, ChatCompletionDeleteParams.none(), requestOptions)
    }
}
