// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageCreateParams
import com.openai.models.beta.threads.messages.MessageDeleteParams
import com.openai.models.beta.threads.messages.MessageDeleted
import com.openai.models.beta.threads.messages.MessageListPageAsync
import com.openai.models.beta.threads.messages.MessageListParams
import com.openai.models.beta.threads.messages.MessageRetrieveParams
import com.openai.models.beta.threads.messages.MessageUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync

    /** Create a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(threadId: String, params: MessageCreateParams): CompletableFuture<Message> =
        create(threadId, params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        threadId: String,
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        create(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(params: MessageCreateParams): CompletableFuture<Message> =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Retrieve a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(messageId: String, params: MessageRetrieveParams): CompletableFuture<Message> =
        retrieve(messageId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: MessageRetrieveParams): CompletableFuture<Message> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Modifies a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(messageId: String, params: MessageUpdateParams): CompletableFuture<Message> =
        update(messageId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        messageId: String,
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        update(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(params: MessageUpdateParams): CompletableFuture<Message> =
        update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Returns a list of messages for a given thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(threadId: String): CompletableFuture<MessageListPageAsync> =
        list(threadId, MessageListParams.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync> =
        list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
    ): CompletableFuture<MessageListPageAsync> = list(threadId, params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(params: MessageListParams): CompletableFuture<MessageListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListPageAsync> =
        list(threadId, MessageListParams.none(), requestOptions)

    /** Deletes a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(messageId: String, params: MessageDeleteParams): CompletableFuture<MessageDeleted> =
        delete(messageId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        messageId: String,
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDeleted> =
        delete(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(params: MessageDeleteParams): CompletableFuture<MessageDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDeleted>

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages`, but is otherwise
         * the same as [MessageServiceAsync.create].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            threadId: String,
            params: MessageCreateParams,
        ): CompletableFuture<HttpResponseFor<Message>> =
            create(threadId, params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            threadId: String,
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            create(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(params: MessageCreateParams): CompletableFuture<HttpResponseFor<Message>> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Message>> =
            retrieve(messageId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(params: MessageRetrieveParams): CompletableFuture<HttpResponseFor<Message>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.update].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            messageId: String,
            params: MessageUpdateParams,
        ): CompletableFuture<HttpResponseFor<Message>> =
            update(messageId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            messageId: String,
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            update(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(params: MessageUpdateParams): CompletableFuture<HttpResponseFor<Message>> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageServiceAsync.list].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(threadId: String): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, MessageListParams.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            params: MessageListParams
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}/messages/{message_id}`, but
         * is otherwise the same as [MessageServiceAsync.delete].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(messageId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            params: MessageDeleteParams
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDeleted>>
    }
}
