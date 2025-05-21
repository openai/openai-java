// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageCreateParams
import com.openai.models.beta.threads.messages.MessageDeleteParams
import com.openai.models.beta.threads.messages.MessageDeleted
import com.openai.models.beta.threads.messages.MessageListPage
import com.openai.models.beta.threads.messages.MessageListParams
import com.openai.models.beta.threads.messages.MessageRetrieveParams
import com.openai.models.beta.threads.messages.MessageUpdateParams

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a message. */
    fun create(threadId: String, params: MessageCreateParams): Message =
        create(threadId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        threadId: String,
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = create(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see [create] */
    fun create(params: MessageCreateParams): Message = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Retrieve a message. */
    fun retrieve(messageId: String, params: MessageRetrieveParams): Message =
        retrieve(messageId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: MessageRetrieveParams): Message = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Modifies a message. */
    fun update(messageId: String, params: MessageUpdateParams): Message =
        update(messageId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        messageId: String,
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = update(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [update] */
    fun update(params: MessageUpdateParams): Message = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Returns a list of messages for a given thread. */
    fun list(threadId: String): MessageListPage = list(threadId, MessageListParams.none())

    /** @see [list] */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage = list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see [list] */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
    ): MessageListPage = list(threadId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** @see [list] */
    fun list(params: MessageListParams): MessageListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(threadId: String, requestOptions: RequestOptions): MessageListPage =
        list(threadId, MessageListParams.none(), requestOptions)

    /** Deletes a message. */
    fun delete(messageId: String, params: MessageDeleteParams): MessageDeleted =
        delete(messageId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        messageId: String,
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDeleted = delete(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [delete] */
    fun delete(params: MessageDeleteParams): MessageDeleted = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDeleted

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages`, but is otherwise
         * the same as [MessageService.create].
         */
        @MustBeClosed
        fun create(threadId: String, params: MessageCreateParams): HttpResponseFor<Message> =
            create(threadId, params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            threadId: String,
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            create(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see [create] */
        @MustBeClosed
        fun create(params: MessageCreateParams): HttpResponseFor<Message> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(messageId: String, params: MessageRetrieveParams): HttpResponseFor<Message> =
            retrieve(messageId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: MessageRetrieveParams): HttpResponseFor<Message> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.update].
         */
        @MustBeClosed
        fun update(messageId: String, params: MessageUpdateParams): HttpResponseFor<Message> =
            update(messageId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            messageId: String,
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            update(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(params: MessageUpdateParams): HttpResponseFor<Message> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageService.list].
         */
        @MustBeClosed
        fun list(threadId: String): HttpResponseFor<MessageListPage> =
            list(threadId, MessageListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
        ): HttpResponseFor<MessageListPage> = list(threadId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: MessageListParams): HttpResponseFor<MessageListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> =
            list(threadId, MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}/messages/{message_id}`, but
         * is otherwise the same as [MessageService.delete].
         */
        @MustBeClosed
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
        ): HttpResponseFor<MessageDeleted> = delete(messageId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDeleted> =
            delete(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: MessageDeleteParams): HttpResponseFor<MessageDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDeleted>
    }
}
