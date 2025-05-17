// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.google.errorprone.annotations.MustBeClosed
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

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a message. */
    fun create(threadId: String, params: MessageCreateParams): CompletableFuture<Message> =
        create(threadId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        threadId: String,
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        create(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see [create] */
    fun create(params: MessageCreateParams): CompletableFuture<Message> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Retrieve a message. */
    fun retrieve(messageId: String, params: MessageRetrieveParams): CompletableFuture<Message> =
        retrieve(messageId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: MessageRetrieveParams): CompletableFuture<Message> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Modifies a message. */
    fun update(messageId: String, params: MessageUpdateParams): CompletableFuture<Message> =
        update(messageId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        messageId: String,
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        update(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [update] */
    fun update(params: MessageUpdateParams): CompletableFuture<Message> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Returns a list of messages for a given thread. */
    fun list(threadId: String): CompletableFuture<MessageListPageAsync> =
        list(threadId, MessageListParams.none())

    /** @see [list] */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync> =
        list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see [list] */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
    ): CompletableFuture<MessageListPageAsync> = list(threadId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** @see [list] */
    fun list(params: MessageListParams): CompletableFuture<MessageListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListPageAsync> =
        list(threadId, MessageListParams.none(), requestOptions)

    /** Deletes a message. */
    fun delete(messageId: String, params: MessageDeleteParams): CompletableFuture<MessageDeleted> =
        delete(messageId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        messageId: String,
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDeleted> =
        delete(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [delete] */
    fun delete(params: MessageDeleteParams): CompletableFuture<MessageDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDeleted>

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages`, but is otherwise
         * the same as [MessageServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            threadId: String,
            params: MessageCreateParams,
        ): CompletableFuture<HttpResponseFor<Message>> =
            create(threadId, params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            threadId: String,
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            create(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see [create] */
        @MustBeClosed
        fun create(params: MessageCreateParams): CompletableFuture<HttpResponseFor<Message>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Message>> =
            retrieve(messageId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: MessageRetrieveParams): CompletableFuture<HttpResponseFor<Message>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            messageId: String,
            params: MessageUpdateParams,
        ): CompletableFuture<HttpResponseFor<Message>> =
            update(messageId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            messageId: String,
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            update(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(params: MessageUpdateParams): CompletableFuture<HttpResponseFor<Message>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageServiceAsync.list].
         */
        @MustBeClosed
        fun list(threadId: String): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, MessageListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}/messages/{message_id}`, but
         * is otherwise the same as [MessageServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(messageId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: MessageDeleteParams
        ): CompletableFuture<HttpResponseFor<MessageDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDeleted>>
    }
}
