// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionDeleteParams
import com.openai.models.chat.completions.ChatCompletionDeleted
import com.openai.models.chat.completions.ChatCompletionListPage
import com.openai.models.chat.completions.ChatCompletionListParams
import com.openai.models.chat.completions.ChatCompletionRetrieveParams
import com.openai.models.chat.completions.ChatCompletionUpdateParams
import com.openai.models.chat.completions.StructuredChatCompletion
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams
import com.openai.services.blocking.chat.completions.MessageService
import java.util.function.Consumer

interface ChatCompletionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatCompletionService

    fun messages(): MessageService

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
     *
     * Returns a chat completion object, or a streamed sequence of chat completion chunk objects if
     * the request is streamed.
     */
    fun create(params: ChatCompletionCreateParams): ChatCompletion =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Creates a model response for the given chat conversation. The model's structured output in
     * JSON form will be deserialized automatically into an instance of the class `T`. See the SDK
     * documentation for more details.
     *
     * @see create
     */
    fun <T : Any> create(
        params: StructuredChatCompletionCreateParams<T>
    ): StructuredChatCompletion<T> = create(params, RequestOptions.none())

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
    ): StructuredChatCompletion<T> =
        StructuredChatCompletion<T>(params.responseType, create(params.rawParams, requestOptions))

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
     *
     * Returns a chat completion object, or a streamed sequence of chat completion chunk objects if
     * the request is streamed.
     */
    @MustBeClosed
    fun createStreaming(params: ChatCompletionCreateParams): StreamResponse<ChatCompletionChunk> =
        createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    @MustBeClosed
    fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ChatCompletionChunk>

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
    @MustBeClosed
    fun createStreaming(
        params: StructuredChatCompletionCreateParams<*>
    ): StreamResponse<ChatCompletionChunk> = createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: StructuredChatCompletionCreateParams<*>,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ChatCompletionChunk> = createStreaming(params.rawParams, requestOptions)

    /**
     * Get a stored chat completion. Only Chat Completions that have been created with the `store`
     * parameter set to `true` will be returned.
     */
    fun retrieve(completionId: String): ChatCompletion =
        retrieve(completionId, ChatCompletionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        completionId: String,
        params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion =
        retrieve(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        completionId: String,
        params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
    ): ChatCompletion = retrieve(completionId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /** @see retrieve */
    fun retrieve(params: ChatCompletionRetrieveParams): ChatCompletion =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(completionId: String, requestOptions: RequestOptions): ChatCompletion =
        retrieve(completionId, ChatCompletionRetrieveParams.none(), requestOptions)

    /**
     * Modify a stored chat completion. Only Chat Completions that have been created with the
     * `store` parameter set to `true` can be modified. Currently, the only supported modification
     * is to update the `metadata` field.
     */
    fun update(completionId: String, params: ChatCompletionUpdateParams): ChatCompletion =
        update(completionId, params, RequestOptions.none())

    /** @see update */
    fun update(
        completionId: String,
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion =
        update(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see update */
    fun update(params: ChatCompletionUpdateParams): ChatCompletion =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * List stored Chat Completions. Only Chat Completions that have been stored with the `store`
     * parameter set to `true` will be returned.
     */
    fun list(): ChatCompletionListPage = list(ChatCompletionListParams.none())

    /** @see list */
    fun list(
        params: ChatCompletionListParams = ChatCompletionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletionListPage

    /** @see list */
    fun list(
        params: ChatCompletionListParams = ChatCompletionListParams.none()
    ): ChatCompletionListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ChatCompletionListPage =
        list(ChatCompletionListParams.none(), requestOptions)

    /**
     * Delete a stored chat completion. Only Chat Completions that have been created with the
     * `store` parameter set to `true` can be deleted.
     */
    fun delete(completionId: String): ChatCompletionDeleted =
        delete(completionId, ChatCompletionDeleteParams.none())

    /** @see delete */
    fun delete(
        completionId: String,
        params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletionDeleted =
        delete(params.toBuilder().completionId(completionId).build(), requestOptions)

    /** @see delete */
    fun delete(
        completionId: String,
        params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
    ): ChatCompletionDeleted = delete(completionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletionDeleted

    /** @see delete */
    fun delete(params: ChatCompletionDeleteParams): ChatCompletionDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(completionId: String, requestOptions: RequestOptions): ChatCompletionDeleted =
        delete(completionId, ChatCompletionDeleteParams.none(), requestOptions)

    /**
     * A view of [ChatCompletionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatCompletionService.WithRawResponse

        fun messages(): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chat/completions`, but is otherwise the same as
         * [ChatCompletionService.create].
         */
        @MustBeClosed
        fun create(params: ChatCompletionCreateParams): HttpResponseFor<ChatCompletion> =
            create(params, RequestOptions.none())

        /** @see create */
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

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<ChatCompletionChunk>>

        /**
         * Returns a raw HTTP response for `get /chat/completions/{completion_id}`, but is otherwise
         * the same as [ChatCompletionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(completionId: String): HttpResponseFor<ChatCompletion> =
            retrieve(completionId, ChatCompletionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            completionId: String,
            params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion> =
            retrieve(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            completionId: String,
            params: ChatCompletionRetrieveParams = ChatCompletionRetrieveParams.none(),
        ): HttpResponseFor<ChatCompletion> = retrieve(completionId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ChatCompletionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ChatCompletionRetrieveParams): HttpResponseFor<ChatCompletion> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            completionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatCompletion> =
            retrieve(completionId, ChatCompletionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /chat/completions/{completion_id}`, but is
         * otherwise the same as [ChatCompletionService.update].
         */
        @MustBeClosed
        fun update(
            completionId: String,
            params: ChatCompletionUpdateParams,
        ): HttpResponseFor<ChatCompletion> = update(completionId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            completionId: String,
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion> =
            update(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: ChatCompletionUpdateParams): HttpResponseFor<ChatCompletion> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletion>

        /**
         * Returns a raw HTTP response for `get /chat/completions`, but is otherwise the same as
         * [ChatCompletionService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ChatCompletionListPage> = list(ChatCompletionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ChatCompletionListParams = ChatCompletionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletionListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ChatCompletionListParams = ChatCompletionListParams.none()
        ): HttpResponseFor<ChatCompletionListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ChatCompletionListPage> =
            list(ChatCompletionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /chat/completions/{completion_id}`, but is
         * otherwise the same as [ChatCompletionService.delete].
         */
        @MustBeClosed
        fun delete(completionId: String): HttpResponseFor<ChatCompletionDeleted> =
            delete(completionId, ChatCompletionDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            completionId: String,
            params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletionDeleted> =
            delete(params.toBuilder().completionId(completionId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            completionId: String,
            params: ChatCompletionDeleteParams = ChatCompletionDeleteParams.none(),
        ): HttpResponseFor<ChatCompletionDeleted> =
            delete(completionId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ChatCompletionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatCompletionDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ChatCompletionDeleteParams): HttpResponseFor<ChatCompletionDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            completionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatCompletionDeleted> =
            delete(completionId, ChatCompletionDeleteParams.none(), requestOptions)
    }
}
