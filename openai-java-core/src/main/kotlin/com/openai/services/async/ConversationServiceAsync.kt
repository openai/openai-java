// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.conversations.Conversation
import com.openai.models.conversations.ConversationCreateParams
import com.openai.models.conversations.ConversationDeleteParams
import com.openai.models.conversations.ConversationDeletedResource
import com.openai.models.conversations.ConversationRetrieveParams
import com.openai.models.conversations.ConversationUpdateParams
import com.openai.services.async.conversations.ItemServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ConversationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ConversationServiceAsync

    fun items(): ItemServiceAsync

    /** Create a conversation with the given ID. */
    fun create(): CompletableFuture<Conversation> = create(ConversationCreateParams.none())

    /** @see create */
    fun create(
        params: ConversationCreateParams = ConversationCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation>

    /** @see create */
    fun create(
        params: ConversationCreateParams = ConversationCreateParams.none()
    ): CompletableFuture<Conversation> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<Conversation> =
        create(ConversationCreateParams.none(), requestOptions)

    /** Get a conversation with the given ID. */
    fun retrieve(conversationId: String): CompletableFuture<Conversation> =
        retrieve(conversationId, ConversationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        conversationId: String,
        params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation> =
        retrieve(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        conversationId: String,
        params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
    ): CompletableFuture<Conversation> = retrieve(conversationId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ConversationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation>

    /** @see retrieve */
    fun retrieve(params: ConversationRetrieveParams): CompletableFuture<Conversation> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        conversationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Conversation> =
        retrieve(conversationId, ConversationRetrieveParams.none(), requestOptions)

    /** Update a conversation's metadata with the given ID. */
    fun update(
        conversationId: String,
        params: ConversationUpdateParams,
    ): CompletableFuture<Conversation> = update(conversationId, params, RequestOptions.none())

    /** @see update */
    fun update(
        conversationId: String,
        params: ConversationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation> =
        update(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see update */
    fun update(params: ConversationUpdateParams): CompletableFuture<Conversation> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ConversationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation>

    /** Delete a conversation with the given ID. */
    fun delete(conversationId: String): CompletableFuture<ConversationDeletedResource> =
        delete(conversationId, ConversationDeleteParams.none())

    /** @see delete */
    fun delete(
        conversationId: String,
        params: ConversationDeleteParams = ConversationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationDeletedResource> =
        delete(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see delete */
    fun delete(
        conversationId: String,
        params: ConversationDeleteParams = ConversationDeleteParams.none(),
    ): CompletableFuture<ConversationDeletedResource> =
        delete(conversationId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ConversationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationDeletedResource>

    /** @see delete */
    fun delete(params: ConversationDeleteParams): CompletableFuture<ConversationDeletedResource> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        conversationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ConversationDeletedResource> =
        delete(conversationId, ConversationDeleteParams.none(), requestOptions)

    /**
     * A view of [ConversationServiceAsync] that provides access to raw HTTP responses for each
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
        ): ConversationServiceAsync.WithRawResponse

        fun items(): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /conversations`, but is otherwise the same as
         * [ConversationServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<Conversation>> =
            create(ConversationCreateParams.none())

        /** @see create */
        fun create(
            params: ConversationCreateParams = ConversationCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>>

        /** @see create */
        fun create(
            params: ConversationCreateParams = ConversationCreateParams.none()
        ): CompletableFuture<HttpResponseFor<Conversation>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            create(ConversationCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /conversations/{conversation_id}`, but is otherwise
         * the same as [ConversationServiceAsync.retrieve].
         */
        fun retrieve(conversationId: String): CompletableFuture<HttpResponseFor<Conversation>> =
            retrieve(conversationId, ConversationRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            conversationId: String,
            params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            retrieve(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            conversationId: String,
            params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            retrieve(conversationId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ConversationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>>

        /** @see retrieve */
        fun retrieve(
            params: ConversationRetrieveParams
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            conversationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            retrieve(conversationId, ConversationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /conversations/{conversation_id}`, but is otherwise
         * the same as [ConversationServiceAsync.update].
         */
        fun update(
            conversationId: String,
            params: ConversationUpdateParams,
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            update(conversationId, params, RequestOptions.none())

        /** @see update */
        fun update(
            conversationId: String,
            params: ConversationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            update(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see update */
        fun update(
            params: ConversationUpdateParams
        ): CompletableFuture<HttpResponseFor<Conversation>> = update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ConversationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>>

        /**
         * Returns a raw HTTP response for `delete /conversations/{conversation_id}`, but is
         * otherwise the same as [ConversationServiceAsync.delete].
         */
        fun delete(
            conversationId: String
        ): CompletableFuture<HttpResponseFor<ConversationDeletedResource>> =
            delete(conversationId, ConversationDeleteParams.none())

        /** @see delete */
        fun delete(
            conversationId: String,
            params: ConversationDeleteParams = ConversationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationDeletedResource>> =
            delete(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see delete */
        fun delete(
            conversationId: String,
            params: ConversationDeleteParams = ConversationDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ConversationDeletedResource>> =
            delete(conversationId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ConversationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationDeletedResource>>

        /** @see delete */
        fun delete(
            params: ConversationDeleteParams
        ): CompletableFuture<HttpResponseFor<ConversationDeletedResource>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            conversationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ConversationDeletedResource>> =
            delete(conversationId, ConversationDeleteParams.none(), requestOptions)
    }
}
