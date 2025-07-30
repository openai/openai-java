// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
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
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService

    /** Create a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(threadId: String, params: MessageCreateParams): Message =
        create(threadId, params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        threadId: String,
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = create(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(params: MessageCreateParams): Message = create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        params: MessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Retrieve a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(messageId: String, params: MessageRetrieveParams): Message =
        retrieve(messageId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: MessageRetrieveParams): Message = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Modifies a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(messageId: String, params: MessageUpdateParams): Message =
        update(messageId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        messageId: String,
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = update(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(params: MessageUpdateParams): Message = update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        params: MessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Returns a list of messages for a given thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(threadId: String): MessageListPage = list(threadId, MessageListParams.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage = list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
    ): MessageListPage = list(threadId, params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(params: MessageListParams): MessageListPage = list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(threadId: String, requestOptions: RequestOptions): MessageListPage =
        list(threadId, MessageListParams.none(), requestOptions)

    /** Deletes a message. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(messageId: String, params: MessageDeleteParams): MessageDeleted =
        delete(messageId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        messageId: String,
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDeleted = delete(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(params: MessageDeleteParams): MessageDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        params: MessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDeleted

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages`, but is otherwise
         * the same as [MessageService.create].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(threadId: String, params: MessageCreateParams): HttpResponseFor<Message> =
            create(threadId, params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(
            threadId: String,
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            create(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(params: MessageCreateParams): HttpResponseFor<Message> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(messageId: String, params: MessageRetrieveParams): HttpResponseFor<Message> =
            retrieve(messageId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(params: MessageRetrieveParams): HttpResponseFor<Message> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/messages/{message_id}`, but is
         * otherwise the same as [MessageService.update].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(messageId: String, params: MessageUpdateParams): HttpResponseFor<Message> =
            update(messageId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(
            messageId: String,
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            update(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(params: MessageUpdateParams): HttpResponseFor<Message> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(
            params: MessageUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/messages`, but is otherwise the
         * same as [MessageService.list].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(threadId: String): HttpResponseFor<MessageListPage> =
            list(threadId, MessageListParams.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
        ): HttpResponseFor<MessageListPage> = list(threadId, params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(params: MessageListParams): HttpResponseFor<MessageListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
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
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
        ): HttpResponseFor<MessageDeleted> = delete(messageId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            messageId: String,
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDeleted> =
            delete(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(params: MessageDeleteParams): HttpResponseFor<MessageDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            params: MessageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDeleted>
    }
}
