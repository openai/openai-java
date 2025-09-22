// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.conversations.Conversation
import com.openai.models.conversations.ConversationCreateParams
import com.openai.models.conversations.ConversationDeleteParams
import com.openai.models.conversations.ConversationDeletedResource
import com.openai.models.conversations.ConversationRetrieveParams
import com.openai.models.conversations.ConversationUpdateParams
import com.openai.services.blocking.conversations.ItemService
import java.util.function.Consumer

interface ConversationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ConversationService

    fun items(): ItemService

    /** Create a conversation. */
    fun create(): Conversation = create(ConversationCreateParams.none())

    /** @see create */
    fun create(
        params: ConversationCreateParams = ConversationCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation

    /** @see create */
    fun create(params: ConversationCreateParams = ConversationCreateParams.none()): Conversation =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): Conversation =
        create(ConversationCreateParams.none(), requestOptions)

    /** Get a conversation */
    fun retrieve(conversationId: String): Conversation =
        retrieve(conversationId, ConversationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        conversationId: String,
        params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation =
        retrieve(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        conversationId: String,
        params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
    ): Conversation = retrieve(conversationId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ConversationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation

    /** @see retrieve */
    fun retrieve(params: ConversationRetrieveParams): Conversation =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(conversationId: String, requestOptions: RequestOptions): Conversation =
        retrieve(conversationId, ConversationRetrieveParams.none(), requestOptions)

    /** Update a conversation */
    fun update(conversationId: String, params: ConversationUpdateParams): Conversation =
        update(conversationId, params, RequestOptions.none())

    /** @see update */
    fun update(
        conversationId: String,
        params: ConversationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation =
        update(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see update */
    fun update(params: ConversationUpdateParams): Conversation =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ConversationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation

    /** Delete a conversation. Items in the conversation will not be deleted. */
    fun delete(conversationId: String): ConversationDeletedResource =
        delete(conversationId, ConversationDeleteParams.none())

    /** @see delete */
    fun delete(
        conversationId: String,
        params: ConversationDeleteParams = ConversationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationDeletedResource =
        delete(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see delete */
    fun delete(
        conversationId: String,
        params: ConversationDeleteParams = ConversationDeleteParams.none(),
    ): ConversationDeletedResource = delete(conversationId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ConversationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationDeletedResource

    /** @see delete */
    fun delete(params: ConversationDeleteParams): ConversationDeletedResource =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        conversationId: String,
        requestOptions: RequestOptions,
    ): ConversationDeletedResource =
        delete(conversationId, ConversationDeleteParams.none(), requestOptions)

    /**
     * A view of [ConversationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ConversationService.WithRawResponse

        fun items(): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /conversations`, but is otherwise the same as
         * [ConversationService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<Conversation> = create(ConversationCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ConversationCreateParams = ConversationCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ConversationCreateParams = ConversationCreateParams.none()
        ): HttpResponseFor<Conversation> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Conversation> =
            create(ConversationCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /conversations/{conversation_id}`, but is otherwise
         * the same as [ConversationService.retrieve].
         */
        @MustBeClosed
        fun retrieve(conversationId: String): HttpResponseFor<Conversation> =
            retrieve(conversationId, ConversationRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            conversationId: String,
            params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation> =
            retrieve(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            conversationId: String,
            params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
        ): HttpResponseFor<Conversation> = retrieve(conversationId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ConversationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ConversationRetrieveParams): HttpResponseFor<Conversation> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            conversationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Conversation> =
            retrieve(conversationId, ConversationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /conversations/{conversation_id}`, but is otherwise
         * the same as [ConversationService.update].
         */
        @MustBeClosed
        fun update(
            conversationId: String,
            params: ConversationUpdateParams,
        ): HttpResponseFor<Conversation> = update(conversationId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            conversationId: String,
            params: ConversationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation> =
            update(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: ConversationUpdateParams): HttpResponseFor<Conversation> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ConversationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation>

        /**
         * Returns a raw HTTP response for `delete /conversations/{conversation_id}`, but is
         * otherwise the same as [ConversationService.delete].
         */
        @MustBeClosed
        fun delete(conversationId: String): HttpResponseFor<ConversationDeletedResource> =
            delete(conversationId, ConversationDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            conversationId: String,
            params: ConversationDeleteParams = ConversationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationDeletedResource> =
            delete(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            conversationId: String,
            params: ConversationDeleteParams = ConversationDeleteParams.none(),
        ): HttpResponseFor<ConversationDeletedResource> =
            delete(conversationId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ConversationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationDeletedResource>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ConversationDeleteParams): HttpResponseFor<ConversationDeletedResource> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            conversationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationDeletedResource> =
            delete(conversationId, ConversationDeleteParams.none(), requestOptions)
    }
}
